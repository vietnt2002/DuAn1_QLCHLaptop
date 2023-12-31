package view.giaodien;

import view.chucnangchinh.JplKhuyenMai;
import iservices.INhanVienService;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import services.NhanVienService;
import utilities.UserInfo;
import view.chucnangchinh.JplBanHang;
import view.chucnangchinh.JplHoaDon;
import view.chucnangchinh.JplKhachHang;
import view.chucnangchinh.JplNhanVien;
import view.chucnangchinh.JplThongKe;
import view.chucnangchinh.JplQuanLySP;

public class FrmGiaoDien extends javax.swing.JFrame {

    private JPanel panel;
    INhanVienService nhanVienService = new NhanVienService();

    public FrmGiaoDien() {
        initComponents();
        setLocationRelativeTo(null);
        panel = new JplBanHang();
        setPanel(panel);
        LoadThongTinNhanVien();
    }

    public FrmGiaoDien(JPanel panel) {
        setPanel(panel);
    }

    private void setColor(JPanel p) {
        p.setBackground(new Color(170, 190, 255));
    }

    private void resetColor(JPanel p) {
        p.setBackground(new Color(255, 153, 153));
    }

    private void setPanel(JPanel p) {
        jplContain.removeAll();
        jplContain.add(p);
        jplContain.updateUI();
    }

