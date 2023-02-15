/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tran Huu Phuc
 */
public class Quanlysach_Model {
    private String maSach;
    private String tenSach;
    private String loaiSach;
    private String nhaXuatBan;
    private String tacGia;
    private int soLuong;
    
    // contructor    
    public Quanlysach_Model(String maSach, String tenSach, String loaiSach, String nhaXuatBan, String tacGia, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.loaiSach = loaiSach;
        this.nhaXuatBan = nhaXuatBan;
        this.tacGia = tacGia;
        this.soLuong = soLuong;
    }

    public Quanlysach_Model() {
       
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

    public void setNhaXuatBan(String nXB) {
        this.nhaXuatBan = nXB;
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
