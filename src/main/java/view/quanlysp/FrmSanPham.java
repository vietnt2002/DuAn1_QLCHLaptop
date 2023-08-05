/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.quanlysp;

import domainmodels.SanPham;
import iservices.ISanPhamService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.CheckTrungService;
import services.SanPhamService;
import utilities.ULHelper;

/**
 *
 * @author portg
 */
public class FrmSanPham extends javax.swing.JFrame {

    private final ISanPhamService svcSP = new SanPhamService() {
    };
    List<SanPham> lstSP = new ArrayList<>();
    DefaultTableModel modelSP = new DefaultTableModel();
    Date date = Date.valueOf(LocalDate.now());
    int index;

    /**
     * Creates new form FrmSanPham
     */
    public FrmSanPham() {
        initComponents();
        setLocationRelativeTo(null);
        modelSP = (DefaultTableModel) tblSP.getModel();
        filltableSP();
    }

    public void filltableSP() {
        try {
            modelSP.setRowCount(0);
            lstSP = svcSP.getAll();
            for (SanPham a : lstSP) {
                modelSP.addRow(new Object[]{
                    a.getMa(), a.getTen(), a.getNgayTao(), a.getNgaySua(), a.getStatus(a.getTrangThai())
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showdetailSP(int index) {
        try {
            txtMa5.setText(lstSP.get(index).getMa());
            txtTen5.setText(lstSP.get(index).getTen());
            if (lstSP.get(index).getTrangThai() == 0) {
                radCon5.setSelected(true);
            } else {
                if (lstSP.get(index).getTrangThai() == 1) {
                    radHet5.setSelected(true);
                }
            }
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

        btgSP = new javax.swing.ButtonGroup();
        pnlSP = new javax.swing.JPanel();
        pnlSPInfo = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        radCon5 = new javax.swing.JRadioButton();
        radHet5 = new javax.swing.JRadioButton();
        pnlSPbtn = new javax.swing.JPanel();
        btnAdd5 = new javax.swing.JButton();
        btnEdit5 = new javax.swing.JButton();
        btnDelete5 = new javax.swing.JButton();
        btnHide5 = new javax.swing.JButton();
        txtMa5 = new javax.swing.JTextField();
        txtTen5 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlSP.setBackground(new java.awt.Color(255, 230, 234));

        pnlSPInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlSPInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel29.setText("Mã");

        jLabel30.setText("Tên");

        jLabel43.setText("Trạng thái");

        btgSP.add(radCon5);
        radCon5.setText("Còn hàng");
        radCon5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radCon5ActionPerformed(evt);
            }
        });

        btgSP.add(radHet5);
        radHet5.setText("Hết hàng");

        btnAdd5.setBackground(new java.awt.Color(255, 51, 0));
        btnAdd5.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd5.setText("Thêm");
        btnAdd5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd5ActionPerformed(evt);
            }
        });

        btnEdit5.setBackground(new java.awt.Color(255, 51, 0));
        btnEdit5.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit5.setText("Sửa");
        btnEdit5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit5ActionPerformed(evt);
            }
        });

        btnDelete5.setBackground(new java.awt.Color(255, 51, 0));
        btnDelete5.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete5.setText("Xóa");
        btnDelete5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete5ActionPerformed(evt);
            }
        });

        btnHide5.setBackground(new java.awt.Color(255, 51, 0));
        btnHide5.setForeground(new java.awt.Color(255, 255, 255));
        btnHide5.setText("Thoát");
        btnHide5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHide5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSPbtnLayout = new javax.swing.GroupLayout(pnlSPbtn);
        pnlSPbtn.setLayout(pnlSPbtnLayout);
        pnlSPbtnLayout.setHorizontalGroup(
            pnlSPbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPbtnLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlSPbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHide5)
                    .addComponent(btnDelete5)
                    .addComponent(btnEdit5)
                    .addComponent(btnAdd5))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlSPbtnLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd5, btnDelete5, btnEdit5, btnHide5});

        pnlSPbtnLayout.setVerticalGroup(
            pnlSPbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPbtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd5)
                .addGap(18, 18, 18)
                .addComponent(btnEdit5)
                .addGap(18, 18, 18)
                .addComponent(btnDelete5)
                .addGap(18, 18, 18)
                .addComponent(btnHide5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSPbtnLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd5, btnDelete5, btnEdit5, btnHide5});

        txtTen5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTen5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSPInfoLayout = new javax.swing.GroupLayout(pnlSPInfo);
        pnlSPInfo.setLayout(pnlSPInfoLayout);
        pnlSPInfoLayout.setHorizontalGroup(
            pnlSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPInfoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel43)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel29)
                        .addComponent(jLabel30)))
                .addGap(18, 18, 18)
                .addGroup(pnlSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSPInfoLayout.createSequentialGroup()
                        .addComponent(radCon5)
                        .addGap(18, 18, 18)
                        .addComponent(radHet5))
                    .addComponent(txtTen5, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(txtMa5))
                .addGap(31, 31, 31)
                .addComponent(pnlSPbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pnlSPInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtMa5, txtTen5});

        pnlSPInfoLayout.setVerticalGroup(
            pnlSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPInfoLayout.createSequentialGroup()
                .addGroup(pnlSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSPInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlSPbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSPInfoLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(pnlSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtMa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtTen5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(radCon5)
                            .addComponent(radHet5))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pnlSPInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMa5, txtTen5});

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblSP);

        javax.swing.GroupLayout pnlSPLayout = new javax.swing.GroupLayout(pnlSP);
        pnlSP.setLayout(pnlSPLayout);
        pnlSPLayout.setHorizontalGroup(
            pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSPInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        pnlSPLayout.setVerticalGroup(
            pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnlSPInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radCon5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radCon5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radCon5ActionPerformed

    private void btnAdd5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd5ActionPerformed
        // TODO add your handling code here:
        try {
            if (ULHelper.checknull(txtMa5, "Không được để mã trống!")) {
                return;
            } else {
                int trungMa = CheckTrungService.checkTrung(txtMa5.getText(),
                        "sanpham", "ma");
                if (trungMa != -1) {
                    JOptionPane.showMessageDialog(this, "Mã đã tồn tại!");
                    return;
                }
            }

            if (ULHelper.checknull(txtTen5, "Không được để tên trống!")) {
                return;
            }
            int stt = (radHet5.isSelected() ? 1 : 0);
            SanPham sp = new SanPham(txtMa5.getText(), txtTen5.getText(), date, date, stt);
            int thongBao = svcSP.them(sp);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                filltableSP();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAdd5ActionPerformed

    private void btnEdit5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit5ActionPerformed
        // TODO add your handling code here:
        try {
            if (ULHelper.checknull(txtMa5, "Không được để mã trống!")) {
                return;
            }

            if (ULHelper.checknull(txtTen5, "Không được để tên trống!")) {
                return;
            }
            lstSP = svcSP.getAll();

            Date tao = lstSP.get(index).getNgayTao();
            int stt = (radHet5.isSelected() ? 1 : 0);
            SanPham sp = new SanPham(txtMa5.getText(), txtTen5.getText(), tao, date, stt);
            int thongBao = svcSP.them(sp);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Sửa thành công!");
                filltableSP();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEdit5ActionPerformed

    private void btnDelete5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete5ActionPerformed
        // TODO add your handling code here:
        try {
            String ma = txtMa5.getText();
            int thongBao = svcSP.xoa(ma);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                filltableSP();
                showdetailSP(0);
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDelete5ActionPerformed

    private void btnHide5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHide5ActionPerformed
        // TODO add your handling code here:
        try {
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnHide5ActionPerformed

    private void txtTen5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTen5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTen5ActionPerformed

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        // TODO add your handling code here:
        try {
            int index = tblSP.getSelectedRow();
            showdetailSP(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblSPMouseClicked

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
            java.util.logging.Logger.getLogger(FrmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgSP;
    private javax.swing.JButton btnAdd5;
    private javax.swing.JButton btnDelete5;
    private javax.swing.JButton btnEdit5;
    private javax.swing.JButton btnHide5;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel pnlSP;
    private javax.swing.JPanel pnlSPInfo;
    private javax.swing.JPanel pnlSPbtn;
    private javax.swing.JRadioButton radCon5;
    private javax.swing.JRadioButton radHet5;
    private javax.swing.JTable tblSP;
    private javax.swing.JTextField txtMa5;
    private javax.swing.JTextField txtTen5;
    // End of variables declaration//GEN-END:variables
}
