package com.gs.binarytree.iterator;

import java.util.NoSuchElementException;
import java.util.Stack;

public class BinarySearchTreePreVisitIteratorImpl<T> implements BinarySearchTreePreVisitIterator<T> {

  private T previous;
  private Stack<BinaryTree<T>> holder;

  public BinarySearchTreePreVisitIteratorImpl(BinaryTree<T> tree) {
    holder = new Stack<BinaryTree<T>>();
    loadLeft(tree);
  }

  private void loadLeft(BinaryTree<T> tree) {
    if (tree == null)
      return;

    holder.push(tree);
    loadLeft(tree.left);
  }

  public boolean hasNext() {

    return holder.size() != 0;
  }

  public T next() {

    if (holder.size() == 0) {
      throw new  NoSuchElementException("There is no more elements to iterate");
    }
    
    BinaryTree<T> current = holder.pop();
    loadLeft(current.right);
    previous = current.val;
    return current.val;
  }

  public boolean hasPrevious() {

    return previous != null;
  }

  public T previous() {

    if (previous == null) {
      throw new NoSuchElementException("There is no previous element");
    }
    
    return previous;
  }

}
