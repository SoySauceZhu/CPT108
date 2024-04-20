package xjtlu.cpt108.collections.linkedList;

public interface SortedList {

	/**
	 * Add node to the list
	 * 
	 * @param value Value of node to be added
	 * @return index of the node in the list
	 */
	int add(int value);

	/**
	 * Remove the node at index <code>ind</code>
	 * 
	 * @param <code>ind</code> Index of the node to be removed
	 * @return index of the node removed
	 */
	int remove(int ind);

	/**
	 * Remove the node with the same content as the input node
	 * 
	 * @param node Node contains the content to be removed
	 * @return index of the node removed; -1 if no node has been removed
	 */
	int remove(Node node);

	/**
	 * Size of the list
	 * 
	 * @return Size of the list
	 */
	int size();

	/**
	 * Check if the list is empty
	 * 
	 * @return true if the list is empty; <code>false</code> otherwise
	 */
	boolean isEmpty();

	/**
	 * Return the first element of the list
	 * 
	 * @return First element of the list; NULL is the list is empty
	 */
	Node first();

	/**
	 * Return the last element of the list
	 * 
	 * @return Last element of the list; NULL if the list is empty
	 */
	Node last();

	/**
	 * Return the i-th element of the list
	 * 
	 * @param ind index of the element to be returned
	 * @return i-th element in the list; NULL if the list is empty
	 */
	Node get(int ind);

	/**
	 * Determine if the list contains the input node
	 * 
	 * @param value Vale of node to be checked
	 * @return The node contains the specified value; NULL otherwise
	 */
	Node contains(int value);

	/**
	 * Clear the list.
	 * I.e., remove all element in the list
	 */
	void clear();

}
