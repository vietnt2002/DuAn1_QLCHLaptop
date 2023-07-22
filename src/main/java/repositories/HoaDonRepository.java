/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.HoaDon;
import domainmodels.KhachHang;
import domainmodels.NhanVien;
import irepositories.IHoaDonRepository;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utilities.DBConnection;

/**
 *
 * @author ADMIN
 */
public class HoaDonRepository implements IHoaDonRepository{

    @Override
    public List<HoaDon> getAll() {
        try {
            List<HoaDon> lstHoaDon = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT Id, Ma, IdNV, IdKH, NgayTao, NgaySua, NgayThanhToan, TrangThai FROM dbo.HoaDon\n" +
                        "WHERE TrangThai = 0\n" +
                        "ORDER BY Ma DESC";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String idKH = rs.getString("IdKH");
                String idNV = rs.getString("IdNV");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                Date ngayThanhToan = rs.getDate("NgayThanhToan");
                int trangThai = rs.getInt("TrangThai");

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(id);
                hoaDon.setMa(ma);
                hoaDon.setIdKH(idKH);
                hoaDon.setIdNV(idNV);
                hoaDon.setNgayTao(ngayTao);
                hoaDon.setNgaySua(ngaySua);
                hoaDon.setNgayThanhToan(ngayThanhToan);
                hoaDon.setTrangThai(trangThai);
                
                lstHoaDon.add(hoaDon);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstHoaDon;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<HoaDon> getAllByMa(String maNv) {
        try {
            List<HoaDon> lstHoaDon = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT HD.Id AS 'Id', HD.Ma AS 'Ma', HD.IdKH AS 'IdKH', KH.Ma AS 'MaKH', NV.Id AS 'IdNV', NV.Ma AS 'MaNV', HD.NgayTao AS 'NgayTao', HD.NgaySua AS 'NgaySua', HD.NgayThanhToan AS 'NgayThanhToan', HD.TrangThai AS 'TrangThai' \n" +
                        "FROM dbo.HoaDon HD JOIN dbo.KhachHang KH\n" +
                        "ON KH.Id = HD.IdKH JOIN dbo.NhanVien NV\n" +
                        "ON NV.Id = HD.IdNV\n" +
                        "WHERE NV.Ma = ? AND HD.TrangThai = 0\n"+
                        "ORDER BY HD.Ma DESC";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maNv);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String idKH = rs.getString("IdKH");
                String maKH = rs.getString("MaKH");
                String idNV = rs.getString("IdNV");
                String maNV = rs.getString("MaNV");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                Date ngayThanhToan = rs.getDate("NgayThanhToan");
                int trangThai = rs.getInt("TrangThai");
                
                KhachHang khachHang = new KhachHang();
                khachHang.setId(idKH);
                khachHang.setMa(maKH);
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(idNV);
                nhanVien.setMa(maNV);
                
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(id);
                hoaDon.setMa(ma);
                hoaDon.setIdKH(khachHang+"");
                hoaDon.setIdNV(nhanVien+"");
                hoaDon.setNgayTao(ngayTao);
                hoaDon.setNgaySua(ngaySua);
                hoaDon.setNgayThanhToan(ngayThanhToan);
                hoaDon.setTrangThai(trangThai);
                
                lstHoaDon.add(hoaDon);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstHoaDon;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer them(HoaDon hoaDon) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "INSERT INTO dbo.HoaDon (IdNV) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, hoaDon.getIdNV());
            
            result = ps.executeUpdate();
            ps.close();
            connection.close();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }
    
    @Override
    public Integer themHDIdNV_IdKH(HoaDon hoaDon) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "INSERT INTO dbo.HoaDon (IdKH, IdNV) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, hoaDon.getIdKH());
            ps.setString(2, hoaDon.getIdNV());
            
            result = ps.executeUpdate();
            ps.close();
            connection.close();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Integer sua(HoaDon hoaDon) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer xoa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getIdByMa(String ma) {
        try {
            String idHD = null;
            HoaDon hoaDon = new HoaDon();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT Id FROM dbo.HoaDon WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                idHD = rs.getString("Id");
                hoaDon.setId(idHD);
            }
            return idHD;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer updateIdKH(String idKH, String idHD) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "UPDATE dbo.HoaDon SET IdKH = ? WHERE Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idKH);
            ps.setString(2, idHD);
            
            result = ps.executeUpdate();
            ps.close();
            connection.close();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Integer updateTrangThai(String trangThai, String idHD) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "UPDATE dbo.HoaDon SET TrangThai = ? WHERE Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, trangThai);
            ps.setString(2, idHD);
            
            result = ps.executeUpdate();
            ps.close();
            connection.close();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

}
