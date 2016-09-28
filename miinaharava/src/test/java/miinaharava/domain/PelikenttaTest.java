package miinaharava.domain;

import miinaharava.domain.Pelikentta;
import miinaharava.domain.Ruudukko;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Martin Vidjeskog
 */
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

}
