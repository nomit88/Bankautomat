/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankautomat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 *
 * @author lars.flury
 */
public class Anzeige extends javax.swing.JFrame {

    private boolean isGeldBeziehen = false;

    /**
     * Creates new form Anzeige
     */
    public Anzeige() {
        initComponents();
        buttonGemischtMitQ.setVisible(false);
        buttonGemischtOhneQ.setVisible(false);
        buttonGrossMitQ.setVisible(false);
        buttonGrossOhneQ.setVisible(false);
        labelInfo.setText("Bitte wählen Sie eine Karte aus");
        labelValue.setText("");
        labelNoten.setVisible(false);
        changeInputButtonState(false);
        comboboxKarte.addActionListener ((ActionEvent e) -> {
                labelInfo.setText("Bitte geben Sie Ihren Pincode ein:");
                changeInputButtonState(true);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelInfo = new javax.swing.JLabel();
        labelValue = new javax.swing.JLabel();
        buttonGrossMitQ = new javax.swing.JButton();
        labelNoten = new javax.swing.JLabel();
        buttonGrossOhneQ = new javax.swing.JButton();
        buttonGemischtMitQ = new javax.swing.JButton();
        buttonGemischtOhneQ = new javax.swing.JButton();
        buttonGeldBeziehen = new javax.swing.JButton();
        buttonSaldoAbfragen = new javax.swing.JButton();
        buttonPinAendern = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        buttonSieben = new javax.swing.JButton();
        buttonAcht = new javax.swing.JButton();
        buttonNeun = new javax.swing.JButton();
        buttonOk = new javax.swing.JButton();
        buttonVier = new javax.swing.JButton();
        buttonFuenf = new javax.swing.JButton();
        buttonSechs = new javax.swing.JButton();
        buttonEins = new javax.swing.JButton();
        buttonZwei = new javax.swing.JButton();
        buttonDrei = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        buttonNull = new javax.swing.JButton();
        comboboxKarte = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(367, 180));

        buttonGrossMitQ.setText("Gross, mit Quittung");

        labelNoten.setText("Was für Noten?");

        buttonGrossOhneQ.setText("Gross, ohne Quittung");

        buttonGemischtMitQ.setText("Gemischt, mit Quittung");
        buttonGemischtMitQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGemischtMitQActionPerformed(evt);
            }
        });

        buttonGemischtOhneQ.setText("Gemischt, ohne Quittung");
        buttonGemischtOhneQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGemischtOhneQActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonGemischtMitQ)
                            .addComponent(buttonGrossMitQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonGemischtOhneQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonGrossOhneQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelNoten)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(labelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelValue, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNoten)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGrossMitQ)
                    .addComponent(buttonGrossOhneQ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGemischtMitQ)
                    .addComponent(buttonGemischtOhneQ))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        buttonGeldBeziehen.setText("Geld beziehen");
        buttonGeldBeziehen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGeldBeziehenActionPerformed(evt);
            }
        });

        buttonSaldoAbfragen.setText("Saldo abfragen");
        buttonSaldoAbfragen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaldoAbfragenActionPerformed(evt);
            }
        });

        buttonPinAendern.setText("Pin ändern");
        buttonPinAendern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPinAendernActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(367, 228));

        buttonSieben.setText("7");
        buttonSieben.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSiebenActionPerformed(evt);
            }
        });

        buttonAcht.setText("8");
        buttonAcht.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAchtActionPerformed(evt);
            }
        });

        buttonNeun.setText("9");
        buttonNeun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNeunActionPerformed(evt);
            }
        });

        buttonOk.setText("OK");
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOkActionPerformed(evt);
            }
        });

        buttonVier.setText("4");
        buttonVier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVierActionPerformed(evt);
            }
        });

        buttonFuenf.setText("5");
        buttonFuenf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFuenfActionPerformed(evt);
            }
        });

        buttonSechs.setText("6");
        buttonSechs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSechsActionPerformed(evt);
            }
        });

        buttonEins.setText("1");
        buttonEins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEinsActionPerformed(evt);
            }
        });

        buttonZwei.setText("2");
        buttonZwei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonZweiActionPerformed(evt);
            }
        });

        buttonDrei.setText("3");
        buttonDrei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDreiActionPerformed(evt);
            }
        });

        buttonClear.setText("Clear");

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonNull.setText("0");
        buttonNull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNullActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonVier, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFuenf, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSechs, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonSieben, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAcht, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNeun, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonEins, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonNull, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(buttonZwei, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDrei, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSieben, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAcht, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNeun, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonVier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFuenf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSechs, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEins, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonZwei, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDrei, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonNull, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        comboboxKarte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Wählen Sie eine Karte ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonSaldoAbfragen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonGeldBeziehen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonPinAendern, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboboxKarte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(buttonGeldBeziehen, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(buttonSaldoAbfragen, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(buttonPinAendern, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addComponent(comboboxKarte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGemischtMitQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGemischtMitQActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonGemischtMitQActionPerformed

    private void buttonGemischtOhneQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGemischtOhneQActionPerformed
        Quittung quittung = new Quittung();
        quittung.setVisible(true);
    }//GEN-LAST:event_buttonGemischtOhneQActionPerformed

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOkActionPerformed
        if (isGeldBeziehen) {
            labelNoten.setVisible(true);
            buttonGemischtMitQ.setVisible(true);
            buttonGemischtOhneQ.setVisible(true);
            buttonGrossMitQ.setVisible(true);
            buttonGrossOhneQ.setVisible(true);
        }
    }//GEN-LAST:event_buttonOkActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        buttonGemischtMitQ.setVisible(false);
        buttonGemischtOhneQ.setVisible(false);
        buttonGrossMitQ.setVisible(false);
        buttonGrossOhneQ.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonGeldBeziehenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGeldBeziehenActionPerformed
        labelInfo.setText("Wie viel Geld möchten Sie beziehen?");
        isGeldBeziehen = true;
        changeInputButtonState(true);
    }//GEN-LAST:event_buttonGeldBeziehenActionPerformed

    private void buttonAchtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAchtActionPerformed
        labelValue.setText(labelValue.getText() + buttonAcht.getText());
    }//GEN-LAST:event_buttonAchtActionPerformed

    private void buttonEinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEinsActionPerformed
        labelValue.setText(labelValue.getText() + buttonEins.getText());
    }//GEN-LAST:event_buttonEinsActionPerformed

    private void buttonZweiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonZweiActionPerformed
        labelValue.setText(labelValue.getText() + buttonZwei.getText());
    }//GEN-LAST:event_buttonZweiActionPerformed

    private void buttonDreiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDreiActionPerformed
        labelValue.setText(labelValue.getText() + buttonDrei.getText());
    }//GEN-LAST:event_buttonDreiActionPerformed

    private void buttonVierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVierActionPerformed
        labelValue.setText(labelValue.getText() + buttonVier.getText());
    }//GEN-LAST:event_buttonVierActionPerformed

    private void buttonFuenfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFuenfActionPerformed
        labelValue.setText(labelValue.getText() + buttonFuenf.getText());
    }//GEN-LAST:event_buttonFuenfActionPerformed

    private void buttonSechsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSechsActionPerformed
        labelValue.setText(labelValue.getText() + buttonSechs.getText());
    }//GEN-LAST:event_buttonSechsActionPerformed

    private void buttonSiebenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSiebenActionPerformed
        labelValue.setText(labelValue.getText() + buttonSieben.getText());
    }//GEN-LAST:event_buttonSiebenActionPerformed

    private void buttonNeunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNeunActionPerformed
        labelValue.setText(labelValue.getText() + buttonNeun.getText());
    }//GEN-LAST:event_buttonNeunActionPerformed

    private void buttonSaldoAbfragenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaldoAbfragenActionPerformed
        changeInputButtonState(false);
    }//GEN-LAST:event_buttonSaldoAbfragenActionPerformed

    private void buttonNullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNullActionPerformed
        labelValue.setText(labelValue.getText() + buttonNull.getText());
    }//GEN-LAST:event_buttonNullActionPerformed

    private void buttonPinAendernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPinAendernActionPerformed
        changeInputButtonState(true);
    }//GEN-LAST:event_buttonPinAendernActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Anzeige.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Anzeige.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Anzeige.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Anzeige.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Anzeige().setVisible(true);
            }
        });
    }

    public void beschrifteFktTasten() {

    }

    public void textDarstellen() {

    }
    
    private void changeInputButtonState(boolean state){
        buttonNull.setEnabled(state);
        buttonEins.setEnabled(state);
        buttonZwei.setEnabled(state);
        buttonDrei.setEnabled(state);
        buttonVier.setEnabled(state);
        buttonFuenf.setEnabled(state);
        buttonSechs.setEnabled(state);
        buttonSieben.setEnabled(state);
        buttonAcht.setEnabled(state);
        buttonNeun.setEnabled(state);
        buttonOk.setEnabled(state);
        buttonClear.setEnabled(state);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAcht;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonDrei;
    private javax.swing.JButton buttonEins;
    private javax.swing.JButton buttonFuenf;
    private javax.swing.JButton buttonGeldBeziehen;
    private javax.swing.JButton buttonGemischtMitQ;
    private javax.swing.JButton buttonGemischtOhneQ;
    private javax.swing.JButton buttonGrossMitQ;
    private javax.swing.JButton buttonGrossOhneQ;
    private javax.swing.JButton buttonNeun;
    private javax.swing.JButton buttonNull;
    private javax.swing.JButton buttonOk;
    private javax.swing.JButton buttonPinAendern;
    private javax.swing.JButton buttonSaldoAbfragen;
    private javax.swing.JButton buttonSechs;
    private javax.swing.JButton buttonSieben;
    private javax.swing.JButton buttonVier;
    private javax.swing.JButton buttonZwei;
    private javax.swing.JComboBox<String> comboboxKarte;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelInfo;
    private javax.swing.JLabel labelNoten;
    private javax.swing.JLabel labelValue;
    // End of variables declaration//GEN-END:variables
}
