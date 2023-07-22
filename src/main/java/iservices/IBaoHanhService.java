/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservices;

import domainmodels.BaoHanh;
import irepositories.*;
import irepositories.ICPURepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilities.DBConnection;
import utilities.ULHelper;

/**
 *
 * @author ADMIN
 */
public interface IBaoHanhService {
    List<BaoHanh> getAll();
    Integer them(BaoHanh baoHanh);
    Integer sua(BaoHanh baoHanh);
    Integer xoa(String ma);
}
