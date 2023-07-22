/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.ManHinh;
import irepositories.IManHinhRepository;
import iservices.IManHinhService;
import java.util.List;
import repositories.ManHinhRepository;

/**
 *
 * @author ADMIN
 */
public class ManHinhService implements IManHinhService {

    private final IManHinhRepository reposytory = new ManHinhRepository();

    @Override
    public List<ManHinh> getAll() {
        return reposytory.getAll();
    }

    @Override
    public Integer them(ManHinh manhinh) {
        return reposytory.them(manhinh);
    }

    @Override
    public Integer sua(ManHinh manhinh) {
        return reposytory.sua(manhinh);
    }

    @Override
    public Integer xoa(String ma) {
        return reposytory.xoa(ma);
    }

}

