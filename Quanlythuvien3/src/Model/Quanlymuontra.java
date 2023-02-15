/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tran Huu Phuc
 */
public class Quanlymuontra {
    private String maSach;
    private String maBandoc;
    private String ngayMuon;
    private String ngayTra;
    private String tinhTrang;
    
    
    // contructor

    public Quanlymuontra() {
    }

    public Quanlymuontra(String maSach, String maBandoc, String ngayMuon, String ngayTra, String tinhTrang) {
        this.maSach = maSach;
        this.maBandoc = maBandoc;
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

    public String getMaBandoc() {
        return maBandoc;
    }

    public void setMaBandoc(String maBandoc) {
        this.maBandoc = maBandoc;
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
