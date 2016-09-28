package miinaharava.domain;

import java.util.Random;

/**
 * Luokka, joka tarjoaa metodit pelikentässä tapahtuvien asioiden päivittämiseen
 * ja hakemiseen. Tietoja jokaisesta ruudusta voidaan ylläpitää tämän luokan
 * avulla.
 *
 * @author Martin Vidjeskog
 */
public class Ruudukko {

    private int korkeus;            // peliruudukon korkeus
    private int leveys;             // peliruudukon leveys
    private int miinoja;            // peliruudukon miinojen maara
    private Ruutu ruudukko[][];     // peliruudukko kaksidimensioisena taulukkona

    /**
     * Konstruktori, joka luo uuden Ruudukko-olion. Parametreina annetaan
     * luotavan ruudukon leveys, korkeus ja miinojen määrä.
     *
     * @param leveys Ruudukon leveys
     * @param korkeus Ruudukon korkeus
     * @param miinoja Ruudukon miinojen määrä
     */
    public Ruudukko(int leveys, int korkeus, int miinoja) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.miinoja = miinoja;
        this.ruudukko = new Ruutu[korkeus][leveys];
        this.luoRuudut();
        this.asetaMiinat();
    }

    /**
     * Metodi, jolla luotuun ruudukkoon asetellaan Ruutu-oliot.
     */
    private void luoRuudut() {
        for (int i = 0; i < this.korkeus; i++) {
            for (int j = 0; j < this.leveys; j++) {
                ruudukko[i][j] = new Ruutu();
            }
        }
    }

    /**
     * Metodi, joka asettelee ruudukkoon satunnaisesti oikean määrän miinoja.
     */
    private void asetaMiinat() {
        int asetetutMiinat = 0;
        Random rand = new Random();
        while (asetetutMiinat < this.miinoja) {
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
     * taulukon korkeus (pelikentän korkeus).
     *
     * @return ruudukon korkeus
     */
    public int getKorkeus() {
        return korkeus;
    }

    /**
     * Metodi, jolla palautetaan Ruudukko-olioon tallennetun kaksidimensioisen
     * taulukon leveys (pelikentän leveys).
     *
     * @return ruudukon leveys
     */
    public int getLeveys() {
        return leveys;
    }

    /**
     * Metodi, jolla palautetaan Ruudukko-olioon tallennetussa
     * kaksidimensioisessa taulukossa olevien miinojen määrä.
     *
     * @return ruudukon miinojen lkm
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
     * @return ruudukon miinojen lkm
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
     * Metodi, joka palauttaa tarkasteltavan ruudun (x, y) naapuriruuduissa
     * olevien miinojen maarän.
     *
     * @param x Tarkasteltavan ruudun x-koordinaatti. [0,n]
     * @param y Tarkasteltavan ruudun y-koordinaatti. [0,n]
     *
     * @return ruudun (x, y) naapurimiinojen määrä
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
     * Metodi, jonka avulla taulukossa olevaan ruudun (x, y) liputuksen tilaa
     * vaihdetaan. Metodi sekä poistaa liputuksen, että asettaa liputuksen.
     *
     * @param x Käsiteltävän ruudun x-koordinaatti. [0,n]
     * @param y Käsiteltävän ruudun y-koordinaatti. [0,n]
     */
    public void liputuksenTilanVaihto(int x, int y) {
        this.ruudukko[y][x].liputuksenTilanVaihto();
    }

    /**
     * Metodi, jonka avulla taulukon ruutu (x, y) voidaan merkitä avatuksi.
     *
     * @param x Käsiteltävän ruudun x-koordinaatti. [0,n]
     * @param y Käsiteltävän ruudun y-koordinaatti. [0,n]
     */
    public void avaaRuutu(int x, int y) {
        this.ruudukko[y][x].avaa();
    }

    /**
     * Metodi, jolla saadaan tietää onko joku ruutu merkitty avatuksi.
     *
     * @param x Käsiteltävän ruudun x-koordinaatti. [0,n]
     * @param y Käsiteltävän ruudun y-koordinaatti. [0,n]
     *
     * @return onko ruutu avattu
     */
    public boolean onkoAvattu(int x, int y) {
        return this.ruudukko[y][x].onkoAvattu();
    }

    /**
     * Metodi, jolla saadaan tietää onko joku ruutu merkitty liputetuksi.
     *
     * @param x Käsiteltävän ruudun x-koordinaatti. [0,n]
     * @param y Käsiteltävän ruudun y-koordinaatti. [0,n]
     *
     * @return onko ruutu liputettu
     */
    public boolean onkoLiputettu(int x, int y) {
        return this.ruudukko[y][x].onkoLiputettu();
    }

    /**
     * Metodi, jolla saadaan tietää onko johonkin ruutuun merkitty miina.
     *
     * @param x Käsiteltävän ruudun x-koordinaatti. [0,n]
     * @param y Käsiteltävän ruudun y-koordinaatti. [0,n]
     *
     * @return onko ruudussa miina
     */
    public boolean onkoMiina(int x, int y) {
        return this.ruudukko[y][x].onkoMiina();
    }

}
