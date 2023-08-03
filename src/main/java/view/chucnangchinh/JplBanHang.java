/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.chucnangchinh;

import domainmodels.ChiTietHD;
import domainmodels.ChiTietSP;
import domainmodels.DongSP;
import domainmodels.HoaDon;
import domainmodels.Imei;
import domainmodels.ImeiDaBan;
import domainmodels.KhachHang;
import domainmodels.KhuyenMai;
import domainmodels.NhanVien;
import iservices.IChiTietHDService;
import iservices.IChiTietSPService;
import iservices.IDongSPService;
import iservices.IHoaDonService;
import iservices.IImeiDaBanService;
import iservices.IImeiService;
import iservices.IKhachHangService;
import iservices.INhanVienService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import services.ChiTietHDService;
import services.ChiTietSPService;
import services.DongSPService;
import services.HoaDonService;
import services.ImeiDaBanService;
import services.ImeiService;
import services.KhachHangService;
import services.KhuyenMaiService;
import services.NhanVienService;
import utilities.UserInfo;

/**
 *
 * @author ADMIN
 */
public class JplBanHang extends javax.swing.JPanel {

    private IHoaDonService hoaDonService = new HoaDonService();
    private INhanVienService nhanVienService = new NhanVienService();
    private IKhachHangService khachHangService = new KhachHangService();
    private IImeiService imeiService = new ImeiService();
    private IDongSPService dongSPService = new DongSPService();
    private IChiTietHDService chiTietHDService = new ChiTietHDService();
    private IChiTietSPService chiTietSPService = new ChiTietSPService();
    private IImeiDaBanService imeiDaBanService = new ImeiDaBanService();
    private KhuyenMaiService khuyenMaiService = new KhuyenMaiService();
    DefaultTableModel model = new DefaultTableModel();
    DefaultComboBoxModel<DongSP> modelDongSP = new DefaultComboBoxModel<DongSP>();
    int indexHD;
    int indexGH;
    int indexSP;
    int indexIM;
    int indexIMDC;

