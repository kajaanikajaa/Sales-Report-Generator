
package exception;

// Custom exception class used for errors related to sales reports.
public class SalesReportException extends Exception {

    // Constructor used to create an exception with an error message.
    public SalesReportException(String message) {
        super(message);
    }

    // Constructor used to create an exception with an error message
    // and the original cause of the error.
    public SalesReportException(String message, Throwable cause) {
        super(message, cause);
    }
}
