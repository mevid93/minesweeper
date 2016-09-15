package miinaharava.kayttoliittyma;

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
    public void konstruktoriToimiiNormaaleillaAlkuarvoilla() {
        Pelikentta kentta = new Pelikentta(10, 10);
        assertEquals(10, kentta.getKentanLeveys());
        assertEquals(10, kentta.getKentanKorkeus());
    }

    @Test
    public void konstruktoriToimiiPoikkeavillaAlkuarvoilla() {
        Pelikentta kentta = new Pelikentta(-1, 8);
        assertEquals(9, kentta.getKentanLeveys());
        assertEquals(9, kentta.getKentanKorkeus());
    }
}
