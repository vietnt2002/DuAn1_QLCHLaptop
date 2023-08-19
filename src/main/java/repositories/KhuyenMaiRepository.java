/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.KhuyenMai;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import utilities.DBConnection;

/**
 *
 * @author ADMIN
 */
public class KhuyenMaiRepository {

    private Connection con = DBConnection.getConnection();

    public List<KhuyenMai> getAll() {
        List<KhuyenMai> list = new ArrayList<>();
        String sql = "Select * from KhuyenMai ORDER BY NumOrder DESC";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMa(RS.getString("Ma"));
                km.setSoTienGiam(RS.getBigDecimal("SoTienGiam"));
                km.setSoLuong(RS.getInt("SoLuong"));
                km.setNgayBD(RS.getDate("NgayBatDau"));
                km.setNgayKT(RS.getDate("NgayKetThuc"));
                km.setTrangThai(RS.getInt("TrangThai"));
                list.add(km);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Integer them(KhuyenMai km) {
        String sql = " Insert into KhuyenMai(SoTienGiam,SoLuong,NgayBatDau,NgayKetThuc,TrangThai) Values (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, km.getSoTienGiam());
            ps.setObject(2, km.getSoLuong());
            ps.setObject(3, km.getNgayBD());
            ps.setObject(4, km.getNgayKT());
            ps.setObject(5, km.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return 0;
    }

    public Integer Sua(KhuyenMai km) {
        String sql = "Update KhuyenMai Set SoTienGiam=?,SoLuong=?,NgayBatDau=?,NgayKetThuc=?,TrangThai=? Where Ma = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, km.getSoTienGiam());
            ps.setObject(2, km.getSoLuong());
            ps.setObject(3, km.getNgayBD());
            ps.setObject(4, km.getNgayKT());
            ps.setObject(5, km.getTrangThai());
            ps.setObject(6, km.getMa());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return 0;
    }

    public Integer xoa(String ma) {
        String sql = "Delete from KhuyenMai Where ma = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            int result = ps.executeUpdate();
            return result;
        } catch (Exception e) {
        }
        return null;
    }

    public List<KhuyenMai> getAllTrangThai(int trangThai) {
        List<KhuyenMai> list = new ArrayList<>();
        String sql = "Select * from KhuyenMai Where SoLuong > 0 AND TrangThai =" + trangThai;
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMa(RS.getString("Ma"));
                km.setSoTienGiam(RS.getBigDecimal("SoTienGiam"));
                km.setSoLuong(RS.getInt("SoLuong"));
                km.setNgayBD(RS.getDate("NgayBatDau"));
                km.setNgayKT(RS.getDate("NgayKetThuc"));
                km.setTrangThai(RS.getInt("TrangThai"));
                list.add(km);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<KhuyenMai> getAllTrangThai_0SL(int trangThai) {
        List<KhuyenMai> list = new ArrayList<>();
        String sql = "Select * from KhuyenMai Where TrangThai =" + trangThai+" ORDER BY NumOrder DESC";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMa(RS.getString("Ma"));
                km.setSoTienGiam(RS.getBigDecimal("SoTienGiam"));
                km.setSoLuong(RS.getInt("SoLuong"));
                km.setNgayBD(RS.getDate("NgayBatDau"));
                km.setNgayKT(RS.getDate("NgayKetThuc"));
                km.setTrangThai(RS.getInt("TrangThai"));
                list.add(km);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<KhuyenMai> timKiem(String ma) {
        List<KhuyenMai> list = new ArrayList<>();
        String sql = "Select * from KhuyenMai Where ma Like '%" + ma + "%'";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMa(RS.getString("Ma"));
                km.setSoTienGiam(RS.getBigDecimal("SoTienGiam"));
                km.setSoLuong(RS.getInt("SoLuong"));
                km.setNgayBD(RS.getDate("NgayBatDau"));
                km.setNgayKT(RS.getDate("NgayKetThuc"));
                km.setTrangThai(RS.getInt("TrangThai"));
                list.add(km);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    
    public List<KhuyenMai> getAllByMa(String maKM){
        try {
            List<KhuyenMai> lstKhuyenMai = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT Id, Ma, SoTienGiam, SoLuong, NgayBatDau, NgayKetThuc, TrangThai FROM dbo.KhuyenMai\n" +
                        "WHERE TrangThai = 0 AND Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maKM);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                BigDecimal soTienGiam = rs.getBigDecimal("SoTienGiam");
                int soLuong = rs.getInt("SoLuong");
                Date ngayBatDau = rs.getDate("NgayBatDau");
                Date ngayKetThuc = rs.getDate("NgayKetThuc");
                int trangThai = rs.getInt("TrangThai");
                
                KhuyenMai khuyenMai = new KhuyenMai();
                khuyenMai.setId(id);
                khuyenMai.setMa(ma);
                khuyenMai.setSoTienGiam(soTienGiam);
                khuyenMai.setSoLuong(soLuong);
                khuyenMai.setNgayBD(ngayBatDau);
                khuyenMai.setNgayKT(ngayKetThuc);
                khuyenMai.setTrangThai(trangThai);
                
                lstKhuyenMai.add(khuyenMai);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstKhuyenMai;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Integer updateSoLuong(String ma){
        Integer result = 0;
        String sql = "UPDATE dbo.KhuyenMai SET SoLuong = SoLuong - 1 WHERE Ma = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            
            result = ps.executeUpdate();
            
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

}
