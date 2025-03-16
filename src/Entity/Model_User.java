/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Dell
 */
public class Model_User {
    private String maNV;
    private String TenNV;
    private String Role;
    private String pass;
    private int IDNV;

    
    public Model_User(String maNV, String TenNV, String Role) {
        this.maNV = maNV;
        this.TenNV = TenNV;
        this.Role = Role;
    }

    public Model_User(String maNV, String TenNV, String Role, String pass, int IDNV) {
        this.maNV = maNV;
        this.TenNV = TenNV;
        this.Role = Role;
        this.pass = pass;
        this.IDNV = IDNV;
    }

    public int getIDNV() {
        return IDNV;
    }

    public void setIDNV(int IDNV) {
        this.IDNV = IDNV;
    }
    

    public Model_User() {
    }

    public Model_User(String maNV) {
        this.maNV = maNV;
    }
    

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Model_User(String maNV, String pass) {
        this.maNV = maNV;
        this.pass = pass;
    }
    
    
    
    
    
    

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
    
    
   public Object[] toData(){
       return new Object[]{this.getMaNV(),this.getTenNV()};
   }
    
    
    
}
