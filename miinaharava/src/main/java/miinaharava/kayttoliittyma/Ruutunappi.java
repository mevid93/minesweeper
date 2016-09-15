package miinaharava.kayttoliittyma;

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

}
