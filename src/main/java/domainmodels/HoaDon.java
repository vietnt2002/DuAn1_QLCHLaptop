/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class HoaDon {

    private String id;
    private String ma;
    private String idKH;
    private String idNV;
    private Date ngayThanhToan;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public HoaDon() {
    }

    public String getTrangThaiString() {
        if (trangThai == 0) {
            return "Chưa hoàn thành";
        } else {
            return "Đã hoàn thành";
        }
    }

    public HoaDon(String id, String ma, String idKH, String idNV, Date ngayThanhToan, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.idKH = idKH;
        this.idNV = idNV;
        this.ngayThanhToan = ngayThanhToan;
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

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
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

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
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
        return "HoaDon{" + "id=" + id + ", ma=" + ma + ", idKH=" + idKH + ", idNV=" + idNV + ", ngayThanhToan=" + ngayThanhToan + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", trangThai=" + trangThai + '}';
    }
    
    public String getStatus(int trangThai) {
        return switch (trangThai) {
            case 0 ->
                "Hết";
            case 1 ->
                "Còn";
            default ->
                "Không rõ";
        };
    }

}
