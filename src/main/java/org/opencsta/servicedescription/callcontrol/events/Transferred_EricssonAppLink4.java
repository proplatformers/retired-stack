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
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.SubjectDeviceID_EricssonAppLink4;

import java.util.*;
import org.opencsta.servicedescription.objects.cstaparamtypes.connectionstates.ConnectionList_EricssonAppLink4;

/**
 * @author chrismylonas
 * 
 */
public class Transferred_EricssonAppLink4 extends CallEvent_Base {

	/**
	 * 
	 */
	private SubjectDeviceID_EricssonAppLink4 transferringDevice;

	/**
	 * 
	 */
	private SubjectDeviceID_EricssonAppLink4 transferredToDevice;

	/**
	 * 
	 */
	private List transferredConnections;

	/**
	 * 
	 */
	private ConnectionID_EricssonAppLink4 primaryOldCall;

	/**
	 * 
	 */
	private ConnectionID_EricssonAppLink4 secondaryOldCall;

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
	private final String eventName = "\n\t*** TRANSFERRED APPLINK4***";

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
	private final String subjectDevice1Name = "\n\t*transferring device: ";

	/**
	 * 
	 */
	private final String subjectDevice2Name = "\n\t*transferred to device: ";

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
	 * 
	 */
	public Transferred_EricssonAppLink4() {
		primaryOldCall = new ConnectionID_EricssonAppLink4();
		secondaryOldCall = new ConnectionID_EricssonAppLink4();
		transferringDevice = new SubjectDeviceID_EricssonAppLink4();
		transferredToDevice = new SubjectDeviceID_EricssonAppLink4();
		transferredConnections = Collections.synchronizedList(new LinkedList());
		localConnectionInfo = new LocalConnectionState();
		cause = new EventCause();
	}

	/**
	 * @return
	 */
	public ConnectionID_EricssonAppLink4 get_primaryOldCall() {
		return primaryOldCall;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_primaryOldCall(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 2);
		curInStr = this.primaryOldCall.set_connectionID(curInStr);
		return curInStr;
	}

	/**
	 * @return
	 */
	public ConnectionID_EricssonAppLink4 get_secondaryOldCall() {
		return secondaryOldCall;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_secondaryOldCall(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 2);
		curInStr = this.secondaryOldCall.set_connectionID(curInStr);
		return curInStr;
	}

	/**
	 * @return
	 */
	public SubjectDeviceID_EricssonAppLink4 get_transferringDevice() {
		return transferringDevice;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_transferringDevice(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 2);
		curInStr = this.transferringDevice.set_deviceID(curInStr);
		return curInStr;
	}

	/**
	 * @return
	 */
	public SubjectDeviceID_EricssonAppLink4 get_transferredToDevice() {
		return transferredToDevice;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_transferredToDevice(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 2);
		curInStr = this.transferredToDevice.set_deviceID(curInStr);
		return curInStr;
	}

	/**
	 * @return
	 */
	public List get_transferredConnections() {
		return transferredConnections;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer set_transferredConnections(StringBuffer curInStr) {
		curInStr = CheckLengthAndStrip(curInStr, 2);
		ConnectionList_EricssonAppLink4 connectionList = new ConnectionList_EricssonAppLink4();
		curInStr = connectionList.workString(curInStr);
		transferredConnections.add(connectionList);
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

		int whichConnection = 0;
		int whichSubjectDevice = 0;
		// TEMP FIX for timestamp & global connection ID stuff
		int tmp_count = 0;
		while (curInStr.length() != 0) {
			System.out.println("CHRIS:"
					+ Integer.toHexString((int) curInStr.charAt(0)));
			if (curInStr.charAt(0) == 0x30) {
				curInStr = CheckLengthAndStrip(curInStr, 2);
			}
			if (curInStr.charAt(0) == 0x6B) {
				if (whichConnection == 0) {
					curInStr = this.set_primaryOldCall(curInStr);
					whichConnection++;
				} else if (whichConnection == 1) {
					curInStr = this.set_secondaryOldCall(curInStr);
					whichConnection++;
				}
			}
			if (curInStr.charAt(0) == 0x63) {
				if (whichSubjectDevice == 0) {
					curInStr = this.set_transferringDevice(curInStr);
					whichSubjectDevice++;
				} else if (whichSubjectDevice == 1) {
					curInStr = this.set_transferredToDevice(curInStr);
					whichSubjectDevice++;
				}
			}
			if (curInStr.charAt(0) == 0x6c)
				curInStr = this.set_transferredConnections(curInStr);
			if (curInStr.charAt(0) == 0x4E)
				curInStr = this.set_localConnectionInfo(curInStr);
			if (curInStr.length() > 0) {
				if (curInStr.charAt(0) == 0x0A) {
					curInStr = this.set_cause(curInStr);
				}
			}
			tmp_count++;
			if (tmp_count > 5)
				curInStr = new StringBuffer();
		}
	}

	/**
	 * @return
	 */
	public String connectionListToString() {
		String str = new String();
		for (int i = 0; i < transferredConnections.size(); i++) {
			str += (String) transferredConnections.get(i).toString();
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
				+ subjectDevice1Name + transferringDevice.toString()
				+ subjectDevice2Name + transferredToDevice.toString()
				+ connectionListName + connectionListToString()
				+ localConnectionStateName + localConnectionInfo.toString()
				+ eventCauseName + cause.toString();

		return str;
	}
}