/**
 * This program runs the Pacmangame.
 * 
 * @author Marcel & Jean-Michel.
 *
 */
public class Pacmangame {

	public static void main(String[] args) {
		Model model = new Model();
		View view = new View(model);
		view.start();
	}

}
