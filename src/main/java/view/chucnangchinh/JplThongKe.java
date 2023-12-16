/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.chucnangchinh;

import java.time.LocalTime;
import java.time.ZoneId;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import repositories.ThongKeRepository;
import viewmodel.viewThongKeDT;
import viewmodel.viewThongKeSP;

/**
 *
 * @author ADMIN
 */
public class JplThongKe extends javax.swing.JPanel {

    DefaultTableModel moDel = new DefaultTableModel();
    ThongKeRepository thongke = new ThongKeRepository();

    public JplThongKe() {
        initComponents();
        lblDoanhThu.setText(String.valueOf(thongke.getDoanhThuNgay()) + " VND");
        lblTongHoaDon.setText(String.valueOf(thongke.getSLDonHangNgay()));
        lblKhachHang.setText(String.valueOf(thongke.getSLKhachHangNgay()));
        getNgay();
        jdateNgayDau.setDate(new Date());
        jDateNgayCuoi.setDate(new Date());
    }

    public void getNgay() {
        new Thread() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("MM");
                while (true) {
                    try {
                        Date d = new Date();
                        lblNgay.setText(sdf.format(d));
                    } catch (Exception e) {
                        break;
                    }
                }
            }
        }.start();
    }

    private void loadDataBangSPTK(List<viewThongKeSP> list) {
        moDel = (DefaultTableModel) tblSPTK.getModel();
        moDel.setRowCount(0);
        for (viewThongKeSP sp : list) {
            moDel.addRow(new Object[]{
                sp.getTen(),
                sp.getSoLuongDB()
            });
        }
    }

    private void loadDataBangDTTK(List<viewThongKeDT> list) {
        moDel = (DefaultTableModel) tblDTTK.getModel();
        moDel.setRowCount(0);
        for (viewThongKeDT DT : list) {
            moDel.addRow(new Object[]{
                DT.getThang(),
                DT.getDoanhThu()
            });
        }
    }

    private void setDataToSanPhamTKThang(JPanel jpn, int month, int year) {
        List<viewThongKeSP> listSP = thongke.getSPTKThang(month, year);
        if (listSP != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (viewThongKeSP sptk : listSP) {
                dataset.addValue(sptk.getSoLuongDB(), "Sản phẩm", sptk.getTen());
            }

            JFreeChart chart = ChartFactory.createBarChart("Biểu đồ thống kê số lượng sản phẩm bán được trong tháng " + month + " năm " + year, "Tên sản phẩm", "Số lượng", dataset);

            ChartPanel chartPanel = new ChartPanel(chart);

            jpn.removeAll();
            jpn.setLayout(new CardLayout());
            jpn.add(chartPanel);
            jpn.validate();
            jpn.repaint();
        }
    }

    private void setDataToSanPhamTKNam(JPanel jpn, int year) {
        List<viewThongKeSP> listSP = thongke.getSPTKNam(year);
        if (listSP != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (viewThongKeSP sptk : listSP) {
                dataset.addValue(sptk.getSoLuongDB(), "Sản phẩm", sptk.getTen());
            }

            JFreeChart chart = ChartFactory.createBarChart("Biểu đồ thống kê số lượng sản phẩm bán được trong năm " + year, "Tên sản phẩm", "Số lượng", dataset);

            ChartPanel chartPanel = new ChartPanel(chart);

            jpn.removeAll();
            jpn.setLayout(new CardLayout());
            jpn.add(chartPanel);
            jpn.validate();
            jpn.repaint();
        }
    }

    private void setDataToSanPhamTKNNgay(JPanel jpn, LocalDateTime ngayDau, LocalDateTime ngayCuoi) {
        List<viewThongKeSP> listSP = thongke.getSPTKNgay(ngayDau, ngayCuoi);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (viewThongKeSP sptk : listSP) {
            dataset.addValue(sptk.getSoLuongDB(), "Sản phẩm", sptk.getTen());
        }
        JFreeChart chart = ChartFactory.createBarChart("Biểu đồ thống kê số lượng sản phẩm bán được từ ngày " + ngayDau.toLocalDate() + " đến " + ngayCuoi.toLocalDate(), "Tên sản phẩm", "Số lượng", dataset);

        ChartPanel chartPanel = new ChartPanel(chart);

        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(chartPanel);
        jpn.validate();
        jpn.repaint();

    }

    private void setDataToDoanhThuTKNNgay(JPanel jpn, LocalDateTime ngayDau, LocalDateTime ngayCuoi) {
        List<viewThongKeDT> listDT = thongke.getDTTKNgay(ngayDau, ngayCuoi);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (viewThongKeDT sptk : listDT) {
            dataset.addValue(sptk.getDoanhThu(), "Doanh thu", sptk.getThang());
        }
        JFreeChart chart = ChartFactory.createBarChart("Biểu đồ thống kê số lượng sản phẩm bán được từ ngày " + ngayDau.toLocalDate() + " đến " + ngayCuoi.toLocalDate(), "Doanh thu", "", dataset);

        ChartPanel chartPanel = new ChartPanel(chart);

        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(chartPanel);
        jpn.validate();
        jpn.repaint();

    }

    private void setDataToDoanhThuTKThang(JPanel jpn, int nam) {
        List<viewThongKeDT> listDT = thongke.getDTTKThang(nam);
        if (listDT != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (viewThongKeDT sptk : listDT) {
                dataset.addValue(sptk.getDoanhThu(), "Doanh thu", "Tháng " + sptk.getThang());
            }
            JFreeChart chart = ChartFactory.createBarChart("Biểu đồ thống kê doanh thu của các tháng năm " + nam, "Thời gian", "Doanh thu", dataset);

            ChartPanel chartPanel = new ChartPanel(chart);

            jpn.removeAll();
            jpn.setLayout(new CardLayout());
            jpn.add(chartPanel);
            jpn.validate();
            jpn.repaint();
        }
    }

    private void setDataToDoanhThuTKNam(JPanel jpn) {
        List<viewThongKeDT> listDT = thongke.getDTTKNam();
        if (listDT != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (viewThongKeDT sptk : listDT) {
                dataset.addValue(sptk.getDoanhThu(), "  Doanh thu", "Năm " + sptk.getThang());
            }
            JFreeChart chart = ChartFactory.createBarChart("Biểu đồ thống kê doanh thu theo năm ", "Thời gian", "Doanh thu", dataset);

            ChartPanel chartPanel = new ChartPanel(chart);

            jpn.removeAll();
            jpn.setLayout(new CardLayout());
            jpn.add(chartPanel);
            jpn.validate();
            jpn.repaint();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDoanhThu = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTongHoaDon = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNgay = new javax.swing.JLabel();
        lblTieuDe1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jdateNgayDau = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jDateNgayCuoi = new com.toedter.calendar.JDateChooser();
        jMonth = new com.toedter.calendar.JMonthChooser();
        jYear = new com.toedter.calendar.JYearChooser();
        cboloc = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSPTK = new javax.swing.JTable();
        bieudoSP = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDTTK = new javax.swing.JTable();
        bieudoDT = new javax.swing.JPanel();

        jPanel3.setBackground(new java.awt.Color(255, 230, 234));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jPanel7.setBackground(new java.awt.Color(255, 179, 190));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("DOANH THU");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Doanh thu_1.png"))); // NOI18N

        lblDoanhThu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDoanhThu.setText("jLabel8");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDoanhThu)
                    .addComponent(jLabel2))
                .addGap(77, 77, 77))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblDoanhThu)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 179, 190));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("TỔNG KHÁCH HÀNG");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/khach hang.png"))); // NOI18N

        lblKhachHang.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblKhachHang.setText("jLabel10");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(lblKhachHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblKhachHang)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 179, 190));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("SỐ HOÁ ĐƠN");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/don hang.png"))); // NOI18N

        lblTongHoaDon.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTongHoaDon.setText("jLabel9");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(lblTongHoaDon)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addComponent(lblTongHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(50, 50, 50))
        );

        lblNgay.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNgay.setForeground(new java.awt.Color(102, 102, 102));
        lblNgay.setText(".");

        lblTieuDe1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTieuDe1.setForeground(new java.awt.Color(102, 102, 102));
        lblTieuDe1.setText("DOANH THU TRONG THÁNG: ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTieuDe1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTieuDe1)
                    .addComponent(lblNgay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THỐNG KÊ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel15.setText("Ngày bắt đầu");

        jdateNgayDau.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdateNgayDauPropertyChange(evt);
            }
        });

        jLabel14.setText("Ngày kết thúc");

        jDateNgayCuoi.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateNgayCuoiPropertyChange(evt);
            }
        });

        jMonth.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jMonthPropertyChange(evt);
            }
        });

        jYear.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jYearPropertyChange(evt);
            }
        });

        cboloc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng", "Năm" }));

        jLabel1.setText("Lọc");

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(66, 66, 66)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cboloc, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(366, 366, 366))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdateNgayDau, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateNgayCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addComponent(jMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jYear, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(390, 390, 390))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboloc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdateNgayDau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel14)
                    .addComponent(jDateNgayCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTabbedPane1.setForeground(new java.awt.Color(255, 0, 0));

        tblSPTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSPTK);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Bảng", jPanel5);

        javax.swing.GroupLayout bieudoSPLayout = new javax.swing.GroupLayout(bieudoSP);
        bieudoSP.setLayout(bieudoSPLayout);
        bieudoSPLayout.setHorizontalGroup(
            bieudoSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bieudoSPLayout.setVerticalGroup(
            bieudoSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Biểu đồ", bieudoSP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("SẢN PHẨM", jPanel1);

        tblDTTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Thời gian", "Doanh thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDTTK);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Bảng", jPanel10);

        javax.swing.GroupLayout bieudoDTLayout = new javax.swing.GroupLayout(bieudoDT);
        bieudoDT.setLayout(bieudoDTLayout);
        bieudoDTLayout.setHorizontalGroup(
            bieudoDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bieudoDTLayout.setVerticalGroup(
            bieudoDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Biểu đồ", bieudoDT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("DOANH THU", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jDateDauPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateDauPropertyChange

    }//GEN-LAST:event_jDateDauPropertyChange

    private void jdateNgayDauPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdateNgayDauPropertyChange

    }//GEN-LAST:event_jdateNgayDauPropertyChange

    private void jDateNgayCuoiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateNgayCuoiPropertyChange

    }//GEN-LAST:event_jDateNgayCuoiPropertyChange

    private void jMonthPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jMonthPropertyChange

    }//GEN-LAST:event_jMonthPropertyChange

    private void jYearPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jYearPropertyChange

    }//GEN-LAST:event_jYearPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date ngBD = jdateNgayDau.getDate();
        Date ngKT = jDateNgayCuoi.getDate();

        if (ngBD == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày bắt đầu trước khi tìm!");
            return;
        } else if (ngKT == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày kết thúc trước khi tìm!");
            return;
        }

        if (ngBD.getTime() > ngKT.getTime()) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải trước ngày kết thúc!");
            return;
        }

        if (cboloc.getSelectedItem().equals("Ngày")) {
            LocalDateTime ngayDau = jdateNgayDau.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atTime(LocalTime.of(0, 0, 0));
            LocalDateTime ngayCuoi = jDateNgayCuoi.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atTime(LocalTime.of(23, 59, 59));
            setDataToSanPhamTKNNgay(bieudoSP, ngayDau, ngayCuoi);
            setDataToDoanhThuTKNNgay(bieudoDT, ngayDau, ngayCuoi);
            loadDataBangSPTK(thongke.getBangSPTKNgay(ngayDau, ngayCuoi));
            loadDataBangDTTK(thongke.getBangDTTKNgay(ngayDau, ngayCuoi));

        } else if (cboloc.getSelectedItem().equals("Tháng")) {
            int month = jMonth.getMonth() + 1;
            int year = jYear.getYear();
            setDataToSanPhamTKThang(bieudoSP, month, year);
            setDataToDoanhThuTKThang(bieudoDT, year);
            loadDataBangSPTK(thongke.getBangSPTKThang(month, year));
            loadDataBangDTTK(thongke.getBangDTTKThang(year));

        } else {
            int year = jYear.getYear();
            setDataToSanPhamTKNam(bieudoSP, year);
            setDataToDoanhThuTKNam(bieudoDT);
            loadDataBangSPTK(thongke.getBangSPTKNam(year));
            loadDataBangDTTK(thongke.getBangDTTKNam());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bieudoDT;
    private javax.swing.JPanel bieudoSP;
    private javax.swing.JComboBox<String> cboloc;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateNgayCuoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private com.toedter.calendar.JMonthChooser jMonth;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private com.toedter.calendar.JYearChooser jYear;
    private com.toedter.calendar.JDateChooser jdateNgayDau;
    private javax.swing.JLabel lblDoanhThu;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblNgay;
    private javax.swing.JLabel lblTieuDe1;
    private javax.swing.JLabel lblTongHoaDon;
    private javax.swing.JTable tblDTTK;
    private javax.swing.JTable tblSPTK;
    // End of variables declaration//GEN-END:variables
}
