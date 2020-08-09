package edu.buet.cse.ch22.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.buet.cse.ch22.Graph;

public class BreadthFirstSearch {
  enum Color {
    WHITE, GRAY, BLACK
  }

  private static final Integer INFINITY = Integer.MAX_VALUE;

  private Graph graph;
  private Integer[] parentArray;
  private Integer[] distanceArray;
  private Color[] colorArray;

  public BreadthFirstSearch(Graph graph) {
    this.graph = graph;
  }

  public void runBFS(int source) {
    final int n = graph.getNumberOfVertices();

    if (source < 0 || source >= n) {
      throw new IllegalArgumentException("Invalid source vertex: " + source);
    }

    // initialize parent, distance and color for each vertex
    parentArray = new Integer[n];
    distanceArray = new Integer[n];
    colorArray = new Color[n];

    for (int i = 0; i < n; i++) {
      if (i == source) {
        continue;
      }

      parentArray[i] = null;
      distanceArray[i] = INFINITY;
      colorArray[i] = Color.WHITE;
    }

    parentArray[source] = null;
    distanceArray[source] = 0;
    colorArray[source] = Color.GRAY;

    Queue<Integer> vertexQueue = new LinkedList<>();

    while (!vertexQueue.isEmpty()) {
      Integer x = vertexQueue.poll();
      List<Integer> adjacentVertexList = graph.getAdjacentVertices(x);

      for (Integer y : adjacentVertexList) {
        if (colorArray[y] == Color.WHITE) {
          colorArray[y] = Color.GRAY;
          distanceArray[y] = distanceArray[x] + 1;
          parentArray[y] = x;
          vertexQueue.offer(y);
        }
      }

      colorArray[x] = Color.BLACK;
    }
  }
}
