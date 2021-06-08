/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.corsacavalli;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author juliet
 */
public class Campo extends JPanel {

    int corsie; //numero corsie da disegnare

    /**
     * costruttore
     *
     * @param corsie numero di corsie da diver disegnare
     */
    public Campo(int corsie) {
        this.corsie = corsie;
    }

    /**
     * metodo per rappresentare il campo dove i cavalli corrono
     *
     * @param g instanza per "disegnare" sul JPanel
     */
    public void paint(Graphics g) {
        g.setColor(new Color(103, 199, 115)); //campo generale
        g.fillRect(0, 0, 1000, corsie * 80); 
        g.setColor(Color.white);

        for (int i = 0; i < corsie; i++) { //divisione delle corsie
            g.fillRect(0, i * 80, 1000, 5);
        }

        for (int i = 0; i < 3; i++) { //arrivo delle corsie
            g.fillRect(960 + i * 10, 0, 5, corsie * 100);
        }
    }
}
