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

/** Java class "AgentID.java" generated from Poseidon for UML.
 *  Poseidon for UML is developed by <A HREF="http://www.gentleware.com">Gentleware</A>.
 *  Generated with <A HREF="http://jakarta.apache.org/velocity/">velocity</A> template engine.
 */
package org.opencsta.servicedescription.objects.cstaparamtypes.otherparameters;

import org.opencsta.servicedescription.common.helpers.CSTA_Base;

/**
 * ECMA-269 12.3.1: AgentID parameter type identifies an ACD agent
 * 
 */
public class AgentID extends CSTA_Base {

	/**
	 * 
	 */
	protected String value;

	/**
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param curInStr
	 * @return
	 */
	public StringBuffer setValue(StringBuffer curInStr) {
		int length = (int) curInStr.charAt(1);
		this.value = curInStr.substring(2, (2 + length));
		curInStr = CheckLengthAndStrip(curInStr, (2 + length));
		return curInStr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return value;
	}
}