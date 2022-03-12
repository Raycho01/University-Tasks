package CountCharsInString;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountChars {

    public static void countChars(String word) {

        String[] words = word.split(" ");

        Map<Character, Integer> charOccurrences = new LinkedHashMap<>();

        for (String singleWord : words) {
            for (int i = 0; i < singleWord.length(); i ++) {
                char letter = singleWord.charAt(i);
                Integer occurrences = charOccurrences.get(letter);
                if (occurrences != null) {
                    charOccurrences.put(letter, charOccurrences.get(letter) + 1);
                }
                else {
                    charOccurrences.put(letter, 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : charOccurrences.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        countChars(scanner.nextLine());
    }

}
