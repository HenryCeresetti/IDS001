package telephony;

/**
* @author HenryCeresetti
* @author OrlandoJunior
* @author Luis
**/

import java.util.Date;

public class postPaid extends subscriber {
    private float clientSubscription;
    
    public postPaid(long clientCPF, String clientName, String clientNum, int callsNum, float clientSubscription) {
        super(clientCPF, clientName, clientNum, callsNum);
        this.clientSubscription = clientSubscription;
    }
    
    public void setClientSubscription(float clientSubscription) {
        this.clientSubscription = clientSubscription;
    }
    
    public float getClientSubscription() {
        return clientSubscription;
    }

    public void makeCall(Date callDate, int callDuration) {
        this.clientSubscription = callDuration * 1.04f;
        
        this.calls[this.callsNum - 1] = new call(callDate, callDuration);
        this.callsNum = this.callsNum - 1;
        
        System.out.println(this.callsNum);
    }
    
    public void showCalls() {
        for (int i = 0; i < 2; i++) {
            System.out.println(this.calls[i]);
        }
    }
    
    public static void main(String[] args) {
        postPaid postp = new postPaid(9876543, "Henry", "13991126543", 5, 25f);

        postp.makeCall(new Date(), 5);
        postp.makeCall(new Date(), 50);

        postp.showCalls();
    }
}