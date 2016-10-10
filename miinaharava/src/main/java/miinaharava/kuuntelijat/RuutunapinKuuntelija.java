package miinaharava.kuuntelijat;

import java.awt.Color;
import miinaharava.domain.Ruutunappi;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import miinaharava.domain.Pelikentta;
import miinaharava.domain.Ruudukko;

/**
 * Luokka, joka sisältää metodit ruutunappien painamisesta syntyvään toimintaan.
 *
 * @author Martin Vidjeskog
 */
public class RuutunapinKuuntelija implements MouseListener {

    private Ruutunappi ruutunappi;
    private Pelikentta kentta;
    private Ruudukko ruudukko;

    /**
     * Konstruktori, joka luo uuden Ruutunapinkuuntelijan ja saa kaksi
     * parametria, jotka ovat ruutunappi, johon kuuntelija liitetään, sekä
     * Ruudukko olion, jossa on kaikkien ruutujen tiedot.
     *
     * @param nappi Ruutunappi, jolle kuuntelija on asetettu
     * @param kentta Lista kaikista Ruutunappi-olioista
     * @param ruudukko Ruudukko, joka sisältää tiedot kaikista Ruuduista
     */
    public RuutunapinKuuntelija(Ruutunappi nappi, Pelikentta kentta, Ruudukko ruudukko) {
        this.kentta = kentta;
        this.ruudukko = ruudukko;
        this.ruutunappi = nappi;
    }

    /**
     * Metodi, joka tarkistaa, kumpaa hiiren nappia on painettu ja ohjaa sitten
     * mitä jatkotoimenpiteitä tehdään.
     *
     * @param e Hiiren painamis-tapahtuma napin päällä
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.ruutunappi) {
            int x = this.ruutunappi.getxKoordinaatti();
            int y = this.ruutunappi.getyKoordinaatti();
            if (SwingUtilities.isLeftMouseButton(e) && !this.ruudukko.onkoLiputettu(x, y) && !this.ruudukko.onkoAvattu(x, y)) {
                this.vasenHiirenNappiPainettu(x, y);
            } else if (SwingUtilities.isRightMouseButton(e) && !this.ruudukko.onkoAvattu(x, y)) {
                this.oikeaHiirenNappiPainettu(x, y);
            }
        }
    }

    /**
     * Metodi, joka suorittaa tarvittavat metodit, jos kuuntelija on
     * rekisteröinyt tapahtuman, jossa on painettu hiiren oikeaa nappia. Metodi
     * saa parametrina painetun ruudun koordinaatit.
     *
     * @param x Ruudun x-koordinaatti
     * @param y Ruudun y-koordinaatti
     */
    private void oikeaHiirenNappiPainettu(int x, int y) {
        this.ruudukko.liputuksenTilanVaihto(x, y);
        this.ruutunappi.naytaLippu(this.ruudukko.onkoLiputettu(x, y));
        this.tarkastaVoittikoPelaaja();
    }

    /**
     * Metodi, joka suorittaa tarvittavat metodit, jos kuuntelija on
     * rekisteröinyt tapahtuman, jossa on painettu hiiren vasenta nappia. Metodi
     * saa parametrina painetun ruudun koordinaatit.
     *
     * @param x Ruudun x-koordinaatti
     * @param y Ruudun y-koordinaatti
     */
    private void vasenHiirenNappiPainettu(int x, int y) {
        if (this.ruudukko.onkoMiina(x, y)) {
            this.ruudukko.avaaRuutu(x, y);
            this.pelaajaHavisi();
        } else {
            this.avaaRuutuJossaEiMiinaa(x, y);  // rekursiivinen metodi
            this.tarkastaVoittikoPelaaja();
        }
    }

    /**
     * Metodi, joka merkitsee kaikki ruudut avatuiksi, jolloin niiden painaminen
     * ei muuta enää niiden tilaa.
     */
    private void merkitseAvatuiksi() {
        for (int i = 0; i < this.ruudukko.getKorkeus(); i++) {
            for (int j = 0; j < this.ruudukko.getLeveys(); j++) {
                if (this.ruudukko.onkoLiputettu(j, i)) {
                    this.ruudukko.liputuksenTilanVaihto(j, i);
                }
                this.ruudukko.avaaRuutu(j, i);
            }
        }
    }

