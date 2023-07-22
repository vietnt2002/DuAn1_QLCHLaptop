/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.sql.*;
import utilities.ULHelper;

/**
 *
 * @author ADMIN
 */
public class CheckTrungRepository {

    public static Integer checkTrung(String ma, String bang, String tenCot) {
        try {
            int dem = 0;
            Connection con = ULHelper.getConnection();
            String lenh = "select " + tenCot + " from " + bang + " where " + tenCot + " like '" + ma + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(lenh);
            while (rs.next()) {
                dem++;
            }
            if (dem > 0) {
                return 1;
            }

        } catch (Exception e) {
        }
        return -1;
    }

}
