/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepositories;

import domainmodels.CPU;
import domainmodels.Imei;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IImeiRepository {
    List<Imei> getAll();
    List<Imei> getAllByIdCtsp(String idCtsp);
    List<Imei> timKiemImei(String idCtsp, String imei);
    Integer them(Imei imei);
    Integer sua(Imei imei);
    Integer xoa(String ma);
    Imei getIdByIMei(String imei);
    Integer updateTrangThai(String trangThai, String imei);
}
