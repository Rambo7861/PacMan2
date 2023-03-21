package com.example.pacman2.kart;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Bigdot3 extends ImageView {
    int posX = 15;
    int posY = 15;

    Image whitedotImage3 = new Image(new FileInputStream("C:\\Users\\sair7\\IdeaProjects\\PacMan\\src\\main\\resources\\Images\\whitedot.png"));

    public Bigdot3() throws FileNotFoundException {
        this.setImage(whitedotImage3);
        this.setX(906);
        this.setY(115);
        this.setFitHeight(22);
        this.setFitWidth(22);
    }
}
