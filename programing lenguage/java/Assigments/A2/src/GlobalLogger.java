import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *  This class takes the data to be written to the file and prints it to the file.
 */
public class GlobalLogger {
    private static List<String> logMessages = new ArrayList<>();
    private static PrintWriter writer = null;


    /**
     *This method allows us to access this class from anywhere.
     * @param message   This is the message to be written to the file.
     */
    public static synchronized void log(String message) {
        logMessages.add(message);
    }

    /**
     * opens the file
     * @param filename  this is for writing file nane
     */
    public static void openFile(String filename) {
        if (writer != null) {
            writer.close();
        }
        try {
            writer = new PrintWriter(filename);
        } catch (IOException e) {
            System.err.println("Error opening log file: " + e.getMessage());
        }
    }

    /**
     * It is the method that prints to the file.
     */
    public static void dumpLogsToFile() {
        if (writer != null) {
            for (String logMessage : logMessages) {
                writer.println(logMessage);
            }
            writer.flush();
        }
    }
}