package output;

import java.io.IOException;
/**
 * This interface defines how a sales report should be written.
 * Different output classes can use this interface.
 */

public interface OutputStrategy {
     /**
     * Writes the given sales report.
     
     * @param report the sales report to be written
     * @throws IOException if an error occurs while writing the report
     */
    void write(String report) throws IOException;
}
