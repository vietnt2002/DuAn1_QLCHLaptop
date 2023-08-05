/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.quanlysp;

import domainmodels.NSX;
import iservices.INSXService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.CheckTrungService;
import services.NSXService;
import utilities.ULHelper;

/**
 *
 * @author portg
 */
public class FrmNSX extends javax.swing.JFrame {

    private final INSXService svcNSX = new NSXService() {
    };
    List<NSX> lstNSX = new ArrayList<>();
    DefaultTableModel modelNSX = new DefaultTableModel();
    Date date = Date.valueOf(LocalDate.now());
    int index;

    /**
     * Creates new form FrmNSX
     */
    public FrmNSX() {
        initComponents();
        setLocationRelativeTo(null);
        modelNSX = (DefaultTableModel) tblNSX.getModel();
        filltableNSX();
    }

    public void filltableNSX() {
        try {
            modelNSX.setRowCount(0);
            lstNSX = svcNSX.getAll();
            for (NSX a : lstNSX) {
                modelNSX.addRow(new Object[]{
                    a.getMa(), a.getTen(), a.getQuocGia(), a.getNgayTao(), a.getNgaySua()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showdetailNSX(int index) {
        try {
            txtMa4.setText(lstNSX.get(index).getMa());
            txtTen4.setText(lstNSX.get(index).getTen());
            txtQG.setText(lstNSX.get(index).getTen());
            
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

        btgNSX = new javax.swing.ButtonGroup();
        pnlNSX = new javax.swing.JPanel();
        pnlNSXinfo = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        pnlNSXbtn = new javax.swing.JPanel();
        btnAdd4 = new javax.swing.JButton();
        btnEdit4 = new javax.swing.JButton();
        btnDelete4 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtMa4 = new javax.swing.JTextField();
        txtTen4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtQG = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblNSX = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlNSX.setBackground(new java.awt.Color(255, 230, 234));

        pnlNSXinfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlNSXinfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhà sản xuất", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

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

        btnExit.setBackground(new java.awt.Color(255, 51, 0));
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNSXbtnLayout = new javax.swing.GroupLayout(pnlNSXbtn);
        pnlNSXbtn.setLayout(pnlNSXbtnLayout);
        pnlNSXbtnLayout.setHorizontalGroup(
            pnlNSXbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNSXbtnLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlNSXbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExit)
                    .addComponent(btnDelete4)
                    .addComponent(btnEdit4)
                    .addComponent(btnAdd4))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlNSXbtnLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd4, btnDelete4, btnEdit4, btnExit});

        pnlNSXbtnLayout.setVerticalGroup(
            pnlNSXbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNSXbtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd4)
                .addGap(18, 18, 18)
                .addComponent(btnEdit4)
                .addGap(18, 18, 18)
                .addComponent(btnDelete4)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlNSXbtnLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd4, btnDelete4, btnEdit4, btnExit});

        txtTen4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTen4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Quốc gia");

        javax.swing.GroupLayout pnlNSXinfoLayout = new javax.swing.GroupLayout(pnlNSXinfo);
        pnlNSXinfo.setLayout(pnlNSXinfoLayout);
        pnlNSXinfoLayout.setHorizontalGroup(
            pnlNSXinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNSXinfoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlNSXinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(pnlNSXinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel37)
                        .addComponent(jLabel42)))
                .addGap(27, 27, 27)
                .addGroup(pnlNSXinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMa4, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(txtTen4)
                    .addComponent(txtQG))
                .addGap(50, 50, 50)
                .addComponent(pnlNSXbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlNSXinfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtMa4, txtQG, txtTen4});

        pnlNSXinfoLayout.setVerticalGroup(
            pnlNSXinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNSXinfoLayout.createSequentialGroup()
                .addGroup(pnlNSXinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNSXinfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlNSXbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNSXinfoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(pnlNSXinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(txtMa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlNSXinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(txtTen4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlNSXinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtQG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pnlNSXinfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMa4, txtQG, txtTen4});

        tblNSX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Quốc gia", "Ngày tạo", "Ngày sửa", "Trạng thái"
            }
        ));
        tblNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNSXMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblNSX);

        javax.swing.GroupLayout pnlNSXLayout = new javax.swing.GroupLayout(pnlNSX);
        pnlNSX.setLayout(pnlNSXLayout);
        pnlNSXLayout.setHorizontalGroup(
            pnlNSXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNSXLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnlNSXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlNSXinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pnlNSXLayout.setVerticalGroup(
            pnlNSXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNSXLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlNSXinfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                        "nsx", "ma");
                if (trungMa != -1) {
                    JOptionPane.showMessageDialog(this, "Mã đã tồn tại!");
                    return;
                }
            }

            if (ULHelper.checknull(txtTen4, "Không được để tên trống!")) {
                return;
            }
            NSX nsx = new NSX(txtMa4.getText(), txtTen4.getText(), txtQG.getText(), date, date, 0);
            int thongBao = svcNSX.them(nsx);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                filltableNSX();
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
            lstNSX = svcNSX.getAll();

            Date tao = lstNSX.get(index).getNgayTao();
            NSX mau = new NSX(txtMa4.getText(), txtTen4.getText(), txtQG.getText(), tao, date, 0);
            int thongBao = svcNSX.sua(mau);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Sửa thành công!");
                filltableNSX();
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
            int thongBao = svcNSX.xoa(ma);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                filltableNSX();
                showdetailNSX(0);
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDelete4ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        try {
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtTen4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTen4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTen4ActionPerformed

    private void tblNSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNSXMouseClicked
        // TODO add your handling code here:
        try {
            int index = tblNSX.getSelectedRow();
            showdetailNSX(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblNSXMouseClicked

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
            java.util.logging.Logger.getLogger(FrmNSX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNSX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNSX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNSX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmNSX().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgNSX;
    private javax.swing.JButton btnAdd4;
    private javax.swing.JButton btnDelete4;
    private javax.swing.JButton btnEdit4;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel pnlNSX;
    private javax.swing.JPanel pnlNSXbtn;
    private javax.swing.JPanel pnlNSXinfo;
    private javax.swing.JTable tblNSX;
    private javax.swing.JTextField txtMa4;
    private javax.swing.JTextField txtQG;
    private javax.swing.JTextField txtTen4;
    // End of variables declaration//GEN-END:variables
}
