import java.util.HashMap;
import java.util.Map;

public class P4_FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Count frequencies of each character
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Find first character with frequency 1
        for (char c : text.toCharArray()) {
            if (frequencyMap.get(c) == 1) {
                return c;
            }
        }

        return '\0'; // Return null character if no unique character exists
    }

    public static void processInput(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("\"" + text + "\" -> First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("\"" + text + "\" -> No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        processInput("swiss");
        processInput("aabbcc");
    }
}
