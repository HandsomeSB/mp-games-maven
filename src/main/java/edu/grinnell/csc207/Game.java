package edu.grinnell.csc207;

import java.util.ArrayList;

import edu.grinnell.csc207.GameObjects.GameObject;
import edu.grinnell.csc207.util.Matrix;
import edu.grinnell.csc207.util.MatrixV0;

public class Game {
    // contains board, winning condition, facilitation
    private Matrix<java.lang.Character> board;
    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    private static Game instance = new Game();
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
        //place walls
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
        for(GameObject go : this.gameObjects) { 
            this.board.set(go.position.getY(), go.position.getX(), go.character);
        }
    }

    public Matrix<java.lang.Character> getBoard() { 
        return this.board;
    }
}
