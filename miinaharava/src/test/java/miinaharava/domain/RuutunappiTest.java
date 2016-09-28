package miinaharava.domain;

import miinaharava.domain.Ruutunappi;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Luokka, joka testaa Ruutunappi-luokan toimintaa.
 *
 * @author Martin Vidjeskog
 */
public class RuutunappiTest {

    /**
     * Metodi, joka testaa, että konstruktori toimii normaaleilla arvoilla.
     */
    @Test
    public void konstruktoriToimii() {
        Ruutunappi ruutu = new Ruutunappi(10, 10);
        assertEquals(10, ruutu.getxKoordinaatti());
        assertEquals(10, ruutu.getyKoordinaatti());
    }

    /**
     * Metodi, joka testaa, että naytaMiina()-metodi toimii.
     */
    @Test
    public void naytaMiinaToimii() {
        Ruutunappi ruutu = new Ruutunappi(10, 10);
        assertEquals("", ruutu.getText());
        ruutu.naytaMiina();
        assertEquals("X", ruutu.getText());
    }

    /**
     * Metodi, joka testaa, että naytaNappurimiinojenMaara-metodi toimii.
     */
    @Test
    public void naytaNaapurimiinojenMaara() {
        Ruutunappi ruutu = new Ruutunappi(10, 10);
        assertEquals("", ruutu.getText());
        ruutu.naytanaapurimiinojenMaara(0);
        assertEquals("", ruutu.getText());
        ruutu.naytanaapurimiinojenMaara(1);
        assertEquals("1", ruutu.getText());
    }

    /**
     * Metodi, joka testaa, että naytaLippu-metodi toimii.
     */
    @Test
    public void naytaLippuToimii() {
        Ruutunappi ruutu = new Ruutunappi(10, 10);
        assertEquals("", ruutu.getText());
        ruutu.naytaLippu(true);
        assertEquals("L", ruutu.getText());
        ruutu.naytaLippu(false);
        assertEquals("", ruutu.getText());
    }

    /**
     * Metodi, joka testaa, että muutaPainetuksi-metodi toimii.
     */
    @Test
    public void muutaPainetuksiToimii() {
        Ruutunappi ruutu = new Ruutunappi(10, 10);
        assertTrue("Ruutu oli painettu", ruutu.isEnabled());
        ruutu.naytaMiina();
        assertFalse("Ruutua ei ollut painettu", ruutu.isEnabled());
    }
}
