/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepositories;

import domainmodels.CPU;
import domainmodels.SSD;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ISSDRepository {
    List<SSD> getAll();
    Integer them(SSD ssd);
    Integer sua(SSD ssd);
    Integer xoa(String ma);
}
