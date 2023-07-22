/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepositories;

import domainmodels.CPU;
import domainmodels.ImeiDaBan;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IImeiDaBanRepository {
    List<ImeiDaBan> getAll();
    List<ImeiDaBan> getImeiByIdHD_IdCTSP(String idHD, String idCtsp);
    Integer them(ImeiDaBan imeiDaBan);
    Integer sua(ImeiDaBan imeiDaBan);
    Integer xoa(String ma);
    Integer xoaAll(String idChiTietHD);
    ImeiDaBan getIdByMa(String ma);
    Integer updateTrangThai(String trangThai, String idHD);
    List<ImeiDaBan> getImeiByIdHD(String idHD);
}
