/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepositories;

import domainmodels.CPU;
import domainmodels.ChiTietSP;
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
    Integer them(Imei imei);
    Integer sua(Imei imei);
    Integer xoa(String ma);
    Integer xoaCTSP(String idChiTietSP);
    Imei getIdByIMei(String imei);
    Integer updateTrangThai(String trangThai, String imei);
    Map<String, String> hashMapMaCTSP();
}
