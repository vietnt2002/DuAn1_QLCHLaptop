/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.chucnangchinh;

import viewmodel.viewCTSP;
import domainmodels.ChiTietSP;
import domainmodels.Imei;
import iservices.IChiTietSPService;
import iservices.IImeiService;
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
import services.ImeiService;
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
    private final IImeiService Services2 = new ImeiService() {
    };
    List<viewCTSP> lstCTSP = new ArrayList<>();
    DefaultTableModel modelCTSP = new DefaultTableModel();
    List<Imei> lstIMEI = new ArrayList<>();
    DefaultTableModel modelIMEI = new DefaultTableModel();
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
    int num;

    public JplQuanLySP() {
        initComponents();
        modelCTSP = (DefaultTableModel) tblCTSP.getModel();
        modelIMEI = (DefaultTableModel) tblIMEI.getModel();
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
        filltableIMEI();
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
            num = 1;
            modelCTSP.setRowCount(0);
            lstCTSP = Services.getAll(ten, nsx, mau, dong, cpu, ram, ssd, mh, bh);
            for (viewCTSP a : lstCTSP) {
                modelCTSP.addRow(new Object[]{
                    a.getMa(), a.getTenSP(), a.getNSX(), a.getMauSac(), a.getDongSP(), a.getCPU(), a.getRAM(), a.getSSD(), a.getManHinh(), a.getBaoHanh(), a.getCanNang(), a.getMoTa(), a.getSoLuongTon(), a.getGiaNhap(), a.getGiaBan(), a.getNgayTao(), a.getNgaySua(), a.getStatus(a.getTrangThai())
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void filltableIMEI() {
        try {
            num = 1;
            modelIMEI.setRowCount(0);
            lstIMEI = Services2.getAll();
            for (Imei a : lstIMEI) {
                modelIMEI.addRow(new Object[]{
                    num++, a.getImei(), a.getStatus(a.getTrangThai())
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showdetail(int index) {
        try {
            lblMa.setText(lstCTSP.get(index).getMa());
            cboTenSp.setSelectedItem(lstCTSP.get(index).getTenSP());
            cboNoiSX.setSelectedItem(lstCTSP.get(index).getNSX());
            cbomauSac.setSelectedItem(lstCTSP.get(index).getNSX());
            cboDongsp.setSelectedItem(lstCTSP.get(index).getDongSP());
            cboRAM.setSelectedItem(lstCTSP.get(index).getRAM());
            cboSSD.setSelectedItem(lstCTSP.get(index).getSSD());
            cboMH.setSelectedItem(lstCTSP.get(index).getManHinh());
            cboBH.setSelectedItem(lstCTSP.get(index).getBaoHanh());
            txtCanNang.setText("" + lstCTSP.get(index).getCanNang());
            txtMota.setText(lstCTSP.get(index).getMoTa());
            txtTon.setText("" + lstCTSP.get(index).getSoLuongTon());
            txtNhap.setText("" + lstCTSP.get(index).getGiaNhap());
            txtBan.setText("" + lstCTSP.get(index).getGiaBan());
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
        pnlCTSP = new javax.swing.JPanel();
        pnlCTSPInfo = new javax.swing.JPanel();
        pnlCTSPbtn = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
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
        pnlDong = new javax.swing.JPanel();
        cboDongsp = new javax.swing.JComboBox<>();
        btnDong = new javax.swing.JButton();
        pnlMau = new javax.swing.JPanel();
        cbomauSac = new javax.swing.JComboBox<>();
        btnMauSac = new javax.swing.JButton();
        pnlNSX = new javax.swing.JPanel();
        cboNoiSX = new javax.swing.JComboBox<>();
        btnNSX = new javax.swing.JButton();
        pnlSP = new javax.swing.JPanel();
        cboTenSp = new javax.swing.JComboBox<>();
        btnTen = new javax.swing.JButton();
        pnlCPU = new javax.swing.JPanel();
        cboCPU = new javax.swing.JComboBox<>();
        btnCPU = new javax.swing.JButton();
        pnlRAM = new javax.swing.JPanel();
        cboRAM = new javax.swing.JComboBox<>();
        btnRAM = new javax.swing.JButton();
        pnlSSD = new javax.swing.JPanel();
        cboSSD = new javax.swing.JComboBox<>();
        btnSSD = new javax.swing.JButton();
        pnlMH = new javax.swing.JPanel();
        cboMH = new javax.swing.JComboBox<>();
        btnMH = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        cboBH = new javax.swing.JComboBox<>();
        btnBH = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblCTSP = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIMEI = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnSearchIMEI = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        cboTrangThai1 = new javax.swing.JComboBox<>();

        pnlCTSP.setBackground(new java.awt.Color(255, 230, 234));

        pnlCTSPInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlCTSPInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN SẢN PHẨM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        btnAdd.setBackground(new java.awt.Color(255, 51, 0));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnImport.setBackground(new java.awt.Color(255, 51, 0));
        btnImport.setForeground(new java.awt.Color(255, 255, 255));
        btnImport.setText("Nhập");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
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

        btnSearch.setBackground(new java.awt.Color(255, 51, 0));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Tìm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCTSPbtnLayout = new javax.swing.GroupLayout(pnlCTSPbtn);
        pnlCTSPbtn.setLayout(pnlCTSPbtnLayout);
        pnlCTSPbtnLayout.setHorizontalGroup(
            pnlCTSPbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTSPbtnLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlCTSPbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSearch)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit)
                    .addComponent(btnImport)
                    .addComponent(btnAdd))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlCTSPbtnLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit, btnImport, btnSearch});

        pnlCTSPbtnLayout.setVerticalGroup(
            pnlCTSPbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTSPbtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImport)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnEdit)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCTSPbtnLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit, btnImport, btnSearch});

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

        pnlDong.setBackground(new java.awt.Color(255, 255, 255));
        pnlDong.setBorder(javax.swing.BorderFactory.createTitledBorder("Dòng"));

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

        javax.swing.GroupLayout pnlDongLayout = new javax.swing.GroupLayout(pnlDong);
        pnlDong.setLayout(pnlDongLayout);
        pnlDongLayout.setHorizontalGroup(
            pnlDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboDongsp, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlDongLayout.setVerticalGroup(
            pnlDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboDongsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlMau.setBackground(new java.awt.Color(255, 255, 255));
        pnlMau.setBorder(javax.swing.BorderFactory.createTitledBorder("Màu sắc"));

        cbomauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnMauSac.setBackground(new java.awt.Color(255, 51, 0));
        btnMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMauSacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMauLayout = new javax.swing.GroupLayout(pnlMau);
        pnlMau.setLayout(pnlMauLayout);
        pnlMauLayout.setHorizontalGroup(
            pnlMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbomauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMauLayout.setVerticalGroup(
            pnlMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMauLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbomauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlNSX.setBackground(new java.awt.Color(255, 255, 255));
        pnlNSX.setBorder(javax.swing.BorderFactory.createTitledBorder("NSX"));

        cboNoiSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnNSX.setBackground(new java.awt.Color(255, 51, 0));
        btnNSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNSXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNSXLayout = new javax.swing.GroupLayout(pnlNSX);
        pnlNSX.setLayout(pnlNSXLayout);
        pnlNSXLayout.setHorizontalGroup(
            pnlNSXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNSXLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboNoiSX, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlNSXLayout.setVerticalGroup(
            pnlNSXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNSXLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNSXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNoiSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlSP.setBackground(new java.awt.Color(255, 255, 255));
        pnlSP.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên sản phẩm"));

        cboTenSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnTen.setBackground(new java.awt.Color(255, 51, 0));
        btnTen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSPLayout = new javax.swing.GroupLayout(pnlSP);
        pnlSP.setLayout(pnlSPLayout);
        pnlSPLayout.setHorizontalGroup(
            pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboTenSp, 0, 184, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnTen, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSPLayout.setVerticalGroup(
            pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlCPU.setBackground(new java.awt.Color(255, 255, 255));
        pnlCPU.setBorder(javax.swing.BorderFactory.createTitledBorder("CPU"));

        cboCPU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCPU.setBackground(new java.awt.Color(255, 51, 0));
        btnCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCPUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCPULayout = new javax.swing.GroupLayout(pnlCPU);
        pnlCPU.setLayout(pnlCPULayout);
        pnlCPULayout.setHorizontalGroup(
            pnlCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCPULayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(cboCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCPULayout.setVerticalGroup(
            pnlCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCPULayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlRAM.setBackground(new java.awt.Color(255, 255, 255));
        pnlRAM.setBorder(javax.swing.BorderFactory.createTitledBorder("RAM"));

        cboRAM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRAM.setBackground(new java.awt.Color(255, 51, 0));
        btnRAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRAMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRAMLayout = new javax.swing.GroupLayout(pnlRAM);
        pnlRAM.setLayout(pnlRAMLayout);
        pnlRAMLayout.setHorizontalGroup(
            pnlRAMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRAMLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(cboRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlRAMLayout.setVerticalGroup(
            pnlRAMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRAMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRAMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRAMLayout.createSequentialGroup()
                        .addComponent(btnRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pnlSSD.setBackground(new java.awt.Color(255, 255, 255));
        pnlSSD.setBorder(javax.swing.BorderFactory.createTitledBorder("SSD"));

        cboSSD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSSD.setBackground(new java.awt.Color(255, 51, 0));
        btnSSD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnSSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSSDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSSDLayout = new javax.swing.GroupLayout(pnlSSD);
        pnlSSD.setLayout(pnlSSDLayout);
        pnlSSDLayout.setHorizontalGroup(
            pnlSSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSSDLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(cboSSD, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSSD, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSSDLayout.setVerticalGroup(
            pnlSSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSSDLayout.createSequentialGroup()
                .addGroup(pnlSSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboSSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSSD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pnlMH.setBackground(new java.awt.Color(255, 255, 255));
        pnlMH.setBorder(javax.swing.BorderFactory.createTitledBorder("Màn hình"));

        cboMH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnMH.setBackground(new java.awt.Color(255, 51, 0));
        btnMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua20.png"))); // NOI18N
        btnMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMHLayout = new javax.swing.GroupLayout(pnlMH);
        pnlMH.setLayout(pnlMHLayout);
        pnlMHLayout.setHorizontalGroup(
            pnlMHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboMH, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMH, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMHLayout.setVerticalGroup(
            pnlMHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addContainerGap()
                .addComponent(cboBH, 0, 182, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnBH, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboBH))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCTSPInfoLayout = new javax.swing.GroupLayout(pnlCTSPInfo);
        pnlCTSPInfo.setLayout(pnlCTSPInfoLayout);
        pnlCTSPInfoLayout.setHorizontalGroup(
            pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTSPInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlNSX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCTSPInfoLayout.createSequentialGroup()
                        .addComponent(pnlCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCTSPInfoLayout.createSequentialGroup()
                        .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlSSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCTSPInfoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCTSPInfoLayout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCTSPInfoLayout.createSequentialGroup()
                                .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel18))
                                .addGap(17, 17, 17)
                                .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCanNang, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMa, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlCTSPInfoLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(17, 17, 17)
                                .addComponent(txtTon, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlCTSPInfoLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtBan, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(pnlCTSPbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCTSPInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel18});

        pnlCTSPInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel10, pnlCPU, pnlDong, pnlMH, pnlMau, pnlNSX, pnlRAM, pnlSP, pnlSSD});

        pnlCTSPInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblMa, txtBan, txtCanNang, txtMota, txtNhap, txtTon});

        pnlCTSPInfoLayout.setVerticalGroup(
            pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTSPInfoLayout.createSequentialGroup()
                .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCTSPInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCanNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCTSPInfoLayout.createSequentialGroup()
                        .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlCTSPInfoLayout.createSequentialGroup()
                                .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCTSPInfoLayout.createSequentialGroup()
                                .addComponent(pnlDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCTSPInfoLayout.createSequentialGroup()
                                .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnlNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnlRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCTSPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnlMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnlSSD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(pnlCTSPbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        pnlCTSPInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pnlCPU, pnlDong, pnlMH, pnlMau, pnlNSX, pnlRAM, pnlSP, pnlSSD});

        pnlCTSPInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel18, lblMa, txtBan, txtCanNang, txtMota, txtNhap, txtTon});

        tblCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "NSX", "Màu", "Dòng", "CPU", "RAM", "SSD", "Màn hình", "Mã BH", "Cân", "Mô tả", "Tồn", "Giá nhập", "Giá bán", "Ngày tạo", "Ngày sửa", "Trạng thái"
            }
        ));
        tblCTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTSPMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblCTSP);

        tblIMEI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "IMEI", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(tblIMEI);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM IMEI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 51, 0))); // NOI18N

        btnSearchIMEI.setText("Tìm");
        btnSearchIMEI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchIMEIActionPerformed(evt);
            }
        });

        jLabel49.setText("Tìm tên:");

        jLabel51.setText("Trạng thái:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName1)
                    .addComponent(cboTrangThai1, 0, 129, Short.MAX_VALUE)
                    .addComponent(btnSearchIMEI, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel49, jLabel51});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboTrangThai1, txtName1});

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnSearchIMEI)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboTrangThai1, txtName1});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel49, jLabel51});

        javax.swing.GroupLayout pnlCTSPLayout = new javax.swing.GroupLayout(pnlCTSP);
        pnlCTSP.setLayout(pnlCTSPLayout);
        pnlCTSPLayout.setHorizontalGroup(
            pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCTSPLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlCTSPInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 30, Short.MAX_VALUE))
        );
        pnlCTSPLayout.setVerticalGroup(
            pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCTSPInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            if (ULHelper.checknull(txtMota, "Không được để mô tả trống!")) {
                return;
            }
            if (ULHelper.checknull(txtTon, "Không được để số lượng trống!")) {
                return;
            } else {
                try {
                    Double a = Double.parseDouble(txtTon.getText());
                    if (a <= 0) {
                        JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0!");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sai kiểu dữ liệu!");
                    return;
                }
            }
            if (ULHelper.checknull(txtCanNang, "Không được để cân trống!")) {
                return;
            } else {
                try {
                    double a = Double.parseDouble(txtCanNang.getText());
                    if (a <= 0) {
                        JOptionPane.showMessageDialog(this, "Cân phải lớn hơn 0!");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sai kiểu dữ liệu!");
                    return;
                }
            }
            if (ULHelper.checknull(txtNhap, "Không được để giá nhập trống!")) {
                return;
            } else {
                try {
                    BigDecimal a = BigDecimal.valueOf(Double.parseDouble(txtNhap.getText()));
                    if (a.compareTo(BigDecimal.ZERO) <= 0) {
                        JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn 0!");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sai kiểu dữ liệu!");
                    return;
                }
            }
            if (ULHelper.checknull(txtBan, "Không được để giá bán trống!")) {
                return;
            } else {
                try {
                    BigDecimal a = BigDecimal.valueOf(Double.parseDouble(txtBan.getText()));
                    if (a.compareTo(BigDecimal.ZERO) <= 0) {
                        JOptionPane.showMessageDialog(this, "Cân phải lớn hơn 0!");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sai kiểu dữ liệu!");
                    return;
                }
            }
            viewCTSP sp = new viewCTSP(cboTenSp.getSelectedItem() + "",
                    cboNoiSX.getSelectedItem() + "",
                    cbomauSac.getSelectedItem() + "", cboDongsp.getSelectedItem().toString(), cboCPU.getSelectedItem() + "", cboRAM.getSelectedItem() + "", cboSSD.getSelectedItem() + "", cboMH.getSelectedItem() + "", cboBH.getSelectedItem() + "", Double.parseDouble(txtCanNang.getText()), txtMota.getText(), Integer.parseInt(txtTon.getText()), BigDecimal.valueOf(Double.parseDouble(txtNhap.getText())), BigDecimal.valueOf(Double.parseDouble(txtBan.getText())), date, date, 1);
            int thongBao = Services.them(sp, ten, nsx, mau, dong, cpu, ram, ssd, mh, bh);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Thêm CTSP thành công!");
                filltable();
                index = (tblCTSP.getRowCount() - 1);
                showdetail(index);
                ChiTietSP ctsp = Services.getAllCTSP().get(index);
                JOptionPane.showMessageDialog(this, "Mã sản phẩm mới là:" + lstCTSP.get(index).getMa());
                JOptionPane.showMessageDialog(this, "Số sản phẩm mới là:" + lstCTSP.get(index).getSoLuongTon());
                for (int i = 0; i < lstCTSP.get(index).getSoLuongTon(); i++) {
                    Imei im = new Imei(ctsp, date, date, 0);
                    int adi = Services2.them(im);
                    if (adi == 1) {
                        filltableIMEI();
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm IMEI thất bại!");
                    }
                }
                JOptionPane.showMessageDialog(this, "Thêm IMEI thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm CTSP thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        // TODO add your handling code here:
        try {
            int index = tblCTSP.getSelectedRow();
            String imp = JOptionPane.showInputDialog(this, "Nhập số lượng cần nhập");
            if (ULHelper.checknull(txtMota, "Không được để mô tả trống!")) {
                return;
            }
            if (ULHelper.checknull(txtTon, "Không được để số lượng trống!")) {
                return;
            } else {
                try {
                    Double a = Double.parseDouble(txtTon.getText());
                    if (a <= 0) {
                        JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0!");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sai kiểu dữ liệu!");
                    return;
                }
            }
            if (ULHelper.checknull(txtCanNang, "Không được để cân trống!")) {
                return;
            } else {
                try {
                    double a = Double.parseDouble(txtCanNang.getText());
                    if (a <= 0) {
                        JOptionPane.showMessageDialog(this, "Cân phải lớn hơn 0!");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sai kiểu dữ liệu!");
                    return;
                }
            }
            if (ULHelper.checknull(txtNhap, "Không được để giá nhập trống!")) {
                return;
            } else {
                try {
                    BigDecimal a = BigDecimal.valueOf(Double.parseDouble(txtNhap.getText()));
                    if (a.compareTo(BigDecimal.ZERO) <= 0) {
                        JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn 0!");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sai kiểu dữ liệu!");
                    return;
                }
            }
            if (ULHelper.checknull(txtBan, "Không được để giá bán trống!")) {
                return;
            } else {
                try {
                    BigDecimal a = BigDecimal.valueOf(Double.parseDouble(txtBan.getText()));
                    if (a.compareTo(BigDecimal.ZERO) <= 0) {
                        JOptionPane.showMessageDialog(this, "Cân phải lớn hơn 0!");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sai kiểu dữ liệu!");
                    return;
                }
            }
            lstCTSP = Services.getAll(ten, nsx, mau, dong, cpu, ram, ssd, mh, bh);

            Date tao = lstCTSP.get(index).getNgayTao();
            String id = lstCTSP.get(index).getId();
            int ton = lstCTSP.get(index).getSoLuongTon();
            int them = Integer.parseInt(imp);
            int nhap = ton + them;
            viewCTSP dsp;
            dsp = new viewCTSP(cboTenSp.getSelectedItem() + "",
                    cboNoiSX.getSelectedItem() + "",
                    cbomauSac.getSelectedItem() + "", cboDongsp.getSelectedItem() + "", cboCPU.getSelectedItem() + "", cboRAM.getSelectedItem() + "", cboSSD.getSelectedItem() + "", cboMH.getSelectedItem() + "", cboBH.getSelectedItem() + "", Double.parseDouble(txtCanNang.getText()), txtMota.getText(), nhap, BigDecimal.valueOf(Double.parseDouble(txtNhap.getText())), BigDecimal.valueOf(Double.parseDouble(txtBan.getText())), tao, date, 1);
            int thongBao = Services.sua(dsp, ten, nsx, mau, dong, cpu, ram, ssd, mh, bh, id);
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Nhập thành công!");
                filltable();
                index = (tblCTSP.getRowCount() - 1);
                ChiTietSP ctsp = Services.getAllCTSP().get(index);
                for (int i = 0; i < them; i++) {
                    Imei im = new Imei(ctsp, date, date, 0);
                    int adi = Services2.them(im);
                    if (adi == 1) {
                        filltableIMEI();
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm IMEI thất bại!");
                    }
                }
                JOptionPane.showMessageDialog(this, "Thêm IMEI thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Nhập thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        try {
            int index = tblCTSP.getSelectedRow();
            if (ULHelper.checknull(txtMota, "Không được để mô tả trống!")) {
                return;
            }
            if (ULHelper.checknull(txtTon, "Không được để số lượng trống!")) {
                return;
            } else {
                try {
                    Double a = Double.parseDouble(txtTon.getText());
                    if (a <= 0) {
                        JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0!");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sai kiểu dữ liệu!");
                    return;
                }
            }
            if (ULHelper.checknull(txtCanNang, "Không được để cân trống!")) {
                return;
            } else {
                try {
                    double a = Double.parseDouble(txtCanNang.getText());
                    if (a <= 0) {
                        JOptionPane.showMessageDialog(this, "Cân phải lớn hơn 0!");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sai kiểu dữ liệu!");
                    return;
                }
            }
            if (ULHelper.checknull(txtNhap, "Không được để giá nhập trống!")) {
                return;
            } else {
                try {
                    BigDecimal a = BigDecimal.valueOf(Double.parseDouble(txtNhap.getText()));
                    if (a.compareTo(BigDecimal.ZERO) <= 0) {
                        JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn 0!");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sai kiểu dữ liệu!");
                    return;
                }
            }
            if (ULHelper.checknull(txtBan, "Không được để giá bán trống!")) {
                return;
            } else {
                try {
                    BigDecimal a = BigDecimal.valueOf(Double.parseDouble(txtBan.getText()));
                    if (a.compareTo(BigDecimal.ZERO) <= 0) {
                        JOptionPane.showMessageDialog(this, "Cân phải lớn hơn 0!");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sai kiểu dữ liệu!");
                    return;
                }
            }
            lstCTSP = Services.getAll(ten, nsx, mau, dong, cpu, ram, ssd, mh, bh);
            int sta = lstCTSP.get(index).getTrangThai();
            Date tao = lstCTSP.get(index).getNgayTao();
            String id = lstCTSP.get(index).getId();
            viewCTSP dsp = new viewCTSP(cboTenSp.getSelectedItem() + "",
                    cboNoiSX.getSelectedItem() + "",
                    cbomauSac.getSelectedItem() + "", cboDongsp.getSelectedItem() + "", cboCPU.getSelectedItem() + "", cboRAM.getSelectedItem() + "", cboSSD.getSelectedItem() + "", cboMH.getSelectedItem() + "", cboBH.getSelectedItem() + "", Double.parseDouble(txtCanNang.getText()), txtMota.getText(), Integer.parseInt(txtTon.getText()), BigDecimal.valueOf(Double.parseDouble(txtNhap.getText())), BigDecimal.valueOf(Double.parseDouble(txtBan.getText())), tao, date, sta);
            int thongBao = Services.sua(dsp, ten, nsx, mau, dong, cpu, ram, ssd, mh, bh, id);
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
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int index = tblCTSP.getSelectedRow();
            String ma = lstCTSP.get(index).getId();          
            int thongBao = Services.xoa(ma);            
            if (thongBao == 1) {
                JOptionPane.showMessageDialog(this, "Xóa CTSP thành công!");
                filltable();
                num = Services2.xoa(ma);
                if (num == 1) {
                    JOptionPane.showMessageDialog(this, "Xóa IMEI thành công!");
                    filltableIMEI();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại!");
                }
                showdetail(0);
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblCTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTSPMouseClicked
        // TODO add your handling code here:
        try {
            int index = tblCTSP.getSelectedRow();
            showdetail(index);
            System.out.println(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblCTSPMouseClicked

    private void txtBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBanActionPerformed

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

    private void btnSearchIMEIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchIMEIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchIMEIActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
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
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgDSP;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBH;
    private javax.swing.JButton btnCPU;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnMH;
    private javax.swing.JButton btnMauSac;
    private javax.swing.JButton btnNSX;
    private javax.swing.JButton btnRAM;
    private javax.swing.JButton btnSSD;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchIMEI;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblMa;
    private javax.swing.JPanel pnlCPU;
    private javax.swing.JPanel pnlCTSP;
    private javax.swing.JPanel pnlCTSPInfo;
    private javax.swing.JPanel pnlCTSPbtn;
    private javax.swing.JPanel pnlDong;
    private javax.swing.JPanel pnlMH;
    private javax.swing.JPanel pnlMau;
    private javax.swing.JPanel pnlNSX;
    private javax.swing.JPanel pnlRAM;
    private javax.swing.JPanel pnlSP;
    private javax.swing.JPanel pnlSSD;
    private javax.swing.JTable tblCTSP;
    private javax.swing.JTable tblIMEI;
    private javax.swing.JTextField txtBan;
    private javax.swing.JTextField txtCanNang;
    private javax.swing.JTextField txtMota;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtNhap;
    private javax.swing.JTextField txtTon;
    // End of variables declaration//GEN-END:variables
}
