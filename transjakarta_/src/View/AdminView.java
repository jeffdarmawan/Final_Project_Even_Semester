/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.User;
import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wilson Fransicius
 */
public class AdminView extends javax.swing.JFrame {

    /**
     * Creates new form AdminView
     */
    Settings Preferences;    
    User guest;
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    int curRow = 0;
    String regex = "\\d*";
    String halte;
    
    public AdminView(Settings set) {
        this.Preferences=set;
        initComponents();
        connectDB();
        printTable();
        this.setLocationRelativeTo(null);
    }
    
    public AdminView(User guest) {
        this.guest=guest;
        initComponents();
        connectDB();
        printTable();
        this.setLocationRelativeTo(null);
    }
    
    public void printTable() {
        try {
            this.connectDB();
            DefaultTableModel dtm = new DefaultTableModel();
            rs = stmt.executeQuery("SELECT * FROM `tj`"); // Selecting all data from 'students' table
            ResultSetMetaData rmd = rs.getMetaData();
            int colTotal = rmd.getColumnCount();
            for (int i = 0; i < colTotal; i++) {
                dtm.addColumn(rmd.getColumnLabel(i + 1));
            }
            while (rs.next()) 
            {
                System.out.print("\n\n\n");
                Object[] object = new Object[colTotal];
                for (int i = 0; i < colTotal; i++) {
                    object[i] = rs.getObject(i + 1);
                    System.out.println(rs.getObject(i+1));
                }
                dtm.addRow(object);
                
            }
            jTable1.setModel(dtm); // Set the Table with fresh data
            //connector.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error! Can not connect to database. " + ex);
            System.exit(0);
        }
    }
    
