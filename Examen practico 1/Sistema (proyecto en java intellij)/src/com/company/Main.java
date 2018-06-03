package com.company;

import javax.swing.*;

public class Main {
    public static JFrame MainWindowFrame = new JFrame();
    public static boolean run = true;
    public static void main(String[] args) throws Exception
    {
        MainWindowFrame.setVisible(true);
        MainWindowFrame.setLayout(null);
        MainWindowFrame.setSize(400, 600);
        GUIManager.init();
        while(run)
            GUIManager.update();

        GUIManager.finish();
    }
}