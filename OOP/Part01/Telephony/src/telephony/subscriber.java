package telephony;

/**
* @author HenryCeresetti
**/

public class subscriber {
    private long clientCPF;
    private String clientName;
    private String clientNum;
    protected call[] calls;
    protected int clientNumCalls;
    
    public subscriber(long clientCPF, String clientName, String clientNum) {
        this.clientCPF = clientCPF;
        this.clientName = clientName;
        this.clientNum = clientNum;
    }
    
    public void setClientCPF(long clientCPF) {
        this.clientCPF = clientCPF;
    }
    
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
    public void setClientNum(String clientNum) {
        this.clientNum = clientNum;
    }
    
    public long getClientCPF() {
        return clientCPF;
    }
    
    public String getClientName() {
        return clientName;
    }
    
    public String getClientNum() {
        return clientNum;
    }
    
    public static String convertToString(long clientCPF, String clientName, String clientNum) {
        String subscriberData = "The subscriber attributes are:\nSubscriber Name: " + clientName + "Subscriber CPF: " + clientCPF + "Subscriber Phone Number: " + clientNum;
        System.out.print(subscriberData);
        return subscriberData;
    }
}