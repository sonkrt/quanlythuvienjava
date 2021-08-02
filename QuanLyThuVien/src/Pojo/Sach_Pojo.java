/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author ADMIN
 */
public class Sach_Pojo {
    private String maSH;
    private String tenSH;
    private String maLoai;
    private int soLuong;
    private String nhaXB;
    private int namXB;
    private String tacGia;

    public Sach_Pojo(String maSH) {
        this.maSH = maSH;
    }

    public Sach_Pojo(String maSH, String tenSH, String maLoai, int soLuong, String nhaXB, int namXB, String tacGia) {
        this.maSH = maSH;
        this.tenSH = tenSH;
        this.maLoai = maLoai;
        this.soLuong = soLuong;
        this.nhaXB = nhaXB;
        this.namXB = namXB;
        this.tacGia = tacGia;
    }

    public String getMaSH() {
        return maSH;
    }

    public String getTenSH() {
        return tenSH;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getNhaXB() {
        return nhaXB;
    }

    public int getNamXB() {
        return namXB;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setMaSH(String maSH) {
        this.maSH = maSH;
    }

    public void setTenSH(String tenSH) {
        this.tenSH = tenSH;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setNhaXB(String nhaXB) {
        this.nhaXB = nhaXB;
    }

    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    @Override
    public String toString() {
        return this.maSH + " - " + this.tenSH;
    }

      
}
