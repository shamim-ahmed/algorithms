package edu.buet.cse.ch06;

public interface MaxPriorityQueue {
  void insert(int i);
  int getMaximum();
  int extractMaximum();
  boolean isEmpty();
  boolean isFull();
}
