/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

import java.sql.Date;
import java.text.DecimalFormat;

/**
 *
 * @author ADMIN
 */
public class ManHinh {

    private String id;
    private String ma;
    private String doPhanGiai;
    private double inch;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public ManHinh() {
    }

    public ManHinh(String id, String ma, String doPhanGiai, double inch, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.doPhanGiai = doPhanGiai;
        this.inch = inch;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public ManHinh(String ma, String doPhanGiai, double inch, Date ngayTao, Date ngaySua, int trangThai) {
        this.ma = ma;
        this.doPhanGiai = doPhanGiai;
        this.inch = inch;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public ManHinh(String doPhanGiai, double inch, Date ngayTao, Date ngaySua, int trangThai) {
        this.doPhanGiai = doPhanGiai;
        this.inch = inch;
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

    public String getDoPhanGiai() {
        return doPhanGiai;
    }

    public void setDoPhanGiai(String doPhanGiai) {
        this.doPhanGiai = doPhanGiai;
    }

    public double getInch() {
        return inch;
    }

    public void setInch(double inch) {
        this.inch = inch;
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
        DecimalFormat dmf = new DecimalFormat("#.#");
        String inchfm = dmf.format(inch);
        return inchfm + " Inch " + doPhanGiai;
    }

}
