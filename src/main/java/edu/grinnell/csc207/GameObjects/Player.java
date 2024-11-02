package edu.grinnell.csc207.GameObjects;

import edu.grinnell.csc207.UI.KeyboardInput;
import edu.grinnell.csc207.util.Vector2D;

public class Player extends GameObject{
    public Player(Vector2D pos, Character chara) { 
        super(pos, chara);
    }

    @Override
    public void update() { 
        char move = KeyboardInput.getInstance().getInput();
        
        switch (move) {
            case 'w':
                
                break;
            case 'a':
                break;
            case 's':
                break;
            case 'd':
                break;
            default:
                break;
        }
    }
}
