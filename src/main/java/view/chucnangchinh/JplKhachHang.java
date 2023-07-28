package view.chucnangchinh;

import domainmodels.KhachHang;
import iservices.IKhachHangService;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.KhachHangService;

/**
 *
 * @author ADMIN
 */
public class JplKhachHang extends javax.swing.JPanel {
    
    private IKhachHangService iKhachHangService = new KhachHangService();
    DefaultTableModel moDel = new DefaultTableModel();
    DefaultComboBoxModel comboxmodel = new DefaultComboBoxModel();
    
    public JplKhachHang() {
        initComponents();
        loadDataKhachHang(iKhachHangService.getAll());
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnSuakh = new javax.swing.JButton();
        btnMoikh = new javax.swing.JButton();
        btnXoakh = new javax.swing.JButton();
        txtMa = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachhang = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        txtTraCuuTen = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnTangkh = new javax.swing.JButton();
        btnGiamkh = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 230, 234));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel14.setText("Mã");

        jLabel17.setText("Họ tên");

        jLabel18.setText("Ngày sinh");

        jLabel19.setText("SDT");

        jLabel20.setText("Địa chỉ");

        btnSuakh.setBackground(new java.awt.Color(255, 51, 0));
        btnSuakh.setForeground(new java.awt.Color(255, 255, 255));
        btnSuakh.setText("Sửa");
        btnSuakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuakhActionPerformed(evt);
            }
        });

        btnMoikh.setBackground(new java.awt.Color(255, 51, 0));
        btnMoikh.setForeground(new java.awt.Color(255, 255, 255));
        btnMoikh.setText("Mới");
        btnMoikh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoikhActionPerformed(evt);
            }
        });

        btnXoakh.setBackground(new java.awt.Color(255, 51, 0));
        btnXoakh.setForeground(new java.awt.Color(255, 255, 255));
        btnXoakh.setText("Xoá");
        btnXoakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoakhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnXoakh)
                    .addComponent(btnMoikh)
                    .addComponent(btnSuakh))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMoikh, btnSuakh, btnXoakh});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnMoikh)
                .addGap(18, 18, 18)
                .addComponent(btnSuakh)
                .addGap(18, 18, 18)
                .addComponent(btnXoakh)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnMoikh, btnSuakh, btnXoakh});

        txtMa.setEditable(false);
        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSdt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel14, jLabel17, jLabel18, jLabel19, jLabel20});

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDiaChi, txtHoTen, txtMa, txtNgaySinh, txtSdt});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel14, jLabel17, jLabel18, jLabel19, jLabel20, txtDiaChi, txtHoTen, txtMa, txtNgaySinh, txtSdt});

        tblKhachhang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblKhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ tên", "Ngày sinh", "Sdt", "Địa chỉ", "Ngày tạo", "Ngày sửa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachhang.setGridColor(new java.awt.Color(47, 85, 212));
        tblKhachhang.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tblKhachhang.setShowGrid(true);
        tblKhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachhang);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tra cứu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txtTraCuuTen.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTraCuuTenCaretUpdate(evt);
            }
        });
        txtTraCuuTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTraCuuTenMouseClicked(evt);
            }
        });
        txtTraCuuTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTraCuuTenActionPerformed(evt);
            }
        });

        jLabel43.setText("Tên hoặc Sdt:");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabel43)
                .addGap(36, 36, 36)
                .addComponent(txtTraCuuTen, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTraCuuTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Sắp xếp theo tên");

        btnTangkh.setBackground(new java.awt.Color(255, 51, 0));
        btnTangkh.setForeground(new java.awt.Color(255, 255, 255));
        btnTangkh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-sort-alpha-up-reversed-20.png"))); // NOI18N
        btnTangkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTangkhActionPerformed(evt);
            }
        });

        btnGiamkh.setBackground(new java.awt.Color(255, 51, 0));
        btnGiamkh.setForeground(new java.awt.Color(255, 255, 255));
        btnGiamkh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-sort-alpha-up-20.png"))); // NOI18N
        btnGiamkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiamkhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(btnTangkh)
                        .addGap(18, 18, 18)
                        .addComponent(btnGiamkh)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTangkh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGiamkh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuakhActionPerformed
        try {
            if (checkValidate()) {
                String ma = txtMa.getText();
                String hoTen = txtHoTen.getText();                
                Date ngaySinh = (Date) txtNgaySinh.getDate();
                String sdt = txtSdt.getText();
                String diachi = txtDiaChi.getText();
                
                KhachHang khachHang = new KhachHang();
                khachHang.setMa(ma);
                khachHang.setHoTen(hoTen);
                khachHang.setNgaySinh(ngaySinh);
                khachHang.setSdt(sdt);
                khachHang.setDiaChi(diachi);
                
                iKhachHangService.sua(khachHang);
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                clearForm();
                loadDataKhachHang(iKhachHangService.getAll());
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSuakhActionPerformed
    private void clearForm() {
        txtMa.setText("");
        txtHoTen.setText("");
        txtNgaySinh.setDate(null);
        txtSdt.setText("");
        txtDiaChi.setText("");
        tblKhachhang.clearSelection();
        loadDataKhachHang(iKhachHangService.getAll());
    }
    
    private void loadDataKhachHang(List<KhachHang> listKhachHangView) {
        moDel = new DefaultTableModel();
        moDel = (DefaultTableModel) tblKhachhang.getModel();
        moDel.setRowCount(0);
        for (KhachHang khachHang : listKhachHangView) {
            moDel.addRow(new Object[]{
                khachHang.getMa(),
                khachHang.getHoTen(),
                khachHang.getNgaySinh(),
                khachHang.getSdt(),
                khachHang.getDiaChi(),
                khachHang.getNgayTao(),
                khachHang.getNgaySua(),});
        }
    }
    private void btnMoikhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoikhActionPerformed
        clearForm();

    }//GEN-LAST:event_btnMoikhActionPerformed

    private void btnXoakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoakhActionPerformed
        if (iKhachHangService.getAll().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không còn gì để xoá");
            return;
        }
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá không ?");
        if (hoi != JOptionPane.YES_OPTION) {
            clearForm();
            return;
        } else {
            String ma = txtMa.getText();
            iKhachHangService.xoa(ma);
            JOptionPane.showMessageDialog(this, "Xoá thành công");
            clearForm();
            loadDataKhachHang(iKhachHangService.getAll());
        }
    }//GEN-LAST:event_btnXoakhActionPerformed

    private void tblKhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachhangMouseClicked
        int index = tblKhachhang.getSelectedRow();
        KhachHang kh = iKhachHangService.getAll().get(index);
        txtMa.setText(tblKhachhang.getValueAt(index, 0).toString());
        txtHoTen.setText(tblKhachhang.getValueAt(index, 1).toString());
        txtNgaySinh.setDate(kh.getNgaySinh());
        txtSdt.setText(tblKhachhang.getValueAt(index, 3).toString());
        txtDiaChi.setText(tblKhachhang.getValueAt(index, 4).toString());
    }//GEN-LAST:event_tblKhachhangMouseClicked
    private boolean checkValidate() {
        if (utilities.ULHelper.checknull(txtHoTen, "Không được để trống !")) {
            return false;
        }
      
        if (utilities.ULHelper.checknull(txtSdt, "Không được để trống !")) {
            return false;
        }
        if (utilities.ULHelper.CheckSDT(txtSdt, "Nhập số điện thoại đúng định dạng !")) {
            return false;
        }
        if (utilities.ULHelper.checknull(txtDiaChi, "Không được để trống !")) {
            return false;
        }
        return true;
    }
    private void btnTangkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTangkhActionPerformed
        List<KhachHang> list = iKhachHangService.sapXepTenTang();
        loadDataKhachHang(list);
        JOptionPane.showMessageDialog(this, "Sắp xếp theo tên a-z");
    }//GEN-LAST:event_btnTangkhActionPerformed

    private void btnGiamkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiamkhActionPerformed
        List<KhachHang> list = iKhachHangService.sapXepTenGiam();
        loadDataKhachHang(list);
        JOptionPane.showMessageDialog(this, "Sắp xếp theo tên z-a");
    }//GEN-LAST:event_btnGiamkhActionPerformed

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void txtTraCuuTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTraCuuTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTraCuuTenActionPerformed

    private void txtTraCuuTenCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTraCuuTenCaretUpdate
        List<KhachHang> list = iKhachHangService.timTen(txtTraCuuTen.getText());
        loadDataKhachHang(list);
    }//GEN-LAST:event_txtTraCuuTenCaretUpdate

    private void txtTraCuuTenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTraCuuTenMouseClicked

    }//GEN-LAST:event_txtTraCuuTenMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiamkh;
    private javax.swing.JButton btnMoikh;
    private javax.swing.JButton btnSuakh;
    private javax.swing.JButton btnTangkh;
    private javax.swing.JButton btnXoakh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKhachhang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMa;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTraCuuTen;
    // End of variables declaration//GEN-END:variables
}
