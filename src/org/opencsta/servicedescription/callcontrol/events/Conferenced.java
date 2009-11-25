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


package org.opencsta.servicedescription.callcontrol.events;

import org.opencsta.servicedescription.objects.cstaparamtypes.EventCause;
import org.opencsta.servicedescription.objects.cstaparamtypes.callandconnectionidentifiers.ConnectionID;
import org.opencsta.servicedescription.objects.cstaparamtypes.connectionstates.ConnectionList;
import org.opencsta.servicedescription.objects.cstaparamtypes.connectionstates.LocalConnectionState;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.SubjectDeviceID;

import java.util.* ;

/**
 * The Conferenced event indicates that the conferencing device has conferenced itself or
 * another device with an existing call and that no devices have been removed from the
 * resulting call.
 * Common situations that generate this event include:
 * - Two step conferencing situations (manual and service initiated)
 * - Single step conferencing situations (manual and service initiated)
 * The conferenced event provides the local view of connections and the primaryOldCall is reused.
 * After establishing the conference the primaryOldCall is reused
 *
 */
public class Conferenced extends CallEvent_Base{
    
    ///////////////////////////////////////
    // associations
    
    /**
     * Specifies the device ID of the conferencing device
     *
     */
    private SubjectDeviceID conferencingDevice;
    
    /**
     * Specifies the device ID of the last device added to the call
     *
     */
    private SubjectDeviceID addedParty;
    
    /**
     * <p>
     *
     * </p>
     *
     *
     */
    private List conferenceConnections;
    
    /**
     * Specifies the connection of the primary call.
     *
     */
    private ConnectionID primaryOldCall;
    
    /**
     * Specifies the connection of the secondary call.  If the switching function supports the "fixed-view" option (as indicated by the capabilities
     * exchange services), this parameter is mandatory.
     * If the switching function supports the "local-view" option, this parameter is mandatory if there are two known calls involved
     * with the conference (before the conference is created) from the perspective of the monitored device, otherwise it shall not be provided.
     *
     */
    private ConnectionID secondaryOldCall;
    
    /**
     * Specifies the local connection state of the device associated with the Monitor Cross Reference ID.  The following are the states of
     * the devices that are in the conference call:
     * - Conferencing device - Connected
     * - Other devices - ......
     * This parameter is mandatory for events generated for device-type monitors and otherwise shall not be provided.
     *
     */
    private LocalConnectionState localConnectionInfo;
    
    /**
     * Spcifies the reason for the event.  Supported causes are:
     * - Active participation
     * - conference
     * - silent participation
     *
     */
    private EventCause cause;
    
    /**
     *
     *
     */
    private final String eventName = "\n\t*** CONFERENCED ***" ;
    
    /**
     *
     *
     */
    private final String primaryOldCallName = "\n\t*primary old call: " ;
    
    /**
     *
     *
     */
    private final String secondaryOldCallName = "\n\t*secondary old call: " ;
    
    /**
     *
     *
     */
    private final String subjectDevice1Name = "\n\t*conferencing device: " ;
    
    /**
     *
     *
     */
    private final String subjectDevice2Name = "\n\t*added party: " ;
    
    /**
     *
     *
     */
    private final String connectionListName = "\n\t*connection list: " ;
    
    /**
     *
     *
     */
    private final String localConnectionStateName = "\n\t*local connection info: " ;
    
    /**
     *
     *
     */
    private final String eventCauseName = "\n\t*cause: " ;
    ///////////////////////////////////////
    // operations
    
    
    /**
     * <p>
     * Does ...
     * </p>
     *
     *
     *
     * @return a ConnectionID with ...
     */
    public ConnectionID get_primaryOldCall() {
        // your code here
        return primaryOldCall;
    } // end get_primaryOldCall
    
    /**
     * <p>
     * Does ...
     * </p>
     *
     *
     *
     * @return a StringBuffer with ...
     * @param curInStr ...
     */
    public StringBuffer set_primaryOldCall(StringBuffer curInStr) {
        curInStr = CheckLengthAndStrip(curInStr, 4) ;
        curInStr = this.primaryOldCall.set_connectionID(curInStr) ;
        return curInStr;
    } // end set_primaryOldCall
    
    /**
     * <p>
     * Does ...
     * </p>
     *
     *
     *
     * @return a ConnectionID with ...
     */
    public ConnectionID get_secondaryOldCall() {
        // your code here
        return secondaryOldCall;
    } // end get_secondaryOldCall
    
