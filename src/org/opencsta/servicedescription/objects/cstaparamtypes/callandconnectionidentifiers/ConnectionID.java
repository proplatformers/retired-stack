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

import org.opencsta.servicedescription.objects.cstaparamtypes.switchingfunctionobjects.CSTAObject;

/**
 * @author chrismylonas
 * 
 */
public class ConnectionID extends CSTAObject {

	/**
	 * 
	 */
	private CallID callID;

	/**
	 * 
	 */
	private LocalDeviceID deviceID;

	/**
	 * 
	 */
	private final String callIDName = "\n\t*\tCall ID: ";

	/**
	 * 
	 */
	private final String deviceIDName = "\n\t*\tDevice ID: ";

	/**
	 * @param call_id
	 * @param device_id
	 */
	public ConnectionID(CallID call_id, LocalDeviceID device_id) {
		this.callID = call_id;
		this.deviceID = device_id;
	}

	/**
	 * @param _call_id
	 * @param _device_id
	 */
	public ConnectionID(String _call_id, String _device_id) {
		this.callID = new CallID(_call_id);
		this.deviceID = new LocalDeviceID(_device_id);
	}

	/**
	 * 
	 */
	public ConnectionID() {
		callID = new CallID();
		deviceID = new LocalDeviceID();
	}

	/**
	 * @return
	 */
	public CallID get_callID() {
		return callID;
	}

	/**
	 * @return
	 */
	public LocalDeviceID get_deviceID() {
		return deviceID;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_callID(StringBuffer curInStr) {
		curInStr = this.callID.set_value(curInStr);
		return curInStr;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_deviceID(StringBuffer curInStr) {
		curInStr = this.deviceID.set_deviceID(curInStr);
		return curInStr;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_connectionID(StringBuffer curInStr) {
		if (curInStr.charAt(0) == 0x80)
			curInStr = this.set_callID(curInStr);
		if (curInStr.charAt(0) == 0xA1)
			curInStr = this.set_deviceID(curInStr);
		return curInStr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = callIDName + callID.toString() + deviceIDName
				+ deviceID.toString();
		return str;
	}

	/**
	 * @return
	 */
	public String set_connectionID() {
		String tmp_call_id = callID.set_callID();
		String tmp_dev = deviceID.set_deviceID();
		String str = tmp_call_id + tmp_dev;
		str = insertSequence(str);
		int length = str.length();
		char[] ar_connID = { 0x6B, (char) length };
		return ((new String(ar_connID) + str));
	}
}