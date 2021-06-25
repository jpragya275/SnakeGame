package snakeGame;

public class Cell {
	private final int row, col;
	private CellType celltype;
	
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public CellType getCelltype() {
		return celltype;
	}

	public void setCellType(CellType celltype) {
		this.celltype = celltype;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}	
}
