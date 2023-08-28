/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.ChiTietSP;
import domainmodels.Imei;
import irepositories.IImeiRepository;
import iservices.IImeiService;
import java.util.List;
import java.util.Map;
import repositories.ImeiRepository;

/**
 *
 * @author ADMIN
 */
public class ImeiService implements IImeiService {

    private IImeiRepository imeiRepo = new ImeiRepository();

    @Override
    public List<Imei> getAll() {
        return imeiRepo.getAll();
    }

    @Override
    public List<Imei> getAllwId() {
        return imeiRepo.getAllwId();
    }

    @Override
    public List<Imei> getAllByIdCtsp(String idCtsp) {
        return imeiRepo.getAllByIdCtsp(idCtsp);
    }

    @Override
    public Integer them(Imei imei) {
        return imeiRepo.them(imei);
    }

    @Override
    public Integer sua(Imei imei) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer xoa(String ma) {
        return imeiRepo.xoa(ma);
    }

    @Override
    public String getIdByIMei(String im) {
        return imeiRepo.getIdByIMei(im);
    }

    @Override
    public List<Imei> timKiemImei(String idCtsp, String imei) {
        return imeiRepo.timKiemImei(idCtsp, imei);
    }

    @Override
    public Integer updateTrangThai(String trangThai, String imei) {
        return imeiRepo.updateTrangThai(trangThai, imei);
    }

    @Override
    public Map<String, String> hashMapMaCTSP() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer xoaCTSP(String idChiTietSP) {
        return imeiRepo.xoa(idChiTietSP);
    }

    @Override
    public List<Imei> timImei(String idCtsp) {
        return imeiRepo.timImei(idCtsp);
    }

    @Override
    public List<Imei> timtheoImei(String Imei) {
        return imeiRepo.timtheoImei(Imei);
    }

    @Override
    public List<Imei> getAllByIdCTSP_0TT(String idCTSP) {
        return imeiRepo.getAllByIdCTSP_0TT(idCTSP);
    }

    @Override
    public List<Imei> timKiemImei_0TT(String idCTSP, String imei) {
        return imeiRepo.timKiemImei_0TT(idCTSP, imei);
    }

    @Override
    public List<Imei> timTTImei(Integer tt) {
        return imeiRepo.timTTImei(tt);
    }

    @Override
    public Integer doiTrangThai(String trangThai, String IdChiTietSP, String trangThaiN) {
        return imeiRepo.doiTrangThai(trangThai, IdChiTietSP, trangThaiN);
    }

}
