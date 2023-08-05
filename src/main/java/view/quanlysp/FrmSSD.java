/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.quanlysp;

import domainmodels.SSD;
import iservices.ISSDService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.CheckTrungService;
import services.SSDService;
import utilities.ULHelper;

/**
 *
 * @author portg
 */
public class FrmSSD extends javax.swing.JFrame {

    List<SSD> lstSSD = new ArrayList<>();
    private final ISSDService svcSSD = new SSDService() {
    };
    DefaultTableModel modelSSD = new DefaultTableModel();
    Date date = Date.valueOf(LocalDate.now());
    int index;

    /**
     * Creates new form FrmSSD
     */
    public FrmSSD() {
        initComponents();
        setLocationRelativeTo(null);
        modelSSD = (DefaultTableModel) tblSSD.getModel();
        filltableSSD();
    }

    public void filltableSSD() {
        try {
            modelSSD.setRowCount(0);
            lstSSD = svcSSD.getAll();
            for (SSD a : lstSSD) {
                modelSSD.addRow(new Object[]{
                    a.getMa(), a.getTen(), a.getNgayTao(), a.getNgaySua(), a.getStatus(a.getTrangThai())
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showdetailSSD(int index) {
        try {
            txtMa3.setText(lstSSD.get(index).getMa());
            txtTen3.setText(lstSSD.get(index).getTen());
            if (lstSSD.get(index).getTrangThai() == 0) {
                radCon3.setSelected(true);
            } else {
                if (lstSSD.get(index).getTrangThai() == 1) {
                    radHet3.setSelected(true);
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

        btgSSD = new javax.swing.ButtonGroup();
        pnlSSD = new javax.swing.JPanel();
        pnlSSDinfo = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        radCon3 = new javax.swing.JRadioButton();
        radHet3 = new javax.swing.JRadioButton();
        pnlSSDbtn = new javax.swing.JPanel();
        btnAdd3 = new javax.swing.JButton();
        btnEdit3 = new javax.swing.JButton();
        btnDelete3 = new javax.swing.JButton();
        btnHide3 = new javax.swing.JButton();
        txtMa3 = new javax.swing.JTextField();
        txtTen3 = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblSSD = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlSSD.setBackground(new java.awt.Color(255, 230, 234));

        pnlSSDinfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlSSDinfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin SSD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel35.setText("Mã");

        jLabel36.setText("Tên");

        jLabel56.setText("Trạng thái");

        btgSSD.add(radCon3);
        radCon3.setText("Còn hàng");
        radCon3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radCon3ActionPerformed(evt);
            }
        });

        btgSSD.add(radHet3);
        radHet3.setText("Hết hàng");

        btnAdd3.setBackground(new java.awt.Color(255, 51, 0));
        btnAdd3.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd3.setText("Thêm");
        btnAdd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd3ActionPerformed(evt);
            }
        });

        btnEdit3.setBackground(new java.awt.Color(255, 51, 0));
        btnEdit3.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit3.setText("Sửa");
        btnEdit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit3ActionPerformed(evt);
            }
        });

