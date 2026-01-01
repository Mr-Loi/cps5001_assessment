package com.loi.cps5001_assessment;

/**
 *
 * @author kirth
 */
public class Edge {

    private Node destination;
    private double weight;

    public Edge(Node destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public Node getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

