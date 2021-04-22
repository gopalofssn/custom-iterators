package com.gs.peeking.iterator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.util.NoSuchElementException;
import org.testng.annotations.Test;
 
public class PeekingIteratorOnArrayTest {

  @Test
  public void tesStringArray() {
    String[] elements = {"hello", "world"};
    PeekingIterator<String> peekingIterator = new PeekingIteratorOnArray<String>(elements);
    assertTrue(peekingIterator.hasNext());
    assertEquals(peekingIterator.peek(), "hello");
    assertEquals(peekingIterator.next(), "hello");
    assertEquals(peekingIterator.next(), "world");
    assertFalse(peekingIterator.hasNext());
  }
  
  @Test
  public void testIntegerArray() {
    Integer[] elements = {1, 2};
    PeekingIterator<Integer> peekingIterator = new PeekingIteratorOnArray<Integer>(elements);
    assertTrue(peekingIterator.hasNext());
    assertEquals(peekingIterator.peek(), new Integer(1));
    assertEquals(peekingIterator.next(), new Integer(1));
    assertEquals(peekingIterator.next(), new Integer(2));
    assertFalse(peekingIterator.hasNext());
  }
  
  @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Elements Can not be null or empty")
  public void testIllegalArgumentException() {
    Long[] elements = {};
    new PeekingIteratorOnArray<Long>(elements);
  }
  
  @Test(expectedExceptions = NoSuchElementException.class, expectedExceptionsMessageRegExp = "There are no element to peek")
  public void testNoSuchElementExceptionForPeek() {
    Float[] elements = {1.0f};
    PeekingIterator<Float> peekingIterator = new PeekingIteratorOnArray<Float>(elements);
    assertEquals(peekingIterator.next(), new Float(1.0f));
    assertEquals(peekingIterator.peek(), new Float(2.0f));
  }
  
  @Test(expectedExceptions = NoSuchElementException.class, expectedExceptionsMessageRegExp = "There are no more element")
  public void testNoSuchElementExceptionForNext() {
    Double[] elements = {1.0};
    PeekingIterator<Double> peekingIterator = new PeekingIteratorOnArray<Double>(elements);
    assertEquals(peekingIterator.next(), new Double(1));
    assertFalse(peekingIterator.hasNext());
    assertEquals(peekingIterator.next(), new Double(2));
  }
  
}
