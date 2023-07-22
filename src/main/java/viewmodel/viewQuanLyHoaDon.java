/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class viewQuanLyHoaDon {

    private String id;
    private String idKH;
    private String idNV;
    private int thanhTien;
    private Date ngayThanhToan;
    private int trangThai;

    public viewQuanLyHoaDon() {
    }

    public String getTrangThaiString() {
        if (trangThai == 0) {
            return "Chưa hoàn thành";
        } else {
            return "Đã hoàn thành";
        }
    }

    public viewQuanLyHoaDon(String id, String idKH, String idNV, int thanhTien, Date ngayThanhToan, int trangThai) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.thanhTien = thanhTien;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
