/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepositories;

import domainmodels.BaoHanh;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IBaoHanhRepository {
    List<BaoHanh> getAll();
    Integer them(BaoHanh baoHanh);
    Integer sua(BaoHanh baoHanh);
    Integer xoa(String ma);
}
