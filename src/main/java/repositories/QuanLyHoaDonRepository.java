/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utilities.DBConnection;
import viewmodel.viewChiTietHoaDon;

/**
 *
 * @author ADMIN
 */
public class QuanLyHoaDonRepository {
    
    private Connection con = DBConnection.getConnection();
    
    public List<viewChiTietHoaDon> getHoaDon() {
        List<viewChiTietHoaDon> list = new ArrayList<>();
        String sql = "SELECT Ma, IdNV, IdKH, NgayThanhToan, KhuyenMai, ThanhTien, TrangThai, LyDo FROM dbo.HoaDon\n" +
                    "WHERE TrangThai = 1 OR TrangThai = 2\n" +
                    "ORDER BY NumOrder DESC";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewChiTietHoaDon hd = new viewChiTietHoaDon();
                hd.setMa(RS.getString("Ma"));
                hd.setIdNV(RS.getString("IdNV"));
                hd.setIdKH(RS.getString("IdKH"));
                hd.setNgayThanhToan(RS.getDate("NgayThanhToan"));
                hd.setKhuyenMai(RS.getBigDecimal("KhuyenMai"));
                hd.setThanhTien(RS.getBigDecimal("ThanhTien"));
                hd.setTrangThai(RS.getInt("TrangThai"));
                hd.setGhiChu(RS.getString("LyDo"));
                
                list.add(hd);
            }
            
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<viewChiTietHoaDon> getHoaDonByMaNV(String maNV) {
        List<viewChiTietHoaDon> list = new ArrayList<>();
        String sql = "SELECT HD.Ma AS 'Ma', IdNV, IdKH, NgayThanhToan, KhuyenMai, ThanhTien, HD.TrangThai AS 'TrangThai', LyDo FROM dbo.HoaDon HD JOIN dbo.NhanVien NV\n" +
                    "ON NV.Id = HD.IdNV\n" +
                    "WHERE (HD.TrangThai = 1 OR HD.TrangThai = 2) AND NV.Ma = ?\n" +
                    "ORDER BY HD.NumOrder DESC";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setString(1, maNV);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewChiTietHoaDon hd = new viewChiTietHoaDon();
                hd.setMa(RS.getString("Ma"));
                hd.setIdNV(RS.getString("IdNV"));
                hd.setIdKH(RS.getString("IdKH"));
                hd.setNgayThanhToan(RS.getDate("NgayThanhToan"));
                hd.setKhuyenMai(RS.getBigDecimal("KhuyenMai"));
                hd.setThanhTien(RS.getBigDecimal("ThanhTien"));
                hd.setTrangThai(RS.getInt("TrangThai"));
                hd.setGhiChu(RS.getString("LyDo"));
                
                list.add(hd);
            }
            
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<viewChiTietHoaDon> getHoaDonChiTiet(String ma) {
        List<viewChiTietHoaDon> List = new ArrayList<>();
        String sql = "SELECT Imei,DSP.Ten As 'DSP', SP.Ten AS 'Sp', MS.Ten AS 'MS', CPU.Ten AS 'CPU', RAM.Ten AS'RAM', SSD.Ten AS'SSD',  ConCAT_WS(' ',DoPhanGiai,Inch) +' Inch' AS 'MH', \n"
                + "QuocGia As 'NSX', BH.SoThangBH AS'BH',CanNang,Mota,GiaBan \n"
                + "FROM dbo.ChiTietHD CTHD JOIN dbo.IMeiDaBan IDB\n"
                + "ON IDB.IdChiTietHD = CTHD.Id JOIN dbo.ChiTietSP CTSP\n"
                + "ON CTSP.Id = CTHD.IdChiTietSP JOIN dbo.DongSP DSP\n"
                + "ON DSP.Id = CTSP.IdDongSP JOIN dbo.SanPham SP\n"
                + "ON SP.Id = CTSP.IdSP JOIN dbo.MauSac MS\n"
                + "ON MS.Id = CTSP.IdMauSac JOIN dbo.NSX \n"
                + "ON NSX.Id = CTSP.IdNSX JOIN dbo.CPU \n"
                + "ON CPU.Id = CTSP.IdCPU JOIN dbo.RAM \n"
                + "ON RAM.Id = CTSP.IdRAM JOIN dbo.ManHinh MH\n"
                + "ON MH.Id = CTSP.IdManHinh JOIN dbo.BaoHanh BH\n"
                + "ON BH.Id = CTSP.IdBH JOIN dbo.SSD \n"
                + "ON SSD.Id = CTSP.IdSSD JOIN dbo.HoaDon HD\n"
                + "ON HD.Id = CTHD.IdHD\n"
                + "WHERE HD.Ma = ? ";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, ma);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewChiTietHoaDon ctsp = new viewChiTietHoaDon();
                ctsp.setImei(RS.getString("Imei"));
                ctsp.setTenSP(RS.getString("SP"));
                ctsp.setNSX(RS.getString("NSX"));
                ctsp.setMauSac(RS.getString("MS"));
                ctsp.setDongSP(RS.getString("DSP"));
                ctsp.setCPU(RS.getString("CPU"));
                ctsp.setRAM(RS.getString("RAM"));
                ctsp.setSSD(RS.getString("SSD"));
                ctsp.setManHinh(RS.getString("MH"));
                ctsp.setCanNang(RS.getDouble("CanNang"));
                ctsp.setGiaBan(RS.getBigDecimal("GiaBan"));
                ctsp.setBaoHanh(RS.getString("BH"));
                ctsp.setMoTa(RS.getString("MoTa"));
                List.add(ctsp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List;
    }
    
