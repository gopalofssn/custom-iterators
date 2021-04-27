package com.gs.peeking.iterator;

import java.util.Collection;

public class PeekingIteratorSelector<T> {

  @SuppressWarnings("unchecked")
  public PeekingIterator<T> select(Object elements) {

    if (elements instanceof Collection) {
      return new PeekingIteratorOnCollection<T>((Collection<T>) elements);
    } else if (elements instanceof Object[]) {
      return new PeekingIteratorOnArray<T>((T[]) elements);
    }

    throw new IllegalArgumentException();
  }

}
