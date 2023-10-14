package minesweeper.gui;

/**
 * Class represents settings dialog.
 */
public class SettingsDialog extends javax.swing.JDialog {

  private static final long serialVersionUID = 1L;
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JButton jsButton2;
  private javax.swing.JLabel jsLabel1;
  private javax.swing.JLabel jsLabel2;
  private javax.swing.JLabel jsLabel3;
  private javax.swing.JLabel jsLabel4;
  private javax.swing.JLabel jsLabel5;
  private javax.swing.JLabel jsLabel6;
  private javax.swing.JLabel jsLabel7;
  private javax.swing.JPanel jsPanel1;
  private javax.swing.JRadioButton jsRadioButton1;
  private javax.swing.JRadioButton jsRadioButton2;
  private javax.swing.JRadioButton jsRadioButton3;
  private javax.swing.JRadioButton jsRadioButton4;
  private javax.swing.JSpinner jsSpinner1;
  private javax.swing.JSpinner jsSpinner2;
  private javax.swing.JSpinner jsSpinner3;

  /**
   * Constructor.
   *
   * @param parent parent window
   * @param modal  allow input to parent widow when in dialog
   */
  public SettingsDialog(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
  }

  /**
   * Method to show dialog. Returns an array of settings when dialog is closed.
   *
   * @return settings array [width, height, number of mines]
   */
  public int[] showDialog() {
    setLocationRelativeTo(null);
    setActive(false);
    setVisible(true);
    return collectSettings();
  }

  private int[] collectSettings() {
    if (jsRadioButton1.isSelected()) {
      return new int[] { 9, 9, 10 }; // easy
    } else if (jsRadioButton2.isSelected()) {
      return new int[] { 16, 16, 40 }; // medium
    } else if (jsRadioButton3.isSelected()) {
      return new int[] { 30, 16, 99 }; // hard
    } else if (jsRadioButton4.isSelected()) {
      return customSettings();
    }
    return new int[] { 0, 0, 0 };
  }

  private int[] customSettings() {
    int leveys = (Integer) jsSpinner1.getValue();
    int korkeus = (Integer) jsSpinner2.getValue();
    int miinat = (Integer) jsSpinner3.getValue();
    return new int[] { leveys, korkeus, miinat };
  }

