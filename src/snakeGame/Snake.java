package snakeGame;
import java.util.LinkedList;

import javax.swing.JFrame;

public class Snake {
	private LinkedList<Cell> snakeBody = new LinkedList <>();
	private Cell head;
	JFrame frame;
	
	public Snake(Cell initPos, Cell body, JFrame frame){
		head = initPos;
		head.setCellType(CellType.SNAKE_BODY);
		snakeBody.add(head);
		snakeBody.add(body);
		body.setCellType(CellType.SNAKE_BODY);
		this.frame = (frame);
		frame.repaint();
	}
	
	public void grow(Cell nextCell) {
		head = nextCell;
		head.setCellType(CellType.SNAKE_BODY);
		snakeBody.add(head);
		frame.repaint();
	}
	
	public void move(Cell nextCell) {
		Cell tail = snakeBody.removeFirst();
		tail.setCellType(CellType.EMPTY);
		head = nextCell;
		head.setCellType(CellType.SNAKE_BODY);
		snakeBody.add(head);
		frame.repaint();
	}
	
	public boolean checkCrash(Cell newCell) {
		for(Cell cell : snakeBody) {
			if(cell == newCell) {
				return true;
			}
		}
		return false;
	}

	public LinkedList<Cell> getSnakeBody() {
		return snakeBody;
	}

	public void setSnakeBody(LinkedList<Cell> snakeBody) {
		this.snakeBody = snakeBody;
	}

	public Cell getHead() {
		return head;
	}

	public void setHead(Cell head) {
		this.head = head;
	}	
}