    public final void connectDB(){
        try{
            //singleton
            con = ConnectionConfig.createConnection();
                    
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select * from tj";
            rs = stmt.executeQuery(query);
            rs.next();
            
        }catch(SQLException e){
            System.out.println(e);
            //JOptionPane.showMessageDialog(this, e.getMessage());
        }catch (ClassNotFoundException ex) {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
            //Logger.getLogger(JListFirstAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ConnectionConfig.closeConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        doneButt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        indexLabel = new javax.swing.JLabel();
        busStopLabel = new javax.swing.JLabel();
        corridorLabel = new javax.swing.JLabel();
        nearbyLabel = new javax.swing.JLabel();
        regionLabel = new javax.swing.JLabel();
        indexTxt = new javax.swing.JTextField();
        busStopTxt = new javax.swing.JTextField();
        corridorTxt = new javax.swing.JTextField();
        nearbyTxt = new javax.swing.JTextField();
        addButt = new javax.swing.JButton();
        updateButt = new javax.swing.JButton();
        deleteButt = new javax.swing.JButton();
        saveButt = new javax.swing.JButton();
        cancelButt = new javax.swing.JButton();
        regionTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        doneButt.setText("Log Out");
        doneButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Index", "Halte", "Corridor", "Nearby", "Region"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        indexLabel.setText("Index");

        busStopLabel.setText("Bus Stop");

        corridorLabel.setText("Corridor");

        nearbyLabel.setText("Nearby");

        regionLabel.setText("Region");

        indexTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indexTxtActionPerformed(evt);
            }
        });

        addButt.setText("Add");
        addButt.setMaximumSize(new java.awt.Dimension(94, 29));
        addButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtActionPerformed(evt);
            }
        });

        updateButt.setText("Update");
        updateButt.setMaximumSize(new java.awt.Dimension(94, 29));
        updateButt.setMinimumSize(new java.awt.Dimension(94, 29));
        updateButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtActionPerformed(evt);
            }
        });

        deleteButt.setText("Delete");
        deleteButt.setMaximumSize(new java.awt.Dimension(94, 29));
        deleteButt.setMinimumSize(new java.awt.Dimension(94, 29));
        deleteButt.setPreferredSize(new java.awt.Dimension(94, 29));
        deleteButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtActionPerformed(evt);
            }
        });

        saveButt.setText("Save");
        saveButt.setEnabled(false);
        saveButt.setMaximumSize(new java.awt.Dimension(94, 29));
        saveButt.setMinimumSize(new java.awt.Dimension(94, 29));
        saveButt.setPreferredSize(new java.awt.Dimension(94, 29));
        saveButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtActionPerformed(evt);
            }
        });

        cancelButt.setText("Cancel");
        cancelButt.setEnabled(false);
        cancelButt.setMaximumSize(new java.awt.Dimension(94, 29));
        cancelButt.setMinimumSize(new java.awt.Dimension(94, 29));
        cancelButt.setPreferredSize(new java.awt.Dimension(94, 29));
        cancelButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(indexLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(busStopLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(corridorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nearbyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(regionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(indexTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(busStopTxt)
                            .addComponent(corridorTxt)
                            .addComponent(nearbyTxt)
                            .addComponent(regionTxt))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButt, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateButt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(deleteButt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(saveButt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(doneButt)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(indexLabel)
                            .addComponent(indexTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(busStopLabel)
                            .addComponent(busStopTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(corridorLabel)
                            .addComponent(corridorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nearbyLabel)
                            .addComponent(nearbyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(regionLabel)
                            .addComponent(regionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveButt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doneButt)
                            .addComponent(cancelButt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtActionPerformed
        this.dispose();
        this.guest.openOpeningView();
    }//GEN-LAST:event_doneButtActionPerformed

    private void indexTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indexTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_indexTxtActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int a = jTable1.getSelectedRow();
        a = jTable1.convertRowIndexToModel(a);
        int index = Integer.valueOf(jTable1.getModel().getValueAt(a, 0).toString());
        String sIndex = Integer.toString(index);
        String busStop = (String) jTable1.getModel().getValueAt(a, 1);
        String corridor = (String) jTable1.getModel().getValueAt(a, 2);
        String nearby = (String) jTable1.getModel().getValueAt(a, 3);
        String region = (String) jTable1.getModel().getValueAt(a, 4);
        indexTxt.setText(sIndex);
        busStopTxt.setText(busStop);
        corridorTxt.setText(corridor);
        nearbyTxt.setText(nearby);
        regionTxt.setText(region);
        halte = (String) jTable1.getModel().getValueAt(a, 1);
        //indexTxt.setText(jTable1.getSelectedRow());
    }//GEN-LAST:event_jTable1MouseClicked

    private void addButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtActionPerformed
        try {
            // TODO add your handling code here:
            addButt.setEnabled(false);
            updateButt.setEnabled(false);
            deleteButt.setEnabled(false);
            doneButt.setEnabled(false);
            cancelButt.setEnabled(true);
            saveButt.setEnabled(true);
            curRow = rs.getRow();
            indexTxt.setText("");
            busStopTxt.setText("");
            corridorTxt.setText("");
            nearbyTxt.setText("");
            regionTxt.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addButtActionPerformed

    private void saveButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtActionPerformed
        // TODO add your handling code here:
        String sIndex = indexTxt.getText();
        String sBusStop = busStopTxt.getText();
        String sCorridor = corridorTxt.getText();
        String sNearby = nearbyTxt.getText();
        String sRegion = regionTxt.getText();
        Object[] row = {sIndex, sBusStop, sCorridor, sNearby, sRegion};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(row);
        jTable1.setModel(model);
        String addQuery = "insert into tj values(?,?,?,?,?)";
        try
        {
            PreparedStatement pstmt = con.prepareStatement(addQuery);
            
            //Index cannot contain letters
            if(!sIndex.matches(regex))
            {
                JOptionPane.showMessageDialog(this, "Index cannot contain letters");
            }
            //Index cannot be blank
            else if(sIndex.length()==0)
            {
                JOptionPane.showMessageDialog(this, "Index cannot be blank");
            }
            //validation suceed
            else
            {
                int newIndex = Integer.parseInt(sIndex);
                pstmt.setInt(1, newIndex); 
            }
            
            //Bus Stop cannot be blank
            if(sBusStop.length() == 0)
            {
                JOptionPane.showMessageDialog(this, "Bus Stop cannot be blank");
            }
            //validation succeed
            else
            {
                pstmt.setString(2, sBusStop); 
            }
            
            //corridor
            if(sCorridor.length()==0)
            {
                JOptionPane.showMessageDialog(this, "Corridor cannot be blank");
            }
            else
            {
                pstmt.setString(3, sCorridor);
            }
            
            //nearby
            if(sNearby.length() == 0)
            {
                JOptionPane.showMessageDialog(this, "Nearby cannot be blank");
            }
            //validation succeed
            else
            {
                pstmt.setString(4, sNearby);
            }
            
            //region
            if(sRegion.length() == 0)
            {
                JOptionPane.showMessageDialog(this, "Nearby cannot be blank");
            }
            //validation succeed
            else
            {
                pstmt.setString(5, sRegion);
            }
            pstmt.execute();
            
            addButt.setEnabled(true);
            updateButt.setEnabled(true);
            deleteButt.setEnabled(true);
            doneButt.setEnabled(true);
            cancelButt.setEnabled(false);
            saveButt.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Record added!");
            dispose();
            new AdminView(Preferences).setVisible(true);
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
        printTable();
    }//GEN-LAST:event_saveButtActionPerformed

    private void cancelButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtActionPerformed
        try {
            // TODO add your handling code here:
            //rs.absolute(curRow);
            rs.cancelRowUpdates();
            addButt.setEnabled(true);
            updateButt.setEnabled(true);
            deleteButt.setEnabled(true);
            doneButt.setEnabled(true);
            saveButt.setEnabled(false);
            cancelButt.setEnabled(false);
            
            //jTable1.setSelectionModel(curRow-1);
        } catch (SQLException ex) {
            Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_cancelButtActionPerformed

    private void deleteButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtActionPerformed
        // TODO add your handling code here:
        int a = jTable1.getSelectedRow();
        a = jTable1.convertRowIndexToModel(a);
        int index = Integer.valueOf(jTable1.getModel().getValueAt(a, 0).toString());
        String sIndex = Integer.toString(index);
        String busStop = (String) jTable1.getModel().getValueAt(a, 1);
        String corridor = (String) jTable1.getModel().getValueAt(a, 2);
        String nearby = (String) jTable1.getModel().getValueAt(a, 3);
        String region = (String) jTable1.getModel().getValueAt(a, 4);
        Object[] row = {sIndex, busStop, corridor, nearby, region};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(a);
        jTable1.setModel(model);
        
        String deleteQuery = "DELETE FROM tj WHERE halte = ?"; //+ busStop;
        try {
            PreparedStatement pstmt = con.prepareStatement(deleteQuery);
            pstmt.setString(1, busStop);
            pstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
        printTable();
        JOptionPane.showMessageDialog(this, "Record deleted!");
        
    }//GEN-LAST:event_deleteButtActionPerformed

    private void updateButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtActionPerformed
        try {
            // TODO add your handling code here:
            int a = jTable1.getSelectedRow();
            a = jTable1.convertRowIndexToModel(a);
            //get value
            int index = Integer.valueOf(jTable1.getModel().getValueAt(a, 0).toString());
            String sIndex = Integer.toString(index);
            String busStop = (String) jTable1.getModel().getValueAt(a, 1);
            String corridor = (String) jTable1.getModel().getValueAt(a, 2);
            String nearby = (String) jTable1.getModel().getValueAt(a, 3);
            String region = (String) jTable1.getModel().getValueAt(a, 4);
            //Object[] row = {sIndex, busStop, corridor, nearby, region};
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setValueAt(sIndex, a, 0);
            model.setValueAt(busStop, a, 1);
            model.setValueAt(corridor, a, 2);
            model.setValueAt(nearby, a, 3);
            model.setValueAt(region, a, 4);
            jTable1.setModel(model);
            
            stmt.executeUpdate("UPDATE tj SET indx = " + indexTxt.getText() + ", halte = '" + busStopTxt.getText() + "', corridor = '" + corridorTxt.getText() + "', nearby = '" + nearbyTxt.getText() + "', region = '" + regionTxt.getText() + "' WHERE halte = '" + busStop +"'");
           
        } catch (SQLException ex) {
            Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
        printTable();
    }//GEN-LAST:event_updateButtActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButt;
    private javax.swing.JLabel busStopLabel;
    private javax.swing.JTextField busStopTxt;
    private javax.swing.JButton cancelButt;
    private javax.swing.JLabel corridorLabel;
    private javax.swing.JTextField corridorTxt;
    private javax.swing.JButton deleteButt;
    private javax.swing.JButton doneButt;
    private javax.swing.JLabel indexLabel;
    private javax.swing.JTextField indexTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nearbyLabel;
    private javax.swing.JTextField nearbyTxt;
    private javax.swing.JLabel regionLabel;
    private javax.swing.JTextField regionTxt;
    private javax.swing.JButton saveButt;
    private javax.swing.JButton updateButt;
    // End of variables declaration//GEN-END:variables
}
