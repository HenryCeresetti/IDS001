package telephony;

/**
 * @author HenryCeresetti
 * @author OrlandoJunior
 */

import java.text.DecimalFormat;
import java.util.Date;

/*Classe pré-Pago herdando a classe Assinante */

public class prePaid extends subscriber {
    protected float rechargeCredits;
    protected recharge[] recharges;
    private recharge[][] recharge;
    private int rechargesQuantity;

/*Método construtor pré-Pago*/  

    public prePaid(long clientCPF, String clientName, int clientTel) {
        super(clientTel, clientCPF, clientName);
        this.recharges = recharge[300];
    }
    
    public int getRechargesQuantity() {
        return rechargesQuantity;
    }
    
    public void makeCall(Date callDate, int callDuration) {
        int i = 0;
        
        float noCredit = callDuration * 1.45f;
        this.callsQuantity++;
        
        while (i < callsQuantity) {
            if (this.calls[i] == null && this.rechargesQuantity > noCredit) {
                call call = new call(callDate, callDuration);
                this.calls[i] = call;
                this.rechargeCredits = this.rechargeCredits - noCredit;
            } else {
                this.callsQuantity--;
                System.out.println("You do not have sufficient credits to make this call.");
            }
        }
    }
    
    public void recharge(Date callDate, float callCost) {
        int i = 0;
        
        this.rechargesQuantity++;
        
        while (i < rechargesQuantity) {
            if (this.recharges[i] == null) {
                recharge rcrg = new recharge(callDate, callCost);
                this.recharges[i] = rcrg;
                this.rechargeCredits = this.rechargeCredits + callCost;
            }
            i++;
        }
    }
    
/*Imprime a fatura do respectivo mês e seu valor*/   

    public void printInvoice(int invoiceMonth) {
        int i = 0;
        
        DecimalFormat numFormater = new DecimalFormat("0.00");
        
        float invoiceValue = 0;
        float invoiceValueSum = 0;
        
        float rcrg = 0;
        
        float callCost = 0;
        float callsCostsSum = 0;
        
        while (i < callsQuantity) {
            if (this.calls[i].getCallDate().getMonth() == invoiceMonth) {
                System.out.println(this.toString());
                invoiceValue = this.calls[i].getCallDuration() * 1.45f;
                invoiceValueSum = invoiceValue + invoiceValueSum;
                System.out.println(this.calls[i]);
                System.out.println("Call Monetary Cost: " + numFormater.format(callCost) + " BRL");
            } else {
                System.out.println(this.toString());
                System.out.println("There is not call registers from the subscriber during this month.");
            }
        }
        System.out.println("Calls Total Monetary Costs: " + numFormater.format(callsCostsSum) + " BRL");
        
        while (i < rechargesQuantity) {
            if (this.recharges[i].getRechargeDate().getMonth() == invoiceMonth) {
                System.out.println(this.recharges[i]);
                rcrg = this.recharges[i].getRechargeDate().getMonth() + rcrg;
            }
            i++;
        }
        System.out.println("Recharges Total Monetary Value: " + numFormater.format(rcrg) + " BRL");
        System.out.println("Credits Total Monetary Value: " + numFormater.format(this.rechargeCredits) + " BRL\n");
    }
}