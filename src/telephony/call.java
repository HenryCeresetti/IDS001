package telephony;

/**
 * @author HenryCeresetti
 * @author OrlandoJunior
 */

import java.util.Date;
import java.text.SimpleDateFormat;

public class call {
    private int callDuration;
    private Date callDate;
    
    public call(Date callDate, int callDuration) {
        this.callDate = callDate;
        this.callDuration = callDuration;
    }
    
    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }
    
    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }
    
    public int getCallDuration() {
        return callDuration;
    }
    
    public Date getCallDate() {
        return callDate;
    }
    
    @Override
    public String toString() {
        SimpleDataFormat defaultDataFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDataFormat = defaultDataFormat.format(callDate);
        System.out.println("Call Date: " + currentDataFormat + " Call Duration: " + callDuration + " minutes.");
        return "The registered call is from the following date: " + currentDataFormat + " and its duration is from: " + callDuration + " minutes.";
    }
}