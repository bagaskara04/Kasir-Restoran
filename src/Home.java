
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
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;


public class Home extends javax.swing.JFrame {

public boolean databaru;

private void GetData(){
    try{
        java.sql.Connection conn=(java.sql.Connection)koneksi.koneksi.getKoneksi();
        java.sql.Statement stm=conn.createStatement();
        java.sql.ResultSet sql = stm.executeQuery("select * from kasir");
        Tableinfo.setModel(DbUtils.resultSetToTableModel(sql));
    }catch(Exception e){
        
    }
}

String pilihan = "";
int harga_makanan,harga_minuman;
int jml_bayar;
int bayar,beli,beli2,harga,harga2;
HashMap param = new HashMap();
JasperReport JasRep;
JasperPrint Jaspri;
JasperDesign JasDes;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        GetData();
        tampil_combominuman();
        tampil_combomakanan();
        tampil_makanan();
        tampil_minuman();
        id_transaksi();        
        databaru=true;
        setLocationRelativeTo(this);
          setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
    }
    
public void id_transaksi(){
    try{
        Connection koneksi=DriverManager.getConnection("jdbc:mysql://localhost:3306/kasirrestoran", "root", "");
        Statement stat = koneksi.createStatement();
        ResultSet rs = stat.executeQuery("SELECT * FROM kasir order by id_transaksi desc");
        if (rs.next()) {
                String id = rs.getString("id_transaksi").substring(1);
                String AN = "" + (Integer.parseInt(id) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}

               txtid.setText("R" + Nol + AN);
            } else {
               txtid.setText("R0001");
            }

           }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           }
        
} 
   
    
    public void tampil_combomakanan(){
        try{
            String sql = "Select * From tb_makanan";
            java.sql.Connection conn = (java.sql.Connection)koneksi.koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                combomakanan.addItem(rs.getString("nama_makanan"));
            }
            
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
        }catch(Exception e){
        }
    }
    
    public void tampil_combominuman(){
        try{
            String sql = "Select * From tb_minuman";
            java.sql.Connection conn = (java.sql.Connection)koneksi.koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                combominuman.addItem(rs.getString("nama_minuman"));
            }
            
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
        }catch(Exception e){
        }
    }
    
     public void tampil_makanan()
    {
        try {
       String sql = "Select harga From tb_makanan where nama_makanan='"+combomakanan.getSelectedItem()+"'";  
       java.sql.Connection conn = (java.sql.Connection)koneksi.koneksi.getKoneksi();
       java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        
        ResultSet res = pst.executeQuery(sql);
        
        while(res.next()){
            Object[] ob = new Object[3];
            ob[0]=  res.getString(1);
            
            txthargamakanan.setText((String) ob[0]);
        }
        res.close(); pst.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }              
    }
     
     public void tampil_minuman()
    {
        try {
       String sql = "Select harga From tb_minuman where nama_minuman='"+combominuman.getSelectedItem()+"'";  
       java.sql.Connection conn = (java.sql.Connection)koneksi.koneksi.getKoneksi();
       java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        
        ResultSet res = pst.executeQuery(sql);
        
        while(res.next()){
            Object[] ob = new Object[1];
            ob[0]=  res.getString(1);
            
            txthargaminuman.setText((String) ob[0]);
        }
        res.close(); pst.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Tableinfo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combomakanan = new javax.swing.JComboBox<>();
        combominuman = new javax.swing.JComboBox<>();
        txtjumlahmakanan = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        txtbayar = new javax.swing.JTextField();
        txtkembalian = new javax.swing.JTextField();
        btnbatal = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        btnhitung = new javax.swing.JButton();
        btnkembalian = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        btntambah = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        txtjumlahminuman = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txthargamakanan = new javax.swing.JTextField();
        txthargaminuman = new javax.swing.JTextField();
        btnmenu = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cetak = new javax.swing.JButton();
        btnrefresh = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tableinfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tableinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableinfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tableinfo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 550, 780, 120));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAMA MAKANAN                :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, 24));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NAMA MINUMAN                :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, 29));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("JUMLAH BELI MAKANAN    :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, 25));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TOTAL                                       :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("JUMLAH BAYAR                     :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 210, 22));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("JUMLAH KEMBALIAN          :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, -1, -1));

        combomakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combomakananActionPerformed(evt);
            }
        });
        getContentPane().add(combomakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 410, 30));

        combominuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combominumanActionPerformed(evt);
            }
        });
        getContentPane().add(combominuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 410, 30));

        txtjumlahmakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahmakananActionPerformed(evt);
            }
        });
        getContentPane().add(txtjumlahmakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 410, 30));
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 410, 30));
        getContentPane().add(txtbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 410, 30));
        getContentPane().add(txtkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 410, 30));

        btnbatal.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnbatal.setForeground(new java.awt.Color(51, 51, 51));
        btnbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset.png"))); // NOI18N
        btnbatal.setText("Batal");
        btnbatal.setPreferredSize(new java.awt.Dimension(171, 41));
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });
        getContentPane().add(btnbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 170, 170, 40));

        btnkeluar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnkeluar.setForeground(new java.awt.Color(51, 51, 51));
        btnkeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/keluar.png"))); // NOI18N
        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });
        getContentPane().add(btnkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 680, 120, 40));

        btnhitung.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnhitung.setForeground(new java.awt.Color(51, 51, 51));
        btnhitung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hitung.png"))); // NOI18N
        btnhitung.setText("Hitung Harga");
        btnhitung.setPreferredSize(new java.awt.Dimension(171, 41));
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });
        getContentPane().add(btnhitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 230, 170, 40));

        btnkembalian.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnkembalian.setForeground(new java.awt.Color(51, 51, 51));
        btnkembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hitung.png"))); // NOI18N
        btnkembalian.setText("Hitung Kembalian");
        btnkembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembalianActionPerformed(evt);
            }
        });
        getContentPane().add(btnkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 290, -1, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/banner-removebg-preview.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 870, 80));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID TRANSAKSI                        :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 210, 20));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 410, 30));

        btntambah.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btntambah.setForeground(new java.awt.Color(51, 51, 51));
        btntambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new.png"))); // NOI18N
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        getContentPane().add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 680, 120, 40));

        btnedit.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnedit.setForeground(new java.awt.Color(51, 51, 51));
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/create.png"))); // NOI18N
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        getContentPane().add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 680, 110, 40));

        btndelete.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btndelete.setText("Hapus");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 680, 110, 40));

        txtjumlahminuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahminumanActionPerformed(evt);
            }
        });
        getContentPane().add(txtjumlahminuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 410, 30));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("JUMLAH BELI MINUMAN    :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, -1, -1));

        txthargamakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargamakananActionPerformed(evt);
            }
        });
        getContentPane().add(txthargamakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 410, 30));

        txthargaminuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaminumanActionPerformed(evt);
            }
        });
        getContentPane().add(txthargaminuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 410, 30));

        btnmenu.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnmenu.setForeground(new java.awt.Color(51, 51, 51));
        btnmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tambah.png"))); // NOI18N
        btnmenu.setText("Tambah Menu");
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(973, 350, 170, 40));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("HARGA MAKANAN               :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 210, 20));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("HARGA MINUMAN              :");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, 20));

        cetak.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cetak.setForeground(new java.awt.Color(51, 51, 51));
        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        cetak.setText("Cetak");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        getContentPane().add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 410, 170, 40));

        btnrefresh.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnrefresh.setForeground(new java.awt.Color(51, 51, 51));
        btnrefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        btnrefresh.setText("Refresh");
        btnrefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnrefreshMouseClicked(evt);
            }
        });
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnrefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 470, 170, 40));

        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1350, 760));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wl.jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 1390, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtjumlahmakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahmakananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjumlahmakananActionPerformed

    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
        // TODO add your handling code here:
        harga_makanan = Integer.parseInt(txthargamakanan.getText());
        harga_minuman = Integer.parseInt(txthargaminuman.getText());
        beli = Integer.parseInt(txtjumlahmakanan.getText());
        beli2 = Integer.parseInt(txtjumlahminuman.getText());
        
        bayar = (harga_makanan * beli)+(harga_minuman * beli2);
        
        DecimalFormat angka = new DecimalFormat ("###,###");
        txttotal.setText("" + Integer.toString(bayar));
    }//GEN-LAST:event_btnhitungActionPerformed

    private void combomakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combomakananActionPerformed
        // TODO add your handling code here:
        tampil_makanan();
       // pilihan = (String) combomakanan.getSelectedItem();
       // switch (pilihan) {
          //  case "NASI GORENG":
          //  harga = 13000;
           // break;
           //   case "BAKMI JAWA":
           // harga = 12000;
           // break;
           //   case "GUDEG":
          //  harga = 15000;
            //break;
           //   case "SOTO AYAM":
           // harga = 11000;
           // break;
           //   case "SATE AYAM":
           // harga = 15000;
         //   break;
       // }
     //   txthargamakanan.setText(""+Integer.toString (harga));
    }//GEN-LAST:event_combomakananActionPerformed

    private void combominumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combominumanActionPerformed
        // TODO add your handling code here:
        tampil_minuman();
                           //pilihan = (String) combominuman.getSelectedItem();
        //switch (pilihan) {
            //case "ES TEH":
           // harga2 = 6000;
           // break;
             // case "ES DAWET":
           // harga2 = 8000;
         //   break;
            //  case "STMJ":
           // harga2 = 12000;
           // break;
           //   case "WEDANG JAHE":
           // harga2 = 9000;
            //break;
        //}
        //txthargaminuman.setText(""+Integer.toString (harga2));                          
    }//GEN-LAST:event_combominumanActionPerformed

 
        
    private void btnkembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembalianActionPerformed
        // TODO add your handling code here:
        int kembali = Integer.parseInt(txtbayar.getText());
        int total = kembali - bayar;
        
        txtkembalian.setText("Rp. "+Integer.toString(total));
        
    }//GEN-LAST:event_btnkembalianActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // TODO add your handling code here:
 
        txtjumlahmakanan.setText("");
        txtjumlahminuman.setText("");
        txthargamakanan.setText("");
        txthargaminuman.setText("");
        txtkembalian.setText("");
        txtbayar.setText("");
        txttotal.setText("");
        combomakanan.setSelectedItem("");
        combominuman.setSelectedItem("");
        
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
if(databaru==true){
            try{
            String sql = "insert into kasir values('"+txtid.getText()+"','"+combomakanan.getSelectedItem()+"','"+combominuman.getSelectedItem()+"','"+txthargamakanan.getText()+"',"
                        + "'"+txthargaminuman.getText()+"','"+txtjumlahmakanan.getText()+"',"
                        + "'"+txtjumlahminuman.getText()+"','"+txttotal.getText()+"','"+txtbayar.getText()+"','"+txtkembalian.getText()+"')";
            java.sql.Connection conn = (java.sql.Connection)koneksi.koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Disimpan");

            combomakanan.setSelectedItem("");
            combominuman.setSelectedItem("");
            txthargamakanan.setText("");
            txthargaminuman.setText("");
            txtjumlahmakanan.setText("");
            txtjumlahminuman.setText("");
            txttotal.setText("");
            txtbayar.setText("");
            txtkembalian.setText("");
            GetData();
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
            }
        }   
    }//GEN-LAST:event_btntambahActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        try{
        String sql = "DELETE FROM kasir WHERE id_transaksi='"+txtid.getText()+"'";
        java.sql.Connection conn= (java.sql.Connection)koneksi.koneksi.getKoneksi();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(null, "Data akan Dihapus");
        databaru = true;

        txtjumlahmakanan.setText("");
        txtjumlahminuman.setText("");
        txthargamakanan.setText("");
        txthargaminuman.setText("");
        txtkembalian.setText("");
        txtbayar.setText("");
        txttotal.setText("");
        combomakanan.setSelectedIndex(0);
        combominuman.setSelectedIndex(0);
        
    }catch(SQLException | HeadlessException e){
        
    }
    GetData();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void TableinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableinfoMouseClicked
       databaru=false;
       try {
           int row = Tableinfo.getSelectedRow();
           String tabel_klik =(Tableinfo.getModel().getValueAt(row, 0)).toString();
           java.sql.Connection conn =(java.sql.Connection)koneksi.koneksi.getKoneksi();
           java.sql.Statement stm=conn.createStatement();
           java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM kasir WHERE id_transaksi='");
           
           if(sql.next ()){
               String nama = sql.getNString("id_transaksi");
               txtid.setText(nama);
               String makanan = sql.getNString("makanan");
               combomakanan.setSelectedIndex(0);
               String minuman= sql.getNString("minuman");
               combominuman.setSelectedIndex(0);
               String hargamakan = sql.getNString("hargamakanan");
               txthargamakanan.setText(hargamakan);
               String hargaminum = sql.getNString("hargaminuman");
               txthargaminuman.setText(hargaminum);
               String jumbel_makanan = sql.getNString("jmlh_makanan");
               txtjumlahmakanan.setText(jumbel_makanan);
               String jumbel_minuman = sql.getNString("jmlh_minuman");
               txtjumlahminuman.setText(jumbel_minuman);
               String total = sql.getNString("total");
               txttotal.setText(total);
               String jum_bayar = sql.getNString("jmlh_bayar");
               txtbayar.setText(jum_bayar);
               String jumbel_kembalian = sql.getNString("jmlh_kembalian");
               txtkembalian.setText(jumbel_kembalian);
           }
               
       }catch(Exception e){
           
       }
    }//GEN-LAST:event_TableinfoMouseClicked

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
if(databaru==true){
            try{
            String sql = "update kasir set makanan='"+combomakanan.getSelectedItem()+"', minuman='"+combominuman.getSelectedItem()+"', hargamakan='"+txthargamakanan.getText()
                          +"', hargaminum='"+txthargaminuman.getText()+"', jmlh_makanan='"+txtjumlahmakanan.getText()+"', jmlh_minuman='"+txtjumlahminuman.getText()
                          +"', total='"+txttotal.getText()+"', jmlh_bayar='"+txtbayar.getText()+"', jmlh_kembalian='"+txtkembalian.getText()+"' where id_transaksi='"+txtid.getText()+"'";
            java.sql.Connection conn = (java.sql.Connection)koneksi.koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Diedit");

            combomakanan.setSelectedItem("");
            combominuman.setSelectedItem("");
            txtjumlahmakanan.setText("");
            txtjumlahminuman.setText("");
            txthargamakanan.setText("");
            txthargaminuman.setText("");
            txttotal.setText("");
            txtbayar.setText("");
            txtkembalian.setText("");
            GetData();
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
            }
        }   
    }//GEN-LAST:event_btneditActionPerformed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        // TODO add your handling code here:
        new Menu().show();
                    this.dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

    private void txthargamakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargamakananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargamakananActionPerformed

    private void txthargaminumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaminumanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaminumanActionPerformed

    private void txtjumlahminumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahminumanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjumlahminumanActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        // TODO add your handling code here:
        try{
         String jdbcDriver = "com.mysql.jdbc.Driver";       
         String url = "jdbc:mysql://localhost:3306/kasirrestoran";
         String username = "root";
        String password = "";
    String report = "E:\\Kasir\\src\\report1.jasper";
     Class.forName("com.mysql.jdbc.Driver").newInstance();
     Connection koneksi = DriverManager.getConnection(url, username, password);
     System.out.println("Connection Sukses...");
     HashMap hash = new HashMap();
     hash.put("id_transaksi", String.valueOf(txtid.getText()));
    // JasperReport JRpt = JasperCompileManager.compileReport(report);
     JasperPrint JPrint = JasperFillManager.fillReport(report, hash, koneksi);
     JasperViewer.viewReport(JPrint, false);
       }catch (Exception e){
           System.out.println("Gagal :" + e.getMessage());
       }
    //   try{
           // String NamaFile = "E:\\Kasir\\src\\cetak2.jasper";
          //  Class.forName("com.mysql.jdbc.Driver").newInstance();
          //  Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kasirrestoran","root","");
          //  HashMap param = new HashMap();
          //  //Mengambil parameter
          //  param.put("id_transaksi",txtid.getText());
                   
           // JasperPrint JPrint = JasperFillManager.fillReport(NamaFile, param, koneksi);
           // JasperViewer.viewReport(JPrint);
       // }catch(Exception ex){
          //  System.out.println(ex);
        //}
    }//GEN-LAST:event_cetakActionPerformed

    private void btnrefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrefreshMouseClicked
       DefaultTableModel mdl = (DefaultTableModel)Tableinfo.getModel();
       mdl.setRowCount(0);
       GetData();
       id_transaksi();
    }//GEN-LAST:event_btnrefreshMouseClicked

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnrefreshActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tableinfo;
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhitung;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnkembalian;
    private javax.swing.JButton btnmenu;
    private javax.swing.JToggleButton btnrefresh;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton cetak;
    private javax.swing.JComboBox<String> combomakanan;
    private javax.swing.JComboBox<String> combominuman;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txthargamakanan;
    private javax.swing.JTextField txthargaminuman;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtjumlahmakanan;
    private javax.swing.JTextField txtjumlahminuman;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables

}
