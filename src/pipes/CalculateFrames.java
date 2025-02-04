package pipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculateFrames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> shots = new ArrayList<>();

        while (scanner.hasNextInt()) {
            shots.add(scanner.nextInt());
        }
        scanner.close();

        int shotIndex = 0;
        for (int round = 1; round <= 10; round++) {
            int frameScore = shots.get(shotIndex);
            if (frameScore == 10) {
                // Strike
                System.out.println("Frame " + round + ": " + (frameScore + shots.get(shotIndex + 1) + shots.get(shotIndex + 2)));
                shotIndex++;
            } else {
                int secondShot = shots.get(shotIndex + 1);
                if (frameScore + secondShot == 10) {
                    // Spare
                    System.out.println("Frame " + round + ": " + (frameScore + secondShot + shots.get(shotIndex + 2)));
                } else {
                    System.out.println("Frame " + round + ": " + (frameScore + secondShot));
                }
                shotIndex += 2;
            }
        }
    }
}

