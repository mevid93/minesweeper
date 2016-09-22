package miinaharava.kayttoliittyma;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author Martin Vidjeskog
 */
public class Ruutunappi extends JButton {

    private int xKoordinaatti;  // Napin sijainti pelikentässä ja ruudun sijainti ruudukossa
    private int yKoordinaatti;  // Napin sijainti pelikentässä ja ruudun sijainti ruudukossa

    /**
     * Kostruktori-metodi joka luo uuden Ruutunappi olion.
     *
     * @param x : Ruudun x-koordinaatti pelikentässä.
     * @param y : Ruudun y-koordinaatti pelikentässä.
     */
    public Ruutunappi(int x, int y) {
        if (x < 0) {
            x = 0;
        }
        this.xKoordinaatti = x;
        if (y < 0) {
            y = 0;
        }
        this.yKoordinaatti = y;
    }

    /**
     * Metodi, joka palauttaa Ruutunapin sijainnin pelikentässä ja ruudukossa.
     *
     * @return
     */
    public int getxKoordinaatti() {
        return xKoordinaatti;
    }

    /**
     * Metodi, joka palauttaa Ruutunapin sijainnin pelikentässä ja ruudukossa.
     *
     * @return
     */
    public int getyKoordinaatti() {
        return yKoordinaatti;
    }

    /**
     * Metodi, joka muuttaa ruutunapin ulkonäköä vastaamaan ruutua joka pitää
     * sisällään miinan.
     *
     */
    public void naytaMiina() {
        this.muutaPainetuksi();
        this.setText("X");
    }

    /**
     * Metodi, joka muuttaa ruutunapin ulkonäköä vastaamaan avattua ruutua jossa
     * ei ole miinaa.
     *
     * @param naapurimiinat
     */
    public void naytanaapurimiinojenMaara(int naapurimiinat) {
        this.muutaPainetuksi();
        if (naapurimiinat != 0) {
            this.setText("" + naapurimiinat);
        }
    }

    public void naytaLippu(boolean esilla) {
        if (esilla) {
            this.setText("L");
        } else {
            this.setText("");
        }
    }

    /**
     * Meotodi, jolla napin tausta muutetaan erilaiseksi kun ruutu on avattu
     */
    private void muutaPainetuksi() {
        this.setBorder(BorderFactory.createLoweredBevelBorder());
        this.setBackground(Color.white);
        this.setEnabled(false);
    }
}
