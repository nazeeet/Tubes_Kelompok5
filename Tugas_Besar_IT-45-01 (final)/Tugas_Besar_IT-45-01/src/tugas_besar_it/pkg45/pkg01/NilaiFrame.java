package tugas_besar_it.pkg45.pkg01;

import Database.Database;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;

public class NilaiFrame extends javax.swing.JFrame {
    ArrayList<Matkul> matkul = new ArrayList<>();
    ArrayList<Kuis> kuis = new ArrayList<>();
    
    public NilaiFrame() {
        initComponents();
        GetList();
        displayKodeMatkulList();
        
        jList1.addListSelectionListener((ListSelectionEvent e) -> {
            if (!matkul.isEmpty() && jList1.getSelectedIndex() >= 0 && jList1.getSelectedIndex() < matkul.size()) {
                String selectedKodeMatkul = matkul.get(jList1.getSelectedIndex()).getKodematkul();
                kodeMatkul.setText("Kode Matkul :            " + matkul.get(jList1.getSelectedIndex()).getKodematkul() + "");
                namaMatkul.setText("Nama Matkul :          " + matkul.get(jList1.getSelectedIndex()).getNamamatkul() + "");
                
                // Hitung akumulasi nilai
                double totalAkumulasi = akumulasiNilai(selectedKodeMatkul);
                akumulasi.setText("Akumulasi Nilai :        " + totalAkumulasi);
            }
        });
    }
    

    public void GetList(){
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
        
    private void displayKodeMatkulList() {
        try {
            Database db = new Database();
            db.connect();
            DefaultListModel<String> kodeMatkulListModel = new DefaultListModel<>();

            String query = "SELECT DISTINCT kode_matkul FROM matkul"; // Assuming kodematkul is a column in your kuis table
            ResultSet rs = db.getData(query);

            while (rs.next()) {
                kodeMatkulListModel.addElement(rs.getString("kode_matkul"));
            }

            jList1.setModel(kodeMatkulListModel);

            db.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(NilaiFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
    public double akumulasiNilai(String kodeMatkul) {
        double totalAkumulasi = 0;

     
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/pbo", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT AVG(nilai_kuis) AS total_akumulasi FROM kuis WHERE  id_matkul = ?")) {

   
            preparedStatement.setString(1, kodeMatkul);


            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
   
                    totalAkumulasi = resultSet.getDouble("total_akumulasi");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedAkumulasi = decimalFormat.format(totalAkumulasi);


        return Double.parseDouble(formattedAkumulasi);
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        kodeMatkul = new javax.swing.JLabel();
        namaMatkul = new javax.swing.JLabel();
        akumulasi = new javax.swing.JLabel();
        OK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Akumulasi Nilai Mahasiswa");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        kodeMatkul.setText("Kode Matkul :");

        namaMatkul.setText("Nama Matkul :");

        akumulasi.setText("Akumulasi Nilai :");

        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kodeMatkul)
                            .addComponent(namaMatkul)
                            .addComponent(akumulasi))
                        .addContainerGap(322, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OK)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(kodeMatkul)
                                .addGap(53, 53, 53)
                                .addComponent(namaMatkul)
                                .addGap(62, 62, 62)
                                .addComponent(akumulasi)))))
                .addGap(0, 21, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        MahasiswaView mhs = new MahasiswaView();
        mhs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_OKActionPerformed

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
            java.util.logging.Logger.getLogger(NilaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NilaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NilaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NilaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NilaiFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OK;
    private javax.swing.JLabel akumulasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kodeMatkul;
    private javax.swing.JLabel namaMatkul;
    // End of variables declaration//GEN-END:variables

}
