package edu.grinnell.csc207.GameObjects;

import edu.grinnell.csc207.UI.KeyboardInput;
import edu.grinnell.csc207.util.Vector2D;

public class Player extends GameObject{
    public Player(Vector2D pos, Character chara, int boardHeight, int boardWidth) { 
        super(pos, chara, boardHeight, boardWidth);
    }

    public Player(Vector2D pos, Vector2D size, Character chara, int boardHeight, int boardWidth) { 
        super(pos, size, chara, boardHeight, boardWidth);
    }

    @Override
    public void update() { 
        char move = KeyboardInput.getInstance().getInput();
        
        switch (move) {
            case 'w':
                if (this.position.getY() - 1 < 0) {
                    System.out.println("Invalid movement");
                    return;
                }
                this.position.incrementY(-1);
                break;
            case 'a':
                if (this.position.getX() - 1 < 0) {
                    System.out.println("Invalid movement");
                    return;
                }
                this.position.incrementX(-1);
                break;
            case 's':
                if (this.position.getY() + 1 >= this.boardHeight) {
                    System.out.println("Invalid movement");
                    return;
                }
                this.position.incrementY(1);
                break;
            case 'd':
                if (this.position.getX() + 1 >= this.boardWidth) {
                    System.out.println("Invalid movement");
                    return;
                }
                this.position.incrementX(1);
                break;
            default:
                break;
        }
    }
}
