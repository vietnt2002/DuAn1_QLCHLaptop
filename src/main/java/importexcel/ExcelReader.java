package importexcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import utilities.DBConnection;

/**
 *
 * @author Hello
 */
public class ExcelReader {

    public static void main(String[] args) {
//        tes1: 
        try {
            Connection connection = DBConnection.getConnection();

            String excelFile = "D:\\Ki_4\\Du_an_1\\Du_lieu\\ChiTietSP.xlsx";

            // Mở file Excel
            FileInputStream fis = new FileInputStream(excelFile);
            Workbook workbook = WorkbookFactory.create(fis);

            // Lấy Sheet đầu tiên từ Workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Chuẩn bị câu lệnh SQL INSERT
            String sql = "INSERT INTO ChiTietSP (IdSP, IdNSX, IdMauSac, IdDongSP, IdCPU, IdRAM, IdSSD, IdManHinh, IdBH, CanNang, MoTa, SoLuongTon, GiaNhap, GiaBan, TrangThai)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            // Duyệt qua từng dòng trong Sheet (bắt đầu từ dòng thứ 1, dòng tiêu đề)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                // Đọc giá trị từ các ô trong dòng
                String idSP = row.getCell(1).getStringCellValue();
                String idNSX = row.getCell(2).getStringCellValue();
                String idMauSac = row.getCell(3).getStringCellValue();
                String idDongSP = row.getCell(4).getStringCellValue();
                String idCPU = row.getCell(5).getStringCellValue();
                String idRAM = row.getCell(6).getStringCellValue();
                String idSSD = row.getCell(7).getStringCellValue();
                String idManHinh = row.getCell(8).getStringCellValue();
                String idBH = row.getCell(9).getStringCellValue();
                float canNang = (float) row.getCell(10).getNumericCellValue();
                String moTa = row.getCell(11).getStringCellValue();
                int soLuongTon = (int) row.getCell(12).getNumericCellValue();
                BigDecimal giaNhap = new BigDecimal(row.getCell(13).getNumericCellValue());
                BigDecimal giaBan = new BigDecimal(row.getCell(14).getNumericCellValue());
                int trangThai = (int) row.getCell(15).getNumericCellValue();
                
                // Thiết lập tham số cho câu lệnh SQL
                ps.setString(1, idSP);
                ps.setString(2, idNSX);
                ps.setString(3, idMauSac);
                ps.setString(4, idDongSP);
                ps.setString(5, idCPU);
                ps.setString(6, idRAM);
                ps.setString(7, idSSD);
                ps.setString(8, idManHinh);
                ps.setString(9, idBH);
                ps.setFloat(10, canNang);
                ps.setString(11, moTa);
                ps.setInt(12, soLuongTon);
                ps.setBigDecimal(13, giaNhap);
                ps.setBigDecimal(14, giaBan);
                ps.setInt(15, trangThai);

                // Thực thi câu lệnh SQL
                ps.executeUpdate();
            }
            System.out.println("INSERT thanh cong");
            // Đóng Workbook, FileInputStream, và PreparedStatement
            workbook.close();
            fis.close();
            ps.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
