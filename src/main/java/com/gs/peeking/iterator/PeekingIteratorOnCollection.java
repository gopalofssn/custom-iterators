package com.gs.peeking.iterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIteratorOnCollection<T> implements PeekingIterator<T> {

  private Iterator<T> iterator;
  private T peek;

  public PeekingIteratorOnCollection(Collection<T> elements) {
    if (elements == null || elements.size() == 0) {
      throw new IllegalArgumentException("Elements Can not be null or empty");
    }

    iterator = elements.iterator();
    peek = iterator.next();
  }

  public boolean hasNext() {

    return peek != null;
  }

  public T next() {

    if (peek == null) {
      throw new NoSuchElementException(" There are no more element");
    }

    T element = peek;
    peek = iterator.hasNext() ? iterator.next() : null;
   
    return element;
  }

  public T peek() {

    if (peek == null) {
      throw new NoSuchElementException(" There are no element to peek");
    }
    
    return peek;
  }

}
