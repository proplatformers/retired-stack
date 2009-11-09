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

package org.opencsta.servicedescription.logicaldevicefeatures.services;


import org.opencsta.servicedescription.common.helpers.CSTA_Layer_7_Common;

/**
 * This class is used for Logical device features setting and getting
 *
 */
public class LogicalDeviceFeatures_Services extends CSTA_Layer_7_Common{
    
    /**
     *
     *
     */
    CSTA_Layer_7_Common parent ;//common layer 7
    
    /**
     * Creates a new instance of LogicalDeviceFeatures_Services
     *
     *
     * @param lyr7 The layer 7 that calls for these services
     */
    public LogicalDeviceFeatures_Services(CSTA_Layer_7_Common lyr7) {
        this.parent = lyr7 ;
    }
    
    /**
     * Not used
     *
     */
    public LogicalDeviceFeatures_Services(){
    }
    
    
    /**
     * The getAgentState service provides the agent state at a specified device
     *
     *
     * @return
     * @param dev the device to query
     */
    public StringBuffer getAgentState(String dev){
        char[] tmp = {INTEGER, 0x02, 0x01, 0x30} ;//SERVICE ID
        String id = new String(tmp) ;//SERVICE ID
        StringBuffer str = new StringBuffer() ;//THE CSTA STRING
        
        str = Device(str, dev) ; //DEVICE WHERE AGENT IS AT
        str = Sequence(str) ;
        str = str.insert(0,id) ; //SERVICE ID
        
        //StringContains(str, "MakeCall") ;
        
        return str ;
    }
    
    /**
     * The setAgentState service requests a new agent state at a specified device.  In
     * the case where an ACD agent is involved with an ACD call, the transition to the requested
     * state may or may not occur until the current connection transitions to the null state.
     *
     *
     * @return
     * @param dev specifies the device id for the acd agent for which the state is to be changed.  The device may also be an acd device or an acd group device if allowed by the switching function, as indicated by the capability exchange services
     * @param agentID specifies the agent id; used for agent login
     * @param requestedAgentState specifies the requested agent state.  the complete set of possible values are:
     * - loggedOn, requests that the agent be logged on.
     * - loggedOff, requestss that the agent be logged off.
     * - notReady, requests that the agent be placed into the notReady agent state.
     * - ready, requests that the agent be placed into the ready state.
     * - workingAfterCall, requests that the agent be placed into the workingAfterCall state
     */
    public StringBuffer setAgentState(String dev, String agentID, int requestedAgentState){
        //requested states are:
        //0 - agent log on
        //1 - agent log off
        //2 - agent not ready
        //3 - agent ready
        //4 - agent working
        char[] tmp = {INTEGER, 0x02, 0x01, 0x38} ;//SERVICE ID
        String id = new String(tmp) ;//SERVICE ID
        StringBuffer str = new StringBuffer() ;//THE CSTA STRING
        
        str = Agent(str, agentID) ; //AGENT-ID
        str = str.insert(0, (char)requestedAgentState).insert(0,(char)0x01).insert(0,(char)0x0A) ;
        str = Device(str, dev) ;
        str = Sequence(str) ;
        str = str.insert(0,id) ; //SERVICE ID
        
        //StringContains(str, "MakeCall") ;
        
        return str ;
    }
    
    /**
     * The getDoNotDisturb service provides the do not disturb feature status at a specified
     * device.  The do not disturb feature is used to prevent incoming calls at a device.
     *
     *
     * @return
     * @param dev specifies the device id of the device on which the do not disturb feature is being queried
     */
    public StringBuffer getDoNotDisturb(String dev){
        char[] tmp = {INTEGER, 0x02, 0x01, 0x34} ;//SERVICE ID
        String id = new String(tmp) ;//SERVICE ID
        StringBuffer str = new StringBuffer() ;//THE CSTA STRING
        
        str = Device(str, dev) ; //DEVICE WHERE DND QUERY DIRECTED
        str = Sequence(str) ;
        str = str.insert(0,id) ; //SERVICE ID
        
        //StringContains(str, "MakeCall") ;
        
        return str ;
    }
    
