package output;
 // This class displays the sales report on the console.
 

public class ConsoleOutput implements OutputStrategy {
   /**
     * Displays the given report on the screen.
     *
     * @param report the sales report to display
     */
   
    @Override
    public void write(String report) {
         // Print the report on the console.
        System.out.println(report);
    }
}
