/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.ChiTietSP;
import viewmodel.viewCTSP;
import irepositories.IChiTietSPRepository;
import iservices.IChiTietSPService;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import repositories.ChiTietSPRepository;
import utilities.DBConnection;

/**
 *
 * @author ADMIN
 */
public class ChiTietSPService implements IChiTietSPService {
    

    private final IChiTietSPRepository Repository = new ChiTietSPRepository();

    @Override
    public List<viewCTSP> getAll(Map<String, String> TenSp, Map<String, String> NSX, Map<String, String> MauSac, Map<String, String> DongSp, Map<String, String> CPU, Map<String, String> RAM, Map<String, String> SSD, Map<String, String> ManHinh, Map<String, Integer> BaoHanh) {
        List<ChiTietSP> lst = Repository.getAllCTSP();
        List<viewCTSP> lst1 = new ArrayList<>();
        for (ChiTietSP a : lst) {
            String tenSp = TenSp.get(a.getIdSP());
            String noiSx = NSX.get(a.getIdNSX());
            String mauSac = MauSac.get(a.getIdMauSac());
            String dongSp = DongSp.get(a.getIdDongSP());
            String cpu = CPU.get(a.getIdCPU());
            String ram = RAM.get(a.getIdRam());
            String ssd = SSD.get(a.getIdSSD());
            String manhinh = ManHinh.get(a.getIdManHinh());
            int baohanh = BaoHanh.get(a.getIdBH());
            lst1.add(new viewCTSP(a.getId(), tenSp, noiSx, mauSac, dongSp, cpu, ram, ssd, manhinh, baohanh, a.getCanNang(), a.getMoTa(), a.getSoLuongTon(), a.getGiaNhap(), a.getGiaBan(), a.getNgayTao(), a.getNgaySua(), a.getTrangThai(), a.getNumOrder(), a.getMa()));

        }
        return lst1;
    }
    
    @Override
    public List<ChiTietSP> getList(Map<String, String> TenSp, Map<String, String> NSX, Map<String, String> MauSac, Map<String, String> DongSp, Map<String, String> CPU, Map<String, String> RAM, Map<String, String> SSD, Map<String, String> ManHinh, Map<String, Integer> BaoHanh) {
        List<ChiTietSP> lst = Repository.getAllCTSP();
        List<viewCTSP> lst1 = new ArrayList<>();
        for (ChiTietSP a : lst) {
            String tenSp = TenSp.get(a.getIdSP());
            String noiSx = NSX.get(a.getIdNSX());
            String mauSac = MauSac.get(a.getIdMauSac());
            String dongSp = DongSp.get(a.getIdDongSP());
            String cpu = CPU.get(a.getIdCPU());
            String ram = RAM.get(a.getIdRam());
            String ssd = SSD.get(a.getIdSSD());
            String manhinh = ManHinh.get(a.getIdManHinh());
            int baohanh = BaoHanh.get(a.getIdBH());
            lst1.add(new viewCTSP(a.getId(), tenSp, noiSx, mauSac, dongSp, cpu, ram, ssd, manhinh, baohanh, a.getCanNang(), a.getMoTa(), a.getSoLuongTon(), a.getGiaNhap(), a.getGiaBan(), a.getNgayTao(), a.getNgaySua(), a.getTrangThai(), a.getNumOrder(), a.getMa()));

        }
        return lst;
    }

