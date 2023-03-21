package com.example.pacman2.player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Pacman extends ImageView {
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
}
