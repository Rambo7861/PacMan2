package com.example.pacman2.player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ghost4 extends ImageView {
    int posX = 15;
    int posY = 15;

    Image ghostImage4 = new Image(new FileInputStream("C:\\Users\\sair7\\IdeaProjects\\PacMan2\\src\\main\\resources\\Images\\orange.png"));

    public Ghost4() throws FileNotFoundException {
        this.setImage(ghostImage4);
        this.setX(530);
        this.setY(500);
        this.setFitHeight(25);
        this.setFitWidth(25);
    }
}