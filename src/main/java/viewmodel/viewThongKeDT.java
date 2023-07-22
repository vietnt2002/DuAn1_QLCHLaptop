/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;

/**
 *
 * @author ADMIN
 */
public class viewThongKeDT {
    String thang;
    BigDecimal doanhThu;

    public viewThongKeDT() {
    }

    public viewThongKeDT(String thang, BigDecimal doanhThu) {
        this.thang = thang;
        this.doanhThu = doanhThu;
    }

   
    
    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public BigDecimal getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(BigDecimal doanhThu) {
        this.doanhThu = doanhThu;
    }

    
    
}
