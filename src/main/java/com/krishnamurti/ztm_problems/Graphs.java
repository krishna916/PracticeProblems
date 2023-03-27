package com.krishnamurti.ztm_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graphs {

    public static List<Integer> graphsDfs(List<List<Integer>> graph) {
        List<Integer> values = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        if(!graph.isEmpty()) {
            values.add(0);
            graphDfs(graph, 0, values, seen);
        }
        return values;
    }

    public static void graphDfs(List<List<Integer>> graph, int vertex, List<Integer> values, Set<Integer> seen) {
        List<Integer> adjcentVertex = graph.get(vertex);
        seen.add(vertex);
        for (Integer ver: adjcentVertex) {
            if (!seen.contains(ver)) {
                values.add(ver);

                graphDfs(graph, ver, values, seen);
            }
        }
    }


    public static List<Integer> graphBfs(List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        List<Integer> values = new ArrayList<>();
        //Map<Integer, Boolean> seen = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        while (!q.isEmpty()) {
            Integer vertex = q.poll();
            values.add(vertex);
            seen.add(vertex);
            List<Integer> connections = graph.get(vertex);
            for (Integer connection: connections) {
                if (!seen.contains(connection)) {
                    q.add(connection);
                }
            }
        }
        return values;
    }

}
