package com.gs.peeking.iterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIteratorOnCollection<T> implements Iterator<T> {

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

    if (!hasNext()) {
      throw new NoSuchElementException(" There are no more element");
    }

    T element = peek;
    if (iterator.hasNext()) {
      peek = iterator.next();
    } else {
      peek = null;
    }

    return element;
  }

  public T peek() {

    return peek;
  }

}
