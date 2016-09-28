package miinaharava.domain;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * Luokka, joka kuvaa yksittäistä pelikenttään kuuluvaa ruutua (JButton).
 * Sisältää toiminnot napin ulkomuodon muuttamiseen ja metodit koordinaattien
 * saamiseen.
 *
 * @author Martin Vidjeskog
 */
public class Ruutunappi extends JButton {

    private final int xKoordinaatti;
    private final int yKoordinaatti;

    /**
     * Kostruktori-metodi joka luo uuden Ruutunappi-olion ja asettelee
     * parametrit oliomuuttujiin.
     *
     * @param x Ruudun x-koordinaatti pelikentässä
     * @param y Ruudun y-koordinaatti pelikentässä
     */
    public Ruutunappi(int x, int y) {
        this.xKoordinaatti = x;
        this.yKoordinaatti = y;
    }

    /**
     * Metodi, joka palauttaa Ruutunapin sijainnin pelikentässä ja ruudukossa.
     *
     * @return x-koordinaatti pelikentässä
     */
    public int getxKoordinaatti() {
        return xKoordinaatti;
    }

    /**
     * Metodi, joka palauttaa Ruutunapin sijainnin pelikentässä ja ruudukossa.
     *
     * @return y-koordinaatti pelikentässä
     */
    public int getyKoordinaatti() {
        return yKoordinaatti;
    }

    /**
     * Metodi, joka muuttaa ruutunapin ulkonäköä vastaamaan ruutua joka pitää
     * sisällään miinan.
     */
    public void naytaMiina() {
        this.muutaPainetuksi();
        this.setText("X");
    }

    /**
     * Metodi, joka muuttaa ruutunapin ulkonäköä vastaamaan avattua ruutua jossa
     * ei ole miinaa.
     *
     * @param naapurimiinat Naapurimiinojen lukumäärä
     */
    public void naytanaapurimiinojenMaara(int naapurimiinat) {
        this.muutaPainetuksi();
        if (naapurimiinat != 0) {
            this.setText("" + naapurimiinat);
        }
    }

    /**
     * Metodi, joka muuttaa ruutunapin ulkonäköä vastaamaan ruutua, jossa
     * joko on lippu tai ei ole lippua, riippuen parametrin arvosta.
     * 
     * @param esilla Merkitäänkö lippu esille 
     */
    public void naytaLippu(boolean esilla) {
        if (esilla) {
            this.setText("L");
        } else {
            this.setText("");
        }
    }

    /**
     * Meotodi, jolla napin tausta muutetaan vastaamaan avatun 
     * ruudun ulkonäköä.
     */
    private void muutaPainetuksi() {
        this.setBorder(BorderFactory.createLoweredBevelBorder());
        this.setBackground(Color.white);
        this.setEnabled(false);
    }
}
