


package main;

import view.giaodien.FrmDangNhap;

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
            }
        });
    }

}
