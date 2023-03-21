package com.example.pacman2.player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ghost3 extends ImageView {
    int posX = 15;
    int posY = 15;

    Image ghostImage3 = new Image(new FileInputStream("C:\\Users\\sair7\\IdeaProjects\\PacMan2\\src\\main\\resources\\Images\\blue.png"));


    public Ghost3() throws FileNotFoundException {
        this.setImage(ghostImage3);
        this.setX(400);
        this.setY(500);
        this.setFitHeight(20);
        this.setFitWidth(20);

    }
}
