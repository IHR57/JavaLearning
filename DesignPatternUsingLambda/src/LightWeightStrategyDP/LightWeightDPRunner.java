package LightWeightStrategyDP;

public class LightWeightDPRunner {
    public static void run() {
        System.out.println("Running Light-weight Design Patter Example");

        var communicationService = new CommunicationService();

        communicationService.setCommunicable(((destination, message) ->
                "Communicating via Email -> Sending message to destination: [" + destination + "] message: " +
                        "[" + message + "]"));
        communicationService.sendMessage("testiqbal123@gmail.com", "Happy New Year");

        // if not lambda expression used then we had to write extra class

        communicationService.setCommunicable(((destination, message) ->
                "Communicating via Phone -> Sending message to destination: [" + destination + "] message: " +
                        "[" + message + "]"));
        communicationService.sendMessage("+8801245667788", "Hello there!");
    }
}
