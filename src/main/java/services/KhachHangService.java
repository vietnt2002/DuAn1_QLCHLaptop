/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.KhachHang;
import irepositories.IKhachHangRepository;
import iservices.IKhachHangService;
import java.util.List;
import repositories.KhachHangRepository;
/**
 *
 * @author ADMIN
 */
public class KhachHangService implements IKhachHangService {

    private IKhachHangRepository ikhachHangRepo = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return ikhachHangRepo.getAll();
    }

    @Override
    public Integer them(KhachHang khachHang) {
            return ikhachHangRepo.them(khachHang);
    }

    @Override
    public Integer sua(KhachHang khachHang) {
        return ikhachHangRepo.sua(khachHang);
    }

    @Override
    public Integer xoa(String ma) {
        return ikhachHangRepo.xoa(ma);
    }

    @Override
    public String getIdBySDT(String sdt) {
        return ikhachHangRepo.getIdBySDT(sdt);
    }
    
    @Override
    public String getIdByMa(String ma) {
        return ikhachHangRepo.getIdByMa(ma);
    }

    @Override
    public List<KhachHang> sapXepTenGiam() {
        return ikhachHangRepo.sapXepTenGiam();
    }

    @Override
    public List<KhachHang> sapXepTenTang() {
        return ikhachHangRepo.sapXepTenTang();
    }

    @Override
    public KhachHang checkTrungMa(String ma) {
        return ikhachHangRepo.checkTrungMa(ma);
    }

    @Override
    public List<KhachHang> timTen(String timTen) {
       return ikhachHangRepo.timTen(timTen);

    }

    @Override
    public KhachHang getHoTenByMa(String ma) {
        return ikhachHangRepo.getHoTenByMa(ma);
    }
    
    @Override
    public KhachHang getHoTenById(String id) {
        return ikhachHangRepo.getHoTenById(id);
    }

    @Override
    public KhachHang getThongTinBySdtOrEmail(String sdtOrEmail) {
        return ikhachHangRepo.getThongTinBySdtOrEmail(sdtOrEmail);
    }

    @Override
    public List<Integer> getSoLanMua() {
      return ikhachHangRepo.getSoLanMua();
    }

    @Override
    public List<KhachHang> locSoLanMua(int solan) {
       return ikhachHangRepo.locSoLanMua(solan);
               
    }

}

