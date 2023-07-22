/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.chucnangchinh;

import domainmodels.ChiTietSPView;
import domainmodels.ChiTietSP;
import iservices.IChiTietSPService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.ChiTietSPService;
import utilities.ULHelper;
import java.sql.Date;
import java.time.LocalDate;
import services.CheckTrungService;
import services.ChiTietSPService;
import utilities.ULHelper;
import view.quanlysp.FrmCPU;
import view.quanlysp.FrmDongSP;
import view.quanlysp.FrmManHinh;
import view.quanlysp.FrmMauSac;
import view.quanlysp.FrmNSX;
import view.quanlysp.FrmRAM;
import view.quanlysp.FrmSSD;
import view.quanlysp.FrmSanPham;

/**
 *
 * @author ADMIN
 */
public class JplQuanLySP extends javax.swing.JPanel {

    private final IChiTietSPService Services = new ChiTietSPService() {
    };
    List<ChiTietSPView> lstDSP = new ArrayList<>();
    DefaultTableModel modelDSP = new DefaultTableModel();
    Map<String, String> ten = new HashMap<>();
    Map<String, String> nsx = new HashMap<>();
    Map<String, String> mau = new HashMap<>();
    Map<String, String> dong = new HashMap<>();
    Map<String, String> cpu = new HashMap<>();
    Map<String, String> ram = new HashMap<>();
    Map<String, String> ssd = new HashMap<>();
    Map<String, String> mh = new HashMap<>();
    Map<String, String> bh = new HashMap<>();
    Date date = Date.valueOf(LocalDate.now());
    int index;

    public JplQuanLySP() {
        initComponents();
        modelDSP = (DefaultTableModel) tblDSP.getModel();
        ten = Services.hashMapTenSp();
        nsx = Services.hashMapNoiSx();
        mau = Services.hashMapMauSac();
        dong = Services.hashMapDongSp();
        cpu = Services.hashMapCPU();
        ram = Services.hashMapRAM();
        ssd = Services.hashMapSSD();
        mh = Services.hashMapManHinh();
        bh = Services.hashMapBaoHanh();
        loadTen();
        filltable();
    }

    public void loadTen() {
        Set<String> keyTenSp = ten.keySet();
        Set<String> keyNoiSx = nsx.keySet();
        Set<String> keyMauSx = mau.keySet();
        Set<String> keyDongSp = dong.keySet();
        Set<String> keyCPU = cpu.keySet();
        Set<String> keyRAM = ram.keySet();
        Set<String> keySSD = ssd.keySet();
        Set<String> keyMH = mh.keySet();
        Set<String> keyBH = bh.keySet();
        cboTenSp.removeAllItems();
        cboNoiSX.removeAllItems();
        cbomauSac.removeAllItems();
        cboDongsp.removeAllItems();
        cboCPU.removeAllItems();
        cboRAM.removeAllItems();
        cboSSD.removeAllItems();
        cboMH.removeAllItems();
        cboBH.removeAllItems();
        for (String a : keyTenSp) {
            cboTenSp.addItem(ten.get(a));
        }
        for (String a : keyNoiSx) {
            cboNoiSX.addItem(nsx.get(a));
        }
        for (String a : keyMauSx) {
            cbomauSac.addItem(mau.get(a));
        }
        for (String a : keyDongSp) {
            cboDongsp.addItem(dong.get(a));
        }
        for (String a : keyCPU) {
            cboCPU.addItem(cpu.get(a));
        }
        for (String a : keyRAM) {
            cboRAM.addItem(ram.get(a));
        }
        for (String a : keySSD) {
            cboSSD.addItem(ssd.get(a));
        }
        for (String a : keyMH) {
            cboMH.addItem(mh.get(a));
        }
        for (String a : keyBH) {
            cboBH.addItem(bh.get(a));
        }
    }

