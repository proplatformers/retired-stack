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


import org.opencsta.servicedescription.common.AgentEvent;
import org.opencsta.servicedescription.common.helpers.CSTAEvent;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.DeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.SubjectDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.otherparameters.AgentID;

/**
 * <p>
 *
 * </p>
 */
public abstract class AgentEvent_Base extends CSTAEvent implements AgentEvent{
    
    ///////////////////////////////////////
    // attributes
    
    
    /**
     * <p>
     * Represents ...
     * </p>
     */
    protected SubjectDeviceID agentDevice;
    
    /**
     * <p>
     * Represents ...
     * </p>
     */
    protected AgentID agentID;
    
    /**
     * <p>
     * Represents ...
     * </p>
     */
    protected DeviceID acdGroup;
    
    /**
     *
     *
     */
//    private final String eventName = "\n\t*** DELIVERED ***" ;
    
    /**
     *
     *
     */
//    private final String subjectDeviceName = "\n\t*agent device: " ;
    
    /**
     *
     *
     */
//    private final String agentIDName = "\n\t*agent id: " ;
    
    /**
     *
     *
     */
//    private final String deviceName = "\n\t*acdGroup: " ;
    ///////////////////////////////////////
    // operations
    
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a SubjectDeviceID with ...
     * </p>
     */
    public SubjectDeviceID getAgentDevice() {
        return agentDevice;
    } // end getAgentDevice
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * </p><p>
     *
     * @param curInStr ...
     * </p>
     */
    public StringBuffer setAgentDevice(StringBuffer curInStr) {
        curInStr = this.agentDevice.set_deviceID(curInStr) ;
        return curInStr;
    } // end setAgentDevice
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a AgentID with ...
     * </p>
     */
    public AgentID getAgentID() {
        return agentID;
    } // end getAgentID
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * </p><p>
     *
     * @param curInStr ...
     * </p>
     */
    public StringBuffer setAgentID(StringBuffer curInStr) {
        curInStr = this.agentID.setValue(curInStr) ;
        return curInStr ;
    } // end setAgentID
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a DeviceID with ...
     * </p>
     */
    public DeviceID getAcdGroup() {
        return acdGroup;
    } // end getAcdGroup
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * </p><p>
     *
     * @param _acdGroup ...
     * </p>
     */
    public void setAcdGroup() {
    } // end setAcdGroup
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * </p><p>
     *
     * @param curInStr ...
     * </p>
     */
    public void workString(StringBuffer curInStr) {
        //cut off anything that was used prior to this (i.e. layer 7 used info)
        curInStr = CheckLengthAndStrip(curInStr, 2) ;
        
        //TEMP FIX for timestamp & global connection ID stuff
        int tmp_count = 0 ;
        while( curInStr.length() != 0 ){
            if( curInStr.charAt(0) == 0x63 )
                curInStr = this.setAgentDevice(curInStr) ;
            if( curInStr.charAt(0) == 0x04 )
                curInStr = this.setAgentID(curInStr) ;
            if( curInStr.charAt(0) == 0x82 )
                curInStr = this.setAgentID(curInStr) ;
            
            tmp_count++ ;
            if( tmp_count > 8 )
                curInStr = new StringBuffer() ;
        }
    } // end workEvent
    
    /**
     * <p>
     * Does ...
     * </p>
     */
    public  AgentEvent_Base() {
        
        agentDevice = new SubjectDeviceID() ;
        agentID = new AgentID() ;
        acdGroup = new DeviceID() ;
    } // end AgentEvent
    
} // end AgentEvent