    @Override
    public Integer them(viewCTSP sp, Map<String, String> TenSp, Map<String, String> NSX, Map<String, String> MauSac, Map<String, String> DongSp, Map<String, String> CPU, Map<String, String> RAM, Map<String, String> SSD, Map<String, String> ManHinh, Map<String, Integer> BaoHanh) {
        Set<String> keyTenSp = TenSp.keySet();
        Set<String> keyNoiSx = NSX.keySet();
        Set<String> keyMauS = MauSac.keySet();
        Set<String> keyDongSp = DongSp.keySet();
        Set<String> keyCpu = CPU.keySet();
        Set<String> keyRam = RAM.keySet();
        Set<String> keySsd = SSD.keySet();
        Set<String> keyManhinh = ManHinh.keySet();
        Set<String> keyBaohanh = BaoHanh.keySet();
        String idSp = "Null";
        String idNSX = "Null";
        String idMauSac = "Null";
        String idDongSp = "Null";
        String idCPU = "Null";
        String idRAM = "Null";
        String idSSD = "Null";
        String idMH = "Null";
        String idBH = "Null";
        for (String a : keyTenSp) {
            if (sp.getTenSP().equalsIgnoreCase(TenSp.get(a))) {
                idSp = a;
            }
        }
        for (String a : keyNoiSx) {
            if (sp.getNSX().equalsIgnoreCase(NSX.get(a))) {
                idNSX = a;
            }
        }
        for (String a : keyMauS) {
            if (sp.getMauSac().equalsIgnoreCase(MauSac.get(a))) {
                idMauSac = a;
            }
        }
        for (String a : keyDongSp) {
            if (sp.getDongSP().equalsIgnoreCase(DongSp.get(a))) {
                idDongSp = a;
            }
        }
        for (String a : keyCpu) {
            if (sp.getCPU().equalsIgnoreCase(CPU.get(a))) {
                idCPU = a;
            }
        }
        for (String a : keyRam) {
            if (sp.getRAM().equalsIgnoreCase(RAM.get(a))) {

                idRAM = a;
            }
        }
        for (String a : keySsd) {
            if (sp.getSSD().equalsIgnoreCase(SSD.get(a))) {
                idSSD = a;
            }
        }
        for (String a : keyManhinh) {
            if (sp.getManHinh().equalsIgnoreCase(ManHinh.get(a))) {
                idMH = a;
            }
        }
        for (String a : keyBaohanh) {
            if (sp.getBaoHanh().equals(BaoHanh.get(a))) {
                idBH = a;
            }
        }
        ChiTietSP CtD = new ChiTietSP(idSp, idNSX, idMauSac, idDongSp, idCPU, idRAM, idSSD, idMH, idBH, sp.getCanNang(), sp.getMoTa(), sp.getSoLuongTon(), sp.getGiaNhap(), sp.getGiaBan(), sp.getNgayTao(), sp.getNgaySua(), sp.getTrangThai());
        return Repository.them(CtD);

    }

    @Override
    public Integer xoa(String ma) {
        return Repository.xoa(ma);
    }

    @Override
    public Map<String, String> hashMapTenSp() {
        return Repository.hashMapTenSp();
    }

    @Override
    public Map<String, String> hashMapNoiSx() {
        return Repository.hashMapNoiSx();
    }

    @Override
    public Map<String, String> hashMapMauSac() {
        return Repository.hashMapMauSac();
    }

    @Override
    public Map<String, String> hashMapDongSp() {
        return Repository.hashMapDongSp();
    }

    @Override
    public Map<String, String> hashMapManHinh() {
        return Repository.hashMapManHinh();
    }

    @Override
    public Map<String, String> hashMapCPU() {
        return Repository.hashMapCPU();
    }

    @Override
    public Map<String, String> hashMapRAM() {
        return Repository.hashMapRAM();
    }

    @Override
    public Map<String, String> hashMapSSD() {
        return Repository.hashMapSSD();
    }

    @Override
    public Map<String, String> hashMapBaoHanh() {
        return Repository.hashMapBaoHanh();
    }

    @Override
    public Map<String, Integer> hashMapBH() {
        return Repository.hashMapBH();
    }

    @Override
    public Integer sua(viewCTSP sp, Map<String, String> TenSp, Map<String, String> NSX, Map<String, String> MauSac, Map<String, String> DongSp, Map<String, String> CPU, Map<String, String> RAM, Map<String, String> SSD, Map<String, String> ManHinh, Map<String, Integer> BaoHanh, String id) {
        Set<String> keyTenSp = TenSp.keySet();
        Set<String> keyNoiSx = NSX.keySet();
        Set<String> keyMauS = MauSac.keySet();
        Set<String> keyDongSp = DongSp.keySet();
        Set<String> keyCpu = CPU.keySet();
        Set<String> keyRam = RAM.keySet();
        Set<String> keySsd = SSD.keySet();
        Set<String> keyManhinh = ManHinh.keySet();
        Set<String> keyBaohanh = BaoHanh.keySet();
        String idSp = "Null";
        String idNSX = "Null";
        String idMauSac = "Null";
        String idDongSp = "Null";
        String idCPU = "Null";
        String idRAM = "Null";
        String idSSD = "Null";
        String idMH = "Null";
        String idBH = "Null";
        for (String a : keyTenSp) {
            if (sp.getTenSP().equalsIgnoreCase(TenSp.get(a))) {
                idSp = a;
            }
        }
        for (String a : keyNoiSx) {
            if (sp.getNSX().equalsIgnoreCase(NSX.get(a))) {
                idNSX = a;
            }
        }
        for (String a : keyMauS) {
            if (sp.getMauSac().equalsIgnoreCase(MauSac.get(a))) {
                idMauSac = a;
            }
        }
        for (String a : keyDongSp) {
            if (sp.getDongSP().equalsIgnoreCase(DongSp.get(a))) {
                idDongSp = a;
            }
        }
        for (String a : keyCpu) {
            if (sp.getCPU().equalsIgnoreCase(CPU.get(a))) {
                idCPU = a;
            }
        }
        for (String a : keyRam) {
            if (sp.getRAM().equalsIgnoreCase(RAM.get(a))) {

                idRAM = a;
            }
        }
        for (String a : keySsd) {
            if (sp.getSSD().equalsIgnoreCase(SSD.get(a))) {
                idSSD = a;
            }
        }
        for (String a : keyManhinh) {
            if (sp.getManHinh().equalsIgnoreCase(ManHinh.get(a))) {
                idMH = a;
            }
        }
        for (String a : keyBaohanh) {
            if (sp.getBaoHanh().equals(BaoHanh.get(a))) {
                idBH = a;
            }
        }
        ChiTietSP CtD = new ChiTietSP(idSp, idNSX, idMauSac, idDongSp, idCPU, idRAM, idSSD, idMH, idBH, sp.getCanNang(), sp.getMoTa(), sp.getSoLuongTon(), sp.getGiaNhap(), sp.getGiaBan(), sp.getNgayTao(), sp.getNgaySua(), sp.getTrangThai());
        return Repository.sua(CtD, id);
    }

