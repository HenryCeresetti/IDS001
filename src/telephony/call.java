package telephony; // "telephony" package identification.

/**
* @author HenryCeresetti
* @author OrlandoJunior
*/

import java.util.Objects; // Java Objects utility importing.
import java.util.Date; // Java Date utility importing.

// "call" public class initialization.
public class call {
    private Date callDate; // "callDate" private field definition. Its type is boxed and can deal with Date tool components.
    private int callDuration; // "callDuration" private field definition. Its type is primitive and cannot be handled as a object.
    
    // public "call" constructor method
    public call(Date callDate, int callDuration) {
        super();
        this.callDate = callDate; // first parameter, defined by logical order.
        this.callDuration = callDuration; // second parameter, through after even its data has primitive type.
    }
    
    // first getter
    public Date getCallDate() {
        return callDate; // variable and value returning is required when you indicate any data type in any method.
    }
    
    public int getCallDuration() {
        return callDuration; // the previous statement applies here too.
    }
    
    @Override // Java has already a "toString()" native method. Here occouried a method overriding.
    public String toString() {
        return "The registered call is from the following date: " + callDate + " and its duration is from: " + callDuration; // returns a string with its referred private fields in its respective invocations.
    }
    
    @Override
    // private fields hashing process.
    public int hashCode() {
        return Objects.hash(callDate, callDuration); // "hash()" method usage from Java "Objects" utility.
    }
    
    @Override // equals method overriding
    public boolean equals(Object objc) {
        if (this == objc) {
            return true;
        }
        
        if (objc == null) {
            return false;
        }
        
        if (getClass() != objc.getClass()) {
            return false;
        }
        
        call instVar = (call) objc;
        return Objects.equals(callDate, instVar.callDate) && Objects.equals(callDuration, instVar.callDuration);
    }

    /* Object getDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    } */
}