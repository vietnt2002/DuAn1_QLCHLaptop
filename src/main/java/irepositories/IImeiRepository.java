/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepositories;

import domainmodels.Imei;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface IImeiRepository {
    List<Imei> getAll();
    List<Imei> getAllwId();
    List<Imei> getAllByIdCtsp(String idCtsp);
    List<Imei> timKiemImei(String idCtsp, String imei);
    List<Imei> timImei(String idCtsp);
    List<Imei> timtheoImei(String Imei);
    List<Imei> timTTImei(Integer tt);
    Integer them(Imei imei);
    Integer sua(Imei imei);
    Integer xoa(String ma);
    Integer xoaCTSP(String idChiTietSP);
    String getIdByIMei(String imei);
    Integer updateTrangThai(String trangThai, String imei);
    Integer doiTrangThai(String trangThai1, String trangThai2);
    Map<String, String> hashMapMaCTSP();
    List<Imei> getAllByIdCTSP_0TT(String idChiTietSP);
    List<Imei> timKiemImei_0TT(String idCTSP, String imei);
}
