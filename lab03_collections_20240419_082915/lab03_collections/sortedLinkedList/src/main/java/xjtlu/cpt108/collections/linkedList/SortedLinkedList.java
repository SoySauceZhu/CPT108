package xjtlu.cpt108.collections.linkedList;

public class SortedLinkedList implements SortedList {

	private Node head;
	private Node tail;
	private int size;

	public SortedLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		if (null == head) {
			sb.append(": EMPTY_LIST");
		} else {
			sb.append(" (").append(size).append("): ");
			Node currentNode = head;
			int currLoc = 0;
			while (null != currentNode) {
				if (!sb.isEmpty()) sb.append("\n");
				sb.append(String.format("  [%2d] ", (currLoc++))).append(currentNode.toString());
				currentNode = currentNode.getNext();
			}
		}
		return sb.toString();
	}

}