    /**
     * <p>
     * Does ...
     * </p>
     *
     *
     *
     * @return a StringBuffer with ...
     * @param curInStr ...
     */
    public StringBuffer set_secondaryOldCall(StringBuffer curInStr) {
        curInStr = CheckLengthAndStrip(curInStr, 4) ;
        curInStr = this.secondaryOldCall.set_connectionID(curInStr) ;
        return curInStr;
    } // end set_secondaryOldCall
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a SubjectDeviceID with ...
     * </p>
     */
    public SubjectDeviceID get_conferencingDevice() {
        // your code here
        return conferencingDevice;
    } // end get_conferencingDevice
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a StringBuffer with ...
     * </p><p>
     * @param curInStr ...
     * </p>
     */
    public StringBuffer set_conferencingDevice(StringBuffer curInStr) {
        curInStr = this.conferencingDevice.set_deviceID(curInStr) ;
        return curInStr;
    } // end set_conferencingDevice
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a SubjectDeviceID with ...
     * </p>
     */
    public SubjectDeviceID get_addedParty() {
        // your code here
        return addedParty;
    } // end get_addedParty
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a StringBuffer with ...
     * </p><p>
     * @param curInStr ...
     * </p>
     */
    public StringBuffer set_addedParty(StringBuffer curInStr) {
        curInStr = this.addedParty.set_deviceID(curInStr) ;
        return curInStr;
    } // end set_addedParty
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a ConnectionList with ...
     * </p>
     */
    public List get_conferenceConnections() {
        // your code here
        return conferenceConnections;
    } // end get_conferenceConnections
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a StringBuffer with ...
     * </p><p>
     * @param curInStr ...
     * </p>
     */
    public StringBuffer set_conferenceConnections(StringBuffer curInStr) {
        curInStr = CheckLengthAndStrip(curInStr, 2) ;
        while( curInStr.charAt(0) == 0x30 ){
            ConnectionList connectionList = new ConnectionList() ;
            curInStr = connectionList.workString(curInStr) ;
            conferenceConnections.add(connectionList) ;
        }
        return curInStr;
    } // end set_conferenceConnections
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a LocalConnectionState with ...
     * </p>
     */
    public LocalConnectionState get_localConnectionInfo() {
        // your code here
        return localConnectionInfo;
    } // end get_localConnectionInfo
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a StringBuffer with ...
     * </p><p>
     * @param curInStr ...
     * </p>
     */
    public StringBuffer set_localConnectionInfo(StringBuffer curInStr) {
        curInStr = this.localConnectionInfo.set_value(curInStr) ;
        return curInStr;
    } // end set_localConnectionInfo
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a EventCause with ...
     * </p>
     */
    public EventCause get_cause() {
        // your code here
        return cause;
    } // end get_cause
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a StringBuffer with ...
     * </p><p>
     * @param curInStr ...
     * </p>
     */
    public StringBuffer set_cause(StringBuffer curInStr) {
        curInStr = this.cause.set_value(curInStr) ;
        return curInStr;
    } // end set_cause
    
    /**
     *
     *
     */
    public String connectionListToString(){
        String str = new String() ;
        for( int i = 0 ; i < conferenceConnections.size() ; i++ ){
            str += (String)conferenceConnections.get(i).toString() ;
        }
        return str ;
    }
    
    /**
     *
     *
     */
    public String toString(){
        String str = eventName + primaryOldCallName + primaryOldCall.toString() +
                secondaryOldCallName + secondaryOldCall.toString() +
                subjectDevice1Name + conferencingDevice.toString() +
                subjectDevice2Name + addedParty.toString() +
                connectionListName + connectionListToString() +
                localConnectionStateName + localConnectionInfo.toString() +
                eventCauseName + cause.toString() ;
        
        return str ;
    }
    
    /**
     *
     *
     */
    public Conferenced(){
        primaryOldCall = new ConnectionID() ;
        secondaryOldCall = new ConnectionID() ;
        conferencingDevice = new SubjectDeviceID() ;
        addedParty = new SubjectDeviceID() ;
        conferenceConnections = Collections.synchronizedList(new LinkedList());
        localConnectionInfo = new LocalConnectionState() ;
        cause = new EventCause() ;
    }
    
} // end Conferenced



