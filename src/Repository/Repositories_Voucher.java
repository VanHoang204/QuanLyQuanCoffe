package Repository;

import Config.DBConnect;
import Entity.Model_KhuyenMai;
import Entity.Model_Voucher;
import static Repository.Reporitories_KhuyenMai.getAll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class Repositories_Voucher {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<Model_Voucher> getVoucher() {
        sql = "SELECT [IDVC], [MaVC], [TenVC], [PhanTramGiam], [SoLuong], [NgayBatDau], [NgayKetThuc] FROM [Voucher]";
        ArrayList<Model_Voucher> listDM = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idVC = rs.getInt("IDVC"); 
                String MaVC = rs.getString("MaVC");
                String TenVC = rs.getString("TenVC");
                Date ngayBatDau = rs.getDate("NgayBatDau");
                Date ngayKetThuc = rs.getDate("NgayKetThuc");
                int PhanTramGiam = rs.getInt("PhanTramGiam");
                int SoLuong = rs.getInt("SoLuong");

                Model_Voucher dm = new Model_Voucher(idVC, MaVC, TenVC, PhanTramGiam, SoLuong, ngayBatDau, ngayKetThuc, MaVC, MaVC);
                listDM.add(dm);
            }
            rs.close();
            ps.close();
            con.close();
            return listDM;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int themvc(Model_Voucher m) {
        String sql = "INSERT INTO Voucher (TenVC, PhanTramGiam , SoLuong, NgayBatDau, NgayKetThuc) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getTenVC());
            ps.setInt(2, m.getPhanTramGiamGia());
            ps.setInt(3, m.getSoLuong());
            ps.setDate(4, new java.sql.Date(m.getNgayBatDau().getTime()));
            ps.setDate(5, new java.sql.Date(m.getNgayKetThuc().getTime()));

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
public Model_Voucher getVoucherByMa(String ma) {
        sql = "SELECT [IDVC], [MaVC], [TenVC], [PhanTramGiam], [SoLuong], [NgayBatDau], [NgayKetThuc] FROM [Voucher] where MaVC = ?";
        Model_Voucher dm;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idVC = rs.getInt("IDVC");
                String MaVC = rs.getString("MaVC");
                String TenVC = rs.getString("TenVC");
                int PhanTramGiam = rs.getInt("PhanTramGiam");
                int SoLuong = rs.getInt("SoLuong");
                Date ngayBatDau = rs.getDate("NgayBatDau");
                Date ngayKetThuc = rs.getDate("NgayKetThuc");

                dm = new Model_Voucher(idVC, MaVC, TenVC, PhanTramGiam, SoLuong, ngayBatDau, ngayKetThuc, MaVC, MaVC);
                return dm;
                
            }
            rs.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int capNhat(Model_Voucher m) {
        String sql = "UPDATE Voucher SET MaVC=?, TenVC=?, PhanTramGiam =?, SoLuong=?, NgayBatDau=?, NgayKetThuc=? WHERE IDVC=?";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, m.getMaVC());
            ps.setString(2, m.getTenVC());
            ps.setInt(3, m.getPhanTramGiam());
            ps.setInt(4, m.getSoLuong());
            ps.setDate(5, new java.sql.Date(m.getNgayBatDau().getTime()));
            ps.setDate(6, new java.sql.Date(m.getNgayKetThuc().getTime()));
            ps.setInt(7, m.getIdVC()); 

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void delete(String MaVC) {
        String sql = "DELETE FROM Voucher WHERE MaVC=?";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, MaVC);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (Model_KhuyenMai model_Voucher : getAll()) {
            System.out.println(model_Voucher.toString());
        }
    }

   
}
