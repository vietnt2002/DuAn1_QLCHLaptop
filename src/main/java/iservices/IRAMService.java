/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

import domainmodels.RAM;
import irepositories.*;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IRAMService {
    List<RAM> getAll();
    Integer them(RAM ram);
    Integer sua(RAM ram);
    Integer xoa(String ma);
}
