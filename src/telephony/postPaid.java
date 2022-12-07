package telephony;

/**
 * @author HenryCeresetti
 * @author OrlandoJunior
 */

import java.text.DecimalFormat;
import java.util.Date;

public class postPaid extends subscriber {
    protected float clientSubscription;
    
    public postPaid(int clientTel, long clientCPF, String clientName, float clientSubscription) {
        super(clientTel, clientCPF, clientName);
        this.clientSubscription = clientSubscription;
    }
    
    public void makeCall(Date callDate, int callDuration) {
        int i = 0;
        callsQuantity++;
        
        while (i < callsQuantity) {
            i++;
            call call = new call(callDate, callDuration);
            this.calls[i] = call;
        }
    }
    
    public void printInvoice(int invoiceMonth) {
        int i = 0;
        
        DecimalFormat numFormater = new DecimalFormat("0.00");
        
        float callCost = 0;
        
        float invoiceValue = 0;
        float invoiceValueSum = 0;
        float invoiceTotalValue = 0;
        
        while (i < callsQuantity) {
            if (this.calls[i] != null) {
                if (this.calls[i].getCallDate().getMonth() == invoiceMonth) {
                invoiceValue = this.calls[i].getCallDuration() * 1.04f;
                invoiceValueSum = invoiceValue + invoiceValueSum;
                System.out.println(this.toString());
                System.out.println("Call Monetary Cost: " + numFormater.format(callCost) + " BRL");
                System.out.println(this.calls[i]);
            }
                i++;
                invoiceTotalValue = invoiceValueSum + clientSubscription;
            }
        System.out.println("Client Subscription: " + numFormater.format(this.clientSubscription) + " BRL");
        System.out.println("Invoice Value: " + numFormater.format(invoiceTotalValue) + " BRL\n");
        }
    }
}