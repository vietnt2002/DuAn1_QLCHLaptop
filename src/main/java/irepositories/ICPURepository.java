/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepositories;

import domainmodels.CPU;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ICPURepository {
    List<CPU> getAll();
    Integer them(CPU cpu);
    Integer sua(CPU cpu);
    Integer xoa(String ma);
}
