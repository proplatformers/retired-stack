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
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.AssociatedCallingDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.SubjectDeviceID;

/**
 * @author chrismylonas
 * 
 */
public class ServiceInitiated extends CallEvent_Base {

	/**
     * 
     */
	private ConnectionID initiatedConnection;

	/**
     * 
     */
	private SubjectDeviceID initiatingDevice;

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
	private final String eventName = "\n\t*** SERVICE INITIATED ***";

	/**
     * 
     */
	private final String connectionName = "\n\t*initiated connection: ";

	/**
     * 
     */
	private final String subjectDeviceName = "\n\t*initiating device: ";

	/**
     * 
     */
	private final String localConnectionStateName = "\n\t*local connection info: ";

	/**
     * 
     */
	private final String eventCauseName = "\n\t*cause: ";

	/**
	 * @return
	 */
	public ConnectionID get_initiatedConnection() {
		return initiatedConnection;
	}

	/**
	 * @return
	 */
	public SubjectDeviceID get_initiatingDevice() {
		return initiatingDevice;
	}

	/**
	 * @return
	 */
	public LocalConnectionState get_localConnectionInfo() {
		return localConnectionInfo;
	}

	/**
	 * @return
	 */
	public AssociatedCallingDeviceID get_associatedCallingDevice() {
		return null;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_initiatedConnection(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 4);
		curInStr = this.initiatedConnection.set_connectionID(curInStr);
		return curInStr;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_initiatingDevice(StringBuffer curInStr) {
		curInStr = this.initiatingDevice.set_deviceID(curInStr);
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

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_associatedCallingDevice(StringBuffer curInStr) {
		return null;
	}

	/**
	 * @return
	 */
	public EventCause get_cause() {
		return null;
	}

	/**
     * 
     */
	public ServiceInitiated() {
		initiatedConnection = new ConnectionID();
		initiatingDevice = new SubjectDeviceID();
		localConnectionInfo = new LocalConnectionState();
		cause = new EventCause();
	}

	// this is for an asterisk service initiated
	/**
	 * @param _ext
	 * @param _call_id
	 * @param _time
	 */
	public ServiceInitiated(String _ext, String _call_id, String _time) {
		// do nothing with the time until we have it done from the siemens
		// and then reverse the process for asterisk
		System.out.println("_SEPT 05: New ServiceInitiated");
		cause = new EventCause("newCall");// new call = 0x16/22
		localConnectionInfo = new LocalConnectionState("initiated");
		initiatingDevice = new SubjectDeviceID(_ext);
		initiatedConnection = new ConnectionID(_call_id, _ext);
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
		_sb = _sb.append(set_initiatedConnection());
		_sb = _sb.append(set_initiatingDevice());
		_sb = _sb.append(set_localConnectionInfo());
		_sb = _sb.append(set_cause());

		// _sb =
		// _sb.append(0x63).append(0x07).append(0x30).append(0x05).append(0x80).append(0x03).append(
		// initiatingDevice.get_deviceID().getValue() ) ;
		return _sb;
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
				curInStr = this.set_initiatedConnection(curInStr);
			if (curInStr.charAt(0) == 0x63)
				curInStr = this.set_initiatingDevice(curInStr);
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
		String str = eventName + connectionName
				+ initiatedConnection.toString() + subjectDeviceName
				+ initiatingDevice.toString() + localConnectionStateName
				+ localConnectionInfo.toString() + eventCauseName
				+ cause.toString();
		return str;
	}

	// asterisk
	/**
	 * @return
	 */
	public String set_cause() {
		return cause.set_cause();
		// char[] ar_cause = { 0x0A,0x01,cause.get_value() } ;
		// return (new String(ar_cause)) ;
	}

	// asterisk
	/**
	 * @return
	 */
	public String set_localConnectionInfo() {
		return localConnectionInfo.set_localConnectionState();
		// char[] ar_lci = {0x4E,0x01, localConnectionInfo.get_value() } ;
		// return (new String(ar_lci)) ;
	}

	// asterisk
	/**
	 * @return
	 */
	public String set_initiatingDevice() {
		return (initiatingDevice.set_deviceID());
		// int length =
		// this.initiatingDevice.get_deviceID().get_value().length() ;
		// char[] ar_inidev = { 0x63, (char)length} ;
		// return (new String(ar_inidev) +
		// this.initiatingDevice.get_deviceID().get_value() ) ;
	}

	// asterisk
	/**
	 * @return
	 */
	public String set_initiatedConnection() {
		return (initiatedConnection.set_connectionID());
	}
}