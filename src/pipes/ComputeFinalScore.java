package pipes;

import java.util.Scanner;

public class ComputeFinalScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int finalScore = 0;
        int frameNumber = 1;

        while (scanner.hasNextLine() && frameNumber <= 10) {
            String line = scanner.nextLine();
            String[] parts = line.split(": ")[1].split(" ");
            int frameScore = Integer.parseInt(parts[0]);

            finalScore += frameScore;
            frameNumber++;
        }
        scanner.close();
        System.out.println("Final Score: " + finalScore);
    }
}
