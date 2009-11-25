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
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.SubjectDeviceID;

/**
 * <p>
 * The Held event indicates that a call has been placed on hold.
 * </p>
 * <p>
 * Common situations that generate this event include:
 * </p>
 * <p>
 *   - Consultation situations (manual and service initated)
 * </p>
 * <p>
 *   - Hold situations (manual and service initated).
 * </p>
 * </p>
 */
public class Held extends CallEvent_Base{

   ///////////////////////////////////////
   // associations

/**
 * <p>
 * 
 * </p>
 */
    private ConnectionID heldConnection; 
/**
 * <p>
 * 
 * </p>
 */
    private SubjectDeviceID holdingDevice; 
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

    private final String eventName = "\n\t*** HELD ***" ;
    private final String connectionName = "\n\t*held connection: " ;
    private final String subjectDeviceName = "\n\t*holding device: " ;
    private final String localConnectionStateName = "\n\t*local connection info: " ;
    private final String eventCauseName = "\n\t*cause: " ;

  ///////////////////////////////////////
  // operations


/**
 * <p>
 * 
 * </p>
 */
    public  Held() {        
        heldConnection = new ConnectionID() ;
        holdingDevice = new SubjectDeviceID() ;
        localConnectionInfo = new LocalConnectionState() ;
        cause = new EventCause() ;
    } // end Held        

/**
 * <p>
 * Does ...
 * </p><p>
 * 
 * @return a ConnectionID with ...
 * </p>
 */
    public ConnectionID get_heldConnection() {        
        // your code here
        return heldConnection;
    } // end get_heldConnection        

/**
 * <p>
 * Does ...
 * </p><p>
 * 
 * @return a SubjectDeviceID with ...
 * </p>
 */
    public SubjectDeviceID get_holdingDevice() {        
        // your code here
        return holdingDevice;
    } // end get_holdingDevice        

/**
 * <p>
 * 
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
 * @return a StringBuffer with ...
 * </p><p>
 * @param curInStr ...
 * </p>
 */
    public StringBuffer set_heldConnection(StringBuffer curInStr) {        
        curInStr = CheckLengthAndStrip(curInStr, 4) ;
        curInStr = this.heldConnection.set_connectionID(curInStr) ;
        return curInStr;
    } // end set_heldConnection        

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
    public StringBuffer set_holdingDevice(StringBuffer curInStr) {        
        curInStr = this.holdingDevice.set_deviceID(curInStr) ;
        return curInStr;
    } // end set_holdingDevice        

/**
 * <p>
 * 
 * </p>
 */
    public StringBuffer set_localConnectionInfo(StringBuffer curInStr) {        
        curInStr = this.localConnectionInfo.set_value(curInStr) ;
        return curInStr;
    } // end set_localConnectionInfo        

/**
 * <p>
 * 
 * </p>
 */
    public StringBuffer set_cause(StringBuffer curInStr) {        
        curInStr = this.cause.set_value(curInStr) ;
        return curInStr;
    } // end set_cause        

    public void workString(StringBuffer curInStr){
        //cut off anything that was used prior to this (i.e. layer 7 used info)
        curInStr = CheckLengthAndStrip(curInStr, 2) ;

        //TEMP FIX for timestamp & global connection ID stuff
        int tmp_count = 0 ;
        while( curInStr.length() != 0 ){
            if( curInStr.charAt(0) == 0x6B )
                curInStr = this.set_heldConnection(curInStr) ;
            if( curInStr.charAt(0) == 0x63 )
                curInStr = this.set_holdingDevice(curInStr) ;
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
        String str = eventName + connectionName + heldConnection.toString() +
                    subjectDeviceName + holdingDevice.toString() +
                    localConnectionStateName + localConnectionInfo.toString() + 
                    eventCauseName + cause.toString() ;
        return str ;
        
    }
} // end Held



