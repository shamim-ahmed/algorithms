package edu.buet.cse.ch06;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class HeapSortTrial {
  public static void main(String... args) {
    int[] values = IntStream.iterate(1, i -> i + 1).limit(23).toArray();
    shuffle(values);

    HeapSort sorter = new HeapSort(values);
    sorter.sort();

    System.out.println(Arrays.toString(values));
  }

  /*
   * Fisher-Yates shuffle. See here: https://stackoverflow.com/a/1520212
   */
  private static void shuffle(int[] values) {
    Random randomGenerator = new Random();

    for (int i = values.length - 1; i > 0; i--) {
      int j = randomGenerator.nextInt(i + 1);
      int temp = values[i];
      values[i] = values[j];
      values[j] = temp;
    }
  }
}
