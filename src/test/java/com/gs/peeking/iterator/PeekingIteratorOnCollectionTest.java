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
    PeekingIterator<String> peekingIterator = new PeekingIteratorOnCollection<String>(elements);
    assertTrue(peekingIterator.hasNext());
    assertEquals(peekingIterator.peek(), "hello");
    assertEquals(peekingIterator.next(), "hello");
    assertEquals(peekingIterator.next(), "world");
    assertFalse(peekingIterator.hasNext());
  }
  
  @Test
  public void testSet() {
    Set<Integer> elements = new HashSet<Integer>(Arrays.asList(1,2));
    PeekingIterator<Integer> peekingIterator = new PeekingIteratorOnCollection<Integer>(elements);
    assertTrue(peekingIterator.hasNext());
    assertEquals(peekingIterator.peek(), new Integer(1));
    assertEquals(peekingIterator.next(), new Integer(1));
    assertEquals(peekingIterator.next(), new Integer(2));
    assertFalse(peekingIterator.hasNext());
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentException() {
    Set<Integer> elements = new HashSet<Integer>();
    new PeekingIteratorOnCollection<Integer>(elements);
  }
  
  @Test(expected = NoSuchElementException.class)
  public void testNoSuchElementExceptionForPeek() {
    Set<Integer> elements = new HashSet<Integer>(Arrays.asList(1));
    PeekingIterator<Integer> peekingIterator = new PeekingIteratorOnCollection<Integer>(elements);
    assertEquals(peekingIterator.next(), new Integer(1));
    assertEquals(peekingIterator.peek(), new Integer(2));
  }
  
  @Test(expected = NoSuchElementException.class)
  public void testNoSuchElementExceptionForNext() {
    Set<Integer> elements = new HashSet<Integer>(Arrays.asList(1));
    PeekingIterator<Integer> peekingIterator = new PeekingIteratorOnCollection<Integer>(elements);
    assertEquals(peekingIterator.next(), new Integer(1));
    assertFalse(peekingIterator.hasNext());
    assertEquals(peekingIterator.next(), new Integer(2));
  }
  
}
