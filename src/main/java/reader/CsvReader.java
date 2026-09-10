package reader;

import model.ProductSale;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvReader implements SalesReader {

    // Reads the CSV file and converts each valid row into a ProductSale object.
    @Override
    public List<ProductSale> read(String filePath) throws IOException {
        Path path = Path.of(filePath);

        // Checks whether the specified CSV file exists.
        if (!Files.exists(path)) {
            throw new IOException("CSV file not found: " + filePath);
        }

        List<String> lines = Files.readAllLines(path);
        List<ProductSale> sales = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();

            // Skips empty lines in the CSV file.
            if (line.isEmpty()) {
                continue;
            }

            // Skips the CSV header row when it is present.
            if (i == 0 && line.toLowerCase().startsWith("product_id")) {
                continue;
            }

            String[] columns = line.split(",", -1);

            // Validates that each row contains exactly five required columns.
            if (columns.length != 5) {
                throw new IllegalArgumentException(
                        "Invalid row at line " + (i + 1)
                                + ": expected 5 columns.");
            }

            try {
                // Converts the CSV values into a ProductSale object.
                ProductSale sale = new ProductSale(
                        columns[0].trim(),
                        columns[1].trim(),
                        columns[2].trim(),
                        Integer.parseInt(columns[3].trim()),
                        Double.parseDouble(columns[4].trim())
                );

                sales.add(sale);

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        "Invalid numeric value at line " + (i + 1) + ".", e);
            }
        }

        return sales;
    }
}