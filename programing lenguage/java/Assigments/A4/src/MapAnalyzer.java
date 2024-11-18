import java.io.*;

/**
 * @author b2230356164
 * @author Muhammet Mustafa KARATAS
 * @ BBM 104 Assigment 4  Map Analyzer
 */

public class MapAnalyzer {
   public static void main(String[] args) throws IOException {
      if (args.length != 2) {
         System.err.println("ERROR ::: ");
         return;
      }

      // input output file name
      String inputFile = args[0];
      String outputFile = args[1];

      // all background progress
      MapAnalyzerProcessor mapAnalyzerProcessor = new MapAnalyzerProcessor();
      mapAnalyzerProcessor.process(inputFile,outputFile);
   }
}
