package com.loi.cps5001_assessment;

/**
 *
 * @author kirth
 */
import java.util.*;

public class EmergencyGraph {

    private Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(Node node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(Node from, Node to, double weight) {
        adjacencyList.get(from).add(new Edge(to, weight));
    }

    public void removeEdge(Node from, Node to) {
        adjacencyList.get(from)
                     .removeIf(edge -> edge.getDestination().equals(to));
    }

    public void updateEdgeWeight(Node from, Node to, double newWeight) {
        for (Edge edge : adjacencyList.get(from)) {
            if (edge.getDestination().equals(to)) {
                edge.setWeight(newWeight);
            }
        }
    }

    public List<Edge> getEdges(Node node) {
        return adjacencyList.get(node);
    }
    
        public Map<Node, Double> dijkstra(Node source) {

        Map<Node, Double> distances = new HashMap<>();
        PriorityQueue<NodeDistance> queue =
                new PriorityQueue<>(Comparator.comparingDouble(nd -> nd.distance));

        distances.put(source, 0.0);
        queue.add(new NodeDistance(source, 0.0));

        while (!queue.isEmpty()) {
            NodeDistance current = queue.poll();

            for (Edge edge : adjacencyList.get(current.node)) {
                double newDistance = current.distance + edge.getWeight();

                if (newDistance < distances.getOrDefault(
                        edge.getDestination(), Double.MAX_VALUE)) {

                    distances.put(edge.getDestination(), newDistance);
                    queue.add(new NodeDistance(edge.getDestination(), newDistance));
                }
            }
        }
        return distances;
    }
}


