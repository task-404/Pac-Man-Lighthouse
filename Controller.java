
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * This class checks the Keyinput and sends data to the model class.
 * @author Marcel & Jean-Michel.
 *
 */
public class Controller implements KeyListener {
//creates an instance of the View class.
	private View view;
//creates a constructor of the Controller class
	public Controller(View view) {
		this.view = view;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
/**
 * calculates a random number and moves the ghost unit depending on the result.
 * @param ghost is a character of the interface class.
 */
	private void moveGhost(Moveable ghost) {
		double random = Math.random();
// TODO: wohin kann ich mich bewegen? 1, 2, 3, 4
		if (random <= 0.25) {
			ghost.move_left(view.getModel().getPacman_datamap());
		} else if (random > 0.25 && random <= 0.5) {
			ghost.move_right(view.getModel().getPacman_datamap());
		} else if (random > 0.5 && random <= 0.75) {
			ghost.move_up(view.getModel().getPacman_datamap());
		} else {
			ghost.move_down(view.getModel().getPacman_datamap());
		}

	}
/**
 * Moves an Unit of the List of moveable characters.
 * 
 * @param keyCode which Key is pressed.
 */
	private void move(int keyCode) {
		for (Moveable moveable : view.getCharacters()) {
			if (moveable instanceof Ghost) {
				moveGhost(moveable);
			} else {
				switch (keyCode) {
				case KeyEvent.VK_UP:
					moveable.move_up(view.getModel().getPacman_datamap());
					break;
				case KeyEvent.VK_DOWN:
					moveable.move_down(view.getModel().getPacman_datamap());
					break;
				case KeyEvent.VK_LEFT:
					moveable.move_left(view.getModel().getPacman_datamap());
					break;
				case KeyEvent.VK_RIGHT:
					moveable.move_right(view.getModel().getPacman_datamap());
					break;
				}
			}
		}
		view.fillMap();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		move(e.getKeyCode());
//		switch (e.getKeyCode()) {
//		case KeyEvent.VK_UP:
//			moveGhost(view.getGhostred());
//			moveGhost(view.getGhostorange());
////			view.getGhostred().moveGhost();
////			view.getGhostorange().moveGhost();
//			view.getPacman().move_up();
//			view.fillMap();
//
//			break;
//
//		case KeyEvent.VK_DOWN:
//			view.getPacman().move_down();
//			view.fillMap();
//			break;
//
//		case KeyEvent.VK_LEFT:
////			System.out.println(view.getModel().getPacman_datamap()[view.getModel().getPacman_datamap().length - 1]);
//			view.getPacman().move_left();
////			System.out.println(view.getModel().getPacman_datamap()[view.getModel().getPacman_datamap().length - 1]);
//			view.fillMap();
//			break;
//
//		case KeyEvent.VK_RIGHT:
//			view.getPacman().move_right();
//			view.fillMap();
//			break;
//		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
