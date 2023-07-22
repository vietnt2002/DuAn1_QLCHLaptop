/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.NSX;
import irepositories.INSXRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilities.DBConnection;

/**
 *
 * @author ADMIN
 */
public class NSXRepository implements INSXRepository {

    @Override
    public List<NSX> getAll() {
        try {
            List<NSX> lst = new ArrayList<>();
            Connection con = DBConnection.getConnection();
            String lenh = "select id,ma,ten,quocgia,ngayTao,ngaySua,trangThai from nsx";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(lenh);
            while (rs.next()) {
                lst.add(new NSX(rs.getString(1), rs.getString(2), rs.getString(3),  rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getInt(7)));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer them(NSX nsx) {
        try {
            Connection con = DBConnection.getConnection();
            String lenh = "insert into NSX(Ma,Ten,quocgia,ngayTao,ngaySua,trangThai) values(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(lenh);
            st.setString(1, nsx.getMa());
            st.setString(2, nsx.getTen());
            st.setString(3, nsx.getQuocGia());
            st.setDate(4, nsx.getNgayTao());
            st.setDate(5, nsx.getNgaySua());
            st.setInt(6, nsx.getTrangThai());
            return st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer sua(NSX nsx) {
        try {
            Connection con = DBConnection.getConnection();
            String lenh = "update NSX set ten=?, quocgia=?, ngayTao=?, ngaySua=?,trangThai=? where ma=?";
            PreparedStatement st = con.prepareStatement(lenh);
            st.setString(6, nsx.getMa());
            st.setString(1, nsx.getTen());
            st.setString(2, nsx.getQuocGia());
            st.setDate(3, nsx.getNgayTao());
            st.setDate(4, nsx.getNgaySua());
            st.setInt(5, nsx.getTrangThai());
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
            String lenh = "delete nsx where ma like '" + ma + "'";
            PreparedStatement st = con.prepareStatement(lenh);

            return st.executeUpdate();
        } catch (Exception e) {
        }
        return -1;
    }

}

