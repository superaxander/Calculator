package net.alexanders.calculator;


import javax.swing.*;
import java.awt.*;

public class Main {
    public static CalcPanel mainWindow;
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainWindow = new CalcPanel();
        mainWindow.setPreferredSize(new Dimension(screenSize.width/4, screenSize.height/5));
        buildGui();
    }

    public static void buildGui()
    {
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setLocationRelativeTo(null);
    }
}
