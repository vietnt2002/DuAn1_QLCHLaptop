/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.KhachHang;
import domainmodels.NhanVien;
import irepositories.IKhachHangRepository;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utilities.DBConnection;

/**
 *
 * @author ADMIN
 */
public class KhachHangRepository implements IKhachHangRepository {

    private Connection con = DBConnection.getConnection();

    @Override
    public List<KhachHang> getAll() {
        List<KhachHang> listKhachHang = new ArrayList<>();
        String sql = "SELECT Id, Ma, HoTen, NgaySinh, Sdt, DiaChi, NgayTao, NgaySua FROM dbo.KhachHang";
        try (PreparedStatement PS = con.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
            while (RS.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(RS.getString("Id"));
                khachHang.setMa(RS.getString("Ma"));
                khachHang.setHoTen(RS.getString("HoTen"));
                khachHang.setNgaySinh(RS.getDate("NgaySinh"));
                khachHang.setSdt(RS.getString("Sdt"));
                khachHang.setDiaChi(RS.getString("DiaChi"));
                khachHang.setNgayTao(RS.getDate("NgayTao"));
                khachHang.setNgaySua(RS.getDate("NgaySua"));
                listKhachHang.add(khachHang);
            }
        } catch (Exception e) {
        }
        return listKhachHang;
    }

