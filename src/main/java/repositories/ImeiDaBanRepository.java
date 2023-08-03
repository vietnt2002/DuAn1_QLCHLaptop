/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.ImeiDaBan;
import irepositories.IImeiDaBanRepository;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilities.DBConnection;

/**
 *
 * @author ADMIN
 */
public class ImeiDaBanRepository implements IImeiDaBanRepository{

    @Override
    public List<ImeiDaBan> getAll() {
        try {
            List<ImeiDaBan> lstIMeiDaBan = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT IMei, IdChiTietHD, NgayBan, NgayTao, NgaySua, TrangThai FROM dbo.IMeiDaBan\n" +
                        "WHERE TrangThai = 0";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String imei = rs.getString("IMei");
                String idChiTietHD = rs.getString("IdChiTietHD");
                Date ngayBan = rs.getDate("NgayBan");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                int trangThai = rs.getInt("TrangThai");
                
                ImeiDaBan imeiDaBan = new ImeiDaBan();
                imeiDaBan.setImei(imei);
                imeiDaBan.setIdChiTietHD(idChiTietHD);
                imeiDaBan.setNgayBan(ngayBan);
                imeiDaBan.setNgayTao(ngayTao);
                imeiDaBan.setNgaySua(ngaySua);
                imeiDaBan.setTrangThai(trangThai);
                
                lstIMeiDaBan.add(imeiDaBan);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstIMeiDaBan;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<ImeiDaBan> getImeiByIdHD_IdCTSP(String idHD, String idCtsp) {
        try {
            List<ImeiDaBan> lstIMeiDaBan = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT IMei FROM dbo.IMeiDaBan JOIN dbo.ChiTietHD\n" +
                        "ON ChiTietHD.Id = IMeiDaBan.IdChiTietHD JOIN dbo.ChiTietSP CTSP\n" +
                        "ON CTSP.Id = ChiTietHD.IdChiTietSP\n" +
                        "WHERE IMeiDaBan.TrangThai = 0 AND IdHD = ? AND CTSP.Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idHD);
            ps.setString(2, idCtsp);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String imei = rs.getString("IMei");
                
                ImeiDaBan imeiDaBan = new ImeiDaBan();
                imeiDaBan.setImei(imei);
                
                lstIMeiDaBan.add(imeiDaBan);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstIMeiDaBan;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer them(ImeiDaBan imeiDaBan) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "INSERT INTO IMeiDaBan (IMei, IdChiTietHD) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, imeiDaBan.getImei());
            ps.setString(2, imeiDaBan.getIdChiTietHD());
            
            result = ps.executeUpdate();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Integer sua(ImeiDaBan imeiDaBan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer xoa(String imei) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "DELETE FROM dbo.IMeiDaBan WHERE IMei = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, imei);
            
            result = ps.executeUpdate();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public ImeiDaBan getIdByMa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer xoaAll(String idChiTietHD) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "DELETE FROM dbo.IMeiDaBan WHERE IdChiTietHD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idChiTietHD);
            
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
            String sql = "UPDATE dbo.IMeiDaBan SET NgayBan = GETDATE(), TrangThai = ? FROM dbo.ChiTietHD JOIN dbo.IMeiDaBan\n" +
                        "ON IMeiDaBan.IdChiTietHD = ChiTietHD.Id\n" +
                        "WHERE IdHD = ?";
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

    @Override
    public List<ImeiDaBan> getImeiByIdHD(String idHD) {
        try {
            List<ImeiDaBan> lstIMeiDaBan = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT IMei FROM dbo.IMeiDaBan JOIN dbo.ChiTietHD\n" +
                        "ON ChiTietHD.Id = IMeiDaBan.IdChiTietHD JOIN dbo.ChiTietSP CTSP\n" +
                        "ON CTSP.Id = ChiTietHD.IdChiTietSP\n" +
                        "WHERE IMeiDaBan.TrangThai = 1 AND IdHD = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idHD);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String imei = rs.getString("IMei");
                
                ImeiDaBan imeiDaBan = new ImeiDaBan();
                imeiDaBan.setImei(imei);
                
                lstIMeiDaBan.add(imeiDaBan);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstIMeiDaBan;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer updateImei(String im, String imei) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "UPDATE dbo.IMeiDaBan SET IMei = ? WHERE IMei = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, im);
            ps.setString(2, imei);
            
            result = ps.executeUpdate();
            ps.close();
            connection.close();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

}
