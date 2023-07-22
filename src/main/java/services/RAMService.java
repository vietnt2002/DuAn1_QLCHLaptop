/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.RAM;
import irepositories.IRAMRepository;
import iservices.IRAMService;
import java.util.ArrayList;
import java.util.List;
import repositories.RAMRepository;

/**
 *
 * @author ADMIN
 */
public class RAMService implements IRAMService {
    private final IRAMRepository reposytory = new RAMRepository();

    @Override
    public List<RAM> getAll() {
        return reposytory.getAll();
    }

    @Override
    public Integer them(RAM ram) {
        return reposytory.them(ram);
    }

    @Override
    public Integer sua(RAM ram) {
        return reposytory.sua(ram);
    }

    @Override
    public Integer xoa(String ma) {
        return reposytory.xoa(ma);
    }
}
