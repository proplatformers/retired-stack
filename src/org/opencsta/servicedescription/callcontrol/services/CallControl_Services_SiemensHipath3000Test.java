package org.opencsta.servicedescription.callcontrol.services;

import org.junit.Test;
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
