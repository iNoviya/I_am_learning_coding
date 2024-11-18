import java.io.Console;
import java.util.*;

/**
 * This class finds the shortest path between 2 specified cities using the Dijkstra algorithm.
 * For this purpose, it uses interconnected roads.
 */

public class DijkstraAlgorithm {

   /**
    * Finds the fastest route between 2 cities.
    * @param neighborhood
    * @param startPoint    starting point
    * @param endPoint      destination
    * @return     faster route
    */
   public List<Route> findFastestRoute(Neighborhood neighborhood, String startPoint, String endPoint) {


      // It measures the entire distance entered from the starting point.
      Map<String, Integer> distances = new HashMap<>();

      // holds possible advancements.
      Map<String, Route> roadHolder = new HashMap<>();

      // It also collects the cities visited in a set to prevent re-entering the places visited.
      Set<String> visitedCity = new HashSet<>();

      // Sorts possible routes by shortest distance.
      PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));


      // Sets the distance of all cities to the starting point as infinite.
      for (String city : neighborhood.getNeighborhoodCity()) {
         distances.put(city, Integer.MAX_VALUE);
      }
      // assume that, start point distance 0
      distances.put(startPoint, 0);
      pq.add(startPoint);

      // begins to find the route
      while (!pq.isEmpty()) {

         // pulls the nearest city from the list.
         String theNearestCity = pq.poll();

         // If a city has been visited, it will skip that city.
         // Prevents loop creation.
         if (!visitedCity.add(theNearestCity)) continue;

         // It takes in the neighbors of the city it is located in.
         List<Route> routes = neighborhood.getRoutes(theNearestCity);

         // It lists the cities first by their distance and then by their ID.
         routes.sort(Comparator.comparingInt(Route::getRoadLength).thenComparingInt(Route::getId));


         // try all neighborhood
         for (Route route : routes) {
            // If a city has been visited, it will skip that city.
            // Prevents loop creation.
            if (visitedCity.contains(route.getEnd())) continue;

            // calculate new distance
            int newDistance = distances.get(theNearestCity) + route.getRoadLength();

            // If the new distance is shorter, it updates the list.
            if (newDistance < distances.get(route.getEnd())) {
               distances.put(route.getEnd(), newDistance);
               roadHolder.put(route.getEnd(), route);
               pq.add(route.getEnd());
            }
         }
      }

      // chose the smallest route
      List<Route> path = new ArrayList<>();
      Stack<Route> stack = new Stack<>();
      String step = endPoint;

      while (roadHolder.containsKey(step)) {
         Route route = roadHolder.get(step);
         stack.push(route);
         step = route.getStart();
      }

      // I tried it out of curiosity, and it works like this too.
      // It would be more understandable with while,
      // but this is also nice. :D :D :D
      for (; !stack.isEmpty(); path.add(stack.pop()));



      // It examines the entire list and edits the format if it contradicts the format in the input file.
      for (Route  route : path ){
         if (!checkWay(neighborhood,route)){
            String temp = route.getStart();
            route.setStart(route.getEnd());
            route.setSend(temp);
         }
      }

      return path;
   }

   // Checks the location of the start and destination points.
   private boolean checkWay (Neighborhood neighborhood , Route route){
      for( String parts : neighborhood.getRoutesList()){
         String[] part = parts.split("\t");
         if (part[0].equals(route.getStart()) && part[1].equals(route.getEnd())){
            return true;
         }
      }
      return false;
   }
}
