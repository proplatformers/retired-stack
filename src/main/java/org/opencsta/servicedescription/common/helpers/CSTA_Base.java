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
public abstract class CSTA_Base {

	/**
     *
     *
     */
	public char DLE = '\u0010';

	/**
     *
     *
     */
	public char STX = '\u0002';

	/**
     *
     *
     */
	public char ETX = '\u0003';

	/**
     *
     *
     */
	public char ENQ = '\u0005';

	/**
     *
     *
     */
	public char NAK = '\u0015';

	/**
     *
     *
     */
	public char INTEGER = '\u0002';

	/**
     *
     *
     */
	public char SEQUENCE = '\u0030';

	/**
     *
     *
     */
	public char CONN_ID = '\u006B';

	/**
     *
     *
     */
	public char DEVICE = '\u0080';

	/**
     *
     *
     */
	public char AGENT = '\u0082';

	/**
     *
     *
     */
	public char CALL_ID = '\u0082';

	/**
     *
     *
     */
	public char A1 = '\u00A1';

	/**
     *
     *
     */
	public char ROSE_INVOKE = '\u00A1';

	/**
     *
     *
     */
	public char A2 = '\u00A2';

	/**
     *
     *
     */
	public char ROSE_RESULT = '\u00A2';

	public char PHASEI_62 = '\u0062';

	/**
	 * Creates a new instance of CSTA_Base
	 * 
	 */
	public CSTA_Base() {
	}

	/**
	 * 
	 * 
	 * 
	 * @param thisString
	 * @param label
	 */
	public void StringContains(StringBuffer thisString, String label) {
		int length = thisString.length();
		System.out.print("\n" + label + ": ");
		for (int j = 0; j < length; j++)
			System.out.print(Integer.toHexString((int) thisString.charAt(j))
					+ " ");
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 * @param curInStr
	 * @param bytes
	 */
	public StringBuffer DeleteChars(StringBuffer curInStr, int bytes) {
		for (int i = 0; i < bytes; i++)
			curInStr = curInStr.deleteCharAt(0);
		return curInStr;
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 * @param curInStr
	 * @param bytes
	 * @param output
	 */
	public StringBuffer DeleteChars(StringBuffer curInStr, int bytes,
			String output) {
		for (int i = 0; i < bytes; i++)
			curInStr = curInStr.deleteCharAt(0);
		System.out.println(output);
		return curInStr;
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 * @param curInStr
	 * @param normalCase
	 */
	public StringBuffer CheckLengthAndStrip(StringBuffer curInStr,
			int normalCase) {
		// WHERE normalCase REFERS TO A STRING OF LESS THAN 128BYTES LENGTH
		// (<=0x80)
		if (curInStr.charAt(1) == 0x81) {
			// E.G. a1 81 9e 2 2 5d 73 ....OR 0x30 0x81 0x94
			curInStr = DeleteChars(curInStr, (normalCase + 1));
		} else if (curInStr.charAt(1) == 0x82) {
			// E.G. a1 82 1 29 2 2 5d 73 .... OR 0x30 0x82 0x01 0x29
			curInStr = DeleteChars(curInStr, (normalCase + 2));
			// STC: WITH A CONFERENCED EVENT
		} else {// MUST BE 0xXX WHERE 'XX' IS THE LENGTH
				// E.G. a1 XX 2 2 5d .... OR 0x30 0xXX
			curInStr = DeleteChars(curInStr, (normalCase));
		}

		return curInStr;
	}

	/**
	 * inserts 0x30 <length> into the string
	 * 
	 * @return the string with sequence and length inserted
	 * @param _str
	 *            the string to insert to
	 */
	public String insertSequence(String _str) {
		int length = _str.length();
		char[] ch_array = { 0x30, (char) length };
		return ((new String(ch_array) + _str));
	}
}
