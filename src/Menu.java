/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import javax.swing.JFrame;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.StringTokenizer;
import java.util.Locale;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;
public class Menu extends javax.swing.JFrame {

public boolean databaru;
private void getData(){
    try{
        java.sql.Connection conn=(java.sql.Connection)koneksi.koneksi.getKoneksi();
        java.sql.Statement stm=conn.createStatement();
        java.sql.ResultSet sql = stm.executeQuery("select * from tb_makanan");
        tabelmenu.setModel(DbUtils.resultSetToTableModel(sql));
        java.sql.ResultSet sql1 = stm.executeQuery("SELECT * FROM tb_minuman");
        tabelmenu2.setModel(DbUtils.resultSetToTableModel(sql1));
    }catch(Exception e){
        
    }
}
    public Menu() {
        initComponents();
         setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        btntambahmakanan = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelmenu = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        hpsmakanan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelmenu2 = new javax.swing.JTable();
        btntambahminuman = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        hpsminuman = new javax.swing.JButton();
        updatamakanan = new javax.swing.JButton();
        updateminuman = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAMA             :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("HARGA            :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });
        getContentPane().add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 470, 30));
        getContentPane().add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 470, 29));

        btntambahmakanan.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btntambahmakanan.setForeground(new java.awt.Color(51, 51, 51));
        btntambahmakanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tambah.png"))); // NOI18N
        btntambahmakanan.setText("Tambah Makanan");
        btntambahmakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahmakananActionPerformed(evt);
            }
        });
        getContentPane().add(btntambahmakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, -1, -1));

        btncancel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btncancel.setForeground(new java.awt.Color(51, 51, 51));
        btncancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset.png"))); // NOI18N
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        getContentPane().add(btncancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1001, 370, 150, 40));

        tabelmenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama Makanan", "Harga"
            }
        ));
        tabelmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelmenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelmenu);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 520, 120));

        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/keluar.png"))); // NOI18N
        jButton3.setText("Kembali");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1027, 660, 140, 40));

        hpsmakanan.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        hpsmakanan.setForeground(new java.awt.Color(51, 51, 51));
        hpsmakanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        hpsmakanan.setText("Hapus Makanan");
        hpsmakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpsmakananActionPerformed(evt);
            }
        });
        getContentPane().add(hpsmakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 660, -1, 40));

        tabelmenu2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama Minuman", "Harga"
            }
        ));
        tabelmenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelmenu2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelmenu2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 500, 520, 120));

        btntambahminuman.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btntambahminuman.setForeground(new java.awt.Color(51, 51, 51));
        btntambahminuman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tambah.png"))); // NOI18N
        btntambahminuman.setText("Tambah Minuman");
        btntambahminuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahminumanActionPerformed(evt);
            }
        });
        getContentPane().add(btntambahminuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 660, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/banner-removebg-preview.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, 90));

        hpsminuman.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        hpsminuman.setForeground(new java.awt.Color(51, 51, 51));
        hpsminuman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        hpsminuman.setText("Hapus Minuman");
        hpsminuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpsminumanActionPerformed(evt);
            }
        });
        getContentPane().add(hpsminuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 660, -1, 40));

        updatamakanan.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        updatamakanan.setForeground(new java.awt.Color(51, 51, 51));
        updatamakanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/create.png"))); // NOI18N
        updatamakanan.setText("Edit Makanan");
        updatamakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatamakananActionPerformed(evt);
            }
        });
        getContentPane().add(updatamakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 250, 150, 40));

        updateminuman.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        updateminuman.setForeground(new java.awt.Color(51, 51, 51));
        updateminuman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/create.png"))); // NOI18N
        updateminuman.setText("Edit Minuman");
        updateminuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateminumanActionPerformed(evt);
            }
        });
        getContentPane().add(updateminuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 310, 150, 40));

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1330, 720));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wl.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
     txtnama.setText("");
     txtharga.setText("");
    }//GEN-LAST:event_btncancelActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new Home().show();
                    this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabelmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelmenuMouseClicked
