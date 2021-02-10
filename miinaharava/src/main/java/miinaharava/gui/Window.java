package miinaharava.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import miinaharava.datastructures.Grid;
import miinaharava.eventlisteners.MenuItemListener;

/**
 * Class representing main GUI window.
 */
public class Window implements Runnable {

	private JFrame frame;
	private int width;
	private int height;
	private int numberOfMines;

	/**
	 * Constructor.
	 */
	public Window() {
		this.width = 9;
		this.height = 9;
		this.numberOfMines = 10;
	}

	@Override
	public void run() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		frame = new JFrame("Miinaharava");
		frame.setPreferredSize(new Dimension((width + 1) * 40, (height + 1) * 40 + 100));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		JMenu peliMenu = new JMenu("Peli");
		JMenuItem asetukset = new JMenuItem("Asetukset");
		asetukset.addActionListener(new MenuItemListener(asetukset, this));
		peliMenu.add(asetukset);
		peliMenu.add(new JSeparator());
		JMenuItem lopeta = new JMenuItem("Lopeta");
		lopeta.addActionListener(new MenuItemListener(lopeta, this));
		peliMenu.add(lopeta);
		JMenu ohjeMenu = new JMenu("Ohje");
		JMenuItem saannot = new JMenuItem("Säännöt");
		saannot.addActionListener(new MenuItemListener(saannot, this));
		ohjeMenu.add(saannot);
		menuBar.add(peliMenu);
		menuBar.add(ohjeMenu);
		frame.setJMenuBar(menuBar);

		initializeComponents(frame.getContentPane());

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		this.frame.setIconImage(new ImageIcon(getClass().getResource("/miina.png")).getImage());
	}

	private void initializeComponents(Container container) {
		container.removeAll();
		container.setLayout(new BorderLayout());

		Grid ruudukko = new Grid(this.width, this.height, this.numberOfMines);
		GamePanel kentta = new GamePanel(ruudukko);
		container.add(kentta);

		JPanel paneeli1 = new JPanel(new GridLayout(1, 3));
		paneeli1.setBackground(Color.red);
		paneeli1.setPreferredSize(new Dimension(500, 50));
		container.add(paneeli1, BorderLayout.NORTH);

		JButton aloitaNappi = new JButton("Aloita alusta");
		aloitaNappi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				restartTheGame();
			}
		});
		paneeli1.add(new JPanel());
		paneeli1.add(aloitaNappi);
		paneeli1.add(new JPanel());

	}

	/**
	 * Start the game from the beginning.
	 */
	public void restartTheGame() {
		initializeComponents(frame.getContentPane());
		frame.revalidate();
		frame.repaint();
	}

	/**
	 * Method returns the frame of the main window.
	 *
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Method to define new settings for the game.
	 *
	 * @param newWidth      game area width
	 * @param newHeight     game area height
	 * @param newNumOfMines new number of mines
	 */
	public void changeSettings(int newWidth, int newHeight, int newNumOfMines) {
		width = newWidth;
		height = newHeight;
		numberOfMines = newNumOfMines;
		frame.setSize(new Dimension((width + 1) * 40, (height + 1) * 40 + 100));
		initializeComponents(frame.getContentPane());
		frame.setLocationRelativeTo(null);
		frame.invalidate();
		frame.revalidate();
		frame.repaint();
	}

}
