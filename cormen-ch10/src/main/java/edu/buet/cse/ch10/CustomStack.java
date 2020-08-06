package edu.buet.cse.ch10;

/**
 * An interface definition for stack
 * 
 * @author shamim
 *
 * @param <T>
 */
public interface CustomStack<T> {
  /**
   * Add an item to stack
   * 
   * @param item
   */
  void push(T item);

  /**
   * Remove an item from stack
   * 
   * @return an item
   * @throws IllegalStateException if stack is empty
   */
  T pop();

  /**
   * Retrieve the top of stack without removing it
   * 
   * @return an item
   * @throws IllegalStateException if stack is empty
   */
  T top();

  /**
   * Check if stack is empty
   * 
   * @return boolean
   */
  boolean isEmpty();

  /**
   * Get current stack size
   * 
   * @return an int
   */
  int size();
}
