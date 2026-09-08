package reader;

import model.ProductSale;

import java.io.IOException;
import java.util.List;

public interface SalesReader {

    //Reads sales data from the specified file.
     
    List<ProductSale> read(String filePath) throws IOException;
}
