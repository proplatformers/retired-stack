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


package org.opencsta.servicedescription.objects.cstaparamtypes.connectionstates;

import org.opencsta.servicedescription.common.helpers.CSTA_Base;
import org.opencsta.servicedescription.objects.cstaparamtypes.callandconnectionidentifiers.ConnectionID;
import org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers.DeviceID;

/**
 * ECMA-269 12.2.9:
 * The ConnectionList parameter type provides the linkage mechanism between a devices old connection
 * ID and new connectionID resulting form the conference or transfer.
 *
 */
public class ConnectionList extends CSTA_Base{
    
    ///////////////////////////////////////
    // associations
    
    /**
     * <p>
     *
     * </p>
     */
    private ConnectionID newConnection;
    /**
     * <p>
     *
     * </p>
     */
    private ConnectionID oldConnection;
    /**
     * <p>
     *
     * </p>
     */
    private DeviceID endPoint;
    /**
     * <p>
     *
     * </p>
     */
    private DeviceID associatedNID;
    
    /**
     *
     */
    private final String connectionListName = "\n\t* Connection List: " ;
    
    /**
     *
     */
    private final String newConnectionName = "\n\t\t*new connection: " ;
    
    /**
     *
     */
    private final String oldConnectionName = "\n\t\t*old connection: " ;
    
    /**
     *
     */
    private final String endPointName = "\n\t\t*end point: " ;
    
    /**
     *
     */
    private final String associatedNIDName = "\n\t\t*associated NID: " ;
    ///////////////////////////////////////
    // operations
    
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a ConnectionID with ...
     * </p>
     */
    public ConnectionID get_newConnection() {
        // your code here
        return newConnection;
    } // end get_newConnection
    
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
    public StringBuffer set_newConnection(StringBuffer curInStr) {
        curInStr = CheckLengthAndStrip(curInStr, 6) ;
        curInStr = newConnection.set_connectionID(curInStr) ;
        return curInStr ;
    } // end set_newConnection
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a ConnectionID with ...
     * </p>
     */
    public ConnectionID get_oldConnection() {
        // your code here
        return oldConnection;
    } // end get_oldConnection
    
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
    public StringBuffer set_oldConnection(StringBuffer curInStr) {
        curInStr = CheckLengthAndStrip(curInStr, 6) ;
        curInStr = oldConnection.set_connectionID(curInStr) ;
        return curInStr ;
    } // end set_oldConnection
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a DeviceID with ...
     * </p>
     */
    public DeviceID get_endPoint() {
        // your code here
        return endPoint;
    } // end get_endPoint
    
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
    public StringBuffer set_endPoint(StringBuffer curInStr) {
        curInStr = CheckLengthAndStrip(curInStr, 4) ;
        curInStr = endPoint.set_value(curInStr) ;
        return curInStr ;
    } // end set_endPoint
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a DeviceID with ...
     * </p>
     */
    public DeviceID get_associatedNID() {
        // your code here
        return associatedNID;
    } // end get_associatedNID
    
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
    public StringBuffer set_associatedNID(StringBuffer curInStr) {
        // your code here
        return null;
    } // end set_associatedNID
    
    /**
     *
     * @return
     * @param curInStr
     */
    public StringBuffer workString(StringBuffer curInStr){
        //cut off anything that was used prior to this (i.e. layer 7 used info)
        curInStr = CheckLengthAndStrip(curInStr, 2) ;
        
        //TEMP FIX for timestamp & global connection ID stuff
        int tmp_count = 0 ;
        while( curInStr.length() != 0 ){
            if( curInStr.charAt(0) == 0xA0 )
                curInStr = this.set_newConnection(curInStr) ;
            if( curInStr.charAt(0) == 0xA1 )
                curInStr = this.set_oldConnection(curInStr) ;
            if( curInStr.charAt(0) == 0xA2 )
                curInStr = this.set_endPoint(curInStr) ;
            
            tmp_count++ ;
            if( tmp_count > 8 )
                return curInStr ;//= new StringBuffer() ;
        }
        return curInStr ;
    }
    
    /**
     *
     */
    public String toString(){
        String str = connectionListName + newConnectionName + newConnection.toString() +
                oldConnectionName + oldConnection.toString() +
                endPointName + endPoint.toString() +
                associatedNIDName + associatedNID.toString() ;
        return str ;
    }
    
    /**
     *
     */
    public ConnectionList(){
        newConnection = new ConnectionID() ;
        oldConnection = new ConnectionID() ;
        endPoint = new DeviceID() ;
        associatedNID = new DeviceID() ;
    }
    
} // end ConnectionList



