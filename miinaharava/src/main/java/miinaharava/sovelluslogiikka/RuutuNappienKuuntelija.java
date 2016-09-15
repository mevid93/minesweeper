package miinaharava.sovelluslogiikka;

import miinaharava.kayttoliittyma.Ruutunappi;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author Martin Vidjeskog
 */
public class RuutuNappienKuuntelija implements MouseListener {

    private Ruutunappi ruutu;

    public RuutuNappienKuuntelija(Ruutunappi ruutu) {
        this.ruutu = ruutu;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.ruutu) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                this.ruutu.setBackground(Color.red);
            }
        }
        if (e.getSource() == this.ruutu) {
            if (SwingUtilities.isRightMouseButton(e)) {
                this.ruutu.setBackground(Color.CYAN);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Ei tarvita
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
