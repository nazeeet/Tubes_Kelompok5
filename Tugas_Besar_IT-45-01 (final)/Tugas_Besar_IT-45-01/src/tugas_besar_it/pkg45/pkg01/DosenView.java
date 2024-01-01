package tugas_besar_it.pkg45.pkg01;

import Database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;


public class DosenView extends javax.swing.JFrame {
    ArrayList<Kuis> kuis = new ArrayList<>();
    
    public DosenView() {
        initComponents();
        GetList();
        IsiList();
        
        jList1.addListSelectionListener(((ListSelectionEvent e) -> {
        idKuis.setText(kuis.get(jList1.getSelectedIndex()).getKodekuis()+ "");
        idMatkul.setText(kuis.get(jList1.getSelectedIndex()).getKodematkul()+ "");
        namaKuis.setText(kuis.get(jList1.getSelectedIndex()).getNamakuis() + "");
        nilaiKuis.setText(kuis.get(jList1.getSelectedIndex()).getNilaikuis() + "");
        }));
    }
    
    public void IsiList(){
        String[] nmKuis = new String[kuis.size()];
        for (int i = 0; i < kuis.size(); i++) {
            nmKuis[i] = kuis.get(i).getNamakuis();
        }
        jList1.setListData(nmKuis);
    }

    public void GetList(){
        try {
            Database db = new Database();
            db.connect();
            String query = "SELECT * FROM kuis";
            ResultSet rs = db.getData(query);

            kuis.clear();
            while(rs.next()){
                kuis.add(new Kuis(rs.getString("id_kuis"), rs.getString("id_matkul"), rs.getString("nama_kuis"), rs.getString("nilai_kuis")));
            }
            
            db.disconnect();
                    
        } catch (SQLException ex) {
            Logger.getLogger(DosenView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UploadKuis() {
        Database db = new Database();

        try {
            db.connect();
            String query = "INSERT INTO `kuis` SET `id_kuis` = '" + idKuis.getText() + "', `id_matkul` = '"
                    + idMatkul.getText() + "', `nama_kuis` = '" + namaKuis.getText() +  "', `nilai_kuis` = '" + nilaiKuis.getText() + "';";

            System.out.println(query); 

            db.update(query);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EditKuis() {
        Database db = new Database();

        try {
            db.connect();
            String query = "UPDATE `kuis` SET `id_kuis` = '" + idKuis.getText() + "', `id_matkul` = '"
                    + idMatkul.getText() + "', `nama_kuis` = '" + namaKuis.getText() + "', `nilai_kuis` = '" + nilaiKuis.getText() + "' WHERE `kuis`.`id_kuis` = '"
                    + kuis.get(jList1.getSelectedIndex()).getKodekuis() + "';";

            System.out.println(query);  
            db.update(query);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     
    public void DeleteKuis() {
        Database db = new Database();

        try {
            db.connect();

           
            String query = "DELETE FROM `kuis` WHERE `kuis`.`id_kuis` = '"
                    + kuis.get(jList1.getSelectedIndex()).getKodekuis() + "';";

            System.out.println(query);  

            db.update(query);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idKuis = new javax.swing.JTextField();
        namaKuis = new javax.swing.JTextField();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        idMatkul = new javax.swing.JTextField();
        upload = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nilaiKuis = new javax.swing.JTextField();
        LogoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Hello, Dosen!");
        jLabel1.setToolTipText("");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel2.setText("ID Kuis :");

        jLabel4.setText("Nama Kuis :");

        idKuis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idKuisActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel3.setText("ID Matkul :");

        upload.setText("Upload");
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });

        jLabel5.setText("Nilai Kuis: ");

        nilaiKuis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nilaiKuisActionPerformed(evt);
            }
        });

        LogoutBtn.setText("Logout");
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LogoutBtn)
                                .addGap(30, 30, 30))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(idMatkul)
                                            .addComponent(namaKuis)
                                            .addComponent(idKuis)
                                            .addComponent(nilaiKuis))))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(delete)
                        .addGap(100, 100, 100))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(upload, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(idKuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(idMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(namaKuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nilaiKuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edit)
                            .addComponent(delete))
                        .addGap(45, 45, 45)))
                .addGap(20, 20, 20)
                .addComponent(upload, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idKuisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idKuisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idKuisActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if(jList1.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "Error! Pilih kuis terlebih dahulu!");
        } else {
            DeleteKuis();
            this.dispose();
            DosenView dsn = new DosenView();
            dsn.setVisible(true);
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus dari database");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
  
        if(jList1.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "Error! Pilih kuis terlebih dahulu!");
        }else if (idKuis.getText().isEmpty() || idMatkul.getText().isEmpty() || namaKuis.getText().isEmpty() || nilaiKuis.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error! Isi semua data!");
        }else {
            EditKuis();
            this.dispose();
            DosenView dsn = new DosenView();
            dsn.setVisible(true);
            JOptionPane.showMessageDialog(this, "Data berhasil di-update di database");
        }  
    }//GEN-LAST:event_editActionPerformed

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
        if (idKuis.getText().isEmpty() || idMatkul.getText().isEmpty() || namaKuis.getText().isEmpty() || nilaiKuis.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error! Isi semua data!");
        } else {
            UploadKuis();
            this.dispose();
            DosenView dsn = new DosenView();
            dsn.setVisible(true);
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan ke database");
        }
    }//GEN-LAST:event_uploadActionPerformed

    private void nilaiKuisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nilaiKuisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nilaiKuisActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();  
    }//GEN-LAST:event_LogoutBtnActionPerformed

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
            java.util.logging.Logger.getLogger(DosenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DosenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DosenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DosenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DosenView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTextField idKuis;
    private javax.swing.JTextField idMatkul;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namaKuis;
    private javax.swing.JTextField nilaiKuis;
    private javax.swing.JButton upload;
    // End of variables declaration//GEN-END:variables

}
