/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class ChiTietHD {
    private String id;
    private String idHD;
    private ChiTietSP idChiTietSP;
    private int soLuong;
    private BigDecimal donGia;
    private BigDecimal thanhTien;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public ChiTietHD() {
    }

    public ChiTietHD(String id, String idHD, ChiTietSP idChiTietSP, int soLuong, BigDecimal donGia, BigDecimal thanhTien, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.idHD = idHD;
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
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

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public ChiTietSP getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(ChiTietSP idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
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

    @Override
    public String toString() {
        return "ChiTietHD{" + "id=" + id + ", idHD=" + idHD + ", idChiTietSP=" + idChiTietSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", thanhTien=" + thanhTien + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", trangThai=" + trangThai + '}';
    }

}
