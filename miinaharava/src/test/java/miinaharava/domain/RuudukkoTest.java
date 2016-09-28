package miinaharava.domain;

import miinaharava.domain.Ruudukko;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 * Testi luokka, joka testaa Ruudukko-luokan toimintaa.
 *
 * @author Martin Vidjeskog
 */
public class RuudukkoTest {

    /**
     * Metodi, joka testaa että Ruudukko-luokan konstruktori toimii oikein.
     */
    @Test
    public void konstruktoriToimii() {
        Ruudukko ruudukko = new Ruudukko(10, 10, 5);
        assertEquals(10, ruudukko.getLeveys());
        assertEquals(10, ruudukko.getKorkeus());
        assertEquals(5, ruudukko.getMiinoja());
    }

    /**
     * Metodi, joka testaa että sisältö asetetaan oiken Ruudukko-olion luonnin
     * yhteydessä.
     */
    @Test
    public void sisallonAsetteluToimii() {
        Ruudukko ruudukko = new Ruudukko(10, 10, 5);
        assertEquals(5, ruudukko.laskeMiinatKentalla());
    }

    /**
     * Metodi, joka testaa että metodi naapurimiinojenMaara() toimii oikein jos
     * naapurimiinoja ei ole.
     */
    @Test
    public void naapurimiinojenMaaraToimiiIlmanNaapurimiinoja() {
        Ruudukko ruudukko = new Ruudukko(3, 3, 0);
        assertEquals(0, ruudukko.naapurimiinojenMaara(1, 1));
        ruudukko = new Ruudukko(1, 1, 1);
        assertEquals(0, ruudukko.naapurimiinojenMaara(0, 0));
    }

    /**
     * Metodi, joka testaa että metodi naapurimiinojenMaara() toimii oikein jos
     * naapurimiinoja ei ole.
     */
    @Test
    public void naapurimiinojenMaaraToimiiNaapurimiinoilla() {
        Ruudukko ruudukko;
        // luodaan uusi ruudukko kunnes keskimmäinen ruutu ilman miinaa
        while (true) {
            ruudukko = new Ruudukko(3, 3, 1);
            if (!ruudukko.onkoMiina(1, 1)) {
                break;
            }
        }
        assertEquals(1, ruudukko.naapurimiinojenMaara(1, 1));
    }

    /**
     * Metodi, jokaa testaa ruudukon ruudun liputuksen tilan vaihtoa.
     */
    @Test
    public void liputuksenTilanVaihtoToimii() {
        Ruudukko ruudukko = new Ruudukko(3, 3, 0);
        assertFalse("Ruudussa oli lippu.", ruudukko.onkoLiputettu(1, 1));
        ruudukko.liputuksenTilanVaihto(1, 1);
        assertTrue("Ruudussa ei ollut lippua.", ruudukko.onkoLiputettu(1, 1));
        ruudukko.liputuksenTilanVaihto(1, 1);
        assertFalse("Ruudussa oli lippu.", ruudukko.onkoLiputettu(1, 1));
    }

    /**
     * Metodi, jokaa testaa ruudukon avauksen toimintaa.
     */
    @Test
    public void ruudukonRuudunAvausToimii() {
        Ruudukko ruudukko = new Ruudukko(3, 3, 0);
        assertFalse("Ruutu oli avattu.", ruudukko.onkoAvattu(1, 1));
        ruudukko.avaaRuutu(1, 1);
        assertTrue("Ruutu ei ollut avattu.", ruudukko.onkoAvattu(1, 1));
    }

    /**
     * Metodi, jokaa testaa toimiiko onkoMiina(int x, int y) metodi.
     */
    @Test
    public void onkoMiinaToimii() {
        Ruudukko ruudukko = new Ruudukko(1, 1, 1);
        assertTrue("Ei ollut miinaa.", ruudukko.onkoMiina(0, 0));
        ruudukko = new Ruudukko(1, 1, 0);
        assertFalse("Oli miina.", ruudukko.onkoMiina(0, 0));
    }

}
