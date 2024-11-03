package edu.grinnell.csc207;

import java.util.ArrayList;

import edu.grinnell.csc207.GameObjects.Enemy;
import edu.grinnell.csc207.GameObjects.GameObject;
import edu.grinnell.csc207.GameObjects.Player;
import edu.grinnell.csc207.util.Matrix;
import edu.grinnell.csc207.util.MatrixV0;
import edu.grinnell.csc207.util.Vector2D;

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
        Player player = new Player(new Vector2D(0, 0),'P');
        this.gameObjects.add(player);

        Enemy enemy = new Enemy(new Vector2D(7, 0), 'E', player);
        this.gameObjects.add(enemy);
        //place walls

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
        this.board.fillRegion(0, 0, this.board.height(), this.board.width(), '.');
        for(GameObject go : this.gameObjects) { 
            for(int i = 0; i < go.size.getX(); ++i) { 
                for(int j = 0; j < go.size.getY(); ++j) { 
                    this.board.set(go.position.getY() + i, go.position.getX() + j, go.character);
                }
            }
        }
    }

    public Matrix<java.lang.Character> getBoard() { 
        return this.board;
    }
}
