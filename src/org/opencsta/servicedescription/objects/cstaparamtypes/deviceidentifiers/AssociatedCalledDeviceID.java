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
 * ECMA-269 12.3.2: For outgoing external calls, the AssociatedCalledDeviceID
 * parameter type specifies the Network Interface Device (e.g., trunk, CO Line)
 * within the switching sub-domain that is associated with the originally called
 * device. This parameter is mandatory on all events dealing with external
 * outgoing calls. For incoming external calls, this parameter specifies a
 * device within the switching sub- domain that is associated with the
 * originally called device (such as a switching function internal
 * representation of DNIS, for example). This parameteris optional on all events
 * dealing with incoming external calls.
 * 
 */
public class AssociatedCalledDeviceID extends DetailedDeviceID {

	/**
     * 
     */
	public AssociatedCalledDeviceID() {
	}
}