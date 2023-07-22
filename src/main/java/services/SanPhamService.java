/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.SanPham;
import irepositories.ISanPhamRepository;
import iservices.ISanPhamService;
import java.util.ArrayList;
import java.util.List;
import repositories.SanPhamRepository;

/**
 *
 * @author ADMIN
 */
public class SanPhamService implements ISanPhamService {

    private final ISanPhamRepository reposytory = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return reposytory.getAll();
    }

    @Override
    public Integer them(SanPham sp) {
        return reposytory.them(sp);
    }

    @Override
    public Integer sua(SanPham sp) {
        return reposytory.sua(sp);
    }

    @Override
    public Integer xoa(String ma) {
        return reposytory.xoa(ma);
    }

    @Override
    public String getIdByMa(String ma) {
        return reposytory.getIdByMa(ma);
    }

}

