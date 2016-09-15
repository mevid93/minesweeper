package miinaharava.sovelluslogiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author Martin Vidjeskog
 */
public class ValikkoNappienKuuntelija implements ActionListener {

    private JMenuItem valinta;

    public ValikkoNappienKuuntelija(JMenuItem valinta) {
        this.valinta = valinta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (valinta.getText()) {
            case "Lopeta":
                System.exit(0);
            // Toteutetaan myöhemmin
            case "Asetukset":
                break;
            // Toteutetaan myöhemmin
            case "Säännöt":
                break;
            default:
                break;
        }
    }

}
