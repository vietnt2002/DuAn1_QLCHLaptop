/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

import domainmodels.ManHinh;
import irepositories.*;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IManHinhService {
    List<ManHinh> getAll();
    Integer them(ManHinh manHinh);
    Integer sua(ManHinh manHinh);
    Integer xoa(String ma);
}
