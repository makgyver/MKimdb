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

package mk.imdb.entity;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import mk.imdb.core.IMDbAPI;
import mk.imdb.core.IMDbConstants;
import mk.imdb.core.IMDbSearchByIdParameters;
import mk.imdb.core.IMDbSearchByTitleParameters;
import mk.imdb.exception.IMDbResponseException;
import mk.imdb.response.IMDbResponseArray;
import mk.imdb.response.IMDbResponseObject;
import mk.imdb.utils.Log;
import mk.imdb.utils.Pair;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Class that represents a Movie.
 * 
 * @author Mirko Polato
 *
 */
public class IMDbMovie extends IMDbEntity {

	//region Fields
	
	/**
	 * The movie rating.
	 */
	private double rating;
	
	/**
	 * The movie MPAA rating.
	 */
	private String mpaa;
	
	/**
	 * The movie location
	 */
	private String location;
	
	/**
	 * The movie title.
	 */
	private String title;
	
	/**
	 * The movie poster.
	 */
	private URL poster;
	
	/**
	 * The imdb.com movie link.
	 */
	private URL link;
	
	/**
	 * The movie plot.
	 */
	private String plot;
	
	/**
	 * The movie IMDb (imdb.com) ID.
	 */
	private String id;
	
	/**
	 * The movie vote count.
	 */
	private Integer count;
	
	/**
	 * The movie type.
	 */
	private IMDbMovieType type;
	
	/**
	 * The movie cast.
	 */
	private List<String> actors = Collections.synchronizedList(new LinkedList<String>());
	
	/**
	 * The movie countries.
	 */
	private List<String> countries = Collections.synchronizedList(new LinkedList<String>());
	
	/**
	 * The movie directors.
	 */
	private List<String> directors = Collections.synchronizedList(new LinkedList<String>());
	
	/**
	 * The movie genres.
	 */
	private List<String> genres = Collections.synchronizedList(new LinkedList<String>());
	
	/**
	 * The movie languages.
	 */
	private List<String> langs = Collections.synchronizedList(new LinkedList<String>());
	
	/**
	 * The movie writers.
	 */
	private List<String> writers = Collections.synchronizedList(new LinkedList<String>());
	
	/**
	 * The movie runtimes.
	 */
	private List<Integer> runtimes = Collections.synchronizedList(new LinkedList<Integer>());
	
	/**
	 * The movie aliases (aka: also known as).
	 */
	private List<Pair<String, String>> akas = Collections.synchronizedList(new LinkedList<Pair<String, String>>());
	
	/**
	 * The movie release dates.
	 */
	private List<Pair<String, Date>> releases = Collections.synchronizedList(new LinkedList<Pair<String, Date>>());
	
	//endregion
	
	/**
	 * Creates a new instance of IMDbMovie based on the origin JSON object.
	 *  
	 * @param json The origin JSON object
	 */
	public IMDbMovie(JSONObject json) {
		super(json);
		parseJSON(json);
	}

	//region Getters/Setters
	
	/**
	 * Gets the movie rating.
	 * 
	 * @return The movie rating
	 */
	public double getRating() {
		return rating;
	}
	
	/**
	 * Sets the movie rating.
	 * 
	 * @param rating The new movie rating
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	/**
	 * Gets the MPAA rating of the movie.
	 * 
	 * @return The MPAA rating
	 */
	public String getMPAARating() {
		return mpaa;
	}
	
	/**
	 * Sets the MPAA rating of the movie.
	 * 
	 * @param mpaa The new MPAA rating
	 */
	public void setMPAARating(String mpaa) {
		this.mpaa = mpaa;
	}
	
	/**
	 * Gets the movie location.
	 * 
	 * @return The movie location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets the movie location.
	 * 
	 * @param location The new movie location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Gets the movie title.
	 * 
	 * @return The movie title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the movie title.
	 * 
	 * @param title The movie title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the movie poster.
	 * 
	 * @return The movie poster
	 */
	public URL getPoster() {
		return poster;
	}
	
	/**
	 * Sets the movie poster.
	 * 
	 * @param poster The new movie poster
	 */
	public void setPoster(URL poster) {
		this.poster = poster;
	}
	
