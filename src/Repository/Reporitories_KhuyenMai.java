/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Config.DBConnect;
import Entity.Model_HoaDon;
import Entity.Model_KhuyenMai;
import Entity.Model_Voucher;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author ADMIN
 */
public class Reporitories_KhuyenMai {
    public static List<Model_KhuyenMai> getAll() {
        String sql = "SELECT [IDKM], [MaKM], [TenChuongTrinh], [MoTaChuongTrinh], [PhanTramKhuyenMai], [NgayBatDau], [NgayKetThuc], [TrangThai] FROM [KhuyenMai]";
        List<Model_KhuyenMai> list = new ArrayList<>();

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDKM");
                String makm = rs.getString("MaKM");
                String tenct = rs.getString("TenChuongTrinh");
                String mota = rs.getString("MoTaChuongTrinh");
                int phantram = rs.getInt("PhanTramKhuyenMai");
                Date ngayBatDau = rs.getDate("NgayBatDau");
                Date ngayKetThuc = rs.getDate("NgayKetThuc");
                int trangThai = rs.getInt("TrangThai");

                Model_KhuyenMai km = new Model_KhuyenMai(id, makm, tenct, mota, phantram, ngayBatDau, ngayKetThuc, phantram);
                list.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static Model_KhuyenMai getByMaKM(String maKM) {
        String sql = "SELECT [IDKM], [MaKM], [TenChuongTrinh], [MoTaChuongTrinh], [PhanTramKhuyenMai], [NgayBatDau], [NgayKetThuc], [TrangThai] FROM [KhuyenMai] WHERE MaKM = '" + maKM + "'";
        System.out.println(sql);
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idkm = rs.getInt("IDKM");
                String makm = rs.getString("MaKM");
                String tenct = rs.getString("TenChuongTrinh");
                String mota = rs.getString("MoTaChuongTrinh");
                int phantram = rs.getInt("PhanTramKhuyenMai");
                Date ngayBatDau = rs.getDate("NgayBatDau");
                Date ngayKetThuc = rs.getDate("NgayKetThuc");
                int trangThai = rs.getInt("TrangThai");

                return new Model_KhuyenMai(idkm, makm, tenct, mota, phantram, ngayBatDau, ngayKetThuc, phantram);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean existedByMa(String ma) {
        String sql = "SELECT TOP(1) * FROM [KhuyenMai] WHERE MaKm = '" + ma + "'";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int themkm(Model_KhuyenMai m) throws SQLException {
        String sql = "INSERT INTO KhuyenMai (TenChuongTrinh, MoTaChuongTrinh, PhanTramKhuyenMai, NgayBatDau, NgayKetThuc, TrangThai, NgayTao) VALUES(?,?,?,?,?,?,(SELECT CONVERT(date, GETDATE())))";
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, m.getTenct());
        ps.setString(2, m.getMoTa());
        ps.setInt(3, m.getPhanTram());
        ps.setDate(4, new java.sql.Date(m.getNgayBatDau().getTime()));
        ps.setDate(5, new java.sql.Date(m.getNgayKetThuc().getTime()));
        ps.setInt(6, m.getTrangthai());

        return ps.executeUpdate();
    }

    public int capNhat(Model_KhuyenMai m) throws SQLException {
        String sql = "UPDATE KhuyenMai SET TenChuongTrinh=?, MoTaChuongTrinh=?, PhanTramKhuyenMai=?, NgayBatDau=?, NgayKetThuc=?, TrangThai=?, NgaySua=(SELECT CONVERT(date, GETDATE())) WHERE IDKM=?";
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, m.getTenct());
        ps.setString(2, m.getMoTa());
        ps.setInt(3, m.getPhanTram());
        ps.setDate(4, new java.sql.Date(m.getNgayBatDau().getTime()));
        ps.setDate(5, new java.sql.Date(m.getNgayKetThuc().getTime()));
        ps.setInt(6, m.getTrangthai());
        ps.setInt(7, m.getId());
        return ps.executeUpdate();
    }

    public void delete(String MaKm) {
        String sql = "DELETE FROM KhuyenMai WHERE MaKM=?";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, MaKm);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        for (Model_KhuyenMai model_KhuyenMai : getAll()) {
            System.out.println(model_KhuyenMai.toString());
        }
    }
    

    public void update(Model_KhuyenMai model_KhuyenMai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object check(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void them(Object readForm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void sua(String text, Object readForm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void loadTable1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void loadTable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void Add(Model_KhuyenMai model_KhuyenMai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int capNhatkm(Model_KhuyenMai km) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void themvc(Model_Voucher vc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public void capNhat(Model_Voucher form) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Model_Voucher getVoucherByMa(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    Model_HoaDon hd = new Model_HoaDon();

    public List<Model_HoaDon> getlist() {
        String sql = "SELECT IDHD,MaHD,ngaytao, tongtien FROM HoaDon where TrangThai = 0";
        try(Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            
            ResultSet rs = ps.executeQuery();;
            List<Model_HoaDon> List = new ArrayList<>();
            while (rs.next()) {
                Model_HoaDon hd = new Model_HoaDon();
             int id = rs.getInt(1);
             String ma =rs.getString(2);
             Date ngaytao = rs.getDate(3);
             double tongtien =rs.getDouble(4);
                List.add(hd);
            }
            return List;
        } catch (Exception e) {
        }
        return null;
    }

   
}
