/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author ADMIN
 */
public class viewSapHetHang {
    private String ma;
    private String ten;
    private int soLuongTon;

    public viewSapHetHang() {
    }

    public viewSapHetHang(String ma, String ten, int soLuongTon) {
        this.ma = ma;
        this.ten = ten;
        this.soLuongTon = soLuongTon;
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

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    @Override
    public String toString() {
        return "viewsanpham{" + "ma=" + ma + ", ten=" + ten + ", soLuongTon=" + soLuongTon + '}';
    }
    
    
    
    
}
