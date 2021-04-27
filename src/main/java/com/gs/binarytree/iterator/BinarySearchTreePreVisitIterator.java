package com.gs.binarytree.iterator;

import java.util.Iterator;

public interface BinarySearchTreePreVisitIterator<T> extends Iterator<T>{

  public boolean hasPrevious();
  public T previous();
  
}
