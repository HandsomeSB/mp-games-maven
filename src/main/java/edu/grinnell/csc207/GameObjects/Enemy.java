package edu.grinnell.csc207.GameObjects;

import edu.grinnell.csc207.util.Vector2D;

public class Enemy extends GameObject {
    private GameObject target;

    public Enemy(Vector2D pos, Character chara, GameObject tar) { 
        super(pos, chara);
        this.target = tar;
    }

    @Override
    public void update() { 
        this.move(target);
    }

    private void move(GameObject target) { 
        //look for valid moves 
        if(target.position.getX() > this.position.getX()) { 
            this.position.incrementX(1);
        } else if(target.position.getY() > this.position.getY()) { 
            this.position.incrementY(1);
        }
    }
}
