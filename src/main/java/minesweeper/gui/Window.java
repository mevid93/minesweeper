package minesweeper.gui;

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
import minesweeper.gamegrid.Grid;
import minesweeper.gui.eventlisteners.MenuItemListener;

/**
 * Class representing main GUI window.
 */
public class Window implements Runnable {

  private static final int DEFAULT_WIDTH = 9; // number of squares in grid horizontally
  private static final int DEFAULT_HEIGHT = 9; // number of squares in grid vertically
  private static final int DEFAULT_NUM_OF_MINES = 10; // number of mines in grid

  private static final int SQUARE_WIDTH_HEIGHT_PX = 40; // number of pixels used for square

  private JFrame frame;
  private int width;
  private int height;
  private int numberOfMines;

  /**
   * Constructor.
   */
  public Window() {
    this.width = DEFAULT_WIDTH;
    this.height = DEFAULT_HEIGHT;
    this.numberOfMines = DEFAULT_NUM_OF_MINES;
  }

  @Override
  public void run() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      assert true; // do nothing
    }

    frame = new JFrame("Minesweeper");
    frame.setPreferredSize(new Dimension((width + 1) * SQUARE_WIDTH_HEIGHT_PX,
        (height + 1) * SQUARE_WIDTH_HEIGHT_PX + 100));
    frame.setResizable(false);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JMenu gameMenu = new JMenu("Game");
    JMenuItem settingsItem = new JMenuItem("Settings");
    settingsItem.addActionListener(new MenuItemListener(settingsItem, this));
    gameMenu.add(settingsItem);
    gameMenu.add(new JSeparator());
    JMenuItem quitItem = new JMenuItem("Quit");
    quitItem.addActionListener(new MenuItemListener(quitItem, this));
    gameMenu.add(quitItem);
    JMenu instructionsItem = new JMenu("Instructions");
    JMenuItem rulesItem = new JMenuItem("Rules");
    rulesItem.addActionListener(new MenuItemListener(rulesItem, this));
    instructionsItem.add(rulesItem);

    JMenuBar menuBar = new JMenuBar();
    menuBar.add(gameMenu);
    menuBar.add(instructionsItem);
    frame.setJMenuBar(menuBar);

    initializeComponents(frame.getContentPane());

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    this.frame.setIconImage(new ImageIcon(this.getClass().getResource("/mine.png")).getImage());
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

    JButton aloitaNappi = new JButton("Restart");
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
