/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

import domainmodels.SSD;
import irepositories.*;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ISSDService {
    List<SSD> getAll();
    Integer them(SSD ssd);
    Integer sua(SSD ssd);
    Integer xoa(String ma);
}
