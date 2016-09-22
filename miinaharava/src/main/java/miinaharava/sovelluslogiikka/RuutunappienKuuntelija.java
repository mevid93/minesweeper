package miinaharava.sovelluslogiikka;

import miinaharava.kayttoliittyma.Ruutunappi;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author Martin Vidjeskog
 */
public class RuutunappienKuuntelija implements MouseListener {

    private Ruutunappi ruutunappi;
    private Ruudukko ruudukko;

    public RuutunappienKuuntelija(Ruutunappi ruutunappi, Ruudukko ruudukko) {
        this.ruutunappi = ruutunappi;
        this.ruudukko = ruudukko;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = this.ruutunappi.getxKoordinaatti();
        int y = this.ruutunappi.getyKoordinaatti();
        if (e.getSource() == this.ruutunappi) {
            if (SwingUtilities.isLeftMouseButton(e) && !this.ruudukko.onkoLiputettu(x, y)) {
                this.ruudukko.avaaRuutu(x, y);
                if (this.ruudukko.onkoMiina(x, y)) {
                    this.ruutunappi.naytaMiina();
                } else {
                    this.ruutunappi.naytanaapurimiinojenMaara(this.ruudukko.naapurimiinojenMaara(x, y));
                }
            }
        }
        if (e.getSource() == this.ruutunappi) {
            if (SwingUtilities.isRightMouseButton(e)) {
                this.ruudukko.liputuksenTilanVaihto(x, y);
                this.ruutunappi.naytaLippu(this.ruudukko.onkoLiputettu(x, y));
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Ei tarvita
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //Ei tarvita
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //Ei tarvita
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //Ei tarvita
    }

}
