package edu.buet.cse.ch22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {
  private List<Integer>[] adjacencyArray;

  @SuppressWarnings("unchecked")
  public Graph(int numberOfVertices) {
    if (numberOfVertices <= 0) {
      throw new IllegalArgumentException("Number of vertices must be positive");
    }

    adjacencyArray = new List[numberOfVertices];

    for (int i = 0; i < adjacencyArray.length; i++) {
      adjacencyArray[i] = new ArrayList<Integer>();
    }
  }

  public int getNumberOfVertices() {
    return adjacencyArray.length;
  }

  public void addEdge(int source, int destination) {
    if (source < 0 || source >= adjacencyArray.length) {
      throw new IllegalArgumentException("Invalid source vertex: " + source);
    }

    if (destination < 0 || destination >= adjacencyArray.length) {
      throw new IllegalArgumentException("Invalid destination vertex: " + destination);
    }

    adjacencyArray[source].add(destination);
  }

  public List<Integer> getAdjacentVertices(int vertex) {
    if (vertex < 0 || vertex >= adjacencyArray.length) {
      throw new IllegalArgumentException("Invalid vertex: " + vertex);
    }

    return Collections.unmodifiableList(adjacencyArray[vertex]);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < adjacencyArray.length; i++) {
      builder.append(i).append(" -> ").append(adjacencyArray[i]);
    }

    return builder.toString();
  }
}
