package com.krishnamurti.ztm_problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GraphTest {

    @Test
    void testGraphBfs() {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(List.of(1, 3));
        graph.add(List.of(0));
        graph.add(List.of(3, 8));
        graph.add(List.of(0,4,5,2));
        graph.add(List.of(3,6));
        graph.add(List.of(3));
        graph.add(List.of(4,7));
        graph.add(List.of(6));
        graph.add(List.of(2));

        System.out.println(Graphs.graphBfs(graph));

    }

    @Test
    void testGraphDfs() {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(List.of(1, 3));
        graph.add(List.of(0));
        graph.add(List.of(3, 8));
        graph.add(List.of(0,4,5,2));
        graph.add(List.of(3,6));
        graph.add(List.of(3));
        graph.add(List.of(4,7));
        graph.add(List.of(6));
        graph.add(List.of(2));


        System.out.println(Graphs.graphsDfs(graph));

    }
}
