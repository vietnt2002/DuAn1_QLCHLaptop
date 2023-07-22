/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

import domainmodels.SanPham;
import irepositories.*;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ISanPhamService {
    List<SanPham> getAll();
    Integer them(SanPham sanPham);
    Integer sua(SanPham sanPham);
    Integer xoa(String ma);
    String getIdByMa(String ma);
}
