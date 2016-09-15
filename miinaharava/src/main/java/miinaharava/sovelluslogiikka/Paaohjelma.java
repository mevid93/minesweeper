package miinaharava.sovelluslogiikka;

import miinaharava.kayttoliittyma.Kayttoliittyma;

/**
 *
 * @author Martin Vidjeskog
 */
public class Paaohjelma {

    /**
     * Metodi, jolla ohjelma käynnistetään. Luodaan käyttöliittymä olio ja
     * kutsutaan sen run-metodia.
     *
     * @param args : Ei ohjelman kannalta mitään merktitystä.
     */
    public static void main(String[] args) {

        Kayttoliittyma ikkuna = new Kayttoliittyma();
        ikkuna.run();

    }

}
