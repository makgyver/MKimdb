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
 * Abstract class that represents a list of parameter useful to make the API calls.
 * 
 * @author Mirko Polato
 *
 */
public abstract class IMDbParameters {

	//region Fields
	
	/**
	 * The verbosity of the plot field.
	 */
	private IMDbVerbosity plot = IMDbVerbosity.SIMPLE;
	
	/**
	 * The verbosity of the aka (also known as) field.
	 */
	private IMDbVerbosity aka = IMDbVerbosity.SIMPLE;
	
	/**
	 * The verbosity of the release field.
	 */
	private IMDbVerbosity release = IMDbVerbosity.SIMPLE;
	
	/**
	 * When the parameter is false, "episodes" is not included in the result.
	 */
	private boolean episode = true;
	
	//endregion
	
	//region Getters/Setters
	
	/**
	 * Gets the plot verbosity.
	 * 
	 * @return The plot verbosity
	 */
	public IMDbVerbosity getPlot() {
		return plot;
	}
	
	/**
	 * Sets the plot verbosity.
	 * 
	 * @param plot The new plot verbosity
	 */
	public void setPlot(IMDbVerbosity plot) {
		this.plot = plot;
	}
	
	/**
	 * Gets the aka verbosity.
	 * 
	 * @return The aka verbosity
	 */
	public IMDbVerbosity getAka() {
		return aka;
	}
	
	/**
	 * Sets the aka verbosity.
	 * 
	 * @param aka The new aka verbosity
	 */
	public void setAka(IMDbVerbosity aka) {
		this.aka = aka;
	}
	
	/**
	 * Gets the release verbosity.
	 * 
	 * @return The release verbosity
	 */
	public IMDbVerbosity getRelease() {
		return release;
	}
	
	/**
	 * Sets the release verbosity.
	 * 
	 * @param release The new release verbosity
	 */
	public void setRelease(IMDbVerbosity release) {
		this.release = release;
	}
	
	/**
	 * Gets whether the episodes are included in the results or not.
	 * 
	 * @return Whether the episodes are included in the results or not
	 */
	public boolean isEpisode() {
		return episode;
	}
	
	/**
	 * Sets if the episodes are included in the results.
	 * 
	 * @param episode Whether the episodes are included in the results or not
	 */
	public void setEpisode(boolean episode) {
		this.episode = episode;
	}
	
	//endregion
}
