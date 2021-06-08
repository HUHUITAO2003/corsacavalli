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
 * @author informatica
 */
public class GaraCavalli extends JFrame{
    int posizione; //prima posizione da assegnare 
    int corsie; //numero di cavalli che corrono
    Cavallo[] cavalli; //Array delle immagini dei cavalli
    CavalloInCampo[] ThreadCavalli; //Array dei cavalli che "corrono"
    Campo pista; //campo dove i cavalli "corrono"
    Graphics offscreen; //per gestione del doppio buffering
    Image buffer_virtuale; //immagine del campo
    JLabel[] arrivi; //Array di JLabel per la classifica
    
    
    /**
     * costruttore per gestire il movimento dell'immagini dei cavallo e della classifica della gara
     *
     * @param corsie numero di corsie occupate
     */
    public GaraCavalli(int corsie){
        super("Cara Cavalli!");
        this.corsie=corsie;
        setSize(1000, 20+corsie*80);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pista = new Campo(corsie);
        cavalli = new Cavallo[corsie];
        ThreadCavalli = new CavalloInCampo[corsie];
        posizione = 1;
        for(int i=0;i<corsie;i++){
            cavalli[i]=new Cavallo(7+i*80, i+1);
            ThreadCavalli[i]= new CavalloInCampo(cavalli[i],this, i);
        }
        arrivi = new JLabel[corsie];
        this.add(pista);
        setVisible(true);
    }
    
    /**
     * metodo per aggiungere alla classifica un cavallo visualizzando posizione e corsia
     *
     * @param corsia corsia di appartenenza del cavallo
     */
    public synchronized int Classifica(int corsia){
        arrivi[posizione-1]= new JLabel(posizione + "° cavallo classificato nella "+(corsia+1)+"° corsia");
        if(posizione==corsie){ //richiamo della visualizzazione della classifica appena la posizione di un cavallo è uguale al numero di corsie create
            visualizzaClassifica();
        }
        return posizione++;
    }
    
    /**
     * metodo per visualizzazione della classifica
     *
     */
    public void visualizzaClassifica(){
        JFrame classifica = new JFrame("Classifica");
        classifica.setBounds(500, 200, 300, corsie*50);
        classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
        classifica.getContentPane().setLayout(new GridLayout(corsie,1));
 
        for(int j = 0; j<arrivi.length; j++){
            classifica.getContentPane().add(arrivi[j]);
        }
        classifica.setVisible(true);
    }

     /**
     * metodo per realizzare il campo dove i cavalli corrono
     *
     * @param g instanza per "disegnare" sul JPanel
     */
    public void paint(Graphics g){
        Graphics2D screen = (Graphics2D)g;
        buffer_virtuale = createImage(1000, corsie*80);
        offscreen = buffer_virtuale.getGraphics();
        Dimension d = getSize();
        pista.paint(offscreen);
        for(int i=0;i<corsie;i++){
            cavalli[i].paint(offscreen);
        }
        screen.drawImage(buffer_virtuale, 0, 20, this);
        offscreen.dispose();
    }

}   