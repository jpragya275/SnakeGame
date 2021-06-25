/**************************************************************
 * Introduction:
 * 
 * Functions:
 * 
 *************************************************************/

package snakeGame;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BoardPanel extends JPanel implements KeyListener, ActionListener{

	private static final long serialVersionUID = 1L;
	static int ROW, COL, ORIGINX, ORIGINY, CELLSIDE;
	private Directions direction;
	private Timer timer;
	private int delay = 100;
	private Snake snake;
	private Board board;
	private Game game;
	
	public BoardPanel(Game game, Snake snake, Board board){
		this.snake = snake;
		this.board = board;
		this.game = game;
		ROW = board.getROW();
		COL = board.getCOL();
		direction = Directions.NONE;
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	

	public Directions getDirection() {
		return direction;
	}

	public void setDirection(Directions direction) {
		this.direction = direction;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ORIGINX = 0;
		ORIGINY = 80;
		CELLSIDE = 16;
		g.setColor(Color.black);
		g.fillRect(0, 0, CELLSIDE*COL, ORIGINY-5);
		
		g.setColor(Color.BLACK);
		g.fillRect(ORIGINX, ORIGINY, CELLSIDE*COL, CELLSIDE*ROW);
		
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 48));
		g.drawString("Snake Game!", 570, 55);
		
		g.setFont(new Font("arial", Font.LAYOUT_RIGHT_TO_LEFT ,20));
		g.drawString("Score : " + game.getScore(), 1400, 45);
		
		g.setColor(Color.blue);
		g.fillOval(snake.getHead().getCol()*CELLSIDE + ORIGINX, snake.getHead().getRow()*CELLSIDE + ORIGINY, 14, 14);
		
		for(Cell c : snake.getSnakeBody()) {
			if(!c.equals(snake.getHead())) {
				g.drawOval(c.getCol()*CELLSIDE + ORIGINX, c.getRow()*CELLSIDE + ORIGINY, 12, 12);
			}
		}
		
		g.setColor(Color.orange);
		g.fillOval(board.getFoodCell().getCol()*CELLSIDE + ORIGINX + 3, board.getFoodCell().getRow()*CELLSIDE + ORIGINY + 3, 10, 10);
	
		if(game.isGameOver()) {
			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD, 100));
			g.drawString("Game Over", 500, 380);
			g.setFont(new Font("arial", Font.BOLD, 60));
			g.drawString("Score: " + game.getScore(), 650, 500);
		}
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(direction != Directions.NONE && !game.isGameOver()) {
			game.setDirection(direction);
			game.update();
		}
		if(direction == Directions.NONE || game.isGameOver()) {
			repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keycode :" + e.getKeyCode());
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(direction != Directions.RIGHT) {
				direction = Directions.LEFT;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(direction != Directions.LEFT) {
				direction = Directions.RIGHT;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(direction != Directions.DOWN) {
				direction = Directions.UP;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(direction != Directions.UP) {
				direction = Directions.DOWN;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
