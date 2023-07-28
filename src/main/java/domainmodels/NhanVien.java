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
public class NhanVien {

    private String id;
    private String idCV;
    private String ma;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public NhanVien() {
    }
   public String getTrangThaiString() {
        if (trangThai == 1) {
            return "Đang làm việc";
        } else {
            return "Đã nghỉ";
        }
    }

    public NhanVien(String id, String idCV, String ma, String hoTen, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.idCV = idCV;
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
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

    public String getIdCV() {
        return idCV;
    }

    public void setIdCV(String idCV) {
        this.idCV = idCV;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
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
        return ma;
    }
    
    public String getStatus(int trangThai) {
        return switch (trangThai) {
            case 0 ->
                "Nghỉ";
            case 1 ->
                "Còn làm";
            default ->
                "Không rõ";
        };
    }

}
