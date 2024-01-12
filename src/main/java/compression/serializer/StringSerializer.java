package compression.serializer;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class StringSerializer {

    private static final Map<Integer, Character> dictionary = createDictionary();

    public static String serialize(int[] numbers) {
        StringBuilder result = new StringBuilder();

        for (int number : numbers) {
            result.append(dictionary.get(number));
        }

        return result.toString();
    }

    public static int[] deserialize(String serialized) {
        Map<Character, Integer> dictionary = createReverseDictionary();
        int[] result = new int[serialized.length()];

        for (int i = 0; i < serialized.length(); i++) {
            result[i] = dictionary.get(serialized.charAt(i));
        }

        return result;
    }

    private static Map<Integer, Character> createDictionary() {
        Map<Integer, Character> dictionary = new HashMap<>();
        int counter = 33;

        for (int i = 1; i <= 300; i++) {
            dictionary.put(i, (char) counter);
            counter++;
        }

        return dictionary;
    }

    private static Map<Character, Integer> createReverseDictionary() {
        Map<Character, Integer> reverseDictionary = new HashMap<>();
        for (Map.Entry<Integer, Character> entry : dictionary.entrySet()) {
            reverseDictionary.put(entry.getValue(), entry.getKey());
        }

        return reverseDictionary;
    }

}
