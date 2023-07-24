/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utilities.DBConnection;

/**
 *
 * @author ADMIN
 */
public class DoiMatKhauRepository {

    private Connection con = DBConnection.getConnection();

    public boolean doiMK(String matKhau, String ma) {
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "UPDATE NhanVien SET MatKhau = '" + matKhau + "' Where Ma = '" + ma + "'";
            PreparedStatement ps = connection.prepareStatement(sql);
            int i = ps.executeUpdate();
            return i > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String checkTrungMatKhau(String ma) {
        String sql = "Select MatKhau from Nhanvien where ma = ?";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setString(1, ma);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                String matKhau = RS.getString("MatKhau");

                return matKhau;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DoiMatKhauRepository mk = new DoiMatKhauRepository();
        boolean doiMK = mk.doiMK("8", "NV01");
        System.out.println(doiMK);
    }

}
