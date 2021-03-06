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

package org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers;

import org.opencsta.servicedescription.common.helpers.CSTA_Base;

/**
 * No ECMA documentation on this. This may be a Siemens (& other companies)
 * specific identifier.
 * 
 */
public abstract class DetailedDeviceID extends CSTA_Base {

	/**
     * 
     */
	protected DeviceID deviceID;

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_deviceID(StringBuffer curInStr) {
		if (curInStr.charAt(1) == 2)// no data null
			curInStr = CheckLengthAndStrip(curInStr, 4);
		else {
			curInStr = CheckLengthAndStrip(curInStr, 4);
			curInStr = this.deviceID.set_value(curInStr);
		}
		return curInStr;
	}

	/**
	 * @return
	 */
	public DeviceID get_deviceID() {
		return deviceID;
	}

	/**
     * 
     */
	public DetailedDeviceID() {
		deviceID = new DeviceID();
	}

	/**
	 * @param _ext
	 */
	public DetailedDeviceID(String _ext) {
		System.out.println("_SEPT 05: asterisk SI's (subject) detailed device");
		set_deviceID(_ext);
	}

	/**
	 * @param ext
	 */
	private void set_deviceID(String ext) {
		this.deviceID = new DeviceID(ext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = deviceID.toString();
		return str;
	}

	/**
	 * @return
	 */
	public String set_deviceID() {
		String str;
		String _tmp = this.deviceID.set_deviceID();
		str = insertSequence(_tmp);
		int length = str.length();
		char[] ar_ddevid = { 0x63, (char) length };
		return ((new String(ar_ddevid)) + str);
	}
}