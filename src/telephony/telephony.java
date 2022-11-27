package telephony;

/**
 * @author HenryCeresetti
 * @author OrlandoJunior
 */

import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class telephony {
    private int prePaidNum;
    private int postPaidNum;
    private prePaid[] prePaids;
    private postPaid[] postPaids;
    prePaid rechargeCredits;
    
    public telephony() {
        super();
        this.prePaids = new prePaid[100];
        this.postPaids = new postPaid[100];
    }
    
    public void signUpSubscriber(String clientNum, long clientCPF, String clientName, float clientSubscription, int optSwitch) {
        int i = 0;
        
        if (optSwitch == 1) {
            this.postPaidNum++;
            
            while (i < postPaidNum) {
                if (this.postPaids[i] == null) {
                    postPaid posp = new postPaid(clientNum, clientCPF, clientName, clientSubscription);
                    this.postPaids[i] = posp;
                }
                i++;
            }
        } else if (optSwitch == 2) {
            this.prePaidNum++;
            
            while (i < prePaidNum) {
                if (this.prePaids[i] == null) {
                    prePaid ppd = new prePaid(clientCPF, clientName, clientNum);
                    this.prePaids[i] == ppd;
                }
                i++;
            }
        }
    }
    
    public void sortSubscribers() {
        int i = 0;
        
        while (i < prePaidNum) {
            if (this.prePaids[i] != null) {
                System.out.println(this.prePaids[i].toString() + "\n");
            }
            i++;
        }
        
        while (i < postPaidNum) {
            if (this.postPaids[i] != null) {
                System.out.println(this.postPaids[i].toString());
            }
            i++;
        } 
    }
    
    public void makeCall(long clientCPF, Date callDate, int callDuration) {  
        int defaultOpt = 0;
        System.out.println(defaultOpt);
        
        switch (defaultOpt) {
            case 1:
                if (this.fetchPostPaid(clientCPF) != null) {
                    postPaid cll = this.fetchPostPaid(clientCPF);
                    cll.makeCall(callDate, callDuration);
                    System.out.println("The call has been made.");
                } else {
                    System.out.println("The subscriber has not been found in our telephony system.");
                }   break;
            case 2:
                if (this.fetchPrePaid(clientCPF) != null && rechargeCredits != null) {
                    prePaid cll = this.fetchPrePaid(clientCPF);
                    cll.makeCall(callDate, callDuration);
                    System.out.println("The call has been made.");
                } else if (this.fetchPrePaid(clientCPF) == null) {
                    System.out.println("The subscriber has not been found in our telephony system.");
                } else {
                    System.out.println("You do not have credits to make this call.");
                }   break;
            default:
                System.out.println("Select another option.");
                break;
        }
    }
    
    public void makeRecharge(long clientCPF, float rechargeValue, Date rechargeDate) {
        if (this.fetchPrePaid(clientCPF) != null) {
            prePaid rcrg = this.fetchPrePaid(clientCPF);
            rcrg.recharge(rechargeDate, rechargeValue);
            System.out.println("Recharge made successfully.");
        } else {
            System.out.println("The subscriber has not been found in our telephony system.");
        }
    }
    
    public prePaid fetchPrePaid(long clientCPF) {
        int i = 0;
        
        while (i < prePaidNum) {
            if (this.prePaids[i] != null) {
                if (this.prePaids[i].getClientCPF() == clientCPF) {
                    return this.prePaids[i];
                }
                i++;
                } else {
                    System.out.println("Echo test.");
                    return null;
                }
        }
        return null;
    }
    
    public postPaid fetchPostPaid(long clientCPF) {
        int i = 0;
        
        while (i < postPaidNum) {
            if (this.postPaids[i].getClientCPF() == clientCPF) {
                i++;
                return this.postPaids[i];
            } else {
                return null;
            }
        }
        return null;
    }
    
    public void printInvoices(int invoiceMonth) {
        int i = 0;
        
        while (i < prePaidsNum) {
            if (this.prePaids[i] != null) {
                long clientCPF = this.prePaids[i].getClientCPF();
                prePaid ppd = new prePaid(clientCPF, "Henry", 143);
                ppd.printInvoice(invoiceMonth + "\n");
            }
        }
        
        while (i < postPaidNum) {
            if (i < postPaidNum) {
                postPaid posp = new postPaid(170, 963, "Orlando", 876);
                posp.printInvoice(invoiceMonth);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner stdinScanner = Scanner(System.in);
        
        int mainOpt = 0;
        int subOpt = 0;
        int x = 0;
        
        int clientNum = 0;
        long clientCPF = 0;
        String clientName = "";
        int clientDuration = 0;
        
        float clientSubscription = 0;
        float rcrg = 0;
        
        int invoiceMonth = 0;
        
        call[] call = new call[10];
        
        while (mainOpt != 6) {
            System.out.println("Type an option:\n" + "1. Sign up subscriber\n" + "2. Show subscribers\n" + "3. Make call\n" + "4. Make recharge\n" + "5. Print invoices\n" + "6. Exit.");
            
            mainOpt = stdinScanner.nextInt();
            
            if (mainOpt == 1) {
                System.out.println("The subscription is from:\n" + "1. Post Paid\n" + "2. Pre Paid.");
                subOpt = stdinScanner.nextInt();
                
                if (subOpt == 1) {
                    System.out.print("Client Subscription: ");
                    clientSubscription = stdinScanner.nextFloat();
                    System.out.print("Client Number: ");
                    clientNum = stdinScanner.nextInt();
                    System.out.print("Client CPF: ");
                    clientCPF = stdinScanner.nextLong();
                    System.out.print("Client Name: ");
                    clientName = stdinScanner.next();
                } else if (subOpt == 2) {
                    System.out.print("Client Number: ");
                    clientNum = stdinScanner.nextInt();
                    System.out.print("Client CPF: ");
                    clientCPF = stdinScanner.nextLong();
                    System.out.print("Client Name: ");
                    clientName = stdinScanner.next();
                } else {
                    System.out.print("Select another option.");
                }
                tel.signUpSubscriber(subOpt, clientSubscription, clientCPF, clientNum, clientName);
            } else if (mainOpt == 2) {
                tel.showSubscribers();
            } else if (mainOpt == 3) {
                System.out.println("Your subscription is:\n1. Post Paid\n2. Pre Paid");
                subOpt = stdinScanner.nextInt();
                
                System.out.print("Type your IE/CPF: ");
                clientCPF = stdinScanner.nextLong();
                
                System.out.println("Type the call duration: ");
                callDuration = stdinScanner.nextInt();
                
                tel.makeCall(subOpt, clientCPF, dt, callDuration);
            } else if (mainOpt == 4) {
                System.out.print("Type your IE/CPF: ");
                clientCPF = stdinScanner.nextLong();
                
                System.out.print("Type the recharge value, in BRL money currency format: ");
                rcrg = stdinScanner.nextFloat();
                
                tel.makeRecharge(clientCPF, rgrc, dt);
            } else if (mainOpt == 5) {
                System.out.print("Type the month at which you would to view some of your invoices: ");
                invoiceMonth = stdinScanner.nextInt();
                tel.printInvoices(invoiceMonth);
            }
        }
    }
}