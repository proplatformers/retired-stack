/*
This file is part of Open CSTA.

    Open CSTA is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Open CSTA is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Open CSTA.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.opencsta.servicedescription.objects.cstaparamtypes.security;

/**
 * 
 * @author chrismylonas
 */
public class TimeInfo {

	/**
	 * 
	 */
	String value;

	/**
	 * @param _time
	 */
	public TimeInfo(String _time) {
		value = _time;
	}

	/**
	 * @return
	 */
	public String getValue() {
		return value;
	}
}
