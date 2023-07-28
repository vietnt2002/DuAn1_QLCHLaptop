/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import irepositories.IChiTietSPRepository;
import java.math.BigDecimal;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilities.DBConnection;
import irepositories.IDongSPRepository;
import irepositories.IManHinhRepository;
import irepositories.IMauSacRepository;
import irepositories.ICPURepository;
import irepositories.IRAMRepository;
import irepositories.INSXRepository;
import irepositories.ISSDRepository;
import irepositories.ISanPhamRepository;
import irepositories.IBaoHanhRepository;
import domainmodels.ChiTietSP;
import domainmodels.DongSP;
import domainmodels.ManHinh;
import domainmodels.MauSac;
import domainmodels.CPU;
import domainmodels.RAM;
import domainmodels.NSX;
import domainmodels.SSD;
import domainmodels.SanPham;
import domainmodels.ChiTietHD;
import domainmodels.BaoHanh;
import irepositories.IChiTietHDRepository;
import java.math.BigDecimal;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import utilities.ULHelper;

/**
 *
 * @author ADMIN
 */
public class ChiTietSPRepository implements IChiTietSPRepository {

    private final IDongSPRepository RepositoryDongSp = new DongSPRepository();
    private final IMauSacRepository RepositoryMau = new MauSacRepository();
    private final IManHinhRepository RepositoryMH = new ManHinhRepository();
    private final ICPURepository RepositoryCPU = new CPURepository();
    private final IRAMRepository RepositoryRAM = new RAMRepository();
    private final ISSDRepository RepositorySSD = new SSDRepository();
    private final INSXRepository RepositoryNoiSx = new NSXRepository();
    private final IBaoHanhRepository RepositoryBaoHanh = new BaoHanhRepository();
    private final ISanPhamRepository RepositoryTenSp = new SanPhamRepository();
    private final IChiTietHDRepository RepositoryHoaDon = new ChiTietHDRepository();
    private final Connection con = DBConnection.getConnection();

