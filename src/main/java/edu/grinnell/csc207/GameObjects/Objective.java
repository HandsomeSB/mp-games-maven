package edu.grinnell.csc207.GameObjects;

import java.util.Random;

import edu.grinnell.csc207.Game;
import edu.grinnell.csc207.util.Vector2D;

public class Objective extends GameObject {
    Player player;

    public Objective(Vector2D pos, Player plr, Character chara) {
        super(pos, chara, 0, 0);
        this.player = plr;
    } 

    @Override
    public void update() {
        if(this.collidesWith(player)) { 
            Random rand = new Random();
            int objX = rand.nextInt(1, 7);
            int objY = rand.nextInt(0, 8);
            this.position = new Vector2D(objX, objY);
            Game game = Game.getInstance();
            game.setScore(game.getScore() + 1);
        }
    }
}
