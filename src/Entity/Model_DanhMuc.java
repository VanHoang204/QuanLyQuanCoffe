/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Dell
 */
public class Model_DanhMuc {
    private int id;
    private String maDM;
    private String tenDm;
    private boolean trangThai;

    public Model_DanhMuc() {
    }

    public Model_DanhMuc(int id, String maDM, String tenDm, boolean trangThai) {
        this.id = id;
        this.maDM = maDM;
        this.tenDm = tenDm;
        this.trangThai = trangThai;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public String getTenDm() {
        return tenDm;
    }

    public void setTenDm(String tenDm) {
        this.tenDm = tenDm;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    @Override
    public String toString() {
        return tenDm;
    }
    
    
    
}
