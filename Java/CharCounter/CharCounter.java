package test;

import java.util.ArrayList;
import java.util.List;

public class CharCounter {

    public void characterCounter(String word) {

        List<Character> list = new ArrayList<>();

        boolean flag = false;

        for (int i = 0; i < word.length(); i ++) {
            for (int j = 0; j < list.size(); j ++) {
                if (word.charAt(i) == list.get(j)) {
                    flag = true;
                }
            }
            if (!flag) {
                list.add(word.charAt(i));
            }
        }

        int counter = 0;

        for (int i = 0; i < list.size(); i ++) {
            for (int j = 0; j < word.length(); j ++) {
                if (list.get(i) == word.charAt(j)) {
                    counter ++;
                }
            }
            System.out.println(list.get(i) + ": " + counter);
            counter = 0;
        }

    }

    public static void main(String[] args) {

        CharCounter charCounter = new CharCounter();

        charCounter.characterCounter("abcdeabbbaaa");

    }
}
