package Entity;

import java.util.Date;

public class Model_KhuyenMai {
    private int id;
    private String makm;
    private String tenct;
    private String moTa;
    private int phanTram;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int trangthai;
    
    public Model_KhuyenMai() {
    }

    public Model_KhuyenMai(int id, String makm, String tenct, String moTa, int phanTram, Date ngayBatDau, Date ngayKetThuc, int trangthai) {
        this.id = id;
        this.makm = makm;
        this.tenct = tenct;
        this.moTa = moTa;
        this.phanTram = phanTram;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }

    public String getTenct() {
        return tenct;
    }

    public void setTenct(String tenct) {
        this.tenct = tenct;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(int phanTram) {
        this.phanTram = phanTram;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    
//    public Object isTrangThai() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public String toString() {
        return "Model_KhuyenMai{" + "id=" + id + ", makm=" + makm + ", tenct=" + tenct + ", moTa=" + moTa + ", phanTram=" + phanTram + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", trangthai=" + trangthai + '}';
    }

   
    public Date setNgayBatDau(String ngayBD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }

    public void setNgayKetThuc(String ngayKT) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

   

    
    
    
}
