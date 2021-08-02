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
public class TaiKhoan_Pojo {
    private String tenDN,MatKhau,Email;

    public TaiKhoan_Pojo(String tenDN) {
        this.tenDN = tenDN;
    }

    public TaiKhoan_Pojo(String tenDN, String MatKhau, String Email) {
        this.tenDN = tenDN;
        this.MatKhau = MatKhau;
        this.Email = Email;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
}
