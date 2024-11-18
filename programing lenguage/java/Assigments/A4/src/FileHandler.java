import java.io.*;
import java.util.*;

/**
 * this class for created to carry out file read and write
 */
public class FileHandler {
   // starting city
   private String _startPoint;

   // ending city
   private String _endPoint;

   /**
    * Read file and created to  raw data for progress
    * @param inputFile  input file name
    * @param allRoutes  all routes
    * @return  city'S neighborhood list for that city
    * @throws IOException  for reading file extensions
    */
   public Neighborhood readFile(String inputFile, List<Route> allRoutes) throws IOException {
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      String[] points = reader.readLine().split("\t");


      this._startPoint = points[0];
      this._endPoint = points[1];

      Neighborhood neighborhood = new Neighborhood();
      String line;
      while ((line = reader.readLine()) != null) {
         String[] parts = line.split("\t");
         String start = parts[0];
         String end = parts[1];
         int distance = Integer.parseInt(parts[2]);
         int id = Integer.parseInt(parts[3]);

         // create rotue class
         Route route = new Route(start, end, distance, id);
         neighborhood.addConnection(route);
         allRoutes.add(route);
      }
      reader.close();
      return neighborhood;
   }


   /**
    * its for write true output
    * @param outputFile    output file name
    * @param fastestRoute  the faster route
    * @param barelyConnectedMap     barely Connected Routh
    * @param fastestRouteBarelyConnected  faster routhe for barely connected rauth
    * @param startPoint    starting city
    * @param endPoint      ariveing city
    * @param originalDistance    raw distance between 2 city
    * @param barelyConnectedDistance   barely Connected distance 2 city
    * @param originalMaterial
    * @param barelyConnectedMaterial
    * @throws IOException     for exception
    */
   public void writeOutput(String outputFile, List<Route> fastestRoute, List<Route> barelyConnectedMap, List<Route> fastestRouteBarelyConnected, String startPoint, String endPoint, int originalDistance, int barelyConnectedDistance, int originalMaterial, int barelyConnectedMaterial) throws IOException {
      BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

      // write the route on file
      writer.write("Fastest Route from " + startPoint + " to " + endPoint + " (" + originalDistance + " KM):\n");
      writeRoutes(writer, fastestRoute);

      writer.write("Roads of Barely Connected Map is:\n");
      writeRoutes(writer, barelyConnectedMap);

      writer.write("Fastest Route from " + startPoint + " to " + endPoint + " on Barely Connected Map (" + barelyConnectedDistance + " KM):\n");
      writeRoutes(writer, fastestRouteBarelyConnected);

      // Analysis progress
      writer.write("Analysis:\n");
      writer.write("Ratio of Construction Material Usage Between Barely Connected and Original Map: " + String.format("%.2f", (double) barelyConnectedMaterial / originalMaterial) + "\n");
      writer.write("Ratio of Fastest Route Between Barely Connected and Original Map: " + String.format("%.2f", (double) barelyConnectedDistance / originalDistance));

      // close file
      writer.flush();
      writer.close();
   }

   /**
    * it's a standart comst to write route for output
    * prevents code duplication.
    * @param writer     BufferWrite parameters
    * @param routes     routes list
    * @throws IOException  for exception
    */
   private void writeRoutes(BufferedWriter writer, List<Route> routes) throws IOException {
      for (Route route : routes) {
         writer.write(route.writeFormat() + "\n");
      }
   }


   // getter setter methods
   public String getStartPoint() {
      return _startPoint;
   }

   public String getEndPoint() {
      return _endPoint;
   }
}
