package org.example;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final int WINDOW_WIDTH = 900;
    public static final int WINDOW_HEIGHT = 600;
    public static void main(String[] args) {
        JFrame window = new JFrame("My Game");
        window.setLayout(null);
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setResizable(false);
        window.add(new MainScenePanel(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT));
        window.setVisible(true);
    }
}