/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import Controller.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

/**
 *
 * @author Mikha Putri
 */
public class SearchRoutesView extends javax.swing.JFrame implements Apply_Settings{

    /**
     * Creates new form searchRoutesView
     */
    
    Settings Preferences;
    String departure, destination;
    User guest;
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    public SearchRoutesView(User s) {
        this.guest = s;
        initComponents();
        connectDB();
        apply();
        System.out.println(this.guest.getDeparture());
        this.departure = this.guest.getDeparture();
        fromBox.setModel(new DefaultComboBoxModel(getHalte()));
        fromBox.setSelectedItem(this.departure);
        redisplay();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        fromBox.setPreferredSize(new Dimension(52, 27));
        toBox.setPreferredSize(new Dimension(52, 27));
        searchRoutesButt.setPreferredSize(new Dimension(90, 29));
        getContentPane().setLayout(null);
        getContentPane().add(fromBox);
        getContentPane().add(toBox);
        getContentPane().add(searchRoutesButt);
    }

    public SearchRoutesView(Settings set) {
        this.Preferences = set;
        initComponents();
        connectDB();
        apply();
        this.departure = "";
        fromBox.setModel(new DefaultComboBoxModel(getHalte()));
        redisplay();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        fromBox.setPreferredSize(new Dimension(52, 27));
        toBox.setPreferredSize(new Dimension(52, 27));
        searchRoutesButt.setPreferredSize(new Dimension(90, 29));
        getContentPane().setLayout(null);
        getContentPane().add(fromBox);
        getContentPane().add(toBox);
        getContentPane().add(searchRoutesButt);
    }
    
    public SearchRoutesView(Settings set, String from){
        this.Preferences = set;
        this.departure = from;
        initComponents();
        connectDB();
        apply();
        fromBox.setModel(new DefaultComboBoxModel(getHalte()));
        fromBox.setSelectedItem(from);
        toBox.setModel(new DefaultComboBoxModel(getHalte()));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        fromBox.setPreferredSize(new Dimension(52, 27));
        toBox.setPreferredSize(new Dimension(52, 27));
        searchRoutesButt.setPreferredSize(new Dimension(90, 29));
        getContentPane().setLayout(null);
        getContentPane().add(fromBox);
        getContentPane().add(toBox);
        getContentPane().add(searchRoutesButt);
    }
   