    /**
     * Creates new form jplBanHang
     */
    public JplBanHang() {
        initComponents();

        LoadTableHoaDon();
        LoadTableSanPham();
        LoadComboboxDongSP();
        LoadComboboxKM();
        LoadTableByCBBDongSP();
        txtTimKiemSP.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                timKiemSP();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                timKiemSP();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                timKiemSP();
            }
        });
        txtTienKhachDua.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                capNhatTienTraKhach();
            }
        });
        LoadDuLieuTheoMaKM();
    }

    private void LoadTableHoaDon() {
        List<HoaDon> lstHoaDon = hoaDonService.getAll();
        if (lstHoaDon == null) {
            JOptionPane.showMessageDialog(this, "Lỗi!");
        } else {
            int count = 1;
            model = (DefaultTableModel) tblHoaDon.getModel();
            model.setRowCount(0);
            for (HoaDon hoaDon : lstHoaDon) {
                String hoTenNV = nhanVienService.getHoTenById(hoaDon.getIdNV());
                String hoTenKH = khachHangService.getHoTenById(hoaDon.getIdKH());
                model.addRow(new Object[]{count++, hoaDon.getMa(), hoaDon.getNgayTao(), hoTenNV, hoTenKH, hoaDon.getTrangThai() == 0 ? "Chờ thanh toán" : "Đã thanh toán"});
            }
        }
    }

    private void LoadTableSanPham() {
        List<ChiTietSP> lstChiTietSP = chiTietSPService.getAllCTSP();
        if (lstChiTietSP == null) {
            JOptionPane.showMessageDialog(this, "Lỗi!");
        } else if (lstChiTietSP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có dữ liệu sản phẩm!");
        } else {
            int count = 1;
            model = (DefaultTableModel) tblSanPham.getModel();
            model.setRowCount(0);
            for (ChiTietSP chiTietSP : lstChiTietSP) {
                model.addRow(new Object[]{
                    count++,
                    chiTietSP.getMa(),
                    chiTietSP.getIdSP(),
                    chiTietSP.getIdMauSac(),
                    chiTietSP.getIdRam(),
                    chiTietSP.getIdSSD(),
                    chiTietSP.getIdCPU(),
                    chiTietSP.getIdManHinh(),
                    chiTietSP.getIdBH(),
                    chiTietSP.getGiaBan(),
                    chiTietSP.getSoLuongTon(),
                    chiTietSP.getTrangThai() == 1 ? "Còn hàng" : "Hết hàng"
                });
                String ma = chiTietSP.getMa();
                int soLuong = chiTietSP.getSoLuongTon();
                if (soLuong == 0) {
                    chiTietSPService.updateTrangThai("0", ma);
                }
            }
        }

    }

    private void timKiemSP() {
        List<ChiTietSP> lstChiTietSP = chiTietSPService.getAllCTSP();
        int count = 1;
        String keyword = txtTimKiemSP.getText().trim().toLowerCase();
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (ChiTietSP chiTietSP : lstChiTietSP) {
            String tenSP = chiTietSP.getIdSP();
            String mauSac = chiTietSP.getIdMauSac();
            String ram = chiTietSP.getIdRam();
            String ssd = chiTietSP.getIdSSD();
            String cpu = chiTietSP.getIdCPU();
            String manHinh = chiTietSP.getIdManHinh();
            BigDecimal donGia = chiTietSP.getGiaBan();
            //Kiểm tra từ khóa tìm kiếm
            if (tenSP.toLowerCase().contains(keyword)
                    || mauSac.toLowerCase().contains(keyword)
                    || ram.toLowerCase().contains(keyword)
                    || ssd.toLowerCase().contains(keyword)
                    || cpu.toLowerCase().contains(keyword)
                    || manHinh.toLowerCase().contains(keyword)
                    || getSPByKhoangGia(keyword, donGia)) {
                rdoTatCa.setSelected(false);
                model.addRow(new Object[]{
                    count++,
                    chiTietSP.getMa(),
                    chiTietSP.getIdSP(),
                    chiTietSP.getIdMauSac(),
                    chiTietSP.getIdRam(),
                    chiTietSP.getIdSSD(),
                    chiTietSP.getIdCPU(),
                    chiTietSP.getIdManHinh(),
                    chiTietSP.getIdBH(),
                    chiTietSP.getGiaBan(),
                    chiTietSP.getSoLuongTon(),
                    chiTietSP.getTrangThai() == 1 ? "Còn hàng" : "Hết hàng"
                });
            }
        }
    }

    private boolean getSPByKhoangGia(String keyword, BigDecimal donGia) {
        //Định dạng nhập khoảng giá (num-num)
        Pattern pattern = Pattern.compile("(\\d+)\\s*-\\s*(\\d+)");
        Matcher matcher = pattern.matcher(keyword);

        //Kiểm tra giá trị có trong khoảng giá?
        if (matcher.matches()) {
            BigDecimal min = new BigDecimal(matcher.group(1));
            BigDecimal max = new BigDecimal(matcher.group(2));
            return donGia.compareTo(min) >= 0 && donGia.compareTo(max) <= 0;
        }
        return false;
    }

    private void LoadComboboxDongSP() {
        List<DongSP> lstDongSP = dongSPService.getAll();
        cbbDongSP.removeAllItems();
        for (DongSP dongSP : lstDongSP) {
            cbbDongSP.addItem(dongSP + "");
        }
    }

    private void LoadComboboxKM() {
        List<KhuyenMai> lstKhuyenMai = khuyenMaiService.getAllTrangThai(0);
        cbbMaGiamGia.removeAllItems();
        for (KhuyenMai khuyenMai : lstKhuyenMai) {
            cbbMaGiamGia.addItem(khuyenMai + "");
        }
    }

    private void LoadTableByCBBDongSP() {
        cbbDongSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rdoTatCa.setSelected(false);
                String tenDSP = cbbDongSP.getSelectedItem().toString();
                List<ChiTietSP> lstChiTietSP = chiTietSPService.getAllByDongSP(tenDSP);
                if (lstChiTietSP == null) {
                    JOptionPane.showMessageDialog(null, "Lỗi!");
                } else {
                    int count = 1;
                    model = (DefaultTableModel) tblSanPham.getModel();
                    model.setRowCount(0);
                    for (ChiTietSP chiTietSP : lstChiTietSP) {
                        model.addRow(new Object[]{
                            count++,
                            chiTietSP.getMa(),
                            chiTietSP.getIdSP(),
                            chiTietSP.getIdMauSac(),
                            chiTietSP.getIdRam(),
                            chiTietSP.getIdSSD(),
                            chiTietSP.getIdCPU(),
                            chiTietSP.getIdManHinh(),
                            chiTietSP.getIdBH(),
                            chiTietSP.getGiaBan(),
                            chiTietSP.getSoLuongTon(),
                            chiTietSP.getTrangThai() == 1 ? "Còn hàng" : "Hết hàng"
                        });
                    }
                }
            }
        });
    }

    private void TaoHoaDon() {
        //Lấy thông tin tạo hóa đơn
        String idKH = khachHangService.getIdBySDT(txtSdt.getText());
        String idNV = nhanVienService.getIdByTen(UserInfo.tenTK);

        //Kiểm tra khách hàng chọn sản phẩm trước hay tạo hóa đơn trước
        if (txtSdt.getText().equals("")) {
            HoaDon hoaDon = new HoaDon();
            hoaDon.setIdNV(idNV);
            hoaDonService.them(hoaDon);
            LoadTableHoaDon();
        } else {
            HoaDon hoaDon = new HoaDon();
            hoaDon.setIdKH(idKH);
            hoaDon.setIdNV(idNV);
            hoaDonService.themIdNV_IdKH(hoaDon);
            LoadTableHoaDon();
        }

        //Chọn hóa đơn vừa tạo
        tblHoaDon.setRowSelectionInterval(0, 0);
        indexHD = tblHoaDon.getSelectedRow();
    }

    private void showDetailHD() {
        indexHD = tblHoaDon.getSelectedRow();
        String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();

        txtMaHD.setText(maHD);
    }

    private void ThemSanPhamVaoGioHang() {
        indexHD = tblHoaDon.getSelectedRow();
        if (indexHD == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn thêm sản phẩm!");
            return;
        }
        indexSP = tblSanPham.getSelectedRow();
        if (indexSP == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm muốn thêm vào giỏ hàng!");
            return;
        }

        String soLuong = tblSanPham.getValueAt(indexSP, 10).toString();
        if (soLuong.equals("0")) {
            JOptionPane.showMessageDialog(this, "Hiện tại sản phẩm này đã hết hàng!");
            return;
        }
        //Check maCTSP đã tồn tại
        String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();
        String idHD = hoaDonService.getIdByMa(maHD);
        List<ChiTietHD> lstChiTietHD = chiTietHDService.getAllByIdHD(idHD);
        for (ChiTietHD cthd : lstChiTietHD) {
            String maCtsp = tblSanPham.getValueAt(indexSP, 1).toString();
            if (cthd.getIdChiTietSP().getMa().equals(maCtsp)) {
                JOptionPane.showMessageDialog(this, "Sản phẩm đã tồn tại trong giỏ hàng!");
                return;
            }
        }

        String maCTSP = tblSanPham.getValueAt(indexSP, 1).toString();
        ChiTietSP idCTSP = chiTietSPService.getIdByMa(maCTSP);
        BigDecimal donGia = (BigDecimal) tblSanPham.getValueAt(indexSP, 9);

        ChiTietHD chiTietHD = new ChiTietHD();
        chiTietHD.setIdHD(idHD);
        chiTietHD.setIdChiTietSP(idCTSP);
        chiTietHD.setDonGia(donGia);

        lstChiTietHD.add(chiTietHD);
        chiTietHDService.them(chiTietHD);
        LoadTableGioHang();
    }

    private void LoadTableGioHang() {
        //Load giỏ hàng theo idHD
        String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();
        String idHD = hoaDonService.getIdByMa(maHD);
        List<ChiTietHD> lstChiTietHD = chiTietHDService.getAllByIdHD(idHD);
        if (lstChiTietHD.isEmpty()) {
            txtTongTien.setText("");
            txtThanhTien.setText("");
            txtSoTienGiam.setText("");
        }
        if (lstChiTietHD == null) {
            JOptionPane.showMessageDialog(this, "Lỗi!");
        } else {
            int count = 1;
            BigDecimal tongTien = BigDecimal.ZERO;
            model = (DefaultTableModel) tblGioHang.getModel();
            model.setRowCount(0);
            for (ChiTietHD chiTietHD : lstChiTietHD) {
                int soLuong = chiTietHD.getSoLuong();
                BigDecimal donGia = chiTietHD.getDonGia();
                BigDecimal thanhTien = donGia.multiply(BigDecimal.valueOf(soLuong));
                model.addRow(new Object[]{
                    count++,
                    chiTietHD.getIdChiTietSP().getMa(),
                    chiTietHD.getIdChiTietSP().getIdSP(),
                    chiTietHD.getSoLuong(),
                    chiTietHD.getDonGia(),
                    thanhTien
                });
                tongTien = tongTien.add(thanhTien);
                txtTongTien.setText(tongTien.toString());
                txtThanhTien.setText(tongTien.toString());
                if (txtSoTienGiam.getText().equals("")) {
                    txtSoTienGiam.setText("0");
                }
            }
        }
    }

    private void LoadTableImei() {
        indexGH = tblGioHang.getSelectedRow();
        String maCtsp = tblGioHang.getValueAt(indexGH, 1).toString();
        ChiTietSP idCtsp = chiTietSPService.getIdByMa(maCtsp);
        List<Imei> lstImei = imeiService.getAllByIdCtsp(idCtsp + "");
        if (lstImei == null) {
            JOptionPane.showMessageDialog(this, "Lỗi dữ liệu Imei!");
        } else {
            int count = 1;
            model = (DefaultTableModel) tblImei.getModel();
            model.setRowCount(0);
            for (Imei imei : lstImei) {
                model.addRow(new Object[]{count++, imei.getImei(), imei.getIdChiTietSP().getIdSP(), imei.getTrangThai() == 0 ? "Chưa bán" : "Đã bán"});
            }
        }
    }

    private void LoadTableImeiDaChon() {
        String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();
        String idHD = hoaDonService.getIdByMa(maHD);
        String maCtsp = tblGioHang.getValueAt(indexGH, 1).toString();
        ChiTietSP idCtsp = chiTietSPService.getIdByMa(maCtsp);
        List<ImeiDaBan> lstImeiDaBan = imeiDaBanService.getImeiByIdHD_IdCTSP(idHD, idCtsp + "");
        if (lstImeiDaBan == null) {
            JOptionPane.showMessageDialog(this, "Lỗi dữ liệu Imei đã bán!");
        } else {
            int count = 1;
            model = (DefaultTableModel) tblIMeiDaChon.getModel();
            model.setRowCount(0);
            for (ImeiDaBan imeiDaBan : lstImeiDaBan) {
                model.addRow(new Object[]{count++, imeiDaBan.getImei()});
            }
        }
    }

    private void capNhatTienTraKhach() {
        try {
            BigDecimal thanhTien = new BigDecimal(txtThanhTien.getText());
            BigDecimal tienKhachDua = new BigDecimal(txtTienKhachDua.getText());
            try {
                tienKhachDua = new BigDecimal(txtTienKhachDua.getText());
                Integer TKD = Integer.parseInt(tienKhachDua + "");
                if (TKD < 0) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập tiền là số dương!");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Khách chưa trả đủ tiền!");
                return;
            }

            //Tính tiền trả khách
            BigDecimal tienTraKhach = tienKhachDua.subtract(thanhTien);

            txtTienTraKhach.setText(tienTraKhach.toString());
        } catch (NumberFormatException e) {
            txtTienTraKhach.setText("");
        }
    }

    private void capNhatThanhTien() {
        try {
            BigDecimal tongTien = new BigDecimal(txtTongTien.getText());
            BigDecimal soTienGiam = new BigDecimal(txtSoTienGiam.getText());
            BigDecimal thanhTien = new BigDecimal(txtThanhTien.getText());

            //tính thành tiền
            if (soTienGiam.equals("")) {
                thanhTien = tongTien;
            } else {
                thanhTien = tongTien.subtract(soTienGiam);
                txtThanhTien.setText(thanhTien.toString());
            }

        } catch (NumberFormatException e) {
            txtThanhTien.setText("");
        }
    }

    private void LoadDuLieuTheoMaKM() {
        cbbMaGiamGia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maKM = cbbMaGiamGia.getSelectedItem().toString();
                List<KhuyenMai> lstKhuyenMai = khuyenMaiService.getAllByMa(maKM);
                for (KhuyenMai khuyenMai : lstKhuyenMai) {
                    txtSoLuongMaGG.setText(khuyenMai.getSoLuong() + "");
                    txtSoTienGiam.setText(khuyenMai.getSoTienGiam() + "");
                }
                capNhatThanhTien();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ThemKhachHang = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtHoTenKH = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtSdtKH = new javax.swing.JTextField();
        txtDiaChiKH = new javax.swing.JTextField();
        btnThemKH = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtNgaySinhKH = new com.toedter.calendar.JDateChooser();
        ChonIMei = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblImei = new javax.swing.JTable();
        btnThemImei = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblIMeiDaChon = new javax.swing.JTable();
        btnBoChon = new javax.swing.JButton();
        btnDoiSanPham = new javax.swing.JButton();
        btnTimKiemImei = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiemImei = new javax.swing.JTextField();
        btnTatCa = new javax.swing.JButton();
        HuyHoaDon = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtLyDoHuy = new javax.swing.JTextArea();
        btnDongY = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnTaoHD = new javax.swing.JButton();
        btnHuyHD = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiemSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbbDongSP = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnThemGioHang = new javax.swing.JButton();
        rdoTatCa = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTienTraKhach = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnTim = new javax.swing.JButton();
        txtMaHD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnTaoKH = new javax.swing.JButton();
        txtHoTen = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnChonKH = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        cbbMaGiamGia = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        txtSoTienGiam = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtSoLuongMaGG = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();

        ThemKhachHang.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel17.setText("Họ tên");

        jLabel19.setText("SDT");

        jLabel20.setText("Địa chỉ");

        jLabel18.setText("Ngày sinh");

        txtDiaChiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiKHActionPerformed(evt);
            }
        });

        btnThemKH.setBackground(new java.awt.Color(255, 0, 0));
        btnThemKH.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/them20.png"))); // NOI18N
        btnThemKH.setText("Thêm");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setText("THÔNG TIN KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel19))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiaChiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSdtKH)
                            .addComponent(txtNgaySinhKH, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(161, 161, 161))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDiaChiKH, txtHoTenKH});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel23)
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtHoTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(txtSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(37, 37, 37)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(jLabel20)
                                .addComponent(txtDiaChiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txtNgaySinhKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnThemKH)
                .addGap(62, 62, 62))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel17, jLabel18, jLabel19, jLabel20, txtDiaChiKH, txtHoTenKH, txtSdtKH});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ThemKhachHangLayout = new javax.swing.GroupLayout(ThemKhachHang.getContentPane());
        ThemKhachHang.getContentPane().setLayout(ThemKhachHangLayout);
        ThemKhachHangLayout.setHorizontalGroup(
            ThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ThemKhachHangLayout.setVerticalGroup(
            ThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tblImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "IMei", "Tên sản phẩm", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblImei);

        btnThemImei.setBackground(new java.awt.Color(255, 0, 0));
        btnThemImei.setForeground(new java.awt.Color(255, 255, 255));
        btnThemImei.setText("Thêm");
        btnThemImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemImeiActionPerformed(evt);
            }
        });

        tblIMeiDaChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "IMei đã chọn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblIMeiDaChon);

        btnBoChon.setBackground(new java.awt.Color(255, 0, 0));
        btnBoChon.setForeground(new java.awt.Color(255, 255, 255));
        btnBoChon.setText("Bỏ chọn");
        btnBoChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoChonActionPerformed(evt);
            }
        });

        btnDoiSanPham.setBackground(new java.awt.Color(255, 0, 0));
        btnDoiSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiSanPham.setText("Đổi sản phẩm khác");
        btnDoiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiSanPhamActionPerformed(evt);
            }
        });

        btnTimKiemImei.setBackground(new java.awt.Color(255, 0, 0));
        btnTimKiemImei.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemImei.setText("Tìm kiếm");
        btnTimKiemImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemImeiActionPerformed(evt);
            }
        });

        jLabel1.setText("Nhập số Imei: ");

        btnTatCa.setBackground(new java.awt.Color(255, 0, 0));
        btnTatCa.setForeground(new java.awt.Color(255, 255, 255));
        btnTatCa.setText("Tất cả");
        btnTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtTimKiemImei, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiemImei, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnThemImei, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnBoChon, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnDoiSanPham)
                .addGap(143, 143, 143))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiemImei)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemImei, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemImei)
                    .addComponent(btnBoChon)
                    .addComponent(btnDoiSanPham)
                    .addComponent(btnTatCa))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ChonIMeiLayout = new javax.swing.GroupLayout(ChonIMei.getContentPane());
        ChonIMei.getContentPane().setLayout(ChonIMeiLayout);
        ChonIMeiLayout.setHorizontalGroup(
            ChonIMeiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ChonIMeiLayout.setVerticalGroup(
            ChonIMeiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel8.setText("Lý do hủy hóa đơn:");

        txtLyDoHuy.setColumns(20);
        txtLyDoHuy.setRows(5);
        jScrollPane6.setViewportView(txtLyDoHuy);

        btnDongY.setBackground(new java.awt.Color(255, 0, 0));
        btnDongY.setForeground(new java.awt.Color(255, 255, 255));
        btnDongY.setText("Đồng ý");
        btnDongY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongYActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDongY, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDongY)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HuyHoaDonLayout = new javax.swing.GroupLayout(HuyHoaDon.getContentPane());
        HuyHoaDon.getContentPane().setLayout(HuyHoaDonLayout);
        HuyHoaDonLayout.setHorizontalGroup(
            HuyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        HuyHoaDonLayout.setVerticalGroup(
            HuyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 230, 234));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hoá đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hoá đơn", "Ngày tạo", "Nhân viên", "Khách hàng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        btnTaoHD.setBackground(new java.awt.Color(255, 51, 51));
        btnTaoHD.setForeground(java.awt.Color.white);
        btnTaoHD.setText("Tạo");
        btnTaoHD.setDoubleBuffered(true);
        btnTaoHD.setFocusTraversalPolicyProvider(true);
        btnTaoHD.setHideActionText(true);
        btnTaoHD.setMargin(new java.awt.Insets(2, 20, 3, 20));
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        btnHuyHD.setBackground(new java.awt.Color(255, 51, 51));
        btnHuyHD.setForeground(java.awt.Color.white);
        btnHuyHD.setText("Hủy");
        btnHuyHD.setDoubleBuffered(true);
        btnHuyHD.setFocusTraversalPolicyProvider(true);
        btnHuyHD.setHideActionText(true);
        btnHuyHD.setMargin(new java.awt.Insets(2, 20, 3, 20));
        btnHuyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHuyHD)
                    .addComponent(btnTaoHD))
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnTaoHD)
                .addGap(18, 18, 18)
                .addComponent(btnHuyHD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã ctsp", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblGioHang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("Tìm kiếm");

        jLabel3.setText("Dòng sản phẩm:");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã ctsp", "Tên sp", "Màu sắc", "RamGB", "SSD", "CPU", "Màn hình", "Thời gian bh", "Đơn giá", "Số lượng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblSanPham);

        btnThemGioHang.setBackground(new java.awt.Color(255, 51, 51));
        btnThemGioHang.setForeground(java.awt.Color.white);
        btnThemGioHang.setText("Thêm giỏ hàng");
        btnThemGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGioHangActionPerformed(evt);
            }
        });

        rdoTatCa.setText("Tất cả");
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnThemGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbbDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoTatCa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnThemGioHang)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đơn hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel6.setText("Mã hoá đơn:");

        jLabel9.setText("Tổng tiền:");

        txtTongTien.setEditable(false);

        jLabel10.setText("Tiền khách đưa:");

        jLabel11.setText("Tiền trả khách:");

        txtTienTraKhach.setEditable(false);

        btnThanhToan.setBackground(new java.awt.Color(255, 0, 0));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setForeground(java.awt.Color.white);
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-print-30.png"))); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel4.setText("Tìm kiếm khách hàng:");

        btnTim.setBackground(new java.awt.Color(255, 0, 0));
        btnTim.setForeground(new java.awt.Color(255, 255, 255));
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        txtMaHD.setEditable(false);

        jLabel5.setText("Khách hàng:");

        jLabel7.setText("Họ tên:");

        jLabel12.setText("Sdt:");

        btnTaoKH.setBackground(new java.awt.Color(255, 0, 0));
        btnTaoKH.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoKH.setText("Tạo");
        btnTaoKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoKHActionPerformed(evt);
            }
        });

        txtHoTen.setEditable(false);

        txtSdt.setEditable(false);

        btnChonKH.setBackground(new java.awt.Color(255, 0, 0));
        btnChonKH.setForeground(new java.awt.Color(255, 255, 255));
        btnChonKH.setText("Chọn");
        btnChonKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKHActionPerformed(evt);
            }
        });

        jLabel21.setText("Mã giảm giá:");

        jLabel24.setText("Số tiền giảm:");

        txtSoTienGiam.setEditable(false);

        txtThanhTien.setEditable(false);

        jLabel25.setText("Thành tiền:");

        txtSoLuongMaGG.setEditable(false);
        txtSoLuongMaGG.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnLamMoi.setBackground(new java.awt.Color(255, 0, 0));
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(txtSdt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChonKH, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTaoKH, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTienTraKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(cbbMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSoLuongMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtSoTienGiam)
                                    .addComponent(txtThanhTien))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel6, jLabel9});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtMaHD, txtSoTienGiam, txtThanhTien, txtTienKhachDua, txtTienTraKhach, txtTongTien});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnTaoKH, btnTim});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim))
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnTaoKH, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLamMoi)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChonKH))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cbbMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuongMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSoTienGiam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienTraKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbbMaGiamGia, txtMaHD, txtSoLuongMaGG, txtSoTienGiam, txtThanhTien, txtTienKhachDua, txtTienTraKhach, txtTongTien});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel6, jLabel9});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnTaoKH, btnTim});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel3, jPanel4});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1179, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 1, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 5, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // tìm kiếm khách hàng theo sdt or email
        if (txtTimKiem.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập vào số điện thoại hoặc email!");
            txtTimKiem.requestFocus();
            return;
        }
        KhachHang khachHang = khachHangService.getThongTinBySdt(txtTimKiem.getText());
        if (khachHang.getSdt() == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin khách hàng!");
            txtSdt.setText("");
            txtHoTen.setText("");
        } else {
            String hoTenKH = khachHang.getHoTen();
            txtHoTen.setText(hoTenKH);
            txtSdt.setText(khachHang.getSdt());
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        // Tạo hóa đơn
        TaoHoaDon();
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void btnTaoKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoKHActionPerformed
        ThemKhachHang.setSize(590, 300);
        ThemKhachHang.setResizable(false);
        ThemKhachHang.setLocationRelativeTo(null);
        ThemKhachHang.setVisible(true);
    }//GEN-LAST:event_btnTaoKHActionPerformed

    private void txtDiaChiKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiKHActionPerformed

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        // Thêm
        try {
            if (txtSdtKH.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập vào số điện thoại!");
                txtSdtKH.requestFocus();
                return;
            }
            if (txtHoTenKH.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập vào họ tên!");
                txtHoTenKH.requestFocus();
                return;
            }
            if (txtDiaChiKH.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập vào địa chỉ!");
                txtDiaChiKH.requestFocus();
                return;
            }

            //Check trùng số điện thoại
            List<KhachHang> lstKhachHang = khachHangService.getAll();
            for (KhachHang khachHang : lstKhachHang) {
                if (khachHang.getSdt().equals(txtSdtKH.getText())) {
                    JOptionPane.showMessageDialog(this, "Đã có thông tin của khách hàng này, hãy quay trở lại tìm kiếm!");
                    txtTimKiem.requestFocus();
                    ThemKhachHang.dispose();
                    return;
                }
            }
            //check SDT
            if (utilities.ULHelper.CheckSDT(txtSdtKH, "Nhập số điện thoại đúng định dạng !")) {
                return;
            }

            String sdt = txtSdtKH.getText();
            String hoTen = txtHoTenKH.getText();
            Date ngaySinh = (Date) txtNgaySinhKH.getDate();
            String diaChi = txtDiaChiKH.getText();

            KhachHang khachHang = new KhachHang();
            khachHang.setSdt(sdt);
            khachHang.setHoTen(hoTen);
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setDiaChi(diaChi);

            Integer result = khachHangService.them(khachHang);
            if (result > -1) {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
                txtHoTen.setText(khachHang.getHoTen());
                txtSdt.setText(khachHang.getSdt());
                ThemKhachHang.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
        // tất cả SP
        LoadTableSanPham();
    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // showDeTail Hoa don
        showDetailHD();
        LoadTableGioHang();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnThemGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGioHangActionPerformed
        // Thêm vào giỏ hàng   
        ThemSanPhamVaoGioHang();
    }//GEN-LAST:event_btnThemGioHangActionPerformed

    private void btnThemImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemImeiActionPerformed
        // Thêm Imei
        indexIM = tblImei.getSelectedRow();
        if (indexIM == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Imei cần lấy!");
            return;
        }
        //Check Imei đã được chọn?
        String imeiCheck = tblImei.getValueAt(indexIM, 1).toString();
        List<ImeiDaBan> lstImeiDaBan = imeiDaBanService.getAll();
        for (ImeiDaBan imeiDaBan : lstImeiDaBan) {
            if (imeiDaBan.getImei().equals(imeiCheck)) {
                JOptionPane.showMessageDialog(this, "Imei này đã được chọn rồi!");
                return;
            }
        }

        String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();
        String idHD = hoaDonService.getIdByMa(maHD);
        String maCTSP = tblGioHang.getValueAt(indexGH, 1).toString();
        ChiTietSP idCTSP = chiTietSPService.getIdByMa(maCTSP);
        String idCTHD = chiTietHDService.getIdByIdCTSP_IdHD(idCTSP + "", idHD);
        String imei = tblImei.getValueAt(indexIM, 1).toString();

        ImeiDaBan imeiDaBan = new ImeiDaBan();
        imeiDaBan.setImei(imei);
        imeiDaBan.setIdChiTietHD(idCTHD);
        imeiDaBanService.them(imeiDaBan);
        LoadTableImeiDaChon();

        //Tăng số lượng chiTietHD
        String mahd = tblHoaDon.getValueAt(indexHD, 1).toString();
        String idhd = hoaDonService.getIdByMa(mahd);
        String maCtsp = tblGioHang.getValueAt(indexGH, 1).toString();
        ChiTietSP idCtsp = chiTietSPService.getIdByMa(maCtsp);
        chiTietHDService.themSoLuong(idhd, idCtsp + "");
        LoadTableGioHang();

        //update lại thành tiền
        String thanhTien = tblGioHang.getValueAt(indexGH, 5).toString();
        chiTietHDService.updateThanhTien(thanhTien, idhd, idCTSP + "");
    }//GEN-LAST:event_btnThemImeiActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // hiển thị danh sách Imei theo idChiTietSP
        LoadTableImei();
        LoadTableImeiDaChon();
        ChonIMei.setSize(800, 380);
        ChonIMei.setResizable(false);
        ChonIMei.setLocationRelativeTo(null);
        ChonIMei.setVisible(true);
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnBoChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoChonActionPerformed
        // Bỏ chọn Imei
        indexIMDC = tblIMeiDaChon.getSelectedRow();
        if (indexIMDC == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Imei cần bỏ!");
            return;
        }
        String imei = tblIMeiDaChon.getValueAt(indexIMDC, 1).toString();
        imeiDaBanService.xoa(imei);
        LoadTableImeiDaChon();

        //Giảm số lượng trong chiTietHD
        String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();
        String idHD = hoaDonService.getIdByMa(maHD);
        String maCtsp = tblGioHang.getValueAt(indexGH, 1).toString();
        ChiTietSP idCtsp = chiTietSPService.getIdByMa(maCtsp);
        chiTietHDService.botSoLuong(idHD, idCtsp + "");
        LoadTableGioHang();
    }//GEN-LAST:event_btnBoChonActionPerformed

    private void btnDoiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiSanPhamActionPerformed
        // xóa sản phẩm tại giỏ hàng
        String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();
        String idHD = hoaDonService.getIdByMa(maHD);

        String maCTSP = tblGioHang.getValueAt(indexGH, 1).toString();
        ChiTietSP idCTSP = chiTietSPService.getIdByMa(maCTSP);
        String idCTHD = chiTietHDService.getIdByIdCTSP_IdHD(idCTSP + "", idHD);
        String maCtsp = tblGioHang.getValueAt(indexGH, 1).toString();
        ChiTietSP idCtsp = chiTietSPService.getIdByMa(maCtsp);

        //Xóa imei bên bảng đã bán
        imeiDaBanService.xoaAll(idCTHD);
        //Xóa sản phẩm bên giỏ hàng
        chiTietHDService.xoa(idCtsp + "", idHD);
        LoadTableGioHang();
        ChonIMei.dispose();
    }//GEN-LAST:event_btnDoiSanPhamActionPerformed

    private void btnHuyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHDActionPerformed
        // Hủy hóa đơn
        indexHD = tblHoaDon.getSelectedRow();
        if (indexHD == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần hủy!");
            return;
        }
        HuyHoaDon.setSize(600, 200);
        HuyHoaDon.setResizable(false);
        HuyHoaDon.setLocationRelativeTo(null);
        HuyHoaDon.setVisible(true);
    }//GEN-LAST:event_btnHuyHDActionPerformed

    private void btnTimKiemImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemImeiActionPerformed
        // Tìm kiếm imei
        //Check rỗng Imei
        if (txtTimKiemImei.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Imei cần tìm!");
            return;
        }
        String maCtsp = tblGioHang.getValueAt(indexGH, 1).toString();
        ChiTietSP idCtsp = chiTietSPService.getIdByMa(maCtsp);
        List<Imei> lstImei = imeiService.timKiemImei(idCtsp + "", txtTimKiemImei.getText());
        if (lstImei == null) {
            JOptionPane.showMessageDialog(this, "Lỗi dữ liệu Imei!");
        } else if (lstImei.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy Imei, vui lòng nhập lại!");
        } else {
            int count = 1;
            model = (DefaultTableModel) tblImei.getModel();
            model.setRowCount(0);
            for (Imei imei : lstImei) {
                model.addRow(new Object[]{count++, imei.getImei(), imei.getIdChiTietSP().getIdSP(), imei.getTrangThai() == 0 ? "Chưa bán" : "Đã bán"});
            }
        }
    }//GEN-LAST:event_btnTimKiemImeiActionPerformed

    private void btnTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTatCaActionPerformed
        // Hiển thị tất cả imei theo idChiTietSP
        LoadTableImei();
    }//GEN-LAST:event_btnTatCaActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // Thanh toán
        //Check idKH đã được thêm vào hóa đơn chưa
        indexHD = tblHoaDon.getSelectedRow();
        if (indexHD == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần thanh toán!");
            return;
        }
        String idKH = (String) tblHoaDon.getValueAt(indexHD, 4);
        if (idKH == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng thêm thông tin khách hàng vào hóa đơn!");
            return;
        }

        //check khách đã chọn sản phẩm chưa
        String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();
        String idHD = hoaDonService.getIdByMa(maHD);
        List<ChiTietHD> lstChiTietHD = chiTietHDService.getAllByIdHD(idHD);
        if (lstChiTietHD.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giỏ hàng đang trống vui lòng thêm sản phẩm để thanh toán!");
            return;
        }
        for (ChiTietHD chiTietHD : lstChiTietHD) {
            if (chiTietHD.getSoLuong() == 0) {
                JOptionPane.showMessageDialog(this, "Có sản phẩm trong giỏ mà khách hàng chưa chọn, hãy bỏ sản phẩm hoặc chọn sản phẩm");
                return;
            }
        }

        //Check khách đã đưa tiền chưa
        if (txtTienKhachDua.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Khách vẫn chưa trả tiền!");
            txtTienKhachDua.requestFocus();
            return;
        }

        //check tiền khách đưa là số
        try {
            double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tiền là số!");
            txtTienKhachDua.requestFocus();
            return;
        }

        //Check tiền trả khách
        double tienTraKhach = Double.parseDouble(txtTienTraKhach.getText());
        if (tienTraKhach < 0) {
            JOptionPane.showMessageDialog(this, "Khách chưa trả đủ tiền!");
            txtTienKhachDua.requestFocus();
            return;
        }

        //Thanh toán
        //update trạng thái hóa đơn
        String thanhTien = txtThanhTien.getText();
        String km = txtSoTienGiam.getText();
        hoaDonService.updateTrangThai("1", "0", thanhTien, km, idHD);

        //update trạng thái chiTietHD
        chiTietHDService.updateTrangThai("1", idHD);

        //update trạng thái imeiDaBan
        imeiDaBanService.updateTrangThai("1", idHD);

        //update trạng thái imei
        List<ImeiDaBan> lstImeiDaBan = imeiDaBanService.getImeiByIdHD(idHD);
        for (ImeiDaBan imeiDaBan : lstImeiDaBan) {
            imeiService.updateTrangThai("1", imeiDaBan.getImei());
        }
        JOptionPane.showMessageDialog(this, "Thanh toán thành công");

        //update số lượng chiTietSP
        for (ChiTietHD chiTietHD : lstChiTietHD) {
            String maCtsp = chiTietSPService.getMaById(chiTietHD.getIdChiTietSP() + "");
            chiTietSPService.updateSoLuong(chiTietHD.getSoLuong() + "", maCtsp);
        }
        LoadTableSanPham();

        //update số lượng khuyến mãi
        if (!txtSoTienGiam.getText().equals("0")) {
            String maKM = cbbMaGiamGia.getSelectedItem().toString();
            khuyenMaiService.updateSoLuong(maKM);
            List<KhuyenMai> lstKhuyenMai = khuyenMaiService.getAllByMa(maKM);
            for (KhuyenMai khuyenMai : lstKhuyenMai) {
                txtSoLuongMaGG.setText(khuyenMai.getSoLuong() + "");
                txtSoTienGiam.setText(khuyenMai.getSoTienGiam() + "");
            }
        }

        LoadTableHoaDon();
        model = (DefaultTableModel) tblGioHang.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnChonKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKHActionPerformed
        // Thêm kh vào hóa đơn
        //thêm thông tin khách hàng vào hóa đơn
        indexHD = tblHoaDon.getSelectedRow();
        if (indexHD == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần thêm thông tin khách hàng!");
            return;
        }
