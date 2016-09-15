package miinaharava.kayttoliittyma;

import miinaharava.sovelluslogiikka.ValikkoNappienKuuntelija;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;

/**
 *
 * @author Martin Vidjeskog
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension((9 + 1) * 40, (9 + 1) * 40 + 100));
        frame.setResizable(false);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu peliMenu = new JMenu("Peli");
        JMenuItem asetukset = new JMenuItem("Asetukset");
        asetukset.addActionListener(new ValikkoNappienKuuntelija(asetukset));
        peliMenu.add(asetukset);
        peliMenu.add(new JSeparator());
        JMenuItem lopeta = new JMenuItem("Lopeta");
        lopeta.addActionListener(new ValikkoNappienKuuntelija(lopeta));
        peliMenu.add(lopeta);
        JMenu ohjeMenu = new JMenu("Ohje");
        JMenuItem saannot = new JMenuItem("Säännöt");
        saannot.addActionListener(new ValikkoNappienKuuntelija(saannot));
        ohjeMenu.add(saannot);
        menuBar.add(peliMenu);
        menuBar.add(ohjeMenu);
        frame.setJMenuBar(menuBar);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Metodi luo käyttöliittymän komponentit ja asettelee ne paikoilleen.
     *
     * @param container : container-olio, johon käyttöliittymän komponentit
     * asetellaan
     */
    private void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());

        Pelikentta kentta = new Pelikentta(9, 9);
        container.add(kentta);

        JPanel paneeli2 = new JPanel(new GridLayout(1, 3));
        paneeli2.setBackground(Color.red);
        paneeli2.setPreferredSize(new Dimension(500, 50));
        container.add(paneeli2, BorderLayout.NORTH);

        JButton nappi1 = new JButton();
        paneeli2.add(new JPanel());
        paneeli2.add(nappi1);
        paneeli2.add(new JPanel());
        nappi1.setText("Aloita alusta");

    }

    public JFrame getFrame() {
        return frame;
    }
}
