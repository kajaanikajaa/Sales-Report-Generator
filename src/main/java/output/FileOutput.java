package output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This class saves the sales report into a file.
 */

public class FileOutput implements OutputStrategy {

    // Stores the location of the file where the report will be saved.
    private final String filePath;

     /**
     * Creates a FileOutput object with the file path.
    
     * @param filePath the path of the output file
     */

    public FileOutput(String filePath) {
        this.filePath = filePath;
    }
     /**
     * Writes the sales report to the specified file.
     
     * @param report the sales report to save
     * @throws IOException if the file cannot be written
     */

    @Override
    public void write(String report) throws IOException {
        // Convert the file path into a Path object and write the report to the file.
        Files.writeString(Path.of(filePath), report);
    }
}
