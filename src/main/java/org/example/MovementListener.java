package org.example;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementListener implements KeyListener {
    private Robot robot;
    private boolean[] pressedKeys;

    public MovementListener(Robot robot) {
        this.robot = robot;
        this.pressedKeys = new boolean[5];
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.pressedKeys[1] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.pressedKeys[2] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.pressedKeys[3] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.pressedKeys[4] = true;
        }
        if (this.pressedKeys[1]) {
            this.robot.moveRight();
        }
        if (this.pressedKeys[2]) {
            this.robot.moveLeft();
        }
        if (this.pressedKeys[3]) {
            this.robot.moveUp();
        }
        if (this.pressedKeys[4]) {
            this.robot.moveDown();
        }


    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.pressedKeys[1] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.pressedKeys[2] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.pressedKeys[3] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.pressedKeys[4] = false;
        }
    }
}
