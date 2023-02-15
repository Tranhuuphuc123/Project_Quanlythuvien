/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

// dữ liệu cho bảng ListSach
public class Sach_Model {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private String maLoai;
    private Double giaSach;
    private int soLuong;
    
    // contructor

    public Sach_Model(String maSach, String tenSach, String tacGia, String maLoai,Double giaSach, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.maLoai = maLoai;
        this.giaSach = giaSach;
        this.soLuong = soLuong;
    }

    // ham rong de nhan dl nhap vao tu ban phim
 public Sach_Model(){
     
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

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
    
      public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }
    

    public Double getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(Double giaSach) {
        this.giaSach = giaSach;
    }
    
   
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
