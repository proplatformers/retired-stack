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

package org.opencsta.servicedescription.callcontrol.services;

import org.opencsta.servicedescription.common.helpers.CSTA_Layer_7_Common;


/**
 *
 * @author  mylo
 */
public class CallControl_Services_SiemensHipath3000 extends CSTA_Layer_7_Common{
    
    //private Client_CSTA_Layer7 cl7;//client layer 7
    //private CSTA_Layer7 sl7 ;//server layer 7
//    CSTA_Layer_7_Common parent ;//common layer 7
    
    /**
     * Creates a new instance of CallControl_Services
     *
     *
     * @param lyr7
     */
    public CallControl_Services_SiemensHipath3000(CSTA_Layer_7_Common lyr7) {
//        this.parent = lyr7 ;
    }
    
    /**
     *
     *
     */
    public CallControl_Services_SiemensHipath3000(){
    }
    
    //public CallControl_Services(CSTA_Layer7 lyr7){
    //  this.sl7 = lyr7 ;
    //}
    
    /**
     *
     *
     *
     * @return
     * @param dev1
     * @param dev2
     */
    public StringBuffer MakeCall(String dev1, String dev2){
        char[] tmp = {INTEGER, 0x01, 0x0A} ;//SERVICE ID
        String id = new String(tmp) ;//SERVICE ID
        StringBuffer str = new StringBuffer() ;//THE CSTA STRING
        
        str = Device(str, dev2) ; //DEVICE TO
        str = Device(str, dev1) ; //DEVICE FROM
        str = Sequence(str) ;
        str = str.insert(0,id) ; //SERVICE ID
        
        //StringContains(str, "MakeCall") ;
        
        return str ;
    }
    
    /**
     *
     *
     *
     * @return
     * @param dev
     * @param str_call_id_0
     */
    public StringBuffer AnswerCall(String dev, String str_call_id_0){
        char[] id_0 = {INTEGER,0x01,0x02} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        str = Device(str, dev) ;//DEVICE ID
        str = str.insert(0,(char)str.length()).insert(0,A1) ;//LOCAL DEVICE ID COMPLETION
        
        String call_id = Call_ID_String_Correction(str_call_id_0) ;
        call_id = Call_ID(call_id) ;
        str = str.insert(0,call_id) ;
        str = Connection_ID2(str) ;
        str = Sequence(str) ;
        str = str.insert(0,id) ;
        
        //StringContains(str, "Ans Call") ;
        
        return str ;
        
    }
    
    
    /**
     *
     *
     *
     * @return
     * @param dev
     * @param str_call_id_0
     */
    public StringBuffer HoldCall(String dev, String str_call_id_0){
        char[] id_0 = {INTEGER,0x01,0x09} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        str = Device(str, dev) ;//DEVICE ID
        str = str.insert(0,(char)str.length()).insert(0,A1) ;//LOCAL DEVICE ID COMPLETION
        String call_id = Call_ID_String_Correction(str_call_id_0) ;
        call_id = Call_ID(call_id) ;
        str = str.insert(0,call_id) ;
        str = Connection_ID2(str) ;
        str = Sequence(str) ;
        str = str.insert(0,id) ;
        
        //StringContains(str, "HoldCall") ;
        
        return str ;
    }
    
    /**
     *
     *
     *
     * @return
     * @param dev
     * @param str_call_id_0
     */
    public StringBuffer RetrieveCall(String dev, String str_call_id_0){
        char[] id_0 = {INTEGER,0x01,0x0E} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        str = Device(str, dev) ;//DEVICE ID
        str = str.insert(0,(char)str.length()).insert(0,A1) ;//LOCAL DEVICE ID COMPLETION
        String call_id = Call_ID_String_Correction(str_call_id_0) ;
        call_id = Call_ID(call_id) ;
        str = str.insert(0,call_id) ;
        str = Connection_ID2(str) ;
        str = Sequence(str) ;
        str = str.insert(0,id) ;
        
        //StringContains(str, "RetrieveCall") ;
        
        return str ;
    }
    
    /**
     *
     *
     *
     * @return
     * @param deviceFrom
     * @param deviceTo
     * @param str_call_id_0
     */
    public StringBuffer SingleStepTransfer(String deviceFrom, String deviceTo, String str_call_id_0){
        char[] id_0 = {INTEGER, 0x01, 0x32} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        str = Device(str, deviceFrom) ;
        str = str.insert(0, (char)str.length() ).insert(0, (char)0xA1) ;
        String call_id = Call_ID_String_Correction(str_call_id_0) ;
        call_id = Call_ID(call_id) ;
        str = str.insert(0, call_id) ;
        str = Connection_ID2(str) ;
        StringBuffer tmp_devTo = new StringBuffer() ;
        tmp_devTo = Device(tmp_devTo, deviceTo) ;
        str = str.append(tmp_devTo) ;
        str = Sequence(str) ;
        str = str.insert(0, id) ;
        
        //StringContains(str, "SSTransfer") ;
        
        return str ;
    }
    
