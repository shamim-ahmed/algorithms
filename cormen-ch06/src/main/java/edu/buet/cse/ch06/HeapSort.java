package edu.buet.cse.ch06;

import java.util.Objects;

public class HeapSort {
  private int[] values;
  private int heapSize;

  public HeapSort(int[] values) {
    this.values = Objects.requireNonNull(values);
  }

  public void sort() {
    heapSize = values.length;
    buildMaxHeap();
    
    for (int i = 0; i < values.length - 1; i++) {
      swap(0, heapSize - 1);
      heapSize--;
      maxHeapify(0);
    }
  }

  private void maxHeapify(final int idx) {
    int i = idx;
    boolean flag = true;

    while (flag) {
      int left = getLeft(i);
      int right = getRight(i);
      int max = i;

      if (left <= heapSize - 1 && values[left] > values[max]) {
        max = left;
      }

      if (right <= heapSize - 1 && values[right] > values[max]) {
        max = right;
      }

      if (max != i) {
        swap(i, max);
        i = max;
      } else {
        flag = false;
      }
    }
  }

  private void buildMaxHeap() {
    for (int i = heapSize / 2; i >= 0; i--) {
      maxHeapify(i);
    }
  }

  @SuppressWarnings("unused")
  private int getParent(int i) {
    return (i - 1) / 2;
  }

  private int getLeft(int i) {
    return 2 * i + 1;
  }

  private int getRight(int i) {
    return 2 * i + 2;
  }

  private void swap(int i, int j) {
    int temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  }
}
