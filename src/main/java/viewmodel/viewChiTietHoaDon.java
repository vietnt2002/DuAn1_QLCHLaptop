/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class viewChiTietHoaDon {

    private String ma;
    private String imei;
    private String idKH;
    private String idNV;
    private int thanhTien;
    private Date ngayThanhToan;
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
    private BigDecimal giaBan;

    public viewChiTietHoaDon() {
    }

    public viewChiTietHoaDon(String ma, String imei, String idKH, String idNV, int thanhTien, Date ngayThanhToan, String tenSP, String NSX, String MauSac, String DongSP, String CPU, String RAM, String SSD, String ManHinh, String BaoHanh, double canNang, String moTa, BigDecimal giaBan) {
        this.ma = ma;
        this.imei = imei;
        this.idKH = idKH;
        this.idNV = idNV;
        this.thanhTien = thanhTien;
        this.ngayThanhToan = ngayThanhToan;
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
        this.giaBan = giaBan;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
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

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "viewChiTietHoaDon{" + "ma=" + ma + ", imei=" + imei + ", idKH=" + idKH + ", idNV=" + idNV + ", thanhTien=" + thanhTien + ", ngayThanhToan=" + ngayThanhToan + ", tenSP=" + tenSP + ", NSX=" + NSX + ", MauSac=" + MauSac + ", DongSP=" + DongSP + ", CPU=" + CPU + ", RAM=" + RAM + ", SSD=" + SSD + ", ManHinh=" + ManHinh + ", BaoHanh=" + BaoHanh + ", canNang=" + canNang + ", moTa=" + moTa + ", giaBan=" + giaBan + '}';
    }

   
    
    
    

   

}