    /**
     * Metodi, joka suoritetaan kun pelaaja häviää. Kutsuu tilanteeseen
     * liittyvät metodit.
     */
    private void pelaajaHavisi() {
        this.ruutunappi.naytaMiina();
        this.ruutunappi.setBackground(Color.red);
        this.kentta.paljastaKaikkiMiinat();
        this.merkitseAvatuiksi();
        JOptionPane.showMessageDialog(null, "Hävisit");
    }

    /**
     * Rekursiivinen metodi, joka avaa ruudun siten, että jos ruudulla ei ole
     * naapurimiinoja, paljastetaan yhdellä kertaa suurempi alue ohjelman
     * aihemäärittelyn osoittamalla tavalla. Saa parametrina tarkasteltavan
     * ruudun koordinaatit.
     *
     * @param x Ruudun x-koordinaatti
     * @param y Ruudun y-koordinaatti
     */
    private void avaaRuutuJossaEiMiinaa(int x, int y) {
        if (!this.ruudukko.onkoLiputettu(x, y)) {
            this.ruudukko.avaaRuutu(x, y);
            int naapurimiinat = this.ruudukko.naapurimiinojenMaara(x, y);
            this.kentta.asetaRuutunapinNaapurimiinatEsille(x, y, naapurimiinat);
            if (naapurimiinat == 0) {
                if (x + 1 < this.ruudukko.getLeveys() && !this.ruudukko.onkoAvattu(x + 1, y)) {
                    avaaRuutuJossaEiMiinaa(x + 1, y);
                }
                if (x + 1 < this.ruudukko.getLeveys() && y + 1 < this.ruudukko.getKorkeus() && !this.ruudukko.onkoAvattu(x + 1, y + 1)) {
                    avaaRuutuJossaEiMiinaa(x + 1, y + 1);
                }
                if (y + 1 < this.ruudukko.getKorkeus() && !this.ruudukko.onkoAvattu(x, y + 1)) {
                    avaaRuutuJossaEiMiinaa(x, y + 1);
                }
                if (x - 1 >= 0 && y + 1 < this.ruudukko.getKorkeus() && !this.ruudukko.onkoAvattu(x - 1, y + 1)) {
                    avaaRuutuJossaEiMiinaa(x - 1, y + 1);
                }
                if (x - 1 >= 0 && !this.ruudukko.onkoAvattu(x - 1, y)) {
                    avaaRuutuJossaEiMiinaa(x - 1, y);
                }
                if (x - 1 >= 0 && y - 1 >= 0 && !this.ruudukko.onkoAvattu(x - 1, y - 1)) {
                    avaaRuutuJossaEiMiinaa(x - 1, y - 1);
                }
                if (y - 1 >= 0 && !this.ruudukko.onkoAvattu(x, y - 1)) {
                    avaaRuutuJossaEiMiinaa(x, y - 1);
                }
                if (x + 1 < this.ruudukko.getLeveys() && y - 1 >= 0 && !this.ruudukko.onkoAvattu(x + 1, y - 1)) {
                    avaaRuutuJossaEiMiinaa(x + 1, y - 1);
                }
            }
        }
    }

    /**
     * Metodi, joka suoritetaan jokaisen klikkauksen yhteydessä. Metodi
     * tarkastaa onko pelaaja voittanut.
     */
    private void tarkastaVoittikoPelaaja() {
        for (int i = 0; i < this.ruudukko.getKorkeus(); i++) {
            for (int j = 0; j < this.ruudukko.getLeveys(); j++) {
                if (!this.ruudukko.onkoMiina(j, i) && !this.ruudukko.onkoAvattu(j, i)) {
                    return;
                } else if (this.ruudukko.onkoMiina(j, i) && !this.ruudukko.onkoLiputettu(j, i)) {
                    return;
                }
            }
        }
        this.merkitseAvatuiksi();
        JOptionPane.showMessageDialog(null, "Voitit");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Ei tarvita
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //Ei tarvita
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //Ei tarvita
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //Ei tarvita
    }

}
