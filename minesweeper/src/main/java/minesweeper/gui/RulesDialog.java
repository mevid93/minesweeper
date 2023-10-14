package minesweeper.gui;

/**
 * Class represents rules dialog.
 */
public class RulesDialog extends javax.swing.JDialog {

  private static final long serialVersionUID = 1L;
  private javax.swing.JButton jsButton1;
  private javax.swing.JLabel jsLabel1;
  private javax.swing.JScrollPane jsScrollPane2;
  private javax.swing.JTextArea jsTextArea1;

  /**
   * Constructor.
   *
   * @param parent main window.
   * @param modal  prevent input to main window while in dialog
   */
  public RulesDialog(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
  }

  /**
   * Method to show dialog.
   */
  public void showDialog() {
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void initComponents() {

    jsButton1 = new javax.swing.JButton();
    jsLabel1 = new javax.swing.JLabel();
    jsScrollPane2 = new javax.swing.JScrollPane();
    jsTextArea1 = new javax.swing.JTextArea();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jsButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
    jsButton1.setText("Close instructions");
    jsButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jaButton1ActionPerformed(evt);
      }
    });

    jsLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
    jsLabel1.setText("Minesweeper rules");

    jsTextArea1.setEditable(false);
    jsTextArea1.setColumns(20);
    jsTextArea1.setLineWrap(true);
    jsTextArea1.setRows(5);
    jsTextArea1.setText(
        new StringBuilder()
            .append("Target is to clear all mines. \n")
            .append("Use left mouse key to inspect a cell. \n")
            .append("Game ends if cell contains a mine. \n")
            .append("If cell does not contain a mine, ")
            .append("a number of mines in the neighbouring cells is shown. \n")
            .append("Use right mouse key to flag cells containing mines. \n")
            .append("The game ends once all the cells without mines are identified.")
            .toString());

    jsTextArea1.setWrapStyleWord(true);
    jsScrollPane2.setViewportView(jsTextArea1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jsButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(153, 153, 153))
            .addGroup(layout.createSequentialGroup().addGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(jsLabel1))
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(jsScrollPane2,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 371,
                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jsLabel1)
                    .addGap(18, 18, 18)
                    .addComponent(jsScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 305,
                        Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jsButton1,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()));

    pack();
  }

  /**
   * Method to close window.
   *
   * @param evt click event
   */
  private void jaButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    dispose();
  }

}
