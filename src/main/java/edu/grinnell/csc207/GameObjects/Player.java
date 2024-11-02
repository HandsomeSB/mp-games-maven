package edu.grinnell.csc207.GameObjects;

import edu.grinnell.csc207.UI.KeyboardInput;
import edu.grinnell.csc207.util.Vector2D;

public class Player extends GameObject{
    public Player(Vector2D pos, Character chara) { 
        super(pos, chara);
    }

    public Player(Vector2D pos, Vector2D size, Character chara) { 
        super(pos, size, chara);
    }

    @Override
    public void update() { 
        char move = KeyboardInput.getInstance().getInput();
        
        switch (move) {
            case 'w':
                this.position.incrementY(-1);
                break;
            case 'a':
                this.position.incrementX(-1);
                break;
            case 's':
                this.position.incrementY(1);
                break;
            case 'd':
                this.position.incrementX(1);
                break;
            default:
                break;
        }
    }
}
