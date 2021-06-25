
package snakeGame;

public class Game {
	
	private Snake snake;
	private Board board;
	private Directions direction;
	private long score;
	private boolean gameOver;
	
	public Game(Snake snake, Board board) {
		this.snake = snake;
		this.board = board;
		score = 0;
	}
	
	public Snake getSnake() {
		return snake;
	}


	public void setSnake(Snake snake) {
		this.snake = snake;
	}


	public Board getBoard() {
		return board;
	}


	public void setBoard(Board board) {
		this.board = board;
	}


	public Directions getDirection() {
		return direction;
	}


	public void setDirection(Directions direction) {
		this.direction = direction;
	}


	public boolean isGameOver() {
		return gameOver;
	}


	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public void update() {
		System.out.println("direction :" + direction);
		if(!gameOver) {
			if(direction != Directions.NONE) {
				Cell nextCell = getNextCell(snake.getHead());
				if(snake.checkCrash(nextCell)) {
					gameOver = true;
					direction = Directions.NONE;
				}
				else {
					if(nextCell.getCelltype() == CellType.FOOD) {
						++score;
						snake.grow(nextCell);
						board.generateFood();
					}
					else {
						snake.move(nextCell);
					}
				}
			}
		}
	}
	
	public Cell getNextCell(Cell head) {
		int r = head.getRow();
		int c = head.getCol();
		switch(direction) {
			case LEFT:
				--c;
				break;
			case RIGHT:
				++c;
				break;
			case UP:
				--r;
				break;
			case DOWN:
				++r;
				break;
			default:
				break;
		}
		if(r >= board.getROW()) {
			r = 0;
		}
		else if(r < 0) {
			r = board.getROW()-1;
		}
		if(c >= board.getCOL()) {
			c = 0;
		}
		else if(c < 0){
			c = board.getCOL() - 1;
		}
		
		Cell cell = board.getGrid()[r][c];
		return cell;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}
}
