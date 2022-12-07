package telephony;

/**
 * @author HenryCeresetti
 * @author OrlandoJunior
 */

import java.text.DecimalFormat;
import java.util.Date;

public class prePaid extends subscriber {
    protected float rechargeCredits;
    private recharge[] recharges;
    private int rechargesQuantity;
    
    public prePaid(long clientCPF, String clientName, int clientTel) {
        super(clientTel, clientCPF, clientName);
        this.recharges = new recharge[300];
        this.rechargeCredits = rechargeCredits;
    }
    
    public String recharge(Date callDate, float callCost) {
		this.rechargesQuantity++;
		for (int i = 0; i < this.rechargesQuantity; i++) {
			if (this.recharges[i] == null) {
				recharge r = new recharge(callDate, callCost);
				this.recharges[i] = r;
				this.rechargeCredits = this.rechargeCredits + callCost;
				return "Crédito no valor de R$" + callCost + ",00 inserido.\n";
			}
		}
		return "Crédito não efetuado.\n";
	}
    /*public int getRechargesQuantity() {
        return rechargesQuantity;
    }*/
    public String makeCall(Date callDate, int callDuration) {
		float value = callDuration * 1.45f;
		this.callsQuantity++;
		for (int i = 0; i < this.callsQuantity; i++) {
			if (this.calls[i] == null && this.rechargeCredits > value) {
					call c = new call(callDate, callDuration);
					this.calls[i] = c;
					this.rechargeCredits = this.rechargeCredits - value;
					return "Chamada concluída.\n";
			} else if (this.calls[i] == null && this.rechargeCredits < value) {
				this.callsQuantity--;
				return "Créditos insuficientes. Recarregue para fazer mais ligações!\n";
			}
		}
		return "Não é possível realizar mais ligações. Limite alcançado.\n";
	}
    
    /*public void makeCall(Date callDate, int callDuration) {
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
    }*/
    
    /*public void recharge(Date callDate, float callCost) {
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
    }*/
    
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