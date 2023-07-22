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
        String sql = "Select * from KhachHang";
        try (PreparedStatement PS = con.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
            while (RS.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(RS.getString("Id"));
                khachHang.setMa(RS.getString("Ma"));
                khachHang.setTen(RS.getString("Ten"));
                khachHang.setTenDem(RS.getString("TenDem"));
                khachHang.setHo(RS.getString("Ho"));
                khachHang.setNgaySinh(RS.getDate("NgaySinh"));
                khachHang.setSdt(RS.getString("Sdt"));
                khachHang.setDiaChi(RS.getString("DiaChi"));
                khachHang.setEmail(RS.getString("Email"));
                khachHang.setSoLanMuaHang(RS.getInt("SoLanMuaHang"));
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
        String sql = "Insert into KhachHang (Ma,Ten,tenDem,Ho,NgaySinh,Sdt,DiaChi,Email,SoLanMuaHang) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, khachHang.getMa());
            PS.setObject(2, khachHang.getTen());
            PS.setObject(3, khachHang.getTenDem());
            PS.setObject(4, khachHang.getHo());
            PS.setObject(5, khachHang.getNgaySinh());
            PS.setObject(6, khachHang.getSdt());
            PS.setObject(7, khachHang.getDiaChi());
            PS.setObject(8, khachHang.getEmail());
            PS.setObject(9, khachHang.getSoLanMuaHang());
            result = PS.executeUpdate();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer sua(KhachHang khachHang) {
        String sql = "Update KhachHang Set Ten = ?,TenDem = ?,Ho=?,NgaySinh=?,Sdt=?,DiaChi=?,Email=?,SoLanMuaHang =? Where Ma = ?";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, khachHang.getTen());
            PS.setObject(2, khachHang.getTenDem());
            PS.setObject(3, khachHang.getHo());
            PS.setObject(4, khachHang.getNgaySinh());
            PS.setObject(5, khachHang.getSdt());
            PS.setObject(6, khachHang.getDiaChi());
            PS.setObject(7, khachHang.getEmail());
            PS.setObject(8, khachHang.getSoLanMuaHang());
            PS.setObject(9, khachHang.getMa());
            PS.executeUpdate();
        } catch (Exception e) {
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
        String sql = "Select * from KhachHang Order by ten ASC";
        try (PreparedStatement PS = con.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
            while (RS.next()) {
                String id = RS.getString("Id");
                String ma = RS.getString("Ma");
                String ten = RS.getString("Ten");
                String tenDem = RS.getString("TenDem");
                String ho = RS.getString("Ho");
                Date ngaySinh = RS.getDate("NgaySinh");
                String sdt = RS.getString("Sdt");
                String diaChi = RS.getString("DiaChi");
                String email = RS.getString("Email");
                int soLanMuaHang = RS.getInt("SoLanMuaHang");
                Date ngayTao = RS.getDate("NgayTao");
                Date ngaySua = RS.getDate("NgaySua");

                KhachHang khachHang = new KhachHang(id, ma, ten, tenDem, ho, ngaySinh, sdt, diaChi, email, soLanMuaHang, ngayTao, ngaySua);
                listKhachHang.add(khachHang);
            }
        } catch (Exception e) {
        }
        return listKhachHang;
    }

    @Override
    public KhachHang checkTrungMa(String ma) {
        String sql = "Select * from khachhang where ma = ?";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setString(1, ma);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(RS.getString("Id"));
                khachHang.setMa(RS.getString("Ma"));
                khachHang.setTen(RS.getString("Ten"));
                khachHang.setTenDem(RS.getString("TenDem"));
                khachHang.setHo(RS.getString("Ho"));
                khachHang.setNgaySinh(RS.getDate("NgaySinh"));
                khachHang.setSdt(RS.getString("Sdt"));
                khachHang.setDiaChi(RS.getString("DiaChi"));
                khachHang.setEmail(RS.getString("Email"));
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
        String sql = "Select * from KhachHang Order by ten Desc";
        try (PreparedStatement PS = con.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
            while (RS.next()) {
                String id = RS.getString("Id");
                String ma = RS.getString("Ma");
                String ten = RS.getString("Ten");
                String tenDem = RS.getString("TenDem");
                String ho = RS.getString("Ho");
                Date ngaySinh = RS.getDate("NgaySinh");
                String sdt = RS.getString("Sdt");
                String diaChi = RS.getString("DiaChi");
                String email = RS.getString("Email");
                int soLanMuaHang = RS.getInt("SoLanMuaHang");
                Date ngayTao = RS.getDate("NgayTao");
                Date ngaySua = RS.getDate("NgaySua");

                KhachHang khachHang = new KhachHang(id, ma, ten, tenDem, ho, ngaySinh, sdt, diaChi, email, soLanMuaHang, ngayTao, ngaySua);
                listKhachHang.add(khachHang);
            }
        } catch (Exception e) {
        }
        return listKhachHang;
    }

    @Override
    public List<KhachHang> timTen(String timTen) {
        List<KhachHang> listKhachHang = new ArrayList<>();
        String sql = "Select * from KhachHang Where ten Like N'%" + timTen + "%' OR sdt Like '%" + timTen + "%'";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(RS.getString("Id"));
                khachHang.setMa(RS.getString("Ma"));
                khachHang.setTen(RS.getString("Ten"));
                khachHang.setTenDem(RS.getString("TenDem"));
                khachHang.setHo(RS.getString("Ho"));
                khachHang.setNgaySinh(RS.getDate("NgaySinh"));
                khachHang.setSdt(RS.getString("Sdt"));
                khachHang.setDiaChi(RS.getString("DiaChi"));
                khachHang.setEmail(RS.getString("Email"));
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
    public KhachHang getHoTenByMa(String ma) {
        try {
            KhachHang khachHang = new KhachHang();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT Ho, TenDem, Ten FROM dbo.KhachHang WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ho = rs.getString("Ho");
                String tenDem = rs.getString("TenDem");
                String ten = rs.getString("Ten");

                khachHang.setHo(ho);
                khachHang.setTenDem(tenDem);
                khachHang.setTen(ten);
            }
            return khachHang;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public KhachHang getHoTenById(String id) {
        try {
            KhachHang khachHang = new KhachHang();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT Ho, TenDem, Ten FROM dbo.KhachHang WHERE Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ho = rs.getString("Ho");
                String tenDem = rs.getString("TenDem");
                String ten = rs.getString("Ten");

                khachHang.setHo(ho);
                khachHang.setTenDem(tenDem);
                khachHang.setTen(ten);
            }
            return khachHang;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public KhachHang getThongTinBySdtOrEmail(String sdtOrEmail) {
        try {
            KhachHang khachHang = new KhachHang();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT Ho, TenDem, Ten, Email, Sdt FROM dbo.KhachHang WHERE Sdt = ? OR Email = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sdtOrEmail);
            ps.setString(2, sdtOrEmail);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ho = rs.getString("Ho");
                String tenDem = rs.getString("TenDem");
                String ten = rs.getString("Ten");
                String email = rs.getString("Email");
                String sdt = rs.getString("Sdt");

                khachHang.setHo(ho);
                khachHang.setTenDem(tenDem);
                khachHang.setTen(ten);
                khachHang.setEmail(email);
                khachHang.setSdt(sdt);

            }
            return khachHang;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Integer> getSoLanMua() {
        List<Integer> list = new ArrayList<>();
        String sql = "Select SoLanMuaHang from KhachHang Group by SoLanMuaHang";
        try (PreparedStatement PS = con.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
            while (RS.next()) {
                list.add(RS.getInt("SoLanMuaHang"));
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public List<KhachHang> locSoLanMua(int solan) {
        List<KhachHang> listKhachHang = new ArrayList<>();
        String sql = "Select * from KhachHang Where solanmuahang =" + solan;
        try (PreparedStatement PS = con.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
            while (RS.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(RS.getString("Id"));
                khachHang.setMa(RS.getString("Ma"));
                khachHang.setTen(RS.getString("Ten"));
                khachHang.setTenDem(RS.getString("TenDem"));
                khachHang.setHo(RS.getString("Ho"));
                khachHang.setNgaySinh(RS.getDate("NgaySinh"));
                khachHang.setSdt(RS.getString("Sdt"));
                khachHang.setSoLanMuaHang(RS.getInt("SoLanMuaHang"));
                khachHang.setDiaChi(RS.getString("DiaChi"));
                khachHang.setEmail(RS.getString("Email"));
                khachHang.setNgayTao(RS.getDate("NgayTao"));
                khachHang.setNgaySua(RS.getDate("NgaySua"));
                listKhachHang.add(khachHang);
            }
        } catch (Exception e) {
        }
        return listKhachHang;
    }

}
