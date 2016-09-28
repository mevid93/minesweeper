package miinaharava.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import miinaharava.kayttoliittyma.Kayttoliittyma;

/**
 * Luokka tarjoaa metodin käyttöliittymässä sijaitsevalle "aloita-alusta"-napin
 * toiminnalle.
 *
 * @author Martin Vidjeskog
 */
public class AloitusnapinKuuntelija implements ActionListener {

    private Kayttoliittyma ikkuna;  // käyttöliittymä ikkuna olio

    /**
     * Konstruktori metodi, joka luo uuden AloitusnapinKuuntelijan ja tallentaa
     * muistiin parametrina annetun Kayttoliittyma-olion.
     *
     * @param ikkuna Kayttoliittyma-olio
     */
    public AloitusnapinKuuntelija(Kayttoliittyma ikkuna) {
        this.ikkuna = ikkuna;
    }

    /**
     * Metodi, joka toteutetaan kun tapahtuma rekisteröidään napissa, johon
     * kuuntelija on kytketty. Kutsutaan käyttöliittymä-olion metodia joka
     * asettaa pelin alkamaan alusta.
     *
     * @param e Napin painallus tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.ikkuna.aloitaAlusta();
    }

}
