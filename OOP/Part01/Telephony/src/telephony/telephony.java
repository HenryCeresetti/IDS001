package telephony;

/**
* @author HenryCeresetti
* @author OrlandoJunior
* @author Luis
**/

import java.util.Set;
import java.util.HashSet;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class telephony {
    public static void main(String[] args) {
        Set<call> call = new HashSet<>();

        GregorianCalendar callDate = new GregorianCalendar();
        callDate.set(1995, GregorianCalendar.MAY, 23);

        GregorianCalendar secCallDate = new GregorianCalendar();
        secCallDate.set(2014, GregorianCalendar.MARCH, 18);

        call firstCall = new call(callDate.getTime(), 30);
        call secondCall = new call(callDate.getTime(), 15);

        call.add(firstCall);
        call.add(secondCall);

        String innerHTML = "<!DOCTYPE html>" +
        "<html lang='en-us'>" +
        "<body>" +
        "<h1>Telephony System</h1>" +
        "<h2>Developed by Henry Ceresetti, Orlando Júnior and Luís</h2>" +
        "<h3>The options are: </h3>" +
        "<p>1. Sign up subscriber.<br>" +
        "2. List subscribers.<br>" +
        "3. Make call.<br>" +
        "4. Make recharge.<br>" +
        "5. Print invoices.<br>" +
        "6. Exit program.<br><br>" +
        "Type the desired option below: <br><br>";

        int defaultSize = 500;

        String optSelector = JOptionPane.showInputDialog(null, String.format(innerHTML, defaultSize, defaultSize));

        switch (optSelector) {
            case "1":
                JOptionPane.showMessageDialog(null, "Sign up subscriber");
                break;
            
            case "2":
                JOptionPane.showMessageDialog(null, "List subscribers");
                break;
            
            case "3":
                JOptionPane.showMessageDialog(null, "Make calls");
                break;
            
            case "4":
                JOptionPane.showMessageDialog(null, "Make recharges");
                break;
            
            case "5":
                JOptionPane.showMessageDialog(null, "Print invoices");
                break;
            
            case "6":
                call.convertToString();
                break;
            
            default:
                JOptionPane.showMessageDialog(null, "Type a valid option");
                break;
        }
    }
}