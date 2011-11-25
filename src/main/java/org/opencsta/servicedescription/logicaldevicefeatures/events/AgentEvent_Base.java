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

package org.opencsta.servicedescription.logicaldevicefeatures.events;

import org.opencsta.servicedescription.common.AgentEvent;
import org.opencsta.servicedescription.common.helpers.CSTAEvent;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.DeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.SubjectDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.otherparameters.AgentID;

/**
 * @author chrismylonas
 * 
 */
public abstract class AgentEvent_Base extends CSTAEvent implements AgentEvent {

	/**
	 * 
	 */
	protected SubjectDeviceID agentDevice;

	/**
	 * 
	 */
	protected AgentID agentID;

	/**
	 * 
	 */
	protected DeviceID acdGroup;

	/**
	 * @return
	 */
	public SubjectDeviceID getAgentDevice() {
		return agentDevice;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer setAgentDevice(StringBuffer curInStr) {
		curInStr = this.agentDevice.set_deviceID(curInStr);
		return curInStr;
	}

	/**
	 * @return
	 */
	public AgentID getAgentID() {
		return agentID;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer setAgentID(StringBuffer curInStr) {
		curInStr = this.agentID.setValue(curInStr);
		return curInStr;
	}

	/**
	 * @return
	 */
	public DeviceID getAcdGroup() {
		return acdGroup;
	}

	/**
	 * 
	 */
	public void setAcdGroup() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opencsta.servicedescription.common.AgentEvent#workString(java.lang
	 * .StringBuffer)
	 */
	public void workString(StringBuffer curInStr) {
		// cut off anything that was used prior to this (i.e. layer 7 used info)
		curInStr = CheckLengthAndStrip(curInStr, 2);

		// TEMP FIX for timestamp & global connection ID stuff
		int tmp_count = 0;
		while (curInStr.length() != 0) {
			if (curInStr.charAt(0) == 0x63)
				curInStr = this.setAgentDevice(curInStr);
			if (curInStr.charAt(0) == 0x04)
				curInStr = this.setAgentID(curInStr);
			if (curInStr.charAt(0) == 0x82)
				curInStr = this.setAgentID(curInStr);

			tmp_count++;
			if (tmp_count > 8)
				curInStr = new StringBuffer();
		}
	}

	/**
	 * 
	 */
	public AgentEvent_Base() {
		agentDevice = new SubjectDeviceID();
		agentID = new AgentID();
		acdGroup = new DeviceID();
	}
}