/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @author ADMIN
 */
public class KhuyenMai {

    private String id;
    private String ma;
    private BigDecimal soTienGiam;
    private int soLuong;
    private Date ngayBD;
    private Date ngayKT;
    private int trangThai;

    public String getTrangThaiString() {
        if (trangThai == 0) {
            return "Đang diễn ra";
        } else if (trangThai == 1) {
            return "Sắp diễn ra";
        } else {
            return "Đã kết thúc";
        }
    }

    public KhuyenMai() {
    }

    public KhuyenMai(String id, String ma, BigDecimal soTienGiam, int soLuong, Date ngayBD, Date ngayKT, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.soTienGiam = soTienGiam;
        this.soLuong = soLuong;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
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

    public BigDecimal getSoTienGiam() {
        return soTienGiam;
    }

    public void setSoTienGiam(BigDecimal soTienGiam) {
        this.soTienGiam = soTienGiam;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return ma;
    }

  

}
