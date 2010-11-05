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
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.AssociatedCalledDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.AssociatedCallingDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.RedirectionDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.SubjectDeviceID;

/**
 * @author chrismylonas
 * 
 */
public class Diverted extends CallEvent_Base {

	/**
     * 
     */
	private ConnectionID connection;

	/**
     * 
     */
	private SubjectDeviceID divertingDevice;

	/**
     * 
     */
	private RedirectionDeviceID lastRedirectionDevice;

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
	private AssociatedCalledDeviceID associatedCalledDevice;

	/**
     * 
     */
	private AssociatedCallingDeviceID associatedCallingDevice;

	/**
     * 
     */
	private SubjectDeviceID newDestination;

	/**
     * 
     */
	private final String eventName = "\n\t*** DIVERTED ***";

	/**
     * 
     */
	private final String connectionName = "\n\t*connection: ";

	/**
     * 
     */
	private final String subjectDevice1Name = "\n\t*diverting device: ";

	/**
     * 
     */
	private final String subjectDevice2Name = "\n\t*new destination device: ";

	/**
     * 
     */
	private final String redirectionDeviceName = "\n\t*last redirection device: ";

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
	public Diverted() {
		connection = new ConnectionID();
		divertingDevice = new SubjectDeviceID();
		newDestination = new SubjectDeviceID();
		lastRedirectionDevice = new RedirectionDeviceID();
		localConnectionInfo = new LocalConnectionState();
		cause = new EventCause();
		associatedCallingDevice = new AssociatedCallingDeviceID();
		associatedCalledDevice = new AssociatedCalledDeviceID();
	}

	/**
	 * @return
	 */
	public ConnectionID get_connection() {
		return connection;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_connection(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 2);
		curInStr = this.connection.set_connectionID(curInStr);
		return curInStr;
	}

	/**
	 * @return
	 */
	public SubjectDeviceID get_divertingDevice() {
		return divertingDevice;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_divertingDevice(StringBuffer curInStr) {
		curInStr = this.divertingDevice.set_deviceID(curInStr);
		return curInStr;
	}

	/**
	 * @return
	 */
	public SubjectDeviceID get_newDestination() {
		return newDestination;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_newDestination(StringBuffer curInStr) {
		curInStr = this.newDestination.set_deviceID(curInStr);
		return curInStr;
	}

	/**
	 * @return
	 */
	public RedirectionDeviceID get_lastRedirectionDevice() {
		return lastRedirectionDevice;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_lastRedirectionDevice(StringBuffer curInStr) {
		curInStr = this.lastRedirectionDevice.set_deviceID(curInStr);
		return curInStr;
	}

	/**
	 * @return
	 */
	public EventCause get_cause() {
		return cause;
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
	public StringBuffer set_localConnectionInfo(StringBuffer curInStr) {
		curInStr = this.localConnectionInfo.set_value(curInStr);
		return curInStr;
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
		return associatedCallingDevice;
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
	 * @return
	 */
	public AssociatedCalledDeviceID get_associatedCalledDevice() {
		return associatedCalledDevice;
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
		curInStr = CheckLengthAndStrip(curInStr, 2);

		// TEMP FIX for timestamp & global connection ID stuff
		int tmp_count = 0;
		int whichSubjectDevice = 0;
		while (curInStr.length() != 0) {
			StringContains(curInStr, "DIVERTED EVENT BREAK DOWN");
			if (curInStr.charAt(0) == 0x6B)
				curInStr = this.set_connection(curInStr);
			if (curInStr.charAt(0) == 0x63) {
				if (whichSubjectDevice == 0) {
					curInStr = this.set_divertingDevice(curInStr);
					whichSubjectDevice++;
				} else if (whichSubjectDevice == 1) {
					curInStr = this.set_newDestination(curInStr);
					whichSubjectDevice++;
				}
			}
			if (curInStr.charAt(0) == 0x64)
				curInStr = this.set_lastRedirectionDevice(curInStr);
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
		String str = eventName + connectionName + connection.toString()
				+ subjectDevice1Name + divertingDevice.toString()
				+ subjectDevice2Name + newDestination.toString()
				+ redirectionDeviceName + lastRedirectionDevice.toString()
				+ localConnectionStateName + localConnectionInfo.toString()
				+ eventCauseName + cause.toString()
				+ associatedCallingDeviceName
				+ associatedCallingDevice.toString()
				+ associatedCalledDeviceName
				+ associatedCalledDevice.toString();

		return str;
	}
}