package com.gs.peeking.iterator;

import java.util.NoSuchElementException;

public class PeekingIteratorOnArray<T> implements PeekingIterator<T> {

  private int index;
  private T[] elements;
  private T peek;

  public PeekingIteratorOnArray(T[] elements) {
    if (elements == null || elements.length == 0) {
      throw new IllegalArgumentException("Elements Can not be null or empty");
    }

    this.elements = elements;
    peek = elements[index];
  }

  public boolean hasNext() {

    return peek != null;
  }

  public T next() {

    if (peek == null) {
      throw new NoSuchElementException("There are no more element");
    }

    T element = peek;
    index++;
    peek = index < elements.length ? elements[index] : null;
    return element;
  }

  public T peek() {

    if (peek == null) {
      throw new NoSuchElementException("There are no element to peek");
    }
    
    return peek;
  }

}
