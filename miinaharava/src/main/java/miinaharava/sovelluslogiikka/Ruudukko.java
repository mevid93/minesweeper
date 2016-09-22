package miinaharava.sovelluslogiikka;

import java.util.Random;

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
     * Konstruktori, joka luo uuden Ruudukko-olion. Parametrien avulla luodaan
     * sisältö kutsumalla private-metodia asetaSisalto().
     *
     * @param leveys
     * @param korkeus
     * @param miinoja
     */
    public Ruudukko(int leveys, int korkeus, int miinoja) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.miinoja = miinoja;
        if (this.miinoja > this.korkeus * this.leveys) {
            this.miinoja = this.korkeus * this.leveys - 1;
        }
        this.ruudukko = new Ruutu[korkeus][leveys];
        this.asetaSisalto();
    }

    /**
     * Metodi, jolla luotuun ruudukkoon Ruutu-oliot ja asetellaan satunaisesti
     * annettu määrä miinoja.
     */
    private void asetaSisalto() {
        int asetetutMiinat = 0;
        Random rand = new Random();
        for (int i = 0; i < this.korkeus; i++) {      // luodaan ruutu oliot
            for (int j = 0; j < this.leveys; j++) {
                ruudukko[i][j] = new Ruutu();
            }
        }
        while (asetetutMiinat < this.miinoja) {       // asetellaan miinat
            int x = rand.nextInt(this.leveys);
            int y = rand.nextInt(this.korkeus);
            if (!this.ruudukko[y][x].onkoMiina()) {
                this.ruudukko[y][x].miinoita();
                asetetutMiinat++;
            }
        }
    }

    /**
     * Metodi, jolla palautetaan Ruudukko-olioon tallennetun kaksidimensioisen
     * taulukon korkeus. Vastaa pelikentän leveyttä.
     *
     * @return : ruudukon korkeus
     */
    public int getKorkeus() {
        return korkeus;
    }

    /**
     * Metodi, jolla palautetaan Ruudukko-olioon tallennetun kaksidimensioisen
     * taulukon leveys. Vastaa pelikentän leveyttä.
     *
     * @return : ruudukon leveys
     */
    public int getLeveys() {
        return leveys;
    }

    /**
     * Metodi, jolla palautetaan Ruudukko-olioon tallennetussa
     * kaksidimensioisessa taulukossa olevien miinojen määrä.
     *
     * @return : ruudukon miinojen lkm.
     */
    public int getMiinoja() {
        return miinoja;
    }

    /**
     * Metodi, jolla palautetaan Ruudukko-olioon tallennetussa
     * kaksidimensioisessa taulukossa olevien miinojen määrä. Metodia käytetään
     * toiminnan testaamiseen. Se on periaatteessa sama kuin getMiinoja(), mutta
     * hitaampi.
     *
     * @return : ruudukon miinojen lkm.
     */
    public int laskeMiinatKentalla() {
        int miinat = 0;
        for (int i = 0; i < this.korkeus; i++) {
            for (int j = 0; j < this.leveys; j++) {
                if (this.ruudukko[i][j].onkoMiina()) {
                    miinat++;
                }
            }
        }
        return miinat;
    }

    /**
     * Metodi, joka palauttaa naapuriruuduissa olevien miinojen maarän.
     *
     * @param x : Tarkasteltavan ruudun x-koordinaatti. [0,n]
     * @param y : Tarkasteltavan ruudun y-koordinaatti. [0,n]
     * @return : Ruudun (x, y) naapurimiinojen määrä.
     */
    public int naapurimiinojenMaara(int x, int y) {
        int miinat = 0;
        for (int i = y - 1; i < y + 2; i++) {
            for (int j = x - 1; j < x + 2; j++) {
                if (i >= 0 && i < this.korkeus && j >= 0 && j < this.leveys && !(i == y && j == x)) {
                    if (this.ruudukko[i][j].onkoMiina()) {
                        miinat++;
                    }
                }
            }
        }
        return miinat;
    }

    /**
     * Metodi, jonka avulla taulukossa olevaan Ruutu-olion liputuksen tilaa
     * vaihdetaan. Metodi sekä poistaa liputuksen, että asettaa liputuksen.
     *
     * @param x : Käsiteltävän ruudun x-koordinaatti. [0,n]
     * @param y : Käsiteltävän ruudun y-koordinaatti. [0,n]
     */
    public void liputuksenTilanVaihto(int x, int y) {
        this.ruudukko[y][x].liputuksenTilanVaihto();
    }

    /**
     * Metodi, jonka avulla taulukon Ruutu-olio voidaan avata.
     *
     * @param x : Käsiteltävän ruudun x-koordinaatti. [0,n]
     * @param y : Käsiteltävän ruudun y-koordinaatti. [0,n]
     */
    public void avaaRuutu(int x, int y) {
        this.ruudukko[y][x].avaa();
    }

    /**
     * Metodi, jolla saadaan tietää onko joku Ruutu-olio merkitty avatuksi.
     *
     * @param x : Käsiteltävän ruudun x-koordinaatti. [0,n]
     * @param y : Käsiteltävän ruudun y-koordinaatti. [0,n]
     * @return
     */
    public boolean onkoAvattu(int x, int y) {
        return this.ruudukko[y][x].onkoAvattu();
    }

    /**
     * Metodi, jolla saadaan tietää onko joku Ruutu-olio merkitty liputetuksi.
     *
     * @param x : Käsiteltävän ruudun x-koordinaatti. [0,n]
     * @param y : Käsiteltävän ruudun y-koordinaatti. [0,n]
     * @return
     */
    public boolean onkoLiputettu(int x, int y) {
        return this.ruudukko[y][x].onkoLiputettu();
    }

    /**
     * Metodi, jolla saadaan tietää onko jossain Ruutu-oliossa merkitty olevan
     * miina.
     *
     * @param x : Käsiteltävän ruudun x-koordinaatti. [0,n]
     * @param y : Käsiteltävän ruudun y-koordinaatti. [0,n]
     * @return
     */
    public boolean onkoMiina(int x, int y) {
        return this.ruudukko[y][x].onkoMiina();
    }

}