    @Override
    public List<ChiTietSP> getAll() {
        try {
            List<ChiTietSP> lstChiTietSP = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT CTSP.Id AS 'Id', CTSP.Ma AS 'Ma', SP.Id AS 'IdSP', SP.Ma AS 'MaSP', SP.Ten AS 'TenSP', DSP.Id AS 'IdDongSP', DSP.Ten AS 'TenDongSP', NSX.Id AS 'IdNSX', NSX.Ten AS 'TenNSX', QuocGia AS 'QuocGia', MS.Id AS 'IdMauSac', MS.Ten AS 'MauSac',\n"
                    + "RAM.Id AS 'IdRAM', RAM.Ten AS 'RAM', SSD.Id AS 'IdSSD', SSD.Ten AS 'SSD', CPU.Id AS 'IdCPU', CPU.Ten AS 'CPU', MH.Id AS 'IdMH', MH.DoPhanGiai AS 'DoPhanGiai', MH.Inch AS 'Inch', CTSP.GiaBan AS 'GiaBan', BH.Id AS 'IdBH', BH.SoThangBH AS 'BaoHanh', CTSP.SoLuongTon AS 'SoLuong', CTSP.TrangThai AS 'TrangThai'\n"
                    + "FROM dbo.ChiTietSP CTSP JOIN dbo.SanPham SP\n"
                    + "ON SP.Id = CTSP.IdSP JOIN dbo.RAM \n"
                    + "ON RAM.Id = CTSP.IdRAM JOIN dbo.SSD\n"
                    + "ON SSD.Id = CTSP.IdSSD JOIN dbo.MauSac MS\n"
                    + "ON MS.Id = CTSP.IdMauSac JOIN dbo.CPU\n"
                    + "ON CPU.Id = CTSP.IdCPU JOIN dbo.ManHinh MH\n"
                    + "ON MH.Id = CTSP.IdManHinh JOIN dbo.BaoHanh BH\n"
                    + "ON BH.Id = CTSP.IdBH JOIN dbo.DongSP DSP\n"
                    + "ON DSP.Id = CTSP.IdDongSP JOIN dbo.NSX\n"
                    + "ON NSX.Id = CTSP.IdNSX";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String idSP = rs.getString("IdSP");
                String maSP = rs.getString("MaSP");
                String tenSP = rs.getString("TenSP");
                String idDongSP = rs.getString("IdDongSP");
                String tenDongSP = rs.getString("TenDongSP");
                String idNSX = rs.getString("IdNSX");
                String tenNSX = rs.getString("TenNSX");
                String quocGia = rs.getString("QuocGia");
                String idMauSac = rs.getString("IdMauSac");
                String tenMauSac = rs.getString("MauSac");
                String idRAM = rs.getString("IdRAM");
                String tenRam = rs.getString("RAM");
                String idSSD = rs.getString("IdSSD");
                String tenSsd = rs.getString("SSD");
                String idCPU = rs.getString("IdCPU");
                String tenCpu = rs.getString("CPU");
                String idMH = rs.getString("IdMH");
                String doPhanGiai = rs.getString("DoPhanGiai");
                float inch = rs.getFloat("Inch");
                BigDecimal giaBan = rs.getBigDecimal("GiaBan");
                String idBH = rs.getString("IdBH");
                int soThangBH = rs.getInt("BaoHanh");
                int soLuong = rs.getInt("SoLuong");
                int trangThai = rs.getInt("TrangThai");

                SanPham sanPham = new SanPham();
                sanPham.setId(idSP);
                sanPham.setMa(maSP);
                sanPham.setTen(tenSP);
                DongSP dongSP = new DongSP();
                dongSP.setId(idDongSP);
                dongSP.setTen(tenDongSP);
                NSX nsx = new NSX();
                nsx.setId(idNSX);
                nsx.setTen(tenNSX);
                nsx.setQuocGia(quocGia);
                MauSac mauSac = new MauSac();
                mauSac.setId(idMauSac);
                mauSac.setTen(tenMauSac);
                RAM ram = new RAM();
                ram.setId(idRAM);
                ram.setTen(tenRam);
                SSD ssd = new SSD();
                ssd.setId(idSSD);
                ssd.setTen(tenSsd);
                CPU cpu = new CPU();
                cpu.setId(idCPU);
                cpu.setTen(tenCpu);
                ManHinh manHinh = new ManHinh();
                manHinh.setId(idMH);
                manHinh.setDoPhanGiai(doPhanGiai);
                manHinh.setInch(inch);
                BaoHanh baoHanh = new BaoHanh();
                baoHanh.setId(idBH);
                baoHanh.setSoThangBH(soThangBH);

                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setId(id);
                chiTietSP.setMa(ma);
                chiTietSP.setIdSP(sanPham + "");
                chiTietSP.setIdDongSP(dongSP + "");
                chiTietSP.setIdNSX(nsx + "");
                chiTietSP.setIdMauSac(mauSac + "");
                chiTietSP.setIdRam(ram + "");
                chiTietSP.setIdSSD(ssd + "");
                chiTietSP.setIdCPU(cpu + "");
                chiTietSP.setIdManHinh(manHinh + "");
                chiTietSP.setIdBH(baoHanh + "");
                chiTietSP.setGiaBan(giaBan);
                chiTietSP.setSoLuongTon(soLuong);
                chiTietSP.setTrangThai(trangThai);

                lstChiTietSP.add(chiTietSP);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstChiTietSP;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<ChiTietSP> getAllByDongSP(String tenDSP) {
        try {
            List<ChiTietSP> lstChiTietSP = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT CTSP.Id AS 'Id', CTSP.Ma AS 'Ma', SP.Id AS 'IdSP', SP.Ma AS 'MaSP', SP.Ten AS 'TenSP', DSP.Id AS 'IdDongSP', DSP.Ten AS 'TenDongSP', NSX.Id AS 'IdNSX', NSX.Ten AS 'TenNSX', QuocGia AS 'QuocGia', MS.Id AS 'IdMauSac', MS.Ten AS 'MauSac', \n"
                    + "RAM.Id AS 'IdRAM', RAM.Ten AS 'RAM', SSD.Id AS 'IdSSD', SSD.Ten AS 'SSD', CPU.Id AS 'IdCPU', CPU.Ten AS 'CPU', MH.Id AS 'IdMH', MH.DoPhanGiai AS 'DoPhanGiai', MH.Inch AS 'Inch', CTSP.GiaBan AS 'GiaBan', BH.Id AS 'IdBH', BH.SoThangBH AS 'BaoHanh', CTSP.SoLuongTon AS 'SoLuong', CTSP.TrangThai AS 'TrangThai'\n"
                    + "FROM dbo.ChiTietSP CTSP JOIN dbo.SanPham SP\n"
                    + "ON SP.Id = CTSP.IdSP JOIN dbo.RAM \n"
                    + "ON RAM.Id = CTSP.IdRAM JOIN dbo.SSD\n"
                    + "ON SSD.Id = CTSP.IdSSD JOIN dbo.MauSac MS\n"
                    + "ON MS.Id = CTSP.IdMauSac JOIN dbo.CPU\n"
                    + "ON CPU.Id = CTSP.IdCPU JOIN dbo.ManHinh MH\n"
                    + "ON MH.Id = CTSP.IdManHinh JOIN dbo.BaoHanh BH\n"
                    + "ON BH.Id = CTSP.IdBH JOIN dbo.DongSP DSP\n"
                    + "ON DSP.Id = CTSP.IdDongSP JOIN dbo.NSX\n"
                    + "ON NSX.Id = CTSP.IdNSX\n"
                    + "WHERE DSP.Ten = ?\n";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tenDSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String idSP = rs.getString("IdSP");
                String maSP = rs.getString("MaSP");
                String tenSP = rs.getString("TenSP");
                String idDongSP = rs.getString("IdDongSP");
                String tenDongSP = rs.getString("TenDongSP");
                String idNSX = rs.getString("IdNSX");
                String tenNSX = rs.getString("TenNSX");
                String quocGia = rs.getString("QuocGia");
                String idMauSac = rs.getString("IdMauSac");
                String tenMauSac = rs.getString("MauSac");
                String idRAM = rs.getString("IdRAM");
                String tenRam = rs.getString("RAM");
                String idSSD = rs.getString("IdSSD");
                String tenSsd = rs.getString("SSD");
                String idCPU = rs.getString("IdCPU");
                String tenCpu = rs.getString("CPU");
                String idMH = rs.getString("IdMH");
                String doPhanGiai = rs.getString("DoPhanGiai");
                float inch = rs.getFloat("Inch");
                BigDecimal giaBan = rs.getBigDecimal("GiaBan");
                String idBH = rs.getString("IdBH");
                int soThangBH = rs.getInt("BaoHanh");
                int soLuong = rs.getInt("SoLuong");
                int trangThai = rs.getInt("TrangThai");

                SanPham sanPham = new SanPham();
                sanPham.setId(idSP);
                sanPham.setMa(maSP);
                sanPham.setTen(tenSP);
                DongSP dongSP = new DongSP();
                dongSP.setId(idDongSP);
                dongSP.setTen(tenDongSP);
                NSX nsx = new NSX();
                nsx.setId(idNSX);
                nsx.setTen(tenNSX);
                nsx.setQuocGia(quocGia);
                MauSac mauSac = new MauSac();
                mauSac.setId(idMauSac);
                mauSac.setTen(tenMauSac);
                RAM ram = new RAM();
                ram.setId(idRAM);
                ram.setTen(tenRam);
                SSD ssd = new SSD();
                ssd.setId(idSSD);
                ssd.setTen(tenSsd);
                CPU cpu = new CPU();
                cpu.setId(idCPU);
                cpu.setTen(tenCpu);
                ManHinh manHinh = new ManHinh();
                manHinh.setId(idMH);
                manHinh.setDoPhanGiai(doPhanGiai);
                manHinh.setInch(inch);
                BaoHanh baoHanh = new BaoHanh();
                baoHanh.setId(idBH);
                baoHanh.setSoThangBH(soThangBH);

                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setId(id);
                chiTietSP.setMa(ma);
                chiTietSP.setIdSP(sanPham + "");
                chiTietSP.setIdDongSP(dongSP + "");
                chiTietSP.setIdNSX(nsx + "");
                chiTietSP.setIdMauSac(mauSac + "");
                chiTietSP.setIdRam(ram + "");
                chiTietSP.setIdSSD(ssd + "");
                chiTietSP.setIdCPU(cpu + "");
                chiTietSP.setIdManHinh(manHinh + "");
                chiTietSP.setIdBH(baoHanh + "");
                chiTietSP.setGiaBan(giaBan);
                chiTietSP.setSoLuongTon(soLuong);
                chiTietSP.setTrangThai(trangThai);

                lstChiTietSP.add(chiTietSP);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstChiTietSP;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer them(ChiTietSP sp) {
        try {
            String lenh = "insert into [dbo].[ChiTietSP](IdSP,IdNsx,IdMauSac,IdDongSP,idCPU,idRam,idSSD,idManHinh,idBH," + ""
                    + "canNang,moTa,SoLuongTon,GiaNhap,GiaBan,ngayTao,ngaySua,trangThai) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(lenh);
            if (sp.getIdSP().equalsIgnoreCase("null")) {
                st.setString(1, null);
            } else {
                st.setString(1, sp.getIdSP());
            }
            if (sp.getIdNSX().equalsIgnoreCase("null")) {
                st.setString(2, null);
            } else {
                st.setString(2, sp.getIdNSX());
            }
            if (sp.getIdMauSac().equalsIgnoreCase("null")) {
                st.setString(3, null);
            } else {
                st.setString(3, sp.getIdMauSac());
            }
            if (sp.getIdDongSP().equalsIgnoreCase("null")) {
                st.setString(4, null);
            } else {
                st.setString(4, sp.getIdDongSP());
            }
            if (sp.getIdCPU().equalsIgnoreCase("null")) {
                st.setString(5, null);
            } else {
                st.setString(5, sp.getIdCPU());
            }
            if (sp.getIdRam().equalsIgnoreCase("null")) {
                st.setString(6, null);
            } else {
                st.setString(6, sp.getIdRam());
            }
            if (sp.getIdSSD().equalsIgnoreCase("null")) {
                st.setString(7, null);
            } else {
                st.setString(7, sp.getIdSSD());
            }
            if (sp.getIdManHinh().equalsIgnoreCase("null")) {
                st.setString(8, null);
            } else {
                st.setString(8, sp.getIdManHinh());
            }
            if (sp.getIdBH().equalsIgnoreCase("null")) {
                st.setString(9, null);
            } else {
                st.setString(9, sp.getIdBH());
            }
            st.setDouble(10, sp.getCanNang());
            st.setString(11, sp.getMoTa());
            st.setInt(12, sp.getSoLuongTon());
            st.setBigDecimal(13, sp.getGiaNhap());
            st.setBigDecimal(14, sp.getGiaBan());
            st.setDate(15, sp.getNgayTao());
            st.setDate(16, sp.getNgaySua());
            st.setInt(17, sp.getTrangThai());

            return st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer sua(ChiTietSP sp, String id) {
        try {
            java.util.UUID idCt = UUID.fromString(id);
            String lenh = "update ChiTietSP set IdSP=?,IdNsx=?,IdMauSac=?,IdDongSP=?,idCPU=?,idRam=?,idSSD=?,idManHinh=?,idBH=?,"
                    + "CanNang=?,MoTa=?,SoLuongTon=?,GiaNhap=?,GiaBan=?,ngayTao=?,ngaySua=?,trangThai=? where id=?";
            PreparedStatement st = con.prepareStatement(lenh);
            if (sp.getIdSP().equalsIgnoreCase("null")) {
                st.setString(1, null);
            } else {
                st.setString(1, sp.getIdSP());
            }
            if (sp.getIdNSX().equalsIgnoreCase("null")) {
                st.setString(2, null);
            } else {
                st.setString(2, sp.getIdNSX());
            }
            if (sp.getIdMauSac().equalsIgnoreCase("null")) {
                st.setString(3, null);
            } else {
                st.setString(3, sp.getIdMauSac());
            }
            if (sp.getIdDongSP().equalsIgnoreCase("null")) {
                st.setString(4, null);
            } else {
                st.setString(4, sp.getIdDongSP());
            }
            if (sp.getIdCPU().equalsIgnoreCase("null")) {
                st.setString(5, null);
            } else {
                st.setString(5, sp.getIdCPU());
            }
            if (sp.getIdRam().equalsIgnoreCase("null")) {
                st.setString(6, null);
            } else {
                st.setString(6, sp.getIdRam());
            }
            if (sp.getIdSSD().equalsIgnoreCase("null")) {
                st.setString(7, null);
            } else {
                st.setString(7, sp.getIdSSD());
            }
            if (sp.getIdManHinh().equalsIgnoreCase("null")) {
                st.setString(8, null);
            } else {
                st.setString(8, sp.getIdManHinh());
            }
            if (sp.getIdBH().equalsIgnoreCase("null")) {
                st.setString(9, null);
            } else {
                st.setString(9, sp.getIdBH());
            }
            st.setDouble(10, sp.getCanNang());
            st.setString(11, sp.getMoTa());
            st.setInt(12, sp.getSoLuongTon());
            st.setBigDecimal(13, sp.getGiaNhap());
            st.setBigDecimal(14, sp.getGiaBan());
            st.setDate(15, sp.getNgayTao());
            st.setDate(16, sp.getNgaySua());
            st.setInt(17, sp.getTrangThai());
            st.setObject(18, idCt);

            return st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer xoa(String ma) {
        try {
            java.util.UUID id = UUID.fromString(ma);
            String lenh = "delete from chitietsp where id =?";
            PreparedStatement st = con.prepareStatement(lenh);
            st.setObject(1, id);
            return st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;

    }

    @Override
    public Map<String, String> hashMapTenSp() {
        Map<String, String> tenSp = new HashMap<>();
        List<SanPham> lst = RepositoryTenSp.getAll();
        for (SanPham a : lst) {
            tenSp.put(a.getId(), a.getTen());
        }
        return tenSp;
    }

    @Override
    public Map<String, String> hashMapNoiSx() {
        Map<String, String> noiSx = new HashMap<>();
        List<NSX> lst = RepositoryNoiSx.getAll();
        for (NSX a : lst) {
            noiSx.put(a.getId(), a.getTen());
        }
        return noiSx;
    }

    @Override
    public Map<String, String> hashMapMauSac() {
        Map<String, String> mauSac = new HashMap<>();
        List<MauSac> lst = RepositoryMau.getAll();
        for (MauSac a : lst) {
            mauSac.put(a.getId(), a.getTen());
        }
        return mauSac;
    }

    @Override
    public Map<String, String> hashMapDongSp() {

        Map<String, String> dongSp = new HashMap<>();
        List<DongSP> lst = RepositoryDongSp.getAll();
        for (DongSP a : lst) {
            dongSp.put(a.getId(), a.getTen());
        }
        return dongSp;
    }

    @Override
    public Map<String, String> hashMapManHinh() {
        Map<String, String> manhinh = new HashMap<>();
        List<ManHinh> lst = RepositoryMH.getAll();
        for (ManHinh a : lst) {
            manhinh.put(a.getId(), a.getDoPhanGiai());
        }
        return manhinh;
    }

    @Override
    public Map<String, String> hashMapCPU() {
        Map<String, String> cpu = new HashMap<>();
        List<CPU> lst = RepositoryCPU.getAll();
        for (CPU a : lst) {
            cpu.put(a.getId(), a.getTen());
        }
        return cpu;
    }

    @Override
    public Map<String, String> hashMapRAM() {
        Map<String, String> ram = new HashMap<>();
        List<RAM> lst = RepositoryRAM.getAll();
        for (RAM a : lst) {
            ram.put(a.getId(), a.getTen());
        }
        return ram;
    }

    @Override
    public Map<String, String> hashMapSSD() {
        Map<String, String> ssd = new HashMap<>();
        List<SSD> lst = RepositorySSD.getAll();
        for (SSD a : lst) {
            ssd.put(a.getId(), a.getTen());
        }
        return ssd;
    }

    @Override
    public Map<String, String> hashMapBaoHanh() {
        Map<String, String> bh = new HashMap<>();
        List<BaoHanh> lst = RepositoryBaoHanh.getAll();
        for (BaoHanh a : lst) {
            bh.put(a.getId(), a.getMa());
        }
        return bh;
    }

    @Override
    public Map<String, Integer> hashMapBH() {
        Map<String, Integer> tbh = new HashMap<>();
        List<BaoHanh> lst = RepositoryBaoHanh.getAll();
        for (BaoHanh a : lst) {
            tbh.put(a.getId(), a.getSoThangBH());
        }
        return tbh;
    }

    public Map<String, String> hashMapHoaDon() {
        Map<String, String> bh = new HashMap<>();
        List<ChiTietHD> lst = RepositoryHoaDon.getAll();
        for (ChiTietHD a : lst) {
            bh.put(a.getId(), a.getIdHD());
        }
        return bh;
    }

    @Override
    public ChiTietSP getIdByMa(String ma) {
        try {
            ChiTietSP chiTietSP = new ChiTietSP();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT Id FROM dbo.ChiTietSP WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                chiTietSP.setId(id);
            }
            return chiTietSP;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Integer suaCTSP(ChiTietSP chiTietSP) {
        try {
            Integer result = 0;

            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<ChiTietSP> getAllCTSP() {
        try {
            Connection con = DBConnection.getConnection();
            List<ChiTietSP> lst = new ArrayList<>();
            String lenh = "select id,IdSP,IdNsx,IdMauSac,IdDongSP,idCPU,idRam,idSSD,idManHinh,idBH,CanNang,MoTa,SoLuongTon,GiaNhap,GiaBan,ngayTao,ngaySua,trangThai,numOrder,ma from ChiTietSP order by numOrder ASC";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(lenh);
            while (rs.next()) {
                lst.add(new ChiTietSP(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDouble(11),
                        rs.getString(12),
                        rs.getInt(13),
                        rs.getBigDecimal(14),
                        rs.getBigDecimal(15),
                        rs.getDate(16),
                        rs.getDate(17),
                        rs.getInt(18),
                        rs.getInt(19),
                        rs.getString(20)));
            }
            rs.close();
            st.close();
            con.close();
            return lst;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public String getMaById(String id) {
        try {
            String ma = null;
            ChiTietSP chiTietSP = new ChiTietSP();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT Ma FROM dbo.ChiTietSP WHERE Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ma = rs.getString("Ma");
                chiTietSP.setMa(ma);
            }
            return ma;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer updateSoLuong(String soLuong, String ma) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "UPDATE dbo.ChiTietSP SET SoLuongTon = SoLuongTon - ? WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, soLuong);
            ps.setString(2, ma);

            result = ps.executeUpdate();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Integer updateTrangThai(String trangThai, String ma) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "UPDATE dbo.ChiTietSP SET TrangThai = ? WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, trangThai);
            ps.setString(2, ma);

            result = ps.executeUpdate();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Integer themCTSP(ChiTietSP chiTietSP) {
        try {
            Integer result = 0;
            Connection connection = DBConnection.getConnection();
            String sql = "insert into ChiTietSP(IdSP,IdNsx,IdMauSac,IdDongSP,idCPU,idRam,idSSD,idManHinh,idBH,canNang,moTa,SoLuongTon,GiaNhap,GiaBan,ngayTao,ngaySua,trangThai) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, chiTietSP.getIdSP());
            st.setString(2, chiTietSP.getIdNSX());
            st.setString(3, chiTietSP.getIdMauSac());
            st.setString(4, chiTietSP.getIdDongSP());
            st.setString(5, chiTietSP.getIdCPU());
            st.setString(6, chiTietSP.getIdRam());
            st.setString(7, chiTietSP.getIdSSD());
            st.setString(8, chiTietSP.getIdManHinh());
            st.setString(9, chiTietSP.getIdBH());
            st.setDouble(10, chiTietSP.getCanNang());
            st.setString(11, chiTietSP.getMoTa());
            st.setInt(12, chiTietSP.getSoLuongTon());
            st.setBigDecimal(13, chiTietSP.getGiaNhap());
            st.setBigDecimal(14, chiTietSP.getGiaBan());
            st.setDate(15, chiTietSP.getNgayTao());
            st.setDate(16, chiTietSP.getNgaySua());
            st.setInt(17, chiTietSP.getTrangThai());
            result = st.executeUpdate();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Integer sua(ChiTietSP chiTietSP) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getIdByTen(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getIdByMau(String mau) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getIdByDong(String dong) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getIdByMH(String mh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getIdByCPU(String cpu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getIdByRAM(String ram) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getIdBySSD(String ssd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getIdByBH(String bh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietSP> getAllCTSPbyDong(String tenDSP) {
        try {
            Connection con = DBConnection.getConnection();
            List<ChiTietSP> lst = new ArrayList<>();
            String lenh = "select id,IdSP,IdNsx,IdMauSac,IdDongSP,idCPU,idRam,idSSD,idManHinh,idBH,CanNang,MoTa,SoLuongTon,GiaNhap,GiaBan,ngayTao,ngaySua,trangThai,numOrder,ma from ChiTietSP where dongSP = ? and trangThai = 1 order by numOrder ASC";
            PreparedStatement ps = con.prepareStatement(lenh);
            ps.setString(1, tenDSP);
            ResultSet rs = ps.executeQuery(lenh);
            while (rs.next()) {
                lst.add(new ChiTietSP(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDouble(11),
                        rs.getString(12),
                        rs.getInt(13),
                        rs.getBigDecimal(14),
                        rs.getBigDecimal(15),
                        rs.getDate(16),
                        rs.getDate(17),
                        rs.getInt(18),
                        rs.getInt(19),
                        rs.getString(20)));
            }
            rs.close();
            ps.close();
            con.close();
            return lst;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<ChiTietSP> getByDongSP(String tenDSP) {
        try {
            List<ChiTietSP> lstChiTietSP = new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT CTSP.Id AS 'Id', CTSP.Ma AS 'Ma', SP.Id AS 'IdSP', SP.Ma AS 'MaSP', SP.Ten AS 'TenSP', DSP.Id AS 'IdDongSP', DSP.Ten AS 'TenDongSP', NSX.Id AS 'IdNSX', NSX.Ten AS 'TenNSX', QuocGia AS 'QuocGia', MS.Id AS 'IdMauSac', MS.Ten AS 'MauSac', \n"
                    + "RAM.Id AS 'IdRAM', RAM.Ten AS 'RAM', SSD.Id AS 'IdSSD', SSD.Ten AS 'SSD', CPU.Id AS 'IdCPU', CPU.Ten AS 'CPU', MH.Id AS 'IdMH', MH.DoPhanGiai AS 'DoPhanGiai', MH.Inch AS 'Inch', CTSP.GiaNhap AS 'GiaNhap', CTSP.GiaBan AS 'GiaBan', BH.Id AS 'IdBH', BH.Ma AS 'BaoHanh', CTSP.SoLuongTon AS 'SoLuong', CTSP.CanNang AS 'CanNang', CTSP.MoTa AS 'MoTa', CTSP.NgayTao AS 'NgayTao' ,CTSP.NgaySua AS 'NgaySua' , CTSP.TrangThai AS 'TrangThai'\n"
                    + "FROM dbo.ChiTietSP CTSP JOIN dbo.SanPham SP\n"
                    + "ON SP.Id = CTSP.IdSP JOIN dbo.RAM \n"
                    + "ON RAM.Id = CTSP.IdRAM JOIN dbo.SSD\n"
                    + "ON SSD.Id = CTSP.IdSSD JOIN dbo.MauSac MS\n"
                    + "ON MS.Id = CTSP.IdMauSac JOIN dbo.CPU\n"
                    + "ON CPU.Id = CTSP.IdCPU JOIN dbo.ManHinh MH\n"
                    + "ON MH.Id = CTSP.IdManHinh JOIN dbo.BaoHanh BH\n"
                    + "ON BH.Id = CTSP.IdBH JOIN dbo.DongSP DSP\n"
                    + "ON DSP.Id = CTSP.IdDongSP JOIN dbo.NSX\n"
                    + "ON NSX.Id = CTSP.IdNSX\n"
                    + "WHERE DSP.Ten = ?\n";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tenDSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String idSP = rs.getString("IdSP");
                String maSP = rs.getString("MaSP");
                String tenSP = rs.getString("TenSP");
                String idDongSP = rs.getString("IdDongSP");
                String tenDongSP = rs.getString("TenDongSP");
                String idNSX = rs.getString("IdNSX");
                String tenNSX = rs.getString("TenNSX");
                String quocGia = rs.getString("QuocGia");
                String idMauSac = rs.getString("IdMauSac");
                String tenMauSac = rs.getString("MauSac");
                String idRAM = rs.getString("IdRAM");
                String tenRam = rs.getString("RAM");
                String idSSD = rs.getString("IdSSD");
                String tenSsd = rs.getString("SSD");
                String idCPU = rs.getString("IdCPU");
                String tenCpu = rs.getString("CPU");
                String idMH = rs.getString("IdMH");
                String doPhanGiai = rs.getString("DoPhanGiai");
                float inch = rs.getFloat("Inch");
                BigDecimal giaNhap = rs.getBigDecimal("GiaNhap");
                BigDecimal giaBan = rs.getBigDecimal("GiaBan");
                String idBH = rs.getString("IdBH");
                String maBH = rs.getString("BaoHanh");
                int soLuong = rs.getInt("SoLuong");
                double canNang = rs.getDouble("SoLuong");
                String moTa = rs.getString("MoTa");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngaySua = rs.getDate("NgaySua");
                int trangThai = rs.getInt("TrangThai");

                SanPham sanPham = new SanPham();
                sanPham.setId(idSP);
                sanPham.setMa(maSP);
                sanPham.setTen(tenSP);
                DongSP dongSP = new DongSP();
                dongSP.setId(idDongSP);
                dongSP.setTen(tenDongSP);
                NSX nsx = new NSX();
                nsx.setId(idNSX);
                nsx.setTen(tenNSX);
                nsx.setQuocGia(quocGia);
                MauSac mauSac = new MauSac();
                mauSac.setId(idMauSac);
                mauSac.setTen(tenMauSac);
                RAM ram = new RAM();
                ram.setId(idRAM);
                ram.setTen(tenRam);
                SSD ssd = new SSD();
                ssd.setId(idSSD);
                ssd.setTen(tenSsd);
                CPU cpu = new CPU();
                cpu.setId(idCPU);
                cpu.setTen(tenCpu);
                ManHinh manHinh = new ManHinh();
                manHinh.setId(idMH);
                manHinh.setDoPhanGiai(doPhanGiai);
                manHinh.setInch(inch);
                BaoHanh baoHanh = new BaoHanh();
                baoHanh.setId(idBH);
                baoHanh.setMa(maBH);

                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setId(id);
                chiTietSP.setMa(ma);
                chiTietSP.setIdSP(sanPham + "");
                chiTietSP.setIdDongSP(dongSP + "");
                chiTietSP.setIdNSX(nsx + "");
                chiTietSP.setIdMauSac(mauSac + "");
                chiTietSP.setIdRam(ram + "");
                chiTietSP.setIdSSD(ssd + "");
                chiTietSP.setIdCPU(cpu + "");
                chiTietSP.setIdManHinh(manHinh + "");
                chiTietSP.setIdBH(baoHanh + "");
                chiTietSP.setGiaNhap(giaNhap);
                chiTietSP.setGiaBan(giaBan);
                chiTietSP.setSoLuongTon(soLuong);
                chiTietSP.setCanNang(canNang);
                chiTietSP.setMoTa(moTa);
                chiTietSP.setNgayTao(ngayTao);
                chiTietSP.setNgaySua(ngaySua);
                chiTietSP.setTrangThai(trangThai);

                lstChiTietSP.add(chiTietSP);
            }
            rs.close();
            ps.close();
            connection.close();
            return lstChiTietSP;
        } catch (Exception e) {
            return null;
        }
    }

}
