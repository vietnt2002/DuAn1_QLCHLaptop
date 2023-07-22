/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepositories;

import domainmodels.CPU;
import domainmodels.ManHinh;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IManHinhRepository {
    List<ManHinh> getAll();
    Integer them(ManHinh manHinh);
    Integer sua(ManHinh manHinh);
    Integer xoa(String ma);
}
