package telephony;

/**
 * @author HenryCeresetti
 * @author OrlandoJunior
 */

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Calendar;

public class postPaid extends subscriber {
    private float clientSubscription;
    
    public postPaid(String clientNum, long clientCPF, String clientName, float clientSubscription) {
        super(clientNum, clientCPF, clientName);
        this.clientSubscription = clientSubscription;
    }
    
    public void makeCall(Date callDate, int callDuration) {
        int i = 0;
        callsNum++;
        
        while (i < callsNum) {
            if (this.calls[i] == null) {
                call call = new call(callDate, callDuration);
                this.calls[i] = call;
            }
            i++;
        }
    }
    
    public void printInvoice(int invoiceMonth) {
        int i = 0;
        
        DecimalFormat formater = new DecimalFormat("0.00");
        float invoiceValue = 0;
        float invoiceValueSum = 0;
        float invoiceQuantity = 0;
        
        while (i < callsNum) {
            if (this.calls[i].getCallDate().getMonth() == invoiceMonth) {
                invoiceValue = this.calls[i].getCallDuration() * 1.04f;
                invoiceValueSum = invoiceValue + invoiceValueSum;
                System.out.println(this.toString());
                System.out.println("Call value: " + formater.format(callValue));
                System.out.println(this.calls[i]);
            }
            i++;
            invoiceQuantity = invoiceValueSum + clientSubscription;
        }
        System.out.println("Client Subscription: " + formater.format(this.clientSubscription));
        System.out.println("Invoice Value: " + formater.format(invoiceQuantity));
    }
    
    public static void main(String[] args) {
        postPaid posp = new postPaid(2, 08642135790L, "Henry", 10);
        postPaid pspd = new postPaid(2, 08642135790L, "Orlando", 15);
        
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 01, 23);
        Date dt = cal.getTime();
        
        Calendar calr = Calendar.getInstance();
        calr.set(2014, 03, 18);
        Date dte = calr.getTime();
        
        posp.makeCall(dt, 5);
        pspd.makeCall(dt, 10);
        pspd.makeCall(dt, 15);
        
        posp.printInvoice(04);
        pspd.printInvoice(04);
    }
}