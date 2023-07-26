/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.HoaDon;
import irepositories.IHoaDonRepository;
import iservices.IHoaDonService;
import java.util.List;
import repositories.HoaDonRepository;

/**
 *
 * @author ADMIN
 */
public class HoaDonService implements IHoaDonService{
    private IHoaDonRepository hoaDonRepo = new HoaDonRepository();

    @Override
    public List<HoaDon> getAll() {
        return hoaDonRepo.getAll();
    }

    @Override
    public List<HoaDon> getAllByMa(String ma) {
        return hoaDonRepo.getAllByMa(ma);
    }
    
    @Override
    public Integer them(HoaDon hoaDon) {
        return hoaDonRepo.them(hoaDon);
    }
    
    @Override
    public Integer themIdNV_IdKH(HoaDon hoaDon) {
        return hoaDonRepo.themHDIdNV_IdKH(hoaDon);
    }

    @Override
    public Integer sua(HoaDon hoaDon) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer xoa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getIdByMa(String ma) {
        return hoaDonRepo.getIdByMa(ma);
    }

    @Override
    public Integer updateIdKH(String idKH, String idHD) {
        return hoaDonRepo.updateIdKH(idKH, idHD);
    }

    @Override
    public Integer updateTrangThai(String trangThai, String lyDo, String thanhTien, String khuyenMai, String idHD) {
        return hoaDonRepo.updateTrangThai(trangThai, lyDo, thanhTien, khuyenMai, idHD);
    }

}
