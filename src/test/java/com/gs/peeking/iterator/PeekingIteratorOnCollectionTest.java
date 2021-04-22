package com.gs.peeking.iterator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.util.*;
import org.junit.Test;

public class PeekingIteratorOnCollectionTest {

  @Test
  public void testList() {
    List<String> elements = new ArrayList<String>(Arrays.asList("hello", "world"));
    PeekingIteratorOnCollection<String> peekingIteratorOnCollection = new PeekingIteratorOnCollection<String>(elements);
    assertTrue(peekingIteratorOnCollection.hasNext());
    assertEquals(peekingIteratorOnCollection.peek(), "hello");
    assertEquals(peekingIteratorOnCollection.next(), "hello");
    assertEquals(peekingIteratorOnCollection.next(), "world");
    assertFalse(peekingIteratorOnCollection.hasNext());
  }
  
  @Test
  public void testSet() {
    Set<Integer> elements = new HashSet<Integer>(Arrays.asList(1,2));
    PeekingIteratorOnCollection<Integer> peekingIteratorOnCollection = new PeekingIteratorOnCollection<Integer>(elements);
    assertTrue(peekingIteratorOnCollection.hasNext());
    assertEquals(peekingIteratorOnCollection.peek(), new Integer(1));
    assertEquals(peekingIteratorOnCollection.next(), new Integer(1));
    assertEquals(peekingIteratorOnCollection.next(), new Integer(2));
    assertFalse(peekingIteratorOnCollection.hasNext());
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentException() {
    Set<Integer> elements = new HashSet<Integer>();
    new PeekingIteratorOnCollection<Integer>(elements);
  }
  
  @Test(expected = NoSuchElementException.class)
  public void testNoSuchElementException() {
    Set<Integer> elements = new HashSet<Integer>(Arrays.asList(1));
    PeekingIteratorOnCollection<Integer> peekingIteratorOnCollection = new PeekingIteratorOnCollection<Integer>(elements);
    assertEquals(peekingIteratorOnCollection.next(), new Integer(1));
    assertFalse(peekingIteratorOnCollection.hasNext());
    assertEquals(peekingIteratorOnCollection.next(), new Integer(1));
  }
  
}
