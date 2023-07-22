/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepositories;

import domainmodels.CPU;
import domainmodels.SanPham;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ISanPhamRepository {
    List<SanPham> getAll();
    Integer them(SanPham sanPham);
    Integer sua(SanPham sanPham);
    Integer xoa(String ma);
    String getIdByMa(String ma);
}
