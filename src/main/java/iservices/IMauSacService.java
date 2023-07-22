/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

import domainmodels.MauSac;
import irepositories.*;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IMauSacService {
    List<MauSac> getAll();
    Integer them(MauSac mauSac);
    Integer sua(MauSac mauSac);
    Integer xoa(String ma);
}
