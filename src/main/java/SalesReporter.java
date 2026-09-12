import exception.SalesReportException;
import model.ProductSale;
import output.ConsoleOutput;
import output.FileOutput;
import output.OutputStrategy;
import reader.CsvReader;
import reader.SalesReader;
import report.SalesReport;

import java.io.IOException;
import java.util.List;

// Main class responsible for reading sales data and generating the report.
public class SalesReporter {

    // Program execution starts from the main method.
    public static void main(String[] args) {

        try {
            // Check whether the correct number of command-line arguments is given.
            if (!isValidArgumentCount(args)) {
                printUsage();
                return;
            }

            // Get the CSV file path from the first argument.
            String csvPath = args[0];

            // Get the output method and convert it to lowercase.
            String outputMethod = args[1].toLowerCase();

            // Check whether the output method is console or file.
            if (!isValidOutputMethod(outputMethod)) {
                throw new SalesReportException("Error: output method must be 'console' or 'file'.");
            }

            // If file output is selected, an output file path must be provided.
            if (outputMethod.equals("file") && args.length != 3) {
                throw new SalesReportException("Error: output file path is required when using 'file'.");
            }

            // Create a CSV reader to read sales data from the input file.
            SalesReader reader = new CsvReader();

            // Read the CSV file and store the sales records in a list.
            List<ProductSale> sales = reader.read(csvPath);

            // Generate the sales report using the sales data.
            String report = new SalesReport().generate(sales);

            // Create the required output method.
            OutputStrategy output = createOutput(outputMethod, args);

            // Write the generated report to the selected output.
            output.write(report);

        } catch (SalesReportException e) {
            // Display custom exception message cleanly
            System.err.println(e.getMessage());
        } catch (IOException | IllegalArgumentException e) {
            // Display an error message if reading or processing fails.
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Checks whether the number of command-line arguments is valid.
    private static boolean isValidArgumentCount(String[] args) {
        return args.length >= 2 && args.length <= 3;
    }

    // Checks whether the selected output method is supported.
    private static boolean isValidOutputMethod(String outputMethod) {
        return outputMethod.equals("console")
                || outputMethod.equals("file");
    }

    // Creates the correct output object based on the selected method.
    private static OutputStrategy createOutput(
            String outputMethod,
            String[] args) {

        // Use ConsoleOutput when the user selects console output.
        if (outputMethod.equals("console")) {
            return new ConsoleOutput();
        }

        // Use FileOutput when the user selects file output.
        return new FileOutput(args[2]);
    }

    // Displays the correct command-line usage format.
    private static void printUsage() {
        System.err.println(
                "Usage: java SalesReporter "
                        + "<csv-file-path> <output-method> "
                        + "[output-file-path]");
    }
}