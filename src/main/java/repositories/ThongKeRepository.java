/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import utilities.DBConnection;
import viewmodel.viewChiTietHoaDon;
import viewmodel.viewThongKeDT;
import viewmodel.viewThongKeSP;

/**
 *
 * @author ADMIN
 */
public class ThongKeRepository {

    private Connection con = DBConnection.getConnection();

    public List<String> getSLDonHangNgay() {
        List<String> list = new ArrayList<>();
        String sql = "select Count(id) as 'SoLuong' From HoaDon Where Day(NgayThanhToan) = day(GetDate())";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                list.add(RS.getString("SoLuong"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getSLKhachHangNgay() {
        List<String> list = new ArrayList<>();
        String sql = "select Count(Idkh) as 'SoLuong' From HoaDon Where  Day(NgayThanhToan) = day(GetDate())";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                list.add(RS.getString("SoLuong"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getDoanhThuNgay() {
        List<String> list = new ArrayList<>();
        String sql = "Select Sum(ThanhTien) AS 'ThanhTien' from ChiTietHD\n"
                + " Join hoadon on HoaDon.Id = ChiTietHD.IdHD\n"
                + " Where Day(NgayThanhToan) = day(GetDate())";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                list.add(RS.getString("ThanhTien"));
            }
        } catch (Exception e) {
        }
        return list;
    }


    public static void main(String[] args) {
//        ThongKeRepository tk = new ThongKeRepository();
//        List<viewChiTietHoaDon> list = tk.getHoaDon();
//        for (viewChiTietHoaDon chiTietSPView : list) {
//            System.out.println(chiTietSPView.toString());
//        }

    }

    public List<viewThongKeSP> getSPTKThang(int month, int year) {
        List<viewThongKeSP> listSP = new ArrayList<>();
        String sql = "Select SP.Ten,Count(Imei) As 'SLDB' from ChiTietSp CTSP\n"
                + "Join SanPHAm SP On CTSP.IdSP =SP.id \n"
                + "Join ChiTietHD CTHD On CTHD.idCHiTietSP = CTSP.Id\n"
                + "Join ImeiDaBan IDB On CTHD.Id = IDB.IdChiTietHD\n"
                + "Join HoaDon HD On HD.id = CTHD.IdHD\n"
                + "Where IDB.TrangThai = 1 and Month(NgayThanhToan) = ? And Year(NgayThanhToan) = ?\n"
                + "Group by SP.Ten";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, month);
            PS.setObject(2, year);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewThongKeSP sp = new viewThongKeSP();
                sp.setTen(RS.getString("Ten"));
                sp.setSoLuongDB(RS.getInt("SLDB"));
                listSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<viewThongKeSP> getSPTKNam(int year) {
        List<viewThongKeSP> listSP = new ArrayList<>();
        String sql = "Select SP.Ten,Count(Imei) As 'SLDB' from ChiTietSp CTSP\n"
                + "Join SanPHAm SP On CTSP.IdSP =SP.id \n"
                + "Join ChiTietHD CTHD On CTHD.idCHiTietSP = CTSP.Id\n"
                + "Join ImeiDaBan IDB On CTHD.Id = IDB.IdChiTietHD\n"
                + "Join HoaDon HD On HD.id = CTHD.IdHD\n"
                + "Where IDB.TrangThai = 1 And Year(NgayThanhToan) = ?\n"
                + "Group by SP.Ten";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, year);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewThongKeSP sp = new viewThongKeSP();
                sp.setTen(RS.getString("Ten"));
                sp.setSoLuongDB(RS.getInt("SLDB"));
                listSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<viewThongKeSP> getSPTKNgay(LocalDateTime ngayDau, LocalDateTime ngayCuoi) {
        List<viewThongKeSP> listSP = new ArrayList<>();
        String sql = "Select SP.Ten,Count(Imei) As 'SLDB' from ChiTietSp CTSP\n"
                + "Join SanPHAm SP On CTSP.IdSP =SP.id \n"
                + "Join ChiTietHD CTHD On CTHD.idCHiTietSP = CTSP.Id\n"
                + "Join ImeiDaBan IDB On CTHD.Id = IDB.IdChiTietHD\n"
                + "Join HoaDon HD On HD.id = CTHD.IdHD\n"
                + "Where IDB.TrangThai = 1 And NgayThanhToan Between ? and ?\n"
                + "Group by SP.Ten";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, ngayDau);
            PS.setObject(2, ngayCuoi);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewThongKeSP sp = new viewThongKeSP();
                sp.setTen(RS.getString("Ten"));
                sp.setSoLuongDB(RS.getInt("SLDB"));
                listSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<viewThongKeDT> getDTTKThang(int year) {
        List<viewThongKeDT> listDT = new ArrayList<>();
        String sql = " Select month(NgayThanhToan) As 'Thang',Sum(ThanhTien) As 'Doanhthu'\n"
                + " From HoaDOn HD join ChiTietHD CTHD On CTHD.IdHd=HD.id\n"
                + " where Year(NgayThanhToan) = ?\n"
                + " Group by month(NgayThanhToan)";
        try {
            PreparedStatement PS = con.prepareStatement(sql);

            PS.setObject(1, year);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewThongKeDT dt = new viewThongKeDT();
                dt.setThang(RS.getString("Thang"));
                dt.setDoanhThu(RS.getBigDecimal("Doanhthu"));
                listDT.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDT;
    }

    public List<viewThongKeDT> getDTTKNam() {
        List<viewThongKeDT> listDT = new ArrayList<>();
        String sql = " Select year(NgayThanhToan) As 'nam',Sum(ThanhTien) As 'Doanhthu'\n"
                + " From HoaDOn HD join ChiTietHD CTHD On CTHD.IdHd=HD.id\n"
                + " Group by year(NgayThanhToan)";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewThongKeDT dt = new viewThongKeDT();
                dt.setThang(RS.getString("nam"));
                dt.setDoanhThu(RS.getBigDecimal("Doanhthu"));
                listDT.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDT;
    }

    public List<viewThongKeDT> getDTTKNgay(LocalDateTime ngayDau, LocalDateTime ngayCuoi) {
        List<viewThongKeDT> listDT = new ArrayList<>();
        String sql = " Select day(NgayThanhToan) As 'nam',Sum(ThanhTien) As 'Doanhthu'\n"
                + " From HoaDOn HD join ChiTietHD CTHD On CTHD.IdHd=HD.id\n"
                + " where NgayThanhToan Between ? and ?\n"
                + " Group by day(NgayThanhToan)";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, ngayDau);
            PS.setObject(2, ngayCuoi);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewThongKeDT dt = new viewThongKeDT();
                dt.setThang(RS.getString("nam"));
                dt.setDoanhThu(RS.getBigDecimal("Doanhthu"));
                listDT.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDT;
    }
// Bảng

    public List<viewThongKeSP> getBangSPTKThang(int month, int year) {
        List<viewThongKeSP> listSP = new ArrayList<>();
        String sql = "Select SP.Ten,Count(Imei) As 'SLDB' from ChiTietSp CTSP\n"
                + "Join SanPHAm SP On CTSP.IdSP =SP.id \n"
                + "Join ChiTietHD CTHD On CTHD.idCHiTietSP = CTSP.Id\n"
                + "Join ImeiDaBan IDB On CTHD.Id = IDB.IdChiTietHD\n"
                + "Join HoaDon HD On HD.id = CTHD.IdHD\n"
                + "Where IDB.TrangThai = 1 and Month(NgayThanhToan) = ? And Year(NgayThanhToan) = ?\n"
                + "Group by SP.Ten";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, month);
            PS.setObject(2, year);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewThongKeSP sp = new viewThongKeSP();
                sp.setTen(RS.getString("Ten"));
                sp.setSoLuongDB(RS.getInt("SLDB"));
                listSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<viewThongKeSP> getBangSPTKNam(int year) {
        List<viewThongKeSP> listSP = new ArrayList<>();
        String sql = "Select SP.Ten,Count(Imei) As 'SLDB' from ChiTietSp CTSP\n"
                + "Join SanPHAm SP On CTSP.IdSP =SP.id \n"
                + "Join ChiTietHD CTHD On CTHD.idCHiTietSP = CTSP.Id\n"
                + "Join ImeiDaBan IDB On CTHD.Id = IDB.IdChiTietHD\n"
                + "Join HoaDon HD On HD.id = CTHD.IdHD\n"
                + "Where IDB.TrangThai = 1 And Year(NgayThanhToan) = ?\n"
                + "Group by SP.Ten";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, year);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewThongKeSP sp = new viewThongKeSP();
                sp.setTen(RS.getString("Ten"));
                sp.setSoLuongDB(RS.getInt("SLDB"));
                listSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<viewThongKeSP> getBangSPTKNgay(LocalDateTime ngayDau, LocalDateTime ngayCuoi) {
        List<viewThongKeSP> listSP = new ArrayList<>();
        String sql = "Select SP.Ten,Count(Imei) As 'SLDB' from ChiTietSp CTSP\n"
                + "Join SanPHAm SP On CTSP.IdSP =SP.id \n"
                + "Join ChiTietHD CTHD On CTHD.idCHiTietSP = CTSP.Id\n"
                + "Join ImeiDaBan IDB On CTHD.Id = IDB.IdChiTietHD\n"
                + "Join HoaDon HD On HD.id = CTHD.IdHD\n"
                + "Where IDB.TrangThai = 1 And NgayThanhToan Between ? and ?\n"
                + "Group by SP.Ten";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, ngayDau);
            PS.setObject(2, ngayCuoi);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewThongKeSP sp = new viewThongKeSP();
                sp.setTen(RS.getString("Ten"));
                sp.setSoLuongDB(RS.getInt("SLDB"));
                listSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<viewThongKeDT> getBangDTTKThang(int year) {
        List<viewThongKeDT> listDT = new ArrayList<>();
        String sql = " Select month(NgayThanhToan) As 'Thang',Sum(ThanhTien) As 'Doanhthu'\n"
                + " From HoaDOn HD join ChiTietHD CTHD On CTHD.IdHd=HD.id\n"
                + " where Year(NgayThanhToan) = ?\n"
                + " Group by month(NgayThanhToan)";
        try {
            PreparedStatement PS = con.prepareStatement(sql);

            PS.setObject(1, year);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewThongKeDT dt = new viewThongKeDT();
                dt.setThang(RS.getString("Thang"));
                dt.setDoanhThu(RS.getBigDecimal("Doanhthu"));
                listDT.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDT;
    }

    public List<viewThongKeDT> getBangDTTKNam() {
        List<viewThongKeDT> listDT = new ArrayList<>();
        String sql = " Select year(NgayThanhToan) As 'nam',Sum(ThanhTien) As 'Doanhthu'\n"
                + " From HoaDOn HD join ChiTietHD CTHD On CTHD.IdHd=HD.id\n"
                + " Group by year(NgayThanhToan)";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewThongKeDT dt = new viewThongKeDT();
                dt.setThang(RS.getString("nam"));
                dt.setDoanhThu(RS.getBigDecimal("Doanhthu"));
                listDT.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDT;
    }

    public List<viewThongKeDT> getBangDTTKNgay(LocalDateTime ngayDau, LocalDateTime ngayCuoi) {
        List<viewThongKeDT> listDT = new ArrayList<>();
        String sql = " Select day(NgayThanhToan) As 'nam',Sum(ThanhTien) As 'Doanhthu'\n"
                + " From HoaDOn HD join ChiTietHD CTHD On CTHD.IdHd=HD.id\n"
                + " where NgayThanhToan Between ? and ?\n"
                + " Group by day(NgayThanhToan)";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setObject(1, ngayDau);
            PS.setObject(2, ngayCuoi);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                viewThongKeDT dt = new viewThongKeDT();
                dt.setThang(RS.getString("nam"));
                dt.setDoanhThu(RS.getBigDecimal("Doanhthu"));
                listDT.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDT;
    }

}
