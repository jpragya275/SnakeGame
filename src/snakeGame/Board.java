package snakeGame;

import javax.swing.JFrame;

public class Board {
	private Cell[][] grid;
	private Cell foodCell;
	private JFrame frame;
	static int ROW, COL, ORIGINX, ORIGINY, CELLSIDE;
	
	public Board(int rows, int cols, JFrame frame) {
		ROW = rows;
		COL = cols;
		this.frame = frame;
		grid = new Cell[ROW][COL];
		for(int i=0; i<ROW; ++i) {
			for(int j=0; j<COL; ++j) {
				grid[i][j] = new Cell(i, j);
				grid[i][j].setCellType(CellType.EMPTY);
				
			}
		}
	}

	public Cell getFoodCell() {
		return foodCell;
	}

	public void setFoodCell(Cell foodCell) {
		this.foodCell = foodCell;
	}
	
	public Cell[][] getGrid() {
		return grid;
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}

	public int getROW() {
		return ROW;
	}

	public void setROW(int rOW) {
		ROW = rOW;
	}

	public int getCOL() {
		return COL;
	}

	public void setCOL(int cOL) {
		COL = cOL;
	}
	
	public void generateFood() {
		int r, c;
		while(true) {
			r = (int)(Math.random()*ROW);
			c = (int)(Math.random()*COL);
			if(grid[r][c].getCelltype() != CellType.SNAKE_BODY) {
				break;
			}
		}
		grid[r][c].setCellType(CellType.FOOD);
		foodCell = grid[r][c];
		frame.repaint();
//		System.out.println("Generating food at " + r  + " " + c);
	}
	
}
