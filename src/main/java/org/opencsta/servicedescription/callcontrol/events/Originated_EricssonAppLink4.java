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
import org.opencsta.servicedescription.objects.cstaparamtypes.callandconnectionidentifiers.ConnectionID_EricssonAppLink4;
import org.opencsta.servicedescription.objects.cstaparamtypes.connectionstates.LocalConnectionState;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.AssociatedCalledDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.AssociatedCallingDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.CalledDeviceID_EricssonAppLink4;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.SubjectDeviceID_EricssonAppLink4;

/**
 * @author chrismylonas
 * 
 */
public class Originated_EricssonAppLink4 extends CallEvent_Base {

	/**
     * 
     */
	private ConnectionID_EricssonAppLink4 originatedConnection;

	/**
     * 
     */
	private SubjectDeviceID_EricssonAppLink4 callingDevice;

	/**
     * 
     */
	private CalledDeviceID_EricssonAppLink4 calledDevice;

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
	private AssociatedCallingDeviceID associatedCallingDevice;

	/**
     * 
     */
	private AssociatedCalledDeviceID associatedCalledDevice;

	/**
     * 
     */
	private final String eventName = "\n\t*** ORIGINATED APPLINK4***";

	/**
     * 
     */
	private final String connectionName = "\n\t*originated connection: ";

	/**
     * 
     */
	private final String subjectDeviceName = "\n\t*calling device: ";

	/**
     * 
     */
	private final String calledDeviceName = "\n\t*called device: ";

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
	private final String associatedCallingDeviceName = "\n\t*associated calling device: ";

	/**
     * 
     */
	private final String associatedCalledDeviceName = "\n\t*associated called device: ";

	/**
     * 
     */
	public Originated_EricssonAppLink4() {
		originatedConnection = new ConnectionID_EricssonAppLink4();
		callingDevice = new SubjectDeviceID_EricssonAppLink4();
		calledDevice = new CalledDeviceID_EricssonAppLink4();
		localConnectionInfo = new LocalConnectionState();
		cause = new EventCause();
		associatedCallingDevice = new AssociatedCallingDeviceID();
		associatedCalledDevice = new AssociatedCalledDeviceID();
	}

	/**
	 * @return
	 */
	public ConnectionID_EricssonAppLink4 get_orginatedConnection() {
		return originatedConnection;
	}

	/**
	 * @return
	 */
	public SubjectDeviceID_EricssonAppLink4 get_callingDevice() {
		return callingDevice;
	}

	/**
	 * @return
	 */
	public CalledDeviceID_EricssonAppLink4 get_calledDevice() {
		return calledDevice;
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
	public EventCause get_cause() {
		return cause;
	}

	/**
	 * @return
	 */
	public AssociatedCallingDeviceID get_associatedCallingDevice() {
		return associatedCallingDevice;
	}

	/**
	 * @return
	 */
	public AssociatedCalledDeviceID get_associatedCalledDevice() {
		return associatedCalledDevice;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_originatedConnection(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 2);
		curInStr = this.originatedConnection.set_connectionID(curInStr);
		return curInStr;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_callingDevice(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 2);
		curInStr = this.callingDevice.set_deviceID(curInStr);
		return curInStr;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_calledDevice(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 2);
		curInStr = this.calledDevice.set_deviceID(curInStr);
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
		curInStr = this.associatedCallingDevice.set_deviceID(curInStr);
		return curInStr;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_associatedCalledDevice(StringBuffer curInStr) {
		curInStr = this.associatedCalledDevice.set_deviceID(curInStr);
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
		curInStr = CheckLengthAndStrip(curInStr, 1);

		// TEMP FIX for timestamp & global connection ID stuff
		int tmp_count = 0;
		while (curInStr.length() != 0) {
			if (curInStr.charAt(0) == 0x30) {
				curInStr = CheckLengthAndStrip(curInStr, 2);
			}
			if (curInStr.charAt(0) == 0x6B)
				curInStr = this.set_originatedConnection(curInStr);
			if (curInStr.charAt(0) == 0x63)
				curInStr = this.set_callingDevice(curInStr);
			if (curInStr.charAt(0) == 0x62)
				curInStr = this.set_calledDevice(curInStr);
			if (curInStr.charAt(0) == 0x4E)
				curInStr = this.set_localConnectionInfo(curInStr);
			if (curInStr.length() > 0) {
				if (curInStr.charAt(0) == 0x0A) {
					curInStr = this.set_cause(curInStr);
				}
			}

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
				+ originatedConnection.toString() + subjectDeviceName
				+ callingDevice.toString() + calledDeviceName
				+ calledDevice.toString() + localConnectionStateName
				+ localConnectionInfo.toString() + eventCauseName
				+ cause.toString() + associatedCallingDeviceName
				+ associatedCallingDevice.toString()
				+ associatedCalledDeviceName
				+ associatedCalledDevice.toString();
		return str;
	}
}