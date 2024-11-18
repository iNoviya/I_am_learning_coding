import java.io.*;
import java.util.*;

public class MapAnalyzer {
   static class Road {
      String start;
      String end;
      int distance;
      int id;

      Road(String start, String end, int distance, int id) {
         this.start = start;
         this.end = end;
         this.distance = distance;
         this.id = id;
      }
   }

   static class Graph {
      Map<String, List<Road>> adjList = new HashMap<>();

      void addRoad(Road road) {
         adjList.putIfAbsent(road.start, new ArrayList<>());
         adjList.putIfAbsent(road.end, new ArrayList<>());
         adjList.get(road.start).add(road);
         adjList.get(road.end).add(new Road(road.end, road.start, road.distance, road.id));
      }

      List<Road> getRoads(String point) {
         return adjList.getOrDefault(point, new ArrayList<>());
      }

      Set<String> getPoints() {
         return adjList.keySet();
      }
   }

   public static void main(String[] args) throws IOException {
      if (args.length != 2) {
         System.err.println("Usage: java MapAnalyzer <input file> <output file>");
         return;
      }

      String inputFile = args[0];
      String outputFile = args[1];

      BufferedReader br = new BufferedReader(new FileReader(inputFile));
      BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

      String[] points = br.readLine().split("\t");
      String startPoint = points[0];
      String endPoint = points[1];

      Graph graph = new Graph();
      List<Road> allRoads = new ArrayList<>();

      String line;
      while ((line = br.readLine()) != null) {
         String[] parts = line.split("\t");
         String start = parts[0];
         String end = parts[1];
         int distance = Integer.parseInt(parts[2]);
         int id = Integer.parseInt(parts[3]);
         Road road = new Road(start, end, distance, id);
         graph.addRoad(road);
         allRoads.add(road);
      }
      br.close();

      List<Road> fastestRoute = findFastestRoute(graph, startPoint, endPoint);
      List<Road> barelyConnectedMap = findBarelyConnectedMap(allRoads, graph.getPoints().size());
      List<Road> fastestRouteBarelyConnected = findFastestRouteOnBarelyConnectedMap(barelyConnectedMap, startPoint, endPoint);

      int originalDistance = fastestRoute.stream().mapToInt(r -> r.distance).sum();
      int barelyConnectedDistance = fastestRouteBarelyConnected.stream().mapToInt(r -> r.distance).sum();
      int originalMaterial = allRoads.stream().mapToInt(r -> r.distance).sum();
      int barelyConnectedMaterial = barelyConnectedMap.stream().mapToInt(r -> r.distance).sum();

      bw.write("Fastest Route from " + startPoint + " to " + endPoint + " (" + originalDistance + " KM):\n");
      for (Road road : fastestRoute) {
         bw.write(road.start + "\t" + road.end + "\t" + road.distance + "\t" + road.id + "\n");
      }

      bw.write("Roads of Barely Connected Map is:\n");
      for (Road road : barelyConnectedMap) {
         bw.write(road.start + "\t" + road.end + "\t" + road.distance + "\t" + road.id + "\n");
      }

      bw.write("Fastest Route from " + startPoint + " to " + endPoint + " on Barely Connected Map (" + barelyConnectedDistance + " KM):\n");
      for (Road road : fastestRouteBarelyConnected) {
         bw.write(road.start + "\t" + road.end + "\t" + road.distance + "\t" + road.id + "\n");
      }

      bw.write("Analysis:\n");
      bw.write("Ratio of Construction Material Usage Between Barely Connected and Original Map: " + String.format("%.2f", (double) barelyConnectedMaterial / originalMaterial) + "\n");
      bw.write("Ratio of Fastest Route Between Barely Connected and Original Map: " + String.format("%.2f", (double) barelyConnectedDistance / originalDistance) + "\n");

      bw.close();
   }

   private static List<Road> findFastestRoute(Graph graph, String startPoint, String endPoint) {
      Map<String, Integer> distances = new HashMap<>();
      Map<String, Road> previous = new HashMap<>();
      PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
      Set<String> visited = new HashSet<>();

      for (String point : graph.getPoints()) {
         distances.put(point, Integer.MAX_VALUE);
      }
      distances.put(startPoint, 0);
      pq.add(startPoint);

      while (!pq.isEmpty()) {
         String current = pq.poll();
         if (!visited.add(current)) continue;

         for (Road road : graph.getRoads(current)) {
            if (visited.contains(road.end)) continue;
            int newDist = distances.get(current) + road.distance;
            if (newDist < distances.get(road.end)) {
               distances.put(road.end, newDist);
               previous.put(road.end, road);
               pq.add(road.end);
            }
         }
      }

      List<Road> path = new ArrayList<>();
      for (Road at = previous.get(endPoint); at != null; at = previous.get(at.start)) {
         path.add(at);
      }
      Collections.reverse(path);
      return path;
   }

   private static List<Road> findBarelyConnectedMap(List<Road> allRoads, int pointCount) {
      allRoads.sort(Comparator.comparingInt((Road r) -> r.distance).thenComparingInt(r -> r.id));
      Map<String, String> parent = new HashMap<>();
      for (Road road : allRoads) {
         parent.putIfAbsent(road.start, road.start);
         parent.putIfAbsent(road.end, road.end);
      }

      List<Road> result = new ArrayList<>();
      for (Road road : allRoads) {
         String root1 = findRoot(road.start, parent);
         String root2 = findRoot(road.end, parent);
         if (!root1.equals(root2)) {
            result.add(road);
            parent.put(root1, root2);
         }
         if (result.size() == pointCount - 1) break;
      }
      return result;
   }

   private static String findRoot(String point, Map<String, String> parent) {
      while (!parent.get(point).equals(point)) {
         parent.put(point, parent.get(parent.get(point)));
         point = parent.get(point);
      }
      return point;
   }

   private static List<Road> findFastestRouteOnBarelyConnectedMap(List<Road> barelyConnectedMap, String startPoint, String endPoint) {
      Graph barelyConnectedGraph = new Graph();
      for (Road road : barelyConnectedMap) {
         barelyConnectedGraph.addRoad(road);
      }
      return findFastestRoute(barelyConnectedGraph, startPoint, endPoint);
   }
}
