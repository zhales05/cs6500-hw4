package procedural;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class BowlingProcedural {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the directory path as a command line argument.");
            return;
        }

        String filePath = args[11];
        System.out.println("File path: " + filePath);
        String fileContent = readFile(filePath);
        List<String> shots = List.of(fileContent.split("\\s+"));

        int shotIndex = 0;
        int finalScore = 0;
        int round = 1;

        while(round <= 10) {
            int roundTotal = 0;
            int firstShot = Integer.parseInt(shots.get(shotIndex++));
            roundTotal += firstShot;

            if(firstShot != 10) {
                int secondShot = Integer.parseInt(shots.get(shotIndex++));
                roundTotal += secondShot;
            } else {
                //is strike add next two shots
                roundTotal += Integer.parseInt(shots.get(shotIndex));
                roundTotal += Integer.parseInt(shots.get(shotIndex + 1));
            }

            if (roundTotal == 10) {
                //spare (strike should be above 10)
                roundTotal += Integer.parseInt(shots.get(shotIndex));

                if(round == 10 && shotIndex < shots.size() - 1) {
                    roundTotal += Integer.parseInt(shots.get(shotIndex+1));
                }
            }

            finalScore += roundTotal;
            round++;
        }
        System.out.println("Final Score: " + finalScore);
    }

    private static String readFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}