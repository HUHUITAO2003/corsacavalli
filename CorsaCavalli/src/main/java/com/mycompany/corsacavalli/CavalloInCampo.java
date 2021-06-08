/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.corsacavalli;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author informatica
 */
public class CavalloInCampo implements Runnable {

    Cavallo cavallo; //immagine del cavallo
    GaraCavalli campo;  //classe che gestisce il movimento dell'immagine e della classifica
    int velocita; //numero di pixel di ogni spostamento
    Thread t; //rappresenta il cavallo che si muove
    int conta;  //conteggio di spostamenti
    int posizione; //posizione nella classifica
    int corsia; //a quale corsia appartiene il cavallo

    
    /**
     * costruttore per gestire il movimento del cavallo
     *
     * @param cavallo immagine del cavallo
     * @param garacavalli gestione dell'immagine del cavallo e classifica
     * @param corsia in quale corsia il cavallo appartiene
     */
    public CavalloInCampo(Cavallo cavallo, GaraCavalli garacavalli, int corsia) {
        this.cavallo = cavallo;
        this.campo = garacavalli;
        this.corsia = corsia;
        conta = 0; //numero spostamenti
        velocita = 0;
        t = new Thread(this);
        t.start(); //inizio della corsa del cavallo
        posizione = 0;
    }
    
    /**
     * metodo per muovere il cavallo
     *
     */
    @Override
    public void run() {//animazione del cavallo
        int dimImmagine = 70; //lunghezza dell'immagine del cavallo
        int dimPista = 960; //lunghezza del cavallo
        
        while ((cavallo.getCordx() + dimImmagine) < dimPista) { //il cavallo corra finche non sia arrivato alla fine della pista
            if ((conta % 5) == 0) { //ogni 5 spostamenti un cambiamento di velocita
                velocita = (int) (Math.random() * 100);
            }
            int luogo = cavallo.getCordx() + velocita;

            if (luogo + dimImmagine > dimPista) { //i cavalli si fermino sulla stessa fine
                luogo = dimPista - dimImmagine;
            }
            cavallo.setCordx(luogo); 
            conta++;

            try {
                sleep(75); //intervallo di ogni movimento
            } catch (InterruptedException ex) {
                Logger.getLogger(CavalloInCampo.class.getName()).log(Level.SEVERE, null, ex);
            }

            campo.repaint(); //aggiornamento della posizione dell'immagine
        }

        posizione = campo.Classifica(corsia); //finita la corsa entra nella classifica
    }

}
