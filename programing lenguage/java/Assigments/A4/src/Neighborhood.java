import java.util.*;

/**
 * This class preserves neighborly relations.
 */

public class Neighborhood {

    // It maintains a list of neighbors for each city.
   private Map<String, List<Route>> _neighborhoodslist;

   // It keeps the route data in the input file as a string list.
   private List<String> _routesList ;

   /**
    * contractor method
    */
   public Neighborhood() {
      this._neighborhoodslist = new HashMap<>();
      this._routesList = new ArrayList<>();
   }


   /**
    *
    * @param route   // route
    */
   public void addConnection(Route route) {

      // add a list raw data
      _routesList.add(route.writeFormat());


      // Creates separate lists for arrival and destination points on maps,
      // if there is no list of specified cities.
      _neighborhoodslist.putIfAbsent(route.getStart(), new ArrayList<>());
      _neighborhoodslist.putIfAbsent(route.getEnd(), new ArrayList<>());

      // Adds routes to the list.
      _neighborhoodslist.get(route.getStart()).add(route);
      _neighborhoodslist.get(route.getEnd()).add(new Route(route.getEnd(), route.getStart(), route.getRoadLength(), route.getId()) );
   }


   /**
    * Returns a list of cities that are adjacent to the specified city by roads.
    * @return city's neighborhoods
    */
   public List<Route> getRoutes(String city) {
      return _neighborhoodslist.getOrDefault(city, new ArrayList<>());
   }


   // getter setter method
   public Set<String> getNeighborhoodCity() {
      return _neighborhoodslist.keySet();
   }

   public List<String> getRoutesList(){
      return _routesList;
   }
}
