package Model;

public class Sach_Model {
    private String maSach;
    private String tenSach;
    private String loaiSach;
    private String nhaXuatBan;
    private String tacGia;
    private int soLuong;

    // contructor

    public Sach_Model() {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.loaiSach = loaiSach;
        this.nhaXuatBan = nhaXuatBan;
        this.tacGia = tacGia;
        this.soLuong = soLuong;
    }

    // get and set

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String mS) {
        this.maSach = mS;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tS) {
        this.tenSach = tS;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String lS) {
        this.loaiSach = lS;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String Nxb) {
        this.nhaXuatBan = Nxb;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tG) {
        this.tacGia = tG;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int sL) {
        this.soLuong = sL;
    }
}
