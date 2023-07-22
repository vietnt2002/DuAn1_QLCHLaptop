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
    Integer them(ChiTietSP chiTietSP);
    Integer suaCTSP(ChiTietSP chiTietSP);
    Integer xoa(String ma);
    ChiTietSP getIdByMa(String ma);
    String getMaById(String id);
    Integer updateSoLuong(String soLuong, String ma);
    Integer updateTrangThai(String trangThai, String ma);
    
    Integer sua(ChiTietSP sp,String id);
    List<ChiTietSP> getAllCTSP();
    Map<String, String> hashMapTenSp();
    Map<String, String> hashMapNoiSx();
    Map<String, String> hashMapMauSac();
    Map<String, String> hashMapDongSp();
    Map<String, String> hashMapManHinh();
    Map<String, String> hashMapCPU();
    Map<String, String> hashMapRAM();
    Map<String, String> hashMapSSD();
    Map<String, String> hashMapBaoHanh();
}
