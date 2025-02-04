package pipes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParseInput {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide the file path as a command-line argument.");
            return;
        }

        String filePath = args[0];
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
            System.out.println(fileContent.replaceAll("\\s+", " "));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

