package com.gs.peeking.iterator;

import java.util.Collection;

public class PeekingIteratorSelector<T> {

  public PeekingIterator<T> select(Collection<T> elements) {

    if (elements instanceof Collection) {
      return new PeekingIteratorOnCollection<T>(elements);
    } else {
      return null;
    }
  }
}
