/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import Config.DBConnect;
import java.sql.*;
import Entity.Model_User;
/**
 *
 * @author Dell
 */
public class Repostitories_Login {
    private Connection con =null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql=null;
    
    
    
    
    
    public Model_User checkLogin(String username,String passs){
        sql="select MaNV,HoTen,role,IDNV from NhanVien where MaNV=? and password=? ";
         Model_User lg = null;
        try {
            con = DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, username);
            ps.setObject(2, passs);
            rs=ps.executeQuery();
            while(rs.next()){
                String ma,ten,role;                              
                ma=rs.getString(1);
                ten=rs.getString(2);
                role=rs.getString(3);
                int id=rs.getInt(4);
                lg = new Model_User(ma, ten, role, passs, id);               
            }
            return lg;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
//    public String role(String username,String pass){
//        sql="select role,HoTen from NhanVien where MaNV=? and password=?";
//        String rolee = null;
//        try {
//            con = DBConnect.getConnection();
//            ps=con.prepareStatement(sql);
//            ps.setObject(1, username);
//            ps.setObject(2, pass);
//            rs=ps.executeQuery();
//            while(rs.next()){
//                
//                rolee=rs.getString(1);                            
//            }
//            
//            return rolee;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
