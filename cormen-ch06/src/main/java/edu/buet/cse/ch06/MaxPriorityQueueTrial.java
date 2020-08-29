package edu.buet.cse.ch06;

import java.util.stream.IntStream;

import edu.buet.cse.ch06.util.Utils;

public class MaxPriorityQueueTrial {
  public static void main(String...args) {
    final int n = 39;
    int[] values = IntStream.iterate(1, i -> i + 1).limit(n).toArray();
    Utils.shuffle(values);
    
    MaxPriorityQueue mpQueue = new MaxPriorityQueueImpl(n);
    
    for (int i : values) {
      mpQueue.insert(i);
    }
    
    while (!mpQueue.isEmpty()) {
      System.out.println(mpQueue.extractMaximum());
    }
  }
}
