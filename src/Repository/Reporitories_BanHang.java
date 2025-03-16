/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Config.DBConnect;
import Entity.Model_HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Entity.Model_HoaDonChiTiet;

/**
 *
 * @author Dell
 */
public class Reporitories_BanHang {
    private Connection con =null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql=null;
    
    
    
    
    
    
    
    public ArrayList<Model_HoaDon> loadHoaDon(){
        sql="SELECT hd.IDHD, hd.MaHD, hd.NgayTao, nv.HoTen, \n" +
"   COALESCE(SUM(ct.SoLuong * ct.GiaBan), 0) AS 'Tổng tiền', -- Sử dụng COALESCE để xử lý trường hợp NULL\\n\" +\n" +
"    tb.TenBan,hd.TrangThai, \n" +
"    COALESCE(vc.PhanTramGiam, 0) AS PhanTramGiam, \n" +
"   kh.HoTen,kh.SDT,nv.MaNV,\n" +
"    COALESCE(SUM(ct.SoLuong * ct.GiaBan), 0) * (1 - COALESCE(vc.PhanTramGiam, 0) / 100.0) AS 'Tổng tiền cần thanh toán',vc.TenVC\n" +
"FROM HoaDon hd\n" +
"LEFT JOIN HoaDonChiTiet ct ON ct.IDHD = hd.IDHD\n" +
"INNER JOIN TheBan tb ON tb.IDTB = hd.IDBan\n" +
"INNER JOIN NhanVien nv ON nv.IDNV = hd.IDNV\n" +
"LEFT JOIN Voucher vc ON vc.IDVC = hd.IDVC\n" +
"LEFT JOIN KhachHang kh ON kh.IDKH = hd.IDKH\n" +
"WHERE hd.TrangThai = 0\n" +
"GROUP BY hd.IDHD,hd.MaHD, hd.NgayTao, nv.HoTen, tb.TenBan, hd.TrangThai, vc.PhanTramGiam, kh.HoTen, kh.SDT,nv.MaNV,vc.TenVC\n" +
"ORDER BY\n" +
"    CASE WHEN hd.TrangThai = 0 THEN 0 ELSE 1 END,\n" +
"    hd.NgayTao DESC;";
        ArrayList<Model_HoaDon> list = new ArrayList<>();
        try {
            con=DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int id,phanTramGiamGia;
                String MaHD,NgayTao,HoTenNV,TenBan,HoTenKhachHang,SDTKH,MaNV;
                Boolean trangThai,HinhThucTT;
                double TongTien;
                
                
                id=rs.getInt(1);
                phanTramGiamGia=rs.getInt(8);
                
                
                MaHD=rs.getString(2);
                NgayTao=rs.getString(3);
                HoTenNV=rs.getString(4);
                TenBan=rs.getString(6);
                HoTenKhachHang=rs.getString(9);
                SDTKH=rs.getString(10);
                MaNV=rs.getString(11);
                
                
                TongTien=rs.getDouble(5);
                trangThai=rs.getBoolean(7);
                double TongCong=rs.getInt(12);
                String TenVC=rs.getString(13);
                
                Model_HoaDon hd = new Model_HoaDon(id, MaHD, TongTien, TenBan, HoTenNV, trangThai, NgayTao, MaNV, phanTramGiamGia, HoTenKhachHang, SDTKH,TongCong,TenVC);
                //ublic Model_HoaDon(int IDHD, String ma, double TongTien, String TenBan, String TenNhanVien, boolean TrangThai, String NgayTao, String MaNV, int PhanTramGiamGia, String TenKhachHang, String SDTKH) {
                list.add(hd);
                
            }
            return list;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int TaoHoaDon(Model_HoaDon hd) throws SQLException {
        con = DBConnect.getConnection();
        if (con == null) {
            throw new SQLException("Ko kết nối được");
        }
        int idKH;
        String sqlCheckKH = "SELECT IDKH FROM KhachHang WHERE SDT = ? OR HoTen = ?";
        ps = con.prepareStatement(sqlCheckKH);
        ps.setString(1, hd.getSDTKH());
        ps.setString(2, hd.getTenKhachHang());
        rs = ps.executeQuery();
        try {
            if (rs.next()) {
                // Khách hàng đã tồn tại
                idKH = rs.getInt("IDKH");
            } else {
                // Khách hàng không tồn tại, thêm mới
                String ThemKH = "INSERT INTO KhachHang (HoTen, SDT) VALUES (?, ?)";
                PreparedStatement psThemKH = con.prepareStatement(ThemKH, Statement.RETURN_GENERATED_KEYS);
                psThemKH.setString(1, hd.getTenKhachHang());
                psThemKH.setString(2, hd.getSDTKH());
                psThemKH.executeUpdate();
                
                // Lấy IDKH của khách hàng mới
                try (ResultSet rs = psThemKH.getGeneratedKeys()) {
                    if (rs.next()) {
                        idKH = rs.getInt(1);
                    } else {
                        throw new SQLException("tạo thất bại");
                    }
                }
            }

            // Thêm hóa đơn với IDKH và lấy ID hóa đơn mới
            String sqlTaoHD = "INSERT INTO HoaDon (IDBan, IDNV, IDKH, IDVC) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sqlTaoHD, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, hd.getIDBan());
                ps.setInt(2, hd.getIdNV());
                ps.setInt(3, idKH);
                ps.setInt(4, hd.getIDvoucher()); // Assuming you have a variable for IDVC
                ps.executeUpdate();
                
                // Lấy IDHD của hóa đơn mới
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idHD = rs.getInt(1);
                        System.out.println("ID của hóa đơn mới là: " + idHD);
                        return idHD; // Trả về ID hóa đơn mới
                    } else {
                        throw new SQLException("Creating invoice failed, no ID obtained.");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null && !con.isClosed()) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public ArrayList<Model_HoaDonChiTiet> getHoaDonChiTiet(int idHD){
        sql="select sp.TenSP,ct.SoLuong,ct.GiaBan,ct.MoTa from HoaDonChiTiet ct\n" +
"inner join SanPham sp on sp.IDSP=ct.IDSP\n" +
"where IDHD = ?";
        ArrayList<Model_HoaDonChiTiet> list = new ArrayList<>();
        try {
            con=DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, idHD);
            rs=ps.executeQuery();
            while(rs.next()){
                
                Model_HoaDonChiTiet ct = new Model_HoaDonChiTiet(rs.getInt(2),rs.getDouble(3),rs.getString(4),rs.getString(1));
                list.add(ct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    public int ThemSanPhamVaoHoaDon(int IDHD,int IDSP,int SoLuong,String MoTa){
        sql="insert into HoaDonChiTiet (IDHD,IDSP,SoLuong,MoTa) values (?,?,?,?)";
        try {
            con=DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, IDHD);
            ps.setObject(2, IDSP);
            ps.setObject(3, SoLuong);
            ps.setObject(4, MoTa);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
   
    
    
}
