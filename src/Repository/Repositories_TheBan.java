/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Config.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entity.Model_TheBan;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Repositories_TheBan {
    private Connection con =null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql=null;
    
    
    
    public ArrayList<Model_TheBan> getTheBan(){
        sql="select * from TheBan";
        ArrayList<Model_TheBan> listtb = new ArrayList<>();
        try {
            con=DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                
                
            Model_TheBan tb  = new Model_TheBan(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBoolean(4),rs.getString(5),rs.getString(6));
            listtb.add(tb);
            }
            return listtb;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }      
    }
    
}
