/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.GUI;

import com.vektorel.DAO.tblmusteridao;
import com.vektorel.Models.tblmusteri;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vektorel
 */
public class frmMainPage extends javax.swing.JFrame {
    private tblmusteridao db = new tblmusteridao();
    
    private int silinecekid;
    private int secilenrow;
    private String islem;
    /**
     * Creates new form frmMainPage
     */
    public frmMainPage() {
        initComponents();
        ekle();
        goster();
    }
    
    // ÖRNEK İÇERİK
    private void ekle(){
    
        tblmusteri tmp;
        
        tmp = new tblmusteri();
        tmp.setId(1);
        tmp.setAd("Müşteri-3");
        tmp.setAdres("Ankara");
        tmp.setSoyad("Soyad-3");
        tmp.setTelefon("0 555 666 9999");
        db.kaydet(tmp);
        
        tmp = new tblmusteri();
          tmp.setId(2);
        tmp.setAd("Müşteri-2");
        tmp.setAdres("İzmir");
        tmp.setSoyad("Soyad-2");
        tmp.setTelefon("0 555 666 9999");
        db.kaydet(tmp);
    
        tmp = new tblmusteri();
          tmp.setId(3);
        tmp.setAd("Müşteri-1");
        tmp.setAdres("İstanbul");
        tmp.setSoyad("Soyad-1");
        tmp.setTelefon("0 555 666 9999");
        db.kaydet(tmp);
    }
    
    private void goster(){
        int i=0;
        tablotemizle();
        for(tblmusteri item: db.listele()){
            tablosatirekle();
         tablomusteri.setValueAt(item.getId(), i,0);
         tablomusteri.setValueAt(item.getAd(), i,1);
         tablomusteri.setValueAt(item.getSoyad(), i,2);
         tablomusteri.setValueAt(item.getTelefon(), i,3);
         tablomusteri.setValueAt(item.getAdres(), i,4);
         i++;
        }
        
        
        
        
       
        
    }
    
    private void ac(){
        txtad.setEditable(true);
        txtadres.setEditable(true);
        txtsoyad.setEditable(true);
        txttelefon.setEditable(true);
        txtad.setBackground(Color.white);
        txtsoyad.setBackground(Color.white);
        txttelefon.setBackground(Color.white);
        txtadres.setBackground(Color.white); 
        btnkaydet.setEnabled(true);
        btniptal.setEnabled(true);
        btnyenikayit.setEnabled(false);
        txtad.requestFocus();
    }
    
    private void kapat(){
        txtad.setEditable(false);
        txtadres.setEditable(false);
        txtsoyad.setEditable(false);
        txttelefon.setEditable(false);
        txtad.setBackground(new java.awt.Color(204, 204, 204));
        txtsoyad.setBackground(new java.awt.Color(204, 204, 204));
        txttelefon.setBackground(new java.awt.Color(204, 204, 204));
        txtadres.setBackground(new java.awt.Color(204, 204, 204)); 
        btnkaydet.setEnabled(false);
        btniptal.setEnabled(false);
        btnyenikayit.setEnabled(true);
       
    }
    
    private void kaydet(){
    
        tblmusteri mst = new tblmusteri(); 
        mst.setId(Integer.parseInt(txtno.getText()));
        mst.setAd(txtad.getText());
        mst.setAdres(txtadres.getText());
        mst.setSoyad(txtsoyad.getText());
        mst.setTelefon(txttelefon.getText());
        db.kaydet(mst);       
    } 
    
    private void temizle(){
        txtad.setText("");
        txtadres.setText("");
        txtsoyad.setText("");
        txttelefon.setText("");
        
    }
    
    private void sil(){
    
      int secim =  JOptionPane.showConfirmDialog(this
                , "İlgili Kaydı Silmek İstiyor musunuz?"
                , "Dikkat!! Kayıt SİLME"
                , JOptionPane.OK_CANCEL_OPTION
                , JOptionPane.ERROR_MESSAGE);
        if(secim == JOptionPane.OK_OPTION){
        db.sil(secilenrow);
        goster();
        }
    }
    
    public void tablotemizle(){    
        DefaultTableModel dtm = 
                (DefaultTableModel)this.tablomusteri.getModel();
        dtm.getDataVector().removeAllElements();
        this.tablomusteri.repaint();
    }
    
