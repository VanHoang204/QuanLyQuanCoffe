/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import Config.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import Entity.Model_HoaDon;

/**
 *
 * @author Dell
 */
public class Repositories_LichSuDonHang {
    private Connection con =null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql=null;
    
    public ArrayList<Entity.Model_HoaDon> getLisHoaDon(){
        sql="select hd.MaHD,hd.GioThanhToan,sum(ct.SoLuong*ct.GiaBan) as 'Tổng tiền',tb.TenBan from HoaDonChiTiet ct inner join HoaDon hd \n" +
"on ct.IDHD=hd.IDHD\n" +
"inner join TheBan tb on tb.IDTB=hd.IDBan\n" +
"where hd.TrangThai=1\n" +
"group by hd.MaHD,hd.GioThanhToan,tb.TenBan\n" +
"order by (hd.GioThanhToan) asc";
        ArrayList<Entity.Model_HoaDon> list = new ArrayList<Model_HoaDon>();
        try {
            con=DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                String ma=rs.getString(1);
                String gioTT=rs.getString(2);
                double tongTien=rs.getDouble(3);
                String tenBan=rs.getString(4);                              
                Model_HoaDon hd = new Model_HoaDon(ma, tongTien, gioTT, tenBan);
                list.add(hd);               
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }   
    
    
    
   
}
