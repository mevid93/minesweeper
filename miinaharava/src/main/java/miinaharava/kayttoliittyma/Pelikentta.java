
package miinaharava.kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import miinaharava.sovelluslogiikka.RuutuNappienKuuntelija;

/**
 *
 * @author Martin Vidjeskog
 */
public class Pelikentta extends JPanel{
    
    private int leveys;
    private int korkeus;
    
    /**
     * 
     * @param leveys : Pelikentän ruutujen määrä leveyssuunnassa
     * @param korkeus  : Pelikentän ruutujen määrä pystysuunnassa
     */
    public Pelikentta(int leveys, int korkeus){
        this.leveys = leveys;
        this.korkeus = korkeus;
        if(this.leveys < 9){    // varmistetaan että leveys on vähintään 9
            this.leveys = 9;
        }
        if(this.korkeus < 9){   // varmistetaan että korkeus on vähintään 9
            this.korkeus = 9;
        }
        this.luoRuudut();
    }
    
    
    /**
     * Metodi, joka luo Ruutunappi-oliot ja asettelee ne pelikenttään.
     * Samalla Ruutunappi-oliot lisätään listaan muita toimintoja varten.
     */
    private void luoRuudut(){
        this.setLayout(new GridBagLayout()); //asetetaan layout
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        for(int i = 0; i < this.korkeus; i++){
            c.gridy = i;
            for(int j = 0; j < this.leveys; j++){
                c.gridx = j;
                Ruutunappi ruutu = new Ruutunappi(i, j);
                        ruutu.setPreferredSize(new Dimension(40, 40));
                        ruutu.addMouseListener(new RuutuNappienKuuntelija(ruutu));
                this.add(ruutu, c);
            }
        }
        this.setBackground(Color.GRAY);
    }

    
    /**
     * Metodi palauttaa pelikentän leveyden (ruutuina).
     * @return  
     */
    public int getKentanLeveys() {
        return leveys;
    }

    
    /**
     * Metodi palauttaa pelikentän korkeuden (ruutuina).
     * @return 
     */
    public int getKentanKorkeus() {
        return korkeus;
    }

    
    
    
}
