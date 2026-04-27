package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class Prize {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;
    private boolean taken;

    public Prize(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.taken = false;
        try {
            InputStream inputStream = Prize.class.getResourceAsStream("/apple.jpg");
            this.image = ImageIO.read(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void paint (Graphics graphics) {
        if (!this.taken) {
            if (this.image != null) {
                graphics.drawImage(this.image, this.x, this.y, this.width, this.height, null);
            } else {
                graphics.setColor(Color.BLUE);
                graphics.fillRect(this.x, this.y, this.width, this.height);
            }
        }
    }

    public void take () {
        if (!this.taken) {
            this.taken = true;
            new Thread(() -> {
                try {
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {

                }
                this.taken = false;
            }).start();

        }
    }

    public Rectangle getRect () {
        Rectangle rectangle = new Rectangle(this.x, this.y, this.width, this.height);
        return rectangle;
    }

}
