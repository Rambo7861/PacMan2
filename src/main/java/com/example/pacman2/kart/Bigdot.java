package com.example.pacman2.kart;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Bigdot extends ImageView {
    int posX = 15;
    int posY = 15;

    Image whitedotImage = new Image(new FileInputStream("C:\\Users\\sair7\\IdeaProjects\\PacMan2\\src\\main\\resources\\Images\\whitedot.png"));

    public Bigdot() throws FileNotFoundException {
        this.setImage(whitedotImage);
        this.setX(44);
        this.setY(115);
        this.setFitHeight(22);
        this.setFitWidth(22);
    }
}
