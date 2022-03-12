package RandomTasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ColoredBalls {

    public static int ifYouAreVeryVeryLucky(int total, int max) {
        return total - max;
    }

    public static int ifYouWannaBeSure(int total) {
        return total - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> colorBalls = new LinkedHashMap<>();                              // where we keep the balls

        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] input = line.split(": ");                              // using split so we can get our input

            String currColor = input[0];
            int currBallsCount = Integer.parseInt(input[1]);

            if (!colorBalls.containsKey(currColor)) {
                colorBalls.put(currColor, currBallsCount);                      // if there is no such color yet, put it
            } else {
                colorBalls.put(currColor, colorBalls.get(currColor) + currBallsCount);            // else, add the count
            }

            line = scanner.nextLine();
        }

        int maxCountInOneColor = 0;
        int totalBalls = 0;

        for (Map.Entry<String, Integer> entry : colorBalls.entrySet()) {   // iterate and find the total number of balls
            totalBalls += entry.getValue();                              // and the biggest number of balls in one color
            if (entry.getValue() > maxCountInOneColor) {
                maxCountInOneColor = entry.getValue();
            }
        }

        System.out.println("If you feel lucky, try taking out " + ifYouAreVeryVeryLucky(totalBalls, maxCountInOneColor) + " balls.");

        // smallest number you can remove from the box, so we can have balls from only one color (if you are lucky)

        System.out.println("If you want to be sure, try taking out " + ifYouWannaBeSure(totalBalls) + " balls.");

        // I didn't exactly get what I needed to do, so there is this option (if you wanna be sure)
    }
}
