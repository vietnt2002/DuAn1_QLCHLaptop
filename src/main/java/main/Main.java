package main;

import view.NhanVien.FrmNhanVien;
import view.Quanly.FrmQuanLy;
import views.FrmDangNhap;

/**
 *
 * @author Hello
 */
public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmDangNhap().setVisible(true);
//                new FrmNhanVien().setVisible(true);
            }
        });
    }

}
