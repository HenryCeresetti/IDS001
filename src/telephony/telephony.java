package telephony;

/**
 * @author HenryCeresetti
 * @author OrlandoJunior
 */

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Date;

public class telephony {
    private int postPaidTels;
    private int prePaidTels;
    private postPaid[] postPaids;
    private prePaid[] prePaids;
    
    public telephony() {
        super();
        this.postPaids = new postPaid[300];
        this.prePaids = new prePaid[150];
    }
    
    public void signUpSubscriber(String clientName, long clientCPF, int clientTel, float clientSubscription) {
        int i = 0;
        int opt = 0;
        
        if (opt == 1) {
            this.postPaidTels++;
            
            while (i < postPaidTels) {
                if (this.postPaids[i] == null) {
                    postPaid ptpd = new postPaid(clientTel, clientCPF, clientName, clientSubscription);
                    this.postPaids[i] = ptpd;
                    System.out.println("The sign up has been made successfully.");
                }
                i++;
            }
        } else if (opt == 2) {
            this.prePaidTels++;
            
            while (i < prePaidTels) {
                if (this.prePaids[i] == null) {
                    prePaid prpd = new prePaid(clientCPF, clientName, clientTel);
                    this.prePaids[i] = prpd;
                    System.out.println("The sign up has been made successfully.");
                }
                i++;
            }
        }
    }
    
    public void sortSubscribers() {
        int i = 0;
        
        System.out.println("Post paid subscribers:\n");
        while (i < postPaidTels) {
            if (this.postPaids[i] != null) {
                System.out.println(this.postPaids[i].toString() + "\n");
            }
            i++;
        }
        
        System.out.println("Pre paid subscribers:\n");
        while (i < prePaidTels) {
            if (this.prePaids[i] != null) {
                System.out.println(this.prePaids[i].toString());
            }
            i++;
        } 
    }
    
    public void makeCall(long clientCPF, Date callDate, int callDuration) {
        int opt = 0;
        
        switch (opt) {
            case 1:
                if (this.queryPostPaid(clientCPF) != null) {
                    postPaid cll = this.queryPostPaid(clientCPF);
                    cll.makeCall(callDate, callDuration);
                    System.out.println("The call has been made.");
                } else {
                    System.out.println("The subscriber has not been found in our telephony system.");
                }
                break;
            case 2:
                if (this.queryPrePaid(clientCPF) != null) {
                    prePaid cll = this.queryPrePaid(clientCPF);
                    cll.makeCall(callDate, callDuration);
                } else {
                    System.out.println("The subscriber has not been found in our telephony system.");
                }
                break;
            default:
                System.out.println("Select another option.");
                break;
        }
    }
    
    public void makeRecharge(long clientCPF, float rechargeValue, Date rechargeDate) {
        if (this.queryPrePaid(clientCPF) != null) {
            prePaid rcrg = this.queryPrePaid(clientCPF);
            rcrg.recharge(rechargeDate, rechargeValue);
            System.out.println("The recharge has been made successfully.");
        } else {
            System.out.println("The subscriber has not been found in our telephony system.");
        }
    }
    
    public prePaid queryPrePaid(long clientCPF) {
        int i = 0;
        
        while (i < prePaidTels) {
            if (this.prePaids[i] != null) {
                if (this.prePaids[i].getClientCPF() == clientCPF) {
                    return this.prePaids[i];
                }
                i++;
                } else {
                    return null;
                }
        }
        return null;
    }
    
    public postPaid queryPostPaid(long clientCPF) {
        int i = 0;
        
        while (i < postPaidTels) {
            if (this.postPaids[i] != null) {
                if (this.postPaids[i].getClientCPF() == clientCPF) {
                    return this.postPaids[i];
                } else {
                    i++;
                }
            }
        }
        return null;
    }
    
    public void printInvoice(int invoiceMonth) {
        int i = 0;
        
        DecimalFormat numFormater = new DecimalFormat("0.00");
        
        while (i < prePaidTels) {
            if (this.prePaids[i].callsQuantity > 0) {
                this.prePaids[i].printInvoice(invoiceMonth);
            } else {
                System.out.println("Pre Paid Subscriber Invoice:");
                System.out.println(this.prePaids[i]);
                System.out.println("The subscriber does not made calls in this month.");
                System.out.println("Recharge Credits: " + numFormater.format(this.prePaids[i].rechargeCredits) + " BRL\n");
            }
        }
        
        while (i < postPaidTels) {
            if (this.postPaids[i].callsQuantity > 0) {
                this.postPaids[i].printInvoice(invoiceMonth);
            }
        }
    }
    
    public static void main(String[] args) {
        telephony tel = new telephony();
        
        Date dt = new Date();
        
        @SuppressWarnings("resource")
        Scanner stdinScanner = new Scanner(System.in);
        
        long clientCPF = 0;
        String clientName = "";
        int clientTel = 0;
        
        int callDuration = 0;
        
        float clientSubscription = 0;
        
        float rcrg = 0;
        
        int invoiceMonth = 0;
        int month = 0;
        
        int initOpt = 0;
        int mainOpt = 0;
                
        while (initOpt != 6) {
            System.out.println("Type an option:\n" + "1. Sign up subscriber\n" + "2. Show subscribers\n" + "3. Make a call\n" + "4. Make a recharge\n" + "5. Print an invoice\n" + "6. Exit.");
            
            initOpt = stdinScanner.nextInt();
            
            switch (initOpt) {
                case 1:
                    System.out.println("The subscription is from:\n" + "1. Post Paid\n" + "2. Pre Paid.");
                    mainOpt = stdinScanner.nextInt();
                switch (mainOpt) {
                    case 1:
                        System.out.print("Client IE/CPF: ");
                        clientCPF = stdinScanner.nextLong();
                        System.out.print("Client Name: ");
                        clientName = stdinScanner.next();
                        System.out.print("Client Tel: ");
                        clientTel = stdinScanner.nextInt();
                        System.out.print("Client Subscription: ");
                        clientSubscription = stdinScanner.nextFloat();
                        break;
                    case 2:
                        System.out.println("Client IE/CPF: ");
                        clientCPF = stdinScanner.nextLong();
                        System.out.print("Client Name: ");
                        clientName = stdinScanner.next();
                        System.out.print("Client Tel: ");
                        clientTel = stdinScanner.nextInt();
                        break;
                    default:
                        System.out.print("Select another option.");
                        break;
                }
                    tel.signUpSubscriber(clientName, clientCPF, clientTel, clientSubscription);
                    break;

                case 2:
                    tel.sortSubscribers();
                    break;
                case 3:
                    System.out.print("Is it your subscription...?\n1. Post Paid\n2. Pre Paid");
                    mainOpt = stdinScanner.nextInt();
                    System.out.print("Type your IE/CPF: ");
                    clientCPF = stdinScanner.nextLong();
                    System.out.print("Type the call duration: ");
                    callDuration = stdinScanner.nextInt();
                    tel.makeCall(clientCPF, dt, callDuration);
                    break;
                case 4:
                    System.out.print("Type your IE/CPF: ");
                    clientCPF = stdinScanner.nextLong();
                    System.out.print("Type the recharge value: ");
                    rcrg = stdinScanner.nextFloat();
                    tel.makeRecharge(clientCPF, rcrg, dt);
                    break;
                case 5:
                    System.out.print("Type the month at which you would to view some of your invoices: ");
                    month = stdinScanner.nextInt();
                    invoiceMonth = month - 1;
                    tel.printInvoice(invoiceMonth);
                    break;
                default:
                    break;
            }
        }
    }
}