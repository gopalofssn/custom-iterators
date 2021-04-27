package com.gs.peeking.iterator;

 import static org.testng.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;
 
public class PeekingIteratorSelectorTest {

  @Test
  public void testArraySelector() {
    String[] elemenets = {"1", "2"};
    PeekingIterator<String> peekingIterator = new PeekingIteratorSelector<String>().select(elemenets);
    assertTrue(peekingIterator instanceof PeekingIteratorOnArray);
    assertFalse(peekingIterator instanceof PeekingIteratorOnCollection);
  }
  
  @Test
  public void testCollectionSelector() {
    List<Integer> elemenets = new ArrayList<Integer>(Arrays.asList(1));
    PeekingIterator<List<Integer>> peekingIterator = new PeekingIteratorSelector<List<Integer>>().select(elemenets);
    assertFalse(peekingIterator instanceof PeekingIteratorOnArray);
    assertTrue(peekingIterator instanceof PeekingIteratorOnCollection);
  }

  
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testStandAloneObjectSelector() {
    String elemenet = "Hello";
    new PeekingIteratorSelector<String>().select(elemenet);
    }

  
}
