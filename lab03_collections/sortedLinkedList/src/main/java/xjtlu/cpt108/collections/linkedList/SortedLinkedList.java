package xjtlu.cpt108.collections.linkedList;

public class SortedLinkedList implements SortedList {

    private final Node head;  // Using as final sentinel
    private int size;

    public SortedLinkedList() {
        head = new Node(Integer.MIN_VALUE);
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


    /**
     * Add a node with given value to the ordered SLList
     *
     * @param value Value of node to be added
     * @return
     */
    @Override
    public int add(int value) {
        Node ptr = head;
        int index = 0;
        Node node = new Node(value);

        // Compare with next value of pointer, if smaller than target then move forward
        while (ptr.getNext() != null && ptr.getNext().getData() < value) {
            ptr = ptr.getNext();
            index++;
        }
        node.setNext(ptr.getNext());
        ptr.setNext(node);

        size++;
        return index;
    }

    /**
     * Remove the node at given index
     *
     * @param ind index to be removed
     * @return index of node removed
     * @throws IllegalArgumentException if given index is invalid
     */
    @Override
    public int remove(int ind) throws IllegalArgumentException {
        if (ind >= size || ind < 0) {
            throw new IllegalArgumentException("Size should in range " + "(0, size]");
        }

        Node ptr = head;
        for (int i = 0; i < ind; i++) {
            ptr = ptr.getNext();
        }

        ptr.setNext(ptr.getNext().getNext());
        size--;
        return ind;
    }

    /**
     * Remove the first node where the given value appears
     *
     * @param node Node contains the content to be removed
     * @return int Index of the node removed; -1 if no such node
     */
    @Override
    public int remove(Node node) {
        boolean existence = false;      // Whether expected node exist
        Node ptr = head;

        int index;
        for (index = 0; index < size; index++) {
            // Ptr is where the index (head as 0) is

            if (ptr.getNext().equals(node)) {
                existence = true;
                ptr.setNext(ptr.getNext().getNext());
                break;
            }
            ptr = ptr.getNext();
        }

        if (existence) {
            size--;
            return index;
        } else {
            return -1;
        }
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
        return head.getNext();
    }

    @Override
    public Node last() {
        if (this.isEmpty()) return null;

        Node ptr = head;
        while (ptr.getNext() != null) {
            ptr = ptr.getNext();
        }
        return ptr;
    }

    @Override
    public Node get(int ind) {
        if (ind > size) {
            throw new IllegalArgumentException("Index out of bound: " + size + ". Expected " + "[0, size)");
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
        while (ptr.getNext() != null) {
            ptr = ptr.getNext();
            if (ptr.getData() == value) return ptr;
        }
        return null;
    }

    @Override
    public void clear() {
        head.setNext(null);
        size = 0;
    }

}