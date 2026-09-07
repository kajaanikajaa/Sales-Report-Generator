package service;

import org.junit.jupiter.api.Test;
import model.ProductSale;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalesCalculatorTest {
   
   // Create a SalesCalculator object to test its methods.
    private final SalesCalculator calculator = new SalesCalculator();


   /**
     * Tests whether the revenue is calculated correctly.
     */
    @Test
    void shouldCalculateRevenueCorrectly() {

        // Create a product sale with quantity and unit price.
        ProductSale sale =
                new ProductSale("P001", "Wireless Mouse", "Electronics", 12, 25.50);
        
         // Check whether the calculated revenue is 306.00.
        assertEquals(306.00, calculator.calculateRevenue(sale), 0.001);
    }
    
    /**
     * Tests whether the product with the highest quantity sold
     * is correctly identified as the best-selling product.
     */

    @Test
    void shouldDetectBestSellingProduct() {

        // Create two products with different quantities sold.
        ProductSale mouse =
                new ProductSale("P001", "Wireless Mouse", "Electronics", 12, 25.50);
        ProductSale pen =
                new ProductSale("P004", "Ballpoint Pen", "Stationery", 100, 0.50);
        
        // Find the best-selling product from the list.
        ProductSale result =
                calculator.bestSellingProduct(List.of(mouse, pen));
     
      // Check whether the Ballpoint Pen is identified as the best-selling product.
        assertEquals("Ballpoint Pen", result.getProductName());

      // Check whether its quantity sold is correctly identified as 100.  
        assertEquals(100, result.getQuantitySold());
    }
}
