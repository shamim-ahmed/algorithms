package edu.buet.cse.ds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomStackTest {
  @Test
  public void pushPopTest() {
    String[] words = {"In", "God", "we", "trust.", "All", "others", "pay", "cash"};
    CustomStack<String> stack = new CustomStackImpl<>(3);
    
    assertEquals(0, stack.size());
    assertEquals(true, stack.isEmpty());
    
    for (String w : words) {
      stack.push(w);
    }
    
    assertEquals(8, stack.size());
    assertEquals(false, stack.isEmpty());
    
    int i = words.length - 1;
    
    while (i >= 0) {
      String result = stack.pop();
      assertEquals(words[i], result);
      i--;
    }
    
    assertEquals(0, stack.size());
    assertEquals(true, stack.isEmpty());
  }
}
