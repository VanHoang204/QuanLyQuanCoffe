/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;


/**
 *
 * @author Dell
 */
public class Model_HoaDon {
    private int IDHD;
    private String ma;
    private double TongTienHang;
    private String GioThanhToan;
    private String TenBan;
    private String TenNhanVien;
    private String button;
    private int IDvoucher;
    private int IDBan;
    private int IDKH;
    private boolean TrangThai;
    private int HinhThucThanhToan;
    private String NgayTao;
    private String NgaySua;
    private String MaNV;
    private int PhanTramGiamGia;
    private String TenKhachHang;
    private String SDTKH;
    private int idNV;
    private double TongCong;
    private String TenVC;
    //Model_HoaDon hd = new Model_HoaDon(id,MaHD,NgayTao,HoTenNV,TongTienHang,TenBan,trangThai,phanTramGiamGia,HoTenKhachHang,SDTKH,MaNV);
    public Model_HoaDon(int IDHD, String ma, double TongTienHang, String TenBan, String TenNhanVien, boolean TrangThai, String NgayTao, String MaNV, int PhanTramGiamGia, String TenKhachHang, String SDTKH,double TongCong,String TenVC) {
        this.IDHD = IDHD;
        this.ma = ma;
        this.TongTienHang = TongTienHang;
        this.TenBan = TenBan;
        this.TenNhanVien = TenNhanVien;
        this.TrangThai = TrangThai;
        this.NgayTao = NgayTao;
        this.MaNV = MaNV;
        this.PhanTramGiamGia = PhanTramGiamGia;
        this.TenKhachHang = TenKhachHang;
        this.SDTKH = SDTKH;
        this.TongCong=TongCong;
        this.TenVC=TenVC;
    }
    public Model_HoaDon(int IDvoucher, int IDBan, String TenKhachHang, String SDTKH, int idNV) {
        this.IDvoucher = IDvoucher;
        this.IDBan = IDBan;
        this.TenKhachHang = TenKhachHang;
        this.SDTKH = SDTKH;
        this.idNV = idNV;
    }
    public String getTenVC() {
        return TenVC;
    }
    public void setTenVC(String TenVC) {
        this.TenVC = TenVC;
    }
    public int getIdNV() {
        return idNV;
    }
    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }
    public double getTongCong() {
        return TongCong;
    }
    public void setTongCong(double TongCong) {
        this.TongCong = TongCong;
    }
    public int getPhanTramGiamGia() {
        return PhanTramGiamGia;
    }

    public void setPhanTramGiamGia(int PhanTramGiamGia) {
        this.PhanTramGiamGia = PhanTramGiamGia;
    }

    public String getMaKachHang() {
        return MaKachHang;
    }

    public void setMaKachHang(String MaKachHang) {
        this.MaKachHang = MaKachHang;
    }
    
    private String MaKachHang;

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
    public int getIDHD() {
        return IDHD;
    }
    

    public void setIDHD(int IDHD) {
        this.IDHD = IDHD;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public double getTongTienHang() {
        return TongTienHang;
    }

    public void setTongTienHang(double TongTienHang) {
        this.TongTienHang = TongTienHang;
    }

    public String getGioThanhToan() {
        return GioThanhToan;
    }

    public void setGioThanhToan(String GioThanhToan) {
        this.GioThanhToan = GioThanhToan;
    }

    public String getTenBan() {
        return TenBan;
    }

    public void setTenBan(String TenBan) {
        this.TenBan = TenBan;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public int getIDvoucher() {
        return IDvoucher;
    }

    public void setIDvoucher(int IDvoucher) {
        this.IDvoucher = IDvoucher;
    }

    public int getIDBan() {
        return IDBan;
    }

    public void setIDBan(int IDBan) {
        this.IDBan = IDBan;
    }

    public int getIDKH() {
        return IDKH;
    }

    public void setIDKH(int IDKH) {
        this.IDKH = IDKH;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getSDTKH() {
        return SDTKH;
    }

    public void setSDTKH(String SDTKH) {
        this.SDTKH = SDTKH;
    }

    

    public int getHinhThucThanhToan() {
        return HinhThucThanhToan;
    }

    public void setHinhThucThanhToan(int HinhThucThanhToan) {
        this.HinhThucThanhToan = HinhThucThanhToan;
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

    public Model_HoaDon(String ma, double TongTienHang, String GioThanhToan, String TenBan) {
        this.ma = ma;
        this.TongTienHang = TongTienHang;
        this.GioThanhToan = GioThanhToan;
        this.TenBan = TenBan;
    }

    public Model_HoaDon(int IDHD, String ma, double TongTienHang, String TenBan, String TenNhanVien, String NgayTao) {
        this.IDHD = IDHD;
        this.ma = ma;
        this.TongTienHang = TongTienHang;
        this.TenBan = TenBan;
        this.TenNhanVien = TenNhanVien;
        this.NgayTao = NgayTao;
    }
    
    public Model_HoaDon() {
        
    }

    
    
    public Object[] toDataRowLichSU(){
        return new Object[]{this.getMa(),this.getGioThanhToan(),this.getTongTienHang(),this.TenBan};
    }
    public Object[] toDataRowHoaDon(){
        return new Object[]{this.getMa(),this.getNgayTao(),this.TenNhanVien,this.getTongTienHang(),this.getTongCong(),this.getTenBan(),this.isTrangThai()?"Đã thanh toán":"Chưa thanh toán"};
    }
    
    
    
//    public Object[] toDataHoaDonInBanHang(){
//        return new Object[]{this.getIDHD(),this.getMa(),this.getNgayTao()}
//    }
//    
}
