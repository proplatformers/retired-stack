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

package org.opencsta.servicedescription.callcontrol.services.interfaces;

/**
 *
 * @author cm
 */
public interface ICallControl_Services {
    /**
     * @param dev1
     * @param dev2
     * @return
     */
    public StringBuffer MakeCall(String dev1, String dev2);
    
    /**
     * @param dev
     * @param str_call_id_0
     * @return
     */
    public StringBuffer AnswerCall(String dev, String str_call_id_0) ;
    
    /**
     * @param dev
     * @param str_call_id_0
     * @return
     */
    public StringBuffer HoldCall(String dev, String str_call_id_0) ;
    
    /**
     * @param dev
     * @param str_call_id_0
     * @return
     */
    public StringBuffer RetrieveCall(String dev, String str_call_id_0) ;
    
    /**
     * @param deviceFrom
     * @param deviceTo
     * @param str_call_id_0
     * @return
     */
    public StringBuffer SingleStepTransfer(String deviceFrom, String deviceTo, String str_call_id_0) ;//blind transfer
    
    /**
     * @param deviceFrom
     * @param deviceTo
     * @param str_call_id_0
     * @return
     */
    public StringBuffer DeflectCall(String deviceFrom, String deviceTo, String str_call_id_0) ;
    
    /**
     * @param dev
     * @param str_call_id_0
     * @return
     */
    public StringBuffer ClearConnection(String dev, String str_call_id_0) ;
    
    /**
     * @param device
     * @return
     */
    public StringBuffer MonitorStart(String device) ;
    
    /**
     * @param crossRef
     * @return
     */
    public StringBuffer MonitorStop(String crossRef) ;
}
