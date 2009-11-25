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


import org.opencsta.servicedescription.logicaldevicefeatures.events.AgentEvent_Base;
import org.opencsta.servicedescription.logicaldevicefeatures.events.AgentLoggedOff;
import org.opencsta.servicedescription.logicaldevicefeatures.events.AgentLoggedOn;
import org.opencsta.servicedescription.logicaldevicefeatures.events.AgentNotReady;
import org.opencsta.servicedescription.logicaldevicefeatures.events.AgentReady;
import org.opencsta.servicedescription.logicaldevicefeatures.events.AgentWorkingAfterCall;

/**
 *
 *
 *
 * @author mylo
 */
public class LogicalDeviceFeatureEventHandler extends CSTA_Base{
    
    /**
     *
     *
     */
    private AgentEvent_Base currentEvent ;
    
    /**
     * Creates a new instance of EventHandler
     *
     */
    public LogicalDeviceFeatureEventHandler() {
    }
    
    /**
     *
     *
     *
     * @return
     * @param curInStr
     */
    public AgentEvent_Base WorkEvent(StringBuffer curInStr){
        
        switch (curInStr.charAt(0)){
            case 0xA1:
                currentEvent = new AgentLoggedOn() ;
                currentEvent.workString(curInStr) ;
                //System.out.println("Conferenced Event") ;
                break ;
            case 0xA2:
                currentEvent = new AgentLoggedOff() ;
                currentEvent.workString(curInStr) ;
                //System.out.println("Conferenced Event") ;
                break ;
            case 0xA3:
                currentEvent = new AgentNotReady() ;
                currentEvent.workString(curInStr) ;
                //ConnectionCleared(curInStr, xRef) ;
                break ;
            case 0xA4:
                currentEvent = new AgentReady() ;
                currentEvent.workString(curInStr) ;
                //DeliveredEvent(curInStr, xRef) ;
                break ;
            case 0xA5:
                currentEvent = new AgentWorkingAfterCall() ;
                currentEvent.workString(curInStr) ;
                //System.out.println("Diverted Event") ;
                break ;
        }
        
        return currentEvent ;
        
    }
    
    
}