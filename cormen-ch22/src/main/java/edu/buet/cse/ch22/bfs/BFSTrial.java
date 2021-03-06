package edu.buet.cse.ch22.bfs;

import java.util.Scanner;

import edu.buet.cse.ch22.Graph;

public class BFSTrial {
  private static final String RESOURCE_FILE = "/edu/buet/cse/ch22/bfs/breadth-first.txt";

  public static void main(String... args) {
    try (Scanner scanner =
        new Scanner(BreadthFirstSearch.class.getResourceAsStream(RESOURCE_FILE))) {
      final int n = Integer.parseInt(scanner.nextLine().trim());
      Graph graph = new Graph(n);

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] values = line.split("\\s+");
        int source = Integer.parseInt(values[0]);

        for (int k = 1; k < values.length; k++) {
          int destination = Integer.parseInt(values[k]);
          graph.addEdge(source, destination);
        }
      }

      BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
      bfs.runBFS(1);
      System.out.println(bfs.findPath(1, 3));
    }
  }
}
