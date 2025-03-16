/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Dell
 */
public class Model_TheBan {
    private int IDBan;
    private String TenBan;
    private String LoaiBan;
    private boolean  trangThai;
    private String NgayTao;
    private String NgaySua;

    public Model_TheBan(int IDBan, String TenBan, String LoaiBan, boolean trangThai, String NgayTao, String NgaySua) {
        this.IDBan = IDBan;
        this.TenBan = TenBan;
        this.LoaiBan = LoaiBan;
        this.trangThai = trangThai;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
    }

    public Model_TheBan() {
    }

    public int getIDBan() {
        return IDBan;
    }

    public void setIDBan(int IDBan) {
        this.IDBan = IDBan;
    }

    public String getTenBan() {
        return TenBan;
    }

    public void setTenBan(String TenBan) {
        this.TenBan = TenBan;
    }

    public String getLoaiBan() {
        return LoaiBan;
    }

    public void setLoaiBan(String LoaiBan) {
        this.LoaiBan = LoaiBan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getNgaySua() {
        return NgaySua;
    }

    public void setNgaySua(String NgaySua) {
        this.NgaySua = NgaySua;
    }
    
    @Override
    public String toString(){
        return TenBan;
    }
    
    
}
