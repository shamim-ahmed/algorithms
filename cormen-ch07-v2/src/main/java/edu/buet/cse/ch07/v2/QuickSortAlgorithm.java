package edu.buet.cse.ch07.v2;

import java.util.Random;

/**
 * An implementation of Quicksort algorithm with randomization
 * 
 * @author shamim
 *
 */
public class QuickSortAlgorithm {
  private final Random randomGenerator = new Random();

  /**
   * sort the given values in place
   * 
   * @param values an array of int
   */
  public void sort(int[] values) {
    quickSort(values, 0, values.length - 1);
  }

  private void quickSort(int[] values, int p, int r) {
    if (p < r) {
      int q = randomizedPartition(values, p, r);
      quickSort(values, p, q - 1);
      quickSort(values, q + 1, r);
    }
  }

  // randomly choose the pivot element
  private int randomizedPartition(int[] values, int p, int r) {
    int i = p + randomGenerator.nextInt(r - p + 1);
    swap(values, i, r);
    return partition(values, p, r);
  }

  private int partition(int[] values, int p, int r) {
    int i = p - 1;
    int pivot = values[r];

    for (int k = p; k < r; k++) {
      if (values[k] <= pivot) {
        i++;
        swap(values, i, k);
      }
    }

    swap(values, i + 1, r);
    return i + 1;
  }

  private void swap(int[] values, int i, int j) {
    int temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  }
}
