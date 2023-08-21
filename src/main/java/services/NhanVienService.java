/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.NhanVien;
import irepositories.INhanVienRepository;
import iservices.INhanVienService;
import java.util.List;
import repositories.NhanVienRepository;

/**
 *
 * @author ADMIN
 */
public class NhanVienService implements INhanVienService {

    private INhanVienRepository iNhanVienRepo = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return iNhanVienRepo.getAll();
    }

    @Override
    public NhanVien getTaiKhoan(String username) {
        return iNhanVienRepo.getTaiKhoan(username);
    }

    @Override
    public Integer them(NhanVien nhanVien) {
        return iNhanVienRepo.them(nhanVien);
    }

    @Override
    public Integer sua(NhanVien nhanVien) {
        return iNhanVienRepo.sua(nhanVien);
    }

    @Override
    public Integer xoa(NhanVien nhanVien) {
        return iNhanVienRepo.xoa(nhanVien);
    }

    @Override
    public String getIdByTen(String ma) {
        return iNhanVienRepo.getIdByTen(ma);
    }

    @Override
    public List<String> getTenChucVu() {
        return iNhanVienRepo.getChucVu();
    }

    @Override
    public NhanVien checkTrungMa(String ma) {
        return iNhanVienRepo.checkTrungMa(ma);
    }

    @Override
    public String getHoTenByMa(String ma) {
        return iNhanVienRepo.getHoTenByMa(ma);
    }

    @Override
    public String getHoTenById(String id) {
        return iNhanVienRepo.getHoTenById(id);
    }

    @Override
    public List<NhanVien> getAllDangLam() {
        return iNhanVienRepo.getAllDangLam();
    }

    @Override
    public List<NhanVien> getAllDaNghi() {
        return iNhanVienRepo.getAllDaNghi();
    }

    @Override
    public List<NhanVien> timTenNvLam(String ten) {
        return iNhanVienRepo.timTenNvLam(ten);
    }

    @Override
    public List<NhanVien> timTenNvNghi(String ten) {
        return iNhanVienRepo.timTenNvNghi(ten);
    }

    @Override
    public List<NhanVien> sapXepTenGiamNVLam() {
        return iNhanVienRepo.sapXepTenGiamNVLam();
    }

    @Override
    public List<NhanVien> sapXepTenGiamNVNghi() {
        return iNhanVienRepo.sapXepTenGiamNVNghi();
    }

    @Override
    public List<NhanVien> sapXepTenTangNVLam() {
        return iNhanVienRepo.sapXepTenTangNVLam();
    }

    @Override
    public List<NhanVien> sapXepTenTangNVNghi() {
        return iNhanVienRepo.sapXepTenTangNVNghi();
    }

    @Override
    public List<NhanVien> locChucVuNVLam(String chucVu1) {
        return iNhanVienRepo.locChucVuNVLam(chucVu1);
    }

    @Override
    public List<NhanVien> locChucVuNVNghi(String chucVu1) {
        return iNhanVienRepo.locChucVuNVNghi(chucVu1);
    }

    @Override
    public String setQuyen(String ma) {
        return iNhanVienRepo.setQuyen(ma);
    }

}
