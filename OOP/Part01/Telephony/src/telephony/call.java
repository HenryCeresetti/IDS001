package telephony;

/**
* @author HenryCeresetti
* @author OrlandoJunior
* @author Luis
**/

import java.text.SimpleDateFormat;
import java.util.Date;

public class call {
    private Date callDate;
    private int callDuration;

    public call(Date callDate, int callDuration) {
        super();
        this.callDate = callDate;
        this.callDuration = callDuration;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }

    public Date getCallDate() {
        return callDate;
    }

    public int getCallDuration() {
        return callDuration;
    }
    
    @Override
    public String convertToString() {
        SimpleDateFormat dateFormatation = new SimpleDateFormat("dd-MM-yyyy");
        
        String formatedDate = dateFormatation.format(callDate);

        System.out.println("Call Date: " + formatedDate + "Call Duration: " + callDuration + " minutes.");

        return "The registered call is from the following date: " + formatedDate + " and its duration is from: " + callDuration + " minutes.";
    }
}