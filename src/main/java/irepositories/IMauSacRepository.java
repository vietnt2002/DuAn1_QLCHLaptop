/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepositories;

import domainmodels.CPU;
import domainmodels.MauSac;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IMauSacRepository {
    List<MauSac> getAll();
    Integer them(MauSac mauSac);
    Integer sua(MauSac mauSac);
    Integer xoa(String ma);
}
