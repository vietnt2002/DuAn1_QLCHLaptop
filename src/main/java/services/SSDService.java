/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.SSD;
import irepositories.ISSDRepository;
import iservices.ISSDService;
import java.util.ArrayList;
import java.util.List;
import repositories.SSDRepository;

/**
 *
 * @author ADMIN
 */
public class SSDService implements ISSDService {

    private final ISSDRepository reposytory = new SSDRepository();

    @Override
    public List<SSD> getAll() {
        return reposytory.getAll();
    }

    @Override
    public Integer them(SSD ssd) {
        return reposytory.them(ssd);
    }

    @Override
    public Integer sua(SSD ssd) {
        return reposytory.sua(ssd);
    }

    @Override
    public Integer xoa(String ma) {
        return reposytory.xoa(ma);
    }

}