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

/**
 * Class that represents the list of parameters for a search by id API call.
 * 
 * @author Mirko Polato
 *
 */
public class IMDbSearchByIdParameters extends IMDbParameters {

	/**
	 * The movie ID
	 */
	private String movieID = null;

	/**
	 * Creates a new instance of IMDbSearchByIdParameters.
	 * 
	 * @param movieID The movie ID
	 */
	public IMDbSearchByIdParameters(String movieID) {
		this.movieID = movieID;
	}
	
	/**
	 * Gets the movie ID.
	 * 
	 * @return The movie ID
	 */
	public String getMovieID() {
		return movieID;
	}

	/**
	 * Sets the movie ID.
	 * 
	 * @param movieID The new movie ID
	 */
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}

}
