package com.example.pacman2.kart;
import com.example.pacman2.Fil;

import javafx.scene.layout.Pane;

public class KartPane extends Pane {
     int [][] kart = Fil.hentKart("map1.csv");


    public KartPane(){
        for (int i = 0; i <kart.length; i++) {
            for (int j = 0; j <kart[i].length ; j++) {
               getChildren().add(new Vegg(j*Vegg.WIDTH, i*Vegg.HEIGHT, kart[i][j]));
            }
        }
    }
}