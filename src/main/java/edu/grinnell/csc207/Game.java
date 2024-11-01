package edu.grinnell.csc207;

import edu.grinnell.csc207.util.Matrix;
import edu.grinnell.csc207.util.MatrixV0;

public class Game {
    // contains board, winning condition, facilitation
    private Matrix<java.lang.Character> board;

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

    }

    public Matrix<java.lang.Character> getBoard() { 
        return this.board;
    }
}
