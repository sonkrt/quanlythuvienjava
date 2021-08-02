/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.TaiKhoan_Pojo;
import Pojo.ThuThu_Pojo;
import Provider.SQLServerProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class TaiKhoan_Dao {
    public static boolean kiemTraTaiKhoan(String tenDN,String matKhau){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("SELECT * FROM TAIKHOAN WHERE TENDN = N'%s' AND MATKHAU = N'%s'", tenDN,matKhau);
        ResultSet rs = provider.executeQuery(sql);
        try {
            if(rs.next()){
                kq = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        provider.close();
        return kq;
    }
    public static ThuThu_Pojo layThongTinThuThu(String tenDN){
        ThuThu_Pojo tt = null;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("SELECT TAIKHOAN.*,MATT,HOTEN,EMAIL,SODT,QUYEN FROM TAIKHOAN,THUTHU WHERE TAIKHOAN.TENDN = THUTHU.TENDN AND TAIKHOAN.TENDN = N'%s'", tenDN);
        ResultSet rs = provider.executeQuery(sql);
        try {
            if(rs.next()){
                tt = new ThuThu_Pojo(rs.getString("MATT"));
                tt.setTaiKhoan(new TaiKhoan_Pojo(rs.getString("TENDN"),rs.getString("MATKHAU"), rs.getString("EMAIL")));
                tt.setSoDT(rs.getString("SODT"));
                tt.setHoTen(rs.getString("HOTEN"));
                tt.setQuyen(rs.getInt("QUYEN"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        provider.close();
        return tt;
    }
    
    public static boolean them(String tenDN,String mk,String email,String maTT,String hoTen,String diaChi,String sdt,String quyen){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("INSERT INTO TAIKHOAN VALUES(N'%s',N'%s','%s');",tenDN,mk,email);
        String sql2 = String.format("INSERT INTO THUTHU VALUES('%s',N'%s',Null,N'%s','%s','%s',%s);", maTT,hoTen,diaChi,sdt,tenDN,quyen);
        int n = provider.executeUpdate(sql);
        int m = provider.executeUpdate(sql2);
        if(n+m == 2){
            kq = true;
        }
        provider.close();
        return kq;
    }
    public static boolean suaTaiKhoan(String tenDN,String maThuThu,String hoTen,String email,String soDT){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("UPDATE TAIKHOAN SET EMAIL = '%s' WHERE TENDN = '%s'",email,tenDN);
        String sql2 = String.format("UPDATE THUTHU SET HOTEN = N'%s',SODT = '%s' WHERE MATT ='%s'", hoTen,soDT,maThuThu);
        int n = provider.executeUpdate(sql);
        int m = provider.executeUpdate(sql2);
        if(n+m == 2){
            kq = true;
        }
        provider.close();
        return kq;
    }
    public static boolean suaMatKhau(String tenDN,String matKhau){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("UPDATE TAIKHOAN SET MATKHAU = '%s' WHERE TENDN = '%s'",matKhau,tenDN);
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
    public static ArrayList<String> layDsMaThuThu(){
        ArrayList<String> list = new ArrayList<>();
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = "SELECT MATT FROM TAIKHOAN,THUTHU WHERE TAIKHOAN.TENDN = THUTHU.TENDN";
        ResultSet rs = provider.executeQuery(sql);
        try {
            while(rs.next()){
                String ma = rs.getString("MATT");
                list.add(ma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        provider.close();
        return list;
    }
    
}
