/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class KhachHang {

    private String id;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private Date ngaySinh;
    private String sdt;
    private String diaChi;
    private String email;
    private int soLanMuaHang;
    private Date ngayTao;
    private Date ngaySua;

    public KhachHang() {
    }

    public KhachHang(String id, String ma, String ten, String tenDem, String ho, Date ngaySinh, String sdt, String diaChi, String email, int soLanMuaHang, Date ngayTao, Date ngaySua) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.email = email;
        this.soLanMuaHang = soLanMuaHang;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
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

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSoLanMuaHang() {
        return soLanMuaHang;
    }

    public void setSoLanMuaHang(int soLanMuaHang) {
        this.soLanMuaHang = soLanMuaHang;
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

    @Override
    public String toString() {
        return ma;
    }
    
    public String getStatus(int trangThai) {
        return switch (trangThai) {
            case 0 ->
                "Không tồn tại";
            case 1 ->
                "Tồn tại";
            default ->
                "Không rõ";
        };
    }

}
