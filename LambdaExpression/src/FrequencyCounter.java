import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {

    public static void run() {
        List<String> words = Arrays.asList("Hello", "World", "Bangladesh", "Dhaka",
                "Hello", "Java", "Code", "Lambda", "Function", "Lambda");

        Map<String, Long> wordFrequency = countFrequency(words);

        System.out.println(wordFrequency);
    }

    private static Map<String, Long> countFrequency(List<String> words) {
        Map<String, Long> frequencyMap = new HashMap<>();

        for(String word: words) {
            frequencyMap.merge(word, 1L, (oldValue, newValue) -> oldValue + newValue);
        }

        return frequencyMap;
    }
}