    @Override
    public List<ChiTietSP> getAllCTSP() {
        return Repository.getAll();
    }

    @Override
    public List<ChiTietSP> getAllByDongSP(String tenDongSP) {
        return Repository.getAllByDongSP(tenDongSP);
    }

    @Override
    public Integer themCTSP(ChiTietSP chiTietSP) {
        return Repository.them(chiTietSP);
    }

    @Override
    public Integer suaCTSP(ChiTietSP chiTietSP) {
        return Repository.suaCTSP(chiTietSP);
    }

    @Override
    public Integer xoaCTSP(String ma) {
        return Repository.xoa(ma);
    }

    @Override
    public ChiTietSP getIdByMa(String ma) {
        return Repository.getIdByMa(ma);
    }

    @Override
    public Integer updateSoLuong(String soLuong, String ma) {
        return Repository.updateSoLuong(soLuong, ma);
    }

    @Override
    public Integer updateTrangThai(String trangThai, String ma) {
        return Repository.updateTrangThai(trangThai, ma);
    }

    @Override
    public String getMaById(String id) {
        return Repository.getMaById(id);
    }

    @Override
    public Map<String, String> hashMapHoaDon() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer them(ChiTietSP chiTietSP) {
        return null;
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
    public List<viewCTSP> getAllbyDSP(Map<String, String> TenSp, Map<String, String> NSX, Map<String, String> MauSac, Map<String, String> DongSp, Map<String, String> CPU, Map<String, String> RAM, Map<String, String> SSD, Map<String, String> ManHinh, Map<String, Integer> BaoHanh) {
        List<ChiTietSP> lst = Repository.getAllCTSP();
        List<viewCTSP> lst1 = new ArrayList<>();
        for (ChiTietSP a : lst) {
            String tenSp = TenSp.get(a.getIdSP());
            String noiSx = NSX.get(a.getIdNSX());
            String mauSac = MauSac.get(a.getIdMauSac());
            String dongSp = DongSp.get(a.getIdDongSP());
            String cpu = CPU.get(a.getIdCPU());
            String ram = RAM.get(a.getIdRam());
            String ssd = SSD.get(a.getIdSSD());
            String manhinh = ManHinh.get(a.getIdManHinh());
            int baohanh = BaoHanh.get(a.getIdBH());
            lst1.add(new viewCTSP(a.getId(), tenSp, noiSx, mauSac, dongSp, cpu, ram, ssd, manhinh, baohanh, a.getCanNang(), a.getMoTa(), a.getSoLuongTon(), a.getGiaNhap(), a.getGiaBan(), a.getNgayTao(), a.getNgaySua(), a.getTrangThai(), a.getNumOrder(), a.getMa()));

        }
        return lst1;
    }

    @Override
    public List<ChiTietSP> getByDongSP(String tenDongSP) {
        return Repository.getByDongSP(tenDongSP);
    }

    @Override
    public List<ChiTietSP> getAllByRam(String tenRam) {
        return Repository.getAllByRAM(tenRam);
    }

    @Override
    public List<ChiTietSP> getAllBySSD(String tenSSD) {
        return Repository.getAllBySSD(tenSSD);
    }

    @Override
    public List<ChiTietSP> getAllByCPU(String tenCPU) {
        return Repository.getAllByCPU(tenCPU);
    }

    @Override
    public List<ChiTietSP> getAllByIdCTSP(String id) {
        return Repository.getAllByIdCTSP(id);
    }

    @Override
    public Integer doiTrangThai(String trangThai1, String trangThai2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
