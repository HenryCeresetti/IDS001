package telephony;

/**
* @author HenryCeresetti
**/

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class call {
    protected int callDuration;
    protected GregorianCalendar callDate;
    protected String convertToString;
    
    public call(GregorianCalendar callDate, int callDuration) {
        this.callDate = callDate;
        this.callDuration = callDuration;
    }
    
    public void setCallDate(GregorianCalendar callDate) {
        this.callDate = callDate;
    }
    
    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }
    
    public GregorianCalendar getCallDate(GregorianCalendar callDate) {
        return callDate;
    }
    
    public int getCallDuration(int callDuration) {
        return callDuration;
    }
    
    public static String convertToString(GregorianCalendar callDate) {
        SimpleDateFormat dateFormatation = new SimpleDateFormat("dd-MM-yyyy");
        String formatedDate = dateFormatation.format(callDate.getTime());
        System.out.print("Formated date: " + formatedDate);
        return formatedDate;
    }
    
    public static void main(String[] args) {
        GregorianCalendar grgCal = new GregorianCalendar();
        grgCal.set(GregorianCalendar.YEAR, 1995);
        
        grgCal.set(GregorianCalendar.MONTH, 05);
        
        grgCal.set(GregorianCalendar.DATE, 23);
        
        System.out.println("Gregorian date: " + grgCal.getTime());
        
        convertToString(grgCal);
    }
}