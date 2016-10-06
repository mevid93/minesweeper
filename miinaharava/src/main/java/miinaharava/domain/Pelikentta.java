package miinaharava.domain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JPanel;
import miinaharava.kuuntelijat.RuutunapinKuuntelija;

/**
 * Luokka, joka kuvaa miinaharavan pelikenttää. Luokka tietää pelikentän koon ja
 * sisältää taulukon kaikista ruuduista (napeista), jotka pelikenttään kuuluvat.
 *
 * @author Martin Vidjeskog
 */
public class Pelikentta extends JPanel {

    private Ruudukko ruudukko;
    private ArrayList<Ruutunappi> nappilista;

    /**
     * Konstruktori, joka luo uuden Pelikentta-olion ja saa parametrina
     * Ruudukko-olion.
     *
     * @param ruudukko Ruudukko olio
     */
    public Pelikentta(Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
        this.nappilista = new ArrayList<>();
        this.asetteleRuutunapit();
    }

    /**
     * Metodi, joka kutsuu toista metodia ruutunappien luomiseksi ja asettelee
     * saamansa ruudut jPaneeliin.
     */
    private void asetteleRuutunapit() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.GRAY);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        for (int i = 0; i < this.ruudukko.getKorkeus(); i++) {
            c.gridy = i;
            for (int j = 0; j < this.ruudukko.getLeveys(); j++) {
                c.gridx = j;
                Ruutunappi ruutunappi = luoRuutunappi(j, i);
                this.add(ruutunappi, c);
            }
        }
    }

    /**
     * Metodi, joka luo yksittäisen Ruutunappi-olion ja antaa sille
     * parameteinaan saadut koordinaatit.
     *
     * @param x Koordinaatti pelikentässä
     * @param y Koordinaatti pelikentässä
     *
     * @return luotu Ruutunappi-olio
     */
    private Ruutunappi luoRuutunappi(int x, int y) {
        Ruutunappi ruutunappi = new Ruutunappi(x, y);
        ruutunappi.setPreferredSize(new Dimension(40, 40));
        ruutunappi.addMouseListener(new RuutunapinKuuntelija(ruutunappi, this, this.ruudukko));
        ruutunappi.setMargin(new Insets(0, 0, 0, 0));
        nappilista.add(ruutunappi);
        return ruutunappi;
    }

    /**
     * Metodi, jolla ykittäisen Pelikentässä sijaitsevan Ruutunapin miinat
     * iconin sellaiseksi, että se vastaa naapurimiinojen määrää.
     *
     * @param x Napin x-koordinaatti
     * @param y Napin y-koordinaatti
     * @param miinat Ruudun naapurimiinojen lkm
     */
    public void asetaRuutunapinNaapurimiinatEsille(int x, int y, int miinat) {
        for (Ruutunappi nappi : this.nappilista) {
            if (nappi.getxKoordinaatti() == x && nappi.getyKoordinaatti() == y) {
                nappi.naytanaapurimiinojenMaara(miinat);
                break;
            }
        }
    }

    /**
     * Metodi, joka asettaa kaikkien Pelikentän Ruutunappien iconiksi miinan,
     * mikäli vastaava Ruutu sisältää miinan ja Ruutua ei ole liputettu. Metodia
     * kutsutaan kun pelaaja on vahingossa osunut miinaan.
     */
    public void paljastaKaikkiMiinat() {
        for (int i = 0; i < this.ruudukko.getKorkeus(); i++) {
            for (int j = 0; j < this.ruudukko.getLeveys(); j++) {
                if (!ruudukko.onkoAvattu(j, i) && !this.ruudukko.onkoLiputettu(j, i)) {
                    if (ruudukko.onkoMiina(j, i)) {
                        for (Ruutunappi nappi : this.nappilista) {
                            if (nappi.getxKoordinaatti() == j && nappi.getyKoordinaatti() == i) {
                                nappi.naytaMiina();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodi palauttaa Pelikentän leveyden.
     *
     * @return Kentän leveys
     */
    public int getKentanLeveys() {
        return this.ruudukko.getLeveys();
    }

    /**
     * Metodi palauttaa Pelikentän korkeuden.
     *
     * @return Kentän korkeus
     */
    public int getKentanKorkeus() {
        return this.ruudukko.getKorkeus();
    }

    /**
     * Metodi palauttaa Pelikentässä olevien Ruutunappien listan.
     *
     * @return Lista kentällä olevista Ruutunapeista
     */
    public ArrayList<Ruutunappi> getNappilista() {
        return this.nappilista;
    }

}