    /**
     * This service allows the computing function to control the do not disturb feature
     * at a specified device.  The do not disturb feature is typically used to prevent a
     * specified device from being alerted.
     *
     *
     * @return
     * @param dev the device on which to set the feature
     * @param on FALSE = DND is not enabled.  TRUE = it is
     */
    public StringBuffer setDoNotDisturb(String dev, boolean on){
        char[] tmp = {INTEGER, 0x02, 0x01, 0x3C} ;//SERVICE ID
        String id = new String(tmp) ;//SERVICE ID
        StringBuffer str = new StringBuffer() ;//THE CSTA STRING
        
        char setit ;
        
        if( on )
            setit = 0xFF ;
        else
            setit = 0x00 ;
        
        str = str.insert(0,setit).insert(0,0x01).insert(0,0x01) ;
        str = Device(str, dev) ; //DEVICE DND DIRECTED
        str = Sequence(str) ;
        str = str.insert(0,id) ; //SERVICE ID
        
        //StringContains(str, "MakeCall") ;
        
        return str ;
    }
    
    //THIS FUNCTION PROVES THAT THE SERVER _NEEDS TO_ SEND THE CLIENT AN
    //ACKNOWLEDGEMENT OF RECEIVING A REQUEST, BECAUSE THE RESULT OF THIS FUCNTION
    //ONLY GIVES THE DESTINATION NUMBER.
    //FOR EXAMPLE, IF WE SEND TWO SEPARATE getForwarding() REQUESTS, AND GET THE
    //RESULTS IN ORDER OR OUT OF ORDER, WE WON'T KNOW WHICH DEVICE IS DIRECTED TO
    //WHICH FORWARDING NUMBER BECAUSE WE DON'T HAVE ANY REFERENCE.
    //SO TO HAVE A REFERENCE, THE SERVER CAN SEND EACH CLIENT THE INVOKE_ID OF THEIR
    //REQUEST, SO WHEN THEY RECEIVE THE COMPLETE RESULT FROM THE PABX VIA THE SERVER
    //THEY CAN THEN DETERMINE WHAT THE RESULT IS FOR, AS WELL AS IMPROVING
    //CLIENT/SERVER COMMUNICATIONS
    /**
     * The getForwarding service provides the forwarding feature status at a specified
     * device.  The status returned may consist of one or more forwarding types that are
     * active at the specified device based on user defined conditions.
     * The forwarding feature is used to redirect calls that arrive at a specified device
     * to an alternate destination.
     *
     *
     * @return
     * @param dev specifies the device on which to query
     */
    public StringBuffer getForwarding(String dev){
        char[] tmp = {INTEGER, 0x02, 0x01, 0x35} ;//SERVICE ID
        String id = new String(tmp) ;//SERVICE ID
        StringBuffer str = new StringBuffer() ;//THE CSTA STRING
        
        str = Device(str, dev) ; //DEVICE WHERE FORWARDING QUERY DIRECTED
        str = Sequence(str) ;
        str = str.insert(0,id) ; //SERVICE ID
        
        //StringContains(str, "MakeCall") ;
        
        return str ;
    }
    
    /**
     * This service allows the computing function to control the forwarding feature
     * at a specified device based on user defined conditions.  The forwarding feature
     * is used to redirect calls that arrive at a specified device to an alternate destination.
     * This service allows only one user-specified setting (forwarding type/forward-dest
     * combination) to be changed per service invocation.
     *
     *
     * @return
     * @param deviceFrom the device from
     * @param forwardType the type of forwarding
     * - forwardImmediate
     * - forwardImmInt
     * - forwardImmExt
     * This parameter shall be provided for user specified forwarding setting sand shall not be provided for switching function default settings.
     * @param on status of forwarding type: FALSE, deactivate forwarding.  TRUE, activate forwarding
     * @param deviceTo the device to which new calls are forwarded.  Not specified for switfching function default settings.
     */
    public StringBuffer setForwarding(String deviceFrom, int forwardType, boolean on, String deviceTo){
        char[] tmp = {INTEGER, 0x02, 0x01, 0x3D} ;//SERVICE ID
        String id = new String(tmp) ;//SERVICE ID
        StringBuffer str = new StringBuffer() ;//THE CSTA STRING
        
        char setit ;
        if( on )
            setit = 0xFF ;
        else
            setit = 0x00 ;
        
        str = Device(str, deviceTo) ; //DEVICE WHERE FORWARDING DIRECTED
        str = str.insert(0,setit).insert(0,0x01).insert(0,0x01) ;
        str = str.insert(0,(char)forwardType).insert(0,0x01).insert(0,0x0A) ;
        str = Device(str, deviceFrom) ;
        str = Sequence(str) ;
        str = str.insert(0,id) ; //SERVICE ID
        
        //StringContains(str, "MakeCall") ;
        
        return str ;
    }
    
