package xjtlu.cpt108.recursion.blob;

/**
 * Grid for storing cells information
 */
public class Grid {

	/**
	 * Constant for representing filled cell
	 */
	private static final char FILLED_CELL = '*';

	/**
	 * Constant for representing non-blob cell
	 */
	private static final char EMPTY_CELL = ' ';

	/**
	 * Number of rows in the grid
	 */
	private int numRows;

	/**
	 * Number of columns in the grid
	 */
	private int numColumns;

	/**
	 * The grid
	 */
	private String[] grid;

	/**
	 * Default constructor
	 * used to clear the context
	 */
	public Grid() {
		clear();
	}

	/**
	 * Set the grid from the input string
	 * 
	 * @param grid Input grid
	 */
	public void setGrid(final String grid) {
		if (null == grid || grid.isBlank()) throw new IllegalArgumentException("Input grid is null or empty!");
		clear();
		String[] rows = grid.split("\n");
		numRows = rows.length;
		numColumns = 0;
		for (int i = 0; i < rows.length; i++) {
			if (rows[i].length() > numColumns) numColumns = rows[i].length();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < rows[i].length(); j++) {
				switch (rows[i].charAt(j)) {
				case EMPTY_CELL -> sb.append(EMPTY_CELL);
				case FILLED_CELL -> sb.append(FILLED_CELL);
				default -> throw new IllegalArgumentException(
						String.format("Unrecognized cell type: %s at (%s,%s)", rows[i].charAt(j), i, j));
				};
			}
			if (rows[i].length() < numColumns) {
				sb.append(String.valueOf(EMPTY_CELL).repeat(numColumns - rows[i].length()));
			}
			sb.append("\n");
		}
		this.grid = sb.toString().split("\n");
		System.out.println("number of rows=" + numRows);
		System.out.println("number of columns=" + numColumns);
		printGrid();
	}

	/**
	 * Print the grid
	 */
	public void printGrid() {
		if (null == grid) throw new RuntimeException("Grid has not been set!");

		StringBuilder sb = new StringBuilder();
		sb.append("    +").append("-".repeat(numColumns)).append("+");
		sb.append("\n    |");
		for (int i = 0; i < numColumns; i++)
			sb.append(i % 10);
		sb.append("|");

		// print the grid by rows
		sb.append("\n+---+").append("-".repeat(numColumns)).append("+");
		for (int i = 0; i < grid.length; i++)
			sb.append(String.format("\n|%03d|%s|", i, grid[i]));
		sb.append("\n+---+").append("-".repeat(numColumns)).append("+");
		System.out.println(sb.toString());
	}

	/**
	 * Reset the grid
	 */
	public void clear() {
		this.grid = null;
		numRows = numColumns = -1;
	}

	/**
	 * Check whether the cell is within the boundary of the grid
	 * 
	 * @param x x-coordinate of the cell
	 * @param y y-coordinate of the cell
	 * @return <code>true</code> if the input location is within the boundaries of the grid; <code>false</code> otherwise
	 */
	private boolean isWithinBoundary(int x, int y) {
		if (null == grid) throw new RuntimeException("Grid has not been set!");
		if (x < 0 || y < 0) return false;
		if (x >= numRows || y >= numColumns) return false;
		return true;
	}

	/**
	 * Check whether the cell is filled
	 * 
	 * @param x x-coordinate of the cell
	 * @param y y-coordinate of the cell
	 * @return <code>true</code> if the input location is filled; <code>false</code> otherwise
	 */
	public boolean isFilled(int x, int y) {
		if (!isWithinBoundary(x, y)) return false;
		return FILLED_CELL == grid[x].charAt(y);
	}

	/**
	 * Count the number of filled cells in a blob
	 * 
	 * @param x starting x-coordinate
	 * @param y starting y-coordinate
	 * @return Number of cells in the blob associated with the starting location
	 */
	public int countCellsInBlob(int x, int y) {
		// TODO: Your implementation starts here
		// TODO: You may also need to consider adding new methods to this class

		return -1;
	}

}
