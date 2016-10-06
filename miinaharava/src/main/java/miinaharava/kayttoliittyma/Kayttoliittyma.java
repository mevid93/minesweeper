package miinaharava.kayttoliittyma;

import miinaharava.domain.Pelikentta;
import miinaharava.kuuntelijat.ValikkonappienKuuntelija;
import miinaharava.kuuntelijat.AloitusnapinKuuntelija;
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
import miinaharava.domain.Ruudukko;

/**
 * Luokka, joka kuvaa miinaharavan pääasiallista graafista pelinäkymää. Sisältää
 * metodit käyttöliittymän piirtämiseen ja komponenttien asetteluun. Sisältää
 * metodit myös pelikentän koon vaihtamista varten ja pelin
 * uudelleenaloittamiseen.
 *
 * @author Martin Vidjeskog
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;   // käyttöliittyman ikkunan kehys
    private int leveys;     // pelikentän leveys
    private int korkeus;    // pelikentän korkeus
    private int miinat;     // pelinkentällä olevien miinojen määrä

    /**
     * Konstruktori, joka asettaa käyttöliittymän pelikentän leveyden, korkeuden
     * ja miinojen määrän kun ohjelma käynnsitetään. Default vaikeustaso on
     * helppo.
     */
    public Kayttoliittyma() {
        this.leveys = 9;
        this.korkeus = 9;
        this.miinat = 10;
    }

    /**
     * Metodi, joka luo käyttöliittymäikkunan ja asettelee sen näkyville.
     */
    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension((this.leveys + 1) * 40, (this.korkeus + 1) * 40 + 100));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu peliMenu = new JMenu("Peli");
        JMenuItem asetukset = new JMenuItem("Asetukset");
        asetukset.addActionListener(new ValikkonappienKuuntelija(asetukset, this));
        peliMenu.add(asetukset);
        peliMenu.add(new JSeparator());
        JMenuItem lopeta = new JMenuItem("Lopeta");
        lopeta.addActionListener(new ValikkonappienKuuntelija(lopeta, this));
        peliMenu.add(lopeta);
        JMenu ohjeMenu = new JMenu("Ohje");
        JMenuItem saannot = new JMenuItem("Säännöt");
        saannot.addActionListener(new ValikkonappienKuuntelija(saannot, this));
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
     * Metodi luo käyttöliittymäikkunan komponentit ja asettelee ne paikoilleen.
     *
     * @param container Container-olio, johon komponentit asetellaan
     */
    private void luoKomponentit(Container container) {
        container.removeAll();
        container.setLayout(new BorderLayout());

        Ruudukko ruudukko = new Ruudukko(this.leveys, this.korkeus, this.miinat);
        Pelikentta kentta = new Pelikentta(ruudukko);
        container.add(kentta);

        JPanel paneeli1 = new JPanel(new GridLayout(1, 3));
        paneeli1.setBackground(Color.red);
        paneeli1.setPreferredSize(new Dimension(500, 50));
        container.add(paneeli1, BorderLayout.NORTH);

        JButton aloitaNappi = new JButton("Aloita alusta");
        aloitaNappi.addActionListener(new AloitusnapinKuuntelija(this));
        paneeli1.add(new JPanel());
        paneeli1.add(aloitaNappi);
        paneeli1.add(new JPanel());

    }

    /**
     * Metodi, joka aloittaa peli alusta (käyttöliittymän päivitys)
     */
    public void aloitaAlusta() {
        this.luoKomponentit(frame.getContentPane());
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Metodi, joka palauttaa ohjelman ikkunan kehyksen.
     *
     * @return Käyttöliittymäikkunan kehys
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Metodi, joka asettaa uuden leveyden ja korkeuden ja miinojen määrän
     *
     * @param leveys Pelikentän leveys
     * @param korkeus Peliekntän korkeus
     * @param miinat Pelikentän miinojen määrä
     */
    public void maaritaUudetAsetukset(int leveys, int korkeus, int miinat) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.miinat = miinat;
        this.luoKomponentit(frame.getContentPane());
        frame.setSize(new Dimension((this.leveys + 1) * 40, (this.korkeus + 1) * 40 + 100));
        frame.setLocationRelativeTo(null);
        frame.invalidate();
        frame.revalidate();
        frame.repaint();
    }

}
