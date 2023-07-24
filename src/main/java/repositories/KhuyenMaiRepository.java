/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.KhuyenMai;
import java.sql.Connection;
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
        String sql = "Select * from KhuyenMai";
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
        String sql = " Insert into KhuyenMai(Ma,SoTienGiam,SoLuong,NgayBatDau,NgayKetThuc,TrangThai) Values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, km.getMa());
            ps.setObject(2, km.getSoTienGiam());
            ps.setObject(3, km.getSoLuong());
            ps.setObject(4, km.getNgayBD());
            ps.setObject(5, km.getNgayKT());
            ps.setObject(6, km.getTrangThai());
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
        String sql = "Select * from KhuyenMai Where TrangThai =" + trangThai;
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

}
