/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.KhachHang;
import domainmodels.SanPham;
import irepositories.ISanPhamRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilities.DBConnection;
import utilities.ULHelper;

/**
 *
 * @author ADMIN
 */
public class SanPhamRepository implements ISanPhamRepository {
    @Override
    public List<SanPham> getAll() {
        try {
            List<SanPham> lst = new ArrayList<>();
            Connection con = DBConnection.getConnection();
            String lenh = "select id,ma,ten,ngayTao,ngaySua,trangThai from sanpham";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(lenh);
            while (rs.next()) {
                lst.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6)));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer them(SanPham sp) {
        try {
            Connection con = DBConnection.getConnection();
            String lenh = "insert into sanpham(Ten,ngayTao,ngaySua,trangThai) values(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(lenh);
            st.setString(1, sp.getTen());
            st.setDate(2, sp.getNgayTao());
            st.setDate(3, sp.getNgaySua());
            st.setInt(4, sp.getTrangThai());
            return st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer sua(SanPham sp) {
        try {
            Connection con = DBConnection.getConnection();
            String lenh = "update sanpham set ten=?, ngayTao=?, ngaySua=?,trangThai=? where ma=?";
            PreparedStatement st = con.prepareStatement(lenh);
            st.setString(5, sp.getMa());
            st.setString(1, sp.getTen());
            st.setDate(2, sp.getNgayTao());
            st.setDate(3, sp.getNgaySua());
            st.setInt(4, sp.getTrangThai());
            return st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer xoa(String ma) {
        try {
            Connection con = DBConnection.getConnection();
            String lenh = "delete sanpham where ma like '" + ma + "'";
            PreparedStatement st = con.prepareStatement(lenh);

            return st.executeUpdate();
        } catch (Exception e) {
        }
        return -1;
    }

    @Override
    public String getIdByMa(String ma) {
        try {
            String idSP = null;
            SanPham sanPham = new SanPham();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT Id FROM dbo.SanPham WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idSP = rs.getString("Id");
                sanPham.setId(idSP);
            }
            return idSP;
        } catch (Exception e) {
            return null;
        }
    }
}
