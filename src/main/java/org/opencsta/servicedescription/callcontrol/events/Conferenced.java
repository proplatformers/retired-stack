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
import org.opencsta.servicedescription.objects.cstaparamtypes.connectionstates.ConnectionList;
import org.opencsta.servicedescription.objects.cstaparamtypes.connectionstates.LocalConnectionState;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.SubjectDeviceID;

import java.util.*;

/**
 * @author chrismylonas
 * 
 */
public class Conferenced extends CallEvent_Base {

	/**
	 * 
	 */
	private SubjectDeviceID conferencingDevice;

	/**
     * 
     */
	private SubjectDeviceID addedParty;

	/**
     * 
     */
	private List conferenceConnections;

	/**
     * 
     */
	private ConnectionID primaryOldCall;

	/**
     * 
     */
	private ConnectionID secondaryOldCall;

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
	private final String eventName = "\n\t*** CONFERENCED ***";

	/**
     * 
     */
	private final String primaryOldCallName = "\n\t*primary old call: ";

	/**
     * 
     */
	private final String secondaryOldCallName = "\n\t*secondary old call: ";

	/**
     * 
     */
	private final String subjectDevice1Name = "\n\t*conferencing device: ";

	/**
     * 
     */
	private final String subjectDevice2Name = "\n\t*added party: ";

	/**
     * 
     */
	private final String connectionListName = "\n\t*connection list: ";

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
	public ConnectionID get_primaryOldCall() {
		return primaryOldCall;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_primaryOldCall(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 4);
		curInStr = this.primaryOldCall.set_connectionID(curInStr);
		return curInStr;
	}

	/**
	 * @return
	 */
	public ConnectionID get_secondaryOldCall() {
		return secondaryOldCall;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_secondaryOldCall(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 4);
		curInStr = this.secondaryOldCall.set_connectionID(curInStr);
		return curInStr;
	}

	/**
	 * @return
	 */
	public SubjectDeviceID get_conferencingDevice() {
		return conferencingDevice;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_conferencingDevice(StringBuffer curInStr) {
		curInStr = this.conferencingDevice.set_deviceID(curInStr);
		return curInStr;
	}

	/**
	 * @return
	 */
	public SubjectDeviceID get_addedParty() {
		return addedParty;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_addedParty(StringBuffer curInStr) {
		curInStr = this.addedParty.set_deviceID(curInStr);
		return curInStr;
	}

	/**
	 * @return
	 */
	public List get_conferenceConnections() {
		return conferenceConnections;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_conferenceConnections(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 2);
		while (curInStr.charAt(0) == 0x30) {
			ConnectionList connectionList = new ConnectionList();
			curInStr = connectionList.workString(curInStr);
			conferenceConnections.add(connectionList);
		}
		return curInStr;
	}

	/**
	 * @return
	 */
	public LocalConnectionState get_localConnectionInfo() {
		return localConnectionInfo;
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
	 * @return
	 */
	public String connectionListToString() {
		String str = new String();
		for (int i = 0; i < conferenceConnections.size(); i++) {
			str += (String) conferenceConnections.get(i).toString();
		}
		return str;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = eventName + primaryOldCallName + primaryOldCall.toString()
				+ secondaryOldCallName + secondaryOldCall.toString()
				+ subjectDevice1Name + conferencingDevice.toString()
				+ subjectDevice2Name + addedParty.toString()
				+ connectionListName + connectionListToString()
				+ localConnectionStateName + localConnectionInfo.toString()
				+ eventCauseName + cause.toString();

		return str;
	}

	/**
     * 
     */
	public Conferenced() {
		primaryOldCall = new ConnectionID();
		secondaryOldCall = new ConnectionID();
		conferencingDevice = new SubjectDeviceID();
		addedParty = new SubjectDeviceID();
		conferenceConnections = Collections.synchronizedList(new LinkedList());
		localConnectionInfo = new LocalConnectionState();
		cause = new EventCause();
	}

}