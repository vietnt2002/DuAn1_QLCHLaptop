/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.ChiTietHD;
import domainmodels.ChiTietSP;
import domainmodels.SanPham;
import irepositories.IChiTietHDRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utilities.DBConnection;

/**
 *
 * @author ADMIN
 */
public class ChiTietHDRepository implements IChiTietHDRepository{

    
    @Override
    public List<ChiTietHD> getAll() {
        try {
            List<ChiTietHD> lstChiTietHD = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT CTSP.Id AS 'IdChiTietSP', CTSP.IdSP AS 'IdSP', SP.Ma AS 'MaSP', SP.Ten AS 'TenSP', CTHD.SoLuong AS 'SoLuong', CTHD.Dongia AS 'DonGia', CTHD.ThanhTien AS 'ThanhTien', CTHD.TrangThai AS 'TrangThai'\n" +
                        "FROM dbo.ChiTietHD CTHD JOIN dbo.ChiTietSP CTSP\n" +
                        "ON CTSP.Id = CTHD.IdChiTietSP JOIN dbo.SanPham SP\n" +
                        "ON SP.Id = CTSP.IdSP\n" +
                        "WHERE CTHD.TrangThai = 0";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String idChiTietSP = rs.getString("IdChiTietSP");
                String idSP = rs.getString("IdSP");
                String maSP = rs.getString("MaSP");
                String tenSP = rs.getString("TenSP");
                int soLuong = rs.getInt("SoLuong");
                BigDecimal donGia = rs.getBigDecimal("DonGia");
                BigDecimal thanhTien = rs.getBigDecimal("ThanhTien");
                int trangThai = rs.getInt("TrangThai");
                
                SanPham sanPham = new SanPham();
                sanPham.setId(idSP);
                sanPham.setMa(maSP);
                sanPham.setTen(tenSP);
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setId(idChiTietSP);
                chiTietSP.setIdSP(sanPham+"");
                
                ChiTietHD chiTietHD = new ChiTietHD();
                chiTietHD.setIdChiTietSP(chiTietSP);
                chiTietHD.setSoLuong(soLuong);
                chiTietHD.setDonGia(donGia);
                chiTietHD.setThanhTien(thanhTien);
                chiTietHD.setTrangThai(trangThai);
                
                lstChiTietHD.add(chiTietHD);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstChiTietHD;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<ChiTietHD> getAllByIdHD(String idHd) {
        try {
            List<ChiTietHD> lstChiTietHD = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT CTHD.IdHD AS 'IdHD', CTSP.Id AS 'IdChiTietSP', CTSP.Ma AS 'MaChiTietSP', CTSP.IdSP AS 'IdSP', SP.Ma AS 'MaSP', SP.Ten AS 'TenSP', CTHD.SoLuong AS 'SoLuong', CTHD.Dongia AS 'DonGia', CTHD.ThanhTien AS 'ThanhTien', CTHD.TrangThai AS 'TrangThai'\n" +
                        "FROM dbo.ChiTietHD CTHD JOIN dbo.ChiTietSP CTSP\n" +
                        "ON CTSP.Id = CTHD.IdChiTietSP JOIN dbo.SanPham SP\n" +
                        "ON SP.Id = CTSP.IdSP\n" +
                        "WHERE CTHD.TrangThai = 0 AND CTHD.IdHD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idHd);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String idHD = rs.getString("IdHD");
                String idChiTietSP = rs.getString("IdChiTietSP");
                String maChiTietSP = rs.getString("MaChiTietSP");
                String idSP = rs.getString("IdSP");
                String maSP = rs.getString("MaSP");
                String tenSP = rs.getString("TenSP");
                int soLuong = rs.getInt("SoLuong");
                BigDecimal donGia = rs.getBigDecimal("DonGia");
                BigDecimal thanhTien = rs.getBigDecimal("ThanhTien");
                int trangThai = rs.getInt("TrangThai");
                
                SanPham sanPham = new SanPham();
                sanPham.setId(idSP);
                sanPham.setMa(maSP);
                sanPham.setTen(tenSP);
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setId(idChiTietSP);
                chiTietSP.setMa(maChiTietSP);
                chiTietSP.setIdSP(sanPham+"");
                
                ChiTietHD chiTietHD = new ChiTietHD();
                chiTietHD.setIdHD(idHD);
                chiTietHD.setIdChiTietSP(chiTietSP);
                chiTietHD.setSoLuong(soLuong);
                chiTietHD.setDonGia(donGia);
                chiTietHD.setThanhTien(thanhTien);
                chiTietHD.setTrangThai(trangThai);
                
                lstChiTietHD.add(chiTietHD);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstChiTietHD;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer them(ChiTietHD chiTietHD) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "INSERT INTO ChiTietHD (IdHD, IdChiTietSP, Dongia) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, chiTietHD.getIdHD());
            ps.setString(2, chiTietHD.getIdChiTietSP()+"");
            ps.setBigDecimal(3, chiTietHD.getDonGia());
            result = ps.executeUpdate();
            
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Integer sua(ChiTietHD chiTietHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer xoa(String idCtsp, String idHD) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "DELETE FROM dbo.ChiTietHD WHERE IdChiTietSP = ? AND IdHD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idCtsp);
            ps.setString(2, idHD);
            
            result = ps.executeUpdate();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public String getIdByIdHD(String idHD) {
        try {
            String id = null;
            ChiTietHD chiTietHD = new ChiTietHD();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT Id FROM dbo.ChiTietHD WHERE IdHD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("Id");
                chiTietHD.setId(id);
            }
            return id;
        } catch (Exception e) {
            return null;
        }
    } 

    @Override
    public Integer themSoLuong(String idHD, String idChiTietSP) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "UPDATE dbo.ChiTietHD SET SoLuong = SoLuong + 1 WHERE IdHD = ? AND IdChiTietSP = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idHD);
            ps.setString(2, idChiTietSP);
            
            result = ps.executeUpdate();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Integer botSoLuong(String idHD, String idChiTietSP) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "UPDATE dbo.ChiTietHD SET SoLuong = SoLuong - 1 WHERE IdHD = ? AND IdChiTietSP = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idHD);
            ps.setString(2, idChiTietSP);
            
            result = ps.executeUpdate();
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
            String sql = "UPDATE dbo.ChiTietHD SET TrangThai = ? WHERE IdHD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, trangThai);
            ps.setString(2, idHD);
            
            result = ps.executeUpdate();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public String getIdByIdCTSP_IdHD(String idCtsp, String idHD) {
        try {
            String id = null;
            ChiTietHD chiTietHD = new ChiTietHD();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT Id FROM dbo.ChiTietHD WHERE IdChiTietSP = ? AND IdHD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idCtsp);
            ps.setString(2, idHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("Id");
                chiTietHD.setId(id);
            }
            return id;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer updateThanhTien(BigDecimal thanhTien, String idHD, String idCtsp) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "UPDATE dbo.ChiTietHD SET ThanhTien = ? WHERE IdHD = ? AND IdChiTietSP = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setBigDecimal(1, thanhTien);
            ps.setString(2, idHD);
            ps.setString(3, idCtsp);
            
            result = ps.executeUpdate();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Integer xoaSoLuong(String idHD) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "UPDATE dbo.ChiTietHD SET SoLuong = 0 WHERE IdHD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idHD);
            
            result = ps.executeUpdate();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

}
