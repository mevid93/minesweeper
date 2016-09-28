package miinaharava.domain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import miinaharava.kuuntelijat.RuutunapinKuuntelija;

/**
 * Luokka, joka kuvaa miinaharavan pelikenttää. Luokka tietää pelikentän koon ja
 * sisältää taulukon kaikista ruuduista (napeista), jotka pelikenttään kuuluvat.
 *
 * @author Martin Vidjeskog
 */
public class Pelikentta extends JPanel {

    private int leveys;
    private int korkeus;
    private Ruudukko ruudukko;

    /**
     * Konstruktori, joka luo uuden Pelikentta-olion ja saa parametrina
     * Ruudukko-olion.
     *
     * @param ruudukko Ruudukko olio
     */
    public Pelikentta(Ruudukko ruudukko) {
        this.leveys = ruudukko.getLeveys();
        this.korkeus = ruudukko.getKorkeus();
        this.ruudukko = ruudukko;
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
        for (int i = 0; i < this.korkeus; i++) {
            c.gridy = i;
            for (int j = 0; j < this.leveys; j++) {
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
        ruutunappi.addMouseListener(new RuutunapinKuuntelija(ruutunappi, this.ruudukko));
        ruutunappi.setMargin(new Insets(0, 0, 0, 0));
        return ruutunappi;
    }

    /**
     * Metodi palauttaa pelikentän leveyden.
     *
     * @return Kentän leveys
     */
    public int getKentanLeveys() {
        return leveys;
    }

    /**
     * Metodi palauttaa pelikentän korkeuden.
     *
     * @return Kentän korkeus
     */
    public int getKentanKorkeus() {
        return korkeus;
    }

}
