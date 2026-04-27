package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainScenePanel extends JPanel {
    private Robot robot;
    private Prize[] prizes;

    public MainScenePanel (int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.robot = new Robot(200, 200);
        this.prizes = new Prize[3];
        Random random = new Random();
        for (int i = 0; i < this.prizes.length; i++) {
            this.prizes[i] = new Prize(random.nextInt(width), random.nextInt(height), 50, 50);
        }
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new MovementListener(this.robot));
        this.gameLoop();
    }

    private boolean checkCollision () {
        boolean collision = false;
        Rectangle characterRect = this.robot.getRect();
        for (int i = 0; i < this.prizes.length; i++) {
            Prize current = this.prizes[i];
            Rectangle prizeRect = current.getRect();
            if (characterRect.intersects(prizeRect)) {
                current.take();
            }
        }
        return collision;
    }


    private void gameLoop () {
        new Thread(() -> {
            while (true) {
                if (this.checkCollision()) {
                }
                repaint();
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {}
            }
        }).start();
    }

    public void paintComponent (Graphics graphics) {
        super.paintComponent(graphics);
        for (int i = 0; i < this.prizes.length; i++) {
            this.prizes[i].paint(graphics);
        }
        this.robot.paint(graphics);
    }
}
