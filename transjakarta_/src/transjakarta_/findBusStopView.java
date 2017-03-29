/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transjakarta_;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Mikha Putri
 */
public class findBusStopView extends javax.swing.JFrame {

    /**
     * Creates new form findBusStopView
     */
    
    String languages;
    public findBusStopView() {
        this.languages="english";
        initComponents();
        display();
        this.setLocationRelativeTo(null);
    }
    
    public findBusStopView(String language) {
        this.languages = language;
        initComponents();
        display();
        this.setLocationRelativeTo(null);
    }
    
    public void display(){
        if(languages.equals("indo")){
            String[] a = {"Jakarta Pusat", "Jakarta Barat", "Jakarta Utara", "Jakarta Timur", "Jakarta Selatan"};
            regionBox.setModel(new DefaultComboBoxModel(a));
            regionBox.setSelectedIndex(0);
            titleLabel.setText("LOKASI SEKARANG");
            regionLabel.setText("Wilayah");
            nearbyLabel.setText("Tempat Terdekat");
            nearestLabel.setText("Halte Terdekat");
            findBSButt.setText("Cari");
            searchRoutesButt.setText("Cari Rute");            
        } else{
            regionBox.setSelectedIndex(0);
            titleLabel.setText("CURRENT LOCATION");
            regionLabel.setText("Region");
            nearbyLabel.setText("Nearby Place");            
            nearestLabel.setText("Nearest Bus Stop");
            findBSButt.setText("Find");
            searchRoutesButt.setText("Search Routes");            
            }
            displayNearby();
        
    }
   
    public void displayNearby(){
        if(languages.equals("indo")){
            System.out.println(regionBox.getSelectedItem());
            String weh = (String)regionBox.getSelectedItem();
                if(weh.equals("Jakarta Pusat"))
                    weh = "Central Jakarta";
                else if(weh.equals("Jakarta Barat"))
                    weh = "West Jakarta";
                else if(weh.equals("Jakarta Timur"))
                    weh = "East Jakarta";
                else if(weh.equals("Jakarta Selatan"))
                    weh = "South Jakarta";
                else if(weh.equals("Jakarta Utara"))
                    weh = "North Jakarta";
            findLoc user = new findLoc();
            ArrayList<String> abcdefghi = user.getNearby(weh);
            String[] abc = abcdefghi.toArray(new String[abcdefghi.size()]);
            //System.out.println(abc[0]);
            nearbyBox.setModel(new DefaultComboBoxModel(abc));
        } else {
            String weh = (String)regionBox.getSelectedItem();
            findLoc user = new findLoc();
            ArrayList<String> abcdefghi = user.getNearby(weh);
            String[] abc = abcdefghi.toArray(new String[abcdefghi.size()]);
            //System.out.println(abc[0]);
            nearbyBox.setModel(new DefaultComboBoxModel(abc));
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

        titleLabel = new javax.swing.JLabel();
        regionLabel = new javax.swing.JLabel();
        regionBox = new javax.swing.JComboBox<>();
        nearbyLabel = new javax.swing.JLabel();
        nearbyBox = new javax.swing.JComboBox<>();
        findBSButt = new javax.swing.JButton();
        nearestLabel = new javax.swing.JLabel();
        nearestBSLabel = new javax.swing.JLabel();
        searchRoutesButt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setText("CURRENT LOCATION");

        regionLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        regionLabel.setText("Region");

        regionBox.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        regionBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Central Jakarta", "North Jakarta", "South Jakarta", "East Jakarta", "West Jakarta" }));
        regionBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                regionBoxItemStateChanged(evt);
            }
        });

        nearbyLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        nearbyLabel.setText("Nearby Place");

        nearbyBox.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        findBSButt.setText("Find");
        findBSButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findBSButtActionPerformed(evt);
            }
        });

        nearestLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        nearestLabel.setText("Nearest Bus Stop: ");

        nearestBSLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N

        searchRoutesButt.setText("Search Routes");
        searchRoutesButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRoutesButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nearestLabel)
                                .addGap(38, 38, 38)
                                .addComponent(nearestBSLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(titleLabel))
                        .addContainerGap(133, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(searchRoutesButt))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(regionLabel)
                                    .addComponent(nearbyLabel))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(regionBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nearbyBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(findBSButt)))
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regionLabel)
                    .addComponent(regionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nearbyLabel)
                    .addComponent(nearbyBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findBSButt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nearestLabel)
                    .addComponent(nearestBSLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(searchRoutesButt)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findBSButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findBSButtActionPerformed
        // TODO add your handling code here:
        String region = (String) regionBox.getSelectedItem();
            if(region.equals("Jakarta Pusat"))
                region = "Central Jakarta";
            else if(region.equals("Jakarta Barat"))
                region = "West Jakarta";
            else if(region.equals("Jakarta Timur"))
                region = "East Jakarta";
            else if(region.equals("Jakarta Selatan"))
                region = "South Jakarta";
            else if(region.equals("Jakarta Utara"))
                region = "North Jakarta";
        String nearby = (String) nearbyBox.getSelectedItem();
       
        findLoc user = new findLoc(region, nearby);
        nearestBSLabel.setText(user.getBusStop());
    }//GEN-LAST:event_findBSButtActionPerformed

    private void regionBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_regionBoxItemStateChanged
        // TODO add your handling code here:
        displayNearby();
    }//GEN-LAST:event_regionBoxItemStateChanged

    private void searchRoutesButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchRoutesButtActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new searchRoutesView(languages, nearestBSLabel.getText()).setVisible(true);
    }//GEN-LAST:event_searchRoutesButtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton findBSButt;
    private javax.swing.JComboBox<String> nearbyBox;
    private javax.swing.JLabel nearbyLabel;
    private javax.swing.JLabel nearestBSLabel;
    private javax.swing.JLabel nearestLabel;
    private javax.swing.JComboBox<String> regionBox;
    private javax.swing.JLabel regionLabel;
    private javax.swing.JButton searchRoutesButt;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
