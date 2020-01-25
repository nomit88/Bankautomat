/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankautomat;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author lars.flury
 */
public class Anzeige extends javax.swing.JFrame {

    private ArrayList<Karte> karten;
    private Bancomat bancomat;
    private Karte ausgewählteKarte;
    private Quittung quittung;
    
    private boolean isGeldBeziehen = false;
    private boolean isPinPruefen = false;
    private boolean isPinAendernPruefen = false;
    private boolean isPinAendernAendern = false;
    private boolean isCancel = false;
    private boolean isAusgeworfen = false;
    private boolean isKontoGesperrt = false;
    
    /**
     * Creates new form Anzeige
     */
    public Anzeige(ArrayList<Karte> karten, Bancomat bancomat) {
        initComponents();
        this.bancomat = bancomat;
        this.karten = karten;
        quittung = new Quittung();

        setKartenDropdown(karten);

        changeGeldwahlButtonvisibility(false);
        buttonAndrererBetrag.setVisible(false);
        textDarstellen("Bitte wählen Sie eine Karte aus");
        labelValue.setText("");
        labelNoten.setVisible(false);
        changeFunctionButtonState(false);
        changeInputButtonState(false);
        changeSubmissionButtonState(false, false, false);
        comboboxKarte.addActionListener((ActionEvent e) -> {
            if (!isAusgeworfen) {
                ausgewählteKarte = bancomat.karteEinlesen(this.karten, String.valueOf(comboboxKarte.getSelectedItem()));
                textDarstellen("Bitte geben Sie Ihren Pincode ein:");
                isPinPruefen = true;
                changeInputButtonState(true);
                changeSubmissionButtonState(true, true, true);
                labelValue.setText("");
            } 
        });
    }

    public void setKarten(ArrayList<Karte> karten) {
        this.karten = karten;
        setKartenDropdown(karten);
    }

    private void setKartenDropdown(ArrayList<Karte> karten) {
        ArrayList<String> gesperteIbans = bancomat.getGesperteKarten();
        comboboxKarte.removeAllItems();

        for (Karte karte : karten) {
            if (!gesperteIbans.contains(karte.getIban())) {
                comboboxKarte.addItem(karte.getIban());
            }
        }
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
        buttonAndrererBetrag = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(367, 180));

