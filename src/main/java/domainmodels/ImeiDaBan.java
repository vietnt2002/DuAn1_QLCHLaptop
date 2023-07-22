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
public class ImeiDaBan {
    private String id;
    private String imei;
    private String idChiTietHD;
    private Date ngayBan;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public ImeiDaBan() {
    }

    public ImeiDaBan(String id, String imei, String idChiTietHD, Date ngayBan, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.imei = imei;
        this.idChiTietHD = idChiTietHD;
        this.ngayBan = ngayBan;
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

    public String getIdChiTietHD() {
        return idChiTietHD;
    }

    public void setIdChiTietHD(String idChiTietHD) {
        this.idChiTietHD = idChiTietHD;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
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
        return "ImeiDaBan{" + "id=" + id + ", imei=" + imei + ", idChiTietHD=" + idChiTietHD + ", ngayBan=" + ngayBan + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", trangThai=" + trangThai + '}';
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
