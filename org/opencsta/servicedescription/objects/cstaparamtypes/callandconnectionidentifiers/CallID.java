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


package org.opencsta.servicedescription.objects.cstaparamtypes.callandconnectionidentifiers;

import org.opencsta.servicedescription.common.helpers.CSTA_Base;

/**
 * <p>
 * Note:  The CallID must have always a length of 2 bytes in the CSTA implementation of Hicom 150
 * </p>
 * </p>
 */
public class CallID extends CSTA_Base{
    
    ///////////////////////////////////////
    // attributes
    
    
    /**
     * <p>
     * Represents ...
     * </p>
     */
    private String value;
    
    
    ///////////////////////////////////////
    // operations
    
    
    /**
     * <p>
     * Does ...
     * </p><p>
     *
     * @param call_id ...
     * </p>
     */
    public  CallID(String call_id) {
        this.value = call_id ;
    } // end CallID
    
    /**
     *
     */
    public CallID(){
    }
    
    /**
     *
     */
    public String get_value(){
        return value ;
    }
    
    /**
     *
     * @return
     * @param curInStr
     */
    public StringBuffer set_value(StringBuffer curInStr){
        int length = (int)curInStr.charAt(1) ;
        this.value = curInStr.substring(2, (2+length)) ;
        curInStr = CheckLengthAndStrip(curInStr, (2+length)) ;
        return curInStr ;
    }
    
    /**
     *
     * @return
     */
    public String toString(){
        String str = toLegibleString(value) ;
        return str ;
    }
    
    /**
     *
     * @return
     * @param str
     */
    public String toLegibleString(String str){
        try{
            StringBuffer sb = new StringBuffer() ;
            for(int i = 0 ; i < str.length() ; i++){
                String tmp = Integer.toHexString(str.charAt(i)) ;
                if( tmp.length() == 1 )
                    sb = sb.append("0").append(tmp) ;
                else
                    sb = sb.append(tmp) ;
            }
            str = sb.toString() ;
            return str ;
        }catch(NullPointerException e){
            return "null" ;
        }
    }
    
    /**
     * used in asterisk integration
     *
     *@return
     */
    public String set_callID(){
        int length = this.value.length() ;
        char[] ar_callid = {0x80, (char)length} ;
        return ( (new String( ar_callid) + this.value ) ) ;
    }
} // end CallID



