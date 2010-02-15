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
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.AssociatedCalledDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.AssociatedCallingDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.CalledDeviceID_EricssonAppLink4;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.CallingDeviceID_EricssonAppLink4;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.RedirectionDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.SubjectDeviceID_EricssonAppLink4;

/**
 * <p>
 * The Failed event indicates that a call cannot be completed or a connection has entered the Fail state.
 * </p>
 * </p>
 */
public class Failed_EricssonAppLink4 extends CallEvent_Base{
    
    ///////////////////////////////////////
    // associations
    
    /**
     * <p>
     *
     * </p>
     */
    private ConnectionID_EricssonAppLink4 failedConnection;
    /**
     * <p>
     *
     * </p>
     */
    private SubjectDeviceID_EricssonAppLink4 failingDevice;
    /**
     * <p>
     *
     * </p>
     */
    private CallingDeviceID_EricssonAppLink4 callingDevice;
    /**
     * <p>
     *
     * </p>
     */
    private CalledDeviceID_EricssonAppLink4 calledDevice;
    /**
     * <p>
     *
     * </p>
     */
    private RedirectionDeviceID lastRedirectionDevice;
    /**
     * <p>
     *
     * </p>
     */
    private AssociatedCalledDeviceID associatedCalledDevice;
    /**
     * <p>
     *
     * </p>
     */
    private AssociatedCallingDeviceID associatedCallingDevice;
    /**
     * <p>
     *
     * </p>
     */
    private EventCause cause;
    /**
     * <p>
     *
     * </p>
     */
    private LocalConnectionState localConnectionInfo;
    
    
    /**
     *
     */
    private final String eventName = "\n\t*** FAILED APPLINK4***" ;
    
    /**
     *
     */
    private final String connectionName = "\n\t*failed connection: " ;
    
    /**
     *
     */
    private final String subjectDeviceName = "\n\t*failing device: " ;
    
    /**
     *
     */
    private final String callingDeviceName = "\n\t*calling device: " ;
    
    /**
     *
     */
    private final String calledDeviceName = "\n\t*called device: " ;
    
    /**
     *
     */
    private final String redirectionDeviceName = "\n\t*last redirection device: " ;
    
    /**
     *
     */
    private final String localConnectionStateName = "\n\t*local connection info: " ;
    
    /**
     *
     */
    private final String eventCauseName = "\n\t*cause: " ;
    
    /**
     *
     */
    private final String associatedCallingDeviceName = "\n\t*associated calling device: " ;
    
    /**
     *
     */
    private final String associatedCalledDeviceName = "\n\t*associated called device: " ;
    ///////////////////////////////////////
    // operations
    
    
    /**
     * <p>
     *
     * </p>
     */
    public  Failed_EricssonAppLink4() {
        failedConnection = new ConnectionID_EricssonAppLink4() ;
        failingDevice = new SubjectDeviceID_EricssonAppLink4() ;
        callingDevice = new CallingDeviceID_EricssonAppLink4() ;
        calledDevice = new CalledDeviceID_EricssonAppLink4() ;
        lastRedirectionDevice = new RedirectionDeviceID() ;
        localConnectionInfo = new LocalConnectionState() ;
        cause = new EventCause() ;
        associatedCallingDevice = new AssociatedCallingDeviceID() ;
        associatedCalledDevice = new AssociatedCalledDeviceID() ;
    } // end Failed
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a ConnectionID with ...
     * </p>
     */
    public ConnectionID_EricssonAppLink4 get_failedConnection() {
        // your code here
        return failedConnection;
    } // end get_failedConnection
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a SubjectDeviceID with ...
     * </p>
     */
    public SubjectDeviceID_EricssonAppLink4 get_failingDevice() {
        // your code here
        return failingDevice;
    } // end get_failingDevice
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a CallingDeviceID with ...
     * </p>
     */
    public CallingDeviceID_EricssonAppLink4 get_callingDevice() {
        // your code here
        return callingDevice;
    } // end get_callingDevice
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a CalledDeviceID with ...
     * </p>
     */
    public CalledDeviceID_EricssonAppLink4 get_calledDevice() {
        // your code here
        return calledDevice;
    } // end get_calledDevice
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a RedirectionDeviceID with ...
     * </p>
     */
    public RedirectionDeviceID get_lastRedirectionDevice() {
        // your code here
        return lastRedirectionDevice;
    } // end get_lastRedirectionDevice
    
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
     * @return a AssociatedCallingDeviceID with ...
     * </p>
     */
    public AssociatedCallingDeviceID get_associatedCallingDevice() {
        // your code here
        return associatedCallingDevice;
    } // end get_associatedCallingDevice
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a AssociatedCalledDeviceID with ...
     * </p>
     */
    public AssociatedCalledDeviceID get_associatedCalledDevice() {
        // your code here
        return associatedCalledDevice;
    } // end get_associatedCalledDevice
    
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
    public StringBuffer set_failedConnection(StringBuffer curInStr) {
        curInStr = CheckLengthAndStrip(curInStr, 2) ;
        curInStr = this.failedConnection.set_connectionID(curInStr) ;
        return curInStr;
    } // end set_failedConnection
    
