/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.ChucVu;
import irepositories.IChucVuRepository;
import iservices.IChucVuService;
import java.util.ArrayList;
import java.util.List;
import repositories.ChucVuRepository;

/**
 *
 * @author ADMIN
 */
public class ChucVuService implements IChucVuService {

    private IChucVuRepository iChucVuRepo = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        return iChucVuRepo.getAll();
    }

    @Override
    public Integer them(ChucVu chucVu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer sua(ChucVu chucVu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer xoa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChucVu getIdByTen(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