    public List<viewChiTietHoaDon> timHoaDonTheoMa(String tim) {
        List<viewChiTietHoaDon> list = new ArrayList<>();
        String sql = "SELECT HD.Ma AS 'Ma', IdNV, IdKH, NgayThanhToan, KhuyenMai, ThanhTien, HD.TrangThai AS 'TrangThai', LyDo FROM dbo.HoaDon HD JOIN dbo.KhachHang KH\n" +
                    "ON KH.Id = HD.IdKH\n" +
                    "WHERE HD.Ma LIKE '%"+tim+"%' OR KH.Sdt LIKE '%"+tim+"%'";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewChiTietHoaDon hd = new viewChiTietHoaDon();
                hd.setMa(RS.getString("Ma"));
                hd.setIdNV(RS.getString("IdNV"));
                hd.setIdKH(RS.getString("IdKH"));
                hd.setNgayThanhToan(RS.getDate("NgayThanhToan"));
                hd.setKhuyenMai(RS.getBigDecimal("KhuyenMai"));
                hd.setThanhTien(RS.getBigDecimal("ThanhTien"));
                hd.setTrangThai(RS.getInt("TrangThai"));
                hd.setGhiChu(RS.getString("LyDo"));
                
                list.add(hd);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<viewChiTietHoaDon> timHoaDonTheoMaHD_MaNV(String tim, String maNV) {
        List<viewChiTietHoaDon> list = new ArrayList<>();
        String sql = "SELECT HD.Ma AS 'Ma', IdNV, IdKH, NgayThanhToan, KhuyenMai, ThanhTien, HD.TrangThai AS 'TrangThai', LyDo FROM dbo.HoaDon HD JOIN dbo.KhachHang KH\n" +
                    "ON KH.Id = HD.IdKH JOIN dbo.NhanVien NV\n" +
                    "ON NV.Id = HD.IdNV\n" +
                    "WHERE NV.Ma = ? AND (HD.Ma LIKE '%"+tim+"%' OR KH.Sdt LIKE '%"+tim+"%')";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setString(1, maNV);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewChiTietHoaDon hd = new viewChiTietHoaDon();
                hd.setMa(RS.getString("Ma"));
                hd.setIdNV(RS.getString("IdNV"));
                hd.setIdKH(RS.getString("IdKH"));
                hd.setNgayThanhToan(RS.getDate("NgayThanhToan"));
                hd.setKhuyenMai(RS.getBigDecimal("KhuyenMai"));
                hd.setThanhTien(RS.getBigDecimal("ThanhTien"));
                hd.setTrangThai(RS.getInt("TrangThai"));
                hd.setGhiChu(RS.getString("LyDo"));
                
                list.add(hd);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<viewChiTietHoaDon> getTimHoaDonTheoNgay(LocalDate dau, LocalDate cuoi) {
        List<viewChiTietHoaDon> list = new ArrayList<>();
        String sql = "SELECT Ma, IdNV, IdKH, NgayThanhToan, KhuyenMai, ThanhTien, TrangThai, LyDo FROM dbo.HoaDon\n" +
                    "WHERE (TrangThai = 1 OR TrangThai = 2) AND NgayThanhToan BETWEEN ? AND ?";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, dau);
            PS.setObject(2, cuoi);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewChiTietHoaDon hd = new viewChiTietHoaDon();
                hd.setMa(RS.getString("Ma"));
                hd.setIdNV(RS.getString("IdNV"));
                hd.setIdKH(RS.getString("IdKH"));
                hd.setNgayThanhToan(RS.getDate("NgayThanhToan"));
                hd.setKhuyenMai(RS.getBigDecimal("KhuyenMai"));
                hd.setThanhTien(RS.getBigDecimal("ThanhTien"));
                hd.setTrangThai(RS.getInt("TrangThai"));
                hd.setGhiChu(RS.getString("LyDo"));
                
                list.add(hd);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<viewChiTietHoaDon> getTimHoaDonTheoNgay_MaNV(LocalDate dau, LocalDate cuoi, String maNV) {
        List<viewChiTietHoaDon> list = new ArrayList<>();
        String sql = "SELECT HD.Ma, IdNV, IdKH, NgayThanhToan, KhuyenMai, ThanhTien, HD.TrangThai, LyDo FROM dbo.HoaDon HD JOIN dbo.NhanVien NV\n" +
                    "ON NV.Id = HD.IdNV\n" +
                    "WHERE (HD.TrangThai = 1 OR HD.TrangThai = 2) AND (NgayThanhToan BETWEEN ? AND ?) AND NV.Ma = ?";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, dau);
            PS.setObject(2, cuoi);
            PS.setObject(3, maNV);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewChiTietHoaDon hd = new viewChiTietHoaDon();
                hd.setMa(RS.getString("Ma"));
                hd.setIdNV(RS.getString("IdNV"));
                hd.setIdKH(RS.getString("IdKH"));
                hd.setNgayThanhToan(RS.getDate("NgayThanhToan"));
                hd.setKhuyenMai(RS.getBigDecimal("KhuyenMai"));
                hd.setThanhTien(RS.getBigDecimal("ThanhTien"));
                hd.setTrangThai(RS.getInt("TrangThai"));
                hd.setGhiChu(RS.getString("LyDo"));
                
                list.add(hd);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<viewChiTietHoaDon> locHoaDon(int trangThai) {
        List<viewChiTietHoaDon> list = new ArrayList<>();
        String sql = "SELECT Ma, IdNV, IdKH, NgayThanhToan, KhuyenMai, ThanhTien, TrangThai, LyDo FROM dbo.HoaDon\n" +
                    "WHERE TrangThai = " + trangThai;
        
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewChiTietHoaDon hd = new viewChiTietHoaDon();
                hd.setMa(RS.getString("Ma"));
                hd.setIdNV(RS.getString("IdNV"));
                hd.setIdKH(RS.getString("IdKH"));
                hd.setNgayThanhToan(RS.getDate("NgayThanhToan"));
                hd.setKhuyenMai(RS.getBigDecimal("KhuyenMai"));
                hd.setThanhTien(RS.getBigDecimal("ThanhTien"));
                hd.setTrangThai(RS.getInt("TrangThai"));
                hd.setGhiChu(RS.getString("LyDo"));
                
                list.add(hd);
            }
            
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<viewChiTietHoaDon> locHoaDonTheoMaNV(int trangThai, String maNV) {
        List<viewChiTietHoaDon> list = new ArrayList<>();
        String sql = "SELECT HD.Ma, IdNV, IdKH, NgayThanhToan, KhuyenMai, ThanhTien, HD.TrangThai, LyDo FROM dbo.HoaDon HD JOIN dbo.NhanVien NV\n" +
                    "ON NV.Id = HD.IdNV\n" +
                    "WHERE NV.Ma = ? AND HD.TrangThai = " + trangThai;
        
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, maNV);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewChiTietHoaDon hd = new viewChiTietHoaDon();
                hd.setMa(RS.getString("Ma"));
                hd.setIdNV(RS.getString("IdNV"));
                hd.setIdKH(RS.getString("IdKH"));
                hd.setNgayThanhToan(RS.getDate("NgayThanhToan"));
                hd.setKhuyenMai(RS.getBigDecimal("KhuyenMai"));
                hd.setThanhTien(RS.getBigDecimal("ThanhTien"));
                hd.setTrangThai(RS.getInt("TrangThai"));
                hd.setGhiChu(RS.getString("LyDo"));
                
                list.add(hd);
            }
            
        } catch (Exception e) {
        }
        return list;
    }
    
    public static void main(String[] args) {
        QuanLyHoaDonRepository qlhd = new QuanLyHoaDonRepository();
        List<viewChiTietHoaDon> list = qlhd.timHoaDonTheoMa("HD98");
        for (viewChiTietHoaDon chiTietHoaDon : list) {
            System.out.println(chiTietHoaDon.toString());
        }
    }
}
