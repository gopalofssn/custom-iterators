package com.gs.peeking.iterator;

import java.util.Iterator;

public interface PeekingIterator<T> extends Iterator<T>{

  public T peek();
}