    /**
     *
     *
     *
     * @return
     * @param deviceFrom
     * @param deviceTo
     * @param str_call_id_0
     */
    public StringBuffer DeflectCall(String deviceFrom, String deviceTo, String str_call_id_0){
        char[] id_0 = {INTEGER, 0x02, 0x00, 0xDA} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        str = Device(str, deviceFrom) ;
        str = str.insert(0, (char)str.length() ).insert(0, (char)0xA1) ;
        String call_id = Call_ID_String_Correction(str_call_id_0) ;
        call_id = Call_ID(call_id) ;
        str = str.insert(0, call_id) ;
        str = Connection_ID2(str) ;
        StringBuffer tmp_devTo = new StringBuffer() ;
        tmp_devTo = Device(tmp_devTo, deviceTo) ;
        str = str.append(tmp_devTo) ;
        
        str = str.append( (char)0x7E ).append( (char)0x02 ).append( (char)0xA1 ).append( (char)0x00 ) ;
        
        str = Sequence(str) ;
        str = str.insert(0, id) ;
        
        //StringContains(str,"DeflectCall") ;
        
        return str ;
    }
    
    /**
     *
     *
     *
     * @return
     * @param dev
     * @param str_call_id_0
     */
    public StringBuffer ClearConnection(String dev, String str_call_id_0){
        char[] id_0 = {INTEGER,0x01,0x05} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        str = Device(str, dev) ;//DEVICE ID
        str = str.insert(0,(char)str.length()).insert(0,A1) ;//LOCAL DEVICE ID COMPLETION
        String call_id = Call_ID_String_Correction(str_call_id_0) ;
        call_id = Call_ID(call_id) ;
        str = str.insert(0,call_id) ;
        str = Connection_ID2(str) ;
        str = Sequence(str) ;
        str = str.insert(0,id) ;
        
        //StringContains(str,"ClearConnection") ;
        
        return str ;
    }
    
    /**
     *
     *
     *
     * @return
     * @param dev
     * @param str_call_id_0
     */
    public StringBuffer ClearConnection_PNA(String dev, String str_call_id_0){
        char[] id_0 = {INTEGER,0x01,0x05} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        str = Device(str, dev) ;//DEVICE ID
        str = str.insert(0,(char)str.length()).insert(0,A1) ;//LOCAL DEVICE ID COMPLETION
        String call_id = str_call_id_0 ;
        call_id = Call_ID(call_id) ;
        str = str.insert(0,call_id) ;
        str = Connection_ID2(str) ;
        str = Sequence(str) ;
        str = str.insert(0,id) ;
        
        //StringContains(str,"ClearConnection") ;
        
        return str ;
    }
    
    /**
     *
     *
     *
     * @return
     */
    public StringBuffer TDSClientRequest(){
        char[] id_0 = {0x99} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        str = str.insert(0,id) ;
        
        return str ;
    }
    
    /**
     *
     *
     *
     * @return
     * @param device
     */
    public StringBuffer MonitorStart_SI_CC_only(String device){
        char[] id_0 = {0x02, 0x01, 0x47} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        char[] longString = {0x80, 0x04, 0x06, 0x5F, 0xF4, 0x00, 0x86, 0x02, 0x03, 0x40, 0x87, 0x02, 0x06, 0x00, 0x88, 0x03, 0x05, 0x54, 0x00,
                + 0x89, 0x03, 0x02, 0xFC, 0x18, 0x83, 0x02, 0x05, 0xC0, 0x85, 0x02, 0x01, 0xC0, 0x84, 0x02, 0x07, 0x00} ;
                
                String guff = new String(longString) ;
                str = str.insert(0,guff) ;
                str = str.insert(0,(char)str.length()).insert(0,'\u00A0') ;
                str = Device(str, device) ;
                str = Sequence(str) ;
                str = str.insert(0,id) ;
                
                return str ;
                
    }
    
