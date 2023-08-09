
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import acm.graphics.GImage;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class View extends GraphicsProgram {
	
	public final int BLOCK_SIZE = 30;
	public final int COIN_SIZE = 10;
	public final int BLOCK_HIGH = 24;
	public final int BLOCK_WIDTH = 20;
	public final int SCREEN_SIZE_HIGH = BLOCK_SIZE * BLOCK_HIGH;
	public final int SCREEN_SIZE_WIDTH = BLOCK_SIZE * BLOCK_WIDTH;
	public final int SCREEN_SIZE = SCREEN_SIZE_WIDTH * SCREEN_SIZE_HIGH;

	private boolean keyListenerExists = false;

	private Model model;
	//creates a List of moveable characters.
	private List<Moveable> characters = new ArrayList<>();
/**
 * Constructor of the View class which adds instances and their position to our List.
 * @param model instance of the model class.
 */
	public View(Model model) {
		this.model = model;
		characters.add(new Ghost(11, 9));
		characters.add(new Ghost(12, 9));
		characters.add(new PacMan(22, 18 ));
		
	}

	public void run() {
		
		fillMap();
	}
/**
 * draws either a blue or black GRect depending on the position.
 * @param x position of the GRect
 * @param y position of the GRect
 * @param color of the GRect
 */
	private void drawRect(int x, int y, Color color) {
		GRect Gang = new GRect(BLOCK_SIZE, BLOCK_SIZE);
		Gang.setFillColor(color);
		Gang.setFilled(true);
		Gang.setLocation(y * BLOCK_SIZE, x * BLOCK_SIZE);
		add(Gang);
	}
/**
 * draws a coin on top of a GRect.
 * @param x position of the coin.
 * @param y position of the coin.
 * @param color of the coin.
 */
	private void drawCoin(int x, int y, Color color) {
		GOval Coin = new GOval(COIN_SIZE, COIN_SIZE);
		Coin.setFillColor(color);
		Coin.setFilled(true);
		Coin.setLocation(y * BLOCK_SIZE + 10, x * BLOCK_SIZE + 10);
		add(Coin);
	}
/**
 * draws either Pacman or a Ghost depending on the position.
 * @param x position of the image.
 * @param y position of the image
 * @param picName of jpg.
 */
	private void drawImage(int x, int y, String picName) {
		GImage Pacman = new GImage(picName);
		Pacman.setLocation(y * BLOCK_SIZE, x * BLOCK_SIZE);
		Pacman.setSize(BLOCK_SIZE, BLOCK_SIZE);
		add(Pacman);
	}
/**
 * Draws the Map of our Pacmangame.
 */
	public void fillMap() {
		if (model.gameLost) {
			GImage Gameover = new GImage("gameOver.jpg");
			Gameover.setLocation(1 , 1 );
		    Gameover.setSize(300,300);
			add(Gameover);
			return;
		}
		
		if (model.gameWon) {
			GImage Gameover = new GImage("gameOver.jpg");
		    Gameover.setSize(SCREEN_SIZE_WIDTH,SCREEN_SIZE_HIGH);
			add(Gameover);
			return;
		}
        //Iterates through our Pacmandatamap and checks whether the x and y coordinates are one of the following:
		// 0 = Passage, 1 = Wall, 3 = Pacman, 4 = Ghostred, 6 = Ghostorange.
		setSize(615, 780);
		for (int x = 0; x < model.getPacman_datamap().length; x++) {
			for (int y = 0; y < model.getPacman_datamap()[y].length; y++) {

				switch (model.getPacman_datamap()[x][y]) {
				case 0:
					drawRect(x, y, Color.BLACK);
					break;
				case 1:
					drawRect(x, y, Color.BLUE);
					break;
				case 2:
					drawRect(x, y, Color.BLACK);
					drawCoin(x, y, Color.YELLOW);
					break;
				case 3:
					drawImage(x, y, "pacmanleft.jpg");
					break;
				case 4:
					drawImage(x, y, "ghost10.jpg");
					break;
				case 6:
					drawImage(x, y, "ghost20.jpg");
					break;
				default:
					System.err.println("invalid value: " + model.getPacman_datamap()[x][y]);
				}

			}
		}

		if (!keyListenerExists) {
			addKeyListeners(new Controller(this));
		}

		keyListenerExists = true;
	}
	
	public List<Moveable> getCharacters() {
		return characters;
	}
	
	public Model getModel() {
		return model;
	}

}
