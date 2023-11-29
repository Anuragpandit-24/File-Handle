package FIle;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Handle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "example.txt";

        // Create a Path object
        Path path = Paths.get(filePath);

        // Check if the file exists
        if (Files.exists(path)) {
            System.out.println("File already exists.");
        } else {
            // Create a new file
            try {
                Files.createFile(path);
                System.out.println("File created successfully.");
            } catch (IOException e) {
                System.err.println("Error creating the file: " + e.getMessage());
            }
        }

        // Write to the file
        String content = "Hello, this is a sample file content.";
        try {
            Files.write(path, content.getBytes());
            System.out.println("Content written to the file.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }

        // Read from the file
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println("File content:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }

        // Delete the file
        try {
            Files.delete(path);
            System.out.println("File deleted successfully.");
        } catch (IOException e) {
            System.err.println("Error deleting the file: " + e.getMessage());
        }

	}

}