    public void filltable() {
        try {
            modelDSP.setRowCount(0);
            lstDSP = Services.getAll(ten, nsx, mau, dong, cpu, ram, ssd, mh, bh);
            for (ChiTietSPView a : lstDSP) {
                modelDSP.addRow(new Object[]{
                    a.getTenSP(), a.getNSX(), a.getMauSac(), a.getDongSP(), a.getCPU(), a.getRAM(), a.getSSD(), a.getManHinh(), a.getBaoHanh(), a.getCanNang(), a.getMoTa(), a.getSoLuongTon(), a.getGiaNhap(), a.getGiaBan(), a.getNgayTao(), a.getNgaySua(), a.getStatus(a.getTrangThai())
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showdetail(int index) {
        try {
            lblMa.setText(lstDSP.get(index).getMa());
            cboTenSp.setSelectedItem(lstDSP.get(index).getTenSP());
            cboNoiSX.setSelectedItem(lstDSP.get(index).getNSX());
            cbomauSac.setSelectedItem(lstDSP.get(index).getNSX());
            cboDongsp.setSelectedItem(lstDSP.get(index).getDongSP());
            cboRAM.setSelectedItem(lstDSP.get(index).getRAM());
            cboSSD.setSelectedItem(lstDSP.get(index).getSSD());
            cboMH.setSelectedItem(lstDSP.get(index).getManHinh());
            cboBH.setSelectedItem(lstDSP.get(index).getBaoHanh());
            txtCanNang.setText("" + lstDSP.get(index).getSoLuongTon());
            txtMota.setText(lstDSP.get(index).getMoTa());
            txtTon.setText("" + lstDSP.get(index).getSoLuongTon());
            txtNhap.setText("" + lstDSP.get(index).getGiaNhap());
            txtBan.setText("" + lstDSP.get(index).getGiaBan());
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

        btgDSP = new javax.swing.ButtonGroup();
        pnlDongSP = new javax.swing.JPanel();
        pnlDongInfo = new javax.swing.JPanel();
        pnlDSPbtn = new javax.swing.JPanel();
        btnAdd1 = new javax.swing.JButton();
        btnShow1 = new javax.swing.JButton();
        btnEdit1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        btnHide1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMota = new javax.swing.JTextField();
        txtTon = new javax.swing.JTextField();
        txtNhap = new javax.swing.JTextField();
        txtBan = new javax.swing.JTextField();
        txtCanNang = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lblMa = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cboDongsp = new javax.swing.JComboBox<>();
        btnDong = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbomauSac = new javax.swing.JComboBox<>();
        btnMauSac = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cboNoiSX = new javax.swing.JComboBox<>();
        btnNSX = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        cboTenSp = new javax.swing.JComboBox<>();
        btnTen = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        cboCPU = new javax.swing.JComboBox<>();
        btnCPU = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        cboRAM = new javax.swing.JComboBox<>();
        btnRAM = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        cboSSD = new javax.swing.JComboBox<>();
        btnSSD = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        cboMH = new javax.swing.JComboBox<>();
        btnMH = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        cboBH = new javax.swing.JComboBox<>();
        btnBH = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDSP = new javax.swing.JTable();
        pnlDSPsrc = new javax.swing.JPanel();
        btnAdd2 = new javax.swing.JButton();
        btnDelete2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnTang1 = new javax.swing.JButton();
        btnGiam1 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        cboTrangThai1 = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();

        pnlDongSP.setBackground(new java.awt.Color(255, 230, 234));

        pnlDongInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlDongInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN SẢN PHẨM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        btnAdd1.setBackground(new java.awt.Color(255, 51, 0));
        btnAdd1.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd1.setText("Thêm");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });

        btnShow1.setBackground(new java.awt.Color(255, 51, 0));
        btnShow1.setForeground(new java.awt.Color(255, 255, 255));
        btnShow1.setText("Hiện");
        btnShow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShow1ActionPerformed(evt);
            }
        });

        btnEdit1.setBackground(new java.awt.Color(255, 51, 0));
        btnEdit1.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit1.setText("Sửa");
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1ActionPerformed(evt);
            }
        });

        btnDelete1.setBackground(new java.awt.Color(255, 51, 0));
        btnDelete1.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete1.setText("Xóa");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        btnHide1.setBackground(new java.awt.Color(255, 51, 0));
        btnHide1.setForeground(new java.awt.Color(255, 255, 255));
        btnHide1.setText("Ẩn");
        btnHide1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHide1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDSPbtnLayout = new javax.swing.GroupLayout(pnlDSPbtn);
        pnlDSPbtn.setLayout(pnlDSPbtnLayout);
        pnlDSPbtnLayout.setHorizontalGroup(
            pnlDSPbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDSPbtnLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlDSPbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHide1)
                    .addComponent(btnDelete1)
                    .addComponent(btnEdit1)
                    .addComponent(btnShow1)
                    .addComponent(btnAdd1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlDSPbtnLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd1, btnDelete1, btnEdit1, btnHide1, btnShow1});

        pnlDSPbtnLayout.setVerticalGroup(
            pnlDSPbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDSPbtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnShow1)
                .addGap(18, 18, 18)
                .addComponent(btnHide1)
                .addGap(18, 18, 18)
                .addComponent(btnAdd1)
                .addGap(18, 18, 18)
                .addComponent(btnEdit1)
                .addGap(18, 18, 18)
                .addComponent(btnDelete1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDSPbtnLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd1, btnDelete1, btnEdit1, btnHide1, btnShow1});

        jLabel10.setText("Cân nặng");

        jLabel11.setText("Giá nhập");

        jLabel12.setText("Số lượng");

        jLabel13.setText("Mô tả");

        jLabel14.setText("Giá bán");

        txtBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBanActionPerformed(evt);
            }
        });

        jLabel18.setText("Mã");

        lblMa.setBackground(java.awt.Color.gray);
        lblMa.setForeground(new java.awt.Color(153, 153, 153));
        lblMa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dòng"));

        cboDongsp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboDongsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDongspActionPerformed(evt);
            }
        });

        btnDong.setBackground(new java.awt.Color(255, 51, 0));
        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboDongsp, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboDongsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Màu sắc"));

        cbomauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnMauSac.setBackground(new java.awt.Color(255, 51, 0));
        btnMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMauSacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbomauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbomauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("NSX"));

        cboNoiSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnNSX.setBackground(new java.awt.Color(255, 51, 0));
        btnNSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNSXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboNoiSX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNoiSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên sản phẩm"));

        cboTenSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnTen.setBackground(new java.awt.Color(255, 51, 0));
        btnTen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTen, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("CPU"));

        cboCPU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCPU.setBackground(new java.awt.Color(255, 51, 0));
        btnCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCPUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(cboCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("RAM"));

        cboRAM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRAM.setBackground(new java.awt.Color(255, 51, 0));
        btnRAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRAMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(cboRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 21, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("SSD"));

        cboSSD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSSD.setBackground(new java.awt.Color(255, 51, 0));
        btnSSD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnSSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSSDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(cboSSD, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSSD, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboSSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSSD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Màn hình"));

        cboMH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnMH.setBackground(new java.awt.Color(255, 51, 0));
        btnMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboMH, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMH, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Bảo hành"));

        cboBH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBH.setBackground(new java.awt.Color(255, 51, 0));
        btnBH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboBH, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBH, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboBH)
                    .addComponent(btnBH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDongInfoLayout = new javax.swing.GroupLayout(pnlDongInfo);
        pnlDongInfo.setLayout(pnlDongInfoLayout);
        pnlDongInfoLayout.setHorizontalGroup(
            pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDongInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDongInfoLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDongInfoLayout.createSequentialGroup()
                        .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDongInfoLayout.createSequentialGroup()
                        .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10)
                            .addComponent(jLabel18))
                        .addGap(17, 17, 17)
                        .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(txtCanNang, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlDongInfoLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(17, 17, 17)
                        .addComponent(txtBan, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDongInfoLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(txtNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDongInfoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(17, 17, 17)
                        .addComponent(txtTon, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(pnlDSPbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlDongInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel13, jLabel14});

        pnlDongInfoLayout.setVerticalGroup(
            pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDongInfoLayout.createSequentialGroup()
                .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDongInfoLayout.createSequentialGroup()
                        .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(pnlDongInfoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblMa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCanNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDongInfoLayout.createSequentialGroup()
                        .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlDongInfoLayout.createSequentialGroup()
                                .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlDongInfoLayout.createSequentialGroup()
                                .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlDongInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDongInfoLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(pnlDSPbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        tblDSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên", "NSX", "Màu", "Dòng", "CPU", "RAM", "SSD", "Màn hình", "Mã BH", "Cân", "Mô tả", "Tồn", "Giá nhập", "Giá bán", "Ngày tạo", "Ngày sửa", "Trạng thái"
            }
        ));
        tblDSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSPMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblDSP);

        pnlDSPsrc.setBackground(new java.awt.Color(255, 255, 255));
        pnlDSPsrc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÊM IMEI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        btnAdd2.setBackground(new java.awt.Color(255, 51, 0));
        btnAdd2.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd2.setText("Thêm");
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });

        btnDelete2.setBackground(new java.awt.Color(255, 51, 0));
        btnDelete2.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete2.setText("Xóa");
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });

        jLabel15.setText("IDCTSP");

        jLabel16.setText("IMEI");

        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pnlDSPsrcLayout = new javax.swing.GroupLayout(pnlDSPsrc);
        pnlDSPsrc.setLayout(pnlDSPsrcLayout);
        pnlDSPsrcLayout.setHorizontalGroup(
            pnlDSPsrcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDSPsrcLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDSPsrcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDSPsrcLayout.createSequentialGroup()
                        .addComponent(btnAdd2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete2))
                    .addGroup(pnlDSPsrcLayout.createSequentialGroup()
                        .addGroup(pnlDSPsrcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(18, 33, Short.MAX_VALUE)
                        .addGroup(pnlDSPsrcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(6, 6, 6))
        );

        pnlDSPsrcLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel15, jLabel16});

        pnlDSPsrcLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel17, jTextField1});

        pnlDSPsrcLayout.setVerticalGroup(
            pnlDSPsrcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDSPsrcLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnlDSPsrcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(pnlDSPsrcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 38, Short.MAX_VALUE)
                .addGroup(pnlDSPsrcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd2)
                    .addComponent(btnDelete2))
                .addContainerGap())
        );

        pnlDSPsrcLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel15, jLabel16});

        pnlDSPsrcLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel17, jTextField1});

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 51, 0))); // NOI18N

        btnTang1.setText("Tăng");

        btnGiam1.setText("Giảm");

        jLabel49.setText("Tìm tên:");

        jLabel51.setText("Trạng thái:");

        jLabel50.setText("Sắp xếp theo tên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnTang1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName1)
                            .addComponent(cboTrangThai1, 0, 129, Short.MAX_VALUE)
                            .addComponent(btnGiam1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabel50))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel49, jLabel51});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboTrangThai1, txtName1});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnGiam1, btnTang1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(cboTrangThai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTang1)
                    .addComponent(btnGiam1))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboTrangThai1, txtName1});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel49, jLabel51});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGiam1, btnTang1});

        javax.swing.GroupLayout pnlDongSPLayout = new javax.swing.GroupLayout(pnlDongSP);
        pnlDongSP.setLayout(pnlDongSPLayout);
        pnlDongSPLayout.setHorizontalGroup(
            pnlDongSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDongSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDongSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDongSPLayout.createSequentialGroup()
                        .addComponent(pnlDongInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 30, Short.MAX_VALUE))
                    .addGroup(pnlDongSPLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(pnlDSPsrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(pnlDongSPLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlDongSPLayout.setVerticalGroup(
            pnlDongSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDongSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDongInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(pnlDongSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDSPsrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
        try {
            if (ULHelper.checknull(txtMota, "Không được để mô tả trống!")) {
                return;
            }
            if (ULHelper.checknull(txtTon, "Không được để tên trống!")) {
                return;
            }
            if (ULHelper.checknull(txtCanNang, "Không được để tên trống!")) {
                return;
            }
            if (ULHelper.checknull(txtNhap, "Không được để tên trống!")) {
                return;
            }
            if (ULHelper.checknull(txtBan, "Không được để tên trống!")) {
                return;
            }
            ChiTietSPView dsp = new ChiTietSPView(cboTenSp.getSelectedItem() + "",
                    cboNoiSX.getSelectedItem() + "",
                    cbomauSac.getSelectedItem() + "", cboDongsp.getSelectedItem() + "", cboCPU.getSelectedItem() + "", cboRAM.getSelectedItem() + "", cboSSD.getSelectedItem() + "", cboMH.getSelectedItem() + "", cboBH.getSelectedItem() + "", Double.parseDouble(txtCanNang.getText()), txtMota.getText(), Integer.parseInt(txtTon.getText()), BigDecimal.valueOf(Double.parseDouble(txtNhap.getText())), BigDecimal.valueOf(Double.parseDouble(txtBan.getText())), date, date, 1);
            int thongBao = Services.them(dsp, ten, nsx, mau, dong, cpu, ram, ssd, mh, bh);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                filltable();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnShow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShow1ActionPerformed
        // TODO add your handling code here:
        try {
            filltable();
            showdetail(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnShow1ActionPerformed

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed
        // TODO add your handling code here:
        try {
            if (ULHelper.checknull(txtMota, "Không được để mô tả trống!")) {
                return;
            }
            if (ULHelper.checknull(txtTon, "Không được để tên trống!")) {
                return;
            }
            if (ULHelper.checknull(txtCanNang, "Không được để tên trống!")) {
                return;
            }
            if (ULHelper.checknull(txtNhap, "Không được để tên trống!")) {
                return;
            }
            if (ULHelper.checknull(txtBan, "Không được để tên trống!")) {
                return;
            }
            lstDSP = Services.getAll(ten, nsx, mau, dong, cpu, ram, ssd, mh, bh);

            Date tao = lstDSP.get(index).getNgayTao();
            String id = lstDSP.get(index).getId();
            ChiTietSPView dsp = new ChiTietSPView(cboTenSp.getSelectedItem() + "",
                    cboNoiSX.getSelectedItem() + "",
                    cbomauSac.getSelectedItem() + "", cboDongsp.getSelectedItem() + "", cboCPU.getSelectedItem() + "", cboRAM.getSelectedItem() + "", cboSSD.getSelectedItem() + "", cboMH.getSelectedItem() + "", cboBH.getSelectedItem() + "", Double.parseDouble(txtCanNang.getText()), txtMota.getText(), Integer.parseInt(txtTon.getText()), BigDecimal.valueOf(Double.parseDouble(txtNhap.getText())), BigDecimal.valueOf(Double.parseDouble(txtBan.getText())), tao, date, 1);
            int thongBao = Services.sua(dsp, ten, nsx, mau, dong, cpu, ram, ssd, mau, dong, id);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Sửa thành công!");
                filltable();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEdit1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
        try {
            String ma = txtMota.getText();
            int thongBao = Services.xoa(ma);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                filltable();
                showdetail(0);
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnHide1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHide1ActionPerformed
        // TODO add your handling code here:
        try {
            lblMa.setText("");
            cboTenSp.setSelectedItem("");
            cboNoiSX.setSelectedItem("");
            cbomauSac.setSelectedItem("");
            cboDongsp.setSelectedItem("");
            cboRAM.setSelectedItem("");
            cboSSD.setSelectedItem("");
            cboMH.setSelectedItem("");
            cboBH.setSelectedItem("");
            txtCanNang.setText("");
            txtMota.setText("");
            txtTon.setText("");
            txtNhap.setText("");
            txtBan.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnHide1ActionPerformed

    private void tblDSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSPMouseClicked
        // TODO add your handling code here:
        try {
            int index = tblDSP.getSelectedRow();
            showdetail(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblDSPMouseClicked

    private void txtBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBanActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void btnNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNSXActionPerformed
        new FrmNSX().setVisible(true);
    }//GEN-LAST:event_btnNSXActionPerformed

    private void btnMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMauSacActionPerformed
        new FrmMauSac().setVisible(true);
    }//GEN-LAST:event_btnMauSacActionPerformed

    private void btnTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTenActionPerformed
        new FrmSanPham().setVisible(true);
    }//GEN-LAST:event_btnTenActionPerformed

    private void btnCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCPUActionPerformed
         new FrmCPU().setVisible(true);
    }//GEN-LAST:event_btnCPUActionPerformed

    private void btnRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRAMActionPerformed
        new FrmRAM().setVisible(true);
    }//GEN-LAST:event_btnRAMActionPerformed

    private void btnSSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSSDActionPerformed
        new FrmSSD().setVisible(true);
    }//GEN-LAST:event_btnSSDActionPerformed

    private void btnBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBHActionPerformed

    }//GEN-LAST:event_btnBHActionPerformed

    private void btnMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMHActionPerformed
        new FrmManHinh().setVisible(true);
    }//GEN-LAST:event_btnMHActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        new FrmDongSP().setVisible(true);
    }//GEN-LAST:event_btnDongActionPerformed

    private void cboDongspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDongspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDongspActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgDSP;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnBH;
    private javax.swing.JButton btnCPU;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnEdit1;
    private javax.swing.JButton btnGiam1;
    private javax.swing.JButton btnHide1;
    private javax.swing.JButton btnMH;
    private javax.swing.JButton btnMauSac;
    private javax.swing.JButton btnNSX;
    private javax.swing.JButton btnRAM;
    private javax.swing.JButton btnSSD;
    private javax.swing.JButton btnShow1;
    private javax.swing.JButton btnTang1;
    private javax.swing.JButton btnTen;
    private javax.swing.JComboBox<String> cboBH;
    private javax.swing.JComboBox<String> cboCPU;
    private javax.swing.JComboBox<String> cboDongsp;
    private javax.swing.JComboBox<String> cboMH;
    private javax.swing.JComboBox<String> cboNoiSX;
    private javax.swing.JComboBox<String> cboRAM;
    private javax.swing.JComboBox<String> cboSSD;
    private javax.swing.JComboBox<String> cboTenSp;
    private javax.swing.JComboBox<String> cboTrangThai1;
    private javax.swing.JComboBox<String> cbomauSac;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblMa;
    private javax.swing.JPanel pnlDSPbtn;
    private javax.swing.JPanel pnlDSPsrc;
    private javax.swing.JPanel pnlDongInfo;
    private javax.swing.JPanel pnlDongSP;
    private javax.swing.JTable tblDSP;
    private javax.swing.JTextField txtBan;
    private javax.swing.JTextField txtCanNang;
    private javax.swing.JTextField txtMota;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtNhap;
    private javax.swing.JTextField txtTon;
    // End of variables declaration//GEN-END:variables
}
