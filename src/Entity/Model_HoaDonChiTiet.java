/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Dell
 */
public class Model_HoaDonChiTiet {
    private int IDHDCT;
    private int IDSP;
    private int IDHD;
    private double SoLuong;
    private double GiaBan;
    private String MoTa;
    private String NgayTao;
    private String NgaySua;  
    private String TenSP;

    public Model_HoaDonChiTiet(int IDSP, int IDHD, double SoLuong, double GiaBan, String MoTa) {
        this.IDSP = IDSP;
        this.IDHD = IDHD;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
        this.MoTa = MoTa;
    }

    public Model_HoaDonChiTiet(double SoLuong, double GiaBan, String MoTa, String TenSP) {
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
        this.MoTa = MoTa;
        this.TenSP = TenSP;
    }
    
    
    
    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }
      

    

    public Model_HoaDonChiTiet() {
    }
    
    
    
    

    public int getIDHDCT() {
        return IDHDCT;
    }

    public void setIDHDCT(int IDHDCT) {
        this.IDHDCT = IDHDCT;
    }

    public int getIDSP() {
        return IDSP;
    }

    public void setIDSP(int IDSP) {
        this.IDSP = IDSP;
    }

    public int getIDHD() {
        return IDHD;
    }

    public void setIDHD(int IDHD) {
        this.IDHD = IDHD;
    }

    public double getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(double SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
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
    
    public Object[] toDataHDCT(){
        return new Object[]{this.getTenSP(),this.getSoLuong(),this.getGiaBan(),this.getMoTa()};
    }    
}
