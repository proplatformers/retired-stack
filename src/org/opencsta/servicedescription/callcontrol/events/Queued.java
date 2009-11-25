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
import org.opencsta.servicedescription.objects.cstaparamtypes.connectionstates.LocalConnectionState;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.AssociatedCalledDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.AssociatedCallingDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.CalledDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.CallingDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.RedirectionDeviceID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.SubjectDeviceID;

/**
 * <p>
 * The Queued event indicates that a call has been queued.
 * </p>
 * <p>
 * Common situations that generate this event include:
 * </p>
 * <p>
 *   - A call is queued at an ACD or hunt group device.
 * </p>
 * <p>
 *   - A call is queued (camped on or parked, for example) at a device.
 * </p>
 * </p>
 */
public class Queued extends CallEvent_Base{

  ///////////////////////////////////////
  // attributes


/**
 * <p>
 * 
 * </p>
 */
    private int numberQueued; 

   ///////////////////////////////////////
   // associations

/**
 * <p>
 * 
 * </p>
 */
    private ConnectionID queuedConnection; 
/**
 * <p>
 * 
 * </p>
 */
    private SubjectDeviceID queue; 
/**
 * <p>
 * 
 * </p>
 */
    private CallingDeviceID callingDevice; 
/**
 * <p>
 * 
 * </p>
 */
    private CalledDeviceID calledDevice; 
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
    private AssociatedCallingDeviceID associatedCallingDevice; 
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
    private LocalConnectionState localConnectionInfo; 
/**
 * <p>
 * 
 * </p>
 */
    private EventCause cause; 

    private final String eventName = "\n\t*** QUEUED ***" ;
    private final String connectionName = "\n\t*queued connection: " ;
    private final String subjectDeviceName = "\n\t*queue: " ;
    private final String numberQueuedName = "\n\t*number queued: " ;
    private final String callingDeviceName = "\n\t*calling device: " ;
    private final String calledDeviceName = "\n\t*called device: " ;
    private final String redirectionDeviceName = "\n\t*last redirection device: " ;
    private final String localConnectionStateName = "\n\t*local connection info: " ;
    private final String eventCauseName = "\n\t*cause: " ;
    private final String associatedCallingDeviceName = "\n\t*associated calling device: " ;
    private final String associatedCalledDeviceName = "\n\t*associated called device: " ;
  ///////////////////////////////////////
  // operations


/**
 * <p>
 * Does ...
 * </p>
 */
    public  Queued() {        
        queuedConnection = new ConnectionID() ;
        queue = new SubjectDeviceID() ;
        callingDevice = new CallingDeviceID() ;
        calledDevice = new CalledDeviceID() ;
        lastRedirectionDevice = new RedirectionDeviceID() ;
        localConnectionInfo = new LocalConnectionState() ;
        cause = new EventCause() ;
        associatedCallingDevice = new AssociatedCallingDeviceID() ;
        associatedCalledDevice = new AssociatedCalledDeviceID() ;
    } // end Queued        

/**
 * <p>
 * Does ...
 * </p><p>
 * 
 * @return a ConnectionID with ...
 * </p>
 */
    public ConnectionID get_queuedConnection() {        
        // your code here
        return queuedConnection;
    } // end get_queuedConnection        

/**
 * <p>
 * Does ...
 * </p><p>
 * 
 * @return a SubjectDeviceID with ...
 * </p>
 */
    public SubjectDeviceID get_queue() {        
        // your code here
        return queue;
    } // end get_queue        

/**
 * <p>
 * Does ...
 * </p><p>
 * 
 * @return a CallingDeviceID with ...
 * </p>
 */
    public CallingDeviceID get_callingDevice() {        
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
    public CalledDeviceID get_calledDevice() {        
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
 * @return a int with ...
 * </p>
 */
    public int get_numberQueued() {        
        // your code here
        return numberQueued;
    } // end get_numberQueued        

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
 * 
 * </p>
 */
    public StringBuffer set_queuedConnection(StringBuffer curInStr) {        
        curInStr = CheckLengthAndStrip(curInStr, 2) ;
        curInStr = this.queuedConnection.set_connectionID(curInStr) ;
        return curInStr;
    } // end set_queuedConnection        

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
    public StringBuffer set_queue(StringBuffer curInStr) {        
        curInStr = this.queue.set_deviceID(curInStr) ;
        return curInStr;
    } // end set_queue        

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
 * 
 * </p>
 */
    public StringBuffer set_numberQueued(StringBuffer curInStr) {        
        int length = curInStr.charAt(1) ;
        this.numberQueued = (int)curInStr.charAt(1+length) ;//usually 2
        curInStr = CheckLengthAndStrip(curInStr, 3) ;
        return curInStr ;
    } // end set_numberQueued        

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
 * Does ...
 * </p><p>
 * 
 * @return a StringBuffer with ...
 * </p><p>
 * @param curInStr ...
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

    
    public void workString(StringBuffer curInStr){
        //cut off anything that was used prior to this (i.e. layer 7 used info)
        curInStr = CheckLengthAndStrip(curInStr, 2) ;

        //TEMP FIX for timestamp & global connection ID stuff
        int tmp_count = 0 ;
        while( curInStr.length() != 0 ){
            StringContains(curInStr,"QUEUED EVENT BREAK DOWN") ;
            if( curInStr.charAt(0) == 0x6B )
                curInStr = this.set_queuedConnection(curInStr) ;
            if( curInStr.charAt(0) == 0x63 )
                curInStr = this.set_queue(curInStr) ;
            if( curInStr.charAt(0) == 0x61 )
                curInStr = this.set_callingDevice(curInStr) ;
            if( curInStr.charAt(0) == 0x62 )
                curInStr = this.set_calledDevice(curInStr) ;
            if( curInStr.charAt(0) == 0x64 )
                curInStr = this.set_lastRedirectionDevice(curInStr) ;
            if( curInStr.charAt(0) == 0x80 )
                curInStr = this.set_numberQueued(curInStr) ;
            if( curInStr.charAt(0) == 0x4E )
                curInStr = this.set_localConnectionInfo(curInStr) ;
            if( curInStr.charAt(0) == 0x0A )
                curInStr = this.set_cause(curInStr) ;
            
            tmp_count++ ;
            if( tmp_count > 8 )
                curInStr = new StringBuffer() ;
        }
    }
    
    public String toString(){
        String str = eventName + connectionName + queuedConnection.toString() +
                    subjectDeviceName + queue.toString() +
                    numberQueuedName + Integer.toString(numberQueued) +
                    callingDeviceName + callingDevice.toString() + 
                    calledDeviceName + calledDevice.toString() +
                    redirectionDeviceName + lastRedirectionDevice.toString() + 
                    localConnectionStateName + localConnectionInfo.toString() + 
                    eventCauseName + cause.toString() +
                    associatedCallingDeviceName + associatedCallingDevice.toString() +
                    associatedCalledDeviceName + associatedCalledDevice.toString() ;
        return str ;
        
    }
    
} // end Queued



