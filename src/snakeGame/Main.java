package snakeGame;

import java.awt.*;
import javax.swing.JFrame;

public class Main {

	private static Snake snake;
	private static Board board;
	private static Game game;
	private static JFrame frame;	

	public static void main(String[] args) {

		frame = new JFrame("Snake Game");
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
		frame.setSize(size);
		
		frame.setBackground(Color.DARK_GRAY);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int x = frame.getWidth();
		int y = frame.getHeight();
		
		int rows = (y-112)/16;
		int cols = (x-16)/16;
		
		snake = new Snake(new Cell(rows/2, cols/2), new Cell(rows/2, cols/2-1), frame);
		
		System.out.println("Rows: " + rows + " Cols: " + cols +" ");
		
		board = new Board(rows, cols, frame);
		board.generateFood();

		game = new Game(snake, board);

		BoardPanel b = new BoardPanel(game, snake, board);
		frame.add(b);
	}
}
