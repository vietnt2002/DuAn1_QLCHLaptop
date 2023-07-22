/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.CPU;
import irepositories.ICPURepository;
import iservices.ICPUService;
import java.util.ArrayList;
import java.util.List;
import repositories.CPURepository;

/**
 *
 * @author ADMIN
 */
public class CPUService implements ICPUService {

    private final ICPURepository reposytory = new CPURepository();

    @Override
    public List<CPU> getAll() {
        return reposytory.getAll();
    }

    @Override
    public Integer them(CPU cpu) {
        return reposytory.them(cpu);
    }

    @Override
    public Integer sua(CPU cpu) {
        return reposytory.sua(cpu);
    }

    @Override
    public Integer xoa(String ma) {
        return reposytory.xoa(ma);
    }

}
