/**
 * In our Model class all of our maps are stored, which are used by the other classes in our project
 * and of course changed with every movement a ghost or Pacman does.
 * 
 * It's also a superclass of PacMan and Ghost.
 * @author Marcel & Jean-Michel.
 *
 */
public class Model {
	
	protected int startx;
	protected int starty;
	protected boolean gameWon = false;
	protected boolean gameLost = false;
	protected int life = 3;
	protected boolean alive = true;
	// 0 = Passage, 1 = Wall, 3 = Pacman, 4 = Ghostred, 6 = Ghostorange.
	//20x24 Gameboard.
	protected int pacman_datamap[][] = new int [][] {    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			                                             { 1, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1},
			                                             { 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 2, 1, 0, 0, 1, 0, 1},
			                                             { 1, 0, 1, 1, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			                                             { 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 2, 1, 1, 0, 0, 1, 1},
			                                             { 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 1, 0, 1},
			                                             { 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 1},
			                                             { 1, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 2, 0, 0, 1, 0, 0, 1, 2, 1},
			                                             { 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1},
			                                             { 1, 0, 2, 0, 1, 0, 1, 0, 0, 2, 0, 0, 1, 2, 1, 0, 1, 0, 1, 1},
			                                             { 1, 2, 1, 2, 1, 0, 1, 0, 1, 0, 1, 2, 1, 2, 1, 0, 1, 0, 0, 1},
			                                             { 1, 0, 0, 0, 0, 0, 0, 0, 1, 4, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
			                                             { 1, 0, 1, 0, 1, 0, 1, 0, 1, 4, 1, 0, 1, 0, 1, 2, 1, 1, 0, 1},
			                                             { 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 2, 0, 1, 0, 1},
			                                             { 1, 0, 1, 0, 1, 2, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1},
			                                             { 1, 0, 0, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 2, 0, 0, 1},
			                                             { 1, 2, 1, 0, 1, 0, 0, 2, 0, 0, 0, 0, 2, 0, 1, 1, 1, 1, 0, 1},
			                                             { 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
			                                             { 1, 0, 1, 2, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
			                                             { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 2, 0, 1},
			                                             { 1, 0, 1, 1, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
			                                             { 1, 0, 1, 1, 0, 1, 1, 0, 1, 2, 1, 1, 2, 1, 0, 1, 2, 1, 0, 1},
			                                             { 1, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1},
			                                             { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
			

	};
	protected final int pacman_maplevel2[] [] = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1 },
	{1,0,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,0,1 },
	{1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1 },
	{1,0,1,0,1,1,1,1,0,1,1,0,0,1,1,1,0,1,0,1 },
	{1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1 },
	{1,0,1,0,1,0,1,1,0,1,1,0,1,1,0,1,0,1,0,1 },
	{1,0,1,0,1,0,1,0,0,0,0,0,0,1,0,1,0,1,0,1 },
	{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1 },
	{1,0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,1,1,0,1 },
	{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1 },
	{1,0,1,0,1,0,1,0,1,4,1,0,0,0,1,0,1,0,1,1 },
	{1,0,1,0,1,0,1,0,1,4,1,0,1,0,1,0,1,0,0,1 },
	{1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,1 },
	{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1 },
	{1,0,1,0,1,0,1,0,1,1,1,1,0,1,0,1,0,1,0,1 },
	{1,0,1,0,1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,1 },
	{1,0,1,0,1,0,1,1,1,0,1,0,1,1,0,1,0,1,0,1 },
	{1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1 },
	{1,0,1,0,1,1,1,1,0,1,1,0,1,1,1,1,0,1,0,1 },
	{1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1 },
	{1,0,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,0,1 },
	{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,1 },
	{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1 }};

		
		
	public Model() {
		
	}
	
	public Model(int startx, int starty) {
		this.startx = startx;
		this.starty = starty;
	}
	
	
	
	
	
	
	
	public int[][] getPacman_datamap() {
		return pacman_datamap;
	}
	
}
