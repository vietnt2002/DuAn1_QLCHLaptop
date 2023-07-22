/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

import domainmodels.CPU;
import irepositories.*;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ICPUService {
    List<CPU> getAll();
    Integer them(CPU cpuView);
    Integer sua(CPU cpuView);
    Integer xoa(String ma);
}
