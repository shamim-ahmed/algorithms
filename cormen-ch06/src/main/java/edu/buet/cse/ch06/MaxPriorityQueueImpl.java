package edu.buet.cse.ch06;

public class MaxPriorityQueueImpl implements MaxPriorityQueue {
  private int[] values;
  private int heapSize;

  public MaxPriorityQueueImpl(int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("initial capacity must be a positive integer");
    }

    values = new int[capacity];
    heapSize = 0;
  }

  @Override
  public boolean isEmpty() {
    return heapSize == 0;
  }

  @Override
  public boolean isFull() {
    return heapSize == values.length;
  }

  @Override
  public void insert(int i) {
    if (isFull()) {
      throw new IllegalStateException("Queue is full");
    }

    heapSize++;
    values[heapSize - 1] = Integer.MIN_VALUE;
    increaseKey(i, heapSize - 1);
  }

  @Override
  public int getMaximum() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }

    return values[0];
  }

  @Override
  public int extractMaximum() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }

    int result = values[0];
    values[0] = values[heapSize - 1];
    heapSize--;
    maxHeapify(0);

    return result;
  }

  private void increaseKey(int key, int position) {
    int oldKey = values[position];

    if (oldKey > key) {
      return;
    }

    values[position] = key;
    int i = position;

    while (i != 0) {
      int parent = getParent(i);

      if (values[parent] > values[i]) {
        break;
      }

      swap(i, parent);
      i = parent;
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
