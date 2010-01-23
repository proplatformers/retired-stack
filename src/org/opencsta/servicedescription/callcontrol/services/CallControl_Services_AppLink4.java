/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.opencsta.servicedescription.callcontrol.services;

import org.opencsta.servicedescription.common.helpers.CSTA_Layer_7_Common;

/**
 *
 * @author cm
 */
public class CallControl_Services_AppLink4  extends CSTA_Layer_7_Common implements CallControl_Services{


    public CallControl_Services_AppLink4() {

    }


    //A1 16 02 01 06 02 01 0A 30 0E 80 04 31 31 34 34 62 06 80 04 31 31 30 36
    public StringBuffer MakeCall(String dev1, String dev2) {
        char[] tmp = {INTEGER, 0x01, 0x0A} ;//SERVICE ID
        String id = new String(tmp) ;//SERVICE ID
        StringBuffer str = new StringBuffer() ;//THE CSTA STRING

        str = PhaseI_Device(str, dev2) ; //DEVICE TO
        str = PhaseI_62(str) ;
        str = PhaseI_Device(str, dev1) ; //DEVICE FROM
        str = Sequence(str) ;
        str = str.insert(0,id) ; //SERVICE ID
        return str ;
    }

    public StringBuffer AnswerCall(String dev, String str_call_id_0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StringBuffer HoldCall(String dev, String str_call_id_0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StringBuffer RetrieveCall(String dev, String str_call_id_0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StringBuffer SingleStepTransfer(String deviceFrom, String deviceTo, String str_call_id_0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StringBuffer DeflectCall(String deviceFrom, String deviceTo, String str_call_id_0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StringBuffer ClearConnection(String dev, String str_call_id_0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //A1 0E 02 01 01 02 01 47 30 06 80 04 31 31 34 34
    public StringBuffer MonitorStart(String device) {
        char[] tmp = {INTEGER, 0x01, 0x47} ;//SERVICE ID
        String id = new String(tmp) ;//SERVICE ID
        StringBuffer str = new StringBuffer() ;//THE CSTA STRING

        str = PhaseI_Device(str,device) ;
        str = Sequence(str) ;
        str = str.insert(0, id) ;

        return str ;
    }

    public StringBuffer MonitorStop(String crossRef) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
