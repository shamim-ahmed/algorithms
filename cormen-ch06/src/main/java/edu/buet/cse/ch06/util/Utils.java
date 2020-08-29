package edu.buet.cse.ch06.util;

import java.util.Random;

public class Utils {
  /*
   * Fisher-Yates shuffle. See here: https://stackoverflow.com/a/1520212
   */
  public static void shuffle(int[] values) {
    Random randomGenerator = new Random();

    for (int i = values.length - 1; i > 0; i--) {
      int j = randomGenerator.nextInt(i + 1);
      int temp = values[i];
      values[i] = values[j];
      values[j] = temp;
    }
  }

  // private constructor to prevent instantiation
  private Utils() {}
}
