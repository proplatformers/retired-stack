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

package org.opencsta.servicedescription.callcontrol.events;

import org.opencsta.servicedescription.objects.cstaparamtypes.EventCause;
import org.opencsta.servicedescription.objects.cstaparamtypes.callandconnectionidentifiers.ConnectionID;
import org.opencsta.servicedescription.objects.cstaparamtypes.connectionstates.LocalConnectionState;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.SubjectDeviceID;

/**
 * @author chrismylonas
 * 
 */
public class ConnectionCleared extends CallEvent_Base {

	/**
     * 
     */
	private ConnectionID droppedConnection;

	/**
     * 
     */
	private SubjectDeviceID releasingDevice;

	/**
     * 
     */
	private LocalConnectionState localConnectionInfo;

	/**
     * 
     */
	private EventCause cause;

	/**
     * 
     */
	private final String eventName = "\n\t*** CONNECTION CLEARED ***";

	/**
     * 
     */
	private final String connectionName = "\n\t*dropped connection: ";

	/**
     * 
     */
	private final String subjectDeviceName = "\n\t*releasing device: ";

	/**
     * 
     */
	private final String localConnectionStateName = "\n\t*local connection info: ";

	/**
     * 
     */
	private final String eventCauseName = "\n\t*cause: ";

	/**
     * 
     */
	public ConnectionCleared() {
		droppedConnection = new ConnectionID();
		releasingDevice = new SubjectDeviceID();
		localConnectionInfo = new LocalConnectionState();
		cause = new EventCause();
	}

	// asterisk
	/**
	 * @param _ext
	 * @param _call_id
	 * @param _time
	 */
	public ConnectionCleared(String _ext, String _call_id, String _time) {
		// do nothing with the time until we have it done from the siemens
		// and then reverse the process for asterisk
		cause = new EventCause("normalClearing");// new call = 0x16/22
		localConnectionInfo = new LocalConnectionState("null");
		releasingDevice = new SubjectDeviceID(_ext);
		droppedConnection = new ConnectionID(_call_id, _ext);
		StringBuffer sb = workString();
		for (int i = 0; i < sb.length(); i++)
			System.out.print(" " + Integer.toHexString(sb.charAt(i)));
	}

	// asterisk
	/**
	 * @return
	 */
	public StringBuffer workString() {
		StringBuffer _sb = new StringBuffer();
		_sb = _sb.append(set_droppedConnection());
		_sb = _sb.append(set_initiatingDevice());
		_sb = _sb.append(set_localConnectionInfo());
		_sb = _sb.append(set_cause());
		return _sb;
	}

	/**
	 * @return
	 */
	public ConnectionID get_droppedConnection() {
		return null;
	}

	/**
	 * @return
	 */
	public SubjectDeviceID get_releasingDevice() {
		return null;
	}

	/**
	 * @return
	 */
	public LocalConnectionState get_localConnectionInfo() {
		return null;
	}

	/**
	 * @return
	 */
	public EventCause get_cause() {
		return null;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_droppedConnection(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 4);
		curInStr = this.droppedConnection.set_connectionID(curInStr);
		return curInStr;
	}

	// asterisk
	/**
	 * @return
	 */
	public String set_droppedConnection() {
		return (droppedConnection.set_connectionID());
	}

	// asterisk
	/**
	 * @return
	 */
	public String set_cause() {
		return cause.set_cause();
	}

	// asterisk
	/**
	 * @return
	 */
	public String set_localConnectionInfo() {
		return localConnectionInfo.set_localConnectionState();
	}

	// asterisk
	/**
	 * @return
	 */
	public String set_initiatingDevice() {
		return (releasingDevice.set_deviceID());
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_releasingDevice(StringBuffer curInStr) {
		curInStr = this.releasingDevice.set_deviceID(curInStr);
		return curInStr;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_localConnectionInfo(StringBuffer curInStr) {
		curInStr = this.localConnectionInfo.set_value(curInStr);
		return curInStr;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_cause(StringBuffer curInStr) {
		curInStr = this.cause.set_value(curInStr);
		return curInStr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opencsta.servicedescription.callcontrol.events.CallEvent_Base#workString
	 * (java.lang.StringBuffer)
	 */
	public void workString(StringBuffer curInStr) {
		// cut off anything that was used prior to this (i.e. layer 7 used info)
		curInStr = CheckLengthAndStrip(curInStr, 2);

		// TEMP FIX for timestamp & global connection ID stuff
		int tmp_count = 0;
		while (curInStr.length() != 0) {
			if (curInStr.charAt(0) == 0x6B)
				curInStr = this.set_droppedConnection(curInStr);
			if (curInStr.charAt(0) == 0x63)
				curInStr = this.set_releasingDevice(curInStr);
			if (curInStr.charAt(0) == 0x4E)
				curInStr = this.set_localConnectionInfo(curInStr);
			if (curInStr.charAt(0) == 0x0A)
				curInStr = this.set_cause(curInStr);

			tmp_count++;
			if (tmp_count > 8)
				curInStr = new StringBuffer();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = eventName + connectionName + droppedConnection.toString()
				+ subjectDeviceName + releasingDevice.toString()
				+ localConnectionStateName + localConnectionInfo.toString()
				+ eventCauseName + cause.toString();
		return str;

	}

}