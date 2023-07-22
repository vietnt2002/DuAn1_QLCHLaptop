/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.DongSP;
import irepositories.IDongSPRepository;
import iservices.IDongSPService;
import java.util.ArrayList;
import java.util.List;
import repositories.DongSPRepository;

/**
 *
 * @author ADMIN
 */
public class DongSPService implements IDongSPService {

    private final IDongSPRepository reposytory = new DongSPRepository();

    @Override
    public List<DongSP> getAll() {
        return reposytory.getAll();
    }

    @Override
    public Integer them(DongSP dongSP) {
        return reposytory.them(dongSP);
    }

    @Override
    public Integer sua(DongSP dongSP) {
        return reposytory.sua(dongSP);
    }

    @Override
    public Integer xoa(String ma) {
        return reposytory.xoa(ma);
    }

}
