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

public class AgentLoggedOff extends AgentEvent_Base {
    
    /**
     *
     *
     */
    private final String eventName = "\n\t*** AGENT LOGGED OFF ***" ;
    
    /**
     *
     *
     */
    private final String subjectDeviceName = "\n\t*agent device: " ;
    
    /**
     *
     *
     */
    private final String agentIDName = "\n\t*agent id: " ;
    /**
     *
     *
     */
    
    private final String deviceName = "\n\t*acdGroup: " ;
    
    /**
     *
     *
     */
    public String toString(){
        String str = eventName + subjectDeviceName + agentDevice.toString() +
                agentIDName + agentID.toString() +
                deviceName + acdGroup.toString() ;
        return str ;
        
    }
    
} // end AgentLoggedOff



