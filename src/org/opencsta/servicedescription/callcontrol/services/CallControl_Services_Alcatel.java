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

package org.opencsta.servicedescription.callcontrol.services;

import org.opencsta.servicedescription.callcontrol.services.interfaces.ICallControl_Services;

/**
 * @author chrismylonas
 * 
 */
public class CallControl_Services_Alcatel implements ICallControl_Services {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#AnswerCall(java.lang.String, java.lang.String)
	 */
	public StringBuffer AnswerCall(String dev, String strCallId_0) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#ClearConnection(java.lang.String, java.lang.String)
	 */
	public StringBuffer ClearConnection(String dev, String strCallId_0) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#DeflectCall(java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	public StringBuffer DeflectCall(String deviceFrom, String deviceTo,
			String strCallId_0) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#HoldCall(java.lang.String, java.lang.String)
	 */
	public StringBuffer HoldCall(String dev, String strCallId_0) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#MakeCall(java.lang.String, java.lang.String)
	 */
	public StringBuffer MakeCall(String dev1, String dev2) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#MonitorStart(java.lang.String)
	 */
	public StringBuffer MonitorStart(String device) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#MonitorStop(java.lang.String)
	 */
	public StringBuffer MonitorStop(String crossRef) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#RetrieveCall(java.lang.String, java.lang.String)
	 */
	public StringBuffer RetrieveCall(String dev, String strCallId_0) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#SingleStepTransfer(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public StringBuffer SingleStepTransfer(String deviceFrom, String deviceTo,
			String strCallId_0) {
		return null;
	}

}
