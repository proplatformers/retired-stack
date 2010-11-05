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

package org.opencsta.servicedescription.objects.cstaparamtypes.statusreporting;

import org.opencsta.servicedescription.objects.cstaparamtypes.switchingfunctionobjects.CSTAObject;

/**
 * Siemens (& other companies?) specific?? Note: Valid CSTAObjects are Stations
 * (analogue Station, digital Handsets), Trunks and UCD groups. Monitoring of
 * other objects is not provided.
 * 
 */
public abstract class MonitorObject {

	/**
     * 
     */
	protected CSTAObject csta_object;

}