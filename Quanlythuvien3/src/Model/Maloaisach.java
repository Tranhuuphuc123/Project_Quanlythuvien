/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tran Huu Phuc
 */
public class Maloaisach {
    private String maLoai;
    private String tenLoai;
    
    // contructor

    public Maloaisach() {
    }

    public Maloaisach(String maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }
    
    
    // gets and set

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenloai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
    
}
