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

package org.opencsta.servicedescription.physicaldevicefeatures.services;

import org.opencsta.servicedescription.common.helpers.CSTA_Layer_7_Common;

/**
 * For doing things to buttons, lamps and displays.
 * 
 * 
 * @author chrismylonas
 */
public class PhysicalDeviceFeatures_Services_SiemensHipath3000 extends
		CSTA_Layer_7_Common implements PhysicalDeviceFeatures_Services {

	/**
	 * Creates a new instance of PhysicalDeviceFeatures_Services
	 * 
	 */
	public PhysicalDeviceFeatures_Services_SiemensHipath3000() {
	}

	/**
	 * The SetDisplay service allows the computing function to set a display
	 * associated with a deice. The capabilities exchange services can be used
	 * to determine the number of displays associated with a device.
	 * 
	 * 
	 * @return
	 * @param dev
	 *            the devices physical element
	 * @param text
	 *            The text to place on the display as a string of characters
	 *            consisting of the text on eahch row of the display including
	 *            spaces concatenated together. If null or of length 0 (""),
	 *            then the display will be cleared.
	 * @param beep
	 *            If this boolean is true, on message arrival the device will
	 *            beep. If false, no audible alert is executed.
	 */
	public StringBuffer SetDisplay(String dev, String text, boolean beep) {
		char[] id_0 = { INTEGER, 0x02, 0x01, 0x12 };
		String id = new String(id_0);
		StringBuffer str = new StringBuffer();

		str = Device(str, dev);// DEVICE ID
		str = Display(str, text, beep);
		str = Sequence(str);
		str = str.insert(0, id);
		return str;
	}

	/**
	 * A helper method for SetDisplay. This sets the CSTA string up.
	 * 
	 * 
	 * @return
	 * @param sb
	 *            The already partly formed CSTA string that is sent to the pbx
	 *            for the service
	 * @param text
	 *            If "" or null, then it is converted to 0x7E and length is
	 *            equal to one and it forms the part of the string that
	 *            describes the viewable text (including spaces).
	 * @param beep
	 *            The audible alert boolean.
	 */
	public StringBuffer Display(StringBuffer sb, String text, boolean beep) {
		int length = (int) text.length();
		if (text.equals("") || text == null) {
			length = 1;
			sb = sb.append((char) 0x16).append((char) length)
					.append((char) 0x7F);
			return sb;
		}
		if (beep) {
			length++;
			sb = sb.append((char) 0x16).append((char) length)
					.append((char) 0x07).append(text);
		} else {
			sb = sb.append((char) 0x16).append((char) length).append(text);
		}
		return sb;
	}

}
