package miinaharava.sovelluslogiikka;

/**
 *
 * @author Martin Vidjeskog
 */
public class Ruudukko {

    private int korkeus;            // peliruudukon korkeus
    private int leveys;             // peliruudukon leveys
    private int miinoja;            // peliruudukon miinojen maara
    private Ruutu ruudukko[][];     // peliruudukko kaksidimensioisena taulukkona

    /**
     * Kondytruktori, joka luo uuden Ruudukko-olion. Parametrien avulla luodaan
     * sisältö kutsumalla private-metodia asetaSisalto().
     *
     * @param leveys
     * @param korkeus
     * @param miinoja
     */
    public Ruudukko(int leveys, int korkeus, int miinoja) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudukko = new Ruutu[korkeus][leveys];
        this.asetaSisalto();
    }

    private void asetaSisalto() {
        // toteutus puutuu
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public int naapurimiinojenMaara(int x, int y) {
        return 1;   //toeteutus puutuu
    }

    public void asetaLippu(int x, int y) {
        //toteutus puuttuu
    }

    public void avaaRuutu(int x, int y) {
        // toteutus puutuu
    }

    public boolean onkoAvattu(int x, int y) {
        return true; // toteutus puutuu
    }

    public boolean onkoLiputettu(int x, int y) {
        return true; // toteutus puutuu
    }

    public boolean onkoMiina(int x, int y) {
        return true;    //toteutus puuttuu
    }

}
