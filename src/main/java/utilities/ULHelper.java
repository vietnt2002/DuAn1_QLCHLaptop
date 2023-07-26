/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class ULHelper {

    private static Connection con = null;
    private static PreparedStatement st = null;
    public static final String url = "jdbc:sqlserver://localhost:1433;"
            + "DatabaseName=QuanLyCuaHangLaptop;encrypt=true;trustServerCertificate=true";

    public static Connection getConnection() {
        Connection connect = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println("chua co driver");

        }
        try {
            connect = DriverManager.getConnection(url, "SA", "KhaiLamDIGITAL");
            return connect;
        } catch (Exception e) {
            System.out.println("sai ten database hoac pass");
        }
        return connect;
    }

    public static boolean checknull(JTextField c, String mss) {
        if (c.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, mss);
            c.requestFocus();
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean checknullLabel(JLabel c, String mss) {
        if (c.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, mss);
            c.requestFocus();
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean checkNotnullLabel(JLabel c, String mss) {
        if (c.getText().trim().length() != 0) {
            JOptionPane.showMessageDialog(null, mss);
            return true;
        } else {
            return false;
        }
    }

    public static boolean CheckSDT(JTextField txt, String mess) {
        String sdt = "0\\d{9}";
        Matcher matcher = Pattern.compile(sdt).matcher(txt.getText());
        if (matcher.matches()) {
            return false;
        }
        JOptionPane.showMessageDialog(null, mess);
        txt.requestFocus();
        return true;
    }

    public static boolean checkNgay(JTextField txt, String mss) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdf.parse(txt.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, mss);
            txt.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkEmail(JTextField txt, String mess) {
        String email = "\\w+@\\w+(\\.\\w+){1,2}";
        Matcher matcher = Pattern.compile(email).matcher(txt.getText());
        if (matcher.matches()) {
            return false;
        }
        JOptionPane.showMessageDialog(null, mess);
        txt.requestFocus();
        return true;
    }

    public static boolean checkSo(JTextField txt, String mss) {
        try {
            Integer.parseInt(txt.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(txt, mss);
            txt.requestFocus();
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        getConnection();
    }
}
