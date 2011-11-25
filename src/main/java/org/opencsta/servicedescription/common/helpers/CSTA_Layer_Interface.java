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
public interface CSTA_Layer_Interface {

	/**
     *
     *
     */
	char DLE = '\u0010';

	/**
     *
     *
     */
	char STX = '\u0002';

	/**
     *
     *
     */
	char ETX = '\u0003';

	/**
     *
     *
     */
	char ENQ = '\u0005';

	/**
     *
     *
     */
	char NAK = '\u0015';

	/**
     *
     *
     */
	char[] Ack0 = { '\u0010', '\u0030' };

	/**
     *
     *
     */
	char[] Ack1 = { '\u0010', '\u0031' };

	/**
     *
     *
     */
	char[] dleenq = { DLE, ENQ };

	/**
     *
     *
     */
	String ACK0 = new String(Ack0);

	/**
     *
     *
     */
	String ACK1 = new String(Ack1);

	/**
     *
     *
     */
	String DLEENQ = new String(dleenq);

	// void PassedUp(String curInStr) ;
	// boolean FromAbove(String curOutStr) throws IOException ;
	// void Strip(String curInStr) ;
	// String Wrap(String curOutStr) throws IOException;
}
