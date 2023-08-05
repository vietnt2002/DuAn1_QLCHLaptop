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
public class NSX {

    private String id;
    private String ma;
    private String ten;
    private String quocGia;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public NSX() {
    }

    public NSX(String id, String ma, String ten, String quocGia, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.quocGia = quocGia;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public NSX(String ma, String ten, String quocGia, Date ngayTao, Date ngaySua, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.quocGia = quocGia;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
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
                "Còn hàng";
            case 1 ->
                "Hết hàng";
            default ->
                "Không rõ";
        };
    }
    
    @Override
    public String toString() {
        return ten + " "+ quocGia;
    }

}
