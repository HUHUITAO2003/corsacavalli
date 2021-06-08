/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.corsacavalli;

/**
 *
 * @author juliet
 */
import java.awt.*;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author juliet
 */
public class Inserimento extends JFrame {

    Container c = new Container(); //Container che conterrà tutta l'interfaccia.
    public JPanel panel = new JPanel(); //pannello che conterra i componeneti grafici

    public JLabel l = new JLabel("Quanti cavalli devono gareggiare? "); //sezione output di una stringa
    public JTextField t = new JTextField(); //sezione di input per scegliere quanti cavalli devogo correre
    public JButton conferma = new JButton("Conferma"); //bottono per avviare la corsa

    
    /**
     * costruttore per l'inserimento di quanti cavalli far correre
     *
     */
    public Inserimento() {

        c = this.getContentPane();
        panel.setLayout(null);
        this.setTitle("Ippodromo");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(getX()-160, getY()-80, 320, 160);

        l.setBounds(55, 20, 300, 20);
        t.setBounds(90, 60, 140, 20);
        conferma.setBounds(90, 100, 140, 20);

        panel.add(l);
        panel.add(t);
        panel.add(conferma);
        c.add(panel);
        conferma.addMouseListener(new EventoMouse()); //aggiunta di un mouse listener che esegua una certa azione una volta verificatasi un evento con il mouse
    }

    private class EventoMouse implements MouseListener {

        /**
        * metodo per scegliere il numero di cavalli da far correre e controllo che il contenuto sia corretto
        *
        * @param e evento del mouse verificatosi
        */
        @Override
        public void mouseClicked(MouseEvent e) { //inserimento delle corsie e controlli del contenuto
                    int n;
                    try { n = Integer.valueOf(t.getText());
                        if (n < 2 || n > 10) {
                            if (n < 2) { JOptionPane.showMessageDialog(null,"numero di cavalli troppo piccolo, scegli un numero tra 2 e 10"); }
                            if (n > 10) { JOptionPane.showMessageDialog(null, "numero di cavalli troppo grande, scegli un numero tra 2 e 10"); }
                        } else { GaraCavalli m = new GaraCavalli(n);
                        
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "inserisci un numero di cavalli intero tra 2 e 10");
                    }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
    
    public static void main(String[] a) {
        Inserimento i = new Inserimento();
    }
}
