
package miinaharava.miinaharava;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Martin Vidjeskog
 */
public class Pelikentta extends JPanel{
    
    private int leveys;
    private int korkeus;
    private List<Ruutu> ruutuLista;
    
    /**
     * 
     * @param leveys : Pelikentän ruutujen määrä leveyssuunnassa
     * @param korkeus  : Pelikentän ruutujen määrä pystysuunnassa
     */
    public Pelikentta(int leveys, int korkeus){
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruutuLista = new ArrayList<>();
        if(this.leveys < 9){    // varmistetaan että leveys on vähintään 9
            this.leveys = 9;
        }
        if(this.korkeus < 9){   // varmistetaan että korkeus on vähintään 9
            this.korkeus = 9;
        }
        this.luoRuudut();
    }
    
    
    /**
     * Metodi, joka luo Ruutu-oliot ja asettelee ne pelikenttään.
     */
    public void luoRuudut(){
        this.setLayout(new GridBagLayout()); //asetetaan layout
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        for(int i = 0; i < this.korkeus; i++){
            c.gridy = i;
            for(int j = 0; j < this.leveys; j++){
                c.gridx = j;
                Ruutu ruutu = new Ruutu(i, j);
                this.add(ruutu, c);
            }
        }
        this.setBackground(Color.GRAY);
    }
    
    
    
}
