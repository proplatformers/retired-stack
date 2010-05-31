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
