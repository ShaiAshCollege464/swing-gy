package org.example;

import java.awt.*;
import java.util.Random;

import static org.example.Main.WINDOW_HEIGHT;
import static org.example.Main.WINDOW_WIDTH;

public class Robot {
    private int x;
    private int y;
    private int size;
    private int direction;

    public Robot (int x, int y) {
        this.x = x;
        this.y = y;
        this.size = 10;
        this.direction = 0;
    }

    public void paint (Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(
                this.x,
                this.y,
                this.size,
                this.size
        );
    }

    public void moveRight () {
        this.x++;
    }

    public void moveLeft () {
        this.x--;
    }


    public void moveUp () {
        this.y--;
    }


    public void moveDown () {
        this.y++;
    }


    public void setDirection (int direction) {
        this.direction = direction;
    }
}
