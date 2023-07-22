/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepositories;
import domainmodels.RAM;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IRAMRepository {
    List<RAM> getAll();
    Integer them(RAM ram);
    Integer sua(RAM ram);
    Integer xoa(String ma);
}
