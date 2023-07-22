package services;

import domainmodels.MauSac;
import irepositories.IMauSacRepository;
import iservices.IMauSacService;
import java.util.ArrayList;
import java.util.List;
import repositories.MauSacRepository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class MauSacService implements IMauSacService {

    private final IMauSacRepository reposytory = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        return reposytory.getAll();
    }

    @Override
    public Integer them(MauSac mau) {
        return reposytory.them(mau);
    }

    @Override
    public Integer sua(MauSac mau) {
        return reposytory.sua(mau);
    }

    @Override
    public Integer xoa(String ma) {
        return reposytory.xoa(ma);
    }

}
