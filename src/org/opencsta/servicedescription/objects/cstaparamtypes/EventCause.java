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

package org.opencsta.servicedescription.objects.cstaparamtypes;

import org.opencsta.servicedescription.common.helpers.CSTA_Base;

/**
 * ECMA-269 12.2.15:
 * This parameter type provides additional information on why an event was generated.
 * Format:
 * Event causes are defined within the context of an event.  For a description of an event cause refer to the
 * event cause descption associated with a specific event.
 * This parameter type contains one of the following event causes:
 * - ACD Busy
 * - ACD Forward
 * - ACD Saturated
 * - Activation
 * - Actie Participation
 * - Alert Time Expired
 * - Alternate
 * - Auto Work
 * - Babble
 * - Bad Attribute
 * - Bad Grammar
 * - Bad Voice
 * - Bad URI
 * - Blocked
 * - Busy
 * - Busy Overflow
 * - Calendar Overflow
 * - Call Back
 * - Call Cancelled
 * - Call Forward
 * - Call Forward - Busy
 * - Call Forward - Immediate
 * - Call Forward - No Answer
 * - Call Not Answered
 * - Call Picup
 * - Camp on
 * - Camp On Trunks
 * - Capacity Overflow
 * - Character Count Reached
 * - Conference
 * - Consultation
 * - Destination Detected
 * - Destination Not Obtainable
 * - Destination Out of Order
 * - Distributed
 * - Distributed Delay
 * - Do Not Disturb
 * - DTMF Digit Detected
 * - Duplicate DTMF
 * - Duration Exceeded
 * - Early Stop
 * - Empty Queue
 * - End of Message Detected
 * - Entering Distribution
 * - Forced Pause
 * - Forced Transition
 * - Incompatible Destination
 * - inter-digit Timeout
 * - Intrude
 * - Invalid Account Code
 * - Invalid Connection
 * -Invalid Connection State
 * - Invalid Number Format
 * - Join Call
 * - Key Operation
 * - Key Operation In Use
 * - Lockout
 * - Maintenance
 * - Make Call
 * - Make Predictive Call
 * - Max Timeout
 * - Message Duration Exceeded
 * - Message Size Exceeded
 * - Multiple Alerting
 * - Multiple Queuing
 * - Network Congestion
 * - Network Dialling
 * - Network Not Obtainable
 * - Network Out of Order
 * - Network Signal
 * - New Call
 * - Next Message
 * - No Audio Saved
 * - No Available Agents
 * - No Queue
 * - Normal
 * - Normal Clearing
 * - No Rule
 * - No Speech Detected
 * - Not Available Bearer Service
 * - Not Supported Bearer Service
 * - Number Changed
 * - Number Unallocated
 * - Out Of Grammar
 * - Overflow
 * - Override
 * - Park
 * - Path Replacedment
 * - Queue Cleared
 * - Queue Time Overflow
 * - Recall
 * - Recall Busy
 * - Recall - Forwarded
 * - Recall - No Answer
 * - Recall - Resources Not Available
 * - Redirected
 * - Remains in Queue
 * - Reorder Tone
 * - Reserved
 * - Resources Not Available
 * - Selected Trunk usy
 * - Silent Participation
 * - Single Step Conference
 * - Single Step Transfer
 * - Speech Detected
 * - Suspend
 * - Switching Function Terminated
 * - Termination Character Received
 * - Timeout
 * - Transfer
 * - Trunks Busy
 * - Unauthorized Bearer Service
 * - Unknown Overflow
 *
 */
public class EventCause extends CSTA_Base{

    /**
     * 
     */
    private char value;

    /**
     * @param eventCause
     */
    public  EventCause(char eventCause) {
        this.value = eventCause ;
    }

    /**
     * 
     */
    public EventCause(){
    }
    

    /**
     * @param _str_cause
     */
    public EventCause(String _str_cause){
        System.out.println("_SEPT 05: New SI's cause") ;
        this.value = StringToChar(_str_cause) ;
    }
    
    /**
     * used in asterisk integration
     *
     */
    public String set_cause(){
        char[] ar_cause = { 0x0A,0x01,this.get_value() } ;
        return (new String(ar_cause)) ;
    }
    
    /**
     * used in asterisk integration
     *
     */
    public char StringToChar(String _str_cause){
        char ch = 0 ;
        if( _str_cause.equals("newCall") )
            ch = 0x16 ;
        if( _str_cause.equals("normalClearing") )
            ch = 0x30 ;
        return ch ;
    }
    
    /**
     *
     *
     */
    public StringBuffer set_value(StringBuffer curInStr){
        int length = curInStr.charAt(1) ;
        this.value = curInStr.charAt(1+length) ;//usually 2
        curInStr = CheckLengthAndStrip(curInStr, 3) ;
        return curInStr ;
    }
    
    /**
     *
     *
     */
    public char get_value(){
        return value ;
    }
    
    /**
     *
     *
     */
    public String toString(){
        String str = new String() ;
        switch (value){
            case 0x01:
                str = "activeParticipation" ;
                break ;
            case 0x02:
                str = "alternate" ;
                break ;
            case 0x03:
                str = "busy" ;
                break ;
            case 0x04:
                str = "callBack" ;
                break ;
            case 0x06:
                str = "callForwardImmediate" ;
                break ;
            case 0x07:
                str = "callForwardBusy" ;
                break ;
            case 0x08:
                str = "callForwardNoAnswer" ;
                break ;
            case 0x09:
                str = "callForward" ;
                break ;
            case 0x0B:
                str = "callPickup" ;
                break ;
            case 0x0C:
                str = "campOn" ;
                break ;
            case 0x0D:
                str = "destNotObtainable" ;
                break ;
            case 0x0E:
                str = "doNotDisturb" ;
                break ;
            case 0x16:
                str = "newCall" ;
                break ;
            case 0x17:
                str = "noAvailableAgents" ;
                break ;
            case 0x19:
                str = "park" ;
                break ;
            case 0x1B:
                str = "recall" ;
                break ;
            case 0x1C:
                str = "redirected" ;
                break ;
            case 0x1D:
                str = "reorderTone" ;
                break ;
            case 0x1F:
                str = "silentParticipation" ;
                break ;
            case 0x20:
                str = "transfer" ;
                break ;
            case 0x21:
                str = "trunksBusy" ;
                break ;
            case 0x23:
                str = "blocked" ;
                break ;
            case 0x25:
                str = "consultation" ;
                break ;
            case 0x26:
                str = "distributed" ;
                break ;
            case 0x2A:
                str = "enteringDistribution" ;
                break ;
            case 0x2C:
                str = "makeCall" ;
                break ;
            case 0x30:
                str = "normalClearing" ;
                break ;
            case 0x34:
                str = "singleStepTransfer" ;
                break ;
            case 0x3F:
                str = "conference" ;
                break ;
            case 0x44:
                str = "intrude" ;
                break ;
            case 0x4E:
                str = "normal" ;
                break ;
            default:
                str = "notCurrentlySuppored NEXT PRINTOUT" ;
                break ;
        }
        return str ;
    }
    
}