    public void tablosatirekle(){
         DefaultTableModel dtm = 
                (DefaultTableModel)this.tablomusteri.getModel();
         dtm.setRowCount(dtm.getRowCount()+1);
         this.tablomusteri.repaint();
    }
    
    private void sec(){
        tblmusteri mst = db.listele().get(secilenrow);
        txtad.setText(mst.getAd());
        txtno.setText(mst.getId()+"");
        txtadres.setText(mst.getAdres());
        txtsoyad.setText(mst.getSoyad());
        txttelefon.setText(mst.getTelefon());
        
    }
    
    private void duzenle(){
            tblmusteri mst = db.listele().get(secilenrow);
            mst.setAd(txtad.getText());
            mst.setAdres(txtadres.getText());
            mst.setSoyad(txtsoyad.getText());
            mst.setTelefon(txttelefon.getText());
            db.duzenle(mst);
            goster();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupmenu = new javax.swing.JPopupMenu();
        btnsec = new javax.swing.JMenuItem();
        btnduzenle = new javax.swing.JMenuItem();
        btnsil = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtsoyad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttelefon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtadres = new javax.swing.JTextArea();
        lblresim = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablomusteri = new javax.swing.JTable();
        btnyenikayit = new javax.swing.JButton();
        btnkaydet = new javax.swing.JButton();
        btniptal = new javax.swing.JButton();
        btncikis = new javax.swing.JButton();
        txtaramasoyad = new javax.swing.JTextField();
        txtaramaad1 = new javax.swing.JTextField();

        btnsec.setText("Seç");
        btnsec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsecActionPerformed(evt);
            }
        });
        popupmenu.add(btnsec);

        btnduzenle.setText("Düzenle");
        btnduzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnduzenleActionPerformed(evt);
            }
        });
        popupmenu.add(btnduzenle);

        btnsil.setText("Sil");
        btnsil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsilActionPerformed(evt);
            }
        });
        popupmenu.add(btnsil);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Müşteri Kayıt Formu");
        setAlwaysOnTop(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("No");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtno.setEditable(false);
        txtno.setBackground(new java.awt.Color(204, 204, 204));
        txtno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 17, 114, -1));

        jLabel2.setText("Ad*");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 61, -1, -1));

        txtad.setEditable(false);
        txtad.setBackground(new java.awt.Color(204, 204, 204));
        txtad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtad, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 55, 114, -1));

        jLabel3.setText("Soyad*");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 96, -1, -1));

        txtsoyad.setEditable(false);
        txtsoyad.setBackground(new java.awt.Color(204, 204, 204));
        txtsoyad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtsoyad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtsoyad, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 93, 114, -1));

        jLabel4.setText("Telefon");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 20, -1, -1));

        txttelefon.setEditable(false);
        txttelefon.setBackground(new java.awt.Color(204, 204, 204));
        txttelefon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txttelefon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txttelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 17, 107, -1));

        jLabel5.setText("Adres");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 58, -1, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtadres.setEditable(false);
        txtadres.setBackground(new java.awt.Color(204, 204, 204));
        txtadres.setColumns(20);
        txtadres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtadres.setRows(5);
        txtadres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txtadres);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 55, 180, 60));

        lblresim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vektorel/Media/icons8-user-100.png"))); // NOI18N
        lblresim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblresim, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 11, -1, -1));

        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tablomusteri.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablomusteri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Ad", "Soyad", "Telefon", "Adres"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablomusteri.setComponentPopupMenu(popupmenu);
        jScrollPane2.setViewportView(tablomusteri);
        if (tablomusteri.getColumnModel().getColumnCount() > 0) {
            tablomusteri.getColumnModel().getColumn(0).setResizable(false);
            tablomusteri.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablomusteri.getColumnModel().getColumn(1).setResizable(false);
            tablomusteri.getColumnModel().getColumn(1).setPreferredWidth(120);
            tablomusteri.getColumnModel().getColumn(2).setResizable(false);
            tablomusteri.getColumnModel().getColumn(2).setPreferredWidth(120);
            tablomusteri.getColumnModel().getColumn(3).setResizable(false);
            tablomusteri.getColumnModel().getColumn(3).setPreferredWidth(100);
            tablomusteri.getColumnModel().getColumn(4).setResizable(false);
            tablomusteri.getColumnModel().getColumn(4).setPreferredWidth(250);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 600, 290));

        btnyenikayit.setBackground(new java.awt.Color(0, 102, 153));
        btnyenikayit.setForeground(new java.awt.Color(255, 102, 102));
        btnyenikayit.setText("Yeni Kayıt");
        btnyenikayit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnyenikayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnyenikayitActionPerformed(evt);
            }
        });
        getContentPane().add(btnyenikayit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 50));

        btnkaydet.setBackground(new java.awt.Color(0, 102, 153));
        btnkaydet.setForeground(new java.awt.Color(255, 102, 102));
        btnkaydet.setText("Kaydet");
        btnkaydet.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnkaydet.setEnabled(false);
        btnkaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkaydetActionPerformed(evt);
            }
        });
        getContentPane().add(btnkaydet, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 100, 50));

        btniptal.setBackground(new java.awt.Color(0, 102, 153));
        btniptal.setForeground(new java.awt.Color(255, 102, 102));
        btniptal.setText("İptal");
        btniptal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btniptal.setEnabled(false);
        btniptal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniptalActionPerformed(evt);
            }
        });
        getContentPane().add(btniptal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 100, 50));

        btncikis.setBackground(new java.awt.Color(0, 102, 153));
        btncikis.setForeground(new java.awt.Color(255, 102, 102));
        btncikis.setText("ÇIKIŞ");
        btncikis.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(btncikis, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 100, 50));

        txtaramasoyad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtaramasoyad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtaramasoyad, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 213, 110, -1));

        txtaramaad1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtaramaad1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtaramaad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaramaad1KeyPressed(evt);
            }
        });
        getContentPane().add(txtaramaad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 213, 110, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnyenikayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnyenikayitActionPerformed
        islem = "yenikayit";
        ac();
        temizle();
        int  lastindex =db.listele().size()-1;
        int id = db.listele().get(lastindex).getId()+1;
        txtno.setText(id+"");
    }//GEN-LAST:event_btnyenikayitActionPerformed

    private void btnkaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkaydetActionPerformed
      if(txtad.getText().isEmpty() || txtsoyad.getText().isEmpty())
      {
          JOptionPane.showMessageDialog(rootPane, "Zorunlu Alanlar Boş bırakılamaz ");
      }
        else
      {
          if(islem.equals("yenikayit"))
               kaydet();
          else if(islem.equals("duzenle"))
               duzenle();
          
          goster();
            kapat();
      }
        
      
    }//GEN-LAST:event_btnkaydetActionPerformed

    private void btniptalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniptalActionPerformed
       kapat();
    }//GEN-LAST:event_btniptalActionPerformed

    private void btnsecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsecActionPerformed
          secilenrow = tablomusteri.getSelectedRow();
          sec();
    }//GEN-LAST:event_btnsecActionPerformed

    private void btnduzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnduzenleActionPerformed
        secilenrow = tablomusteri.getSelectedRow();
        sec();
        ac();
        islem = "duzenle";
    }//GEN-LAST:event_btnduzenleActionPerformed

    private void btnsilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsilActionPerformed
        secilenrow = tablomusteri.getSelectedRow();
        sil();
    }//GEN-LAST:event_btnsilActionPerformed

    private void txtaramaad1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaramaad1KeyPressed
       
        goster();      
    }//GEN-LAST:event_txtaramaad1KeyPressed

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
            java.util.logging.Logger.getLogger(frmMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncikis;
    private javax.swing.JMenuItem btnduzenle;
    private javax.swing.JButton btniptal;
    private javax.swing.JButton btnkaydet;
    private javax.swing.JMenuItem btnsec;
    private javax.swing.JMenuItem btnsil;
    private javax.swing.JButton btnyenikayit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblresim;
    private javax.swing.JPopupMenu popupmenu;
    private javax.swing.JTable tablomusteri;
    private javax.swing.JTextField txtad;
    private javax.swing.JTextArea txtadres;
    private javax.swing.JTextField txtaramaad1;
    private javax.swing.JTextField txtaramasoyad;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtsoyad;
    private javax.swing.JTextField txttelefon;
    // End of variables declaration//GEN-END:variables
}
