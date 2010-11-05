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

package org.opencsta.servicedescription.objects.cstaparamtypes.statusreporting;

import org.opencsta.servicedescription.common.helpers.CSTA_Base;

/**
 * ECMA-269 12.3.21: The MonitorCrossRefID parameter type specifies an
 * identifier that is used to correlate an event to an established monitor. When
 * a monitor is established using the Monitor Start service, a monitor Cross
 * ReferenceID parameter is returned as part of the positive acknowledgement
 * message. This monitorCrossReferenceID parameter is included in every event
 * for that specific monitor.
 * 
 */
public class MonitorCrossRefID extends CSTA_Base {

	/**
	 * 
	 */
	protected String value;

	/**
	 * 
	 */
	public MonitorCrossRefID() {
	}

	/**
	 * @param xref
	 */
	public MonitorCrossRefID(String xref) {
		value = xref;
	}

	/**
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer setValue(StringBuffer curInStr) {
		int length = (int) curInStr.charAt(1);
		this.value = curInStr.substring(2, (2 + length));
		curInStr = CheckLengthAndStrip(curInStr, (2 + length));
		return curInStr;
	}
}