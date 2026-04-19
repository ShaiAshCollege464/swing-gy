package org.example;

import javax.swing.*;
import java.awt.*;

public class MainScenePanel extends JPanel {
    private Robot robot;

    public MainScenePanel (int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.robot = new Robot(200, 200);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new MovementListener(this.robot));
        this.gameLoop();
    }

    private void gameLoop () {
        new Thread(() -> {
            while (true) {
                repaint();
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {}
            }
        }).start();
    }

    public void paintComponent (Graphics graphics) {
        super.paintComponent(graphics);
        this.robot.paint(graphics);
    }
}
