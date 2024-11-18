import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * this class run background progress
 */
public class MapAnalyzerProcessor {
   /**
    * started progress
    * @param inputFile     input file nane
    * @param outputFile    output file name
    * @throws IOException  for exception
    */
   public void process(String inputFile, String outputFile) throws IOException {

      // create file progress class
      FileHandler fileHandler = new FileHandler();

      // start to choosing route algorithms
      DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
      KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();

      // adds all routes to a list
      List<Route> allRoutes = new ArrayList<>();
      // Gets intercity connection information
      Neighborhood neighborhood = fileHandler.readFile(inputFile, allRoutes);

      // Stores the start and end points.
      String startPoint = fileHandler.getStartPoint();
      String endPoint = fileHandler.getEndPoint();

      // create and save the fastest route
      List<Route> fastestRoute = dijkstraAlgorithm.findFastestRoute(neighborhood, startPoint, endPoint);
      // create and store barely connected map
      List<Route> barelyConnectedMap = kruskalAlgorithm.findBarelyConnectedMap(allRoutes);
      // create and store fastest route for barely connected map
      List<Route> fastestRouteBarelyConnected = dijkstraAlgorithm.findFastestRoute(new Neighborhood() {{
         barelyConnectedMap.forEach(this::addConnection);
      }}, startPoint, endPoint);

      // Calculates the distance traveled for faster route.
      int originalDistance = fastestRoute.stream().mapToInt(Route::getRoadLength).sum();
      // Calculates the distance traveled for barely connected map.
      int barelyConnectedDistance = fastestRouteBarelyConnected.stream().mapToInt(Route::getRoadLength).sum();

      // It calculates the distance between 2 cities without creating a route.
      int originalMaterial = allRoutes.stream().mapToInt(Route::getRoadLength).sum();
      int barelyConnectedMaterial = barelyConnectedMap.stream().mapToInt(Route::getRoadLength).sum();

      // The results are written to the output file
      fileHandler.writeOutput(outputFile, fastestRoute, barelyConnectedMap, fastestRouteBarelyConnected, startPoint, endPoint, originalDistance, barelyConnectedDistance, originalMaterial, barelyConnectedMaterial);
   }


}
