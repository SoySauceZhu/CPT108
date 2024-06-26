package xjtlu.cpt108.collections.linkedList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class TestByMingjie {

    private SortedList sortedList;


    @Test
    public void testAdd() {
        // Add elements to the list and check if they are added in sorted order
        sortedList = new SortedLinkedList();
        assertEquals(0, sortedList.size());
        sortedList.add(5);
        sortedList.add(3);
        sortedList.add(7);
        sortedList.add(1);
        assertEquals(4, sortedList.size());
        assertEquals(1, sortedList.first().getData());
        assertEquals(7, sortedList.last().getData());
        assertEquals(3, sortedList.get(1).getData());
    }

    @Test
    public void testRemoveByIndex() {
        // Add elements to the list and then remove them by index
        sortedList = new SortedLinkedList();
//        assertEquals(-1, sortedList.remove(0));
        sortedList.add(9);
        sortedList.add(8);
        sortedList.add(7);
        sortedList.add(18);
        sortedList.add(21);
        sortedList.add(12);
        assertEquals(6, sortedList.size());
        assertEquals(5, sortedList.remove(5));
        assertEquals(5, sortedList.size());
        assertEquals(7, sortedList.first().getData());
        assertEquals(18, sortedList.last().getData());
        assertEquals(4, sortedList.remove(4));
        assertEquals(12, sortedList.last().getData());
    }

    @Test
    public void testRemoveByNode() {
        // Add elements to the list and then remove them by node
        sortedList = new SortedLinkedList();
        assertEquals(-1, sortedList.remove(new Node(21)));
        sortedList.add(9);
        sortedList.add(8);
        sortedList.add(7);
        sortedList.add(18);
        sortedList.add(21);
        sortedList.add(12);
        assertEquals(6, sortedList.size());
        assertEquals(5, sortedList.remove(new Node(21))); // Remove node2
        assertEquals(5, sortedList.size());
        assertEquals(-1, sortedList.remove(new Node(10)));
        assertEquals(7, sortedList.first().getData());
        assertEquals(18, sortedList.last().getData());
    }

    @Test
    public void testSize() {
        // Test size method
        sortedList = new SortedLinkedList();
        assertEquals(0, sortedList.size());
        sortedList.add(5);
        sortedList.add(3);
        sortedList.add(7);
        assertEquals(3, sortedList.size());
        sortedList.remove(1); // Remove an element
        assertEquals(2, sortedList.size());
    }

    @Test
    public void testIsEmpty() {
        // Test isEmpty method
        sortedList = new SortedLinkedList();
        assertTrue(sortedList.isEmpty());
        sortedList.add(5);
        assertFalse(sortedList.isEmpty());
        sortedList.remove(0);
        assertTrue(sortedList.isEmpty());
    }

    @Test
    public void testFirst() {
        // Test first method
        sortedList = new SortedLinkedList();
        assertNull(sortedList.first());
        sortedList.add(5);
        sortedList.add(3);
        assertEquals(3, sortedList.first().getData());
    }

    @Test
    public void testLast() {
        // Test last method
        sortedList = new SortedLinkedList();
        assertNull(sortedList.last());
        sortedList.add(5);
        sortedList.add(6);
        sortedList.add(9);
        sortedList.add(10);
        sortedList.add(21);
        sortedList.add(18);
        assertEquals(new Node(21), sortedList.last());
    }

    @Test
    public void testGet() {
        // Test get method
        sortedList = new SortedLinkedList();
        assertNull(sortedList.get(13));
        sortedList.add(5);
        sortedList.add(3);
        sortedList.add(7);
        assertEquals(5, sortedList.get(1).getData());
    }

    @Test
    public void testContains() {
        // Test contains method
        sortedList = new SortedLinkedList();
        assertNull(sortedList.contains(5));
        sortedList.add(5);
        sortedList.add(3);
        sortedList.add(7);
        assertNotNull(sortedList.contains(5));
        assertNull(sortedList.contains(6));
    }

    @Test
    public void testClear() {
        // Test clear method
        sortedList = new SortedLinkedList();
        sortedList.add(5);
        sortedList.add(3);
        sortedList.add(7);
        assertFalse(sortedList.isEmpty());
        sortedList.clear();
        assertTrue(sortedList.isEmpty());
    }
}