	/**
	 * Gets the movie imdb.com link.
	 * 
	 * @return The movie link
	 */
	public URL getLink() {
		return link;
	}
	
	/**
	 * Sets the movie imdb.com link.
	 * 
	 * @param link The new movie link
	 */
	public void setLink(URL link) {
		this.link = link;
	}
	
	/**
	 * Gets the movie plot.
	 * 
	 * @return The movie plot
	 */
	public String getPlot() {
		return plot;
	}
	
	/**
	 * Sets the movie plot.
	 * 
	 * @param plot The new movie plot
	 */
	public void setPlot(String plot) {
		this.plot = plot;
	}
	
	/**
	 * Gets the movie IMDb ID.
	 * 
	 * @return The new movie ID
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the movie IMDb ID.
	 * 
	 * @param id The new movie ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the movie vote count.
	 * 
	 * @return The movie vote count
	 */
	public Integer getCount() {
		return count;
	}
	
	/**
	 * Sets the movie vote count.
	 * 
	 * @param count The new movie vote count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	
	/**
	 * Gets the movie type.
	 * 
	 * @return The movie type
	 */
	public IMDbMovieType getType() {
		return type;
	}

	/**
	 * Sets the movie type.
	 * 
	 * @param type The new movie type
	 */
	public void setType(IMDbMovieType type) {
		this.type = type;
	}

	/**
	 * Gets the movie cast.
	 * 
	 * @return The movie cast.
	 */
	public List<String> getActors() {
		return actors;
	}
	
	/**
	 * Sets the movie cast.
	 * 
	 * @param actors The new movie cast
	 */
	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	
	/**
	 * Gets the movie countries.
	 * 
	 * @return The movie countries
	 */
	public List<String> getCountries() {
		return countries;
	}
	
	/**
	 * Sets the movie countries.
	 * 
	 * @param countries The new movie countries
	 */
	public void setCountries(List<String> countries) {
		this.countries = countries;
	}
	
	/**
	 * Gets the movie directors.
	 * 
	 * @return The movie directors
	 */
	public List<String> getDirectors() {
		return directors;
	}
	
