package com.example.pacman2;

public class Food {
    int x;
    int y;
    int type;
    boolean active;

    public Food(int x, int y, int type){
        this.x = x;
        this.y = y;
        this.type = type;
        this.active = true;
    }
}