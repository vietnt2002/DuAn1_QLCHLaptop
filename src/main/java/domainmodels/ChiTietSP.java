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
public class ChiTietSP {

    private String id;
    private String idSP;
    private String idNSX;
    private String idMauSac;
    private String idDongSP;
    private String idCPU;
    private String idRam;
    private String idSSD;
    private String idManHinh;
    private String idBH;
    private double canNang;
    private String moTa;
    private int soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;
    private int numOrder;
    private String ma;

    public ChiTietSP() {
    }

    public ChiTietSP(String id, String idSP, String idNSX, String idMauSac, String idDongSP, String idCPU, String idRam, String idSSD, String idManHinh, String idBH, double canNang, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, Date ngayTao, Date ngaySua, int trangThai, int numOrder, String ma) {
        this.id = id;
        this.idSP = idSP;
        this.idNSX = idNSX;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.idCPU = idCPU;
        this.idRam = idRam;
        this.idSSD = idSSD;
        this.idManHinh = idManHinh;
        this.idBH = idBH;
        this.canNang = canNang;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.numOrder = numOrder;
        this.ma = ma;
    }

    public ChiTietSP(String idSP, String idNSX, String idMauSac, String idDongSP, String idCPU, String idRam, String idSSD, String idManHinh, String idBH, double canNang, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, Date ngayTao, Date ngaySua, int trangThai, String ma) {
        this.idSP = idSP;
        this.idNSX = idNSX;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.idCPU = idCPU;
        this.idRam = idRam;
        this.idSSD = idSSD;
        this.idManHinh = idManHinh;
        this.idBH = idBH;
        this.canNang = canNang;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.ma = ma;
    }

    public ChiTietSP(String idSP, String idNSX, String idMauSac, String idDongSP, String idCPU, String idRam, String idSSD, String idManHinh, String idBH, double canNang, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, Date ngayTao, Date ngaySua, int trangThai) {
        this.idSP = idSP;
        this.idNSX = idNSX;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.idCPU = idCPU;
        this.idRam = idRam;
        this.idSSD = idSSD;
        this.idManHinh = idManHinh;
        this.idBH = idBH;
        this.canNang = canNang;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
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

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(String idNSX) {
        this.idNSX = idNSX;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        this.idDongSP = idDongSP;
    }

    public String getIdCPU() {
        return idCPU;
    }

    public void setIdCPU(String idCPU) {
        this.idCPU = idCPU;
    }

    public String getIdRam() {
        return idRam;
    }

    public void setIdRam(String idRam) {
        this.idRam = idRam;
    }

    public String getIdSSD() {
        return idSSD;
    }

    public void setIdSSD(String idSSD) {
        this.idSSD = idSSD;
    }

    public String getIdManHinh() {
        return idManHinh;
    }

    public void setIdManHinh(String idManHinh) {
        this.idManHinh = idManHinh;
    }

    public String getIdBH() {
        return idBH;
    }

    public void setIdBH(String idBH) {
        this.idBH = idBH;
    }

    public double getCanNang() {
        return canNang;
    }

    public void setCanNang(double canNang) {
        this.canNang = canNang;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
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

    public int getNumOrder() {
        return numOrder;
    }

    public void setNumOrder(int numOrder) {
        this.numOrder = numOrder;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getStatus(int trangThai) {
        return switch (trangThai) {
            case 0 ->
                "Hết hàng";
            case 1 ->
                "Còn hàng";
            case 2 ->
                "Ngừng bán";
            default ->
                "Không rõ";
        };
    }

    @Override
    public String toString() {
        return id;
    }

}
