/*******************************************************************************
 * Copyright (C) 2013  Mirko Polato
 * 
 * This file is part of MKimdb.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 ******************************************************************************/

package mk.imdb.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

import mk.imdb.response.IMDbResponseArray;
import mk.imdb.response.IMDbResponseObject;
import mk.imdb.response.IMDbStatus;
import mk.imdb.utils.Log;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Static class that offers methods for calling the imdbapi.org API.
 * 
 * @author Mirko Polato
 *
 */
public final class IMDbAPI {

	//region Timeout
	
	/**
	 * Timeout in milliseconds.
	 */
	private static int timeout = 20000; // 20 seconds
	
	/**
	 * Sets the timeout to the given value (milliseconds).
	 * @param limit The timeout in milliseconds.
	 */
	public static void setTimeout(int limit) {
		if (limit < 0) limit = 0;
		timeout = limit;
	}
	
	//endregion

	//region Utilities
	
	/**
	 * Makes an HTTP request (GET) and gets back the result as a string.
	 * 
	 * @param url The query URL
	 * @return The result string
	 */
	public static String makeApiCallGet(URL url) {
		StringBuilder result = new StringBuilder();
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setReadTimeout(timeout);
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			for (String line = null; (line = reader.readLine()) != null;) {
			    result.append(line).append("\n");
			}
			reader.close();
			
		} catch (SocketTimeoutException ste) {
			Log.print(ste);
			
			JSONObject json = new JSONObject();
			json.put(IMDbConstants.STATUS_CODE, IMDbStatus.TIMEOUT);
			
			result.setLength(0);
			result.append(json.toString());
			
		} catch (Exception e) {
			Log.print(e);
			
			JSONObject json = new JSONObject();
			json.put(IMDbConstants.STATUS_CODE, IMDbStatus.UNKNOWN_ERROR.getCode());
			
			result.setLength(0);
			result.append(json.toString());
		}
		
		return result.toString();
	}

	/**
	 * Converts a string to a JSONObject.
	 * 
	 * @param strJson The JSON string
	 * @return The JSONObject
	 */
	private static JSONObject toJSON(String strJson) {
		return (JSONObject) JSONSerializer.toJSON(strJson);
	}
	
	//endregion

	//region Search
	
	/**
	 * Searches for movie by ID.
	 * 
	 * @param params The list of parameters
	 * @return The IMDb API (imdbapi.org) response object.
	 */
	public static IMDbResponseObject searchMovieById(IMDbSearchByIdParameters params) {
		try {
			return new IMDbResponseObject(toJSON(makeApiCallGet(IMDbURLCreator.searchMovieByIdUrl(params))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new IMDbResponseObject(IMDbStatus.MALFORMED_URL);
		}
	}
	
	/**
	 * Searches for movies by title.
	 * 
	 * @param params The list of parameters
	 * @return The IMDb API (imdbapi.org) response object.
	 */
	public static IMDbResponseArray searchMovieByTitle(IMDbSearchByTitleParameters params) {
		try {
			return new IMDbResponseArray(toJSON(makeApiCallGet(IMDbURLCreator.searchMovieByTitleUrl(params))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new IMDbResponseArray(IMDbStatus.MALFORMED_URL);
		}
	}
	
	/**
	 * Searches for movies by title. Gets all the results.
	 * 
	 * @param params The list of parameters (Limit and Offset parameters will be ignored).
	 * @return The IMDb API (imdbapi.org) response object.
	 */
	public static IMDbResponseArray fullSearchMovieByTitle(IMDbSearchByTitleParameters params) {
		try {
			
			params.setLimit(5);
			params.setOffset(0);
			
			IMDbResponseArray result = new IMDbResponseArray(toJSON(makeApiCallGet(IMDbURLCreator.searchMovieByTitleUrl(params))));
			
			for (int p = 1; p * 5 < result.getResults(); p++) {
				params.setOffset(p * 5);
				IMDbResponseArray page = new IMDbResponseArray(toJSON(makeApiCallGet(IMDbURLCreator.searchMovieByTitleUrl(params))));
				for (Object obj : page.getData()) {
					result.addData((JSONObject) obj);
				}
			}
			
			return result;
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new IMDbResponseArray(IMDbStatus.MALFORMED_URL);
		}
	}
	
	//endregion
	
}
