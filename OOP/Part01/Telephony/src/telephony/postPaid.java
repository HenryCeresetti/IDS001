package telephony;

/**
* @author Henry M. Ceresetti
**/

import java.util.GregorianCalendar;

public class postPaid extends subscriber {
    private float clientSubscription;
    
    public postPaid(long clientCPF, String clientName, String clientNum, float clientSubscription) {
        super(clientCPF, clientName, clientNum);
        this.clientSubscription = clientSubscription;
    }
    
    public void setClientSubscription(float clientSubscription) {
        this.clientSubscription = clientSubscription;
    }
    
    public float getClientSubscription() {
        return clientSubscription;
    }
    
    public void makeCall(GregorianCalendar callDate, int callDuration) {
        this.clientSubscription = callDuration * 1.04f;
        this.calls[this.clientNumCalls - 1] = new call(callDate, callDuration);
        this.clientNumCalls = this.clientNumCalls - 1;
        
        System.out.println(this.clientNumCalls);
    }
    
    public void showCalls() {
        for (int i = 0; i < 2; i++) {
            System.out.println(this.calls[i]);
        }
    }

    public static void main(String[] args) {}
}