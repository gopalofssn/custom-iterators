package com.gs.zigzag.iterator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.testng.annotations.Test;

public class ZigzagNListsIteratorTest {

  @Test(expectedExceptions = NoSuchElementException.class)
  public void testNull() {
    List<List<Integer>> dataList = new ArrayList<List<Integer>>();
    dataList.add(new ArrayList<Integer>());
    dataList.add(null);
    dataList.add(new ArrayList<Integer>());
    Iterator<Integer> iterator = new ZigzagNListsIterator(dataList);
    iterator.next();
  }
  
  @Test
  public void testOneValue() {
    List<List<Integer>> dataList = new ArrayList<List<Integer>>();
    dataList.add(new ArrayList<Integer>());
    dataList.add(null);
    dataList.add(new ArrayList<Integer>(Arrays.asList(1)));
    Iterator<Integer> iterator = new ZigzagNListsIterator(dataList);
    assertTrue(iterator.hasNext());
    assertEquals(iterator.next(), new Integer(1));
  }
  
  @Test
  public void testThreeList() {
    List<List<Integer>> dataList = new ArrayList<List<Integer>>();
    dataList.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)));
    dataList.add(Arrays.asList(11, 22));
    dataList.add(new ArrayList<Integer>(Arrays.asList(111, 222, 333)));
    Iterator<Integer> iterator = new ZigzagNListsIterator(dataList);
    Integer[] expected = { 1, 11,  111, 2, 22, 222, 3, 333, 4, 5};
    for( int i = 0; i < expected.length; i++) { 
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), expected[i]);
    }
    assertFalse(iterator.hasNext());
  }
  
}
