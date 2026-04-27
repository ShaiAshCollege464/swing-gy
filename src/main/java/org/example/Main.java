package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final int WINDOW_WIDTH = 900;
    public static final int WINDOW_HEIGHT = 600;
    public static void main(String[] args) {
        try {
            InputStream inputStream = Prize.class.getResourceAsStream("/apple.jpg");
            BufferedImage image = ImageIO.read(inputStream);
            System.out.println("Width: " + image.getWidth());
            System.out.println("Height: " + image.getHeight());
            for (int i = 0; i < image.getWidth(); i++) {
                for (int j = 0; j < image.getHeight(); j++) {
                    Color current = new Color(image.getRGB(i, j));
                    int red = current.getRed();
                    int green = current.getGreen();
                    int blue = current.getBlue();
                    Color newColor = new Color(255 - red, 255- green, 255 -blue);
                    image.setRGB(i, j, newColor.getRGB());
                }
            }
            File file = new File("C:\\Users\\shaig\\IdeaProjects\\personal\\untitled\\src\\main\\updated.png");
            boolean result = ImageIO.write(image, "png", file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}