package edu.buet.cse.ch22;

import java.util.ArrayList;
import java.util.List;

/**
 * An adjacency list representation of an unweighted Graph
 * 
 * @author shamim
 *
 */
public class UnWeightedGraph {
  private List<Integer>[] adjacencyArray;

  @SuppressWarnings("unchecked")
  public UnWeightedGraph(int numberOfNodes) {
    if (numberOfNodes <= 0) {
      throw new IllegalArgumentException("number of nodes must be a positive integer");
    }

    adjacencyArray = new List[numberOfNodes];

    for (int i = 0; i < adjacencyArray.length; i++) {
      adjacencyArray[i] = new ArrayList<Integer>();
    }
  }

  public void addEdge(int source, int destination, double weight) {
    if (source < 0 || source >= adjacencyArray.length) {
      throw new IllegalArgumentException("Invalid value for source of edge: " + source);
    }

    if (destination < 0 || destination >= adjacencyArray.length) {
      throw new IllegalArgumentException("Invalid value for destination of edge: " + destination);
    }

    adjacencyArray[source].add(destination);
  }
}
