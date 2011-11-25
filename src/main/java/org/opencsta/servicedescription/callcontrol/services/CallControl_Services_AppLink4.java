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
import org.opencsta.servicedescription.common.helpers.CSTA_Layer_7_Common;

/**
 * 
 * @author chrismylonas
 */
public class CallControl_Services_AppLink4 extends CSTA_Layer_7_Common
		implements ICallControl_Services {

	/**
     * 
     */
	public CallControl_Services_AppLink4() {

	}

	// A1 16 02 01 06 02 01 0A 30 0E 80 04 31 31 34 34 62 06 80 04 31 31 30 36
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#MakeCall(java.lang.String, java.lang.String)
	 */
	public StringBuffer MakeCall(String dev1, String dev2) {
		char[] tmp = { INTEGER, 0x01, 0x0A };// SERVICE ID
		String id = new String(tmp);// SERVICE ID
		StringBuffer str = new StringBuffer();// THE CSTA STRING

		str = PhaseI_Device(str, dev2); // DEVICE TO
		str = PhaseI_62(str);
		str = PhaseI_Device(str, dev1); // DEVICE FROM
		str = Sequence(str);
		str = str.insert(0, id); // SERVICE ID
		return str;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#AnswerCall(java.lang.String, java.lang.String)
	 */
	public StringBuffer AnswerCall(String dev, String str_call_id_0) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#HoldCall(java.lang.String, java.lang.String)
	 */
	public StringBuffer HoldCall(String dev, String str_call_id_0) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#RetrieveCall(java.lang.String, java.lang.String)
	 */
	public StringBuffer RetrieveCall(String dev, String str_call_id_0) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#SingleStepTransfer(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public StringBuffer SingleStepTransfer(String deviceFrom, String deviceTo,
			String str_call_id_0) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#DeflectCall(java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	public StringBuffer DeflectCall(String deviceFrom, String deviceTo,
			String str_call_id_0) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#ClearConnection(java.lang.String, java.lang.String)
	 */
	public StringBuffer ClearConnection(String dev, String str_call_id_0) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	// A1 0E 02 01 01 02 01 47 30 06 80 04 31 31 34 34
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#MonitorStart(java.lang.String)
	 */
	public StringBuffer MonitorStart(String device) {
		char[] tmp = { INTEGER, 0x01, 0x47 };// SERVICE ID
		String id = new String(tmp);// SERVICE ID
		StringBuffer str = new StringBuffer();// THE CSTA STRING

		str = PhaseI_Device(str, device);
		str = Sequence(str);
		str = str.insert(0, id);

		return str;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.callcontrol.services.interfaces.
	 * ICallControl_Services#MonitorStop(java.lang.String)
	 */
	public StringBuffer MonitorStop(String crossRef) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
