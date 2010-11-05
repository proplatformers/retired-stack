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

package org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers;

/**
 * ECMA-269 12.3.22: For external incomign calls, this parameter specifies the
 * called device information that was provided by the Network over a Network
 * Interface Device. For example, this may contain DNIS (Dialed Number
 * Identification Service) or DID (Direct Inward Dialing) digit information or a
 * string of digits that represents the called device. This information is
 * established when the call is first created and stays with the call as long as
 * teh Network Interface Device (NID) associated with teh original calling
 * device remains in the call, even if the call is transferred from the original
 * called device, for example.
 * 
 */
public class NetworkCalledDeviceID extends DetailedDeviceID {

	/**
	 * 
	 */
	public NetworkCalledDeviceID() {
	}

}
