///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Repository;
//
//import Config.DBConnect;
//import Entity.Model_User;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
///**
// *
// * @author Dell
// */
//public class Repositories_ViewStart {
//    private Connection con =null;
//    private PreparedStatement ps = null;
//    private ResultSet rs = null;
//    private String sql=null;
//    
//    
//    public Model_User getUser(String username,String passs){
//        sql="select MaNV,HoTen from NhanVien where MaNV=? and password=? ";
//        Model_User user = null;
//        try {
//            con = DBConnect.getConnection();
//            ps=con.prepareStatement(sql);
//            ps.setObject(1, username);
//            ps.setObject(2, passs);
//            rs=ps.executeQuery();
//            while(rs.next()){
//                String ma,pass;                                              
//                user = new Model_User(rs.getString(1), rs.getString(2));
//            }
//            return user;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    
//    public Model_User checkLogin(String username,String passs){
//        sql="select MaNV,password from NhanVien where MaNV=? and password=? ";
//        Model_User lg = null;
//        try {
//            con = DBConnect.getConnection();
//            ps=con.prepareStatement(sql);
//            ps.setObject(1, username);
//            ps.setObject(2, passs);
//            rs=ps.executeQuery();
//            while(rs.next()){
//                String ma,pass;                              
//                ma=rs.getString(1);
//                pass=rs.getString(2);
//                lg = new Model_User(ma, pass);
//            }
//            return lg;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    
//    
//    public String role(String username,String pass){
//        sql="select role from NhanVien where MaNV=? and password=?";
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
//    
//}
