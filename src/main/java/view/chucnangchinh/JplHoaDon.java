/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.chucnangchinh;

import domainmodels.CPU;
import domainmodels.ChiTietHD;
import domainmodels.ChiTietSP;
import domainmodels.Imei;
import domainmodels.ImeiDaBan;
import domainmodels.KhachHang;
import domainmodels.NhanVien;
import domainmodels.RAM;
import domainmodels.SSD;
import iservices.ICPUService;
import iservices.IChiTietHDService;
import iservices.IChiTietSPService;
import iservices.IHoaDonService;
import iservices.IImeiDaBanService;
import iservices.IImeiService;
import iservices.IKhachHangService;
import iservices.IMauSacService;
import iservices.INhanVienService;
import iservices.IRAMService;
import iservices.ISSDService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import repositories.QuanLyHoaDonRepository;
import services.CPUService;
import services.ChiTietHDService;
import services.ChiTietSPService;
import services.HoaDonService;
import services.ImeiDaBanService;
import services.ImeiService;
import services.KhachHangService;
import services.MauSacService;
import services.NhanVienService;
import services.RAMService;
import services.SSDService;
import utilities.UserInfo;
import viewmodel.viewChiTietHoaDon;

/**
 *
 * @author ADMIN
 */
public class JplHoaDon extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel();
    QuanLyHoaDonRepository QLHD = new QuanLyHoaDonRepository();
    INhanVienService nhanVienService = new NhanVienService();
    IKhachHangService khachHangService = new KhachHangService();
    IChiTietSPService chiTietSPService = new ChiTietSPService();
    IHoaDonService hoaDonService = new HoaDonService();
    IChiTietHDService chiTietHDService = new ChiTietHDService();
    IImeiService imeiService = new ImeiService();
    IImeiDaBanService imeiDaBanService = new ImeiDaBanService();
    IRAMService ramService = new RAMService();
    ISSDService ssdService = new SSDService();
    ICPUService cpuService = new CPUService();
    IMauSacService mauSacService = new MauSacService();
    int indexSP;
    int indexIm;
    int indexHD;
    int indexCTHD;
    int indexImLoi;
    int indexImCD;

    public JplHoaDon() {
        initComponents();
        jDate1.setDate(new Date());
        jDate2.setDate(new Date());

        loadHoaDonTheoMaNV();
        loadComboboxRAM();
        loadComboboxSSD();
        loadComboboxCPU();
        timKiemSPTheoRam();
        timKiemSPTheoSSD();
        timKiemSPTheoCPU();
        txtTimSP.getDocument().addDocumentListener(new DocumentListener() {
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
    }

    private void loadHoaDonTheoMaNV() {
        String vaiTro = nhanVienService.setQuyen(UserInfo.tenTK);
        if (vaiTro.equals("Quản lý")) {
            loadDataHoaDon(QLHD.getHoaDon());
        } else {
            loadDataHoaDon(QLHD.getHoaDonByMaNV(UserInfo.tenTK));
        }
    }

    private void loadDataHoaDon(List<viewChiTietHoaDon> list) {
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        int count = 1;
        for (viewChiTietHoaDon hd : list) {
            String hoTenNV = nhanVienService.getHoTenById(hd.getIdNV());
            String hoTenKH = khachHangService.getHoTenById(hd.getIdKH());
            model.addRow(new Object[]{
                count++,
                hd.getMa(),
                hoTenKH,
                hd.getNgayThanhToan(),
                hoTenNV,
                hd.getKhuyenMai(),
                hd.getThanhTien(),
                hd.getTrangThaiString(),
                hd.getGhiChu()
            });
        }
    }

    private void loadDataHoaDonCT(List<viewChiTietHoaDon> list) {
        model = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        model.setRowCount(0);
        for (viewChiTietHoaDon hd : list) {
            model.addRow(new Object[]{
                hd.getImei(),
                hd.getTenSP(),
                hd.getNSX(),
                hd.getMauSac(),
                hd.getDongSP(),
                hd.getCPU(),
                hd.getRAM(),
                hd.getSSD(),
                hd.getManHinh(),
                hd.getCanNang() + " KG",
                hd.getBaoHanh() + " Tháng",
                hd.getMoTa(),
                hd.getGiaBan()
            });
        }
    }

    private void timKiemSPTheoRam() {
        cbbRAM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tenRam = cbbRAM.getSelectedItem().toString();
                List<ChiTietSP> lstChiTietSP = chiTietSPService.getAllByRam(tenRam);
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
        });
    }

    private void timKiemSPTheoSSD() {
        cbbSSD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tenSSD = cbbSSD.getSelectedItem().toString();
                List<ChiTietSP> lstChiTietSP = chiTietSPService.getAllBySSD(tenSSD);
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
        });
    }

    private void timKiemSPTheoCPU() {
        cbbCPU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tenCPU = cbbCPU.getSelectedItem().toString();
                List<ChiTietSP> lstChiTietSP = chiTietSPService.getAllByCPU(tenCPU);
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
        });
    }

    private void timKiemSP() {
        List<ChiTietSP> lstChiTietSP = chiTietSPService.getAllCTSP();
        int count = 1;
        String keyword = txtTimSP.getText().trim().toLowerCase();
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (ChiTietSP chiTietSP : lstChiTietSP) {
            String tenSP = chiTietSP.getIdSP();
            String mauSac = chiTietSP.getIdMauSac();
            //Kiểm tra từ khóa tìm kiếm
            if (tenSP.toLowerCase().contains(keyword) || mauSac.toLowerCase().contains(keyword)) {
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

    private void loadComboboxRAM() {
        List<RAM> lstRam = ramService.getAll();
        cbbRAM.removeAllItems();
        for (RAM ram : lstRam) {
            cbbRAM.addItem(ram + "");
        }
    }

    private void loadComboboxSSD() {
        List<SSD> lstSSD = ssdService.getAll();
        cbbSSD.removeAllItems();
        for (SSD ssd : lstSSD) {
            cbbSSD.addItem(ssd + "");
        }
    }

    private void loadComboboxCPU() {
        List<CPU> lstCPU = cpuService.getAll();
        cbbCPU.removeAllItems();
        for (CPU cpu : lstCPU) {
            cbbCPU.addItem(cpu + "");
        }
    }

    private void suaHoaDon() {
        indexHD = tblHoaDon.getSelectedRow();
        if (indexHD == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần sửa!");
            return;
        }
        indexCTHD = tblHoaDonChiTiet.getSelectedRow();
        if (indexCTHD == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần đổi trả!");
            return;
        }
    }

    private void loadTableSanPhamTheoId() {
        indexCTHD = tblHoaDonChiTiet.getSelectedRow();
        String imei = tblHoaDonChiTiet.getValueAt(indexCTHD, 0).toString();
        String idCTSP = imeiService.getIdByIMei(imei);
        List<ChiTietSP> lstChiTietSP = chiTietSPService.getAllByIdCTSP(idCTSP);
        if (lstChiTietSP == null) {
            JOptionPane.showMessageDialog(this, "Lỗi table sản phẩm!");
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
            }
        }
    }

    private void loadTableSanPham() {
        List<ChiTietSP> lstChiTietSP = chiTietSPService.getAllCTSP();
        if (lstChiTietSP == null) {
            JOptionPane.showMessageDialog(this, "Lỗi table sản phẩm!");
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
            }
        }
    }

    private void loadTableImei() {
        String maCTSP = (String) tblSanPham.getValueAt(indexSP, 1);
        ChiTietSP idCTSP = chiTietSPService.getIdByMa(maCTSP);
        List<Imei> lstImei = imeiService.getAllByIdCtsp(idCTSP + "");
        if (lstImei == null) {
            JOptionPane.showMessageDialog(this, "Lỗi dữ liệu Imei!");
        } else {
            int count = 1;
            model = (DefaultTableModel) tblImei.getModel();
            model.setRowCount(0);
            for (Imei imei : lstImei) {
                String trangThai = "";
                if (imei.getTrangThai() == 0) {
                    trangThai = "Chưa bán";
                } else if (imei.getTrangThai() == 1) {
                    trangThai = "Đã bán";
                } else {
                    trangThai = "Lỗi!";
                }
                model.addRow(new Object[]{count++, imei.getImei(), imei.getIdChiTietSP().getIdSP(), trangThai});
            }
        }
    }

    private void loadTableImeiLoi() {
        indexCTHD = tblHoaDonChiTiet.getSelectedRow();
        String imei = tblHoaDonChiTiet.getValueAt(indexCTHD, 0).toString();
        String tenSP = tblHoaDonChiTiet.getValueAt(indexCTHD, 1).toString();
        String trangThai = "Đã bán";
        model = (DefaultTableModel) tblImeiLoi.getModel();
        model.setRowCount(0);
        model.addRow(new Object[]{imei, tenSP, trangThai});
    }

    private void loadTableImeiCanDoi() {
        indexIm = tblImei.getSelectedRow();
        String imei = tblImei.getValueAt(indexIm, 1).toString();
        String tenSP = tblImei.getValueAt(indexIm, 2).toString();
        String trangThai = tblImei.getValueAt(indexIm, 3).toString();
        if (trangThai.equals("Đã bán")) {
            JOptionPane.showMessageDialog(this, "Imei này đã bán, hãy chọn Imei khác!");
            return;
        }
        if (trangThai.equals("Lỗi!")) {
            JOptionPane.showMessageDialog(this, "Sản phẩm này đã lỗi, không thể chọn!");
            return;
        }
        model = (DefaultTableModel) tblImeiCanDoi.getModel();
        model.setRowCount(0);
        model.addRow(new Object[]{imei, tenSP, trangThai});
    }

    private void doiHang() {
        indexSP = tblSanPham.getSelectedRow();
        if (indexSP == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần đổi!");
            return;
        }
        indexIm = tblImei.getSelectedRow();
        if (indexIm == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Imei cần đổi!");
            return;
        }
        if (txtLyDo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập lý do đổi hàng!");
            txtLyDo.requestFocus();
            return;
        }
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đổi hàng không?");
        if (hoi != JOptionPane.YES_OPTION) {
            return;
        }

        // Lấy thông tin & đổi sản phẩm
        indexHD = tblHoaDon.getSelectedRow();
        if(indexHD == -1){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần đổi!");
            DoiTraHang.dispose();
            return;
        }
        String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();
        String idHD = hoaDonService.getIdByMa(maHD);
        String imeiLoi = tblImeiLoi.getValueAt(indexImLoi, 0).toString();
        String idCTSPLoi = imeiService.getIdByIMei(imeiLoi);
        String imeiCD = tblImeiCanDoi.getValueAt(indexImCD, 0).toString();
        String idCTSPCD = imeiService.getIdByIMei(imeiCD);
        // Trường hợp đổi sản phẩm cùng loại
        if (idCTSPLoi.equals(idCTSPCD)) {
            //update hóa đơn: thành tiền & lý do
            String khuyenMai = tblHoaDon.getValueAt(indexHD, 5).toString();
            String thanhTien = tblHoaDon.getValueAt(indexHD, 6).toString();
            String lyDo = txtLyDo.getText();
            hoaDonService.updateTrangThai("1", lyDo, thanhTien, khuyenMai, idHD);
            //update chiTietSP: số lượng
            String maCTSP = chiTietSPService.getMaById(idCTSPLoi);
            chiTietSPService.updateSoLuong("1", maCTSP);

            //update imei: trạng thái
            imeiService.updateTrangThai("2", imeiLoi);
            imeiService.updateTrangThai("1", imeiCD);

            //update imeiDaBan: đổi imei
            imeiDaBanService.updateImei(imeiCD, imeiLoi);
            
            loadTableSanPhamTheoId();
            model = (DefaultTableModel) tblImei.getModel();
            model.setRowCount(0);
        } else {
            // Trường hợp đổi sản phẩm khác loại
            //update hóa đơn: khuyến mãi, thành tiền & lý do
            String km = tblHoaDon.getValueAt(indexHD, 5).toString();
            BigDecimal donGiaCTHD = new BigDecimal(tblHoaDonChiTiet.getValueAt(indexCTHD, 12).toString());
            String dg = tblSanPham.getValueAt(indexSP, 9).toString();
            BigDecimal donGiaSP = new BigDecimal(dg);
            //Đơn giá của chiTietHD trừ đơn giá của chiTietSP
            BigDecimal donGia = donGiaCTHD.subtract(donGiaSP);
            BigDecimal thanhTienHD = new BigDecimal(tblHoaDon.getValueAt(indexHD, 6).toString());
            BigDecimal thanhTien = thanhTienHD.subtract(donGia);
            String lyDo = txtLyDo.getText();
            hoaDonService.updateTrangThai("1", lyDo, thanhTien + "", km, idHD);

            int soLuong = chiTietHDService.getSoLuongByIdHD_IdCTSP(idHD, idCTSPLoi);
            BigDecimal thanhTienCTHD = donGiaCTHD.multiply(BigDecimal.valueOf(soLuong));
            //nếu số lượng = 1: update đơn giá, thành tiền, idChiTietSP
            if (soLuong == 1) {
                chiTietHDService.updateSanPham(dg, dg, idCTSPCD, idHD, idCTSPLoi);
            } else if (soLuong > 1) { //Nếu số lượng > 1: Số lượng - 1 & thêm CTHD mới
                chiTietHDService.botSoLuong(idHD, idCTSPLoi);
                imeiDaBanService.xoa(imeiLoi);
                //Thêm chiTietHD
                int soLuongSP = 1;
                int trangThaiCTHD = 1;
                String maCTSP = tblSanPham.getValueAt(indexSP, 1).toString();
                ChiTietSP idCtspCD = chiTietSPService.getIdByMa(maCTSP);
                ChiTietHD chiTietHD = new ChiTietHD();
                chiTietHD.setIdHD(idHD);
                chiTietHD.setIdChiTietSP(idCtspCD);
                chiTietHD.setDonGia(donGiaSP);
                chiTietHD.setThanhTien(donGiaSP);
                chiTietHD.setSoLuong(soLuongSP);
                chiTietHD.setTrangThai(trangThaiCTHD);
                chiTietHDService.themCTHD(chiTietHD);
                //Thêm imeiDaBan
                String idCTHD = chiTietHDService.getIdByIdCTSP_IdHD(idCTSPCD, idHD);
                int trangThaiImeiDB = 1;
                ImeiDaBan imeiDaBan = new ImeiDaBan();
                imeiDaBan.setImei(imeiCD);
                imeiDaBan.setIdChiTietHD(idCTHD);
                imeiDaBan.setTrangThai(trangThaiImeiDB);
                imeiDaBanService.themImeiDaBan(imeiDaBan);
            }
            //update chiTietSP: tăng & giảm số lượng
            String maCTSPLoi = chiTietSPService.getMaById(idCTSPLoi);
            chiTietSPService.updateSoLuong("-1", maCTSPLoi); //+1
            String maCTSPCD = chiTietSPService.getMaById(idCTSPCD);
            chiTietSPService.updateSoLuong("1", maCTSPCD); //-1

            //update imeiDaBan: swap imei
            imeiDaBanService.updateImei(imeiCD, imeiLoi);

            //update imei: trạng thái 2 sp
            imeiService.updateTrangThai("0", imeiLoi);
            imeiService.updateTrangThai("1", imeiCD);
            
            loadTableSanPham();
            model = (DefaultTableModel) tblImei.getModel();
            model.setRowCount(0);
        }
        JOptionPane.showMessageDialog(this, "Đổi hàng thành công");
        model = (DefaultTableModel) tblImeiLoi.getModel();
        model.setRowCount(0);
        model = (DefaultTableModel) tblImeiCanDoi.getModel();
        model.setRowCount(0);
        txtLyDo.setText("");
        txtTimImei.setText("");
        loadTableImei();
        loadHoaDonTheoMaNV();
        if (indexHD < 0 || indexHD > QLHD.getHoaDon().size()) {
            return;
        }
        viewChiTietHoaDon cthd = QLHD.getHoaDon().get(indexHD);
        String MaHoaDon = cthd.getMa();
        List<viewChiTietHoaDon> list = QLHD.getHoaDonChiTiet(MaHoaDon);
        loadDataHoaDonCT(list);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        DoiTraHang = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblImei = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLyDo = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtTimImei = new javax.swing.JTextField();
        btnDoiHang = new javax.swing.JButton();
        btnTatCa = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTimSP = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblImeiLoi = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblImeiCanDoi = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cbbCPU = new javax.swing.JComboBox<>();
        cbbSSD = new javax.swing.JComboBox<>();
        cbbRAM = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnSuaHD = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        txtTraCuu = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jDate1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jDate2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cboLocTrangThai = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã CTSP", "Tên SP", "Màu sắc", "RamGB", "SSD", "CPU", "Màn hình ", "Thời gian BH", "Đơn giá", "Số lượng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblSanPham);

        tblImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Imei", "Tên SP", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblImei.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblImeiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblImei);

        jLabel4.setText("Lý do đổi hàng: ");

        txtLyDo.setColumns(20);
        txtLyDo.setRows(5);
        jScrollPane2.setViewportView(txtLyDo);

        jLabel3.setText("Tìm kiếm Imei:");

        txtTimImei.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimImeiCaretUpdate(evt);
            }
        });

        btnDoiHang.setBackground(new java.awt.Color(255, 51, 51));
        btnDoiHang.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiHang.setText("Đổi hàng");
        btnDoiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiHangActionPerformed(evt);
            }
        });

        btnTatCa.setBackground(new java.awt.Color(255, 51, 51));
        btnTatCa.setForeground(new java.awt.Color(255, 255, 255));
        btnTatCa.setText("Tất cả");
        btnTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTatCaActionPerformed(evt);
            }
        });

        jLabel5.setText("Tìm tên sp:");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Imei lỗi"));

        tblImeiLoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Imei", "Tên SP", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblImeiLoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblImeiLoiMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblImeiLoi);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Imei cần đổi"));

        tblImeiCanDoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Imei", "Tên SP", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblImeiCanDoi);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("<=>");

        jLabel7.setText("SSD:");

        jLabel8.setText("RAM:");

        jLabel9.setText("CPU:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbSSD, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbbCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(btnTatCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimImei, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(579, 579, 579)
                        .addComponent(btnDoiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbbCPU, cbbRAM, cbbSSD});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimImei, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbSSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(btnDoiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbbCPU, cbbRAM, cbbSSD, txtTimImei, txtTimSP});

        javax.swing.GroupLayout DoiTraHangLayout = new javax.swing.GroupLayout(DoiTraHang.getContentPane());
        DoiTraHang.getContentPane().setLayout(DoiTraHangLayout);
        DoiTraHangLayout.setHorizontalGroup(
            DoiTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoiTraHangLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DoiTraHangLayout.setVerticalGroup(
            DoiTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoiTraHangLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 230, 234));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HOÁ ĐƠN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hoá đơn", "Khách hàng ", "Ngày thanh toán", "Thu ngân", "Khuyến mãi", "Thành tiền", "Trạng Thái", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setGridColor(new java.awt.Color(102, 102, 255));
        tblHoaDon.setShowGrid(true);
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        btnSuaHD.setBackground(new java.awt.Color(255, 51, 51));
        btnSuaHD.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaHD.setText("Sửa");
        btnSuaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnSuaHD)
                .addContainerGap(298, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tra cứu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 51, 51))); // NOI18N

        txtTraCuu.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTraCuuCaretUpdate(evt);
            }
        });
        txtTraCuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTraCuuMouseClicked(evt);
            }
        });
        txtTraCuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTraCuuActionPerformed(evt);
            }
        });
        txtTraCuu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTraCuuKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(txtTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc theo ngày", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        jDate1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDate1PropertyChange(evt);
            }
        });

        jLabel1.setText("Ngày bắt đầu:");

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Lọc");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Ngày kết thúc:");

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Xoá lọc");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDate1, jDate2});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jDate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDate1, jDate2});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trạng thái", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        cboLocTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã hoàn thành", "Đã huỷ" }));
        cboLocTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(cboLocTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboLocTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHI TIẾT HOÁ ĐƠN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 51, 51))); // NOI18N

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Imei", "Tên ", "NSX", "Màu sắc", "Dòng SP", "CPU", "RAM GB", "SSD", "Màn hình", "Cân nặng", "Bảo hành", "Mô tả", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonChiTiet.setGridColor(new java.awt.Color(51, 51, 255));
        tblHoaDonChiTiet.setShowGrid(true);
        tblHoaDonChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonChiTietMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDonChiTiet);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1126, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTraCuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTraCuuMouseClicked

    }//GEN-LAST:event_txtTraCuuMouseClicked

    private void txtTraCuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTraCuuActionPerformed

    }//GEN-LAST:event_txtTraCuuActionPerformed

    private void txtTraCuuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTraCuuKeyReleased

    }//GEN-LAST:event_txtTraCuuKeyReleased

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        indexHD = tblHoaDon.getSelectedRow();
        String MaHoaDon = tblHoaDon.getValueAt(indexHD, 1).toString();
        List<viewChiTietHoaDon> list = QLHD.getHoaDonChiTiet(MaHoaDon);
        loadDataHoaDonCT(list);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void txtTraCuuCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTraCuuCaretUpdate
        String key = txtTraCuu.getText().trim();
        String vaiTro = nhanVienService.setQuyen(UserInfo.tenTK);
        if (vaiTro.equals("Quản lý")) {
            List<viewChiTietHoaDon> list1 = QLHD.timHoaDonTheoMa(key);
            loadDataHoaDon(list1);
        } else {
            List<viewChiTietHoaDon> lst2 = QLHD.timHoaDonTheoMaHD_MaNV(key, UserInfo.tenTK);
            loadDataHoaDon(lst2);
        }
    }//GEN-LAST:event_txtTraCuuCaretUpdate

    private void jDate1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDate1PropertyChange

    }//GEN-LAST:event_jDate1PropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date ngBD = jDate1.getDate();
        Date ngKT = jDate2.getDate();
        if (ngBD == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày bắt đầu trước khi tìm!");
            return;
        } else if (ngKT == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày kết thúc trước khi tìm!");
            return;
        }
        if (ngBD.getTime() > ngKT.getTime()) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải trước ngày kết thúc!");
            return;
        }

        String vaiTro = nhanVienService.setQuyen(UserInfo.tenTK);
        if (vaiTro.equals("Quản lý")) {
            LocalDate dau = jDate1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate cuoi = jDate2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            loadDataHoaDon(QLHD.getTimHoaDonTheoNgay(dau, cuoi));
        } else {
            LocalDate dau = jDate1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate cuoi = jDate2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            loadDataHoaDon(QLHD.getTimHoaDonTheoNgay_MaNV(dau, cuoi, UserInfo.tenTK));
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String vaiTro = nhanVienService.setQuyen(UserInfo.tenTK);
        if (vaiTro.equals("Quản lý")) {
            jDate1.setDate(new Date());
            jDate2.setDate(new Date());
            loadDataHoaDon(QLHD.getHoaDon());
            model = (DefaultTableModel) tblHoaDonChiTiet.getModel();
            model.setRowCount(0);
        } else {
            jDate1.setDate(new Date());
            jDate2.setDate(new Date());
            loadDataHoaDon(QLHD.getHoaDonByMaNV(UserInfo.tenTK));
            model = (DefaultTableModel) tblHoaDonChiTiet.getModel();
            model.setRowCount(0);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void cboLocTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocTrangThaiActionPerformed
        String vaiTro = nhanVienService.setQuyen(UserInfo.tenTK);
        if (vaiTro.equals("Quản lý")) {
            if (cboLocTrangThai.getSelectedItem().equals("Tất cả")) {
                loadDataHoaDon(QLHD.getHoaDon());
            } else if (cboLocTrangThai.getSelectedItem().equals("Đã hoàn thành")) {
                loadDataHoaDon(QLHD.locHoaDon(1));
            } else {
                loadDataHoaDon(QLHD.locHoaDon(2));
            }
        } else {
            if (cboLocTrangThai.getSelectedItem().equals("Tất cả")) {
                loadDataHoaDon(QLHD.getHoaDonByMaNV(UserInfo.tenTK));
            } else if (cboLocTrangThai.getSelectedItem().equals("Đã hoàn thành")) {
                loadDataHoaDon(QLHD.locHoaDonTheoMaNV(1, UserInfo.tenTK));
            } else {
                loadDataHoaDon(QLHD.locHoaDonTheoMaNV(2, UserInfo.tenTK));
            }
        }
    }//GEN-LAST:event_cboLocTrangThaiActionPerformed

    private void btnSuaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHDActionPerformed
        // sửa hóa đơn
        suaHoaDon();
    }//GEN-LAST:event_btnSuaHDActionPerformed

    private void tblHoaDonChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonChiTietMouseClicked
        // trả hàng
        DoiTraHang.setSize(1300, 550);
        DoiTraHang.setResizable(false);
        DoiTraHang.setLocationRelativeTo(null);
        DoiTraHang.setVisible(true);
        loadTableSanPhamTheoId();
        loadTableImeiLoi();
    }//GEN-LAST:event_tblHoaDonChiTietMouseClicked

    private void btnDoiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiHangActionPerformed
        // Đổi hàng
        indexHD = tblHoaDon.getSelectedRow();
        doiHang();
    }//GEN-LAST:event_btnDoiHangActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // Load table imei theo idChiTietSP
        indexSP = tblSanPham.getSelectedRow();
        loadTableImei();
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void txtTimImeiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimImeiCaretUpdate
        // Tìm Imei
        indexSP = tblSanPham.getSelectedRow();
        if (indexSP == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần tìm Imei!");
            return;
        }
        String maCTSP = tblSanPham.getValueAt(indexSP, 1).toString();
        String idChiTietSP = chiTietSPService.getIdByMa(maCTSP).toString();
        List<Imei> lstImei = imeiService.timKiemImei(idChiTietSP, txtTimImei.getText());
        if (lstImei == null) {
            JOptionPane.showMessageDialog(this, "Lỗi table Imei!");
        } else {
            int count = 1;
            model = (DefaultTableModel) tblImei.getModel();
            model.setRowCount(0);
            String trangThai = "";
            for (Imei imei : lstImei) {
                if (imei.getTrangThai() == 0) {
                    trangThai = "Chưa bán";
                } else if (imei.getTrangThai() == 1) {
                    trangThai = "Đã bán";
                } else {
                    trangThai = "Lỗi!";
                }
                model.addRow(new Object[]{count++, imei.getImei(), imei.getIdChiTietSP().getIdSP(), trangThai});
            }
        }
    }//GEN-LAST:event_txtTimImeiCaretUpdate

    private void btnTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTatCaActionPerformed
        // Load tất cả sản phẩm
        loadTableSanPham();
    }//GEN-LAST:event_btnTatCaActionPerformed

    private void tblImeiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImeiMouseClicked
        // chọn imei cần đổi
        loadTableImeiCanDoi();
    }//GEN-LAST:event_tblImeiMouseClicked

    private void tblImeiLoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImeiLoiMouseClicked
        // TODO add your handling code here:
        loadTableSanPhamTheoId();
    }//GEN-LAST:event_tblImeiLoiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DoiTraHang;
    private javax.swing.JButton btnDoiHang;
    private javax.swing.JButton btnSuaHD;
    private javax.swing.JButton btnTatCa;
    private javax.swing.JComboBox<String> cbbCPU;
    private javax.swing.JComboBox<String> cbbRAM;
    private javax.swing.JComboBox<String> cbbSSD;
    private javax.swing.JComboBox<String> cboLocTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDate1;
    private com.toedter.calendar.JDateChooser jDate2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTable tblImei;
    private javax.swing.JTable tblImeiCanDoi;
    private javax.swing.JTable tblImeiLoi;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextArea txtLyDo;
    private javax.swing.JTextField txtTimImei;
    private javax.swing.JTextField txtTimSP;
    private javax.swing.JTextField txtTraCuu;
    // End of variables declaration//GEN-END:variables
}
