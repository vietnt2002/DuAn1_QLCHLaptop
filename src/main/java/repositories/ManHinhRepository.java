/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.ManHinh;
import irepositories.IManHinhRepository;
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
public class ManHinhRepository implements IManHinhRepository {

    @Override
    public List<ManHinh> getAll() {
        try {
            List<ManHinh> lst = new ArrayList<>();
            Connection con = DBConnection.getConnection();
            String lenh = "select id,ma,dophangiai,inch,ngayTao,ngaySua,trangThai from manhinh";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(lenh);
            while (rs.next()) {
                lst.add(new ManHinh(rs.getString(1), rs.getString(2), rs.getString(3),  rs.getDouble(4), rs.getDate(5), rs.getDate(6), rs.getInt(7)));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer them(ManHinh manhinh) {
        try {
            Connection con = DBConnection.getConnection();
            String lenh = "insert into ManHinh(dophangiai,inch,ngayTao,ngaySua,trangThai) values(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(lenh);
            st.setString(1, manhinh.getDoPhanGiai());
            st.setDouble(2, manhinh.getInch());
            st.setDate(3, manhinh.getNgayTao());
            st.setDate(4, manhinh.getNgaySua());
            st.setInt(5, manhinh.getTrangThai());
            return st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer sua(ManHinh manhinh) {
        try {
            Connection con = DBConnection.getConnection();
            String lenh = "update ManHinh set dophangiai=?, inch=?, ngayTao=?, ngaySua=?,trangThai=? where ma=?";
            PreparedStatement st = con.prepareStatement(lenh);
            st.setString(6, manhinh.getMa());
            st.setString(1, manhinh.getDoPhanGiai());
            st.setDouble(2, manhinh.getInch());
            st.setDate(3, manhinh.getNgayTao());
            st.setDate(4, manhinh.getNgaySua());
            st.setInt(5, manhinh.getTrangThai());
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
            String lenh = "delete manhinh where ma like '" + ma + "'";
            PreparedStatement st = con.prepareStatement(lenh);

            return st.executeUpdate();
        } catch (Exception e) {
        }
        return -1;
    }

}


