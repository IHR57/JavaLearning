package LightWeightStrategyDP;

public class CommunicationService {
    private Communicable communicable;

    public void setCommunicable(Communicable communicable) {
        this.communicable = communicable;
    }

    public void sendMessage(String dest, String msg) {
        var log = communicable.communicate(dest, msg);
        System.out.println(log);
    }
}
