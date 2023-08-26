/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.quanlysp;

import domainmodels.MauSac;
import iservices.IMauSacService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.CheckTrungService;
import services.MauSacService;
import utilities.ULHelper;

/**
 *
 * @author portg
 */
public class FrmMauSac extends javax.swing.JFrame {
    private final IMauSacService svcMS = new MauSacService() {
    };
    List<MauSac> lstMS = new ArrayList<>();
    DefaultTableModel modelMauSac = new DefaultTableModel();
    Date date = Date.valueOf(LocalDate.now());
    int index;

    /**
     * Creates new form FrmMauSac
     */
    public FrmMauSac() {
        initComponents();
        setLocationRelativeTo(null);
        modelMauSac = (DefaultTableModel) tblMauSac.getModel();
        filltableMS();
    }
    
    public void filltableMS() {
        try {
            modelMauSac.setRowCount(0);
            lstMS = svcMS.getAll();
            for (MauSac a : lstMS) {
                modelMauSac.addRow(new Object[]{
                    a.getMa(), a.getTen(), a.getNgayTao(), a.getNgaySua(), a.getStatus(a.getTrangThai())
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showdetailMS(int index) {
        try {
            txtMa4.setText(lstMS.get(index).getMa());
            txtTen4.setText(lstMS.get(index).getTen());
        } catch (Exception e) {
            e.printStackTrace();
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

        pnlMauSac = new javax.swing.JPanel();
        pnlMauSacinfo = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        pnlMauSacbtn = new javax.swing.JPanel();
        btnAdd4 = new javax.swing.JButton();
        btnEdit4 = new javax.swing.JButton();
        btnDelete4 = new javax.swing.JButton();
        btnHide4 = new javax.swing.JButton();
        txtMa4 = new javax.swing.JTextField();
        txtTen4 = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMauSac.setBackground(new java.awt.Color(255, 230, 234));

        pnlMauSacinfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlMauSacinfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin màu sắc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel37.setText("Mã");

        jLabel42.setText("Tên");

        btnAdd4.setBackground(new java.awt.Color(255, 51, 0));
        btnAdd4.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd4.setText("Thêm");
        btnAdd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd4ActionPerformed(evt);
            }
        });

        btnEdit4.setBackground(new java.awt.Color(255, 51, 0));
        btnEdit4.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit4.setText("Sửa");
        btnEdit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit4ActionPerformed(evt);
            }
        });

        btnDelete4.setBackground(new java.awt.Color(255, 51, 0));
        btnDelete4.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete4.setText("Xóa");
        btnDelete4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete4ActionPerformed(evt);
            }
        });

        btnHide4.setBackground(new java.awt.Color(255, 51, 0));
        btnHide4.setForeground(new java.awt.Color(255, 255, 255));
        btnHide4.setText("Thoát");
        btnHide4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHide4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMauSacbtnLayout = new javax.swing.GroupLayout(pnlMauSacbtn);
        pnlMauSacbtn.setLayout(pnlMauSacbtnLayout);
        pnlMauSacbtnLayout.setHorizontalGroup(
            pnlMauSacbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMauSacbtnLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlMauSacbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHide4)
                    .addComponent(btnDelete4)
                    .addComponent(btnEdit4)
                    .addComponent(btnAdd4))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlMauSacbtnLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd4, btnDelete4, btnEdit4, btnHide4});

        pnlMauSacbtnLayout.setVerticalGroup(
            pnlMauSacbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMauSacbtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd4)
                .addGap(18, 18, 18)
                .addComponent(btnEdit4)
                .addGap(18, 18, 18)
                .addComponent(btnDelete4)
                .addGap(18, 18, 18)
                .addComponent(btnHide4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMauSacbtnLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd4, btnDelete4, btnEdit4, btnHide4});

        txtMa4.setEditable(false);

        txtTen4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTen4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMauSacinfoLayout = new javax.swing.GroupLayout(pnlMauSacinfo);
        pnlMauSacinfo.setLayout(pnlMauSacinfoLayout);
        pnlMauSacinfoLayout.setHorizontalGroup(
            pnlMauSacinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMauSacinfoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlMauSacinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(53, 53, 53)
                .addGroup(pnlMauSacinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTen4, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(txtMa4))
                .addGap(40, 40, 40)
                .addComponent(pnlMauSacbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnlMauSacinfoLayout.setVerticalGroup(
            pnlMauSacinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMauSacinfoLayout.createSequentialGroup()
                .addGroup(pnlMauSacinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMauSacinfoLayout.createSequentialGroup()
                        .addGroup(pnlMauSacinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(txtMa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlMauSacinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(txtTen4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnlMauSacbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tblMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Ngày tạo", "Ngày sửa", "Trạng thái"
            }
        ));
        tblMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMauSacMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblMauSac);

        javax.swing.GroupLayout pnlMauSacLayout = new javax.swing.GroupLayout(pnlMauSac);
        pnlMauSac.setLayout(pnlMauSacLayout);
        pnlMauSacLayout.setHorizontalGroup(
            pnlMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMauSacLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMauSacinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        pnlMauSacLayout.setVerticalGroup(
            pnlMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMauSacLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMauSacinfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd4ActionPerformed
        // TODO add your handling code here:
        try {
            if (ULHelper.checknull(txtMa4, "Không được để mã trống!")) {
                return;
            } else {
                int trungMa = CheckTrungService.checkTrung(txtMa4.getText(),
                    "mausac", "ma");
                if (trungMa != -1) {
                    JOptionPane.showMessageDialog(this, "Mã đã tồn tại!");
                    return;
                }
            }

            if (ULHelper.checknull(txtTen4, "Không được để màu trống!")) {
                return;
            }
            int stt = 0;
            MauSac mau = new MauSac(txtTen4.getText(), date, date, stt);
            int thongBao = svcMS.them(mau);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                filltableMS();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAdd4ActionPerformed

    private void btnEdit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit4ActionPerformed
        // TODO add your handling code here:
        try {
            if (ULHelper.checknull(txtMa4, "Không được để mã trống!")) {
                return;
            }

            if (ULHelper.checknull(txtTen4, "Không được để tên trống!")) {
                return;
            }
            lstMS = svcMS.getAll();

            Date tao = lstMS.get(index).getNgayTao();
            int stt = lstMS.get(index).getTrangThai();
            MauSac mau = new MauSac(txtTen4.getText(), tao, date, stt);
            int thongBao = svcMS.sua(mau);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Sửa thành công!");
                filltableMS();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEdit4ActionPerformed

    private void btnDelete4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete4ActionPerformed
        // TODO add your handling code here:
        try {
            String ma = txtMa4.getText();
            int thongBao = svcMS.xoa(ma);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                filltableMS();
                showdetailMS(0);
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDelete4ActionPerformed

    private void btnHide4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHide4ActionPerformed
        // TODO add your handling code here:
        try {
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnHide4ActionPerformed

    private void txtTen4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTen4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTen4ActionPerformed

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked
        // TODO add your handling code here:
        try {
            int index = tblMauSac.getSelectedRow();
            showdetailMS(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblMauSacMouseClicked

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
            java.util.logging.Logger.getLogger(FrmMauSac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMauSac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMauSac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMauSac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMauSac().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd4;
    private javax.swing.JButton btnDelete4;
    private javax.swing.JButton btnEdit4;
    private javax.swing.JButton btnHide4;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel pnlMauSac;
    private javax.swing.JPanel pnlMauSacbtn;
    private javax.swing.JPanel pnlMauSacinfo;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTextField txtMa4;
    private javax.swing.JTextField txtTen4;
    // End of variables declaration//GEN-END:variables
}