	/**
	 * Sets the movie directors.
	 * 
	 * @param directors The new movie directors
	 */
	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}
	
	/**
	 * Gets the movie genres.
	 * 
	 * @return The movie genres
	 */
	public List<String> getGenres() {
		return genres;
	}
	
	/**
	 * Sets the movie genres.
	 * 
	 * @param genres The new movie genres
	 */
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	
	/**
	 * Gets the movie languages.
	 * 
	 * @return The movie languages
	 */
	public List<String> getLanguages() {
		return langs;
	}
	
	/**
	 * Sets the movie languages.
	 * 
	 * @param langs The new movie languages
	 */
	public void setLanguages(List<String> langs) {
		this.langs = langs;
	}
	
	/**
	 * Gets the movie writers.
	 * 
	 * @return The movie writers
	 */
	public List<String> getWriters() {
		return writers;
	}
	
	/**
	 * Sets the movie writers.
	 * 
	 * @param writers The new mvovie writers
	 */
	public void setWriters(List<String> writers) {
		this.writers = writers;
	}
	
	/**
	 * Gets the movie runtimes.
	 * 
	 * @return The movie runtimes
	 */
	public List<Integer> getRuntimes() {
		return runtimes;
	}
	
	/**
	 * Sets the movie runtimes.
	 * 
	 * @param runtimes The new movie runtimes
	 */
	public void setRuntimes(List<Integer> runtimes) {
		this.runtimes = runtimes;
	}
	
	/**
	 * Gets the movie aliases.
	 * 
	 * @return The movie aliases.
	 * 
	 */
	public List<Pair<String, String>> getAKA() {
		return akas;
	}
	
	/**
	 * Sets the movie aliases.
	 * 
	 * @param akas The new movie aliases
	 */
	public void setAKA(List<Pair<String, String>> akas) {
		this.akas = akas;
	}
	
	/**
	 * Gets the movie release dates.
	 * 
	 * @return The movie release dates
	 */
	public List<Pair<String, Date>> getReleases() {
		return releases;
	}
	
	/**
	 * Sets the movie release dates.
	 * 
	 * @param releases The new movie release dates
	 */
	public void setReleases(List<Pair<String, Date>> releases) {
		this.releases = releases;
	}
	
	/**
	 * Gets the movie year (US release).
	 * 
	 * @return The movie year.
	 */
	public int getYear() {
		return getYear("USA");
	}
	
	/**
	 * Gets the movie year.
	 * 
	 * @param country The release country name
	 * @return The movie year
	 */
	public int getYear(String country) {
		int year = 1900;
		
		SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
		for (Pair<String, Date> release : releases) {
			if (release.getFirst().equals(country)) {
				year = Integer.valueOf(formatNowYear.format(release.getSecond()));
				break;
			}
		}
		
		return year;
	}
	
	//endregion
	
	/**
	 * Parses the origin JSON object.
	 * 
	 * @param json The origin JSON object
	 */
	private void parseJSON(JSONObject json) {
		
		if (json.has(IMDbConstants.IMDB_ID)) setId(json.getString(IMDbConstants.IMDB_ID));
		if (json.has(IMDbConstants.RATING)) setRating(json.getDouble(IMDbConstants.RATING));
		if (json.has(IMDbConstants.RATING_COUNT)) setCount(json.getInt(IMDbConstants.RATING_COUNT));
		if (json.has(IMDbConstants.RATED)) setMPAARating(json.getString(IMDbConstants.RATED));
		if (json.has(IMDbConstants.LOCATIONS)) setLocation(json.getString(IMDbConstants.LOCATIONS));
		if (json.has(IMDbConstants.TYPE)) setType(IMDbMovieType.getTypeByName(json.getString(IMDbConstants.TYPE)));
		if (json.has(IMDbConstants.TITLE)) setTitle(json.getString(IMDbConstants.TITLE));
		
		if (json.has(IMDbConstants.PLOT)) {
			setPlot(json.getString(IMDbConstants.PLOT));
		} else if (json.has(IMDbConstants.PLOT_SIMPLE)) {
			setPlot(json.getString(IMDbConstants.PLOT_SIMPLE));
		}
		
		if (json.has(IMDbConstants.IMDB_URL)) {
			try {
				setLink(new URL(json.getString(IMDbConstants.IMDB_URL)));
			} catch (MalformedURLException e) {
				Log.print(e);
			}
		}
		
		if (json.has(IMDbConstants.POSTER)) {
			try {
				setPoster(new URL(json.getString(IMDbConstants.POSTER)));
			} catch (MalformedURLException e) {
				Log.print(e);
			}
		}
		
		if (json.has(IMDbConstants.GENRES)) {
			JSONArray array = json.getJSONArray(IMDbConstants.GENRES);
			
			for (Object obj : array) {
				genres.add((String) obj);
			}
		}
		
		if (json.has(IMDbConstants.LANGUAGE)) {
			JSONArray array = json.getJSONArray(IMDbConstants.LANGUAGE);
			
			for (Object obj : array) {
				langs.add((String) obj);
			}
		}
		
		if (json.has(IMDbConstants.WRITERS)) {
			JSONArray array = json.getJSONArray(IMDbConstants.WRITERS);
			
			for (Object obj : array) {
				writers.add((String) obj);
			}
		}
		
		if (json.has(IMDbConstants.DIRECTORS)) {
			JSONArray array = json.getJSONArray(IMDbConstants.DIRECTORS);
			
			for (Object obj : array) {
				directors.add((String) obj);
			}
		}
		
		if (json.has(IMDbConstants.ACTORS)) {
			JSONArray array = json.getJSONArray(IMDbConstants.ACTORS);
			
			for (Object obj : array) {
				actors.add((String) obj);
			}
		}
		
		if (json.has(IMDbConstants.COUNTRY)) {
			JSONArray array = json.getJSONArray(IMDbConstants.COUNTRY);
			
			for (Object obj : array) {
				countries.add((String) obj);
			}
		}
		
		if (json.has(IMDbConstants.RUNTIME)) {
			JSONArray array = json.getJSONArray(IMDbConstants.RUNTIME);
			
			for (Object obj : array) {
				String[] words = ((String) obj).split(" ");
				try {
					runtimes.add(Integer.parseInt(words[0]));
				} catch (Exception ex) {
					Log.print(ex);
				}
			}
		}
		
		if (json.has(IMDbConstants.ALSO_KNOWN_AS)) {
			
			JSONArray array = json.getJSONArray(IMDbConstants.ALSO_KNOWN_AS);
			
			try {
				
				for (Object obj : array) {
					JSONObject jobj = (JSONObject) obj;
					akas.add(new Pair<String, String>(jobj.getString(IMDbConstants.COUNTRY), jobj.getString(IMDbConstants.TITLE)));
				}

			} catch (Exception ex) {
				Log.print(ex);
				
				for (Object obj : array) {
					akas.add(new Pair<String, String>("USA", (String)obj));
					break;
				}
			}
		}
		
		if (json.has(IMDbConstants.RELEASE_DATE)) {
			
			try {
			
				JSONArray array = json.getJSONArray(IMDbConstants.RELEASE_DATE);
				
				for (Object obj : array) {
					JSONObject jobj = (JSONObject) obj;
					
					Calendar cal = GregorianCalendar.getInstance();
					cal.set(jobj.getInt(IMDbConstants.YEAR), 
							jobj.getInt(IMDbConstants.MONTH), 
							jobj.getInt(IMDbConstants.DAY));
					
					Date date = cal.getTime();
					
					releases.add(new Pair<String, Date>(jobj.getString(IMDbConstants.COUNTRY), date));
				}
			
			} catch (Exception ex) {
				
				Log.print(ex);
				
				String release = json.getString(IMDbConstants.RELEASE_DATE);
				DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
				try {
					releases.add(new Pair<String, Date>("USA", (Date)formatter.parse(release)));
				} catch (ParseException e) {
					Log.print(e);
				}
			}
		}
	}
	
	//region Search
	
	/**
	 * Searches for movie by id.
	 * 
	 * @param params The list of parameters
	 * @return The movie
	 * @throws IMDbResponseException Throws whether the server response is not a success.
	 */
	public static IMDbMovie searchById(IMDbSearchByIdParameters params) throws IMDbResponseException {
		
		IMDbResponseObject response = IMDbAPI.searchMovieById(params);
		
		if (response.hasError()) {
			throw new IMDbResponseException(response.getStatus());
		} else {
			return new IMDbMovie(response.getData());
		}
	}
	
	/**
	 * Searches for movies by title.
	 * 
	 * @param params The list of parameters
	 * @return The movie
	 * @throws IMDbResponseException Throws whether the server response is not a success.
	 */
	public static List<IMDbMovie> searchByTitle(IMDbSearchByTitleParameters params) throws IMDbResponseException {
		
		IMDbResponseArray response = IMDbAPI.searchMovieByTitle(params);
		
		if (response.hasError()) {
			throw new IMDbResponseException(response.getStatus());
		} else {
			
			List<IMDbMovie> movies = new LinkedList<IMDbMovie>();
			for (JSONObject json : response.getData()) {
				movies.add(new IMDbMovie(json));
			}
			return movies;
		}
	}
	
	/**
	 * Searches for movies by title. Gets all the results.
	 * 
	 * @param params The list of parameters (Limit and Offset parameters will be ignored)
	 * @return The movie
	 * @throws IMDbResponseException Throws whether the server response is not a success.
	 */
	public static List<IMDbMovie> fullSearchByTitle(IMDbSearchByTitleParameters params) throws IMDbResponseException {
		
		IMDbResponseArray response = IMDbAPI.fullSearchMovieByTitle(params);
		
		if (response.hasError()) {
			throw new IMDbResponseException(response.getStatus());
		} else {
			
			List<IMDbMovie> movies = new LinkedList<IMDbMovie>();
			for (JSONObject json : response.getData()) {
				movies.add(new IMDbMovie(json));
			}
			return movies;
		}
	}
	
	//endregion
}
