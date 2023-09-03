/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.SSD;
import irepositories.ISSDRepository;
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
public class SSDRepository implements ISSDRepository {
    @Override
    public List<SSD> getAll() {
        try {
            List<SSD> lst = new ArrayList<>();
            Connection con = DBConnection.getConnection();
            String lenh = "select id,ma,ten,ngayTao,ngaySua,trangThai from SSD";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(lenh);
            while (rs.next()) {
                lst.add(new SSD(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6)));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer them(SSD ssd) {
        try {
            Connection con = DBConnection.getConnection();
            String lenh = "insert into SSD(Ten,ngayTao,ngaySua,trangThai) values(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(lenh);
            st.setString(1, ssd.getTen());
            st.setDate(2, ssd.getNgayTao());
            st.setDate(3, ssd.getNgaySua());
            st.setInt(4, ssd.getTrangThai());
            return st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer sua(SSD ssd) {
        try {
            Connection con = DBConnection.getConnection();
            String lenh = "update SSD set ten=?, ngayTao=?, ngaySua=?,trangThai=? where ma=?";
            PreparedStatement st = con.prepareStatement(lenh);
            st.setString(5, ssd.getMa());
            st.setString(1, ssd.getTen());
            st.setDate(2, ssd.getNgayTao());
            st.setDate(3, ssd.getNgaySua());
            st.setInt(4, ssd.getTrangThai());
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
            String lenh = "delete SSD where ma like '" + ma + "'";
            PreparedStatement st = con.prepareStatement(lenh);

            return st.executeUpdate();
        } catch (Exception e) {
        }
        return -1;
    }
}
