package oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BowlingOOP {
    public static void main(String[] args) {
        System.out.println("Bowling OOP");
        if (args.length < 1) {
            System.out.println("Please provide the directory path as a command line argument.");
            return;
        }

        String filePath = args[8];
        System.out.println("File path: " + filePath);
        String fileContent = readFile(filePath);
        List<String> shots = List.of(fileContent.split("\\s+"));

        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.play(shots);
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
