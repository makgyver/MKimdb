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

package mk.imdb.response;

/**
 * Enumeration with the possible response status codes.
 * 
 * @author Mirko Polato
 *
 */
public enum IMDbStatus {

	/**
	 * Code 0: None.
	 */
	NONE (0, "None."),
	
	/**
	 * Code 404: Film not found.
	 */
	MOVIE_NOT_FOUND (404, "Film not found."),
	
	/**
	 * Code 501: Parameter was invalid.
	 */
	INVALID_PARAMETER (501, "Parameter was invalid."),
	
	/**
	 * Code 98: Malformed URL.
	 */
	MALFORMED_URL(98, "Malformed url."),
	
	/**
	 * Code 99: Request Timeout. Retry in a few minutes.
	 */
	TIMEOUT(99, "Request Timeout. Retry in a few minutes."),
	
	/**
	 * Code 100: Unknown error. See the log for more information.
	 */
	UNKNOWN_ERROR(100, "Unknown error. See the log for more information.");
	
	/**
	 * The status code.
	 */
	private int code = 0;
	
	/**
	 * The status string.
	 */
	private String status = "";
	
	/**
	 * Gets the status value.
	 * 
	 * @return The status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Gets the status code.
	 * 
	 * @return The status code
	 */
	public int getCode() {
		return code;
	}
	
	/**
	 * Creates a new enumeration item with the specified code and message.
	 * 
	 * @param code The status code
	 * @param status The status value
	 */
	private IMDbStatus(int code, String status) {
		this.code = code;
		this.status = status;
	}
	
	/**
	 * Gets the status identified by the given code.
	 * 
	 * @param code The status code
	 * @return The status
	 */
	public static IMDbStatus getStatusByCode(int code) {
	    
	    for (IMDbStatus s : values()) {
	    	if (s.getCode() == code) return s;
	    }
	    
	    return IMDbStatus.UNKNOWN_ERROR;
	}
	
}
