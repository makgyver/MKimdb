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

/**
 * Enumeration with the possible movie types.
 * 
 * @author Mirko Polato
 * 
 */
public enum IMDbMovieType {

	/**
	 * None.
	 */
	NONE("none"),
	
	/**
	 * Movie.
	 */
	MOVIE("M"),
	
	/**
	 * TV Movie.
	 */
	TV_MOVIE("TV"),
	
	/**
	 * TV Series.
	 */
	TV_SERIES("TVS"),
	
	/**
	 * Video.
	 */
	VIDEO("V"),
	
	/**
	 * Video game.
	 */
	VIDEO_GAME("VG");
	
	/**
	 * The type value.
	 */
	private String value = "";
	
	/**
	 * Gets the type value.
	 * 
	 * @return The type value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Creates a new enumeration item with the specified type.
	 * 
	 * @param type The type value
	 */
	private IMDbMovieType(String type) {
		this.value = type;
	}
	
	/**
	 * Gets the type identified by the given name.
	 * 
	 * @param name The type name
	 * @return The type
	 */
	public static IMDbMovieType getTypeByName(String name) {
	    
	    for (IMDbMovieType s : values()) {
	    	if (s.getValue().equals(name)) return s;
	    }
	    
	    return IMDbMovieType.NONE;
	}
	
}
