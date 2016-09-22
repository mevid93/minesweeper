package miinaharava.kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import miinaharava.sovelluslogiikka.Ruudukko;
import miinaharava.sovelluslogiikka.RuutunappienKuuntelija;

/**
 *
 * @author Martin Vidjeskog
 */
public class Pelikentta extends JPanel {

    private int leveys;
    private int korkeus;
    private Ruudukko ruudukko;
    private Ruutunappi[][] ruutunapit;

    /**
     * Konstruktori.
     * @param ruudukko : Ruudukko olio  
     */
    public Pelikentta(Ruudukko ruudukko) {
        this.leveys = ruudukko.getLeveys();
        this.korkeus = ruudukko.getKorkeus();
        this.ruudukko = ruudukko;
        this.ruutunapit = new Ruutunappi[this.korkeus][this.leveys];
        this.luoRuutunapit();
    }

    /**
     * Metodi, joka luo Ruutunappi-oliot ja asettelee ne pelikenttään. Samalla
     * Ruutunappi-oliot lisätään listaan muita toimintoja varten.
     */
    private void luoRuutunapit() {
        this.setLayout(new GridBagLayout()); //asetetaan layout
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        for (int i = 0; i < this.korkeus; i++) {
            c.gridy = i;
            for (int j = 0; j < this.leveys; j++) {
                c.gridx = j;
                Ruutunappi ruutunappi = new Ruutunappi(i, j);
                ruutunappi.setPreferredSize(new Dimension(40, 40));
                ruutunappi.addMouseListener(new RuutunappienKuuntelija(ruutunappi, this.ruudukko));
                ruutunappi.setMargin(new Insets(0, 0, 0, 0));
                this.add(ruutunappi, c);
                this.ruutunapit[i][j] = ruutunappi;
            }
        }
        this.setBackground(Color.GRAY);
    }

    /**
     * Metodi palauttaa pelikentän leveyden (ruutuina).
     *
     * @return : Kentän leveys
     */
    public int getKentanLeveys() {
        return leveys;
    }

    /**
     * Metodi palauttaa pelikentän korkeuden (ruutuina).
     *
     * @return : Kentän korkeus
     */
    public int getKentanKorkeus() {
        return korkeus;
    }


}
