/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodels.*;
import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class viewImei {

    private String id;
    private String imei;
    private ChiTietSP maChiTietSP;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public viewImei() {
    }

    public viewImei(String id, String imei, ChiTietSP maChiTietSP, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.imei = imei;
        this.maChiTietSP = maChiTietSP;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public viewImei(String imei, ChiTietSP maChiTietSP, Date ngayTao, Date ngaySua, int trangThai) {
        this.imei = imei;
        this.maChiTietSP = maChiTietSP;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public ChiTietSP getMaChiTietSP() {
        return maChiTietSP;
    }

    public void setMaChiTietSP(ChiTietSP maChiTietSP) {
        this.maChiTietSP = maChiTietSP;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Imei{" + "id=" + id + ", imei=" + imei + ", maChiTietSP=" + maChiTietSP + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", trangThai=" + trangThai + '}';
    }

    public String getStatus(int trangThai) {
        return switch (trangThai) {
            case 0 ->
                "Chưa bán";
            case 1 ->
                "Đã bán";
            case 2 ->
                "Lỗi";
            case 3 ->
                "Ngừng bán";
            default ->
                "Không rõ";
        };
    }

}
