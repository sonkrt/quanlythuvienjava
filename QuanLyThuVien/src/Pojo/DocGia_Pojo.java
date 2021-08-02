/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.sql.Date;

/**
 *
 * @author Asus
 */
public class DocGia_Pojo {
        private String maThe;
        private String tenDocGia;
        private String phai;
        private String soDT;
        private String diaChi;
        private Date ngayCap;
        private Date ngayHetHan;

    public DocGia_Pojo(String maThe) {
        this.maThe = maThe;
    }

    public DocGia_Pojo(String maThe, String tenDocGia, String phai, String soDT, String diaChi, Date ngayCap, Date ngayHetHan) {
        this.maThe = maThe;
        this.tenDocGia = tenDocGia;
        this.phai = phai;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.ngayCap = ngayCap;
        this.ngayHetHan = ngayHetHan;
    }

    public String getMaThe() {
        return maThe;
    }

    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    @Override
    public String toString() {
        return this.maThe + " - " + this.tenDocGia;
    }
        


  
}
