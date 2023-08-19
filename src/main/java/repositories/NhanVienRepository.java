/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.ChucVu;
import domainmodels.NhanVien;
import irepositories.INhanVienRepository;
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
public class NhanVienRepository implements INhanVienRepository {

    private Connection con = DBConnection.getConnection();

    @Override
    public List<NhanVien> getAll() {
        try {
            List<NhanVien> lstNhanVien = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT NV.Id AS 'Id', CV.Id AS 'IdCV', CV.Ma AS 'MaCV', CV.Ten AS 'TenCV', NV.Ma AS 'Ma', NV.HoTen AS 'HoTen', NV.GioiTinh AS 'GioiTinh',\n" +
                        "NV.NgaySinh AS 'NgaySinh', NV.Sdt AS 'Sdt', NV.DiaChi AS 'DiaChi', NV.MatKhau AS 'MatKhau', NV.NgayTao AS 'NgayTao', NV.NgaySua AS 'NgaySua', NV.TrangThai AS 'TrangThai'\n" +
                        "FROM dbo.NhanVien NV JOIN dbo.ChucVu CV\n" +
                        "ON CV.Id = NV.IdCV";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idCV = rs.getString("IdCV");
                String maCV = rs.getString("MaCV");
                String tenCV = rs.getString("TenCV");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String sdt = rs.getString("Sdt");
                String diaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                int trangThai = rs.getInt("TrangThai");

                ChucVu chucVu = new ChucVu();
                chucVu.setId(idCV);
                chucVu.setMa(maCV);
                chucVu.setTen(tenCV);

                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(id);
                nhanVien.setMa(ma);
                nhanVien.setHoTen(hoTen);
                nhanVien.setGioiTinh(gioiTinh);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setSdt(sdt);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setNgayTao(ngayTao);
                nhanVien.setNgaySua(ngaySua);
                nhanVien.setTrangThai(trangThai);
                nhanVien.setIdCV(chucVu + "");

                lstNhanVien.add(nhanVien);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstNhanVien;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public NhanVien getTaiKhoan(String username) {
        List<NhanVien> lstNhanVien = getAll();
        for (NhanVien nhanVien : lstNhanVien) {
            if (nhanVien.getMa().equals(username)) {
                return nhanVien;
            }
        }
        return null;
    }

    @Override
    public Integer them(NhanVien nhanVien) {
        String sql = "Insert into NhanVien (idCV,HoTen,GioiTinh,NgaySinh,Sdt,DiaChi,MatKhau) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, nhanVien.getIdCV());
            PS.setObject(2, nhanVien.getHoTen());
            PS.setObject(3, nhanVien.getGioiTinh());
            PS.setObject(4, nhanVien.getNgaySinh());
            PS.setObject(5, nhanVien.getSdt());
            PS.setObject(6, nhanVien.getDiaChi());
            PS.setObject(7, nhanVien.getMatKhau());
            PS.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer sua(NhanVien nhanVien) {
        String sql = "Update NhanVien Set idCV =?,HoTen=?,GioiTinh=?,NgaySinh=?,Sdt=?,DiaChi=?,MatKhau=?,TrangThai=? Where ma = ?";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, nhanVien.getIdCV());
            PS.setObject(2, nhanVien.getHoTen());
            PS.setObject(3, nhanVien.getGioiTinh());
            PS.setObject(4, nhanVien.getNgaySinh());
            PS.setObject(5, nhanVien.getSdt());
            PS.setObject(6, nhanVien.getDiaChi());
            PS.setObject(7, nhanVien.getMatKhau());
            PS.setObject(8, nhanVien.getTrangThai());
            PS.setObject(9, nhanVien.getMa());
            PS.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer xoa(String ma) {
        String sql = "Delete from NhanVien Where ma = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            int result = ps.executeUpdate();
            return result;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public String getIdByTen(String ma) {
        try {
            String idNV = null;
            NhanVien nhanVien = new NhanVien();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT Id FROM dbo.NhanVien WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idNV = rs.getString("Id");
                nhanVien.setId(idNV);
            }
            return idNV;
        } catch (Exception e) {
            return null;
        }
    }

    public String setQuyen(String ma) {
        try {

            String sql = "Select CV.Ten From dbo.ChucVu CV Join NhanVien NV On NV.IdCV=CV.id WHERE NV.Ma Like '" + ma + "'";
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet rs = PS.executeQuery();
            while (rs.next()) {
                String cv = rs.getString("Ten");
                return cv;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getChucVu() {
        List<String> list = new ArrayList<>();
        String sql = "Select Ten from ChucVu";
        try (PreparedStatement Ps = con.prepareStatement(sql)) {
            ResultSet Rs = Ps.executeQuery();
            while (Rs.next()) {
                list.add(Rs.getString("Ten"));
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public NhanVien checkTrungMa(String ma) {
        String sql = "SELECT Id, IdCV, Ma, HoTen, GioiTinh, NgaySinh, Sdt, DiaChi, MatKhau, NgayTao, NgaySua, TrangThai FROM dbo.NhanVien WHERE Ma = ?";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setString(1, ma);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                String id = RS.getString("Id");
                String chucVu = RS.getString("IdCv");
                String ma1 = RS.getString("Ma");
                String hoTen = RS.getString("HoTen");
                String gTinh = RS.getString("GioiTinh");
                Date ngaySinh = RS.getDate("NgaySinh");
                String sdt = RS.getString("Sdt");
                String diaChi = RS.getString("DiaChi");
                String matKhau = RS.getString("MatKhau");
                Date ngayTao = RS.getDate("NgayTao");
                Date ngaySua = RS.getDate("NgaySua");
                Integer trangThai = RS.getInt("TrangThai");
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(id);
                nhanVien.setMa(ma1);
                nhanVien.setHoTen(hoTen);
                nhanVien.setGioiTinh(gTinh);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setSdt(sdt);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setNgayTao(ngayTao);
                nhanVien.setNgaySua(ngaySua);
                nhanVien.setTrangThai(trangThai);
                nhanVien.setIdCV(chucVu + "");
                return nhanVien;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String getHoTenByMa(String ma) {
        try {
            String hoTen = null;
            NhanVien nhanVien = new NhanVien();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT HoTen FROM dbo.NhanVien WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hoTen = rs.getString("HoTen");
                nhanVien.setHoTen(hoTen);
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
            NhanVien nhanVien = new NhanVien();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT HoTen FROM dbo.NhanVien WHERE Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hoTen = rs.getString("HoTen");
                nhanVien.setHoTen(hoTen);
            }
            return hoTen;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<NhanVien> getAllDangLam() {
        try {
            List<NhanVien> lstNhanVien = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT NV.Id AS 'Id', CV.Id AS 'IdCV', CV.Ma AS 'MaCV', CV.Ten AS 'TenCV', NV.Ma AS 'Ma', NV.HoTen AS 'HoTen', NV.GioiTinh AS 'GioiTinh', \n"
                    + "NV.NgaySinh AS 'NgaySinh', NV.Sdt AS 'Sdt', NV.DiaChi AS 'DiaChi', NV.MatKhau AS 'MatKhau', NV.NgayTao AS 'NgayTao', NV.NgaySua AS 'NgaySua', NV.TrangThai AS 'TrangThai' \n"
                    + "FROM dbo.NhanVien NV JOIN dbo.ChucVu CV\n"
                    + "ON CV.Id = NV.IdCV Where NV.TrangThai = 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idCV = rs.getString("IdCV");
                String maCV = rs.getString("MaCV");
                String tenCV = rs.getString("TenCV");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String sdt = rs.getString("Sdt");
                String diaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                int trangThai = rs.getInt("TrangThai");

                ChucVu chucVu = new ChucVu();
                chucVu.setId(idCV);
                chucVu.setMa(maCV);
                chucVu.setTen(tenCV);

                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(id);
                nhanVien.setMa(ma);
                nhanVien.setHoTen(hoTen);
                nhanVien.setGioiTinh(gioiTinh);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setSdt(sdt);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setNgayTao(ngayTao);
                nhanVien.setNgaySua(ngaySua);
                nhanVien.setTrangThai(trangThai);
                nhanVien.setIdCV(chucVu + "");

                lstNhanVien.add(nhanVien);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstNhanVien;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<NhanVien> getAllDaNghi() {
        try {
            List<NhanVien> lstNhanVien = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT NV.Id AS 'Id', CV.Id AS 'IdCV', CV.Ma AS 'MaCV', CV.Ten AS 'TenCV', NV.Ma AS 'Ma', NV.HoTen AS 'HoTen', NV.GioiTinh AS 'GioiTinh', \n"
                    + "NV.NgaySinh AS 'NgaySinh', NV.Sdt AS 'Sdt', NV.DiaChi AS 'DiaChi', NV.MatKhau AS 'MatKhau', NV.NgayTao AS 'NgayTao', NV.NgaySua AS 'NgaySua', NV.TrangThai AS 'TrangThai' \n"
                    + "FROM dbo.NhanVien NV JOIN dbo.ChucVu CV\n"
                    + "ON CV.Id = NV.IdCV Where NV.TrangThai = 0";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idCV = rs.getString("IdCV");
                String maCV = rs.getString("MaCV");
                String tenCV = rs.getString("TenCV");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String sdt = rs.getString("Sdt");
                String diaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                int trangThai = rs.getInt("TrangThai");

                ChucVu chucVu = new ChucVu();
                chucVu.setId(idCV);
                chucVu.setMa(maCV);
                chucVu.setTen(tenCV);

                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(id);
                nhanVien.setMa(ma);
                nhanVien.setHoTen(hoTen);
                nhanVien.setGioiTinh(gioiTinh);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setSdt(sdt);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setNgayTao(ngayTao);
                nhanVien.setNgaySua(ngaySua);
                nhanVien.setTrangThai(trangThai);
                nhanVien.setIdCV(chucVu + "");

                lstNhanVien.add(nhanVien);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstNhanVien;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<NhanVien> timTenNvLam(String ten) {
        try {
            List<NhanVien> lstNhanVien = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT NV.Id AS 'Id', CV.Id AS 'IdCV', CV.Ma AS 'MaCV', CV.Ten AS 'TenCV', NV.Ma AS 'Ma', NV.HoTen AS 'HoTen', NV.GioiTinh AS 'GioiTinh', \n"
                    + "NV.NgaySinh AS 'NgaySinh', NV.Sdt AS 'Sdt', NV.DiaChi AS 'DiaChi', NV.MatKhau AS 'MatKhau', NV.NgayTao AS 'NgayTao', NV.NgaySua AS 'NgaySua', NV.TrangThai AS 'TrangThai' \n"
                    + "FROM dbo.NhanVien NV JOIN dbo.ChucVu CV\n"
                    + "ON CV.Id = NV.IdCV Where NV.HoTen Like N'%" + ten + "%' AND NV.TrangThai = 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idCV = rs.getString("IdCV");
                String maCV = rs.getString("MaCV");
                String tenCV = rs.getString("TenCV");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String sdt = rs.getString("Sdt");
                String diaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                int trangThai = rs.getInt("TrangThai");

                ChucVu chucVu = new ChucVu();
                chucVu.setId(idCV);
                chucVu.setMa(maCV);
                chucVu.setTen(tenCV);

                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(id);
                nhanVien.setMa(ma);
                nhanVien.setHoTen(hoTen);
                nhanVien.setGioiTinh(gioiTinh);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setSdt(sdt);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setNgayTao(ngayTao);
                nhanVien.setNgaySua(ngaySua);
                nhanVien.setTrangThai(trangThai);
                nhanVien.setIdCV(chucVu + "");

                lstNhanVien.add(nhanVien);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstNhanVien;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<NhanVien> timTenNvNghi(String ten) {
        try {
            List<NhanVien> lstNhanVien = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT NV.Id AS 'Id', CV.Id AS 'IdCV', CV.Ma AS 'MaCV', CV.Ten AS 'TenCV', NV.Ma AS 'Ma', NV.HoTen AS 'HoTen', NV.GioiTinh AS 'GioiTinh', \n"
                    + "NV.NgaySinh AS 'NgaySinh', NV.Sdt AS 'Sdt', NV.DiaChi AS 'DiaChi', NV.MatKhau AS 'MatKhau', NV.NgayTao AS 'NgayTao', NV.NgaySua AS 'NgaySua', NV.TrangThai AS 'TrangThai' \n"
                    + "FROM dbo.NhanVien NV JOIN dbo.ChucVu CV\n"
                    + "ON CV.Id = NV.IdCV Where NV.HoTen Like N'%" + ten + "%' AND NV.TrangThai = 0";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idCV = rs.getString("IdCV");
                String maCV = rs.getString("MaCV");
                String tenCV = rs.getString("TenCV");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String sdt = rs.getString("Sdt");
                String diaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                int trangThai = rs.getInt("TrangThai");

                ChucVu chucVu = new ChucVu();
                chucVu.setId(idCV);
                chucVu.setMa(maCV);
                chucVu.setTen(tenCV);

                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(id);
                nhanVien.setMa(ma);
                nhanVien.setHoTen(hoTen);
                nhanVien.setGioiTinh(gioiTinh);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setSdt(sdt);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setNgayTao(ngayTao);
                nhanVien.setNgaySua(ngaySua);
                nhanVien.setTrangThai(trangThai);
                nhanVien.setIdCV(chucVu + "");

                lstNhanVien.add(nhanVien);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstNhanVien;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<NhanVien> sapXepTenGiamNVLam() {
        try {
            List<NhanVien> lstNhanVien = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT NV.Id AS 'Id', CV.Id AS 'IdCV', CV.Ma AS 'MaCV', CV.Ten AS 'TenCV', NV.Ma AS 'Ma', NV.HoTen AS 'HoTen', NV.GioiTinh AS 'GioiTinh', \n"
                    + "NV.NgaySinh AS 'NgaySinh', NV.Sdt AS 'Sdt', NV.DiaChi AS 'DiaChi', NV.MatKhau AS 'MatKhau', NV.NgayTao AS 'NgayTao', NV.NgaySua AS 'NgaySua', NV.TrangThai AS 'TrangThai' \n"
                    + "FROM dbo.NhanVien NV JOIN dbo.ChucVu CV\n"
                    + "ON CV.Id = NV.IdCV Where NV.TrangThai=1 Order by reverse(substring((reverse(NV.HoTen)),0,charindex(' ',(reverse(NV.HoTen))))) DESC";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idCV = rs.getString("IdCV");
                String maCV = rs.getString("MaCV");
                String tenCV = rs.getString("TenCV");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String sdt = rs.getString("Sdt");
                String diaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                int trangThai = rs.getInt("TrangThai");

                ChucVu chucVu = new ChucVu();
                chucVu.setId(idCV);
                chucVu.setMa(maCV);
                chucVu.setTen(tenCV);

                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(id);
                nhanVien.setMa(ma);
                nhanVien.setHoTen(hoTen);
                nhanVien.setGioiTinh(gioiTinh);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setSdt(sdt);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setNgayTao(ngayTao);
                nhanVien.setNgaySua(ngaySua);
                nhanVien.setTrangThai(trangThai);
                nhanVien.setIdCV(chucVu + "");

                lstNhanVien.add(nhanVien);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstNhanVien;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<NhanVien> sapXepTenGiamNVNghi() {
        try {
            List<NhanVien> lstNhanVien = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT NV.Id AS 'Id', CV.Id AS 'IdCV', CV.Ma AS 'MaCV', CV.Ten AS 'TenCV', NV.Ma AS 'Ma', NV.HoTen AS 'HoTen', NV.GioiTinh AS 'GioiTinh', \n"
                    + "NV.NgaySinh AS 'NgaySinh', NV.Sdt AS 'Sdt', NV.DiaChi AS 'DiaChi', NV.MatKhau AS 'MatKhau', NV.NgayTao AS 'NgayTao', NV.NgaySua AS 'NgaySua', NV.TrangThai AS 'TrangThai' \n"
                    + "FROM dbo.NhanVien NV JOIN dbo.ChucVu CV\n"
                    + "ON CV.Id = NV.IdCV Where NV.TrangThai=0  Order by reverse(substring((reverse(NV.HoTen)),0,charindex(' ',(reverse(NV.HoTen))))) DESC";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idCV = rs.getString("IdCV");
                String maCV = rs.getString("MaCV");
                String tenCV = rs.getString("TenCV");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String sdt = rs.getString("Sdt");
                String diaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                int trangThai = rs.getInt("TrangThai");

                ChucVu chucVu = new ChucVu();
                chucVu.setId(idCV);
                chucVu.setMa(maCV);
                chucVu.setTen(tenCV);

                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(id);
                nhanVien.setMa(ma);
                nhanVien.setHoTen(hoTen);
                nhanVien.setGioiTinh(gioiTinh);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setSdt(sdt);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setNgayTao(ngayTao);
                nhanVien.setNgaySua(ngaySua);
                nhanVien.setTrangThai(trangThai);
                nhanVien.setIdCV(chucVu + "");

                lstNhanVien.add(nhanVien);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstNhanVien;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<NhanVien> sapXepTenTangNVLam() {
        try {
            List<NhanVien> lstNhanVien = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT NV.Id AS 'Id', CV.Id AS 'IdCV', CV.Ma AS 'MaCV', CV.Ten AS 'TenCV', NV.Ma AS 'Ma', NV.HoTen AS 'HoTen', NV.GioiTinh AS 'GioiTinh', \n"
                    + "NV.NgaySinh AS 'NgaySinh', NV.Sdt AS 'Sdt', NV.DiaChi AS 'DiaChi', NV.MatKhau AS 'MatKhau', NV.NgayTao AS 'NgayTao', NV.NgaySua AS 'NgaySua', NV.TrangThai AS 'TrangThai' \n"
                    + "FROM dbo.NhanVien NV JOIN dbo.ChucVu CV\n"
                    + "ON CV.Id = NV.IdCV Where NV.TrangThai=1  Order by reverse(substring((reverse(NV.HoTen)),0,charindex(' ',(reverse(NV.HoTen))))) ASC";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idCV = rs.getString("IdCV");
                String maCV = rs.getString("MaCV");
                String tenCV = rs.getString("TenCV");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String sdt = rs.getString("Sdt");
                String diaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                int trangThai = rs.getInt("TrangThai");

                ChucVu chucVu = new ChucVu();
                chucVu.setId(idCV);
                chucVu.setMa(maCV);
                chucVu.setTen(tenCV);

                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(id);
                nhanVien.setMa(ma);
                nhanVien.setHoTen(hoTen);
                nhanVien.setGioiTinh(gioiTinh);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setSdt(sdt);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setNgayTao(ngayTao);
                nhanVien.setNgaySua(ngaySua);
                nhanVien.setTrangThai(trangThai);
                nhanVien.setIdCV(chucVu + "");

                lstNhanVien.add(nhanVien);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstNhanVien;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<NhanVien> sapXepTenTangNVNghi() {
        try {
            List<NhanVien> lstNhanVien = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT NV.Id AS 'Id', CV.Id AS 'IdCV', CV.Ma AS 'MaCV', CV.Ten AS 'TenCV', NV.Ma AS 'Ma', NV.HoTen AS 'HoTen', NV.GioiTinh AS 'GioiTinh', \n"
                    + "NV.NgaySinh AS 'NgaySinh', NV.Sdt AS 'Sdt', NV.DiaChi AS 'DiaChi', NV.MatKhau AS 'MatKhau', NV.NgayTao AS 'NgayTao', NV.NgaySua AS 'NgaySua', NV.TrangThai AS 'TrangThai' \n"
                    + "FROM dbo.NhanVien NV JOIN dbo.ChucVu CV\n"
                    + "ON CV.Id = NV.IdCV Where NV.TrangThai=0  Order by reverse(substring((reverse(NV.HoTen)),0,charindex(' ',(reverse(NV.HoTen))))) ASC";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idCV = rs.getString("IdCV");
                String maCV = rs.getString("MaCV");
                String tenCV = rs.getString("TenCV");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String sdt = rs.getString("Sdt");
                String diaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                int trangThai = rs.getInt("TrangThai");

                ChucVu chucVu = new ChucVu();
                chucVu.setId(idCV);
                chucVu.setMa(maCV);
                chucVu.setTen(tenCV);

                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(id);
                nhanVien.setMa(ma);
                nhanVien.setHoTen(hoTen);
                nhanVien.setGioiTinh(gioiTinh);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setSdt(sdt);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setNgayTao(ngayTao);
                nhanVien.setNgaySua(ngaySua);
                nhanVien.setTrangThai(trangThai);
                nhanVien.setIdCV(chucVu + "");

                lstNhanVien.add(nhanVien);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstNhanVien;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<NhanVien> locChucVuNVLam(String chucVu1) {
        try {
            List<NhanVien> lstNhanVien = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT NV.Id AS 'Id', CV.Id AS 'IdCV', CV.Ma AS 'MaCV', CV.Ten AS 'TenCV', NV.Ma AS 'Ma', NV.HoTen AS 'HoTen', NV.GioiTinh AS 'GioiTinh', \n"
                    + "NV.NgaySinh AS 'NgaySinh', NV.Sdt AS 'Sdt', NV.DiaChi AS 'DiaChi', NV.MatKhau AS 'MatKhau', NV.NgayTao AS 'NgayTao', NV.NgaySua AS 'NgaySua', NV.TrangThai AS 'TrangThai' \n"
                    + "FROM dbo.NhanVien NV JOIN dbo.ChucVu CV\n"
                    + "ON CV.Id = NV.IdCV Where CV.Ten = ? AND  NV.TrangThai = 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, chucVu1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idCV = rs.getString("IdCV");
                String maCV = rs.getString("MaCV");
                String tenCV = rs.getString("TenCV");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String sdt = rs.getString("Sdt");
                String diaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                int trangThai = rs.getInt("TrangThai");

                ChucVu chucVu = new ChucVu();
                chucVu.setId(idCV);
                chucVu.setMa(maCV);
                chucVu.setTen(tenCV);

                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(id);
                nhanVien.setMa(ma);
                nhanVien.setHoTen(hoTen);
                nhanVien.setGioiTinh(gioiTinh);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setSdt(sdt);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setNgayTao(ngayTao);
                nhanVien.setNgaySua(ngaySua);
                nhanVien.setTrangThai(trangThai);
                nhanVien.setIdCV(chucVu + "");

                lstNhanVien.add(nhanVien);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstNhanVien;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<NhanVien> locChucVuNVNghi(String chucVu1) {
        try {
            List<NhanVien> lstNhanVien = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT NV.Id AS 'Id', CV.Id AS 'IdCV', CV.Ma AS 'MaCV', CV.Ten AS 'TenCV', NV.Ma AS 'Ma', NV.HoTen AS 'HoTen', NV.GioiTinh AS 'GioiTinh', \n"
                    + "NV.NgaySinh AS 'NgaySinh', NV.Sdt AS 'Sdt', NV.DiaChi AS 'DiaChi', NV.MatKhau AS 'MatKhau', NV.NgayTao AS 'NgayTao', NV.NgaySua AS 'NgaySua', NV.TrangThai AS 'TrangThai' \n"
                    + "FROM dbo.NhanVien NV JOIN dbo.ChucVu CV\n"
                    + "ON CV.Id = NV.IdCV Where CV.Ten = ? AND  NV.TrangThai = 0";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, chucVu1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idCV = rs.getString("IdCV");
                String maCV = rs.getString("MaCV");
                String tenCV = rs.getString("TenCV");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String sdt = rs.getString("Sdt");
                String diaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                int trangThai = rs.getInt("TrangThai");

                ChucVu chucVu = new ChucVu();
                chucVu.setId(idCV);
                chucVu.setMa(maCV);
                chucVu.setTen(tenCV);

                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(id);
                nhanVien.setMa(ma);
                nhanVien.setHoTen(hoTen);
                nhanVien.setGioiTinh(gioiTinh);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setSdt(sdt);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setNgayTao(ngayTao);
                nhanVien.setNgaySua(ngaySua);
                nhanVien.setTrangThai(trangThai);
                nhanVien.setIdCV(chucVu + "");

                lstNhanVien.add(nhanVien);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstNhanVien;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        NhanVienRepository nv = new NhanVienRepository();
        String list = nv.setQuyen("NV02");

        System.out.println(list.toString());

    }

}
