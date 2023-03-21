package com.example.pacman2.player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Pacman extends ImageView {

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
    Directions playerDirection = Directions.IDLE;
    final int TILE_SIZE = 40;
    int pX = 1;
    int pActualX = 60;
    int pY = 1;
    int pActualY = 60;

    int posX = 15;
    int posY = 15;

    Image pacmanImage = new Image(new FileInputStream("C:\\Users\\sair7\\IdeaProjects\\PacMan2\\src\\main\\resources\\Images\\pacman.png"));

    public Pacman() throws FileNotFoundException {
        this.setImage(pacmanImage);
        this.setX(455);
        this.setY(905);
        this.setFitHeight(25);
        this.setFitWidth(25);
    }

    public void pressHandler(KeyEvent e) {
        switch (e.getCode()){
            case UP -> this.setY(this.getY()-5);
            case DOWN -> this.setY(this.getY()+5);
            case LEFT -> this.setX(this.getX()-5);
            case RIGHT -> this.setX(this.getX()+5);
        }
    }
    public void handleKeyPressed(KeyEvent event) {
        if (event.getCode().isArrowKey()) {
            event.consume();
            switch (event.getCode()) {
                case LEFT:
                    //Check Matrix for walls
                    if (matrix[pX - 1][pY] != 1){
                        //if no wall move LEFT
                        if (pActualX == pX * TILE_SIZE + 20 && pActualY == pY * TILE_SIZE + 20) {
                            System.out.println("Can move LEFT");
                            pX -= 1;
                            playerDirection = Directions.LEFT;
                        }
                        System.out.println(pX + pY);
                    }
                    break;
                case RIGHT:
                    if (matrix[pX + 1][pY] != 1){
                        //if no wall move RIGHT
                        if (pActualX == pX * TILE_SIZE + 20 && pActualY == pY * TILE_SIZE + 20) {
                            System.out.println("Can move RIGHT");
                            pX += 1;
                            playerDirection = Directions.RIGHT;
                        }
                        System.out.println(pX + pY);
                    }
                    break;
                case DOWN:
                    if (matrix[pX][pY + 1] != 1){
                        if (pActualX == pX * TILE_SIZE + 20 && pActualY == pY * TILE_SIZE + 20) {
                            System.out.println("Can move DOWN");
                            pY += 1;
                            playerDirection = Directions.DOWN;
                        }
                        System.out.println(pX + pY);
                    }
                    break;
                case UP:
                    if (matrix[pX][pY - 1] != 1){
                        if (pActualX == pX * TILE_SIZE + 20 && pActualY == pY * TILE_SIZE + 20) {
                            System.out.println("Can move UP");
                            pY -= 1;
                            playerDirection = Directions.UP;
                        }
                        System.out.println(pX + pY);
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

}
