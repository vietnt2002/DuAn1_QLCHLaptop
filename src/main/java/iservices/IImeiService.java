/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

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
    List<Imei> getAllByIdCtsp(String idCtsp);
    List<Imei> timKiemImei(String idCtsp, String imei);
    Integer them(Imei imei);
    Integer sua(Imei imei);
    Integer xoa(String ma);
    Imei getIdByIMei(String im);
    Integer updateTrangThai(String trangThai, String imei);
    Map<String, String> hashMapMaCTSP();
}
