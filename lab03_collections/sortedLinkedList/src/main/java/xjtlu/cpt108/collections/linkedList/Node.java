package xjtlu.cpt108.collections.linkedList;

import java.util.Objects;

public class Node {

	private int data;
	private Node next;

	public Node(int data) {
		setData(data);
		next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Node other = (Node) obj;
		return data == other.data;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(data) //
		// .append(" (").append(getClass().getSimpleName()).append(")") //
		;
		return sb.toString();
	}

}
