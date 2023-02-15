/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tran Huu Phuc
 */
public class Quanlytiemkiem {
    private String maSach;
    private String tenSach;
    private String maBandoc;
    private String tenBandoc;
    private String ngayMuon;
    private String ngayTra;
    private String tinhTrang;
    
    //contructor

    public Quanlytiemkiem() {
    }

    public Quanlytiemkiem(String maSach, String tenSach, String maBandoc, String tenBandoc, String ngayMuon, String ngayTra, String tinhTrang) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maBandoc = maBandoc;
        this.tenBandoc = tenBandoc;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.tinhTrang = tinhTrang;
    }
    
    // get and set

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaBandoc() {
        return maBandoc;
    }

    public void setMaBandoc(String maBandoc) {
        this.maBandoc = maBandoc;
    }

    public String getTenBandoc() {
        return tenBandoc;
    }

    public void setTenBandoc(String tenBandoc) {
        this.tenBandoc = tenBandoc;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
}
