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
import org.opencsta.servicedescription.objects.cstaparamtypes.callandconnectionidentifiers.ConnectionID_EricssonAppLink4;
import org.opencsta.servicedescription.objects.cstaparamtypes.connectionstates.LocalConnectionState;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.SubjectDeviceID_EricssonAppLink4;

/**
 * <p>
 * The ConnectionCleared event indicates that a single device has disconnected or dropped out of a call.
 * </p>
 * <p>
 * Common situations that generate this event include:
 * </p>
 * <p>
 * - A user manually terminates the call (by going on-hook, for example).
 * </p>
 * <p>
 * - The Clear Connection service is successfully invoked.
 * </p>
 * <p>
 * - Connection cleras as a result of some other services operation.
 * </p>
 * </p>
 *
 *
 */
public class ConnectionCleared_EricssonAppLink4 extends CallEvent_Base{
    
    ///////////////////////////////////////
    // associations
    
    /**
     * <p>
     *
     * </p>
     */
    private ConnectionID_EricssonAppLink4 droppedConnection;
    /**
     * <p>
     *
     * </p>
     */
    private SubjectDeviceID_EricssonAppLink4 releasingDevice;
    /**
     * <p>
     *
     * </p>
     */
    private LocalConnectionState localConnectionInfo;
    /**
     * <p>
     *
     * </p>
     */
    private EventCause cause;
    
    private final String eventName = "\n\t*** CONNECTION CLEARED APPLINK4***" ;
    private final String connectionName = "\n\t*dropped connection: " ;
    private final String subjectDeviceName = "\n\t*releasing device: " ;
    private final String localConnectionStateName = "\n\t*local connection info: " ;
    private final String eventCauseName = "\n\t*cause: " ;
    ///////////////////////////////////////
    // operations
    
    
    /**
     * <p>
     * Does ...
     * </p>
     */
    public  ConnectionCleared_EricssonAppLink4() {
        droppedConnection = new ConnectionID_EricssonAppLink4() ;
        releasingDevice = new SubjectDeviceID_EricssonAppLink4() ;
        localConnectionInfo = new LocalConnectionState() ;
        cause = new EventCause() ;
    } // end ConnectionCleared
    
    //asterisk
    public ConnectionCleared_EricssonAppLink4(String _ext, String _call_id, String _time){
        //do nothing with the time until we have it done from the siemens
        //and then reverse the process for asterisk
        System.out.println("_SEPT 05: New ConnectionCleared") ;
        cause = new EventCause("normalClearing") ;//new call = 0x16/22
        localConnectionInfo = new LocalConnectionState("null") ;
        releasingDevice = new SubjectDeviceID_EricssonAppLink4(_ext) ;
        droppedConnection = new ConnectionID_EricssonAppLink4(_call_id,_ext) ;
        StringBuffer sb = workString() ;
        for( int i = 0 ; i < sb.length() ; i++)
            System.out.print( " " + Integer.toHexString( sb.charAt(i) )) ;
    }
    
    //asterisk
    public StringBuffer workString(){
        StringBuffer _sb = new StringBuffer() ;
        _sb = _sb.append( set_droppedConnection() ) ;
        _sb = _sb.append( set_initiatingDevice() ) ;
        _sb = _sb.append( set_localConnectionInfo() ) ;
        _sb = _sb.append( set_cause() );
        
        //_sb = _sb.append(0x63).append(0x07).append(0x30).append(0x05).append(0x80).append(0x03).append( initiatingDevice.get_deviceID().getValue() ) ;
        return _sb ;
    }
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a ConnectionID with ...
     * </p>
     */
    public ConnectionID_EricssonAppLink4 get_droppedConnection() {
        // your code here
        return null;
    } // end get_droppedConnection
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a DeviceID with ...
     * </p>
     */
    public SubjectDeviceID_EricssonAppLink4 get_releasingDevice() {
        // your code here
        return null;
    } // end get_releasingDevice
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a DeviceID with ...
     * </p>
     */
    public LocalConnectionState get_localConnectionInfo() {
        // your code here
        return null;
    } // end get_localConnectionInfo
    
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
        return null;
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
    public StringBuffer set_droppedConnection(StringBuffer curInStr) {
        curInStr = CheckLengthAndStrip(curInStr, 2) ;
        curInStr = this.droppedConnection.set_connectionID(curInStr) ;
        return curInStr;
    } // end set_droppedConnection
    
    //asterisk
    public String set_droppedConnection(){
        return ( droppedConnection.set_connectionID() );
    }
    
    //asterisk
    public String set_cause(){
        return cause.set_cause() ;
    }
    
    //asterisk
    public String set_localConnectionInfo(){
        return localConnectionInfo.set_localConnectionState() ;
    }
    
    //asterisk
    public String set_initiatingDevice(){
        return ( releasingDevice.set_deviceID() ) ;
    }
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
    public StringBuffer set_releasingDevice(StringBuffer curInStr) {
        curInStr = CheckLengthAndStrip(curInStr, 2) ;
        curInStr = this.releasingDevice.set_deviceID(curInStr) ;
        return curInStr;
    } // end set_releasingDevice
    
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
    public void workString(StringBuffer curInStr){
        //cut off anything that was used prior to this (i.e. layer 7 used info)
        curInStr = CheckLengthAndStrip(curInStr, 1) ;
        
        //TEMP FIX for timestamp & global connection ID stuff
        int tmp_count = 0 ;
        while( curInStr.length() != 0 ){
            if( curInStr.charAt(0) == 0x30 ){
                curInStr = CheckLengthAndStrip(curInStr, 2) ;
            }
            if( curInStr.charAt(0) == 0x6B )
                curInStr = this.set_droppedConnection(curInStr) ;
            if( curInStr.charAt(0) == 0x63 )
                curInStr = this.set_releasingDevice(curInStr) ;
            if( curInStr.charAt(0) == 0x4E )
                curInStr = this.set_localConnectionInfo(curInStr) ;
            if( curInStr.length() > 0 ){
                if( curInStr.charAt(0) == 0x0A ){
                    curInStr = this.set_cause(curInStr) ;
                }
            }
            tmp_count++ ;
            if( tmp_count > 8 )
                curInStr = new StringBuffer() ;
        }
    }
    
    /**
     *
     *
     */
    public String toString(){
        String str = eventName +
                connectionName + droppedConnection.toString() +
                subjectDeviceName + releasingDevice.toString() +
                localConnectionStateName + localConnectionInfo.toString() +
                eventCauseName + cause.toString() ;
        return str ;
        
    }
    
} // end ConnectionCleared



