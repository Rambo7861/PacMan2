package com.example.pacman2.player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ghost extends ImageView {

    int matrix [][] = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0},
            {0,1,1,1,1,1,1,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
            {1,1,1,1,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,1,1,1,1,1},
            {1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,1,1,1,1,1},
            {1,1,1,1,1,0,1,0,1,0,0,0,1,1,0,0,0,1,0,0,1,0,1,1,1,1,1},
            {0,0,0,0,0,0,1,0,1,0,1,1,1,1,1,1,0,1,0,0,1,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0},
            {1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,1,1,1,1,1},
            {1,1,1,1,1,0,1,0,1,0,1,0,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1},
            {1,1,1,1,1,0,1,0,1,0,1,0,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1},
            {0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,1,0,1,0,0,0,0,1,0,1,1,1,1,1,1,1,1,1,0},
            {0,1,0,0,1,0,1,0,1,0,1,0,0,0,0,1,0,1,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,1,0,1,0,1,0,1,1,0,0,1,1,0,1,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,1,0,1,0,1,1,1,1,0,0,1,1,1,1,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };

    enum Directions {LEFT, RIGHT, UP, DOWN, IDLE}
    final int TILE_SIZE = 40;
    final int velo = 4;
    final int enemyVelo = 1;

    int pX = 1;
    int pActualX = 60;
    int pY = 1;
    int pActualY = 60;

    int ghostX = 4;
    int ghostActualX = 4 * TILE_SIZE + 20;
    int ghostActualY = 1 * TILE_SIZE + 20;
    Directions ghostDirection = Directions.RIGHT;
    int ghostY = 1;

    int posX = 15;
    int posY = 15;

    Image ghostImage = new Image(new FileInputStream("C:\\Users\\sair7\\IdeaProjects\\PacMan2\\src\\main\\resources\\Images\\red.png"));

    public Ghost() throws FileNotFoundException {
        this.setImage(ghostImage);
        this.setX(455);
        this.setY(420);
        this.setFitHeight(25);
        this.setFitWidth(25);
    }

    private void moveGhost(){
        switch (ghostDirection){
            case LEFT:
                //Check Matrix for walls
                if (matrix[ghostX - 1][ghostY] != 1){
                    //if no wall move LEFT
                    if (ghostActualX == ghostX * TILE_SIZE + 20 && ghostActualY == ghostY * TILE_SIZE + 20) {
                        System.out.println("Can move LEFT");
                        ghostX -= 1;
                        ghostDirection = Directions.LEFT;
                    }
                    System.out.println(ghostX + " " + ghostY);
                }else {
                    ghostDirection = Directions.IDLE;
                }
                break;
            case RIGHT:
                if (matrix[ghostX + 1][ghostY] != 1){
                    //if no wall move RIGHT
                    if (ghostActualX == ghostX * TILE_SIZE + 20 && ghostActualY == ghostY * TILE_SIZE + 20) {
                        System.out.println("Can move RIGHT");
                        ghostX += 1;
                        ghostDirection = Directions.RIGHT;
                    }
                    System.out.println(ghostX + " " + ghostY);
                }else {
                    ghostDirection = Directions.IDLE;
                }
                break;
            case DOWN:
                if (matrix[ghostX][ghostY + 1] != 1){
                    if (ghostActualX == ghostX * TILE_SIZE + 20 && ghostActualY == ghostY * TILE_SIZE + 20) {
                        System.out.println("Can move DOWN");
                        ghostY += 1;
                        ghostDirection = Directions.DOWN;
                    }
                    System.out.println(ghostX + " " + ghostY);
                }else {
                    ghostDirection = Directions.IDLE;
                }
                break;
            case UP:
                if (matrix[ghostX][ghostY - 1] != 1){
                    if (ghostActualX == ghostX * TILE_SIZE + 20 && ghostActualY == ghostY * TILE_SIZE + 20) {
                        System.out.println("Can move UP");
                        ghostY -= 1;
                        ghostDirection = Directions.UP;
                    }
                    System.out.println(ghostX + " " + ghostY);
                }else {
                    ghostDirection = Directions.IDLE;
                }
                break;
            default:
                int rnd = (int)Math.floor(Math.random() * (4 - 1 + 1) + 1);
                System.out.println(rnd);
                switch (rnd){
                    case 1 -> ghostDirection = Directions.LEFT;
                    case 2 -> ghostDirection = Directions.RIGHT;
                    case 3 -> ghostDirection = Directions.UP;
                    case 4 -> ghostDirection = Directions.DOWN;
                }
        }
    }
}

