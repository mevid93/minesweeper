package miinaharava.sovelluslogiikka;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author Martin Vidjeskog
 */
public class RuudukkoTest {

    public RuudukkoTest() {
    }

    @Test
    public void konstruktoriToimiiNormaaleillaArvoilla() {
        Ruudukko ruudukko = new Ruudukko(10, 10, 5);
        assertEquals(10, ruudukko.getLeveys());
        assertEquals(10, ruudukko.getKorkeus());
        assertEquals(5, ruudukko.getMiinoja());
    }
    
    @Test
    public void konstruktoriToimiiKunMiinojaOnLiikaa() {
        Ruudukko ruudukko = new Ruudukko(3, 3, 20);
        assertEquals(3, ruudukko.getLeveys());
        assertEquals(3, ruudukko.getKorkeus());
        assertEquals(8, ruudukko.getMiinoja());
    }

    @Test
    public void sisallonAsetteluToimii() {
        Ruudukko ruudukko = new Ruudukko(10, 10, 5);
        assertEquals(5, ruudukko.laskeMiinatKentalla());
    }

    @Test
    public void naapurimiinojenMaaraToimiiIlmanNaapurimiinoja() {
        Ruudukko ruudukko = new Ruudukko(3, 3, 0);
        assertEquals(0, ruudukko.naapurimiinojenMaara(1, 1));
        ruudukko = new Ruudukko(1, 1, 1);
        assertEquals(0, ruudukko.naapurimiinojenMaara(0, 0));
    }

    @Test
    public void liputuksenTilanVaihtoToimii() {
        Ruudukko ruudukko = new Ruudukko(3, 3, 0);
        assertFalse("Ruudussa oli lippu.", ruudukko.onkoLiputettu(1, 1));
        ruudukko.liputuksenTilanVaihto(1, 1);
        assertTrue("Ruudussa ei ollut lippua.", ruudukko.onkoLiputettu(1, 1));
        ruudukko.liputuksenTilanVaihto(1, 1);
        assertFalse("Ruudussa oli lippu.", ruudukko.onkoLiputettu(1, 1));
    }

    @Test
    public void ruudukonRuudunAvausToimii() {
        Ruudukko ruudukko = new Ruudukko(3, 3, 0);
        assertFalse("Ruutu oli avattu.", ruudukko.onkoAvattu(1, 1));
        ruudukko.avaaRuutu(1, 1);
        assertTrue("Ruutu ei ollut avattu.", ruudukko.onkoAvattu(1, 1));
    }
    
    @Test
    public void onkoMiinaToimiiJosOnMiina(){
        Ruudukko ruudukko = new Ruudukko(1,1,1);
        assertTrue("Ei ollut miinaa.", ruudukko.onkoMiina(0, 0));
    }

}
