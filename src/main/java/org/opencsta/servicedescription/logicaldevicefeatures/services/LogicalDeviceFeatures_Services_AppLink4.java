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

package org.opencsta.servicedescription.logicaldevicefeatures.services;

/**
 * 
 * @author chrismylonas
 */
public class LogicalDeviceFeatures_Services_AppLink4 implements
		LogicalDeviceFeatures_Services {

	/**
     * 
     */
	public LogicalDeviceFeatures_Services_AppLink4() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.logicaldevicefeatures.services.
	 * LogicalDeviceFeatures_Services#getAgentState(java.lang.String)
	 */
	public StringBuffer getAgentState(String dev) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.logicaldevicefeatures.services.
	 * LogicalDeviceFeatures_Services#setAgentState(java.lang.String,
	 * java.lang.String, int)
	 */
	public StringBuffer setAgentState(String dev, String agentID,
			int requestedAgentState) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.logicaldevicefeatures.services.
	 * LogicalDeviceFeatures_Services#getDoNotDisturb(java.lang.String)
	 */
	public StringBuffer getDoNotDisturb(String dev) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.logicaldevicefeatures.services.
	 * LogicalDeviceFeatures_Services#setDoNotDisturb(java.lang.String, boolean)
	 */
	public StringBuffer setDoNotDisturb(String dev, boolean on) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.logicaldevicefeatures.services.
	 * LogicalDeviceFeatures_Services#getForwarding(java.lang.String)
	 */
	public StringBuffer getForwarding(String dev) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.logicaldevicefeatures.services.
	 * LogicalDeviceFeatures_Services#setForwarding(java.lang.String, int,
	 * boolean, java.lang.String)
	 */
	public StringBuffer setForwarding(String deviceFrom, int forwardType,
			boolean on, String deviceTo) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.logicaldevicefeatures.services.
	 * LogicalDeviceFeatures_Services#getAutoWorkMode(java.lang.String)
	 */
	public StringBuffer getAutoWorkMode(String dev) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.logicaldevicefeatures.services.
	 * LogicalDeviceFeatures_Services#getAutoAnswer(java.lang.String)
	 */
	public StringBuffer getAutoAnswer(String dev) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.logicaldevicefeatures.services.
	 * LogicalDeviceFeatures_Services#getCallerIDStatus(java.lang.String)
	 */
	public StringBuffer getCallerIDStatus(String dev) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opencsta.servicedescription.logicaldevicefeatures.services.
	 * LogicalDeviceFeatures_Services#setCallerIDStatus(java.lang.String,
	 * boolean)
	 */
	public StringBuffer setCallerIDStatus(String dev, boolean on) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
