package Entity;

import java.util.Date;

public class Model_Voucher {
    private int idVC;
    private String MaVC;
    private String TenVC;
    private int PhanTramGiamGia;
    private int SoLuong;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String NgayTao;
    private String NgaySua;

    public Model_Voucher() {
    }

    public Model_Voucher(int idVC, String MaVC, String TenVC, int PhanTramGiamGia, int SoLuong, Date ngayBatDau, Date ngayKetThuc, String NgayTao, String NgaySua) {
        this.idVC = idVC;
        this.MaVC = MaVC;
        this.TenVC = TenVC;
        this.PhanTramGiamGia = PhanTramGiamGia;
        this.SoLuong = SoLuong;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
    }

    public int getIdVC() {
        return idVC;
    }

    public void setIdVC(int idVC) {
        this.idVC = idVC;
    }

    public String getMaVC() {
        return MaVC;
    }

    public void setMaVC(String MaVC) {
        this.MaVC = MaVC;
    }

    public String getTenVC() {
        return TenVC;
    }

    public void setTenVC(String TenVC) {
        this.TenVC = TenVC;
    }

    public int getPhanTramGiamGia() {
        return PhanTramGiamGia;
    }

    public void setPhanTramGiamGia(int PhanTramGiamGia) {
        this.PhanTramGiamGia = PhanTramGiamGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
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
    public String toString() {
        return "Model_Voucher{" +
                "idVC=" + idVC +
                ", MaVC='" + MaVC + '\'' +
                ", TenVC='" + TenVC + '\'' +
                ", PhanTramGiamGia=" + PhanTramGiamGia +
                ", SoLuong=" + SoLuong +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", NgayTao='" + NgayTao + '\'' +
                ", NgaySua='" + NgaySua + '\'' +
                '}';
    }

    public int getPhanTramGiam() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
