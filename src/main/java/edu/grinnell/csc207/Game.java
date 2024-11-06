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
        
        generateObjective();

        //Initial rendering
        renderBoard();
    }
    /**
     * Represent a single turn of the game
     */
    public void update() { 
        updateGameObjects();
        renderBoard();
    }

    private void updateGameObjects() { 
        for(GameObject go : this.gameObjects) {
            go.update();
        }
    }

    private void renderBoard() { 
        if (this.player.position.getX() == this.enemy.position.getX() && this.player.position.getY() == this.enemy.position.getY()) {
            this.gameOver = true;
            System.out.println("GAME OVER!");
        }
        if (this.player.position.getX() == this.objective.position.getX() && this.player.position.getY() == this.objective.position.getY()) {
            this.score++;
            this.gameObjects.remove(this.objective);
            generateObjective();
        }
        System.out.println("Score: " + this.score);
        this.board.fillRegion(0, 0, this.board.height(), this.board.width(), '.');
        for(GameObject go : this.gameObjects) { 
            for(int i = 0; i < go.size.getX(); ++i) { 
                for(int j = 0; j < go.size.getY(); ++j) { 
                    this.board.set(go.position.getY() + i, go.position.getX() + j, go.character);
                }
            }
        }
    }

    private void generateObjective() {
        Random rand = new Random();
        int objX = rand.nextInt(1, 7);
        int objY = rand.nextInt(0, 8);
        this.objective = new Objective(new Vector2D(objX, objY), '*');
        this.gameObjects.add(this.objective);
    }

    public boolean getGameOver() {
        return this.gameOver;
    }

    public Matrix<java.lang.Character> getBoard() { 
        return this.board;
    }
}
