import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
   private static String _inputFileName;

   ReadFile(String inputFileName) {
      this._inputFileName = inputFileName;
   }

   public static String getInputFileName() {
      return _inputFileName;
   }

   public List<String> readFile() {
      File INPUT_FILE = new File(_inputFileName);

      List<String> inputList = new ArrayList<>();

      try (BufferedReader inputs = new BufferedReader(new FileReader(INPUT_FILE))) {
         String row;
         while ((row = inputs.readLine()) != null) {
            String trimmedRow = row.trim();
            if (!trimmedRow.isEmpty()) {
               inputList.add(trimmedRow);
            }
         }
      } catch (IOException e) {
         System.out.println("File read error: " + e.getMessage());
      }
      return inputList;
   }
}