        btnDelete3.setBackground(new java.awt.Color(255, 51, 0));
        btnDelete3.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete3.setText("Xóa");
        btnDelete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete3ActionPerformed(evt);
            }
        });

        btnHide3.setBackground(new java.awt.Color(255, 51, 0));
        btnHide3.setForeground(new java.awt.Color(255, 255, 255));
        btnHide3.setText("Thoát");
        btnHide3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHide3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSSDbtnLayout = new javax.swing.GroupLayout(pnlSSDbtn);
        pnlSSDbtn.setLayout(pnlSSDbtnLayout);
        pnlSSDbtnLayout.setHorizontalGroup(
            pnlSSDbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSSDbtnLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlSSDbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHide3)
                    .addComponent(btnDelete3)
                    .addComponent(btnEdit3)
                    .addComponent(btnAdd3))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlSSDbtnLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd3, btnDelete3, btnEdit3, btnHide3});

        pnlSSDbtnLayout.setVerticalGroup(
            pnlSSDbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSSDbtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd3)
                .addGap(18, 18, 18)
                .addComponent(btnEdit3)
                .addGap(18, 18, 18)
                .addComponent(btnDelete3)
                .addGap(18, 18, 18)
                .addComponent(btnHide3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSSDbtnLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd3, btnDelete3, btnEdit3, btnHide3});

        txtTen3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTen3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSSDinfoLayout = new javax.swing.GroupLayout(pnlSSDinfo);
        pnlSSDinfo.setLayout(pnlSSDinfoLayout);
        pnlSSDinfoLayout.setHorizontalGroup(
            pnlSSDinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSSDinfoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlSSDinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel56)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSSDinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel35)
                        .addComponent(jLabel36)))
                .addGap(18, 18, 18)
                .addGroup(pnlSSDinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSSDinfoLayout.createSequentialGroup()
                        .addComponent(radCon3)
                        .addGap(18, 18, 18)
                        .addComponent(radHet3))
                    .addComponent(txtTen3, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(txtMa3))
                .addGap(42, 42, 42)
                .addComponent(pnlSSDbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pnlSSDinfoLayout.setVerticalGroup(
            pnlSSDinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSSDinfoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlSSDinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSSDbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSSDinfoLayout.createSequentialGroup()
                        .addGroup(pnlSSDinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txtMa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlSSDinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(txtTen3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlSSDinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(radCon3)
                            .addComponent(radHet3))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tblSSD.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSSD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSSDMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblSSD);

        javax.swing.GroupLayout pnlSSDLayout = new javax.swing.GroupLayout(pnlSSD);
        pnlSSD.setLayout(pnlSSDLayout);
        pnlSSDLayout.setHorizontalGroup(
            pnlSSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSSDLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pnlSSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlSSDinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        pnlSSDLayout.setVerticalGroup(
            pnlSSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSSDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSSDinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlSSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlSSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radCon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radCon3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radCon3ActionPerformed

    private void btnAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd3ActionPerformed
        // TODO add your handling code here:
        try {
            if (ULHelper.checknull(txtMa3, "Không được để mã trống!")) {
                return;
            } else {
                int trungMa = CheckTrungService.checkTrung(txtMa3.getText(),
                        "SSD", "ma");
                if (trungMa != -1) {
                    JOptionPane.showMessageDialog(this, "Mã đã tồn tại!");
                    return;
                }
            }

            if (ULHelper.checknull(txtTen3, "Không được để tên trống!")) {
                return;
            }
            int stt = (radHet3.isSelected() ? 1 : 0);
            SSD ssd = new SSD(txtMa3.getText(), txtTen3.getText(), date, date, stt);
            int thongBao = svcSSD.them(ssd);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                filltableSSD();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAdd3ActionPerformed

    private void btnEdit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit3ActionPerformed
        // TODO add your handling code here:
        try {
            if (ULHelper.checknull(txtMa3, "Không được để mã trống!")) {
                return;
            }

            if (ULHelper.checknull(txtTen3, "Không được để tên trống!")) {
                return;
            }
            lstSSD = svcSSD.getAll();

            Date tao = lstSSD.get(index).getNgayTao();
            int stt = (radHet3.isSelected() ? 1 : 0);
            SSD ssd = new SSD(txtMa3.getText(), txtTen3.getText(), tao, date, stt);
            int thongBao = svcSSD.sua(ssd);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Sửa thành công!");
                filltableSSD();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEdit3ActionPerformed

    private void btnDelete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete3ActionPerformed
        // TODO add your handling code here:
        try {
            String ma = txtMa3.getText();
            int thongBao = svcSSD.xoa(ma);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                filltableSSD();
                showdetailSSD(0);
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDelete3ActionPerformed

    private void btnHide3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHide3ActionPerformed
        // TODO add your handling code here:
        try {
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnHide3ActionPerformed

    private void txtTen3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTen3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTen3ActionPerformed

    private void tblSSDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSSDMouseClicked
        // TODO add your handling code here:
        try {
            int index = tblSSD.getSelectedRow();
            showdetailSSD(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblSSDMouseClicked

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
            java.util.logging.Logger.getLogger(FrmSSD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSSD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSSD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSSD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSSD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgSSD;
    private javax.swing.JButton btnAdd3;
    private javax.swing.JButton btnDelete3;
    private javax.swing.JButton btnEdit3;
    private javax.swing.JButton btnHide3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JPanel pnlSSD;
    private javax.swing.JPanel pnlSSDbtn;
    private javax.swing.JPanel pnlSSDinfo;
    private javax.swing.JRadioButton radCon3;
    private javax.swing.JRadioButton radHet3;
    private javax.swing.JTable tblSSD;
    private javax.swing.JTextField txtMa3;
    private javax.swing.JTextField txtTen3;
    // End of variables declaration//GEN-END:variables
}
