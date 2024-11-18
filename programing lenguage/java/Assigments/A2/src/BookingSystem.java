/**
 * @author b2230356164 M Mustafa KARARTAŞ
 *
 *
 */

/**
 * This is the main class, the entire operation is collected in this class.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BookingSystem {
   public static void main(String[] args) throws IOException {

      /**
       * Creates a class for file reading.
       */
      ReadFile io = new ReadFile(args[0]);

      /**
       * Creates a class for operations to be performed in the background.
       */
      OperationSystem operationSystem = new OperationSystem();
      operationSystem.setInputList(io.readFile());

      /**
       * Processes are started in the background
       */
      operationSystem.handleCommands();

      /**
       * To print a file, the required class is called and the data is written to the file and the file is closed.
       */
      GlobalLogger.openFile(args[1]);
      GlobalLogger.dumpLogsToFile();

      /**
       * To just delete the space in the last line
       */
      ReadFile trimFile = new ReadFile(args[1]);
      List<String> trimList = trimFile.readFile();
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
         for (int i = 0; i < trimList.size(); i++) {
            if (i != trimList.size() - 1) {
               writer.write(trimList.get(i));
               writer.newLine();
               writer.flush();
            } else {
               writer.write(trimList.get(i));
            }

         }
      } catch (IOException e) {
         System.out.println("Error writing to the file: " + e.getMessage());
      }
   }
}