package miinaharava.domain;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RuutunappiTest {

    @Test
    public void konstruktoriToimii() {
        Ruutunappi ruutu = new Ruutunappi(10, 10);
        assertEquals(10, ruutu.getxKoordinaatti());
        assertEquals(10, ruutu.getyKoordinaatti());
    }

    @Test
    public void naytaMiinaToimii() {
        Ruutunappi ruutu = new Ruutunappi(10, 10);
        assertEquals(null, ruutu.getIcon());
        ruutu.naytaMiina();
        assertTrue(ruutu.getIcon().toString().contains("miina.png"));
    }

    @Test
    public void naytaNaapurimiinojenMaara() {
        Ruutunappi ruutu = new Ruutunappi(10, 10);
        assertEquals(null, ruutu.getIcon());
        ruutu.naytanaapurimiinojenMaara(0);
        assertEquals(null, ruutu.getIcon());
        ruutu.naytanaapurimiinojenMaara(1);
        assertTrue(ruutu.getIcon().toString().contains("numero1.png"));
    }

    @Test
    public void naytaLippuToimii() {
        Ruutunappi ruutu = new Ruutunappi(10, 10);
        assertEquals(null, ruutu.getIcon());
        ruutu.naytaLippu(true);
        assertTrue(ruutu.getIcon().toString().contains("lippu.png"));
        ruutu.naytaLippu(false);
        assertEquals(null, ruutu.getIcon());
    }

    @Test
    public void muutaPainetuksiToimii() {
        Ruutunappi ruutu = new Ruutunappi(10, 10);
        assertTrue("Ruutu oli painettu", ruutu.isEnabled());
        ruutu.naytaMiina();
        assertFalse("Ruutua ei ollut painettu", ruutu.isEnabled());
    }
}
