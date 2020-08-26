package edu.buet.cse.ch06;

import java.util.Objects;

public class HeapSort {
  private int[] values;
  private int heapSize;

  public HeapSort(int[] values) {
    this.values = Objects.requireNonNull(values);
  }

  public void sort() {
    heapSize = 0;
  }

  private void maxHeapify(int i) {
    int left = getLeft(i);
    int right = getRight(i);
    int max = i;

    if (left <= heapSize && values[left] > values[max]) {
      max = left;
    }

    if (right <= heapSize && values[right] > values[max]) {
      max = right;
    }

    if (max != i) {
      swap(i, max);
      maxHeapify(max);
    }
  }

  private void buildMaxHeap() {
    heapSize = values.length;
    
    for (int i = heapSize / 2; i >= 1; i--) {
      maxHeapify(i);
    }
  }

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
