package edu.grinnell.csc207.GameObjects;

public class Enemy extends Character {
    private Character target;

    @Override
    public void move() { 
        this.move(target);
    }

    private void move(Character target) { 
        //look for valid moves 
        if(target.position.getX() > this.position.getX()) { 
            this.position.incrementX(1);
        } else if(target.position.getY() > this.position.getY()) { 
            this.position.incrementY(1);
        }
    }
}
