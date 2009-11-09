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

/**
 * ECMA-269 12.2.17: This parameter type describes the connection state of the device associated with the Monitor Cross Reference ID.
 * This parameter type is only applicable for events generated by device-type monitors.
 * Format:
 * This parameter type shall contain one of the following connection states:
 * - alerting
 * - connected
 * - fail
 * - hold
 * - initiated
 * - null
 * - queued
 *
 */
public class LocalConnectionState extends CSTA_Base{
    
    ///////////////////////////////////////
    // attributes
    
    
    /**
     * <p>
     * Represents ...
     * </p>
     */
    private char value ;
    
    
    ///////////////////////////////////////
    // operations
    
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @param localConnectionState ...
     * </p>
     */
    public  LocalConnectionState(char localConnectionState) {
        this.value = localConnectionState ;
    } // end LocalConnectionState
    
    /**
     * <p>
     * Does ...
     * </p>
     */
    public  LocalConnectionState() {
        // your code here
    } // end LocalConnectionState
    
    /**
     * used in asterisk integration
     *
     * @param _state
     */
    public LocalConnectionState(String _state){
        System.out.println("_SEPT 05: asterisk SI's localconnectioninfo") ;
        this.value = StringToChar(_state) ;
    }
    
    /**
     * used in asterisk integration
     *
     * @return
     * @param str
     */
    public char StringToChar(String str){
        char ch = 0;
        if( str.equals("null") )
            ch = 0x00 ;
        if( str.equals("initiated") )
            ch = 0x01 ;
        return ch ;
    }
    
    /**
     * used in asterisk integration
     *
     * @return
     */
    public String set_localConnectionState(){
        char[] ar_lci = {0x4E,0x01, this.get_value() } ;
        return (new String(ar_lci)) ;
    }
    
    /**
     * used in asterisk integration
     *
     * @return
     * @param curInStr
     */
    public StringBuffer set_value(StringBuffer curInStr){
        int length = curInStr.charAt(1) ;
        this.value = curInStr.charAt(1+length) ;//usually 2
        curInStr = CheckLengthAndStrip(curInStr, 3) ;
        return curInStr ;
    }
    
    /**
     * used in asterisk integration
     *
     * @return
     */
    public char get_value(){
        return value ;
    }
    
    /**
     * used in asterisk integration
     *
     * @return
     */
    public String toString(){
        String str = new String() ;
        switch (value){
            case 0x00:
                str = "null" ;
                break ;
            case 0x01:
                str = "initiated" ;
                break ;
            case 0x02:
                str = "alerting" ;
                break ;
            case 0x03:
                str = "connected" ;
                break ;
            case 0x04:
                str = "hold" ;
                break ;
            case 0x05:
                str = "queued" ;
                break ;
            case 0x06:
                str = "fail" ;
                break ;
        }
        return str ;
    }
} // end LocalConnectionState



