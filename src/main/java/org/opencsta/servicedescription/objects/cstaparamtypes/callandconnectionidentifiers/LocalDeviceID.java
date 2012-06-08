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

package org.opencsta.servicedescription.objects.cstaparamtypes.callandconnectionidentifiers;

import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.DetailedDeviceID;

/**
 * @author chrismylonas
 * 
 */
public class LocalDeviceID extends DetailedDeviceID {

	/**
	 * 
	 */
	public LocalDeviceID() {
	}

	/**
	 * @param _ext
	 */
	public LocalDeviceID(String _ext) {
		super(_ext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers
	 * .DetailedDeviceID#set_deviceID()
	 */
	public String set_deviceID() {
		String str;
		String _tmp = this.deviceID.set_deviceID();
		str = insertSequence(_tmp);
		int length = str.length();
		char[] ar_ddevid = { 0xa1, (char) length };
		return ((new String(ar_ddevid)) + str);
	}
}