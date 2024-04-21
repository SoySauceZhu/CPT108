package xjtlu.cpt108.collections.linkedList;


/**
 * Represents a sorted linked list data structure that stores integers.
 * <p>
 * The internal list structure is implemented by single linked list
 * This class implement SortedList interface, providing methods to
 * add, remove, and manipulate elements in the linked list of {@code int}.
 * <p>
 * Elements are stored in ascending order once they are added to the list,
 * therefore no typical sorting algorithm is exploited.
 * <p>There is a node {@code head} plays a role as sentinel, it doesn't store data.
 * The index of real data stored in list starts from 0, which is {@code head.getNext()}.
 * <p>GitHub repo
 *
 * @author Mingjie Zhu
 * @see <a href="https://github.com/SoySauceZhu/CPT108">GitHub repo: CPT108</a>
 * @see SortedList
 * @version 0.0.3
 */

public class SortedLinkedList implements SortedList {

    private final Node head;  // Using as final sentinel
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


    /**
     * Add a node with given value to the ordered SLList
     *
     * @param value Value of node to be added
     * @return int the index that the value is added
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

        if (ptr.getNext() == null) {
            tail = node;
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
     * @throws IllegalArgumentException if given index is out of bound
     */
    @Override
    public int remove(int ind) throws IllegalArgumentException {
        if (size == 0) {
            throw new IllegalArgumentException("Sorted list is null, no node can be removed");
        }
        if (ind >= size || ind < 0) {
            throw new IllegalArgumentException("Index out of bound " + ind
                    + ". Expected: [0, " + size + ")");
        }

        Node ptr = head;
        for (int i = 0; i < ind; i++) {
            ptr = ptr.getNext();
        }

        if (ptr.getNext().getNext() == null) {
            tail = ptr;
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
        // Check existence, make the best complexity Omega(1)
        if (this.isEmpty() || node.getData() > tail.getData()
                || node.getData() < head.getNext().getData()) {
            return -1;
        }

        Node ptr = head;
        boolean existence = false;

        int index;
        for (index = 0; index < size; index++) {
            if (ptr.getNext().equals(node)) {
                if (ptr.getNext().getNext() == null) {
                    tail = ptr;
                }
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

    /**
     * Return the size of SLList
     *
     * @return int size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Check if the list is empty
     *
     * @return true if the list is empty; false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the first node of SLList
     *
     * @return Node The first node
     */
    @Override
    public Node first() {
        return head.getNext();
    }

    /**
     * Return the last node of SLList
     *
     * @return Node The last node; NULL otherwise.
     */
    @Override
    public Node last() {
        if (this.isEmpty()) return null;
        return tail;
    }

    /**
     * Return the i-th element of the list
     *
     * @param ind index of the element to be returned
     * @return i-th element in the list; NULL if the list is empty
     */
    @Override
    public Node get(int ind) {
        if (size == 0) return null;

        if (ind > size) {
            throw new IllegalArgumentException("Index out of bound: "
                    + ind + ". Expected " + "[0, " + size + ")");
        }

        Node ptr = head.getNext();
        for (int i = 0; i < ind; i++) {
            ptr = ptr.getNext();
        }
        return ptr;
    }

    /**
     * Determine if the list contains the node with input value
     *
     * @param value Vale of node to be checked
     * @return The node contains the specified value; NULL otherwise
     */
    @Override
    public Node contains(int value) {
        // This make the best complexity Omega(1)
        if (this.isEmpty() || value < head.getNext().getData()
                || value > tail.getData()) return null;

        Node ptr = head;
        while (ptr.getNext() != null) {
            ptr = ptr.getNext();
            if (ptr.getData() == value) return ptr;
        }
        return null;
    }

    /**
     * Clear the list.
     * I.e., remove all element in the list
     */
    @Override
    public void clear() {
        head.setNext(null);
        size = 0;
    }

}