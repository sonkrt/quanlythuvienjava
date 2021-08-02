/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.TheLoaiSach_Pojo;
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
public class TheLoaiSach_Dao {
    public static ArrayList<TheLoaiSach_Pojo> layDsTheLoaiSach(){
        ArrayList<TheLoaiSach_Pojo> list = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM THELOAI";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                TheLoaiSach_Pojo tls = new TheLoaiSach_Pojo(rs.getString("MALOAI"),rs.getString("TENLOAI"));
                list.add(tls);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSach_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static boolean themTheLoaiSach(String maTheLoai,String tenTheLoai){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("INSERT INTO THELOAI VALUES(N'%s',N'%s')",maTheLoai,tenTheLoai);
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
    public static boolean xoaTheLoaiSach(String maTheLoaiSach){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("DELETE FROM THELOAI WHERE MALOAI='%s'", maTheLoaiSach);
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
    public static boolean suaTheLoaiSach(String maTheLoaiSachCu,String maTheLoaiSachMoi,String tenTheLoai){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("UPDATE THELOAI SET  MALOAI='%s',TENLOAI=N'%s' WHERE MALOAI='%s'",maTheLoaiSachMoi,tenTheLoai,maTheLoaiSachCu );
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
    public static ArrayList<TheLoaiSach_Pojo> timKiemTheLoaiSach(String content){
        ArrayList<TheLoaiSach_Pojo> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM THELOAI WHERE MALOAI LIKE '%' +"+ "'" + content+"'"+ "+ '%'" +"OR TENLOAI LIKE '%' +"+ "N'" +content+"'" + "+ '%'" ;
            System.out.println(sql);
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                TheLoaiSach_Pojo tls = new TheLoaiSach_Pojo(rs.getString("MALOAI"),rs.getString("TENLOAI"));
                list.add(tls);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSach_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        }
    public static TheLoaiSach_Pojo layTheLoaiSach1(String ma){
        TheLoaiSach_Pojo tls = new TheLoaiSach_Pojo(ma);
        String sql = String.format("SELECT * FROM THELOAI WHERE MALOAI = '%s'",ma);
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        ResultSet rs = provider.executeQuery(sql);
        try {
            while(rs.next()){
                tls.setTheLoai(rs.getString(2));
            }
            provider.close();
                } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSach_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tls;
    }
    public static ArrayList<String> layDsMaTheLoai(){
        ArrayList<String> list = new ArrayList<>();
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = "SELECT MALOAI FROM THELOAI";
        ResultSet rs = provider.executeQuery(sql);
        try {
            while(rs.next()){
                String ma = rs.getString(1);
                list.add(ma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        provider.close();
        return list;
    }
}
