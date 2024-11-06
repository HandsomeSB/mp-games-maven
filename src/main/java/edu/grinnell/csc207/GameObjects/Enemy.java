package edu.grinnell.csc207.GameObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import edu.grinnell.csc207.util.Vector2D;

public class Enemy extends GameObject {
    private GameObject target;

    public Enemy(Vector2D pos, Character chara, GameObject tar, int boardHeight, int boardWidth) { 
        super(pos, chara, boardHeight, boardWidth);
        this.target = tar;
    }

    @Override
    public void update() { 
        this.move(target, 0);
    }

    private void move(GameObject target, int count) { 
        if (count < 2) {
        ArrayList<Vector2D> candidatePositions = new ArrayList<Vector2D>(Arrays.asList(
            new Vector2D(this.position.getX() + 1, this.position.getY()),
            new Vector2D(this.position.getX() - 1, this.position.getY()),
            new Vector2D(this.position.getX(), this.position.getY() + 1),
            new Vector2D(this.position.getX(), this.position.getY() - 1)
        ));

        int minManhattanDist = Integer.MAX_VALUE;
        ArrayList<Vector2D> nextPosition = new ArrayList<Vector2D>();
        for(Vector2D pos : candidatePositions) { 
            if(pos.getX() > 0 && pos.getY() > 0 && pos.getX() < this.boardWidth && pos.getY() < this.boardHeight) {
                int dist = pos.manhattanDist(target.position);
                if(dist < minManhattanDist) { 
                    minManhattanDist = dist;
                    nextPosition = new ArrayList<Vector2D>();
                }
                if(dist == minManhattanDist) { 
                    nextPosition.add(pos);
                }

            }
        }
        Random rand = new Random();
        this.position = nextPosition.get(rand.nextInt(nextPosition.size()));
        this.move(this.target, count + 1);  
    }
}
}
