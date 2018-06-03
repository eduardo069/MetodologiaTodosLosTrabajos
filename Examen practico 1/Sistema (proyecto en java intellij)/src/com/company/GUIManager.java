package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class GUIManager
{
    static JLabel LabelTitulo = new JLabel("Sistema de elevador");
    static JLabel LabelPantalla = new JLabel("1");
    static RoundButton BotonUno = new RoundButton("1");
    static RoundButton BotonDos = new RoundButton("2");
    static RoundButton BotonTres = new RoundButton("3");
    static RoundButton BotonCuatro = new RoundButton("4");
    static RoundButton BotonCinco = new RoundButton("5");
    static RoundButton BotonSeis = new RoundButton("6");
    static RoundButton BotonEmergencia = new RoundButton("E");
    static RoundButton BotonAbrir = new RoundButton("Abrir");
    static RoundButton BotonCerrar = new RoundButton("Cerrar");
    static int SiguientePiso = 1;
    static int PisoActual = 1;
    static int PisoParo = 1;
    public static void init()
    {
        BotonUno.setBounds(135,225,65,65);
        BotonDos.setBounds(205,225, 65, 65);
        BotonTres.setBounds(135,295,65,65);
        BotonCuatro.setBounds(205,295,65,65);
        BotonCinco.setBounds(135,365,65,65);
        BotonSeis.setBounds(205,365,65,65);
        BotonAbrir.setBounds(20,450,100,100);
        BotonCerrar.setBounds(270,450,100,100);
        BotonEmergencia.setBounds(170,500,50,50);
        LabelTitulo.setBounds(135, 20, 200, 20);
        LabelPantalla.setBounds(105, 90, 200, 100);

        BotonUno.setBackground(Color.GRAY);
        BotonDos.setBackground(Color.GRAY);
        BotonTres.setBackground(Color.GRAY);
        BotonCuatro.setBackground(Color.GRAY);
        BotonCinco.setBackground(Color.GRAY);
        BotonSeis.setBackground(Color.GRAY);
        BotonAbrir.setBackground(Color.GRAY);
        BotonCerrar.setBackground(Color.GRAY);
        BotonEmergencia.setBackground(Color.RED);

        BotonUno.setBorderPainted(false);
        BotonDos.setBorderPainted(false);
        BotonTres.setBorderPainted(false);
        BotonCuatro.setBorderPainted(false);
        BotonCinco.setBorderPainted(false);
        BotonSeis.setBorderPainted(false);
        BotonAbrir.setBorderPainted(false);
        BotonCerrar.setBorderPainted(false);
        BotonEmergencia.setBorderPainted(false);

        BotonUno.setFocusPainted(false);
        BotonDos.setFocusPainted(false);
        BotonTres.setFocusPainted(false);
        BotonCuatro.setFocusPainted(false);
        BotonCinco.setFocusPainted(false);
        BotonSeis.setFocusPainted(false);
        BotonAbrir.setFocusPainted(false);
        BotonCerrar.setFocusPainted(false);
        BotonEmergencia.setFocusPainted(false);

        LabelPantalla.setSize(200,100);
        LabelPantalla.setText("1");
        LabelPantalla.setFont(new Font("Serif", Font.BOLD, 20));
        LabelPantalla.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        LabelPantalla.setHorizontalAlignment(JLabel.CENTER);
        LabelPantalla.setVerticalAlignment(JLabel.CENTER);
        BotonUno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SiguientePiso = 1;
            }
        });
        BotonDos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SiguientePiso = 2;
            }
        });
        BotonTres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SiguientePiso = 3;
            }
        });
        BotonCuatro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SiguientePiso = 4;
            }
        });
        BotonCinco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SiguientePiso = 5;
            }
        });
        BotonSeis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SiguientePiso = 6;
            }
        });
        BotonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(PisoActual == SiguientePiso)
                    SiguientePiso = -1;
            }
        });
        BotonAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SiguientePiso == -1)
                    SiguientePiso = PisoActual;
            }
        });
        BotonEmergencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SiguientePiso == -2)
                    SiguientePiso = PisoParo;
                if(PisoActual != SiguientePiso && SiguientePiso > 0)
                {
                    PisoParo = SiguientePiso;
                    SiguientePiso = -2;
                }
            }
        });
        Main.MainWindowFrame.add(LabelTitulo);
        Main.MainWindowFrame.add(LabelPantalla);
        Main.MainWindowFrame.add(BotonUno);
        Main.MainWindowFrame.add(BotonDos);
        Main.MainWindowFrame.add(BotonTres);
        Main.MainWindowFrame.add(BotonCuatro);
        Main.MainWindowFrame.add(BotonCinco);
        Main.MainWindowFrame.add(BotonSeis);
        Main.MainWindowFrame.add(BotonAbrir);
        Main.MainWindowFrame.add(BotonCerrar);
        Main.MainWindowFrame.add(BotonEmergencia);
    }

    public static void update() throws Exception
    {
        while(SiguientePiso > 0 && SiguientePiso > PisoActual)
        {
            LabelPantalla.setText(String.valueOf(++PisoActual));
            Thread.sleep(1000);
        }
        while(SiguientePiso > 0 && SiguientePiso < PisoActual)
        {
            LabelPantalla.setText(String.valueOf(--PisoActual));
            Thread.sleep(1000);
        }
        while(SiguientePiso == -1)
        {
            LabelPantalla.setText("Cerrado");
        }
        while(SiguientePiso == -2)
        {
            LabelPantalla.setText("Paro de Emergencia!");
        }
        while(SiguientePiso == PisoActual)
        {
            Thread.sleep(1000);
            LabelPantalla.setText("Abierto");
        }
    }

    public static void finish()
    {

    }
}
