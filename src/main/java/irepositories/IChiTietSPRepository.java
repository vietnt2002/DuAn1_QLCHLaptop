/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepositories;

import domainmodels.CPU;
import domainmodels.ChiTietSP;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface IChiTietSPRepository {
    List<ChiTietSP> getAll();
    List<ChiTietSP> getAllByDongSP(String tenDongSP);
    List<ChiTietSP> getByDongSP(String tenDongSP);
    Integer them(ChiTietSP chiTietSP);
    Integer themCTSP(ChiTietSP chiTietSP);
    Integer sua(ChiTietSP chiTietSP);
    Integer suaCTSP(ChiTietSP chiTietSP);
    Integer xoa(String ma);
    ChiTietSP getIdByMa(String ma);
    String getIdByTen(String ten);
    String getIdByMau(String mau);
    String getIdByDong(String dong);
    String getIdByMH(String mh);
    String getIdByCPU(String cpu);
    String getIdByRAM(String ram);
    String getIdBySSD(String ssd);
    String getIdByBH(String bh);
    String getMaById(String id);
    Integer updateSoLuong(String soLuong, String ma);
    Integer updateTrangThai(String trangThai, String ma);
    Integer sua(ChiTietSP sp,String id);
    List<ChiTietSP> getAllCTSP();
    List<ChiTietSP> getAllCTSPbyDong(String tenDSP);
    Map<String, String> hashMapTenSp();
    Map<String, String> hashMapNoiSx();
    Map<String, String> hashMapMauSac();
    Map<String, String> hashMapDongSp();
    Map<String, String> hashMapManHinh();
    Map<String, String> hashMapCPU();
    Map<String, String> hashMapRAM();
    Map<String, String> hashMapSSD();
    Map<String, String> hashMapBaoHanh();
    Map<String, Integer> hashMapBH();
}
