package miinaharava.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PelikenttaTest {

    public PelikenttaTest() {
    }

    @Test
    public void konstruktoriToimii() {
        Ruudukko ruudukko = new Ruudukko(10, 10, 5);
        Pelikentta kentta = new Pelikentta(ruudukko);
        assertEquals(10, kentta.getKentanLeveys());
        assertEquals(10, kentta.getKentanKorkeus());
    }

    @Test
    @SuppressWarnings("null")
    public void naapurimiinojenEsilleAsettaminenToimii() {
        Pelikentta kentta = new Pelikentta(new Ruudukko(3, 3, 1));
        Ruutunappi nappi = null;
        for (Ruutunappi ruutunappi : kentta.getNappilista()) {
            if (ruutunappi.getxKoordinaatti() == 1 && ruutunappi.getyKoordinaatti() == 1) {
                nappi = ruutunappi;
                break;
            }
        }
        assertEquals(null, nappi.getIcon());
        kentta.asetaRuutunapinNaapurimiinatEsille(1, 1, 1);
        assertTrue(nappi.getIcon().toString().contains("numero1.png"));
    }

    @Test
    @SuppressWarnings("null")
    public void paljastaKaikkiMiinatToimii() {
        Ruudukko ruudukko = new Ruudukko(3, 3, 1);
        while (!ruudukko.onkoMiina(1, 1)) {
            ruudukko = new Ruudukko(3, 3, 1);
        }
        Pelikentta kentta = new Pelikentta(ruudukko);
        Ruutunappi nappi = null;
        for (Ruutunappi ruutunappi : kentta.getNappilista()) {
            if (ruutunappi.getxKoordinaatti() == 1 && ruutunappi.getyKoordinaatti() == 1) {
                nappi = ruutunappi;
                break;
            }
        }
        assertEquals(null, nappi.getIcon());
        kentta.paljastaKaikkiMiinat();
        assertTrue(nappi.getIcon().toString().contains("miina.png"));
    }
}
