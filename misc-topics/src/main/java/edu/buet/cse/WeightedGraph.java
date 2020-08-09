package edu.buet.cse;

import java.util.ArrayList;
import java.util.List;

/**
 * An adjacency list representation of a weighted Graph
 * 
 * @author shamim
 *
 */
public class WeightedGraph {
  private List<Edge>[] adjacencyArray;

  @SuppressWarnings("unchecked")
  public WeightedGraph(int numberOfNodes) {
    if (numberOfNodes <= 0) {
      throw new IllegalArgumentException("number of nodes must be a positive integer");
    }

    adjacencyArray = new List[numberOfNodes];

    for (int i = 0; i < adjacencyArray.length; i++) {
      adjacencyArray[i] = new ArrayList<Edge>();
    }
  }

  public void addEdge(int source, int destination, double weight) {
    if (source < 0 || source >= adjacencyArray.length) {
      throw new IllegalArgumentException("Invalid value for source of edge: " + source);
    }

    if (destination < 0 || destination >= adjacencyArray.length) {
      throw new IllegalArgumentException("Invalid value for destination of edge: " + destination);
    }

    Edge edge = new Edge(source, destination, weight);
    adjacencyArray[source].add(edge);
  }

  private static class Edge {
    private final int source;
    private final int destination;
    private final double weight;

    public Edge(int source, int destination, double weight) {
      this.source = source;
      this.destination = destination;
      this.weight = weight;
    }

    public int getSource() {
      return source;
    }

    public int getDestination() {
      return destination;
    }

    public double getWeight() {
      return weight;
    }
  }
}
