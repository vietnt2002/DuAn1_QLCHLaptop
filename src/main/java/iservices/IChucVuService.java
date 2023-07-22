/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

import domainmodels.ChucVu;
import irepositories.*;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IChucVuService {
    List<ChucVu> getAll();
    Integer them(ChucVu chucVu);
    Integer sua(ChucVu chucVuView);
    Integer xoa(String ma);
    ChucVu getIdByTen(String ten);
}
