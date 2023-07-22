/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.NSX;
import irepositories.INSXRepository;
import iservices.INSXService;
import java.util.List;
import repositories.NSXRepository;

/**
 *
 * @author ADMIN
 */
public class NSXService implements INSXService {

    private final INSXRepository reposytory = new NSXRepository();

    @Override
    public List<NSX> getAll() {
        return reposytory.getAll();
    }

    @Override
    public Integer them(NSX nsx) {
        return reposytory.them(nsx);
    }

    @Override
    public Integer sua(NSX nsx) {
        return reposytory.sua(nsx);
    }

    @Override
    public Integer xoa(String ma) {
        return reposytory.xoa(ma);
    }

}
