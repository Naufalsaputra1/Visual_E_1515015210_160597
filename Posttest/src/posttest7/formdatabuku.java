/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posttest7;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class formdatabuku extends javax.swing.JFrame {
private DefaultTableModel model;
private Connection con = koneksi.getConnection();
private Statement stt;
private ResultSet rss;

private int baris;
private boolean cek=true;

    /**
     * Creates new form formdatabuku
     */
    public formdatabuku() {
        initComponents();
    }
private void InitTable(){
    model = new DefaultTableModel();
    model.addColumn("ID Buku");
    model.addColumn("JUDUL");
    model.addColumn("PENULIS");
    model.addColumn("HARGA");
    jTable2.setModel(model);
}

private void TampilData(){
    try{
        String sql = "SELECT * FROM buku";
        stt = con.createStatement();
        rss = stt.executeQuery(sql);
        while (rss.next()){
            Object[] o = new Object[4];
            o[0] = rss.getString("id");
            o[1] = rss.getString("judul");
            o[2] = rss.getString("penulis");
            o[3] = rss.getInt("harga");
            model.addRow(o);
        }
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
}

private void TambahData(String judul, String penulis, String harga){
    try{
        String sql = "INSERT INTO buku VALUES (NULL,'"+judul+"','"+penulis+"',"+harga+")";
        stt = con.createStatement();
        stt.executeUpdate(sql);
        model.addRow(new Object[]{judul,penulis,harga});
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
    }
}

 
public boolean UbahData(String id, String judul, String penulis, String harga){
    try{
        String sql = "UPDATE buku set judul='"+judul
                +"', penulis='"+penulis+"',harga="+harga
                +" WHERE id="+id+";";
        stt = con.createStatement();
        stt.executeUpdate(sql);
        return true;
    }catch(SQLException e){
        System.out.println(e.getMessage());
        return false;
    }
}

public boolean HapusData(String id, int baris){
    try{
        String sql = "DELETE FROM buku WHERE id="+id+";";
        stt = con.createStatement();
        stt.executeUpdate(sql);
        model.removeRow(baris);
        return true;
    }catch(SQLException e){
        System.out.println(e.getMessage());
        return false;
    }
}

private void validasidata(String jud, String nulis, String price) {//disini adalah sisi validasi dimana setiap data judul dan penulis yang masuk di huruf kecilkan
        try{
            String sql ="SELECT *FROM buku";//kita menampilkan dulu buku kemudian
            stt = con.createStatement();//variabel menampung dari sql yang udah ditentukan
            ResultSet rss = stt.executeQuery(sql);//variable penampung eksekusi pada sql
            while(rss.next()){
                Object[] o = new Object[2];//membuat objek baru
                o[0]=rss.getString("judul").toLowerCase();//disini adalah sisi dimana objek yang baru di masukkan dengan huruf kecil
                o[1]=rss.getString("penulis").toLowerCase();//disini adalah sisi objek dimana mendapati tulisan dengan masukkan dibandingkan dengan sql yang sudah di huruf kecilkan
                
                if(o[0].equals(jud.toLowerCase())&&o[1].equals(nulis.toLowerCase())){
                    JOptionPane.showMessageDialog(null,"DATA TELAH ADA");//untuk membandingkan dan mencegah data duplikat dimana judul dan pengarang yang sama berada di database yang sama maka jika nama pengarang dan judul yang sama maka akan muncul pemberitahuan bahwa data telah ada 
                    cek=false;//dan nilai cek berubah menjadi false
                    break;                    
                }
            }
            if(cek==true){
                TambahData(jud, nulis, price);//ketika nilai cek masih bernilai benar maka akan lari ke method tambah data dimana data akan tersimpan
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }//jadi sebelum menyimpan data ada method validasi ini dimana gunanya mengecek dulu apakah sudah ada judul dan pengarang yang sama jika suddah ada maka data tidak bisa tersimpan tapi jika tidak ada buku yang kondisinya nama dan pengarang sama maka data akan tersimpan
    }



private void PencarianData(String by, String cari){
    try{
        String sql = "SELECT * FROM buku where "+by+" LIKE'%"+cari+"%';";
        stt = con.createStatement();
        rss = stt.executeQuery(sql);
        while(rss.next()){
            Object[] data = new Object[4];
            data[0] = rss.getString("id");
            data[1] = rss.getString("judul").toLowerCase();
            data[2] = rss.getString("penulis").toLowerCase();
            data[3] = rss.getInt("harga");
            model.addRow(data);
        }
    }catch(Exception e){
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
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        simpan = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        comboPenulis = new javax.swing.JComboBox<>();
        ubah = new javax.swing.JToggleButton();
        hapus = new javax.swing.JToggleButton();
        keluar = new javax.swing.JToggleButton();
        caridata = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        combox = new javax.swing.JComboBox<>();
        cari = new javax.swing.JToggleButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "JUDUL", "PENULIS", "HARGA"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 0));

        jLabel1.setText("Form Data Buku");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setText("Judul");

        jLabel3.setText("Penulis");

        jLabel4.setText("Harga");

        txtJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJudulActionPerformed(evt);
            }
        });

        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });

        comboPenulis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tere Liye", "Naufal Saputra", "Penunggu", "Lagi nunggu" }));
        comboPenulis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPenulisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(comboPenulis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(comboPenulis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        ubah.setText("Ubah");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        caridata.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                caridataCaretUpdate(evt);
            }
        });
        caridata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caridataActionPerformed(evt);
            }
        });

        jLabel6.setText("By");

        combox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Judul", "Penulis" }));
        combox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxActionPerformed(evt);
            }
        });

        cari.setText("Pencarian");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(simpan)
                        .addGap(36, 36, 36)
                        .addComponent(ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapus)
                        .addGap(37, 37, 37)
                        .addComponent(keluar)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(caridata, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(combox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 15, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(ubah)
                    .addComponent(hapus)
                    .addComponent(keluar))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caridata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(combox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJudulActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void comboPenulisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPenulisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPenulisActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        InitTable();
        TampilData();
    }//GEN-LAST:event_formComponentShown

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        if(txtJudul.getText().equals("")||txtHarga.getText().equals("")){
         JOptionPane.showMessageDialog(null,"DATA BELUM LENGKAP","Danger!!",JOptionPane.INFORMATION_MESSAGE);
         txtJudul.requestFocus();//apabila field harga dan judul kosong maka akan muncul pemberitahuan bahwa masih ada data yang kosong.
     }
      String judul = txtJudul.getText();
      String penulis = comboPenulis.getSelectedItem().toString();
      String harga = txtHarga.getText();
     
      validasidata(judul,penulis,harga);
      
      InitTable();
      TampilData();
      txtJudul.setText("");
      comboPenulis.getSelectedItem();
      txtHarga.setText("");
    }//GEN-LAST:event_simpanActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        try {
             int baris = jTable2.getSelectedRow();
      
      jTable2.setValueAt(txtJudul.getText(), baris,1);
      jTable2.setValueAt(comboPenulis.getSelectedItem(), baris,2);
      jTable2.setValueAt(txtHarga.getText(), baris,3);
      
       String e_judul=jTable2.getValueAt(baris, 1).toString();
       String e_penulis=jTable2.getValueAt(baris, 2).toString();
       String e_harga=jTable2.getValueAt(baris, 3).toString();
       String id=jTable2.getValueAt(baris, 0).toString();
       
       txtJudul.setText(e_judul);
       comboPenulis.setSelectedItem(e_penulis);
       txtHarga.setText(e_harga);
       
       UbahData(e_judul,e_penulis,e_harga,id);
        } catch (Exception e) {
            //jika belum ada data yang dipilih namun mengklik tombol ubah maka akan muncul peringatan bahwa belum ada data yang terpilih
            JOptionPane.showMessageDialog(null,"DATA BELUM DIPILIH","Danger!!",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void caridataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caridataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caridataActionPerformed

    private void comboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboxActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_keluarActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        try{
      //sama seperti update hapus data akan terpanggil setelah kita mengklik baris yang kita inginkan setelah itu method hapusdata akan berjalan
      int baris = jTable2.getSelectedRow();
  
       String id = jTable2.getValueAt(baris, 0).toString();
        HapusData(id,baris);
    
        txtJudul.setText("");
        comboPenulis.setSelectedItem(null);
        txtHarga.setText("");
  }catch(Exception e){
      //sama seperti update tadi jika belum ada baris yang terpilih maka akan menampilkan peringatan bahwa belum ada data yang terpilih
      JOptionPane.showMessageDialog(null,"DATA BELUM DIPILIH","Danger!!",JOptionPane.INFORMATION_MESSAGE);
  }
    }//GEN-LAST:event_hapusActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        if(combox.getSelectedItem().equals("Judul")){
            try{
                Statement st = con.createStatement();
                String judul = caridata.getText();
                ResultSet rs = st.executeQuery("SELECT * FROM buku WHERE judul like '%"+judul+"%'");
                DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
                
                dtm.setRowCount(0);
                String [] data = new String[6];
                int i = 1;
                
                while(rs.next())
                {
                    data[0] = rs.getString("judul");
                    data[1] = rs.getString("penulis");
                    data[2] = rs.getString("harga");
                    dtm.addRow(data);
                    i++;                    
                }
                rs.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"data yang anda cari ditemukan","Kesalahan",JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(combox.getSelectedItem().equals("Penulis")){
            try{
                Statement st = con.createStatement();
                String penulis = caridata.getText();
                ResultSet rs = st.executeQuery("SELECT * FROM buku WHERE penulis like '%"+penulis+"%'");
                DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
                
                dtm.setRowCount(0);
                String [] data = new String[6];
                int i = 1;
                
                while(rs.next())
                {
                    data[0] = rs.getString("judul");
                    data[1] = rs.getString("penulis");
                    data[2] = rs.getString("harga");
                    dtm.addRow(data);
                    i++;                    
                }
                rs.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"data yang anda cari ditemukan","Kesalahan",JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_cariActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int baris = jTable2.getSelectedRow();
       
       String e_judul=jTable2.getValueAt(baris, 1).toString();
       String e_penulis=jTable2.getValueAt(baris, 2).toString();
       String e_harga=jTable2.getValueAt(baris, 3).toString();
        
        txtJudul.setText(e_judul);
        comboPenulis.setSelectedItem(e_penulis);
        txtHarga.setText(e_harga);
    }//GEN-LAST:event_jTable2MouseClicked

    private void caridataCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_caridataCaretUpdate
        // TODO add your handling code here:
        InitTable();
        if(caridata.getText().length()==0){
            TampilData();
        }else{
            PencarianData(combox.getSelectedItem().toString(),caridata.getText());
        }
    }//GEN-LAST:event_caridataCaretUpdate

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
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formdatabuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton cari;
    private javax.swing.JTextField caridata;
    private javax.swing.JComboBox<String> comboPenulis;
    private javax.swing.JComboBox<String> combox;
    private javax.swing.JToggleButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToggleButton keluar;
    private javax.swing.JToggleButton simpan;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JToggleButton ubah;
    // End of variables declaration//GEN-END:variables
}
