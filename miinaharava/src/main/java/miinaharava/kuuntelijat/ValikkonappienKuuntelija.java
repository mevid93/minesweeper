package miinaharava.kuuntelijat;

import miinaharava.kayttoliittyma.AsetuksetDialogi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import miinaharava.kayttoliittyma.Kayttoliittyma;
import miinaharava.kayttoliittyma.SaannotDialogi;

/**
 * Luokka, joka sisältää tarvittavat meotodi, käyttöliittymän valikon nappien
 * tapahtumakuuntijalle. Logiikka sille mitä tehdään jos nappeja painetaan.
 *
 * @author Martin Vidjeskog
 */
public class ValikkonappienKuuntelija implements ActionListener {

    private JMenuItem valinta;      // Valikkonappi, johon kuuntelija on kytketty
    private Kayttoliittyma ikkuna;  // Käyttöliittymä luokka

    /**
     * Konstruktori, joka saa paramtereina valikkonapin (JMenuItem) ja Kaytto-
     * liittyma-olion ja luo uuden ValikkonappienKuuntelijan.
     *
     * @param valinta Valikkonappi (JMenuItem)
     * @param ikkuna Kayttoliittyma-olio
     */
    public ValikkonappienKuuntelija(JMenuItem valinta, Kayttoliittyma ikkuna) {
        this.ikkuna = ikkuna;
        this.valinta = valinta;
    }

    /**
     * Metodi, joka määrää mitä tehdään, kun valikon nappiin rekisteröidään
     * tapahtuma.
     *
     * @param e Valikon tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (valinta.getText()) {
            case "Lopeta":
                System.exit(0);
            case "Asetukset":
                asetusNapinToiminnot();
                break;
            case "Säännöt":
                saantoNapinToiminnot();
                break;
            default:
                break;
        }
    }

    /**
     * Metodi, joka luo uuden AsetuksetDialogi-olion (extends JDialog). Metodi
     * myös kutsuu sen metodia naytaDialogi().
     */
    private void asetusNapinToiminnot() {
        AsetuksetDialogi asetus = new AsetuksetDialogi(this.ikkuna.getFrame(), true);
        int[] koko = asetus.naytaDialogi();
        if (koko[0] != 0) {
            ikkuna.maaritaUudetAsetukset(koko[0], koko[1], koko[2]);
        }
    }

    /**
     * Metodi, joka luo uuden SaannotDialogi-olion (extends JDialog). Metodi
     * myös kutsuu myös sen metodia naytaDialogi().
     */
    private void saantoNapinToiminnot() {
        SaannotDialogi saanto = new SaannotDialogi(this.ikkuna.getFrame(), true);
        saanto.naytaDialogi();
    }

}
