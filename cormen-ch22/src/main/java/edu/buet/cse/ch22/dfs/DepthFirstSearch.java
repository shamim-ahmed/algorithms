package edu.buet.cse.ch22.dfs;

import java.util.List;
import java.util.Objects;

import edu.buet.cse.ch22.Color;
import edu.buet.cse.ch22.Graph;

public class DepthFirstSearch {
  private final Graph graph;
  private final Integer[] discoveryTimeArray;
  private final Integer[] finishTimeArray;
  private final Integer[] parentArray;
  private final Color[] colorArray;
  private int time = 0;

  public DepthFirstSearch(Graph graph) {
    this.graph = Objects.requireNonNull(graph);
    int vertexCount = graph.getNumberOfVertices();
    discoveryTimeArray = new Integer[vertexCount];
    finishTimeArray = new Integer[vertexCount];
    parentArray = new Integer[vertexCount];
    colorArray = new Color[vertexCount];
  }

  public void runDFS() {
    final int n = graph.getNumberOfVertices();

    for (int i = 0; i < n; i++) {
      colorArray[i] = Color.WHITE;
      parentArray[i] = null;
    }

    for (int i = 0; i < n; i++) {
      if (colorArray[i] == Color.WHITE) {
        dfsVisit(i);
      }
    }
  }

  private void dfsVisit(Integer x) {
    time += 1;
    discoveryTimeArray[x] = time;
    colorArray[x] = Color.GRAY;

    List<Integer> adjacentVertexList = graph.getAdjacentVertices(x);

    for (Integer y : adjacentVertexList) {
      if (colorArray[y] == Color.WHITE) {
        parentArray[y] = x;
        dfsVisit(y);
      }
    }

    colorArray[x] = Color.BLACK;
    time += 1;
    finishTimeArray[x] = time;
  }
}
