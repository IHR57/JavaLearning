package CommandDP;

public class OffCommand implements Command{
    private TV tv;

    public OffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.switchOff();
    }
}
