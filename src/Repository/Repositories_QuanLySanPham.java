/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import Config.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import Entity.Model_SanPham;
import Entity.Model_DanhMuc;

/**
 *
 * @author Dell
 */
public class Repositories_QuanLySanPham {
//    private DefaultTableModel mol = new DefaultTableModel();
//    private 
//    
    private Connection con =null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql=null;
    
    
    public ArrayList<Model_SanPham> getListSp() {
    // Tạo câu SQL
    String sql = "SELECT sp.IDSP, sp.MaSP, sp.TenSP, sp.GiaSP, dm.TenDM, sp.HinhAnh, sp.TrangThai, "
                 + "COALESCE(MIN(CASE WHEN nl.SoLuong / nlct.SoLuongSuDung < 1 THEN 0 ELSE FLOOR(nl.SoLuong / nlct.SoLuongSuDung) END), 0) AS SoLuongTonKho "
                 + "FROM SanPham sp "
                 + "INNER JOIN DanhMuc dm ON sp.IDDM = dm.IDDM "
                 + "LEFT JOIN NguyenLieuChiTiet nlct ON nlct.IDSP = sp.IDSP "
                 + "LEFT JOIN NguyenLieu nl ON nl.IDNL = nlct.IDNL "
                 + "GROUP BY sp.IDSP, sp.MaSP, sp.TenSP, sp.GiaSP, dm.TenDM, sp.HinhAnh, sp.TrangThai";

    ArrayList<Model_SanPham> list = new ArrayList<>();
 
    try (
        Connection conn = DBConnect.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(sql)) {
        // Thực thi truy vấn
        ResultSet rs = ps.executeQuery();
      
        while (rs.next()) {
            int id = rs.getInt(1);
            String ma = rs.getString(2);
            String ten = rs.getString(3);
            double giaBan = rs.getDouble(4);
            String tendm = rs.getString(5);
            String hinhAnh = rs.getString(6);
            boolean trangThai = rs.getBoolean(7);
            int tonKho = rs.getInt(8);
            Model_SanPham sp = new Model_SanPham(id, ma, ten, giaBan, tendm, hinhAnh, trangThai, tonKho);

            list.add(sp);
        }
        return list;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }       
}


    public ArrayList<Model_DanhMuc> getDanhMuc(){
        sql="select IDDM,MaDM,TenDM,TrangThai from DanhMuc";
        ArrayList<Model_DanhMuc> listDM = new ArrayList<>();
        try {
            con=DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                
                
            Model_DanhMuc dm = new Model_DanhMuc(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBoolean(4));
            listDM.add(dm);
            }
            return listDM;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }      
    }
    public int themSp(Model_SanPham m){
        sql="insert into SanPham(TenSP,GiaSP,IDDM,HinhAnh,TrangThai) values(?,?,?,?,?)";
        try {
            con=DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, m.getTenSP());
            ps.setObject(2, m.getGiaSP());
            ps.setObject(3, m.getIDDM());
            ps.setObject(4, m.getHinhAnh());
            ps.setObject(5, m.isTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int capNhat(Model_SanPham m){
        sql="update SanPham set TenSP=?,GiaSP=?,IDDM=?,HinhAnh=?,TrangThai=? where MaSP=?";
        try {
            con=DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, m.getTenSP());
            ps.setObject(2, m.getGiaSP());
            ps.setObject(3, m.getIDDM());
            ps.setObject(4, m.getHinhAnh());
            ps.setObject(5, m.isTrangThai());
            ps.setObject(6, m.getMaSP());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
//    public ArrayList<Model_SanPham> TimKiem() {
//        // Tao cau sql
//        String sql = "select sp.IDSP,sp.MaSP,sp.TenSP,sp.GiaSP,dm.TenDM,sp.HinhAnh,sp.TrangThai from SanPham sp inner join DanhMuc dm on sp.IDDM=dm.IDDM";
//        ArrayList<Model_SanPham> list = new ArrayList<>();
//        // ket noi co so du lieu va thuc thi truy van
//        try (
//            Connection conn = DBConnect.getConnection(); 
//            PreparedStatement ps = conn.prepareStatement(sql)) {
//            // thuc thi truy van
//            ResultSet rs = ps.executeQuery();
//            // doc tung ban ghi vaf convert sang doi tuong hoa don
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String ma = rs.getString(2);
//                String ten = rs.getString(3);
//                double giaBan = rs.getDouble(4);
//                String Tendm = rs.getString(5);
//                String HinhAnh = rs.getString(6);
//                boolean trangThai = rs.getBoolean(7);
//                
//                Model_SanPham sp = new Model_SanPham(id,ma,ten,giaBan,Tendm,HinhAnh,trangThai);
//                
//                list.add(sp);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//           return null;
//        }       
//    }
   
}
