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

package org.opencsta.servicedescription.callcontrol.services.testing;

import org.junit.Test;
import org.opencsta.servicedescription.callcontrol.services.CallControl_Services_SiemensHipath3000;

import static org.junit.Assert.*;

/**
 * @author chrismylonas
 * 
 */
public class CallControl_Services_SiemensHipath3000Test {

	/**
	 * 
	 */
	public static final int ID_MAKE_CALL = 0x0a;

	/**
	 * 
	 */
	public static final int ID_ANSWER_CALL = 0x02;

	/**
	 * 
	 */
	public static final int ID_HOLD_CALL = 0x09;

	/**
	 * 
	 */
	public static final int ID_RETRIEVE_CALL = 0x0E;

	/**
	 * 
	 */
	public static final int ID_SINGLE_STEP_TRANSFER = 0x32;

	/**
	 * 
	 */
	public static final int ID_DEFLECT_CALL = 0xDA;
	
	/**
	 * 
	 */
	public static final int ID_CONNECTION_CLEARED = 0x05;
	
	/**
	 * 
	 */
	public static final int ID_MONITOR_START = 0x47;
	
	/**
	 * 
	 */
	public static final int ID_MONITOR_STOP = 0x49 ;

	/**
	 * 
	 */
	@Test
	public void test_MakeCall() {
		CallControl_Services_SiemensHipath3000 cc = new CallControl_Services_SiemensHipath3000();
		StringBuffer sb = cc.MakeCall("100", "200");
		for (int i = 0; i < sb.length(); i++) {
			System.out.print(" " + Integer.toHexString(sb.charAt(i)));
		}
		System.out.println("Test: ID_MAKE_CALL is equal");
		assertEquals(ID_MAKE_CALL, sb.charAt(2));
		System.out.println("Test: make call has a length");
		assertTrue(cc.MakeCall("100", "200").length() > 0);
	}
}
