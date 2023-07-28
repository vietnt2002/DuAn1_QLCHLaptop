/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

import domainmodels.ChiTietSP;
import viewmodel.viewCTSP;
import irepositories.*;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface IChiTietSPService {
    List<ChiTietSP> getAllCTSP();
    List<ChiTietSP> getAllByDongSP(String tenDongSP);
    List<ChiTietSP> getByDongSP(String tenDongSP);
    Integer themCTSP(ChiTietSP chiTietSP);
    Integer suaCTSP(ChiTietSP chiTietSP);
    Integer them(ChiTietSP chiTietSP);
    Integer sua(ChiTietSP chiTietSP);
    Integer xoaCTSP(String ma);
    Integer updateSoLuong(String soLuong, String ma);
    Integer updateTrangThai(String trangThai, String ma);
    String getMaById(String id);
    ChiTietSP getIdByMa(String ma);
    String getIdByTen(String ten);
    String getIdByMau(String mau);
    String getIdByDong(String dong);
    String getIdByMH(String mh);
    String getIdByCPU(String cpu);
    String getIdByRAM(String ram);
    String getIdBySSD(String ssd);
    String getIdByBH(String bh);
    List<viewCTSP> getAll(Map<String, String> TenSp,
         Map<String, String> NSX, Map<String, String> MauSac ,
         Map<String, String> DongSp, Map<String, String> CPU, Map<String, String> RAM, Map<String, String> SSD, Map<String, String> ManHinh, Map<String, String> BaoHanh);
    List<viewCTSP> getAllbyDSP(Map<String, String> TenSp,
         Map<String, String> NSX, Map<String, String> MauSac ,
         Map<String, String> DongSp, Map<String, String> CPU, Map<String, String> RAM, Map<String, String> SSD, Map<String, String> ManHinh, Map<String, String> BaoHanh);
    Integer them(viewCTSP sp, Map<String, String> TenSp,
         Map<String, String> NSX, Map<String, String> MauSac ,
         Map<String, String> DongSp, Map<String, String> CPU, Map<String, String> RAM, Map<String, String> SSD, Map<String, String> ManHinh, Map<String, String> BaoHanh);
    Integer sua(viewCTSP sp,Map<String, String> TenSp,
         Map<String, String> NSX, Map<String, String> MauSac ,
         Map<String, String> DongSp, Map<String, String> CPU, Map<String, String> RAM, Map<String, String> SSD, Map<String, String> ManHinh, Map<String, String> BaoHanh, String id);
    Integer xoa(String ma);
    Map<String, String> hashMapTenSp();
    Map<String, String> hashMapNoiSx();
    Map<String, String> hashMapMauSac();
    Map<String, String> hashMapDongSp();
    Map<String, String> hashMapManHinh();
    Map<String, String> hashMapCPU();
    Map<String, String> hashMapRAM();
    Map<String, String> hashMapSSD();
    Map<String, String> hashMapBaoHanh();
    Map<String, String> hashMapHoaDon();
    Map<String, Integer> hashMapBH();

}
