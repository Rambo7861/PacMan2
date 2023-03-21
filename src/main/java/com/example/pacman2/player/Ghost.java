package com.example.pacman2.player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ghost extends ImageView {

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

    public void moveGhost(){
        if (ghostDirection == Directions.LEFT && ghostActualX != (ghostX * TILE_SIZE) + 20){
            ghostActualX -= enemyVelo;
        }else if (ghostDirection == Directions.RIGHT && ghostActualX != (ghostX * TILE_SIZE) + 20){
            ghostActualX += enemyVelo;
        }else if (ghostDirection == Directions.UP && ghostActualY != (ghostY * TILE_SIZE) + 20){
            ghostActualY -= enemyVelo;
        }else if (ghostDirection == Directions.DOWN && ghostActualY != (ghostY * TILE_SIZE) + 20){
            ghostActualY += enemyVelo;
        }else {
            moveGhost();
        }
    }
}

