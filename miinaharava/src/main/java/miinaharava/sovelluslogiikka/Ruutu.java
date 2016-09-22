package miinaharava.sovelluslogiikka;

/**
 *
 * @author Martin Vidjeskog
 */
public class Ruutu {

    private boolean onAvattu;       // tieto siitä onko ruutu avattu 
    private boolean onLiputettu;    // tieto siitä onko ruutu liputettu
    private boolean onMiina;        // tieto siitä onko ruudussa miina

    /**
     * Konstruktori, joka luo Ruutu-olion ja asettaa kaikki boolean arvot alussa
     * epätosiksi.
     */
    public Ruutu() {
        this.onAvattu = false;
        this.onLiputettu = false;
        this.onMiina = false;
    }

    /**
     * Metodi, joka palattaa tiedon siitä onko ruutu avattu
     *
     * @return
     */
    public boolean onkoAvattu() {
        return this.onAvattu;
    }

    /**
     * Metodi, jolla ruutu merkitään avatuksi
     */
    public void avaa() {
        if (this.onLiputettu) {
            return;
        }
        this.onAvattu = true;
    }

    /**
     * Metodi, joka palauttaa tiedon siitä onko ruutu liputettu
     *
     * @return
     */
    public boolean onkoLiputettu() {
        return this.onLiputettu;
    }

    /**
     * Metodi, jolla ruutu voidaan merkitä liputetutksi tai liputtomaksi
     * riippuen siitä onko boolean arvo true vai false.
     */
    public void liputuksenTilanVaihto() {
        if (this.onAvattu) {
            return;
        }
        if (this.onLiputettu) {
            this.onLiputettu = false;
            return;
        }
        this.onLiputettu = true;
    }

    /**
     * Metodi, joka palauttaa tiedon siitä onko ruudussa miina.
     *
     * @return
     */
    public boolean onkoMiina() {
        return this.onMiina;
    }

    /**
     * Metodi, jolla ruutuun voidaan merkitä miina. Metodia kutsutaan vain
     * ruudukon luonnin yhteydessä.
     */
    public void miinoita() {
        this.onMiina = true;
    }

}
