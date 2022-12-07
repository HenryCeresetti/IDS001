package telephony;

/**
 * @author HenryCeresetti
 * @author OrlandoJunior
 */

import java.util.Date;

public class recharge {
    private Date rechargeDate;
    private float rechargeValue;
    
    public recharge(Date rechargeDate, float rechargeValue) {
        this.rechargeDate = rechargeDate;
        this.rechargeValue = rechargeValue;
    }
    
    public Date getRechargeDate() {
        return rechargeDate;
    }
    
    public float getRechargeValue() {
        return rechargeValue;
    }
    
    @Override
    public String toString() {
        return "Recharge\n" + "Recharge Date: " + rechargeDate + "\nRecharge Value: " + rechargeValue + " BRL\n";
    }
}