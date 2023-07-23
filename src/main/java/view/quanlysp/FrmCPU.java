/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.quanlysp;

import domainmodels.CPU;
import iservices.ICPUService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.CPUService;
import services.CheckTrungService;
import utilities.ULHelper;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author portg
 */
public class FrmCPU extends javax.swing.JFrame {

    private final ICPUService svcCPU = new CPUService() {
    };
    List<CPU> lstCPU = new ArrayList<>();
    DefaultTableModel modelCPU = new DefaultTableModel();
    Date date = Date.valueOf(LocalDate.now());
    int index;

    /**
     * Creates new form FrmCPU
     */
    public FrmCPU() {
        initComponents();
        setLocationRelativeTo(null);
        modelCPU = (DefaultTableModel) tblCPU.getModel();
    }

    public void filltableCPU() {
        try {
            modelCPU.setRowCount(0);
            lstCPU = svcCPU.getAll();
            for (CPU a : lstCPU) {
                modelCPU.addRow(new Object[]{
                    a.getMa(), a.getTen(), a.getNgayTao(), a.getNgaySua(), a.getStatus(a.getTrangThai())
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showdetailCPU(int index) {
        try {
            txtMa.setText(lstCPU.get(index).getMa());
            txtTen.setText(lstCPU.get(index).getTen());
            if (lstCPU.get(index).getTrangThai() == 0) {
                radCon.setSelected(true);
            } else {
                if (lstCPU.get(index).getTrangThai() == 1) {
                    radHet.setSelected(true);
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

        btgCPU = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pnlCPUInfo = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        radCon = new javax.swing.JRadioButton();
        radHet = new javax.swing.JRadioButton();
        pnlCPUbtn = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnHide = new javax.swing.JButton();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCPU = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 230, 234));

        jPanel1.setBackground(new java.awt.Color(255, 230, 234));

        pnlCPUInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlCPUInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin CPU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel27.setText("Mã");

        jLabel28.setText("Tên");

        jLabel38.setText("Trạng thái");

        radCon.setText("Còn hàng");
        radCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radConActionPerformed(evt);
            }
        });

        radHet.setText("Hết hàng");

        btnAdd.setBackground(new java.awt.Color(255, 51, 0));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnShow.setBackground(new java.awt.Color(255, 51, 0));
        btnShow.setForeground(new java.awt.Color(255, 255, 255));
        btnShow.setText("Hiện");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 51, 0));
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 0));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnHide.setBackground(new java.awt.Color(255, 51, 0));
        btnHide.setForeground(new java.awt.Color(255, 255, 255));
        btnHide.setText("Ẩn");
        btnHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHideActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCPUbtnLayout = new javax.swing.GroupLayout(pnlCPUbtn);
        pnlCPUbtn.setLayout(pnlCPUbtnLayout);
        pnlCPUbtnLayout.setHorizontalGroup(
            pnlCPUbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCPUbtnLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlCPUbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHide)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit)
                    .addComponent(btnShow)
                    .addComponent(btnAdd))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlCPUbtnLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit, btnHide, btnShow});

        pnlCPUbtnLayout.setVerticalGroup(
            pnlCPUbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCPUbtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnShow)
                .addGap(18, 18, 18)
                .addComponent(btnHide)
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnEdit)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCPUbtnLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit, btnHide, btnShow});

        txtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCPUInfoLayout = new javax.swing.GroupLayout(pnlCPUInfo);
        pnlCPUInfo.setLayout(pnlCPUInfoLayout);
        pnlCPUInfoLayout.setHorizontalGroup(
            pnlCPUInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCPUInfoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlCPUInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addGroup(pnlCPUInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel27)
                        .addComponent(jLabel28)))
                .addGap(40, 40, 40)
                .addGroup(pnlCPUInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlCPUInfoLayout.createSequentialGroup()
                        .addComponent(radCon)
                        .addGap(35, 35, 35)
                        .addComponent(radHet))
                    .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(txtMa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(pnlCPUbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pnlCPUInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtMa, txtTen});

        pnlCPUInfoLayout.setVerticalGroup(
            pnlCPUInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCPUInfoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnlCPUInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCPUInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlCPUInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(radCon)
                    .addComponent(radHet))
                .addGap(73, 73, 73))
            .addGroup(pnlCPUInfoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnlCPUbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pnlCPUInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMa, txtTen});

        tblCPU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Ngày tạo", "Ngày sửa", "Trạnng thái"
            }
        ));
        tblCPU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCPUMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCPU);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCPUInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(pnlCPUInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radConActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            if (ULHelper.checknull(txtMa, "Không được để mã trống!")) {
                return;
            } else {
                int trungMa = CheckTrungService.checkTrung(txtMa.getText(),
                    "cpu", "ma");
                if (trungMa != -1) {
                    JOptionPane.showMessageDialog(this, "Mã đã tồn tại!");
                    return;
                }
            }

            if (ULHelper.checknull(txtTen, "Không được để tên trống!")) {
                return;
            }
            int stt = (radHet.isSelected() ? 1 : 0);
            CPU cpu = new CPU(txtMa.getText(), txtTen.getText(), date, date, stt);
            int thongBao = svcCPU.them(cpu);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                filltableCPU();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:
        try {
            filltableCPU();
            showdetailCPU(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        try {
            if (ULHelper.checknull(txtMa, "Không được để mã trống!")) {
                return;
            }

            if (ULHelper.checknull(txtTen, "Không được để tên trống!")) {
                return;
            }
            lstCPU = svcCPU.getAll();

            Date tao = lstCPU.get(index).getNgayTao();
            int stt = (radHet.isSelected() ? 1 : 0);
            CPU cpu = new CPU(txtMa.getText(), txtTen.getText(), tao, date, stt);
            int thongBao = svcCPU.sua(cpu);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Sửa thành công!");
                filltableCPU();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            String ma = txtMa.getText();
            int thongBao = svcCPU.xoa(ma);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                filltableCPU();
                showdetailCPU(0);
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHideActionPerformed
        // TODO add your handling code here:
        try {
            modelCPU.setRowCount(0);
            txtMa.setText("");
            txtTen.setText("");
            radCon.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnHideActionPerformed

    private void txtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenActionPerformed

    private void tblCPUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCPUMouseClicked
        // TODO add your handling code here:
        try {
            int index = tblCPU.getSelectedRow();
            showdetailCPU(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblCPUMouseClicked

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
            java.util.logging.Logger.getLogger(FrmCPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCPU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgCPU;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHide;
    private javax.swing.JButton btnShow;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlCPUInfo;
    private javax.swing.JPanel pnlCPUbtn;
    private javax.swing.JRadioButton radCon;
    private javax.swing.JRadioButton radHet;
    private javax.swing.JTable tblCPU;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}