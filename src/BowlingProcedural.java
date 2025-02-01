import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class BowlingProcedural {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the directory path as a command line argument.");
            return;
        }

        String filePath = args[0];

        String fileContent = readFile(filePath);
        System.out.println(fileContent);
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