/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.opencsta.servicedescription.logicaldevicefeatures.services;

/**
 *
 * @author cm
 */
public interface LogicalDeviceFeatures_Services {
    public StringBuffer getAgentState(String dev) ;
    public StringBuffer setAgentState(String dev, String agentID, int requestedAgentState) ;
    public StringBuffer getDoNotDisturb(String dev) ;
    public StringBuffer setDoNotDisturb(String dev, boolean on) ;
    public StringBuffer getForwarding(String dev) ;
    public StringBuffer setForwarding(String deviceFrom, int forwardType, boolean on, String deviceTo) ;
    public StringBuffer getAutoWorkMode(String dev) ;
    public StringBuffer getAutoAnswer(String dev) ;
    public StringBuffer getCallerIDStatus(String dev) ;
    public StringBuffer setCallerIDStatus(String dev, boolean on) ;
}
