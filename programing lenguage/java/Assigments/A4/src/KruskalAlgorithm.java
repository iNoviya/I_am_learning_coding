import java.util.*;

/**
 *This class is to connect specified cities using the minimum number of roads using the Kruskal algorithm.
 * We use this algorithm because we avoid creating loops when connecting cities.
 */


public class KruskalAlgorithm {

   /**
    *
    * @param allRoutes     It is a list indicating all routes.
    * @return  return list barelyConnectedMap to find route
    */
   public List<Route> findBarelyConnectedMap(List<Route> allRoutes) {
      // Sorts the route by distance. If there is a tie, it reorders according to ID numbers.
      // This ensures that the one with the smallest id is selected in case of equality, as stated in the figure.
      allRoutes.sort(Comparator.comparingInt(Route::getRoadLength).thenComparingInt(Route::getId));

      // A map List is created that stores the start and end points of the roads for Union-Find structure
      Map<String, String> parent = new HashMap<>();
      for (Route route : allRoutes) {
         parent.putIfAbsent(route.getStart(), route.getStart());
         parent.putIfAbsent(route.getEnd(), route.getEnd());
      }

      // keeps the route
      List<Route> barelyConnectedMap = new ArrayList<>();

      // It finds the cities that are wanted to be connected to each other on the routes.
      Set<String> cities = new HashSet<>();
      for (Route route : allRoutes){
         cities.add(route.getStart());
         cities.add(route.getEnd());
      }

      // It combines parts according to the union-find structure.
      for (Route route : allRoutes) {
         String startPoint = findRoute(route.getStart(), parent);
         String endPoint = findRoute(route.getEnd(), parent);
         if (!endPoint.equals(startPoint)) {
            barelyConnectedMap.add(route);
            parent.put(startPoint, endPoint);
         }

         // If it exceeds or equals the number of unic cities in the routes,
         // it terminates the loop. Because it is impossible for this to happen.
         // (For n points, there are only (n-1) connection lines)
         if (barelyConnectedMap.size() >= cities.size() ) break;
      }
      return barelyConnectedMap;
   }


   /**
    * Finds the root for the specified city.
    * @param city    city name
    * @param parent  parent map list
    * @return  city's features
    */
   private String findRoute(String city, Map<String, String> parent) {
      while (!parent.get(city).equals(city)) {
         parent.put(city, parent.get(parent.get(city)));
         city = parent.get(city);
      }
      return city;
   }
}