    /**
     * The getAutoWorkMode service provides the auto-work mode feature status at a
     * specified device.
     * The auto-work feature is used to automatically transition an agent state to the WorkingAfterCall
     * state (from the Busy state) after an agent is finished with a call.  The feature may
     * also automatically transition the agent stat from WorkingAfterCall (to Ready, for
     * example) after a certain amount of time.
     *
     *
     * @return
     * @param dev specifies the device id of the device on which the auto-work mode status is being queried.  The device id may refer to an acd device, acd group, or to an agent
     */
    public StringBuffer getAutoWorkMode(String dev){
        char[] tmp = {INTEGER, 0x02, 0x01, 0x32} ;//SERVICE ID
        String id = new String(tmp) ;//SERVICE ID
        StringBuffer str = new StringBuffer() ;//THE CSTA STRING
        
        str = Device(str, dev) ; //DEVICE WHERE AUTO-WORK-MODE QUERY DIRECTED
        str = Sequence(str) ;
        str = str.insert(0,id) ; //SERVICE ID
        
        //StringContains(str, "MakeCall") ;
        
        return str ;
    }
    
    /**
     * The getAutoAnswer service provides the auto-answer feature status at a specified device.
     * The auto-answer feature is used to automatically connect to (answer) a call
     * when it arrives at a device, without manual intervention (AICC headset mode).
     * The service specifies the number of rings at the device before the device is
     * auto-answered.
     *
     *
     * @return
     * @param dev specifies the device id of the device on which the auto-answer status is being queried
     */
    public StringBuffer getAutoAnswer(String dev){
        char[] tmp = {INTEGER, 0x02, 0x01, 0x31} ;//SERVICE ID
        String id = new String(tmp) ;//SERVICE ID
        StringBuffer str = new StringBuffer() ;//THE CSTA STRING
        
        str = Device(str, dev) ; //DEVICE WHERE AUTO-WORK-MODE QUERY DIRECTED
        str = Sequence(str) ;
        str = str.insert(0,id) ; //SERVICE ID
        
        //StringContains(str, "MakeCall") ;
        
        return str ;
    }
    
    /**
     * The getCallerIDStatus service provides the caller id status at the specified device.
     * When the status is set to TRUE, the device's caller id will be provided on all calls
     * originating from it.  When the status is set to FALSE, the switching function will not provide
     * the device's caller id on calls, which originate from it, to the called device.
     *
     *
     * @return
     * @param dev specifies the device id of the device on which the caller id status feature is being queried
     */
    public StringBuffer getCallerIDStatus(String dev){
        char[] tmp = {INTEGER, 0x02, 0x01, 0x33} ;//SERVICE ID
        String id = new String(tmp) ;//SERVICE ID
        StringBuffer str = new StringBuffer() ;//THE CSTA STRING
        
        str = Device(str, dev) ; //DEVICE WHERE CALLER_ID-STATUS QUERY DIRECTED
        str = Sequence(str) ;
        str = str.insert(0,id) ; //SERVICE ID
        
        //StringContains(str, "MakeCall") ;
        
        return str ;
    }
    
    /**
     * This service sets the caller id status at the specified device.  When the status is set
     * to TRUE, the device's caller id will be provided on all calls originating from it.  When the
     * status is set to FALSE, the switching function will not provide the device's caller id on
     * calls, which originate from it to the called device
     *
     *
     * @return
     * @param dev device to query
     * @param on set to true or false...
     */
    public StringBuffer setCallerIDStatus(String dev, boolean on){
        char[] tmp = {INTEGER, 0x02, 0x01, 0x3B} ;//SERVICE ID
        String id = new String(tmp) ;//SERVICE ID
        StringBuffer str = new StringBuffer() ;//THE CSTA STRING
        
        char setit ;
        
        if( on )
            setit = 0xFF ;
        else
            setit = 0x00 ;
        
        str = str.insert(0,setit).insert(0,0x01).insert(0,0x01) ;
        str = Device(str, dev) ; //DEVICE DND DIRECTED
        str = Sequence(str) ;
        str = str.insert(0,id) ; //SERVICE ID
        
        //StringContains(str, "MakeCall") ;
        
        return str ;
    }
    
}