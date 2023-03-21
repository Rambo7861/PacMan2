package com.example.pacman2.kart;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Vegg extends Rectangle {
    public static final double WIDTH = 36;
    public static final double HEIGHT = 36;

    /**
     * klasse vegg, representerer alle blokker på kartet
     * @param x posisjon for blokker
     * @param y posisjon for blokker
     * @param type setter vegg type ( 0 = vegg, 1 = åpen felt,)
     */
    public Vegg (double x, double y, int type ){
        super(x,y, WIDTH, HEIGHT);
        if (type == 0)
            setFill(Color.BLUE);
        else if ( type == 1)
            setFill(Color.BLACK);
    }
}