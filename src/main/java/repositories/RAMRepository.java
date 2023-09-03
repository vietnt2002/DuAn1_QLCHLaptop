/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.RAM;
import irepositories.IRAMRepository;
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
public class RAMRepository implements IRAMRepository {

    @Override
    public List<RAM> getAll() {
        try {
            List<RAM> lst = new ArrayList<>();
            Connection con = DBConnection.getConnection();
            String lenh = "select id,ma,ten,ngayTao,ngaySua,trangThai from RAM";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(lenh);
            while (rs.next()) {
                lst.add(new RAM(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6)));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer them(RAM ram) {
        try {
            Connection con = DBConnection.getConnection();
            String lenh = "insert into RAM(Ten,ngayTao,ngaySua,trangThai) values(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(lenh);
            st.setString(1, ram.getTen());
            st.setDate(2, ram.getNgayTao());
            st.setDate(3, ram.getNgaySua());
            st.setInt(4, ram.getTrangThai());
            return st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer sua(RAM ram) {
        try {
            Connection con = DBConnection.getConnection();
            String lenh = "update RAM set ten=?, ngayTao=?, ngaySua=?,trangThai=? where ma=?";
            PreparedStatement st = con.prepareStatement(lenh);
            st.setString(5, ram.getMa());
            st.setString(1, ram.getTen());
            st.setDate(2, ram.getNgayTao());
            st.setDate(3, ram.getNgaySua());
            st.setInt(4, ram.getTrangThai());
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
            String lenh = "delete RAM where ma like '" + ma + "'";
            PreparedStatement st = con.prepareStatement(lenh);

            return st.executeUpdate();
        } catch (Exception e) {
        }
        return -1;
    }
}