    /**
     * <p>
     *
     * </p>
     */
    public StringBuffer set_failingDevice(StringBuffer curInStr) {
        curInStr = CheckLengthAndStrip(curInStr, 2) ;
        curInStr = this.failingDevice.set_deviceID(curInStr) ;
        return curInStr;
    } // end set_failingDevice
    
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
    public StringBuffer set_callingDevice(StringBuffer curInStr) {
        curInStr = CheckLengthAndStrip(curInStr, 2) ;
        curInStr = this.callingDevice.set_deviceID(curInStr) ;
        return curInStr;
    } // end set_callingDevice
    
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
    public StringBuffer set_calledDevice(StringBuffer curInStr) {
        curInStr = CheckLengthAndStrip(curInStr, 2) ;
        curInStr = this.calledDevice.set_deviceID(curInStr) ;
        return curInStr;
    } // end set_calledDevice
    
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
    public StringBuffer set_lastRedirectionDevice(StringBuffer curInStr) {
        curInStr = this.lastRedirectionDevice.set_deviceID(curInStr) ;
        return curInStr;
    } // end set_lastRedirectionDevice
    
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
     * <p>
     *
     * </p>
     */
    public StringBuffer set_associatedCallingDevice(StringBuffer curInStr) {
        curInStr = this.associatedCallingDevice.set_deviceID(curInStr) ;
        return curInStr;
    } // end set_associatedCallingDevice
    
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
    public StringBuffer set_associatedCalledDevice(StringBuffer curInStr) {
        curInStr = this.associatedCalledDevice.set_deviceID(curInStr) ;
        return curInStr;
    } // end set_associatedCalledDevice
    
    /**
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
                curInStr = this.set_failedConnection(curInStr) ;
            if( curInStr.charAt(0) == 0x63 )
                curInStr = this.set_failingDevice(curInStr) ;
            if( curInStr.charAt(0) == 0x61 )
                curInStr = this.set_callingDevice(curInStr) ;
            if( curInStr.charAt(0) == 0x62 )
                curInStr = this.set_calledDevice(curInStr) ;
            if( curInStr.charAt(0) == 0x64 )
                curInStr = this.set_lastRedirectionDevice(curInStr) ;
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
     */
    public String toString(){
        String str = eventName + connectionName + failedConnection.toString() +
                subjectDeviceName + failingDevice.toString() +
                callingDeviceName + callingDevice.toString() +
                calledDeviceName + calledDevice.toString() +
                redirectionDeviceName + lastRedirectionDevice.toString() +
                localConnectionStateName + localConnectionInfo.toString() +
                eventCauseName + cause.toString() +
                associatedCallingDeviceName + associatedCallingDevice.toString() +
                associatedCalledDeviceName + associatedCalledDevice.toString() ;
        return str ;
        
    }
} // end Failed



