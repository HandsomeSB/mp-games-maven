package edu.grinnell.csc207;

import java.util.ArrayList;

import edu.grinnell.csc207.GameObjects.Objective;
import edu.grinnell.csc207.GameObjects.Enemy;
import edu.grinnell.csc207.GameObjects.GameObject;
import edu.grinnell.csc207.GameObjects.Player;
import edu.grinnell.csc207.util.Matrix;
import edu.grinnell.csc207.util.MatrixV0;
import edu.grinnell.csc207.util.Vector2D;
import java.util.Random;

public class Game {
    // contains board, winning condition, facilitation
    private Matrix<java.lang.Character> board;
    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    private static Game instance = new Game();
    private Objective objective;
    private Player player;
    private Enemy enemy;
    private int score = 0;
    private boolean gameOver = false;

    public static Game getInstance() {
        return Game.instance;
    }

    private Game() {
        this.board = new MatrixV0<java.lang.Character>(8, 8, '.');
        init();
    }

    /**
     * 
     */
    private void init() { 
        //place character
        this.player = new Player(new Vector2D(0, 0),'P', this.board.height(), this.board.width());
        this.gameObjects.add(this.player);

        this.enemy = new Enemy(new Vector2D(7, 0), 'E', this.player, this.board.height(), this.board.width());
        this.gameObjects.add(enemy);
        
        this.objective = new Objective(new Vector2D(2, 2), player, '*');
        this.gameObjects.add(objective);

        //Initial rendering
        renderBoard();
    }
    /**
     * Represent a single turn of the game
     */
    public void update() { 
        updateGameObjects();
        if (this.player.collidesWith(this.enemy)) {
            this.gameOver = true;
        }
        renderBoard();
    }

    private void updateGameObjects() { 
        for(GameObject go : this.gameObjects) {
            go.update();
        }
    }

    private void renderBoard() { 
        this.board.fillRegion(0, 0, this.board.height(), this.board.width(), '.');
        for(GameObject go : this.gameObjects) { 
            for(int i = 0; i < go.size.getX(); ++i) { 
                for(int j = 0; j < go.size.getY(); ++j) { 
                    this.board.set(go.position.getY() + i, go.position.getX() + j, go.character);
                }
            }
        }
    }

    public boolean getGameOver() {
        return this.gameOver;
    }

    public Matrix<java.lang.Character> getBoard() { 
        return this.board;
    }

    public int getScore() { 
        return this.score;
    }

    public void setScore(int val) {
        this.score = val;
    }
}
