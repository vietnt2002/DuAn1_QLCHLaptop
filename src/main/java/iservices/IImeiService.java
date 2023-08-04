/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

import domainmodels.ChiTietSP;
import domainmodels.Imei;
import irepositories.*;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface IImeiService {
    List<Imei> getAll();
    List<Imei> getAllwId();
    List<Imei> getAllByIdCtsp(String idCtsp);
    List<Imei> timKiemImei(String idCtsp, String imei);
    List<Imei> timImei(String idCtsp);
    List<Imei> timTTImei(Integer tt);
    List<Imei> timtheoImei(String Imei);
    Integer them(Imei imei);
    Integer sua(Imei imei);
    Integer xoa(String ma);
    Integer xoaCTSP(String idChiTietSP);
    String getIdByIMei(String im);
    Integer updateTrangThai(String trangThai, String imei);
    Map<String, String> hashMapMaCTSP();
    List<Imei> getAllByIdCTSP_0TT(String idCTSP);
    List<Imei> timKiemImei_0TT(String idCTSP, String imei);
}
