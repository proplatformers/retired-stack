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
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.CalledDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.CallingDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.RedirectionDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.SubjectDeviceID;

/**
 * @author chrismylonas
 * 
 */
public class NetworkReached extends CallEvent_Base {

	/**
     * 
     */
	private ConnectionID outboundConnection;

	/**
     * 
     */
	private SubjectDeviceID networkInterfaceUsed;

	/**
     * 
     */
	private CallingDeviceID callingDevice;

	/**
     * 
     */
	private CalledDeviceID calledDevice;

	/**
     * 
     */
	private RedirectionDeviceID lastRedirectionDevice;

	/**
     * 
     */
	private AssociatedCallingDeviceID associatedCallingDevice;

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
	private final String eventName = "\n\t*** NETWORK REACHED ***";

	/**
     * 
     */
	private final String connectionName = "\n\t*outbound connection: ";

	/**
     * 
     */
	private final String subjectDeviceName = "\n\t*network interface used: ";

	/**
     * 
     */
	private final String callingDeviceName = "\n\t*calling device: ";

	/**
     * 
     */
	private final String calledDeviceName = "\n\t*called device: ";

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
	public NetworkReached() {
		outboundConnection = new ConnectionID();
		networkInterfaceUsed = new SubjectDeviceID();
		callingDevice = new CallingDeviceID();
		calledDevice = new CalledDeviceID();
		lastRedirectionDevice = new RedirectionDeviceID();
		localConnectionInfo = new LocalConnectionState();
		cause = new EventCause();
		associatedCallingDevice = new AssociatedCallingDeviceID();
	}

	/**
	 * @return
	 */
	public ConnectionID get_outboundConnection() {
		return outboundConnection;
	}

	/**
	 * @return
	 */
	public SubjectDeviceID get_networkInterfaceUsed() {
		return networkInterfaceUsed;
	}

	/**
	 * @return
	 */
	public CallingDeviceID get_callingDevice() {
		return callingDevice;
	}

	/**
	 * @return
	 */
	public CalledDeviceID get_calledDevice() {
		return calledDevice;
	}

	/**
	 * @return
	 */
	public RedirectionDeviceID get_lastRedirectionDevice() {
		return lastRedirectionDevice;
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
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_outboundConnection(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 4);
		curInStr = this.outboundConnection.set_connectionID(curInStr);
		return curInStr;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_networkInterfaceUsed(StringBuffer curInStr) {
		curInStr = this.networkInterfaceUsed.set_deviceID(curInStr);
		return curInStr;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_callingDevice(StringBuffer curInStr) {
		curInStr = this.callingDevice.set_deviceID(curInStr);
		return curInStr;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_calledDevice(StringBuffer curInStr) {
		curInStr = this.calledDevice.set_deviceID(curInStr);
		return curInStr;
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
				curInStr = this.set_outboundConnection(curInStr);
			if (curInStr.charAt(0) == 0x63)
				curInStr = this.set_networkInterfaceUsed(curInStr);
			if (curInStr.charAt(0) == 0x61)
				curInStr = this.set_callingDevice(curInStr);
			if (curInStr.charAt(0) == 0x62)
				curInStr = this.set_calledDevice(curInStr);
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
		String str = eventName + connectionName + outboundConnection.toString()
				+ subjectDeviceName + networkInterfaceUsed.toString()
				+ callingDeviceName + callingDevice.toString()
				+ calledDeviceName + calledDevice.toString()
				+ redirectionDeviceName + lastRedirectionDevice.toString()
				+ localConnectionStateName + localConnectionInfo.toString()
				+ eventCauseName + cause.toString()
				+ associatedCallingDeviceName
				+ associatedCallingDevice.toString();
		return str;

	}
}