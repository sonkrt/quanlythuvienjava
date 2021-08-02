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
public class MuonSach_Pojo {
    private String maThe;
    private String maSach;
    private String maThuThu;
    private Date ngayMuon;
    private Date ngayTra;
    private Date hanTra;
    private String tinhTrang;
    private float tienPhat;
    private String ghiChu;

    public MuonSach_Pojo(String maThe, String maSach, Date ngayMuon) {
        this.maThe = maThe;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
    }

    public MuonSach_Pojo(String maThe, String maSach, String maThuThu, Date ngayMuon, Date ngayTra, Date hanTra, String tinhTrang, float tienPhat, String ghiChu) {
        this.maThe = maThe;
        this.maSach = maSach;
        this.maThuThu = maThuThu;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.hanTra = hanTra;
        this.tinhTrang = tinhTrang;
        this.tienPhat = tienPhat;
        this.ghiChu = ghiChu;
    }

    public String getMaThe() {
        return maThe;
    }

    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaThuThu() {
        return maThuThu;
    }

    public void setMaThuThu(String maThuThu) {
        this.maThuThu = maThuThu;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Date getHanTra() {
        return hanTra;
    }

    public void setHanTra(Date hanTra) {
        this.hanTra = hanTra;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public float getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(float tienPhat) {
        this.tienPhat = tienPhat;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
   
}
