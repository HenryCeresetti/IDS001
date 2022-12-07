package telephony;

/**
 * @author HenryCeresetti
 * @author OrlandoJunior
 */

public class subscriber {
    protected call[] calls;
    protected int callsQuantity;
    
    private long clientCPF;
    private String clientName;
    private int clientTel;
    
    public subscriber(int clientTel, long clientCPF, String clientName) {
        this.clientCPF = clientCPF;
        this.clientName = clientName;
        this.clientTel = clientTel;
        this.calls = new call[75];
    }
    
    public long getClientCPF() {
        return clientCPF;
    }
    
    @Override
    public String toString() {
        return "The subscriber fields are:\n" + "Subscriber: " + clientName + "\nSubscriber IE/CPF: " + clientCPF + "\nSubscriber Tel Num: " + clientTel;
    }
}