  private void setActive(boolean arvo) {
    jsSpinner1.setEnabled(arvo);
    jsSpinner2.setEnabled(arvo);
    jsSpinner3.setEnabled(arvo);
  }

  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    jsPanel1 = new javax.swing.JPanel();
    jsButton2 = new javax.swing.JButton();
    jsRadioButton1 = new javax.swing.JRadioButton();
    jsLabel1 = new javax.swing.JLabel();
    jsRadioButton2 = new javax.swing.JRadioButton();
    jsRadioButton3 = new javax.swing.JRadioButton();
    jsRadioButton4 = new javax.swing.JRadioButton();
    jsLabel2 = new javax.swing.JLabel();
    jsLabel3 = new javax.swing.JLabel();
    jsLabel4 = new javax.swing.JLabel();
    jsSpinner1 = new javax.swing.JSpinner();
    jsSpinner2 = new javax.swing.JSpinner();
    jsSpinner3 = new javax.swing.JSpinner();
    jsLabel5 = new javax.swing.JLabel();
    jsLabel6 = new javax.swing.JLabel();
    jsLabel7 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jsButton2.setText("Apply");
    jsButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jaButton2ActionPerformed(evt);
      }
    });

    buttonGroup1.add(jsRadioButton1);
    jsRadioButton1.setText("Easy");
    jsRadioButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jaRadioButton1ActionPerformed(evt);
      }
    });

    jsLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
    jsLabel1.setText("Difficulty level");

    buttonGroup1.add(jsRadioButton2);
    jsRadioButton2.setText("Medium");
    jsRadioButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jaRadioButton2ActionPerformed(evt);
      }
    });

    buttonGroup1.add(jsRadioButton3);
    jsRadioButton3.setText("Hard");
    jsRadioButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jaRadioButton3ActionPerformed(evt);
      }
    });

    buttonGroup1.add(jsRadioButton4);
    jsRadioButton4.setText("Custom");
    jsRadioButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jaRadioButton4ActionPerformed(evt);
      }
    });

    jsLabel2.setText("Width");

    jsLabel3.setText("Height");

    jsLabel4.setText("Mines");

    jsSpinner1.setModel(new javax.swing.SpinnerNumberModel(9, 9, 36, 1));

    jsSpinner2.setModel(new javax.swing.SpinnerNumberModel(9, 9, 20, 1));

    jsSpinner3.setModel(new javax.swing.SpinnerNumberModel(10, 1,
        ((Integer) jsSpinner1.getValue() - 1) * ((Integer) jsSpinner2.getValue() - 1), 1));

    jsLabel5.setText("[9, 36]");

    jsLabel6.setText("[9, 20]");

    jsLabel7.setText("[1, (Width-1)*(Height-1)]");

    javax.swing.GroupLayout jsPanel1Layout = new javax.swing.GroupLayout(jsPanel1);
    jsPanel1.setLayout(jsPanel1Layout);
    jsPanel1Layout.setHorizontalGroup(
        jsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jsPanel1Layout.createSequentialGroup().addGroup(jsPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                    jsPanel1Layout
                        .createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(
                            jsPanel1Layout
                                .createParallelGroup(
                                    javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jsRadioButton4)
                                .addComponent(jsRadioButton3)
                                .addComponent(jsRadioButton2)
                                .addComponent(jsLabel1)
                                .addComponent(jsRadioButton1)
                                .addGroup(
                                    jsPanel1Layout.createSequentialGroup()
                                        .addComponent(jsLabel2).addGap(18, 18, 18)
                                        .addComponent(jsSpinner1,
                                            javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jsPanel1Layout.createSequentialGroup()
                                    .addGroup(jsPanel1Layout
                                        .createParallelGroup(
                                            javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jsLabel3)
                                        .addComponent(jsLabel4))
                                    .addGap(14, 14, 14)
                                    .addGroup(jsPanel1Layout
                                        .createParallelGroup(
                                            javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jsSpinner3)
                                        .addComponent(jsSpinner2))))
                        .addGap(18, 18, 18)
                        .addGroup(
                            jsPanel1Layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jsLabel5)
                                .addComponent(jsLabel6)
                                .addComponent(jsLabel7)))
                .addGroup(
                    jsPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58).addComponent(jsButton2,
                            javax.swing.GroupLayout.PREFERRED_SIZE, 122,
                            javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE)));

    jsPanel1Layout.setVerticalGroup(
        jsPanel1Layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                jsPanel1Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jsLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jsRadioButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jsRadioButton2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jsRadioButton3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jsRadioButton4)
                    .addGap(21, 21, 21)
                    .addGroup(
                        jsPanel1Layout.createParallelGroup(
                            javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jsLabel2)
                            .addComponent(jsSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jsLabel5))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        jsPanel1Layout.createParallelGroup(
                            javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jsLabel3)
                            .addComponent(jsSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jsLabel6))
                    .addGap(9, 9, 9)
                    .addGroup(
                        jsPanel1Layout.createParallelGroup(
                            javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                jsPanel1Layout.createSequentialGroup()
                                    .addComponent(jsLabel4).addGap(18, 18, 18)
                                    .addComponent(jsButton2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jsPanel1Layout.createSequentialGroup()
                                .addGroup(jsPanel1Layout
                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jsSpinner3,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jsLabel7))
                                .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                jsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

    pack();
  }

  private void jaButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    dispose();
  }

  private void jaRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    setActive(false);
  }

  private void jaRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    setActive(false);
  }

  private void jaRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    setActive(false);
  }

  private void jaRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {
    setActive(true);
  }
}
