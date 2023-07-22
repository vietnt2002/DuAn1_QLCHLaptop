/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

import domainmodels.DongSP;
import irepositories.*;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IDongSPService {
    List<DongSP> getAll();
    Integer them(DongSP dongSP);
    Integer sua(DongSP dongSP);
    Integer xoa(String ma);
}
