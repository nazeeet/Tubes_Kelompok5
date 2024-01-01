package tugas_besar_it.pkg45.pkg01;

import Database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

public class MahasiswaView extends javax.swing.JFrame {
    ArrayList<Kuis> kuis = new ArrayList<>();
    Mahasiswa mhs = new Mahasiswa("Tasya");


    public MahasiswaView() {
        initComponents();
        GetList();
        IsiList();
        
        jLabel1.setText("Hello, " + mhs.getNama() + "!") ;
        
        
        
        jList1.addListSelectionListener((ListSelectionEvent e) -> {
            if (!kuis.isEmpty() && jList1.getSelectedIndex() >= 0 && jList1.getSelectedIndex() < kuis.size()) {
                idKuis.setText("ID Kuis :              " + kuis.get(jList1.getSelectedIndex()).getKodekuis() + "");
                idMatkul.setText("ID Matkul :          " + kuis.get(jList1.getSelectedIndex()).getKodematkul() + "");
                namaKuis.setText("Nama Kuis :      " + kuis.get(jList1.getSelectedIndex()).getNamakuis() + "");
            }
        });
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
    
    private void storeRandomScore(int randomScore) {
        Database db = new Database();
        
        try { 
            db.connect();


            String selectedQuizID = kuis.get(jList1.getSelectedIndex()).getKodekuis();

            String updateQuery = "UPDATE kuis SET nilai_kuis = '" + randomScore + "' WHERE id_kuis = '" + selectedQuizID + "'";

            db.update(updateQuery);
            db.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        idKuis = new javax.swing.JLabel();
        idMatkul = new javax.swing.JLabel();
        namaKuis = new javax.swing.JLabel();
        Attempt = new javax.swing.JButton();
        NilaiFrame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Hello,");

        jLabel2.setText("Dashboard ");

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        idKuis.setText("ID Kuis :");

        idMatkul.setText("ID Matkul :");

        namaKuis.setText("Nama Kuis : ");

        Attempt.setText("Attempt Quiz");
        Attempt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttemptActionPerformed(evt);
            }
        });

        NilaiFrame.setText("Akumulasi Nilai");
        NilaiFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NilaiFrameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(idMatkul, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idKuis, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(namaKuis, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Attempt)
                                        .addGap(134, 134, 134))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(NilaiFrame)
                                        .addContainerGap())))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idKuis)
                        .addGap(47, 47, 47)
                        .addComponent(idMatkul)
                        .addGap(49, 49, 49)
                        .addComponent(namaKuis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Attempt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NilaiFrame)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();         
    }//GEN-LAST:event_LogoutActionPerformed

    private void AttemptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttemptActionPerformed
                
        if(jList1.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "Error! Pilih kuis terlebih dahulu!");
            
        
        } else {
            int randomScore = (int) (Math.random() * 101);
            JOptionPane.showMessageDialog(this, "Your score is: " + randomScore, "Score", JOptionPane.INFORMATION_MESSAGE);
            storeRandomScore(randomScore);
            this.dispose();
            MahasiswaView mhs = new MahasiswaView();
            mhs.setVisible(true);
        }
    }//GEN-LAST:event_AttemptActionPerformed

    private void NilaiFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NilaiFrameActionPerformed
        NilaiFrame nilaiFrame = new NilaiFrame();
        nilaiFrame.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_NilaiFrameActionPerformed

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
            java.util.logging.Logger.getLogger(MahasiswaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MahasiswaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Attempt;
    private javax.swing.JButton Logout;
    private javax.swing.JButton NilaiFrame;
    private javax.swing.JLabel idKuis;
    private javax.swing.JLabel idMatkul;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel namaKuis;
    // End of variables declaration//GEN-END:variables
}