        buttonGrossMitQ.setText("Gross, mit Quittung");
        buttonGrossMitQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGrossMitQActionPerformed(evt);
            }
        });

        labelNoten.setText("Was für Noten?");

        buttonGrossOhneQ.setText("Gross, ohne Quittung");
        buttonGrossOhneQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGrossOhneQActionPerformed(evt);
            }
        });

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
                            .addComponent(buttonGrossMitQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonGemischtMitQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonGrossOhneQ, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonGemischtOhneQ))
                        .addGap(25, 25, 25))
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
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

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

        comboboxKarte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxKarteActionPerformed(evt);
            }
        });

        jLabel4.setText("Wählen Sie eine Karte ");

        buttonAndrererBetrag.setText("Anderer Betrag");
        buttonAndrererBetrag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAndrererBetragActionPerformed(evt);
            }
        });

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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboboxKarte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonAndrererBetrag, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonPinAendern, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31))))
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
                                .addComponent(buttonPinAendern, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(buttonAndrererBetrag, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        quittung.setZweihunderterNotenAnzahl("2");
        quittung.setHunderterNotenAnzahl("1");
        quittung.setFuenfzigerNotenAnzahl("4");
        quittung.setZwanzigerNotenAnzahl("6");
        quittung.updateNotenLabels();
        quittung.setVisible(true);
    }//GEN-LAST:event_buttonGemischtMitQActionPerformed

    private void buttonGemischtOhneQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGemischtOhneQActionPerformed

    }//GEN-LAST:event_buttonGemischtOhneQActionPerformed

    /**
     * Die aktuelle Karte wird ausgeworfen und die Karten werden neu gesetzt.
     * Dies wird getan um sicherzustellen dass das Program nich auf veralteten
     * Karten sitzt.
     */
    private void karteAuswerfen() {
        isAusgeworfen = true;
        if (isCancel) {
            textDarstellen("Karte wurde Ausgeworfen");
        } else {
            textDarstellen(labelInfo.getText() + " & Karte wurde Ausgeworfen");
        }
        bancomat.setKarten();
        labelValue.setText("");
        changeFunctionButtonState(false);
        changeInputButtonState(false);
        changeSubmissionButtonState(false, false, false);
        isAusgeworfen = false;
    }
    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOkActionPerformed
        if (isPinAendernAendern) {
            String[] pinAendernStatus = bancomat.pincodeAendern(ausgewählteKarte, labelValue.getText());
            textDarstellen(pinAendernStatus[0]);
            if (Integer.parseInt(pinAendernStatus[1]) == 1) {
                textDarstellen(labelInfo.getText() + " Geben Sie einen anderen Pin ein:");
            } else {
                isPinAendernAendern = false;
                karteAuswerfen();
            }
            isPinPruefen = false;
        }

        if (isPinPruefen) {
            if (bancomat.pincodePrüfen(ausgewählteKarte, Integer.parseInt(labelValue.getText()))) {
                isPinPruefen = false;
                changeFunctionButtonState(true);

                textDarstellen("Pincode Korrekt eingegeben.");
                ausgewählteKarte.resetPincount();
                if (isPinAendernPruefen) {
                    textDarstellen(labelInfo.getText() + " Geben Sie einen neuen Pin ein:");
                    isPinAendernPruefen = false;
                    isPinAendernAendern = true;
                }
                isKontoGesperrt = bancomat.pruefeKonto(ausgewählteKarte);
                buttonGeldBeziehen.setEnabled(!isKontoGesperrt);
                buttonSaldoAbfragen.setEnabled(!isKontoGesperrt);
                System.out.println(isKontoGesperrt);

            } else {
                int anzVerbleibendeVersuche = ausgewählteKarte.getPincount();
                if (anzVerbleibendeVersuche > 0) {
                    textDarstellen("Falscher Pincode, versuchen Sie es erneut: Verbleibende Versuche " + anzVerbleibendeVersuche);
                } else {
                    textDarstellen("Der Pincode wurde zu oft falsch eingegeben. Die Karte wird jetzt eingezogen.");
                    bancomat.karteEinziehen(ausgewählteKarte);
                    karten.remove(ausgewählteKarte);
                    setKartenDropdown(karten);
                }
            }
        }

        if (isGeldBeziehen) {
            changeGeldwahlButtonvisibility(true);
        } else {
                   
            labelValue.setText(isKontoGesperrt ? "Ihr Konto ist gesperrt!" : "");
        }


    }//GEN-LAST:event_buttonOkActionPerformed
    private void resetFunctionButtonText() {
        buttonGeldBeziehen.setText("Geld beziehen");
        buttonPinAendern.setText("Pin ändern");
        buttonSaldoAbfragen.setText("Saldo abfragen");
        buttonAndrererBetrag.setEnabled(false);
    }
    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        changeGeldwahlButtonvisibility(false);
        isGeldBeziehen = false;
        isCancel = true;
        karteAuswerfen();
        resetFunctionButtonText();
        isCancel = false;

    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonGeldBeziehenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGeldBeziehenActionPerformed
        textDarstellen("Wie viel Geld möchten Sie beziehen?:");
        if (isGeldBeziehen) {
            changeSubmissionButtonState(true, true, true);
            changeInputButtonState(false);
            labelValue.setText("20");
        } else {
            changeSubmissionButtonState(false, false, true);
        }
        isGeldBeziehen = true;
        buttonGeldBeziehen.setText("20");
        buttonAndrererBetrag.setVisible(true);
        buttonPinAendern.setText("100");
        buttonSaldoAbfragen.setText("50");
        changeInputButtonState(false);

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
        if (isGeldBeziehen) {
            labelValue.setText("50");
            changeInputButtonState(false);
            changeSubmissionButtonState(true, true, true);
        } else {
            labelInfo.setText("Ihr Saldo beträgt:");
            labelValue.setText(bancomat.saldoAbfragen(ausgewählteKarte));
        }
    }//GEN-LAST:event_buttonSaldoAbfragenActionPerformed

    private void buttonNullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNullActionPerformed
        labelValue.setText(labelValue.getText() + buttonNull.getText());
    }//GEN-LAST:event_buttonNullActionPerformed

    private void buttonPinAendernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPinAendernActionPerformed
        if (isGeldBeziehen) {
            changeSubmissionButtonState(true, true, true);
            changeInputButtonState(false);
            labelValue.setText("100");
        } else {
            textDarstellen("Geben Sie Ihren aktuellen Pin ein um den Pin zu ändern:");
            changeInputButtonState(true);
            isPinPruefen = true;
            isPinAendernPruefen = true;
        }

    }//GEN-LAST:event_buttonPinAendernActionPerformed

    private void comboboxKarteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxKarteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxKarteActionPerformed

    private void buttonAndrererBetragActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAndrererBetragActionPerformed
        labelValue.setText("");
        changeInputButtonState(true);
        changeSubmissionButtonState(true, true, true);
    }//GEN-LAST:event_buttonAndrererBetragActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        labelValue.setText("");
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonGrossMitQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGrossMitQActionPerformed
        labelValue.setText(bancomat.geldAbheben(Integer.parseInt(labelValue.getText()), ausgewählteKarte));
        
        quittung.setZweihunderterNotenAnzahl("1");
        quittung.setHunderterNotenAnzahl("3");
        quittung.setFuenfzigerNotenAnzahl("5");
        quittung.setZwanzigerNotenAnzahl("2");
        quittung.updateNotenLabels();
        if(labelValue.getText().isEmpty()){
            quittung.setVisible(true);
        }
    }//GEN-LAST:event_buttonGrossMitQActionPerformed

    private void buttonGrossOhneQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGrossOhneQActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonGrossOhneQActionPerformed

    public void beschrifteFktTasten() {

    }

    public void textDarstellen(String infoText) {
        labelInfo.setText(infoText);
    }

    private void changeInputButtonState(boolean state) {
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
    }

    private void changeGeldwahlButtonvisibility(boolean state) {
        buttonGemischtMitQ.setVisible(state);
        buttonGemischtOhneQ.setVisible(state);
        buttonGrossMitQ.setVisible(state);
        buttonGrossOhneQ.setVisible(state);
    }

    private void changeFunctionButtonState(boolean state) {
        buttonGeldBeziehen.setEnabled(state);
        buttonPinAendern.setEnabled(state);
        buttonSaldoAbfragen.setEnabled(state);

    }

    private void changeSubmissionButtonState(boolean ok, boolean clear, boolean cancel) {
        buttonOk.setEnabled(ok);
        buttonClear.setEnabled(clear);
        buttonCancel.setEnabled(cancel);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAcht;
    private javax.swing.JButton buttonAndrererBetrag;
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
