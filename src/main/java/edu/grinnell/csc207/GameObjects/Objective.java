package edu.grinnell.csc207.GameObjects;

import java.util.Random;

import edu.grinnell.csc207.Game;
import edu.grinnell.csc207.util.Vector2D;

/**
 * The objective (goal) of our game.
 * 
 * @author Harrison Zhu
 * @author Mina Bakrac
 */
public class Objective extends GameObject {
    
    Player player;

    /**
     * Create a new objective.
     * 
     * @param pos
     *      The position.
     * @param plr
     *      The player.
     * @param chara
     *      The character.
     */
    public Objective(Vector2D pos, Player plr, Character chara) {
        super(pos, chara, 0, 0);
        this.player = plr;
    }  // Objective(Vector2D, Player, Character)

    /**
     * The update method for objectives.
     */
    @Override
    public void update() {
        if(this.collidesWith(player)) { 
            Random rand = new Random();
            int objX = rand.nextInt(1, 7);
            int objY = rand.nextInt(0, 8);
            this.position = new Vector2D(objX, objY);
            Game game = Game.getInstance();
            game.setScore(game.getScore() + 1);
        } // if
    } // update()
} // class Objective