    /**
    *This method started as a copy of MonitorStart_SI_CC_only(String device)
    *
    *
    * @return
    * @param device
    * @param monitors
    */
    public StringBuffer MonitorStart_Proper(String device,StringBuffer[] monitors){
        char[] id_0 = {0x02, 0x01, 0x47} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
//        char[] longString = {0x80, 0x04, 0x06, 0x5F, 0xF4, 0x00, 0x86, 0x02, 0x03, 0x40, 0x87, 0x02, 0x06, 0x00, 0x88, 0x03, 0x05, 0x54, 0x00,
//                + 0x89, 0x03, 0x02, 0xFC, 0x18, 0x83, 0x02, 0x05, 0xC0, 0x85, 0x02, 0x01, 0xC0, 0x84, 0x02, 0x07, 0x00} ;
                
        //1. Need to create the monitor part of the string.
        //2. Insert 0xA0 followed by the length of (1.)
        //   e.g. sb.insert(0(char)str.length()).insert(0,'\u00A0') ;
        //3. Insert Device
        //4. Call the Sequence(sb) method
        //5. Insert id
        str = CreateMonitorPart(monitors);
        str = str.insert(0,(char)str.length()).insert(0,'\u00A0') ;
        str = Device(str, device) ;
        str = Sequence(str) ;
        str = str.insert(0,id) ;
        
        return str ;
                
    }
    /**
     *
     *
     *
     * @return
     * @param device
     */
    public StringBuffer MonitorStart2(String device){
        char[] id_0 = {0x02, 0x01, 0x47} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        char[] longString = {0x80, 0x04, 0x06, 0x00, 0x00, 0x00, 0x86, 0x02, 0x03, 0x00, 0x87, 0x02, 0x06, 0x00, 0x88, 0x03, 0x05, 0x00, 0x00,
                + 0x89, 0x03, 0x02, 0x00, 0x00, 0x83, 0x02, 0x05, 0x00, 0x85, 0x02, 0x01, 0x00, 0x84, 0x02, 0x07, 0x00} ;
                
                String guff = new String(longString) ;
                str = str.insert(0,guff) ;
                str = str.insert(0,(char)str.length()).insert(0,'\u00A0') ;
                str = Device(str, device) ;
                str = Sequence(str) ;
                str = str.insert(0,id) ;
                
                return str ;
                
    }
    
    /**
     *
     *
     *
     * @return
     * @param device
     */
    public StringBuffer MonitorRequest(String device){
        char[] id_0 = {0x47} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        str = str.insert(0,device) ;
        str = str.insert(0,id) ;
        
        return str ;
    }
    
    /**
     *
     *
     *
     * @return
     * @param device
     */
    public StringBuffer MonitorRequest_SI_CC_only(String device){
        char[] id_0 = {0x46} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        str = str.insert(0,device) ;
        str = str.insert(0,id) ;
        
        return str ;
    }
    
    /**
     *
     *
     *
     * @return
     * @param device
     */
    public StringBuffer MonitorRequest_LogicalDeviceFeatures(String device){
        char[] id_0 = {0x45} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        str = str.insert(0,device) ;
        str = str.insert(0,id) ;
        
        return str ;
    }
    
    /**
     *
     *
     *
     * @return
     * @param device
     */
    public StringBuffer MonitorRequest_HP4000_CC_only(String device){
        char[] id_0 = {0x40} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        str = str.insert(0,device) ;
        str = str.insert(0,id) ;
        
        return str ;
    }
    
    /**
     *
     *
     *
     * @return
     * @param device
     */
    public StringBuffer MonitorRequest_LogicalDeviceFeaturesAndCalls(String device){
        char[] id_0 = {0x44} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        str = str.insert(0,device) ;
        str = str.insert(0,id) ;
        
        return str ;
    }
    
    /**
     *
     *
     *
     * @return
     * @param device
     */
    public StringBuffer MonitorStart3(String device){
        char[] id_0 = {0x02, 0x01, 0x47} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        char[] longString = {0x80, 0x04, 0x06, 0x00, 0x00, 0x00, 0x86, 0x02, 0x03, 0x40, 0x87, 0x02, 0x06, 0x00, 0x88, 0x03, 0x05, 0x54, 0x00,
                + 0x89, 0x03, 0x02, 0xFC, 0x18, 0x83, 0x02, 0x05, 0xC0, 0x85, 0x02, 0x01, 0xC0, 0x84, 0x02, 0x07, 0x00} ;
                
            /*char[] longString = {0x80, 0x04, 0x06, 0x40, 0x04, 0x00, 0x86, 0x02, 0x03, 0x40, 0x87, 0x02, 0x06, 0x00, 0x88, 0x03, 0x05, 0x54, 0x00,
                            + 0x89, 0x03, 0x02, 0xFC, 0x18, 0x83, 0x02, 0x05, 0xC0, 0x85, 0x02, 0x01, 0xC0, 0x84, 0x02, 0x07, 0x00} ;
            DOES NOT LISTEN TO TRANSFER OR CONFERENCE*/
                String guff = new String(longString) ;
                str = str.insert(0,guff) ;
                str = str.insert(0,(char)str.length()).insert(0,'\u00A0') ;
                str = Device(str, device) ;
                str = Sequence(str) ;
                str = str.insert(0,id) ;
                return str ;
    }
    
    /**
     *
     *
     *
     * @return
     * @param crossRef
     */
    public StringBuffer MonitorStop(String crossRef){
        char[] id_0 = {0x02, 0x01, 0x49} ;
        String id = new String(id_0) ;
        StringBuffer str = new StringBuffer() ;
        
        str = str.insert(0, crossRef) ;
        str = str.insert(0, (char)str.length()).insert(0, (char)0x55) ;
        str = Sequence(str) ;
        str = str.insert(0,id) ;
        return str ;
    }
}
