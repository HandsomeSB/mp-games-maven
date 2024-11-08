package edu.grinnell.csc207.GameObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import edu.grinnell.csc207.util.Vector2D;

/**
 * The enemy character object in our game.
 * 
 * @author Harrison Zhu
 * @author Mina Bakrac
 */
public class Enemy extends GameObject {
    /**
     * The target.
     */
    private GameObject target;

    /**
     * Create a new enemy.
     * 
     * @param pos
     *      The position.
     * @param chara
     *      The character.
     * @param tar
     *      The target.
     * @param boardHeight
     *      Height of the board.
     * @param boardWidth
     *      Width of the board.
     */
    public Enemy(Vector2D pos, Character chara, GameObject tar, int boardHeight, int boardWidth) { 
        super(pos, chara, boardHeight, boardWidth);
        this.target = tar;
    } // Enemy(Vector2D, Character, GameObject, int, int)

    /**
     * Updates the position of the ememy.
     */
    @Override
    public void update() { 
        for(int i = 0; i < 2; ++i) { 
            this.move(target);
        } // for
    } // update()

    /**
     * Moves the enemy to a different spot on the board depending on position of player.
     * 
     * @param target
     *      The target.
     */
    private void move(GameObject target) { 
        ArrayList<Vector2D> candidatePositions = new ArrayList<Vector2D>(Arrays.asList(
            new Vector2D(this.position.getX() + 1, this.position.getY()),
            new Vector2D(this.position.getX() - 1, this.position.getY()),
            new Vector2D(this.position.getX(), this.position.getY() + 1),
            new Vector2D(this.position.getX(), this.position.getY() - 1)
        ));
        int minManhattanDist = Integer.MAX_VALUE;
        ArrayList<Vector2D> nextPosition = new ArrayList<Vector2D>();
        for(Vector2D pos : candidatePositions) { 
            if(pos.getX() >= 0 && pos.getY() >= 0 && pos.getX() < this.boardWidth && pos.getY() < this.boardHeight) {
                int dist = pos.manhattanDist(target.position);
                if(dist < minManhattanDist) { 
                    minManhattanDist = dist;
                    nextPosition = new ArrayList<Vector2D>();
                } // if
                if(dist == minManhattanDist) { 
                    nextPosition.add(pos);
                } // if
            } // if
        } // for
        Random rand = new Random();
        this.position = nextPosition.get(rand.nextInt(nextPosition.size()));
    } // move(GameObject)
} // class Enemy
