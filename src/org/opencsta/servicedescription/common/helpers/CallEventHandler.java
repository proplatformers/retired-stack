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

package org.opencsta.servicedescription.common.helpers;

import org.opencsta.servicedescription.callcontrol.events.CallEvent_Base;
import org.opencsta.servicedescription.callcontrol.events.Conferenced;
import org.opencsta.servicedescription.callcontrol.events.ConnectionCleared;
import org.opencsta.servicedescription.callcontrol.events.ConnectionCleared_EricssonAppLink4;
import org.opencsta.servicedescription.callcontrol.events.Delivered;
import org.opencsta.servicedescription.callcontrol.events.Delivered_EricssonAppLink4;
import org.opencsta.servicedescription.callcontrol.events.Diverted;
import org.opencsta.servicedescription.callcontrol.events.Established;
import org.opencsta.servicedescription.callcontrol.events.Established_EricssonAppLink4;
import org.opencsta.servicedescription.callcontrol.events.Failed;
import org.opencsta.servicedescription.callcontrol.events.Failed_EricssonAppLink4;
import org.opencsta.servicedescription.callcontrol.events.Held;
import org.opencsta.servicedescription.callcontrol.events.Held_EricssonAppLink4;
import org.opencsta.servicedescription.callcontrol.events.NetworkReached;
import org.opencsta.servicedescription.callcontrol.events.NetworkReached_EricssonAppLink4;
import org.opencsta.servicedescription.callcontrol.events.Originated;
import org.opencsta.servicedescription.callcontrol.events.Originated_EricssonAppLink4;
import org.opencsta.servicedescription.callcontrol.events.Queued;
import org.opencsta.servicedescription.callcontrol.events.Retrieved;
import org.opencsta.servicedescription.callcontrol.events.Retrieved_EricssonAppLink4;
import org.opencsta.servicedescription.callcontrol.events.ServiceInitiated;
import org.opencsta.servicedescription.callcontrol.events.ServiceInitiated_EricssonAppLink4;
import org.opencsta.servicedescription.callcontrol.events.Transferred;
import org.opencsta.servicedescription.callcontrol.events.Transferred_EricssonAppLink4;

/**
 * 
 * 
 * 
 * @author chrismylonas
 */
public class CallEventHandler extends CSTA_Base {

	/**
     *
     *
     */
	private CallEvent_Base currentEvent;

	/**
	 * Creates a new instance of EventHandler
	 * 
	 */
	public CallEventHandler() {
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 * @param curInStr
	 */
	public CallEvent_Base WorkEvent(StringBuffer curInStr) {

		switch (curInStr.charAt(0)) {
		case 0xA2:
			currentEvent = new Conferenced();
			currentEvent.workString(curInStr);
			// System.out.println("Conferenced Event") ;
			break;
		case 0xA3:
			currentEvent = new ConnectionCleared();
			currentEvent.workString(curInStr);
			// ConnectionCleared(curInStr, xRef) ;
			break;
		case 0xA4:
			currentEvent = new Delivered();
			currentEvent.workString(curInStr);
			// DeliveredEvent(curInStr, xRef) ;
			break;
		case 0xA6:
			currentEvent = new Diverted();
			currentEvent.workString(curInStr);
			// System.out.println("Diverted Event") ;
			break;
		case 0xA7:
			currentEvent = new Established();
			currentEvent.workString(curInStr);
			// EstablishedEvent(curInStr, xRef) ;
			break;
		case 0xA8:
			currentEvent = new Failed();
			currentEvent.workString(curInStr);
			break;
		case 0xA9:
			currentEvent = new Held();
			currentEvent.workString(curInStr);
			// HeldEvent(curInStr, xRef) ;
			break;
		case 0xAB:
			currentEvent = new NetworkReached();
			currentEvent.workString(curInStr);
			// System.out.println("Network Reached") ;
			break;
		case 0xAD:
			currentEvent = new Originated();
			currentEvent.workString(curInStr);
			break;
		case 0xAE:
			// System.out.println("Queued Event") ;
			currentEvent = new Queued();
			currentEvent.workString(curInStr);
			break;
		case 0xAF:
			currentEvent = new Retrieved();
			currentEvent.workString(curInStr);
			// RetrievedEvent(curInStr, xRef) ;
			break;
		case 0xB0:
			currentEvent = new ServiceInitiated();
			currentEvent.workString(curInStr);
			// ServiceInitiated(curInStr, xRef) ;
			break;
		case 0xB1:
			// System.out.println("Transferred Event") ;
			currentEvent = new Transferred();
			currentEvent.workString(curInStr);
			break;
		}

		return currentEvent;

	}

	public CallEvent_Base WorkEvent_Ericsson(StringBuffer curInStr) {

		switch (curInStr.charAt(0)) {
		case 0xF2:
			currentEvent = new Conferenced();
			currentEvent.workString(curInStr);
			// System.out.println("Conferenced Event") ;
			break;
		case 0x03:
			currentEvent = new ConnectionCleared_EricssonAppLink4();
			currentEvent.workString(curInStr);
			// ConnectionCleared(curInStr, xRef) ;
			break;
		case 0x04:
			currentEvent = new Delivered_EricssonAppLink4();
			currentEvent.workString(curInStr);
			// DeliveredEvent(curInStr, xRef) ;
			break;
		case 0xF6:
			currentEvent = new Diverted();
			currentEvent.workString(curInStr);
			// System.out.println("Diverted Event") ;
			break;
		case 0x06:
			currentEvent = new Established_EricssonAppLink4();
			currentEvent.workString(curInStr);
			// EstablishedEvent(curInStr, xRef) ;
			break;
		case 0x07:
			currentEvent = new Failed_EricssonAppLink4();
			currentEvent.workString(curInStr);
			break;
		case 0x08:
			currentEvent = new Held_EricssonAppLink4();
			currentEvent.workString(curInStr);
			// HeldEvent(curInStr, xRef) ;
			break;
		case 0x09:
			currentEvent = new NetworkReached_EricssonAppLink4();
			currentEvent.workString(curInStr);
			// System.out.println("Network Reached") ;
			break;
		case 0x0a:
			currentEvent = new Originated_EricssonAppLink4();
			currentEvent.workString(curInStr);
			break;
		case 0xFE:
			// System.out.println("Queued Event") ;
			currentEvent = new Queued();
			currentEvent.workString(curInStr);
			break;
		case 0x0c:
			currentEvent = new Retrieved_EricssonAppLink4();
			currentEvent.workString(curInStr);
			// RetrievedEvent(curInStr, xRef) ;
			break;
		case 0x0d:
			currentEvent = new ServiceInitiated_EricssonAppLink4();
			currentEvent.workString(curInStr);
			// ServiceInitiated(curInStr, xRef) ;
			break;
		case 0x0e:
			// System.out.println("Transferred Event") ;
			currentEvent = new Transferred_EricssonAppLink4();
			currentEvent.workString(curInStr);
			break;
		case 0x67:
			// Forwarding Event
			// Switching Function Event: Forwarding
			// Invoke Id: 46 (x2E)
			// Monitor Cross Reference Id: 18 (x12)
			// Device: 1348
			// Forwarding Information:
			// Forwarding Type: Forward Immediate On
			// Forward DN: 8109
			// ASN1 data:
			// A1 23 02 01 2E 02 01 15 30 1B 55 01 12 80 01 67
			// 30 13 63 06 80 04 31 33 34 38 30 09 0A 01 00 16
			// 04 38 31 30 39
			break;

		}

		return currentEvent;

	}

}
