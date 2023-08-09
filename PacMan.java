/**
 * This Class is responsible for how our Pacman moves in our 2D-Array and what happens if the dies or wins the game.
 * @author Marcel & Jean-Michel.
 *
 */
public class PacMan extends Model implements Moveable {

	private int life = 3;
	

	private int coincounter;
	private int maximumcoins = 36;
	private final int initialx;
	private final int initialy;
	

	
	public PacMan(int startx, int starty) {
		super(startx, starty);
		this.initialx = startx;
		this.initialy = starty;
		
	}

	/**
	 * Methods for moving Pacman in our 2-Array.
	 */
	public void move_left(int pacman_datamap[][]) {
		//Stores the values of position on the right from Pacman.
		int value = pacman_datamap[startx] [starty-1];
		switch (value) {
		//changes the current position of Pacman to a Wall and overwrite the position to his right with Pacmans value.
		case 0:
			pacman_datamap[startx] [starty] = 0 ;
			pacman_datamap[startx] [--starty] = 3;
			break;
			//Pacman can't move into a wall.
		case 1:
			break;
			//changes the current position of Pacman to a Wall(deletes the coin) and overwrite the position to his right with Pacmans value.
			//increments the coincounter by 1 and calls the Gameover method to check if the game is won.
		case 2: 
			pacman_datamap[startx] [starty] = 0;
			pacman_datamap[startx] [--starty] = 3;
			coincounter++;
			GameOver();
		break;
		case 4:
			//changes the current position of Pacman to a Wall and throws Pacmans to his origin startposition.
			//decrements Pacmans life by 1 and calls the PacManDeath method to check if he is dead.
		case 6:
			pacman_datamap[startx] [starty] = 0;
			pacman_datamap[initialx] [initialy] = 3;
			startx = initialx; 
		    starty = initialy;
		    --life;

		    PacManDeath();
		    
			break;
		default:
			break;
	
		}
		

	}
/**
 * Methods for moving Pacman in our 2-Array.
 */
	public  void move_right(int pacman_datamap[][]) {
		//Stores the values of position on the right from Pacman.
		int value = pacman_datamap[startx] [starty+1];
		switch (value) {
	//changes the current position of Pacman to a Wall and overwrite the position to his right with Pacmans value.
		case 0:
			pacman_datamap[startx] [starty] = 0 ;
			pacman_datamap[startx] [++starty] = 3;
			break;
	//Pacman can't move into a wall.
		case 1:
			break;
			//changes the current position of Pacman to a Wall(deletes the coin) and overwrite the position to his right with Pacmans value.
			//increments the coincounter by 1 and calls the Gameover method to check if the game is won.
		case 2:
			pacman_datamap[startx] [starty] = 0;
			pacman_datamap[startx] [++starty] = 3;
			coincounter++;
			GameOver();
		break;
		case 4:
		case 6:
			//changes the current position of Pacman to a Wall and throws Pacmans to his origin startposition.
			//decrements Pacmans life by 1 and calls the PacManDeath method to check if he is dead.
			pacman_datamap[startx] [starty] = 0 ;
			pacman_datamap[initialx] [initialy] = 3;
			startx = initialx; 
		    starty = initialy;
		    --life;

		    PacManDeath();
			
			break;
		default:
			break;
	}
	}

	public void move_down(int pacman_datamap[][]) {
		// was ist links von mir?
		int value = pacman_datamap[startx+1] [starty];
				switch (value) {
			
				case 0:
					pacman_datamap[startx] [starty] = 0 ;
					pacman_datamap[++startx] [starty] = 3;
					break;
				case 5:
				case 1:
					break;
				case 2: //kollision mit einem coin
					pacman_datamap[startx] [starty] = 0;
					pacman_datamap[++startx] [starty] = 3;
					coincounter++;
					GameOver();
				break;
				case 4:
				case 6:
					pacman_datamap[startx] [starty] = 0 ;
					pacman_datamap[initialx] [initialy] = 3;
					startx = initialx; 
				    starty = initialy;

				    --life;
				    PacManDeath();
				    
					
					break;
				default:
					break;
			}
	}

	public void move_up(int pacman_datamap[][]) {
		// was ist links von mir?
		int value = pacman_datamap[startx-1] [starty];
				switch (value) {
			
				case 0:
					pacman_datamap[startx] [starty] = 0 ;
					pacman_datamap[--startx] [starty] = 3;
					break;
				case 5:
				case 1:
					break;
				case 2: //kollision mit einem coin
					pacman_datamap[startx] [starty] = 0;
					pacman_datamap[--startx] [starty] = 3;
					++coincounter;
					GameOver();
				break;
				//kollision mit Geist
				case 4:
				case 6:
					pacman_datamap[startx] [starty] = 0 ;
					pacman_datamap[initialx] [initialy] = 3;
					startx = initialx; 
				    starty = initialy;

				    --life;
				    PacManDeath();
					break;
				default:
					break;
			}
	}

	/**
	 * Checks if Pacman is dead and closes the program if so.
	 */
	public void PacManDeath() {
		if (life == 0) {
			alive = false;
			gameLost = true;
			System.exit(0);
		}
		
	}
			

	
	/**
	 * Checks is Pacman collected the necessary amount of coins to win the game and closes the program if so.
	 */
	public void GameOver() {
		if(coincounter == maximumcoins) {
			gameWon = true;
			pacman_datamap = pacman_maplevel2;
			coincounter = 0;
			maximumcoins = 3;
			System.exit(0);
		}
	}


}
