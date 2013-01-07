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

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class provides methods for creating well formed query URL.
 * 
 * @author Mirko Polato
 *
 */
public final class IMDbURLCreator {
	
	//region Utilities
	
	/**
	 * Forms a pair 'property=value'.
	 * 
	 * @param prop The property
	 * @param value The value
	 * @return The string 'prop=value'
	 */
	private static String pair(String prop, String value) {
		return prop + "=" + value;
	}
	
	/**
	 * Adds to the head of the given string a "&".
	 * 
	 * @param par The string
	 * @return The string with "&" symbol as first character
	 */
	private static String param(String par) {
		return "&" + par;
	}
	
	//endregion

	//region Search by ID
	
	/**
	 * Returns the URL that searches for movie by id.
	 * 
	 * @param pars The list of parameters
	 * @return The query URL
	 * @throws MalformedURLException Throws if the URL has an invalid form
	 */
	public static URL searchMovieByIdUrl(IMDbSearchByIdParameters pars) throws MalformedURLException {
		return new URL(IMDbConstants.BASE_URL + 
					   pair(IMDbConstants.ID, pars.getMovieID()) + 
					   param(pair(IMDbConstants.PLOT, pars.getPlot().getValue())) + 
					   param(pair(IMDbConstants.EPISODE, (pars.isEpisode()) ? "1" : "0")) +
					   param(pair(IMDbConstants.AKA, pars.getAka().getValue())) + 
					   param(pair(IMDbConstants.RELEASE, pars.getRelease().getValue())));
	}
	
	//endregion
	
	//region Search by title
	
	/**
	 * Returns the URL that searches for movies by title.
	 * 
	 * @param pars The list of parameters
	 * @return The query URL
	 * @throws MalformedURLException Throws if the URL has an invalid form
	 */
	public static URL searchMovieByTitleUrl(IMDbSearchByTitleParameters pars) throws MalformedURLException {
		String year = "";
		
		if (pars.isYearSet()) {
			year = param(pair(IMDbConstants.YEAR_ENABLED, "1")) + 
				   param(pair(IMDbConstants.YEAR, pars.getYear().toString()));
		}
		
		return new URL(IMDbConstants.BASE_URL + 
					   pair(IMDbConstants.TITLE, pars.getTitle()) + 
					   param(pair(IMDbConstants.PLOT, pars.getPlot().getValue())) + 
					   param(pair(IMDbConstants.EPISODE, (pars.isEpisode()) ? "1" : "0")) +
					   param(pair(IMDbConstants.AKA, pars.getAka().getValue())) + 
					   param(pair(IMDbConstants.RELEASE, pars.getRelease().getValue())) + 
					   year +
					   param(pair(IMDbConstants.MOVIE_TYPE, pars.getType().getValue())) + 
					   param(pair(IMDbConstants.OFFSET, pars.getOffset().toString())) + 
					   param(pair(IMDbConstants.LIMIT, pars.getLimit().toString())));
	}
	
	//endregion
	
}
