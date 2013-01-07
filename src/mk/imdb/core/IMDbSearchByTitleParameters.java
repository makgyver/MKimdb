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

import mk.imdb.entity.IMDbMovieType;

/**
 * Class that represents the list of parameters for a search by title API call.
 * 
 * @author Mirko Polato
 *
 */
public class IMDbSearchByTitleParameters extends IMDbParameters {

	//region Fields
	
	/**
	 * The movie title.
	 */
	private String title = null;
	
	/**
	 * The movie year.
	 */
	private Integer year = null;
	
	/**
	 * The movie type.
	 */
	private IMDbMovieType type = IMDbMovieType.NONE;
	
	/**
	 * The offset from where the search starts.
	 */
	private Integer offset = 0;
	
	/**
	 * The maximum number of the results.
	 */
	private Integer limit = 1;
	
	//endregion
	
	/**
	 * Creates a new instance of IMDbSearchByTitleParameters.
	 * 
	 * @param title The movie title
	 */
	public IMDbSearchByTitleParameters(String title) {
		this.title = title;
	}
	
	//region Getters/Setters
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public boolean isYearSet() {
		return year != null;
	}
	
	public IMDbMovieType getType() {
		return type;
	}
	
	public void setType(IMDbMovieType type) {
		this.type = type;
	}
	
	public Integer getOffset() {
		return offset;
	}
	
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
	public Integer getLimit() {
		return limit;
	}
	
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	//endregion
	
}
