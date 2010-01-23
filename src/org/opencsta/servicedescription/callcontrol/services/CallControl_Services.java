/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.opencsta.servicedescription.callcontrol.services;

/**
 *
 * @author cm
 */
public interface CallControl_Services {
    public StringBuffer MakeCall(String dev1, String dev2);
    public StringBuffer AnswerCall(String dev, String str_call_id_0) ;
    public StringBuffer HoldCall(String dev, String str_call_id_0) ;
    public StringBuffer RetrieveCall(String dev, String str_call_id_0) ;
    public StringBuffer SingleStepTransfer(String deviceFrom, String deviceTo, String str_call_id_0) ;//blind transfer
    public StringBuffer DeflectCall(String deviceFrom, String deviceTo, String str_call_id_0) ;
    public StringBuffer ClearConnection(String dev, String str_call_id_0) ;
    public StringBuffer MonitorStart(String device) ;
    public StringBuffer MonitorStop(String crossRef) ;
}
