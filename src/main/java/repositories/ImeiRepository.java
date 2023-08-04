/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.ChiTietSP;
import domainmodels.Imei;
import domainmodels.SanPham;
import irepositories.IChiTietSPRepository;
import irepositories.IImeiRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import utilities.DBConnection;

/**
 *
 * @author ADMIN
 */
public class ImeiRepository implements IImeiRepository {

    private final IChiTietSPRepository repo = new ChiTietSPRepository();

    @Override
    public List<Imei> getAll() {
        try {
            List<Imei> lstIMei = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT IMei, TrangThai FROM dbo.IMei \n"
                    + "WHERE TrangThai = 0";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String im = rs.getString("IMei");
                int trangThai = rs.getInt("TrangThai");

                Imei imei = new Imei();
                imei.setImei(im);
                imei.setTrangThai(trangThai);

                lstIMei.add(imei);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstIMei;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Imei> getAllByIdCtsp(String idCtsp) {
        try {
            List<Imei> lstIMei = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT IMei AS 'IMei', SP.Ten AS 'TenSP', IMei.TrangThai AS 'TrangThai' FROM dbo.IMei JOIN dbo.ChiTietSP CTSP\n"
                    + "ON CTSP.Id = IMei.IdChiTietSP JOIN dbo.SanPham SP\n"
                    + "ON SP.Id = CTSP.IdSP\n"
                    + "WHERE IMei.TrangThai = 0 AND IdChiTietSP = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idCtsp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String im = rs.getString("IMei");
                String tenSP = rs.getString("TenSP");
                int trangThai = rs.getInt("TrangThai");

                SanPham sanPham = new SanPham();
                sanPham.setTen(tenSP);
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setIdSP(sanPham + "");

                Imei imei = new Imei();
                imei.setImei(im);
                imei.setIdChiTietSP(chiTietSP);
                imei.setTrangThai(trangThai);

                lstIMei.add(imei);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstIMei;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer them(Imei imei) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "INSERT INTO dbo.Imei (IdChiTietSP) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, imei.getIdChiTietSP().getId());
            result = ps.executeUpdate();
            ps.close();
            connection.close();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Integer sua(Imei imei) {
        return null;
    }

    @Override
    public Integer xoa(String ma) {
        try {
            Connection con = DBConnection.getConnection();
            String lenh = "delete dbo.IMei WHERE IdChiTietSP like '" + ma + "'";
            PreparedStatement st = con.prepareStatement(lenh);
            return st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String getIdByIMei(String im) {
        try {
            String idChiTietSP = null;
            Imei imei = new Imei();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT IdChiTietSP FROM dbo.IMei WHERE IMei = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, im);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idChiTietSP = rs.getString("IdChiTietSP");
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setId(idChiTietSP);
                imei.setIdChiTietSP(chiTietSP);
            }
            return idChiTietSP;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Imei> timKiemImei(String idCtsp, String im) {
        try {
            List<Imei> lstIMei = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT IMei AS 'IMei', SP.Ten AS 'TenSP', IMei.TrangThai AS 'TrangThai' FROM dbo.IMei JOIN dbo.ChiTietSP CTSP\n"
                    + "ON CTSP.Id = IMei.IdChiTietSP JOIN dbo.SanPham SP\n"
                    + "ON SP.Id = CTSP.IdSP\n"
                    + "WHERE IMei.TrangThai = 0 AND IdChiTietSP = ? AND IMei LIKE '%" + im + "%'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idCtsp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String iMei = rs.getString("IMei");
                String tenSP = rs.getString("TenSP");
                int trangThai = rs.getInt("TrangThai");

                SanPham sanPham = new SanPham();
                sanPham.setTen(tenSP);
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setIdSP(sanPham + "");

                Imei imei = new Imei();
                imei.setImei(iMei);
                imei.setIdChiTietSP(chiTietSP);
                imei.setTrangThai(trangThai);

                lstIMei.add(imei);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstIMei;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer updateTrangThai(String trangThai, String imei) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "UPDATE dbo.IMei SET TrangThai = ? WHERE IMei = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, trangThai);
            ps.setString(2, imei);
            result = ps.executeUpdate();
            ps.close();
            connection.close();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Map<String, String> hashMapMaCTSP() {

        Map<String, String> tenSp = new HashMap<>();
        List<ChiTietSP> lst = repo.getAll();
        for (ChiTietSP a : lst) {
            tenSp.put(a.getId(), a.getMa());
        }
        return tenSp;
    }

    @Override
    public List<Imei> getAllwId() {
        try {
            List<Imei> lstIMei = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT id, IMei, TrangThai FROM dbo.IMei";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String im = rs.getString("IMei");
                int trangThai = rs.getInt("TrangThai");
                Imei imei = new Imei();
                imei.setId(id);
                imei.setImei(im);
                imei.setTrangThai(trangThai);
                lstIMei.add(imei);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstIMei;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer xoaCTSP(String idChiTietSP) {
        try {
            java.util.UUID id = UUID.fromString(idChiTietSP);
            Connection connection = DBConnection.getConnection();
            String lenh = "delete dbo.Imei where IdChiTietSP = ?";
            PreparedStatement ps = connection.prepareStatement(lenh);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Imei> timImei(String idCtsp) {
        try {
            List<Imei> lstIMei = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT IMei AS 'IMei', SP.Ten AS 'TenSP', IMei.TrangThai AS 'TrangThai' FROM dbo.IMei JOIN dbo.ChiTietSP CTSP\n"
                    + "ON CTSP.Id = IMei.IdChiTietSP JOIN dbo.SanPham SP\n"
                    + "ON SP.Id = CTSP.IdSP\n"
                    + "WHERE IdChiTietSP = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idCtsp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String iMei = rs.getString("IMei");
                String tenSP = rs.getString("TenSP");
                int trangThai = rs.getInt("TrangThai");

                SanPham sanPham = new SanPham();
                sanPham.setTen(tenSP);
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setIdSP(sanPham + "");

                Imei imei = new Imei();
                imei.setImei(iMei);
                imei.setIdChiTietSP(chiTietSP);
                imei.setTrangThai(trangThai);

                lstIMei.add(imei);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstIMei;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Imei> timtheoImei(String im) {
        try {
            List<Imei> lstIMei = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT IMei AS 'IMei', SP.Ten AS 'TenSP', IMei.TrangThai AS 'TrangThai' FROM dbo.IMei JOIN dbo.ChiTietSP CTSP\n"
                    + "ON CTSP.Id = IMei.IdChiTietSP JOIN dbo.SanPham SP\n"
                    + "ON SP.Id = CTSP.IdSP\n"
                    + "WHERE IMei LIKE '%" + im + "%'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String iMei = rs.getString("IMei");
                String tenSP = rs.getString("TenSP");
                int trangThai = rs.getInt("TrangThai");

                SanPham sanPham = new SanPham();
                sanPham.setTen(tenSP);
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setIdSP(sanPham + "");

                Imei imei = new Imei();
                imei.setImei(iMei);
                imei.setIdChiTietSP(chiTietSP);
                imei.setTrangThai(trangThai);

                lstIMei.add(imei);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstIMei;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Imei> getAllByIdCTSP_0TT(String idChiTietSP) {
        try {
            List<Imei> lstIMei = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT IMei AS 'IMei', SP.Ten AS 'TenSP', IMei.TrangThai AS 'TrangThai' FROM dbo.IMei JOIN dbo.ChiTietSP CTSP\n"
                    + "ON CTSP.Id = IMei.IdChiTietSP JOIN dbo.SanPham SP\n"
                    + "ON SP.Id = CTSP.IdSP\n"
                    + "WHERE IdChiTietSP = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idChiTietSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String im = rs.getString("IMei");
                String tenSP = rs.getString("TenSP");
                int trangThai = rs.getInt("TrangThai");

                SanPham sanPham = new SanPham();
                sanPham.setTen(tenSP);
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setIdSP(sanPham + "");

                Imei imei = new Imei();
                imei.setImei(im);
                imei.setIdChiTietSP(chiTietSP);
                imei.setTrangThai(trangThai);

                lstIMei.add(imei);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstIMei;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Imei> timKiemImei_0TT(String idCTSP, String im) {
        try {
            List<Imei> lstIMei = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT IMei AS 'IMei', SP.Ten AS 'TenSP', IMei.TrangThai AS 'TrangThai' FROM dbo.IMei JOIN dbo.ChiTietSP CTSP\n"
                    + "ON CTSP.Id = IMei.IdChiTietSP JOIN dbo.SanPham SP\n"
                    + "ON SP.Id = CTSP.IdSP\n"
                    + "WHERE IdChiTietSP = ? AND IMei LIKE '%" + im + "%'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idCTSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String iMei = rs.getString("IMei");
                String tenSP = rs.getString("TenSP");
                int trangThai = rs.getInt("TrangThai");

                SanPham sanPham = new SanPham();
                sanPham.setTen(tenSP);
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setIdSP(sanPham + "");

                Imei imei = new Imei();
                imei.setImei(iMei);
                imei.setIdChiTietSP(chiTietSP);
                imei.setTrangThai(trangThai);

                lstIMei.add(imei);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstIMei;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Imei> timTTImei(Integer tt) {
        try {
            List<Imei> lstIMei = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT IMei AS 'IMei', SP.Ten AS 'TenSP', IMei.TrangThai AS 'TrangThai' FROM dbo.IMei JOIN dbo.ChiTietSP CTSP\n"
                    + "ON CTSP.Id = IMei.IdChiTietSP JOIN dbo.SanPham SP\n"
                    + "ON SP.Id = CTSP.IdSP\n"
                    + "WHERE IMei.TrangThai = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String iMei = rs.getString("IMei");
                String tenSP = rs.getString("TenSP");
                int trangThai = rs.getInt("TrangThai");

                SanPham sanPham = new SanPham();
                sanPham.setTen(tenSP);
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setIdSP(sanPham + "");

                Imei imei = new Imei();
                imei.setImei(iMei);
                imei.setIdChiTietSP(chiTietSP);
                imei.setTrangThai(trangThai);

                lstIMei.add(imei);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstIMei;
        } catch (Exception e) {
            return null;
        }
    }
}
