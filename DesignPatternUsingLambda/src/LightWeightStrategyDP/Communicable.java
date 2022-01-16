package LightWeightStrategyDP;

@FunctionalInterface
public interface Communicable {
    String communicate(String destination, String message);
}
