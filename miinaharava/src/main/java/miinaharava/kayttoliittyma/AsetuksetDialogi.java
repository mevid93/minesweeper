package miinaharava.kayttoliittyma;

/**
 * Luokka, joka kuvaa asetusikkunaa (JDialogi). Sisältää piirtämiseen ja
 * komponenttien toimintoihin vaadittava metodit.
 *
 * @author Martin Vidjeskog
 */
public class AsetuksetDialogi extends javax.swing.JDialog {

    /**
     * Konstruktori, joka luo uuden AsetuksetDialogi-olion (extends JDialog).
     * Saa parametreinaan Frame-olion, josta konstruktoria kutsutaan ja boolean-
     * arvon, jolla määrätään voiko toista ikkunaa käyttää dialogin ollessa
     * auki.
     *
     * @param parent Frame-olio
     * @param modal Voiko alempaa ikkunaa käyttää samanaikaisesti
     */
    public AsetuksetDialogi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Metodi, joka asettelee dialogin näkyville ja palauttaa lopuksi tiedot
     * siitä mitä asetuksia käyttäjä on tehnyt.
     *
     * @return kentän ominaisuudet, int[leveys, korkeus, miinat]
     */
    public int[] naytaDialogi() {
        this.setLocationRelativeTo(null);
        asetaAktiivisiksi(false);
        this.setVisible(true);
        return keraaTiedotPalautettavaksi();
    }

    /**
     * Metodi, joka listaa palautettavat tiedot kentän asetuksisa.
     *
     * @return kentän ominaisuudet, int[leveys, korkeus, miinat]
     */
    private int[] keraaTiedotPalautettavaksi() {
        if (jRadioButton1.isSelected()) {
            return new int[]{9, 9, 10};    // palauttaa asetukset helppoon vaikeustasoon
        } else if (jRadioButton2.isSelected()) {
            return new int[]{16, 16, 40};  // palauttaa asetukset keskivaikeaan vaikeustasoon
        } else if (jRadioButton3.isSelected()) {
            return new int[]{30, 16, 99};  // palauttaa asetukset vaikeaan vaikeustasoon
        } else if (jRadioButton4.isSelected()) {
            return customAsetukset();      // palauttaa asetukset custom vaikeustasoon
        }
        return new int[]{0, 0, 0};         // virhe palautetaan vain nollaa jolloin muutksia ei tehdä   
    }

    /**
     * Metodi, joka kerää custom asetuksiin tarvittavat tiedot
     *
     * @return kentän ominaisuudet, int[leveys, korkeus, miinat]
     */
    private int[] customAsetukset() {
        int leveys = (Integer) this.jSpinner1.getValue();
        int korkeus = (Integer) this.jSpinner2.getValue();
        int miinat = (Integer) this.jSpinner3.getValue();
        return new int[]{leveys, korkeus, miinat};
    }

    /**
     * Metodi, joka asettelee custom asetuksia varten tarvittavat
     * käyttöliittymän komponentit aktiivisiksi tai passiivisiksi parametrina
     * saadun boolean arvon mukaan.
     *
     * @param arvo Asetetaanko aktiiviseksi
     */
    private void asetaAktiivisiksi(boolean arvo) {
        this.jSpinner1.setEnabled(arvo);
        this.jSpinner2.setEnabled(arvo);
        this.jSpinner3.setEnabled(arvo);
    }

    /**
     * Metodi, joka asettelee dialogin graafisen ulkomuodon ja komponenttien
     * ominaisuudet.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton2.setText("Ota käyttöön");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Helppo");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setText("Vaikeustaso");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Keskivaikea");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Vaikea");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Custom");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Leveys");

        jLabel3.setText("Korkeus");

        jLabel4.setText("Miinat");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(9, 9, 36, 1));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(9, 9, 20, 1));

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(10, 1, ((Integer)jSpinner1.getValue()-1)*((Integer)jSpinner2.getValue()-1), 1));

        jLabel5.setText("[9, 36]");

        jLabel6.setText("[9, 20]");

        jLabel7.setText("[1, (Leveys-1)*(Korkeus-1)]");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton2)
                            .addComponent(jLabel1)
                            .addComponent(jRadioButton1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner3)
                                    .addComponent(jSpinner2))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodi, joka sulkee dialogin kun JButtonia painetaan.
     *
     * @param evt Napin painamiseen liittyvä tapahtuma
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Metodi, joka suoritetaan kun jRadioButton1:stä painetaan.
     *
     * @param evt Napin tapahtuma
     */
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        asetaAktiivisiksi(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    /**
     * Metodi, joka suoritetaan kun jRadioButton2:sta painetaan.
     *
     * @param evt Napin tapahtuma
     */
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        asetaAktiivisiksi(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    /**
     * Metodi, joka suoritetaan kun jRadioButton3:sta painetaan.
     *
     * @param evt Napin tapahtuma
     */
    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        asetaAktiivisiksi(false);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    /**
     * Metodi, joka suoritetaan kun jRadioButton4:sta painetaan.
     *
     * @param evt Napin tapahtuma
     */
    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        asetaAktiivisiksi(true);
    }//GEN-LAST:event_jRadioButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    // End of variables declaration//GEN-END:variables
}
