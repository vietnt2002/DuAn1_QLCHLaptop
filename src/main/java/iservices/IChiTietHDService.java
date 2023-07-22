/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

import domainmodels.ChiTietHD;
import irepositories.*;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IChiTietHDService {
    List<ChiTietHD> getAll();
    List<ChiTietHD> getAllByIdHD(String idHD);
    Integer them(ChiTietHD chiTietHD);
    Integer sua(ChiTietHD chiTietHD);
    Integer xoa(String idCtsp, String idHD);
    String getIdByIdHD(String idHD);
    String getIdByIdCTSP_IdHD(String idCtsp, String idHD);
    Integer themSoLuong(String idHD, String idChiTietSP);
    Integer botSoLuong(String idHD, String idChiTietSP);
    Integer updateTrangThai(String trangThai, String idHD);
    Integer updateThanhTien(BigDecimal thanhTien, String idHD, String idCtsp);
}
