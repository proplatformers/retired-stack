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
package org.opencsta.servicedescription.objects.cstaparamtypes.otherparameters;

/**
 * ECMA-269 12.2.5: The CallLinkageData parameter type contains globally unique
 * information that is used to associated CSTA calls that are linked by a
 * switchign function because of the way that a call was created or manipulated.
 * For example, a call that is created as teh result of the CSTA Consultation
 * Call service (consulted call) may be linked to the call placed on hold at the
 * consultation device by the CallLinkageData parameter type. The
 * CallLinkageData parameter type can also be used to correlate calls in
 * different switchign sub-domains with teh same "end-to-end" or "global" call.
 * This definition goes on for a bit so check out the standard if you wanna know
 * more...
 * 
 */
public class CallLinkageID {
}
