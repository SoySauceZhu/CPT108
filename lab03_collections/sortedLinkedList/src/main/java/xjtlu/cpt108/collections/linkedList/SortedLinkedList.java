package xjtlu.cpt108.collections.linkedList;

public class SortedLinkedList implements SortedList {

    private Node head;
    private Node tail;
    private int size;

    public SortedLinkedList() {
        head = new Node(Integer.MIN_VALUE);
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        if (null == head.getNext()) {
            sb.append(": EMPTY_LIST");
        } else {
            sb.append(" (").append(size).append("): ");
            Node currentNode = head.getNext();
            int currLoc = 0;
            while (null != currentNode) {
                if (!sb.isEmpty()) sb.append("\n");
                sb.append(String.format("  [%2d] ", (currLoc++))).append(currentNode.toString());
                currentNode = currentNode.getNext();
            }
        }
        return sb.toString();
    }

    @Override
    public int add(int value) {
        Node ptr = head;
        int index = 0;
        while (ptr.getNext() != null && ptr.getNext().getData() < value) {
            ptr = ptr.getNext();
            index++;
        }
        Node node = new Node(value);
        node.setNext(ptr.getNext());
        ptr.setNext(node);

        size++;
        return index;
    }

    @Override
    public int remove(int ind) throws IllegalArgumentException{
        if (ind >= size || ind < 0) {
            throw new IllegalArgumentException("Index out of bound");
        }

        Node ptr = head;
        for (int i = 0; i < ind; i++) {
            ptr = ptr.getNext();
        }

        ptr.setNext(ptr.getNext().getNext());
        size--;
        return ind;
    }

    @Override
    public int remove(Node node) {
        int value = node.getData();
        Node ptr = head;
        int index = 0;
        while (ptr.getNext() != null) {
            index++;
            if (ptr.getNext().getData() == value) {
                ptr.setNext(ptr.getNext().getNext());
                size--;
                index--;
                break;
            }
            ptr = ptr.getNext();
        }
        if (index >= size) index = -1;
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Node first() {
        return null;
    }

    @Override
    public Node last() {
        return null;
    }

    @Override
    public Node get(int ind) {
        if (ind > size) {
            throw new IllegalArgumentException("Index out of bound: " + size);
        }

        Node ptr = head.getNext();
        for (int i = 0; i < ind; i++) {
            ptr = ptr.getNext();
        }
        return ptr;
    }

    @Override
    public Node contains(int value) {
        Node ptr = head;
        while (ptr.getNext()!=null) {
            ptr = ptr.getNext();
            if (ptr.getData() == value) return ptr;
        }
        return null;
    }

    @Override
    public void clear() {

    }

}