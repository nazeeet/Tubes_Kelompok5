package tugas_besar_it.pkg45.pkg01;

import Database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

public class AdminView extends javax.swing.JFrame {
    ArrayList<Matkul> matkul = new ArrayList<>();
    ArrayList<User> user = new ArrayList<>();
    
    

    public AdminView() {
        initComponents();
        GetListMatkul();
        IsiListMatkul();
        GetListUser();
        IsiListUser();

        jList1.addListSelectionListener((ListSelectionEvent e) -> {
            if (!matkul.isEmpty() && jList1.getSelectedIndex() >= 0 && jList1.getSelectedIndex() < matkul.size()) {
                kodeMK.setText("Kode Matkul :            " + matkul.get(jList1.getSelectedIndex()).getKodematkul() + "");
                nmMK.setText("Nama Matkul :          " + matkul.get(jList1.getSelectedIndex()).getNamamatkul() + "");
            }
        });
        
        jList2.addListSelectionListener((ListSelectionEvent e) -> {
            if (!user.isEmpty() && jList2.getSelectedIndex() >= 0 && jList2.getSelectedIndex() < user.size()) {
                nmUser.setText("Nama User :            " + user.get(jList2.getSelectedIndex()).getNama() + "");
                role.setText("Role :          " + user.get(jList2.getSelectedIndex()).getRole() + "");
            }
        });
    }

        
    public void IsiListMatkul(){
        String[] nmMK = new String[matkul.size()];
        for (int i = 0; i < matkul.size(); i++) {
           nmMK[i] = matkul.get(i).getKodematkul();
        }
        jList1.setListData(nmMK);
    }

    public void GetListMatkul(){
        try {
            Database db = new Database();
            db.connect();
            String query = "SELECT * FROM matkul";
            ResultSet rs = db.getData(query);

            matkul.clear();
            while(rs.next()){
                matkul.add(new Matkul(rs.getString("kode_matkul"), rs.getString("nama_matkul")));
            }
            
            db.disconnect();
                    
        } catch (SQLException ex) {
            Logger.getLogger(DosenView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void IsiListUser(){
        String[] nmUser = new String[user.size()];
        for (int i = 0; i < user.size(); i++) {
            nmUser[i] = user.get(i).getNama();
        }
        jList2.setListData(nmUser);
    }

    public void GetListUser(){
        try {
            Database db = new Database();
            db.connect();
            String query = "SELECT * FROM user";
            ResultSet rs = db.getData(query);

            user.clear();
            while(rs.next()){
                user.add(new User(rs.getString("id"), rs.getString("nama"), rs.getString("email"), rs.getString("password"), rs.getString("role")));
            }
            
            db.disconnect();
                    
        } catch (SQLException ex) {
            Logger.getLogger(DosenView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DeleteMatkul() {
        Database db = new Database();

        try {
            db.connect();

            // Ganti query dengan menghapus parameter selectedIndex
            String query = "DELETE FROM `matkul` WHERE `matkul`.`kode_matkul` = '"
                    + matkul.get(jList1.getSelectedIndex()).getKodematkul() + "';";

            System.out.println(query);  // Tampilkan query untuk debug

            db.update(query);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteUser() {
        Database db = new Database();

        try {
            db.connect();

            // Ganti query dengan menghapus parameter selectedIndex
            String query = "DELETE FROM `user` WHERE `user`.`id` = '"
                    + user.get(jList2.getSelectedIndex()).getId() + "';";

            System.out.println(query);  // Tampilkan query untuk debug

            db.update(query);
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNama = new javax.swing.JLabel();
        logoutbutton = new javax.swing.JButton();
        hapusMatkul = new javax.swing.JButton();
        hapusUser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        kodeMK = new javax.swing.JLabel();
        nmMK = new javax.swing.JLabel();
        nmUser = new javax.swing.JLabel();
        role = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNama.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelNama.setText("Welcome, Admin!");

        logoutbutton.setText("Logout");
        logoutbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbuttonActionPerformed(evt);
            }
        });

        hapusMatkul.setText("Hapus Matkul");
        hapusMatkul.setToolTipText("");
        hapusMatkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusMatkulActionPerformed(evt);
            }
        });

        hapusUser.setText("Hapus User");
        hapusUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusUserActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        kodeMK.setText("Kode Matkul :");

        nmMK.setText("Nama Matkul :");

        nmUser.setText("Nama :");

        role.setText("Role :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelNama)
                        .addGap(441, 441, 441)
                        .addComponent(logoutbutton)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kodeMK)
                            .addComponent(nmMK)
                            .addComponent(hapusMatkul))
                        .addGap(239, 239, 239)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nmUser)
                            .addComponent(role)
                            .addComponent(hapusUser, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(217, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(logoutbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(labelNama)))
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kodeMK)
                        .addGap(39, 39, 39)
                        .addComponent(nmMK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapusMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nmUser)
                        .addGap(38, 38, 38)
                        .addComponent(role)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapusUser, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hapusUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusUserActionPerformed
        if(jList2.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "Error! Pilih User terlebih dahulu!");
        } else {
            DeleteUser();
            this.dispose();
            AdminView adm = new AdminView();
            adm.setVisible(true);
            JOptionPane.showMessageDialog(this, "User berhasil dihapus dari database");
        }
    }//GEN-LAST:event_hapusUserActionPerformed

    private void hapusMatkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusMatkulActionPerformed
        if(jList1.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "Error! Pilih Mata Kuliah terlebih dahulu!");
        } else {
            DeleteMatkul();
            this.dispose();
            AdminView adm = new AdminView();
            adm.setVisible(true);
            JOptionPane.showMessageDialog(this, "Mata Kuliah berhasil dihapus dari database");
        }
    }//GEN-LAST:event_hapusMatkulActionPerformed

    private void logoutbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbuttonActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();   
    }//GEN-LAST:event_logoutbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapusMatkul;
    private javax.swing.JButton hapusUser;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kodeMK;
    private javax.swing.JLabel labelNama;
    private javax.swing.JButton logoutbutton;
    private javax.swing.JLabel nmMK;
    private javax.swing.JLabel nmUser;
    private javax.swing.JLabel role;
    // End of variables declaration//GEN-END:variables
}
