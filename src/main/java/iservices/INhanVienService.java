/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

import domainmodels.NhanVien;
import irepositories.*;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface INhanVienService {

    List<NhanVien> getAll();

    NhanVien getTaiKhoan(String username);

    Integer them(NhanVien nhanVien);

    Integer sua(NhanVien nhanVien);

    Integer xoa(String ma);

    String getIdByTen(String ten);

    NhanVien checkTrungMa(String ma);

    List<String> getTenChucVu();

    NhanVien getHoTenByMa(String ma);

    NhanVien getHoTenById(String id);

    List<NhanVien> getAllDangLam();

    List<NhanVien> getAllDaNghi();

    List<NhanVien> timTenNvLam(String ten);

    List<NhanVien> timTenNvNghi(String ten);

    List<NhanVien> sapXepTenGiamNVLam();

    List<NhanVien> sapXepTenGiamNVNghi();

    List<NhanVien> sapXepTenTangNVLam();

    List<NhanVien> sapXepTenTangNVNghi();

    List<NhanVien> locChucVuNVLam(String chucVu1);

    List<NhanVien> locChucVuNVNghi(String chucVu1);

    String setQuyen(String ten);
}
