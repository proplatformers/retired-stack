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
 * ECMA-269 12.3.15:  The IOCrossRefID parameter type identifies each I/O data path.  The computing function receives a
 * IOCrossRefIDin each I/O service request.  The Start Data Path service initiates an I/O data path.  The
 * IOCrossRefIDis only valid for the duration of the data path.
 * The IOCrossRefID is unique within the I/O registration.  Some switching functions may provide the additional
 * benefit of a unique IOCrossRefID across the entire switching sub-domain.  This is
 * also the case if I/O registration is not supported by the switching function.
 * The parameter type also specifies if the switchign function or the computing function started the data path.
 * 
 */
public class IOCrossRefID {
 }
