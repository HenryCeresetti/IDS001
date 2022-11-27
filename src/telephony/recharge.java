package telephony;

/**
 * @author HenryCeresetti
 * @author OrlandoJunior
 */

import java.util.Date;
import java.util.Calendar;

public class recharge {
    private float rechargeValue;
    private Date rechargeDate;
    
    public recharge(Date rechargeDate, float rechargeValue) {
        this.rechargeDate = rechargeDate;
        this.rechargeValue = rechargeValue;
    }
    
    public void setRechargeDate(Date rechargeDate) {
        this.rechargeDate = rechargeDate;
    }
    
    public void setRechargeValue(float rechargeValue) {
        this.rechargeValue = rechargeValue;
    }
    
    public Date getRechargeDate() {
        return rechargeDate;
    }
    
    public float getRechargeValue() {
        return rechargeValue;
    }
    
    @Override
    public String convertToString() {
        return "Recharge\n" + "Recharge Date: " + rechargeDate + "\nRecharge Value: " + rechargeValue + " BRL";
    }
    
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date dt = cal.getTime();
        
        recharge rcrg = new recharge(dt, 150);
        System.out.println(rcrg.convertToString());
    }
}