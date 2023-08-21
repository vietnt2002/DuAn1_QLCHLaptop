/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepositories;

import domainmodels.NhanVien;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface INhanVienRepository {

    List<NhanVien> getAll();

    List<NhanVien> getAllDangLam();

    List<NhanVien> getAllDaNghi();

    NhanVien getTaiKhoan(String username);

    Integer them(NhanVien nhanVien);

    Integer sua(NhanVien nhanVien);

    Integer xoa(NhanVien nhanVien);

    String getIdByTen(String ten);

    NhanVien checkTrungMa(String ma);

    List<String> getChucVu();

    List<NhanVien> timTenNvLam(String ten);

    List<NhanVien> timTenNvNghi(String ten);

    List<NhanVien> sapXepTenGiamNVLam();

    List<NhanVien> sapXepTenGiamNVNghi();

    List<NhanVien> sapXepTenTangNVLam();

    List<NhanVien> sapXepTenTangNVNghi();

    String getHoTenByMa(String ma);

    String getHoTenById(String id);

    List<NhanVien> locChucVuNVLam(String chucVu1);

    List<NhanVien> locChucVuNVNghi(String chucVu1);

    String setQuyen(String ma);
}
