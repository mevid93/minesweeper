package miinaharava;

import miinaharava.kayttoliittyma.Kayttoliittyma;

/**
 * Luokka, joka sisältää ohjelman käynnistämiseen tarvittavan metodin.
 *
 * @author Martin Vidjeskog
 */
public class Paaohjelma {

    /**
     * Metodi, jolla ohjelma käynnistetään. Luodaan käyttöliittymä olio ja
     * kutsutaan sen run-metodia.
     *
     * @param args Konsolin kautta syötetyt parametrit
     */
    public static void main(String[] args) {

        Kayttoliittyma ikkuna = new Kayttoliittyma();
        ikkuna.run();

    }

}