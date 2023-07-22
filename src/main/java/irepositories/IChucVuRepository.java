/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepositories;

import domainmodels.CPU;
import domainmodels.ChucVu;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IChucVuRepository {
    List<ChucVu> getAll();
    Integer them(ChucVu chucVu);
    Integer sua(ChucVu chucVu);
    Integer xoa(String ma);
    ChucVu getIdByTen(String ten);
}
