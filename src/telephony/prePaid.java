package telephony;

/**
 * @author HenryCeresetti
 * @author OrlandoJunior
 */

import java.util.Date;

public class prePaid extends subscriber {
    private int rechargeNum;
    private float rechargeCredits;
    
    public prePaid(long clientCPF, String clientName, int clientNum) {
        super(clientCPF, clientName, clientNum);
        this.rechargeNum = rechargeNum;
        this.rechargeCredits = rechargeCredits;
    }
    
    public void setRechargeNum(int rechargeNum) {
        this.rechargeNum = rechargeNum;
    }
    
    public void setRechargeCredits(float rechargeCredits) {
        this.rechargeCredits = rechargeCredits;
    }
    
    public int getRechargeNum() {
        return rechargeNum;
    }
    
    public float getRechargeCredits() {
        return rechargeCredits;
    }
    
    public void makeCall(Date callDate, int callDuration) {
        int i = 0;
        
        float noCredit = callDuration * 1.45f;
        this.callsNum++;
        
        while (i < callsNum) {
            if (this.calls[i] == null && this.rechargeCredits > noCredit) {
                call call = new call(callDate, callDuration);
                this.calls[i] = call;
                this.rechargeCredits = this.rechargeCredits - noCredit;
            } else {
                System.out.println("You do not have credits to make this call.");
            }
        }
    }
    
    public void recharge(Date callDate, float callValue) {
        int i = 0;
        
        this.rechargeNum++;
        
        while (i < rechargeNum) {
            if (this.recharges[i] == null) {
                recharge rcrg = new recharge(callDate, callValue);
                this.recharges[i] = rcrg;
                this.rechargeCredits = this.rechargeCredits + callValue;
            }
        }
    }
    
    public void printInvoice(int invoiceMonth) {
        int i = 0;
        
        DecimalFormat formater = new DecimalFormat("0.00");
        
        float invoiceValue = 0;
        float invoiceValueSum = 0;
        float rcrg = 0;
        
        while (i < callsNum) {
            if (this.calls[i].getCallDate().getMonth() == invoiceMonth) {
                invoiceValue = this.calls[i].getCallDuration() * 1.45f;
                invoiceValueSum = invoiceValue + invoiceValueSum;
                rcrg = this.recharges[i].getInvoiceValue() + rcrg;
                System.out.println(this.toString() + this.calls[i]);
                System.out.println("Call Value: " + formater.format(callValue) + " BRL");
            }
        }
        System.out.println("Calls Total Value: " + formater.format(callValueSum) + " BRL");
        
        while (i < rechargesNum) {
            if (this.recharges[i].getCallDate().getMonth() == invoiceMonth) {
                System.out.println(this.recharges[i]);
            }
            i++;
        }
    }
    
    public static void main(String[] args) {
        postPaid posp = new postPaid(08642135798L, "Henry", 998766120);
        
        Calendar cal = Calendar.getInstance();
        cal.set(1991, 02, 20);
        Date dt = cal.getTime();
        
        Calendar calr = Calendar.getInstance();
        calr.set(2022, 02, 13);
        Date dte = calr.getTime();
        
        posp.recharge(dt, 250);
        posp.recharge(dte, 500);
        
        posp.makeCall(dte, 15);
        posp.makeCall(dte, 30);
        
        posp.printInvoice(09);
    }
}