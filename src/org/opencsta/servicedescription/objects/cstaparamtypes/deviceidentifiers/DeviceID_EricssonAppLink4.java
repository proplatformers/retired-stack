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

package org.opencsta.servicedescription.objects.cstaparamtypes.deviceidentifiers;

import org.opencsta.servicedescription.objects.cstaparamtypes.switchingfunctionobjects.CSTAObject;

/**
 * ECMA-269 12.3.11:  Identifies or represents a device.
 *
 */
public class DeviceID_EricssonAppLink4 extends CSTAObject{
    ///////////////////////////////////////
    // attributes
    
    
    /**
     * <p>
     * device_id variable is...
     * </p>
     * </p>
     */
    protected String value;
    
    
    ///////////////////////////////////////
    // operations
    
    
    /**
     * <p>
     *
     * </p>
     */
    public  DeviceID_EricssonAppLink4(String device_id) {
        value = device_id ;
    } // end DeviceID
    
    public DeviceID_EricssonAppLink4(){
        value = "null" ;
    }
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @return a String with ...
     * </p>
     */
    public String get_value() {
        // your code here
        return value;
    } // end get_device_id
    
    public String getValue(){
        return value ;
    }
    /**
     * <p>
     *
     * </p>
     */
    public StringBuffer set_value(StringBuffer curInStr) {
        int length = (int)curInStr.charAt(1) ;
        this.value = curInStr.substring(2, (2+length)) ;
        curInStr = CheckLengthAndStrip(curInStr, (2+length)) ;
        return curInStr ;
    } // end set_device_id
    
    public String toString(){
        return value ;
    }
    
    //asterisk
    public String set_deviceID(){
        int length = this.value.length() ;
        char[] ar_devid = {0x80, (char)length} ;
        return ( (new String( ar_devid) + this.value ) ) ;
    }
    
} // end DeviceID



