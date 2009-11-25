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

import org.opencsta.servicedescription.common.CallEvent;
import org.opencsta.servicedescription.common.helpers.CSTAEvent;

public abstract class CallEvent_Base extends CSTAEvent implements CallEvent{
    
    
    /**
     * Creates a new instance of Base_Event_Class
     *
     */
    public CallEvent_Base() {
    }
    
    
    /**
     *
     *
     *
     * @return
     * @param str
     */
    public String Call_ID_String_Correction(String str) {
        try{
//            int i ;
            StringBuffer foo = new StringBuffer() ;
            for( int j = 0 ; j < str.length() ; j++ ){
                if( (int)str.charAt(j) < 10 )
                    foo = foo.append(0).append( Integer.toHexString( str.charAt(j) ) );
                else
                    foo = foo.append( Integer.toHexString( str.charAt(j) ) ) ;
            }
            
            String call_id = new String(foo) ;
            return call_id ;
        }catch(NullPointerException e){
            return "" ;
        }
    }

    /**
     *
     *
     *
     * @param curInStr
     */
    public void workString(StringBuffer curInStr){
    }
}
