package xjtlu.cpt108.recursion.blob;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GridTest {
	private static final String GRID = "   **  " //
			+ "\n ***    * " //
			+ "\n     *" //
			+ "\n  ****    **" //
			+ "\n  ****  " //
			+ "\n  *    *" //
			+ "\n        *" //
	;

	@Test
	public void gridHasBlobTest() {
		Grid blob = new Grid();
		blob.setGrid(GRID);

		// out of boundary cell
		assertFalse(blob.isFilled(1, 10));

		// cell with no blob
		assertFalse(blob.isFilled(0, 1));
		assertFalse(blob.isFilled(1, 4));
		assertFalse(blob.isFilled(3, 1));

		// cell with blob
		assertTrue(blob.isFilled(0, 3));
		assertTrue(blob.isFilled(1, 1));
		assertTrue(blob.isFilled(1, 3));
		assertTrue(blob.isFilled(3, 2));

		System.out.println("all has blob tests are passed!");
	}

	@Test
	public void gridCountBlobTest() {
		Grid blob = new Grid();
		blob.setGrid(GRID);

		// out of boundaries
		assertEquals(0, blob.countCellsInBlob(-2, 2));
		assertEquals(0, blob.countCellsInBlob(3, 18));

		// non-blob cell
		assertEquals(0, blob.countCellsInBlob(2, 2));
		assertEquals(0, blob.countCellsInBlob(2, 3));
		assertEquals(0, blob.countCellsInBlob(2, 11));
		assertEquals(0, blob.countCellsInBlob(5, 6));

		// count blobs
		assertEquals(5, blob.countCellsInBlob(1, 2));
		assertEquals(1, blob.countCellsInBlob(1, 8));
		assertEquals(10, blob.countCellsInBlob(3, 2));
		assertEquals(2, blob.countCellsInBlob(3, 10));
		assertEquals(2, blob.countCellsInBlob(3, 11));
		assertEquals(2, blob.countCellsInBlob(5, 7));

		System.out.println("all count blob tests are passed!");
	}
}
