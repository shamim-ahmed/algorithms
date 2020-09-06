package edu.buet.cse.ch07;

import java.util.Arrays;
import java.util.stream.IntStream;

import edu.buet.cse.ch07.utils.Utils;

public class QuickSortTrial {
  public static void main(String...args) {
    int[] values = IntStream.iterate(1, i -> i + 1).limit(100).toArray();
    Utils.shuffle(values);
    
    QuickSortAlgorithm qsAlgo = new QuickSortAlgorithm();
    qsAlgo.sort(values);
    
    System.out.println(Arrays.toString(values));
  }
}
