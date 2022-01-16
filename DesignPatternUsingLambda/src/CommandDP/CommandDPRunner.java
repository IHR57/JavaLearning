package CommandDP;

public class CommandDPRunner {
    public static void run() {
        System.out.println("Running Command Design Pattern example!!");
        TV tv = new TV();

        // without lambda expression
//        Command onCommand = new OnCommand(tv);
//        Command offCommand = new OffCommand(tv);
//
//        RemoteControl remoteControl = new RemoteControl();
//        remoteControl.press(onCommand);
//        remoteControl.press(offCommand);

        // using lambda expression
        // we no longer need onCommand and offCommand class
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.press(() -> tv.switchOn());
        remoteControl.press(() -> tv.switchOff());
    }
}
