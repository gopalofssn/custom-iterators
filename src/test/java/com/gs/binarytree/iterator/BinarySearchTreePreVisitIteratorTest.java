package com.gs.binarytree.iterator;

import static org.testng.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;

public class BinarySearchTreePreVisitIteratorTest {

  @Test
  public void testLeftOnlyTree() {
    BinaryTree<Character> tree = new BinaryTree<Character>('C');
    tree.left = new BinaryTree<Character>('B');
    tree.left.left = new BinaryTree<Character>('A');
    BinarySearchTreePreVisitIterator<Character> iterator = new BinarySearchTreePreVisitIteratorImpl<Character>(tree);
    assertFalse(iterator.hasPrevious());
    assertTrue(iterator.hasNext());
    assertEquals(iterator.next(), new Character('A'));
    assertEquals(iterator.previous(), new Character('A'));
    assertEquals(iterator.next(), new Character('B'));
    assertEquals(iterator.previous(), new Character('B'));
    assertEquals(iterator.next(), new Character('C'));
    assertTrue(iterator.hasPrevious());
    assertEquals(iterator.previous(), new Character('C'));
    assertFalse(iterator.hasNext());
  }
  
  
  @Test
  public void testRightOnlyTree() {
    BinaryTree<Long> tree = new BinaryTree<Long>(1l);
    tree.right = new BinaryTree<Long>(2l);
    BinarySearchTreePreVisitIterator<Long> iterator = new BinarySearchTreePreVisitIteratorImpl<Long>(tree);
    assertTrue(iterator.hasNext());
    assertEquals(iterator.next(), new Long(1));
    assertEquals(iterator.next(), new Long(2));
    assertTrue(iterator.hasPrevious());
    assertEquals(iterator.previous(), new Long(2));
    assertFalse(iterator.hasNext());
  }
  
  @Test(expected = NoSuchElementException.class)
  public void testNull() {
    BinaryTree<String> tree = null;
    BinarySearchTreePreVisitIterator<String> iterator = new BinarySearchTreePreVisitIteratorImpl<String>(tree);
    iterator.next();
  }
}
