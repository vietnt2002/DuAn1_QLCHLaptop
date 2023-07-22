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
public class ExcelWriter {
    public static void main(String[] args) {
        //        tes1: 
        try {
            Connection connection = DBConnection.getConnection();

            String excelFile = "D:\\Ki_4\\Du_an_1\\Du_lieu\\IMei.xlsx";

            // Mở file Excel
            FileInputStream fis = new FileInputStream(excelFile);
            Workbook workbook = WorkbookFactory.create(fis);

            // Lấy Sheet đầu tiên từ Workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Chuẩn bị câu lệnh SQL INSERT
            String sql = "INSERT INTO IMei (IdChiTietSP, TrangThai) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            // Duyệt qua từng dòng trong Sheet (bắt đầu từ dòng thứ 1, dòng tiêu đề)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                // Đọc giá trị từ các ô trong dòng
                String idChiTietSP = row.getCell(1).getStringCellValue();
                int trangThai = (int) row.getCell(2).getNumericCellValue();
                
                // Thiết lập tham số cho câu lệnh SQL
                ps.setString(1, idChiTietSP);
                ps.setInt(2, trangThai);

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
