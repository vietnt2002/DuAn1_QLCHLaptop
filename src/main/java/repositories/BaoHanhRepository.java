/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.BaoHanh;
import irepositories.*;
import irepositories.IBaoHanhRepository;
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
public class BaoHanhRepository implements IBaoHanhRepository {

    @Override
    public List<BaoHanh> getAll() {
        try {
            List<BaoHanh> lst = new ArrayList<>();
            Connection con = DBConnection.getConnection();
            String lenh = "select id,ma,soThangBH,ngayTao,ngaySua,trangThai from BaoHanh";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(lenh);
            while (rs.next()) {
                lst.add(new BaoHanh(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getInt(6)));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer them(BaoHanh baohanh) {
        try {
            Connection con = DBConnection.getConnection();
            String lenh = "insert into BaoHanh(ma,soThangBH,ngayTao,ngaySua,trangThai) values(?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(lenh);
            st.setString(1, baohanh.getMa());
            st.setInt(2, baohanh.getSoThangBH());
            st.setDate(3, baohanh.getNgayTao());
            st.setDate(4, baohanh.getNgaySua());
            st.setInt(5, baohanh.getTrangThai());
            return st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer sua(BaoHanh baohanh) {
        try {
            Connection con = DBConnection.getConnection();
            String lenh = "update BaoHanh set soThangBH=?, ngayTao=?, ngaySua=?,trangThai=? where ma=?";
            PreparedStatement st = con.prepareStatement(lenh);
            st.setString(5, baohanh.getMa());
            st.setInt(1, baohanh.getSoThangBH());
            st.setDate(2, baohanh.getNgayTao());
            st.setDate(3, baohanh.getNgaySua());
            st.setInt(4, baohanh.getTrangThai());
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
            String lenh = "delete BaoHanh where ma like '" + ma + "'";
            PreparedStatement st = con.prepareStatement(lenh);

            return st.executeUpdate();
        } catch (Exception e) {
        }
        return -1;
    }
}
