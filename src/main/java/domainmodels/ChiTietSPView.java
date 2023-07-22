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
public class ChiTietSPView {

    private String id;
    private String tenSP;
    private String NSX;
    private String MauSac;
    private String DongSP;
    private String CPU;
    private String RAM;
    private String SSD;
    private String ManHinh;
    private String BaoHanh;
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

    public ChiTietSPView() {
    }

    public ChiTietSPView(String id, String tenSP, String NSX, String MauSac, String DongSP, String CPU, String RAM, String SSD, String ManHinh, String BaoHanh, double canNang, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, Date ngayTao, Date ngaySua, int trangThai, int numOrder, String ma) {
        this.id = id;
        this.tenSP = tenSP;
        this.NSX = NSX;
        this.MauSac = MauSac;
        this.DongSP = DongSP;
        this.CPU = CPU;
        this.RAM = RAM;
        this.SSD = SSD;
        this.ManHinh = ManHinh;
        this.BaoHanh = BaoHanh;
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

    public ChiTietSPView(String tenSP, String NSX, String MauSac, String DongSP, String CPU, String RAM, String SSD, String ManHinh, String BaoHanh, double canNang, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, Date ngayTao, Date ngaySua, int trangThai, String ma) {
        this.tenSP = tenSP;
        this.NSX = NSX;
        this.MauSac = MauSac;
        this.DongSP = DongSP;
        this.CPU = CPU;
        this.RAM = RAM;
        this.SSD = SSD;
        this.ManHinh = ManHinh;
        this.BaoHanh = BaoHanh;
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

    public ChiTietSPView(String tenSP, String NSX, String MauSac, String DongSP, String CPU, String RAM, String SSD, String ManHinh, String BaoHanh, double canNang, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, Date ngayTao, Date ngaySua, int trangThai) {
        this.tenSP = tenSP;
        this.NSX = NSX;
        this.MauSac = MauSac;
        this.DongSP = DongSP;
        this.CPU = CPU;
        this.RAM = RAM;
        this.SSD = SSD;
        this.ManHinh = ManHinh;
        this.BaoHanh = BaoHanh;
        this.canNang = canNang;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        this.NSX = NSX;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public String getDongSP() {
        return DongSP;
    }

    public void setDongSP(String DongSP) {
        this.DongSP = DongSP;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getSSD() {
        return SSD;
    }

    public void setSSD(String SSD) {
        this.SSD = SSD;
    }

    public String getManHinh() {
        return ManHinh;
    }

    public void setManHinh(String ManHinh) {
        this.ManHinh = ManHinh;
    }

    public String getBaoHanh() {
        return BaoHanh;
    }

    public void setBaoHanh(String BaoHanh) {
        this.BaoHanh = BaoHanh;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return id;
    }

}
