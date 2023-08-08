package org.example;



  /*We are tracking down our rogue agent and she travels from place to place to avoid being tracked. Each of her travels are based on a list of itineraries in an unusual or incorrect order. The task is to determine the complete route she will take.

          You are given an array of routes containing her travel itineraries. Convert this into a complete, in-order list of the places she will travel.*/

          import java.util.ArrayList;
          import java.util.HashMap;
          import java.util.List;
          import java.util.Map;

public class Algo {

    public static String findRoutes(ArrayList<ArrayList<String>> routes) {
        Map<String, String> graph = new HashMap<>();

        for (ArrayList<String> route : routes) {
            String from = route.get(0);
            String to = route.get(1);
            graph.put(from, to);
        }

        String start = null;
        for (String place : graph.keySet()) {
            if (!graph.values().contains(place)) {
                start = place;
                break;
            }
        }

        List<String> route = new ArrayList<>();
        String currentPlace = start;
        while (currentPlace != null) {
            route.add(currentPlace);
            currentPlace = graph.get(currentPlace);
        }

        return String.join(", ", route);
    }

}