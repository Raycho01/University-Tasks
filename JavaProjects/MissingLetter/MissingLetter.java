package MissingLetter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MissingLetter {

    public static char missingLetter(String sent, String received) {

        // sent: ivanov
        // received: vniao


        // sent: accessibility
        // received: accesibility


        // sent: vesko
        // received: vesk


        // sent: raycho
        // received: rayho


        // sent: aaabaa
        // received: aaaaa


        // sent: aaaaaa
        // received: aaaaa

        boolean flag = true;

        for (int i = 0 ; i < received.length(); i ++) {
            if (sent.charAt(i) != received.charAt(i)) {
                flag = false;
                break;
            }
        }

        if (flag) {
            return sent.charAt(sent.length()-1);
        }

        HashMap<Character, Integer> records = new HashMap<>();

        for (int i = 0 ; i < sent.length(); i ++) {
        records.put(sent.charAt(i), 0);
        }

        List<Character> used = new ArrayList<>();

        for (int i = 0 ; i < received.length(); i ++) {
            for (int j = 0; j < sent.length(); j ++) {
                if (sent.charAt(j) == received.charAt(i) && !used.contains(sent.charAt(j))) {
                    records.put(sent.charAt(j), records.get(sent.charAt(j)) + 1);
                    used.add(sent.charAt(j));
                }

            }

        }

        for (Character ch : records.keySet()) {
            if (records.get(ch) == 0) {
                return ch;
            }
        }

        int counter = 0;

        for (Character ch : records.keySet()) {
            for (int i = 0; i < sent.length(); i ++) {
                if (sent.charAt(i) == ch) {
                    counter ++;
                }
            }
            if (counter - records.get(ch) != 0) {
                return ch;
            }
            else {
                counter = 0;
            }
        }

        return '0';
    }

    public static void main(String[] args) {
        System.out.println(missingLetter("ivanov", "vniao"));
        System.out.println(missingLetter("aaaaaa", "aaaaa"));
        System.out.println(missingLetter("vesko", "vesk"));
        System.out.println(missingLetter("raycho", "rayho"));
        System.out.println(missingLetter("aaabaa", "aaaaa"));
    }
}