    private void LoadThongTinNhanVien() {
        String hoTenNV = nhanVienService.getHoTenByMa(utilities.UserInfo.tenTK);
        lblHoTen.setText(hoTenNV);
        String vaiTro = nhanVienService.setQuyen(utilities.UserInfo.tenTK);
        lblVaiTro.setText(vaiTro);
        if (vaiTro.equals("Nhân viên")) {
            jplKhuyenMai.setVisible(false);
            jplThongKe.setVisible(false);
            jplKhachHang.setVisible(false);
            jplQLSP.setVisible(false);
        } else {
            jplBanHang.setVisible(false);
            panel = new JplHoaDon();
            setPanel(panel);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        lblVaiTro = new javax.swing.JLabel();
        jplBanHang = new javax.swing.JPanel();
        lblBanHang = new javax.swing.JLabel();
        jplQlHoaDon = new javax.swing.JPanel();
        lblQLHoaDon = new javax.swing.JLabel();
        jplNhanvien = new javax.swing.JPanel();
        lblNhanVien = new javax.swing.JLabel();
        jplKhachHang = new javax.swing.JPanel();
        lblKhachHang = new javax.swing.JLabel();
        jplThongKe = new javax.swing.JPanel();
        lblThongKe = new javax.swing.JLabel();
        lblDoiMatKhau = new javax.swing.JLabel();
        jplKhuyenMai = new javax.swing.JPanel();
        lblKhuyenMai = new javax.swing.JLabel();
        lblDangXuat = new javax.swing.JLabel();
        jplQLSP = new javax.swing.JPanel();
        lblQuanLySP = new javax.swing.JLabel();
        jplContain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/store.png"))); // NOI18N
        jLabel1.setText("CỬA HÀNG BÁN LAPTOP");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nhân viên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Vai trò:");

        lblHoTen.setForeground(new java.awt.Color(255, 0, 0));

        lblVaiTro.setForeground(new java.awt.Color(255, 0, 0));

        jplBanHang.setLayout(new java.awt.GridLayout(1, 0));

        lblBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/BanHang.png"))); // NOI18N
        lblBanHang.setText("Bán hàng");
        lblBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBanHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBanHangMouseExited(evt);
            }
        });
        jplBanHang.add(lblBanHang);

        jplQlHoaDon.setLayout(new java.awt.GridLayout(1, 0));

        lblQLHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/hoadon.png"))); // NOI18N
        lblQLHoaDon.setText("Quản lý hoá đơn");
        lblQLHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQLHoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQLHoaDonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQLHoaDonMouseExited(evt);
            }
        });
        jplQlHoaDon.add(lblQLHoaDon);

        jplNhanvien.setLayout(new java.awt.GridLayout(1, 0));

        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/thong tin.png"))); // NOI18N
        lblNhanVien.setText("Quản lý khách hàng");
        lblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseExited(evt);
            }
        });
        jplNhanvien.add(lblNhanVien);

        jplKhachHang.setLayout(new java.awt.GridLayout(1, 0));

        lblKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/thong tin.png"))); // NOI18N
        lblKhachHang.setText("Quản lý nhân viên");
        lblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseExited(evt);
            }
        });
        jplKhachHang.add(lblKhachHang);

        jplThongKe.setLayout(new java.awt.GridLayout(1, 0));

        lblThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/thongke.png"))); // NOI18N
        lblThongKe.setText("Thống kê");
        lblThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThongKeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblThongKeMouseExited(evt);
            }
        });
        jplThongKe.add(lblThongKe);

        lblDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDoiMatKhau.setText("Đổi mật khẩu ");
        lblDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDoiMatKhauMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDoiMatKhauMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDoiMatKhauMouseExited(evt);
            }
        });

        jplKhuyenMai.setLayout(new java.awt.GridLayout(1, 0));

        lblKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/KhuyenMai.png"))); // NOI18N
        lblKhuyenMai.setText("Khuyến mại");
        lblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhuyenMaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblKhuyenMaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblKhuyenMaiMouseExited(evt);
            }
        });
        jplKhuyenMai.add(lblKhuyenMai);

        lblDangXuat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/thoat.png"))); // NOI18N
        lblDangXuat.setText("Đăng xuất");
        lblDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseExited(evt);
            }
        });

        jplQLSP.setLayout(new java.awt.GridLayout(1, 0));

        lblQuanLySP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sanpham_1.png"))); // NOI18N
        lblQuanLySP.setText("Quản lý sản phẩm");
        lblQuanLySP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuanLySPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuanLySPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuanLySPMouseExited(evt);
            }
        });
        jplQLSP.add(lblQuanLySP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jplThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jplQlHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jplNhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jplKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(jplBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jplKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jplQLSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(lblDoiMatKhau)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVaiTro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(lblDoiMatKhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jplBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jplQlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jplNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jplQLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jplKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jplKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jplThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jplContain.setLayout(new javax.swing.BoxLayout(jplContain, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jplContain, javax.swing.GroupLayout.DEFAULT_SIZE, 1234, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jplContain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseClicked
        panel = new JplKhachHang();
        setPanel(panel);
    }//GEN-LAST:event_lblNhanVienMouseClicked

    private void lblNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseEntered
        setColor(jplNhanvien);
    }//GEN-LAST:event_lblNhanVienMouseEntered

    private void lblNhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseExited
        resetColor(jplNhanvien);
    }//GEN-LAST:event_lblNhanVienMouseExited

    private void lblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseClicked
        panel = new JplNhanVien();
        setPanel(panel);
    }//GEN-LAST:event_lblKhachHangMouseClicked

    private void lblKhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseEntered
        setColor(jplKhachHang);
    }//GEN-LAST:event_lblKhachHangMouseEntered

    private void lblKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseExited
        resetColor(jplKhachHang);
    }//GEN-LAST:event_lblKhachHangMouseExited

    private void lblThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongKeMouseClicked
        panel = new JplThongKe();
        setPanel(panel);
    }//GEN-LAST:event_lblThongKeMouseClicked

    private void lblThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongKeMouseEntered
        setColor(jplThongKe);
    }//GEN-LAST:event_lblThongKeMouseEntered

    private void lblThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongKeMouseExited
        resetColor(jplThongKe);
    }//GEN-LAST:event_lblThongKeMouseExited

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất không?");
        if (hoi != JOptionPane.OK_OPTION) {
            return;
        } else {
            UserInfo.tenTK = null;
            new FrmDangNhap().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void lblDangXuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseEntered
        lblDangXuat.setForeground(Color.red);
    }//GEN-LAST:event_lblDangXuatMouseEntered

    private void lblDangXuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseExited
        lblDangXuat.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblDangXuatMouseExited

    private void lblQLHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQLHoaDonMouseClicked
        panel = new JplHoaDon();
        setPanel(panel);
    }//GEN-LAST:event_lblQLHoaDonMouseClicked

    private void lblQLHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQLHoaDonMouseEntered
        setColor(jplQlHoaDon);
    }//GEN-LAST:event_lblQLHoaDonMouseEntered

    private void lblQLHoaDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQLHoaDonMouseExited
        resetColor(jplQlHoaDon);
    }//GEN-LAST:event_lblQLHoaDonMouseExited

    private void lblBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHangMouseClicked
        panel = new JplBanHang();
        setPanel(panel);
    }//GEN-LAST:event_lblBanHangMouseClicked

    private void lblBanHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHangMouseEntered
        setColor(jplBanHang);
    }//GEN-LAST:event_lblBanHangMouseEntered

    private void lblBanHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHangMouseExited
        resetColor(jplBanHang);
    }//GEN-LAST:event_lblBanHangMouseExited

    private void lblQuanLySPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLySPMouseClicked
        panel = new JplQuanLySP();
        setPanel(panel);
    }//GEN-LAST:event_lblQuanLySPMouseClicked

    private void lblQuanLySPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLySPMouseEntered
        setColor(jplQLSP);
    }//GEN-LAST:event_lblQuanLySPMouseEntered

    private void lblQuanLySPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLySPMouseExited
        resetColor(jplQLSP);
    }//GEN-LAST:event_lblQuanLySPMouseExited

    private void lblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhuyenMaiMouseClicked
        panel = new JplKhuyenMai();
        setPanel(panel);
    }//GEN-LAST:event_lblKhuyenMaiMouseClicked

    private void lblKhuyenMaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhuyenMaiMouseEntered
        setColor(jplKhuyenMai);
    }//GEN-LAST:event_lblKhuyenMaiMouseEntered

    private void lblKhuyenMaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhuyenMaiMouseExited
        resetColor(jplKhuyenMai);
    }//GEN-LAST:event_lblKhuyenMaiMouseExited

    private void lblDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoiMatKhauMouseClicked
        new DoiMatKhau().setVisible(true);
    }//GEN-LAST:event_lblDoiMatKhauMouseClicked

    private void lblDoiMatKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoiMatKhauMouseEntered
        lblDoiMatKhau.setForeground(Color.red);
    }//GEN-LAST:event_lblDoiMatKhauMouseEntered

    private void lblDoiMatKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoiMatKhauMouseExited
        lblDoiMatKhau.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblDoiMatKhauMouseExited

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
            java.util.logging.Logger.getLogger(FrmGiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGiaoDien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jplBanHang;
    private javax.swing.JPanel jplContain;
    private javax.swing.JPanel jplKhachHang;
    private javax.swing.JPanel jplKhuyenMai;
    private javax.swing.JPanel jplNhanvien;
    private javax.swing.JPanel jplQLSP;
    private javax.swing.JPanel jplQlHoaDon;
    private javax.swing.JPanel jplThongKe;
    private javax.swing.JLabel lblBanHang;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblDoiMatKhau;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblQLHoaDon;
    private javax.swing.JLabel lblQuanLySP;
    private javax.swing.JLabel lblThongKe;
    private javax.swing.JLabel lblVaiTro;
    // End of variables declaration//GEN-END:variables
}
