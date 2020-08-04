package edu.buet.cse.ds;

/**
 * An implementation of stack interface
 * 
 * @author shamim
 *
 * @param <T>
 */
public class CustomStackImpl<T> implements CustomStack<T> {
  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  private int count = -1;

  private T[] itemArray;

  public CustomStackImpl() {
    this(DEFAULT_INITIAL_CAPACITY);
  }

  @SuppressWarnings("unchecked")
  public CustomStackImpl(int initialCapacity) {
    if (initialCapacity <= 0) {
      throw new IllegalArgumentException("initialCapacity must be a positive integer");
    }

    itemArray = (T[]) new Object[initialCapacity];
  }

  /**
   * {@inheritDoc}
   */
  public void push(T item) {
    if (count == itemArray.length - 1) {
      increaseCapacity();
    }

    itemArray[++count] = item;
  }

  /**
   * {@inheritDoc}
   */
  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }

    return itemArray[count--];
  }

  /**
   * {@inheritDoc}
   */
  public T top() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }

    return itemArray[count];
  }

  /**
   * {@inheritDoc}
   */
  public boolean isEmpty() {
    return count < 0;
  }

  /**
   * {@inheritDoc}
   */
  public int size() {
    return count + 1;
  }

  private void increaseCapacity() {
    int n = 2 * itemArray.length;
    @SuppressWarnings("unchecked")
    T[] expandedArray = (T[]) new Object[n];
    System.arraycopy(itemArray, 0, expandedArray, 0, itemArray.length);
    itemArray = expandedArray;
  }
}
