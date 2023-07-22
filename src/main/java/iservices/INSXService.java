/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

import domainmodels.NSX;
import irepositories.*;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface INSXService {
    List<NSX> getAll();
    Integer them(NSX nsx);
    Integer sua(NSX nsx);
    Integer xoa(String ma);
}
