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

package org.opencsta.servicedescription.common.helpers;

/**
 * @author chrismylonas
 * 
 */
public abstract class CSTA_Layer_7_Common extends CSTA_Base {

	/**
     *
     *
     */
	private static Object parent;

	/**
     *
     *
     */
	private String xRef;

	/**
     *
     *
     */
	private String invoke_id_ref;

	/**
     *
     *
     */
	protected CallEventHandler callEventHandler;

	/**
     *
     *
     */
	protected LogicalDeviceFeatureEventHandler logicalDeviceFeatureEventHandler;

	/**
	 * Creates a new instance of CSTA_Layer_7_Common
	 * 
	 */
	public CSTA_Layer_7_Common() {
	}

	/**
	 * 
	 * 
	 * @deprecated
	 * @return
	 * @param str
	 */
	public String Call_ID_String_Correction(String str) {
		return str;
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 * @param str
	 */
	public String toLegibleString(String str) {
		StringBuffer sb = new StringBuffer();
		System.out.println(Integer.toHexString(str.charAt(0))
				+ Integer.toHexString(str.charAt(1)));
		for (int i = 0; i < str.length(); i++) {
			String tmp = Integer.toHexString(str.charAt(i));
			if (tmp.length() == 1)
				sb = sb.append("0").append(tmp);
			else
				sb = sb.append(tmp);
		}
		str = sb.toString();
		return str;
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 * @param sb
	 */
	public StringBuffer Connection_ID2(StringBuffer sb) {
		int length = sb.length();
		sb = sb.insert(0, (char) length).insert(0, SEQUENCE)
				.insert(0, (char) (length + 2)).insert(0, CONN_ID);
		return sb;
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 * @param call_id_0
	 */
	public String Call_ID(String call_id_0) {
		int length = call_id_0.length();
		char[] ch_1 = { DEVICE, (char) length };
		String call_id = new String(ch_1);
		call_id = call_id + call_id_0;
		System.out.println("length call_id:"
				+ Integer.toString(call_id.length()) + ":\n\t");
		for (int i = 0; i < call_id.length(); i++)
			System.out.println(Integer.toHexString(call_id.charAt(i)));
		return call_id;
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 * @param sb
	 * @param dev
	 */
	public StringBuffer Device(StringBuffer sb, String dev) {
		int length = dev.length();
		sb = sb.insert(0, dev).insert(0, (char) length).insert(0, DEVICE)
				.insert(0, (char) (length + 2)).insert(0, SEQUENCE);
		return sb;
	}

	public StringBuffer PhaseI_Device(StringBuffer sb, String dev) {
		int length = dev.length();
		sb = sb.insert(0, dev).insert(0, (char) length).insert(0, '\u0080');
		return sb;
	}

	public StringBuffer PhaseI_62(StringBuffer sb) {
		int length = sb.length();
		sb = sb.insert(0, (char) length).insert(0, PHASEI_62);
		return sb;
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 * @param sb
	 * @param agentID
	 */
	public StringBuffer Agent(StringBuffer sb, String agentID) {
		int length = agentID.length();
		sb = sb.insert(0, agentID).insert(0, (char) length).insert(0, AGENT);
		return sb;
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 * @param sb
	 */
	public StringBuffer Sequence(StringBuffer sb) {
		return sb = sb.insert(0, (char) sb.length()).insert(0, SEQUENCE);
	}

	public StringBuffer CreateMonitorPart(StringBuffer[] monitors) {
		StringBuffer str = new StringBuffer();

		// char[] longString = {0x80, 0x04, 0x06, 0x5F, 0xF4, 0x00, 0x86, 0x02,
		// 0x03, 0x40, 0x87, 0x02, 0x06, 0x00, 0x88, 0x03, 0x05, 0x54, 0x00,
		// + 0x89, 0x03, 0x02, 0xFC, 0x18, 0x83, 0x02, 0x05, 0xC0, 0x85, 0x02,
		// 0x01, 0xC0, 0x84, 0x02, 0x07, 0x00} ;

		for (int i = 0; i < monitors.length; i++) {
			str = CreateMonitorBitSet(i, monitors[i]);
		}

		return str;
	}

	private StringBuffer CreateMonitorBitSet(int i, StringBuffer monitorBitSet) {
		StringBuffer str = new StringBuffer();
		switch (i) {
		case 0:// CALLCONTROL
		case 1:// CALL
		case 2:
		case 3:
		case 4:
		case 5:
		}

		return str;
	}

	/**
	 * @return the invoke_id_ref
	 */
	public/**
			 *
			 *
			 */
	String getInvoke_id_ref() {
		return invoke_id_ref;
	}

	/**
	 * @param invoke_id_ref
	 *            the invoke_id_ref to set
	 */
	public void setInvoke_id_ref(String invoke_id_ref) {
		this.invoke_id_ref = invoke_id_ref;
	}
}
