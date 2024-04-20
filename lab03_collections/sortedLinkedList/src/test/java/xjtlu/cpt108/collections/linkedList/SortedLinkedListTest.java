package xjtlu.cpt108.collections.linkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SortedLinkedListTest {

	private static void print(String label, Object... objects) {
		StringBuilder sb = new StringBuilder();

		if (null != label && !label.isBlank()) sb.append(label);
		for (Object obj : objects) {
			if (null == obj) continue;
			if (!sb.isEmpty()) sb.append("\n");
			sb.append(obj.toString());
		}

		System.out.println(sb.toString());
	}

	private SortedList generateTestList(int size) {
		SortedList sortedList = new SortedLinkedList();

		for (int i = 0; i < size; i++) {
			sortedList.add((i + 1) * 10);
		}
		return sortedList;
	}

	@Test
	public void emptyListTest() {
		SortedList sortedList = generateTestList(0);
		assertTrue(sortedList.isEmpty());
	}

	@Test
	public void addTest() {
		int size = 10;
		SortedList sortedList = generateTestList(size);

		print(null, sortedList);

		for (int i = 0; i < size; i++) {
			Node node = sortedList.get(i);
			assertNotNull(node);
			assertEquals((i + 1) * 10, node.getData());
		}

		assertNull(sortedList.contains(2));
		assertNull(sortedList.contains(52));
		assertNull(sortedList.contains(102));

		System.out.println(sortedList.add(5));
		print("add(5)",sortedList);
		System.out.println(sortedList.add(15));
		print("add(15)",sortedList);
		System.out.println(sortedList.add(105));
		print("add(105)",sortedList);

		assertEquals(15, sortedList.contains(15).getData());
		assertNull(sortedList.contains(18));
		assertEquals(5, sortedList.contains(5).getData());
		assertEquals(105, sortedList.contains(105).getData());
		assertNull(sortedList.contains(123));
	}

	@Test
	public void removeTest() {
		int size = 10;
		SortedList sortedList = generateTestList(size);

		print(null, sortedList);

		assertEquals(-1, sortedList.remove(new Node(1)));
		assertEquals(2, sortedList.remove(new Node(30)));
		assertEquals(-1, sortedList.remove(new Node(75)));
		assertEquals(-1, sortedList.remove(new Node(101)));

		print(null, sortedList);

		sortedList.remove(3);
		assertEquals(60, sortedList.get(3).getData());
		print(null, sortedList);
	}

	@Test
	public void sizeTest() {
		int size = 10;
		SortedList sortedList = generateTestList(size);
		print(null, sortedList);

		assertEquals(10, sortedList.size());

		sortedList.add(5);
		sortedList.add(15);
		sortedList.add(105);

		print(null, sortedList);
		assertEquals(13, sortedList.size());

		sortedList.remove(new Node(1));
		assertEquals(13, sortedList.size());

		sortedList.remove(new Node(30));
		print(null, sortedList);
		assertEquals(12, sortedList.size());
	}

}
