/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author Asus
 */
public class TheLoaiSach_Pojo {
    private String maLoai;
    private String theLoai;

    public TheLoaiSach_Pojo(String maLoai) {
        this.maLoai = maLoai;
    }

    public TheLoaiSach_Pojo(String maLoai, String theLoai) {
        this.maLoai = maLoai;
        this.theLoai = theLoai;
    }


    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    @Override
    public String toString() {
        return this.maLoai + " - " + this.theLoai;
    }
    
}
