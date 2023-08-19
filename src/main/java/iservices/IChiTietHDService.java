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
    Integer themCTHD(ChiTietHD chiTietHD);
    Integer them(ChiTietHD chiTietHD);
    Integer sua(ChiTietHD chiTietHD);
    Integer xoa(String idCtsp, String idHD);
    String getIdByIdHD(String idHD);
    String getIdByIdCTSP_IdHD(String idCtsp, String idHD);
    Integer themSoLuong(String idHD, String idChiTietSP);
    Integer botSoLuong(String idHD, String idChiTietSP);
    Integer xoaSoLuong(String idHD);
    Integer updateTrangThai(String trangThai, String idHD);
    Integer updateThanhTien(String thanhTien, String idHD, String idCtsp);
    Integer updateSanPham(String donGia, String thanhTien, String idChiTietSP, String idHD, String idCTSP);
    Integer getSoLuongByIdHD_IdCTSP(String idHD, String idChiTietSP);
}
