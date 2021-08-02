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
public class ThuThu_Pojo {
    private  TaiKhoan_Pojo taiKhoan;
    private String maTT;
    private String hoTen;
    private String soDT;
    private int quyen;
    public ThuThu_Pojo(String maTT) {
        this.maTT = maTT;
    }

    public ThuThu_Pojo(TaiKhoan_Pojo taiKhoan, String maTT, String hoTen, String soDT, int quyen) {
        this.taiKhoan = taiKhoan;
        this.maTT = maTT;
        this.hoTen = hoTen;
        this.soDT = soDT;
        this.quyen = quyen;
    }

    public TaiKhoan_Pojo getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan_Pojo taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMaTT() {
        return maTT;
    }

    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public int getQuyen() {
        return quyen;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }

   
    

   
    
}
