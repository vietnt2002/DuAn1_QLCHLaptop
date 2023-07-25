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
        String sql = "Select HD.Ma,NV.Ho+' '+ NV.tenDem +' '+ NV.Ten  As 'HoTenNV', KH.Ho+' '+ KH.tenDem +' '+ KH.Ten  As 'HoTenKH',HD.NgayThanhToan,HD.TrangThai,LyDo\n"
                + "From HoaDon HD Join NhanVien NV On HD.idNV = NV.Id\n"
                + "Join KhachHang KH On HD.IdKH = KH.Id\n"
                + "Where HD.TrangThai = '1' OR HD.TrangThai = '2'";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewChiTietHoaDon hd = new viewChiTietHoaDon();
                hd.setMa(RS.getString("Ma"));
                hd.setIdNV(RS.getString("HoTenNV"));
                hd.setIdKH(RS.getString("HoTenKH"));
                hd.setNgayThanhToan(RS.getDate("NgayThanhToan"));
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
        String sql = "Select HD.Ma,NV.Ho+' '+ NV.tenDem +' '+ NV.Ten  As 'HoTenNV', KH.Ho+' '+ KH.tenDem +' '+ KH.Ten  As 'HoTenKH',\n"
                + "HD.NgayThanhToan,HD.TrangThai\n"
                + "From HoaDon HD \n"
                + "Join NhanVien NV On HD.idNV = NV.Id\n"
                + "Join KhachHang KH On HD.IdKH = KH.Id\n"
                + "Where HD.Ma Like '%" + tim + "%' OR KH.Ho+' '+ KH.tenDem +' '+ KH.Ten Like N'%" + tim + "%' OR KH.SDT like '%" + tim + "%'";
        
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewChiTietHoaDon hd = new viewChiTietHoaDon();
                hd.setMa(RS.getString("Ma"));
                hd.setIdNV(RS.getString("HoTenNV"));
                hd.setIdKH(RS.getString("HoTenKH"));
                hd.setNgayThanhToan(RS.getDate("NgayThanhToan"));
                hd.setTrangThai(RS.getInt("TrangThai"));
                list.add(hd);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<viewChiTietHoaDon> getTimHoaDonTheoNgay(LocalDate dau, LocalDate cuoi) {
        List<viewChiTietHoaDon> list = new ArrayList<>();
        String sql = "Select HD.Ma,NV.Ho+' '+ NV.tenDem +' '+ NV.Ten  As 'HoTenNV', KH.Ho+' '+ KH.tenDem +' '+ KH.Ten  As 'HoTenKH',HD.NgayThanhToan,HD.TrangThai\n"
                + "From HoaDon HD Join NhanVien NV On HD.idNV = NV.Id\n"
                + "Join KhachHang KH On HD.IdKH = KH.Id\n"
                + "Where HD.TrangThai = '1' OR HD.TrangThai = '2' AND ngaythanhtoan between ? and ?";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, dau);
            PS.setObject(2, cuoi);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewChiTietHoaDon hd = new viewChiTietHoaDon();
                hd.setMa(RS.getString("Ma"));
                hd.setIdNV(RS.getString("HoTenNV"));
                hd.setIdKH(RS.getString("HoTenKH"));
                hd.setNgayThanhToan(RS.getDate("NgayThanhToan"));
                hd.setTrangThai(RS.getInt("TrangThai"));
                
                list.add(hd);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<viewChiTietHoaDon> locHoaDon(int trangThai) {
        List<viewChiTietHoaDon> list = new ArrayList<>();
        String sql = "Select HD.Ma,NV.Ho+' '+ NV.tenDem +' '+ NV.Ten  As 'HoTenNV', KH.Ho+' '+ KH.tenDem +' '+ KH.Ten  As 'HoTenKH',HD.NgayThanhToan,HD.TrangThai\n"
                + "From HoaDon HD Join NhanVien NV On HD.idNV = NV.Id\n"
                + "Join KhachHang KH On HD.IdKH = KH.Id Where HD.TrangThai =" + trangThai;
        
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewChiTietHoaDon hd = new viewChiTietHoaDon();
                hd.setMa(RS.getString("Ma"));
                hd.setIdNV(RS.getString("HoTenNV"));
                hd.setIdKH(RS.getString("HoTenKH"));
                hd.setNgayThanhToan(RS.getDate("NgayThanhToan"));
                hd.setTrangThai(RS.getInt("TrangThai"));
                
                list.add(hd);
            }
            
        } catch (Exception e) {
        }
        return list;
    }
    
    public static void main(String[] args) {
//        QuanLyHoaDonRepository qlhd = new QuanLyHoaDonRepository();
//        List<viewChiTietHoaDon> list = qlhd.getTimHoaDonTheoNgay("2023-07-17", "2023-07-21");
//        for (viewChiTietHoaDon chiTietHoaDon : list) {
//            System.out.println(chiTietHoaDon.toString());
//        }
    }
}