//        String idKh = tblHoaDon.getValueAt(indexHD, 4).toString();
//        if (idKh != null) {
//            JOptionPane.showMessageDialog(this, "Hóa đơn này đã có thông tin khách hàng!");
//            return;
//        }
        if (txtSdt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng thêm thông tin khách hàng!");
            return;
        }
        String idKH = khachHangService.getIdBySDT(txtSdt.getText());
        String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();
        String idHD = hoaDonService.getIdByMa(maHD);
        hoaDonService.updateIdKH(idKH, idHD);
        LoadTableHoaDon();
        tblHoaDon.setRowSelectionInterval(indexHD, indexHD);
    }//GEN-LAST:event_btnChonKHActionPerformed

    private void btnDongYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongYActionPerformed
        // Đồng ý hủy hóa đơn
        String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();
        String idHD = hoaDonService.getIdByMa(maHD);

        List<ChiTietHD> lstChiTietHD = chiTietHDService.getAllByIdHD(idHD);
        if (!lstChiTietHD.isEmpty()) {
            String maCTSP = tblGioHang.getValueAt(indexGH, 1).toString();
            ChiTietSP idCTSP = chiTietSPService.getIdByMa(maCTSP);
            String idCTHD = chiTietHDService.getIdByIdCTSP_IdHD(idCTSP + "", idHD);

            //Xóa imei đã chọn(bên bảng imei đã bán)
            imeiDaBanService.xoaAll(idCTHD);

            //update số lượng chiTietHD
            chiTietHDService.xoaSoLuong(idHD);
        }
        //update trạng thái HoaDon
        String lyDo = txtLyDoHuy.getText();
        hoaDonService.updateTrangThai("2", lyDo, "0", "0", idHD);

        //update trạng thái ChiTietHD
        chiTietHDService.updateTrangThai("2", idHD);

        LoadTableHoaDon();
        model = (DefaultTableModel) tblGioHang.getModel();
        model.setRowCount(0);

        HuyHoaDon.dispose();
    }//GEN-LAST:event_btnDongYActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // Làm mới khách hàng
        txtHoTen.setText("");
        txtSdt.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog ChonIMei;
    private javax.swing.JDialog HuyHoaDon;
    private javax.swing.JDialog ThemKhachHang;
    private javax.swing.JButton btnBoChon;
    private javax.swing.JButton btnChonKH;
    private javax.swing.JButton btnDoiSanPham;
    private javax.swing.JButton btnDongY;
    private javax.swing.JButton btnHuyHD;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnTaoKH;
    private javax.swing.JButton btnTatCa;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemGioHang;
    private javax.swing.JButton btnThemImei;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnTimKiemImei;
    private javax.swing.JComboBox<String> cbbDongSP;
    private javax.swing.JComboBox<String> cbbMaGiamGia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblIMeiDaChon;
    private javax.swing.JTable tblImei;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtDiaChiKH;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtHoTenKH;
    private javax.swing.JTextArea txtLyDoHuy;
    private javax.swing.JTextField txtMaHD;
    private com.toedter.calendar.JDateChooser txtNgaySinhKH;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSdtKH;
    private javax.swing.JTextField txtSoLuongMaGG;
    private javax.swing.JTextField txtSoTienGiam;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienTraKhach;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemImei;
    private javax.swing.JTextField txtTimKiemSP;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