    public final void connectDB(){
        try{
            //singleton
            con = ConnectionConfig.createConnection();
            
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM tj order by halte";
            rs = stmt.executeQuery(query);
            rs.next();
        }catch(SQLException e){
            System.out.println(e);
            //JOptionPane.showMessageDialog(this, e.getMessage());
        }catch (ClassNotFoundException ex) {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
            //Logger.getLogger(JListFirstAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void redisplay(){
        //fromBox.removeAllItems();
        toBox.removeAllItems();
        toBox.setModel(new DefaultComboBoxModel(getHalte()));
        if(departure.equals(""))
            fromBox.setSelectedIndex(0);
       
        //else
            //fromBox.setSelectedItem(fromidk);
        for(int i = 0; i < toBox.getModel().getSize(); i++)
        {
            if(fromBox.getSelectedItem().equals(toBox.getItemAt(i))){
                toBox.removeItemAt(i);
                break;
            }  
        }
        
            toBox.setSelectedIndex(0);
    }
    
    public String[] getHalte()
    {
        ArrayList<String> allHalte = new ArrayList();
        String halte;
        String[] sHalte = null;
        try{
            rs = stmt.executeQuery("select * from tj order by halte");
            while(rs.next()){ 
                allHalte.add(rs.getString("halte"));
                
                //check after the first data is the same as the next one
                if(allHalte.size()!= 1){
                    //remove the data with the same value
                    if(allHalte.get(allHalte.size()-1).equals(allHalte.get(allHalte.size()-2))){
                    allHalte.remove(allHalte.size()-1);
                }
            }
        }
        }catch(SQLException e)
        {
           System.out.println(e);
        }
        String[] halteArr = new String[allHalte.size()];//System.out.println(allHalte);
        halteArr = allHalte.toArray(halteArr);
        
        return halteArr;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        from = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        searchroute = new javax.swing.JLabel();
        searchRoutesButt = new javax.swing.JButton();
        findBSLabel = new javax.swing.JLabel();
        fromBox = new javax.swing.JComboBox<>();
        toBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        from.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        from.setText("From");

        to.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        to.setText("To");

        searchroute.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        searchroute.setText("SEARCH ROUTES");

        searchRoutesButt.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        searchRoutesButt.setText("Search");
        searchRoutesButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRoutesButtActionPerformed(evt);
            }
        });

        findBSLabel.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        findBSLabel.setText("Find bus stop?");
        findBSLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                findBSLabelMouseClicked(evt);
            }
        });

        fromBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fromBoxItemStateChanged(evt);
            }
        });
        fromBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromBoxActionPerformed(evt);
            }
        });

        toBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fromBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(toBox, 0, 241, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(findBSLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                            .addComponent(searchRoutesButt)))
                    .addComponent(searchroute, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(searchroute)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(from)
                    .addComponent(fromBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(to)
                    .addComponent(toBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchRoutesButt)
                    .addComponent(findBSLabel))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchRoutesButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchRoutesButtActionPerformed
        //JOptionPane.showMessageDialog(this, from);
        this.dispose();
        //new ResultView(Preferences).setVisible(true);
        this.guest.setJourney(departure, destination);
        this.guest.openResultView();
    }//GEN-LAST:event_searchRoutesButtActionPerformed

    private void findBSLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findBSLabelMouseClicked
        // TODO add your handling code here:
        this.dispose();
        this.guest.openFindBusStopView();
    }//GEN-LAST:event_findBSLabelMouseClicked

    private void fromBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fromBoxItemStateChanged
        //if(evt.getStateChange() == ItemEvent.SELECTED){
            this.departure = (String) fromBox.getSelectedItem();System.out.println(fromBox.getSelectedItem() + " " + departure);
        //}    
        redisplay();
        
    }//GEN-LAST:event_fromBoxItemStateChanged

    private void toBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toBoxItemStateChanged
        // to = (String) toBox.getSelectedItem();
        if(evt.getStateChange() == ItemEvent.SELECTED)
        this.destination= (String) toBox.getSelectedItem();
        //redisplay();
    }//GEN-LAST:event_toBoxItemStateChanged

    private void fromBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchRoutesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchRoutesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchRoutesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchRoutesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(new Runnable() {
            //public void run() {
                //new searchRoutesView().setVisible(true);
            //}
        //});
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel findBSLabel;
    private javax.swing.JLabel from;
    private javax.swing.JComboBox<String> fromBox;
    private javax.swing.JButton searchRoutesButt;
    private javax.swing.JLabel searchroute;
    private javax.swing.JLabel to;
    private javax.swing.JComboBox<String> toBox;
    // End of variables declaration//GEN-END:variables

    @Override
    public void apply() {
        if(this.guest.getSettings().getLanguage().equals("eng")){
            changeToEng();
        }        
        else if (this.guest.getSettings().getLanguage().equals("indo")){
            changeToIndo();
        }
        if(this.guest.getSettings().getColor().equals("pink")){
            changePink();
        }
        else if (this.guest.getSettings().getColor().equals("gray")){
            changeGray();
        }
        else{
            changeDefault();
        }
    }

    @Override
    public void changeToIndo() {
        searchroute.setText("CARI RUTE");
        from.setText("Dari");
        to.setText("Ke");
        findBSLabel.setText("Cari halte?");
        searchRoutesButt.setText("Cari");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeToEng() {
        searchroute.setText("SEARCH ROUTES");
        from.setText("From");
        to.setText("To");
        findBSLabel.setText("Find bus stop?");
        searchRoutesButt.setText("Search");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
    public void changePink() {
        this.getContentPane().setBackground(Color.pink);
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

}
