package com.gs.zigzag.iterator;

import java.util.*;
/**
 * 
 * @author Gopal Selvaraj
 * input : {
 *            { 1, 2, 3, 4, 5},
 *            {11, 22},
 *            {111, 222, 333}
 *          }
 *  output : 1 11  111 2 22 222 3 333 4 5
 */
public class ZigzagNListsIterator implements Iterator<Integer>{

  private LinkedList<Iterator<Integer>> iteratorHolder;
  private int currentIndex;
  private int iteratorHolderLength;
  
  public ZigzagNListsIterator(List<List<Integer>> dataList) {
    this.currentIndex = 0;
    this.iteratorHolder = new LinkedList<Iterator<Integer>>();
    
    for(List<Integer> data : dataList) {
      if (data == null) continue;
      
      iteratorHolderLength++;
      this.iteratorHolder.addLast(data.iterator());
    }
  }
  
  public boolean hasNext() {
     if (iteratorHolder.isEmpty()) {
       return false;
     }
     
     currentIndex = currentIndex % iteratorHolderLength;
     
     if (!iteratorHolder.get(currentIndex).hasNext()) {
       iteratorHolder.remove(currentIndex);
       iteratorHolderLength--;
       return hasNext();
     }
     
     return true;
  }

  public Integer next() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more element to visit !!!");
    }
    
    Integer val = iteratorHolder.get(currentIndex).next();
    currentIndex++;
    return val;
  }

  
}
