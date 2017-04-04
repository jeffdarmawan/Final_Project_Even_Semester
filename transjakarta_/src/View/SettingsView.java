/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.*;
import Model.*;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Mikha Putri
 */
public class SettingsView extends javax.swing.JFrame implements Apply_Settings{
    
    Settings Preferences; 
    User guest;
    
    public SettingsView(Settings set){
        this.Preferences = set;
        initComponents();     
        apply();
        this.setLocationRelativeTo(null);
    }
    
    public SettingsView(User s){
        this.guest = s;
        initComponents();     
        apply();
        this.setLocationRelativeTo(null);
    }
    
    @Override
    public void apply() {
        if(this.Preferences.getLanguage().equals("eng")){
            changeToEng();
            languageGroup.setSelected(engButton.getModel(), true);
        }
        else if (this.Preferences.getLanguage().equals("indo")){
            changeToIndo();
            languageGroup.setSelected(indoButton.getModel(), true);
        }
        if(this.Preferences.getColor().equals("pink")){
            changePink();
            colorGroup.setSelected(pinkButton.getModel(), true);
        }
        else if (this.Preferences.getColor().equals("gray")){
            changeGray();
            colorGroup.setSelected(grayButton.getModel(), true);
        }
        else{
            changeDefault();
        }
    }
    
    @Override
    public void changeToIndo() {
        languageLabel.setText("Bahasa");
        colorsLabel.setText("Warna");
        backButton.setText("Menu Utama");
        defaultButt.setText("Pengaturan Awal");
        okButton.setText("Ok");
        engButton.setText("Inggris");
        indoButton.setText("Bahasa");
        pinkButton.setText("Merah Muda");
        grayButton.setText("Kelabu");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void changeToEng() {
        languageLabel.setText("Language");
        colorsLabel.setText("Color");
        backButton.setText("Main Menu");
        defaultButt.setText("Set as Default");
        okButton.setText("Ok");
        engButton.setText("English");
        indoButton.setText("Indonesia");
        pinkButton.setText("Pink");
        grayButton.setText("Gray");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changePink() {
        this.getContentPane().setBackground(Color.PINK);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeGray() {
        this.getContentPane().setBackground(Color.GRAY);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeDefault() {
        this.getContentPane().setBackground(null);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        languageGroup = new javax.swing.ButtonGroup();
        colorGroup = new javax.swing.ButtonGroup();
        pinkButton = new javax.swing.JRadioButton();
        grayButton = new javax.swing.JRadioButton();
        okButton = new javax.swing.JButton();
        languageLabel = new javax.swing.JLabel();
        engButton = new javax.swing.JRadioButton();
        indoButton = new javax.swing.JRadioButton();
        colorsLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        defaultButt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(370, 200));
        setMinimumSize(new java.awt.Dimension(370, 200));
        setPreferredSize(new java.awt.Dimension(370, 200));
        setResizable(false);
        setSize(new java.awt.Dimension(370, 200));

        colorGroup.add(pinkButton);
        pinkButton.setText("Pink");

        colorGroup.add(grayButton);
        grayButton.setText("Gray");

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        languageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        languageLabel.setText("Language");
        languageLabel.setToolTipText("");
        languageLabel.setMaximumSize(new java.awt.Dimension(70, 15));
        languageLabel.setMinimumSize(new java.awt.Dimension(70, 15));
        languageLabel.setPreferredSize(new java.awt.Dimension(70, 15));

        languageGroup.add(engButton);
        engButton.setText("English");
        engButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engButtonActionPerformed(evt);
            }
        });

        languageGroup.add(indoButton);
        indoButton.setText("Indonesia");
        indoButton.setAlignmentY(0.0F);
        indoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        colorsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        colorsLabel.setText("Color");
        colorsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorsLabel.setMaximumSize(new java.awt.Dimension(70, 15));
        colorsLabel.setMinimumSize(new java.awt.Dimension(70, 15));
        colorsLabel.setPreferredSize(new java.awt.Dimension(70, 15));

        backButton.setText("Main Menu");
        backButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        defaultButt.setText("Set default");
        defaultButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(defaultButt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(colorsLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(languageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(engButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pinkButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(indoButton)
                            .addComponent(grayButton))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(languageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(engButton))
                    .addComponent(indoButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colorsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pinkButton)
                    .addComponent(grayButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(okButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defaultButt)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        
        if(engButton.isSelected())
        {
            this.Preferences.setLanguage("eng");
        }
        else if(indoButton.isSelected())
        {
            this.Preferences.setLanguage("indo");
        }
        else{
        }
        
        if(pinkButton.isSelected())
        {
            this.Preferences.setColor("pink");
            if(engButton.isSelected()){
                JOptionPane.showMessageDialog(this, "Updated!");
            }
            else if (indoButton.isSelected()){
                JOptionPane.showMessageDialog(this, "Diperbarui!");
            }
        }
        else if(grayButton.isSelected())
        {
            this.Preferences.setColor("gray");
            
                if(engButton.isSelected()){
                JOptionPane.showMessageDialog(this, "Updated!");
                }
                else if (indoButton.isSelected()){
                JOptionPane.showMessageDialog(this, "Diperbarui!");
                }
        }
        else{
        }        
        apply();
        /*
        frame = this;
        langLabel = languageLabel;
        colorLabel = colorsLabel;
        back = backButton;
        ChangeSettings cs = new ChangeSettings();
        cs.change(language, color, langLabel, colorLabel, frame, back);*/
    }//GEN-LAST:event_okButtonActionPerformed

    private void engButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_engButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new OpeningView(Preferences).setVisible(true);        
    }//GEN-LAST:event_backButtonActionPerformed

    private void defaultButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultButtActionPerformed
        this.Preferences.setColor("default");
        this.Preferences.setLanguage("eng");
        apply();
        //languageGroup.setSelected((ButtonModel)engButton, true);
        languageGroup.setSelected(engButton.getModel(), true);
        //languageGroup.clearSelection();
        colorGroup.clearSelection();
        
    }//GEN-LAST:event_defaultButtActionPerformed

    /*
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton backButton;
    private javax.swing.ButtonGroup colorGroup;
    public javax.swing.JLabel colorsLabel;
    private javax.swing.JButton defaultButt;
    public javax.swing.JRadioButton engButton;
    public javax.swing.JRadioButton grayButton;
    public javax.swing.JRadioButton indoButton;
    private javax.swing.ButtonGroup languageGroup;
    public javax.swing.JLabel languageLabel;
    public javax.swing.JButton okButton;
    public javax.swing.JRadioButton pinkButton;
    // End of variables declaration//GEN-END:variables

}
