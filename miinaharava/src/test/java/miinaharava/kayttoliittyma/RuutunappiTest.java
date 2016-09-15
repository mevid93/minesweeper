package miinaharava.kayttoliittyma;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Martin Vidjeskog
 */
public class RuutunappiTest {

    public RuutunappiTest() {
    }

    @Test
    public void konstruktoriToimiiNormaaleillaKoordinaateilla() {
        Ruutunappi ruutu = new Ruutunappi(10, 10);
        assertEquals(10, ruutu.getxKoordinaatti());
        assertEquals(10, ruutu.getyKoordinaatti());
    }

    @Test
    public void konstruktoriToimiiPoikkeavillaKoordinaateilla() {
        Ruutunappi ruutu = new Ruutunappi(-1, -1);
        assertEquals(0, ruutu.getxKoordinaatti());
        assertEquals(0, ruutu.getyKoordinaatti());
    }

}
