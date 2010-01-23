/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.opencsta.servicedescription.logicaldevicefeatures.services;

/**
 *
 * @author cm
 */
public class LogicalDeviceFeatures_Services_AppLink4 implements LogicalDeviceFeatures_Services{

    public LogicalDeviceFeatures_Services_AppLink4(){
        
    }

    public StringBuffer getAgentState(String dev) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StringBuffer setAgentState(String dev, String agentID, int requestedAgentState) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StringBuffer getDoNotDisturb(String dev) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StringBuffer setDoNotDisturb(String dev, boolean on) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StringBuffer getForwarding(String dev) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StringBuffer setForwarding(String deviceFrom, int forwardType, boolean on, String deviceTo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StringBuffer getAutoWorkMode(String dev) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StringBuffer getAutoAnswer(String dev) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StringBuffer getCallerIDStatus(String dev) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StringBuffer setCallerIDStatus(String dev, boolean on) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
