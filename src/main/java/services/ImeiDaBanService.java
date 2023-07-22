/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.ImeiDaBan;
import irepositories.IImeiDaBanRepository;
import iservices.IImeiDaBanService;
import java.util.List;
import repositories.ImeiDaBanRepository;

/**
 *
 * @author ADMIN
 */
public class ImeiDaBanService implements IImeiDaBanService{
    private IImeiDaBanRepository imeiDaBanRepo = new ImeiDaBanRepository();
    
    @Override
    public List<ImeiDaBan> getAll() {
        return imeiDaBanRepo.getAll();
    }
    
    @Override
    public List<ImeiDaBan> getImeiByIdHD_IdCTSP(String idHD, String idCtsp) {
        return imeiDaBanRepo.getImeiByIdHD_IdCTSP(idHD, idCtsp);
    }

    @Override
    public Integer them(ImeiDaBan imeiDaBan) {
        return imeiDaBanRepo.them(imeiDaBan);
    }

    @Override
    public Integer sua(ImeiDaBan imeiDaBan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer xoa(String imei) {
        return imeiDaBanRepo.xoa(imei);
    }

    @Override
    public ImeiDaBan getIdByMa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer xoaAll(String idChiTietHD) {
        return imeiDaBanRepo.xoaAll(idChiTietHD);
    }

    @Override
    public Integer updateTrangThai(String trangThai, String idHD) {
        return imeiDaBanRepo.updateTrangThai(trangThai, idHD);
    }

    @Override
    public List<ImeiDaBan> getImeiByIdHD(String idHD) {
        return imeiDaBanRepo.getImeiByIdHD(idHD);
    }
 
}
