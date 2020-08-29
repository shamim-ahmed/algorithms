package edu.buet.cse.ch06;

import java.util.Arrays;
import java.util.stream.IntStream;

import edu.buet.cse.ch06.util.Utils;

public class HeapSortTrial {
  public static void main(String... args) {
    int[] values = IntStream.iterate(1, i -> i + 1).limit(23).toArray();
    Utils.shuffle(values);

    HeapSort sorter = new HeapSort(values);
    sorter.sort();

    System.out.println(Arrays.toString(values));
  }
}
