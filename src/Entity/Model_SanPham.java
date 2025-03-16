/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Dell
 */
public class Model_SanPham {
    private int IDSP;
    private String MaSP;
    private String TenSP;
    private Double GiaSP;
    private int IDDM;
    private String TenDanhMuc;
    private String HinhAnh;
    private boolean TrangThai;
    private String NgayTao;
    private String NgaySua;
    private int tonKho;

    public int getTonKho() {
        return tonKho;
    }

    public void setTonKho(int tonKho) {
        this.tonKho = tonKho;
    }

   

    public Model_SanPham() {
    }

    public Model_SanPham(int IDSP, String MaSP, String TenSP, Double GiaSP, String TenDanhMuc, String HinhAnh, boolean TrangThai,int tonKho) {
        this.IDSP = IDSP;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.GiaSP = GiaSP;
//        this.IDDM = IDDM;
        this.TenDanhMuc = TenDanhMuc;
        this.HinhAnh = HinhAnh;
        this.TrangThai = TrangThai;
        this.tonKho=tonKho;
    }

    public Model_SanPham(String MaSP,String TenSP, Double GiaSP, int IDDM, String HinhAnh, boolean TrangThai) {
        this.MaSP=MaSP;
        this.TenSP = TenSP;
        this.GiaSP = GiaSP;
        this.IDDM = IDDM;
        this.HinhAnh = HinhAnh;
        this.TrangThai = TrangThai;
    }

    public int getIDSP() {
        return IDSP;
    }

    public void setIDSP(int IDSP) {
        this.IDSP = IDSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public Double getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(Double GiaSP) {
        this.GiaSP = GiaSP;
    }

    public int getIDDM() {
        return IDDM;
    }

    public void setIDDM(int IDDM) {
        this.IDDM = IDDM;
    }

    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    public void setTenDanhMuc(String TenDanhMuc) {
        this.TenDanhMuc = TenDanhMuc;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
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

    
    
    public Object[] toDataRow(){
        return new Object[]{this.getMaSP(),this.getTenSP(),this.getTenDanhMuc(),this.getGiaSP(),this.getTonKho(),this.isTrangThai()?"Đang bán":"Ngưng bán"};
    }
    public Object[] toDataRowBH(){
        return new Object[]{this.MaSP,this.TenSP,this.TenDanhMuc,this.GiaSP};
    }
}
