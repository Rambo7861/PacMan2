package com.example.pacman2.player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ghost extends ImageView {
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
}

