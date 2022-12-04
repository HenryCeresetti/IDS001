package telephony;

/**
 * @author HenryCeresetti
 * @author OrlandoJunior
 */

import java.util.Objects;
import java.util.Date;

public class call {
    private Date callDate;
    private int callDuration;
    
    public call(Date callDate, int callDuration) {
        super();
        this.callDate = callDate;
        this.callDuration = callDuration;
    }
    
    public Date getCallDate() {
        return callDate;
    }
    
    public int getCallDuration() {
        return callDuration;
    }
    
    @Override
    public String toString() {
        return "The registered call is from the following date: " + callDate + " and its duration is from: " + callDuration;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(callDate, callDuration);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        call instVar = (call) obj;
        return Objects.equals(callDate, instVar.callDate) && Objects.equals(callDuration, instVar.callDuration);
    }
}