    @Override
    public Integer them(KhachHang khachHang) {
        Integer result = 0;
        String sql = "Insert into KhachHang (HoTen,NgaySinh,Sdt,DiaChi) values (?,?,?,?)";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, khachHang.getHoTen());
            PS.setObject(2, khachHang.getNgaySinh());
            PS.setObject(3, khachHang.getSdt());
            PS.setObject(4, khachHang.getDiaChi());
            result = PS.executeUpdate();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer sua(KhachHang khachHang) {
        String sql = "Update KhachHang Set HoTen=?,NgaySinh=?,Sdt=?,DiaChi=?,NgaySua=? Where Ma = ?";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, khachHang.getHoTen());
            PS.setObject(2, khachHang.getNgaySinh());
            PS.setObject(3, khachHang.getSdt());
            PS.setObject(4, khachHang.getDiaChi());
            PS.setObject(5, khachHang.getNgaySua());
            PS.setObject(6, khachHang.getMa());
            PS.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer xoa(String ma) {
        String sql = "Delete from KhachHang Where ma = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            int result = ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public String getIdBySDT(String sdt) {
        try {
            String idKH = null;
            KhachHang khachHang = new KhachHang();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT Id FROM dbo.KhachHang WHERE Sdt = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sdt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idKH = rs.getString("Id");
                khachHang.setId(idKH);
            }
            return idKH;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getIdByMa(String ma) {
        try {
            String idKH = null;
            KhachHang khachHang = new KhachHang();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT Id FROM dbo.KhachHang WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idKH = rs.getString("Id");
                khachHang.setId(idKH);
            }
            return idKH;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<KhachHang> sapXepTenTang() {
        List<KhachHang> listKhachHang = new ArrayList<>();
        String sql = "SELECT Id, Ma, HoTen, NgaySinh, Sdt, DiaChi, NgayTao, NgaySua FROM dbo.KhachHang\n" +
                    "ORDER BY reverse(substring((reverse(HoTen)),0,charindex(' ',(reverse(HoTen))))) ASC";
        try (PreparedStatement PS = con.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
            while (RS.next()) {
                String id = RS.getString("Id");
                String ma = RS.getString("Ma");
                String hoTen = RS.getString("HoTen");
                Date ngaySinh = RS.getDate("NgaySinh");
                String sdt = RS.getString("Sdt");
                String diaChi = RS.getString("DiaChi");
                Date ngayTao = RS.getDate("NgayTao");
                Date ngaySua = RS.getDate("NgaySua");

                KhachHang khachHang = new KhachHang(id, ma, hoTen, ngaySinh, sdt, diaChi, ngayTao, ngaySua);
                listKhachHang.add(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    @Override
    public KhachHang checkTrungMa(String ma) {
        String sql = "SELECT Id, Ma, HoTen, NgaySinh, Sdt, DiaChi, NgayTao, NgaySua FROM dbo.KhachHang WHERE Ma = ?";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setString(1, ma);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(RS.getString("Id"));
                khachHang.setMa(RS.getString("Ma"));
                khachHang.setHoTen(RS.getString("HoTen"));
                khachHang.setNgaySinh(RS.getDate("NgaySinh"));
                khachHang.setSdt(RS.getString("Sdt"));
                khachHang.setDiaChi(RS.getString("DiaChi"));
                khachHang.setNgayTao(RS.getDate("NgayTao"));
                khachHang.setNgaySua(RS.getDate("NgaySua"));
                return khachHang;
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<KhachHang> sapXepTenGiam() {
        List<KhachHang> listKhachHang = new ArrayList<>();
        String sql = "SELECT Id, Ma, HoTen, NgaySinh, Sdt, DiaChi, NgayTao, NgaySua FROM dbo.KhachHang\n" +
                    "ORDER BY reverse(substring((reverse(HoTen)),0,charindex(' ',(reverse(HoTen))))) DESC";
        try (PreparedStatement PS = con.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
            while (RS.next()) {
                String id = RS.getString("Id");
                String ma = RS.getString("Ma");
                String hoTen = RS.getString("HoTen");
                Date ngaySinh = RS.getDate("NgaySinh");
                String sdt = RS.getString("Sdt");
                String diaChi = RS.getString("DiaChi");
                Date ngayTao = RS.getDate("NgayTao");
                Date ngaySua = RS.getDate("NgaySua");

                KhachHang khachHang = new KhachHang(id, ma, hoTen, ngaySinh, sdt, diaChi, ngayTao, ngaySua);
                listKhachHang.add(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    @Override
    public List<KhachHang> timTen(String timTen) {
        List<KhachHang> listKhachHang = new ArrayList<>();
        String sql = "SELECT Id, Ma, HoTen, NgaySinh, Sdt, DiaChi, NgayTao, NgaySua FROM dbo.KhachHang\n" +
                    "WHERE HoTen LIKE N'%"+timTen+"%' OR Sdt LIKE '%"+timTen+"%'";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(RS.getString("Id"));
                khachHang.setMa(RS.getString("Ma"));
                khachHang.setHoTen(RS.getString("HoTen"));
                khachHang.setNgaySinh(RS.getDate("NgaySinh"));
                khachHang.setSdt(RS.getString("Sdt"));
                khachHang.setDiaChi(RS.getString("DiaChi"));
                khachHang.setNgayTao(RS.getDate("NgayTao"));
                khachHang.setNgaySua(RS.getDate("NgaySua"));
                listKhachHang.add(khachHang);
            }
        } catch (Exception e) {
        }
        return listKhachHang;
    }

//    public static void main(String[] args) {
//        KhachHangRepository kh = new KhachHangRepository();
//        List<KhachHang> listkh = kh.timTen("u");
//        for (KhachHang khachHang : listkh) {
//            System.out.println(khachHang.toString());
//        }
//    }
    public String getHoTenByMa(String ma) {
        try {
            String hoTen = null;
            KhachHang khachHang = new KhachHang();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT HoTen FROM dbo.KhachHang WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hoTen = rs.getString("HoTen");

                khachHang.setHoTen(hoTen);
            }
            return hoTen;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public String getHoTenById(String id) {
        try {
            String hoTen = null;
            KhachHang khachHang = new KhachHang();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT HoTen FROM dbo.KhachHang WHERE Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hoTen = rs.getString("HoTen");

                khachHang.setHoTen(hoTen);
            }
            return hoTen;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public KhachHang getThongTinBySdt(String sdt) {
        try {
            KhachHang khachHang = new KhachHang();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT HoTen, Sdt FROM dbo.KhachHang WHERE Sdt = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sdt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String hoTen = rs.getString("HoTen");
                String Sdt = rs.getString("Sdt");

                khachHang.setHoTen(hoTen);
                khachHang.setSdt(Sdt);
            }
            return khachHang;
        } catch (Exception e) {
            return null;
        }
    }

}
