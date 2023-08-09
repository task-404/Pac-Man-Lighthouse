/**
 * This Class is responsible for how our Ghosts to move in our 2D-Array.
 * @author Marcel & Jean-Michel.
 *
 */
public class Ghost extends Model implements Moveable {

	public Ghost(int startx, int starty) {
		super(startx, starty);
	}


	public void move_left(int pacman_datamap[][]) {
		// was ist links von mir?
		int value = pacman_datamap[startx][starty-1];
		switch (value) {

		case 0:
			pacman_datamap[startx][starty] = 0;
			pacman_datamap[startx][--starty] = 4;
			break;
		case 5:
		case 1:
		case 4:
		case 6:
			break;
		case 2: // kollision mit einem coin
			pacman_datamap[startx][starty] = 2;
			pacman_datamap[startx][--starty] = 4;
			break;
		default:
			break;
		}
	}

	public void move_right(int pacman_datamap[][]) {
		// was ist links von mir?
		int value = pacman_datamap[startx ][starty+1];
		switch (value) {

		case 0:
			pacman_datamap[startx][starty] = 0;
			pacman_datamap[startx][++starty] = 4;
			break;
		case 5:
		case 1:
		case 4:
		case 6:
			break;
		case 2: // kollision mit einem coin
			pacman_datamap[startx][starty] = 2;
			pacman_datamap[startx][++starty] = 4;
			break;
		default:
			break;
		}
	}

	public void move_up(int pacman_datamap[][]) {
		// was ist links von mir?
		int value = pacman_datamap[startx-1][starty ];
		switch (value) {

		case 0:
			pacman_datamap[startx][starty] = 0;
			pacman_datamap[--startx][starty] = 4;
			break;

		case 1:
		case 4:
		case 6:
			break;
		case 2: // kollision mit einem coin
			pacman_datamap[startx][starty] = 2;
			pacman_datamap[--startx][starty] = 4;
			break;
		case 5:
			pacman_datamap[startx][starty] = 0;
			pacman_datamap[--startx][starty] = 4;
			break;
		default:
			break;
		}
	}

	public void move_down(int pacman_datamap[][]) {
		// was ist links von mir?
		int value = pacman_datamap[startx+1][starty];
		switch (value) {

		case 0:
			pacman_datamap[startx][starty] = 0;
			pacman_datamap[++startx][starty] = 4;
			break;
		case 5:
		case 1:
		case 4:
		case 6:
			break;
		case 2: // kollision mit einem coin
			pacman_datamap[startx][starty] = 2;
			pacman_datamap[++startx][starty] = 4;
			break;
		default:
			break;
		}
	}

}
