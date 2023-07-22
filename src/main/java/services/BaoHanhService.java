/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.BaoHanh;
import irepositories.IBaoHanhRepository;
import iservices.IBaoHanhService;
import java.util.List;
import repositories.BaoHanhRepository;

/**
 *
 * @author ADMIN
 */
public class BaoHanhService implements IBaoHanhService {

    private final IBaoHanhRepository reposytory = new BaoHanhRepository();

    @Override
    public List<BaoHanh> getAll() {
        return reposytory.getAll();
    }

    @Override
    public Integer them(BaoHanh baohanh) {
        return reposytory.them(baohanh);
    }

    @Override
    public Integer sua(BaoHanh baohanh) {
        return reposytory.sua(baohanh);
    }

    @Override
    public Integer xoa(String ma) {
        return reposytory.xoa(ma);
    }

}
