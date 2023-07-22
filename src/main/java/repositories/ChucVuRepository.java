/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.ChucVu;
import irepositories.IChucVuRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utilities.DBConnection;

/**
 *
 * @author ADMIN
 */
public class ChucVuRepository implements IChucVuRepository {

    private Connection con = DBConnection.getConnection();

    @Override
    public List<ChucVu> getAll() {
        List<ChucVu> listChucVu = new ArrayList<>();
        String sql = "Select * from ChucVu";
        try (PreparedStatement Ps = con.prepareStatement(sql)) {
            ResultSet Rs = Ps.executeQuery();
            while (Rs.next()) {
                ChucVu Chucvu = new ChucVu();
                Chucvu.setId(Rs.getString("Id"));
                Chucvu.setMa(Rs.getString("Ma"));
                Chucvu.setTen(Rs.getString("Ten"));
                Chucvu.setNgayTao(Rs.getDate("NgayTao"));
                Chucvu.setNgaySua(Rs.getDate("NgaySua"));
                Chucvu.setTrangThai(Rs.getInt("TrangThai"));
                listChucVu.add(Chucvu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChucVu;
    }

    @Override
    public Integer them(ChucVu chucVu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer sua(ChucVu chucVu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer xoa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChucVu getIdByTen(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