try {
            int row = tabelmenu.getSelectedRow();
            String tabel_klik =(tabelmenu.getModel().getValueAt(row, 0)).toString();
            java.sql.Connection conn =(java.sql.Connection)koneksi.koneksi.getKoneksi();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet sql2 = stm.executeQuery("SELECT * FROM tb_makanan WHERE nama_makanan='");

            if(sql2.next()){
                String nama_minuman = sql2.getNString("nama_makanan");
                txtnama.getText();
                String harga = sql2.getNString("harga");
                txtharga.getText();
            }

        }   catch (Exception e) {

        }
    }//GEN-LAST:event_tabelmenuMouseClicked

    private void btntambahmakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahmakananActionPerformed
        try{
             String sql = "insert into tb_makanan values('"+txtnama.getText()+"','"+txtharga.getText()+"')";
             java.sql.Connection conn = (java.sql.Connection)koneksi.koneksi.getKoneksi();
             java.sql.PreparedStatement pst = conn.prepareStatement(sql);
             pst.execute();
             JOptionPane.showMessageDialog(null, "BERHASIL DISIMPAN");
             txtnama.setText("");
             txtharga.setText("");
             getData();
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btntambahmakananActionPerformed

    private void btntambahminumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahminumanActionPerformed
 try{
             String sql1 = "insert into tb_minuman values('"+txtnama.getText()+"','"+txtharga.getText()+"')";
             java.sql.Connection conn = (java.sql.Connection)koneksi.koneksi.getKoneksi();
             java.sql.PreparedStatement pst = conn.prepareStatement(sql1);
             pst.execute();
             JOptionPane.showMessageDialog(null, "BERHASIL DISIMPAN");
             txtnama.setText("");
             txtharga.setText("");
             getData();
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btntambahminumanActionPerformed

    private void tabelmenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelmenu2MouseClicked
        try {
            int row = tabelmenu2.getSelectedRow();
            String tabel_klik =(tabelmenu2.getModel().getValueAt(row, 0)).toString();
            java.sql.Connection conn =(java.sql.Connection)koneksi.koneksi.getKoneksi();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet sql2 = stm.executeQuery("SELECT * FROM tb_minuman WHERE nama_minuman='");

            if(sql2.next()){
                String nama_minuman = sql2.getNString("nama_minuman");
                txtnama.getText();
                String harga = sql2.getNString("harga");
                txtharga.getText();
            }

        }   catch (Exception e) {

        }

    }//GEN-LAST:event_tabelmenu2MouseClicked

    private void hpsmakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpsmakananActionPerformed
         try{
        String sql = "DELETE FROM tb_makanan WHERE nama_makanan='"+txtnama.getText()+"'";
        java.sql.Connection conn= (java.sql.Connection)koneksi.koneksi.getKoneksi();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(null, "Berhasil Menghapus Makanan");
        databaru = true;
        txtnama.setText("");
        txtharga.setText("");
    }catch(SQLException | HeadlessException e){
        
    }
    getData();
    }//GEN-LAST:event_hpsmakananActionPerformed

    private void hpsminumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpsminumanActionPerformed
        try{
            String sql1 = "DELETE FROM tb_minuman WHERE nama_minuman='"+txtnama.getText()+"'";
            java.sql.Connection con=(java.sql.Connection)koneksi.koneksi.getKoneksi();
            java.sql.PreparedStatement pst1= con.prepareStatement(sql1);
            pst1.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Menghapus Minuman");
            databaru = true;
            txtnama.setText("");
            txtharga.setText("");
        }catch(SQLException | HeadlessException e){
            
        }
        getData();
    }//GEN-LAST:event_hpsminumanActionPerformed

    private void updatamakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatamakananActionPerformed
        try{
            String sql="update tb_makanan set harga='"+ txtharga.getText()+"' where nama_makanan='"+ txtnama.getText() +"'";
            java.sql.Connection conn=(java.sql.Connection)koneksi.koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Berhasil diedit");
            databaru = true;
            txtnama.setText("");
            txtharga.setText("");
            getData();
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Gagal Update");
        }
    }//GEN-LAST:event_updatamakananActionPerformed

    private void updateminumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateminumanActionPerformed
        try{
            String sql1="update tb_minuman set harga='"+ txtharga.getText()+"' where nama_minuman='"+ txtnama.getText() +"'";
            java.sql.Connection con=(java.sql.Connection)koneksi.koneksi.getKoneksi();
            java.sql.PreparedStatement pst = con.prepareStatement(sql1);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Berhasil diedit");
            databaru = true;
            txtnama.setText("");
            txtharga.setText("");
            getData();
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Gagal Update");
        }
    }//GEN-LAST:event_updateminumanActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btntambahmakanan;
    private javax.swing.JButton btntambahminuman;
    private javax.swing.JButton hpsmakanan;
    private javax.swing.JButton hpsminuman;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelmenu;
    private javax.swing.JTable tabelmenu2;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtnama;
    private javax.swing.JButton updatamakanan;
    private javax.swing.JButton updateminuman;
    // End of variables declaration//GEN-END:variables
}
