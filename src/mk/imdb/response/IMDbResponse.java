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

import mk.imdb.core.IMDbConstants;
import net.sf.json.JSONObject;

public abstract class IMDbResponse {

	/**
	 * The response status (default sets to NONE)
	 */
	protected IMDbStatus status = IMDbStatus.NONE;
	
	/**
	 * Initializes the response basic information based on the given JSON object.
	 *  
	 * @param json The JSON response
	 */
	public IMDbResponse(JSONObject json) {
		if (json.has(IMDbConstants.STATUS_CODE)) setStatus(IMDbStatus.getStatusByCode(json.getInt(IMDbConstants.STATUS_CODE)));
	}
	
	/**
	 * Initializes the response status with the given one.
	 * 
	 * @param status The response status
	 */
	public IMDbResponse(IMDbStatus status) {
		this.status = status;
	}
	
	/**
	 * Gets whether the response status is an error.
	 * 
	 * @return Whether the response status is an error.
	 */
	public boolean hasError() {
		return status.getCode() > IMDbStatus.NONE.getCode();
	}
	
	/**
	 * Gets the response status.
	 * 
	 * @return The response status
	 */
	public IMDbStatus getStatus() {
		return status;
	}

	/**
	 * Sets the response status.
	 * 
	 * @param status The new response status
	 */
	protected void setStatus(IMDbStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return status.getStatus();
	}

}
