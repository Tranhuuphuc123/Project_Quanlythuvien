/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tran Huu Phuc
 */
public class Quanlybandoc_Model {
    private String maBandoc;
    private String tenBandoc;
    private String CMND;
    private String gioiTinh;
    private String ngayDangky;
    private String ngayHethan;
    
    
    // contructor
    public Quanlybandoc_Model(){
        
    }

    public Quanlybandoc_Model(String maBandoc, String tenBandoc, String CMND, String gioiTinh, String ngayDangky, String ngayHethan) {
        this.maBandoc = maBandoc;
        this.tenBandoc = tenBandoc;
        this.CMND = CMND;
        this.gioiTinh = gioiTinh;
        this.ngayDangky = ngayDangky;
        this.ngayHethan = ngayHethan;
    }
    
    
    
    // get and set

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

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgayDangky() {
        return ngayDangky;
    }

    public void setNgayDangky(String ngayDangky) {
        this.ngayDangky = ngayDangky;
    }

    public String getNgayHethan() {
        return ngayHethan;
    }

    public void setNgayHethan(String ngayHethan) {
        this.ngayHethan = ngayHethan;
    }
    
    
    
}
