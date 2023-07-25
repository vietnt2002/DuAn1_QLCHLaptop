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
    private ChiTietSP idChiTietSP;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public viewImei() {
    }

    public viewImei(String id, String imei, ChiTietSP idChiTietSP, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.imei = imei;
        this.idChiTietSP = idChiTietSP;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public viewImei(String imei, ChiTietSP idChiTietSP, Date ngayTao, Date ngaySua, int trangThai) {
        this.imei = imei;
        this.idChiTietSP = idChiTietSP;
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

    public ChiTietSP getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(ChiTietSP idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
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
        return "Imei{" + "id=" + id + ", imei=" + imei + ", idChiTietSP=" + idChiTietSP + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", trangThai=" + trangThai + '}';
    }

    public String getStatus(int trangThai) {
        return switch (trangThai) {
            case 0 ->
                "Hết hàng";
            case 1 ->
                "Còn hàng";
            default ->
                "Không rõ";
        };
    }

}
