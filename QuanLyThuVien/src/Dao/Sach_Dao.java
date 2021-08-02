/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.Sach_Pojo;
import Provider.SQLServerProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Sach_Dao {
    public static ArrayList<Sach_Pojo> layDSSach()
    {
        ArrayList<Sach_Pojo> list = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM SACH";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
               Sach_Pojo s = new Sach_Pojo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7));
               list.add(s);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSach_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static boolean themSach(String maSH,String tenSH,String maLoai,String soLuong,String nhaXB,String namXB,String tacGia){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("INSERT INTO SACH VALUES('%s',N'%s','%s',%s,N'%s',%s,N'%s')",maSH,tenSH,maLoai,soLuong,nhaXB,namXB,tacGia);
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
     public static boolean suaSach(String maSach,String tenSach,String maLoai,String soLuong,String nhaXB,String namXB,String tacGia){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("UPDATE SACH SET TENSH=N'%s',MALOAI ='%s',SOLUONG ='%s',NXB =N'%s',NAMXB='%s',TACGIA=N'%s' WHERE MASH='%s'",tenSach,maLoai,soLuong,nhaXB,namXB,tacGia,maSach);
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
     public static boolean xoaSach(String maSH){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("DELETE FROM SACH WHERE MASH ='%s'",maSH);
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
     public static ArrayList<Sach_Pojo> timKiemSach(String content){
        ArrayList<Sach_Pojo> list = new ArrayList<>();
        try {
            String sql ="SELECT * FROM SACH WHERE MASH LIKE '%' +"+ "'" + content+"'"+ "+ '%' " + "OR TENSH LIKE '%' +"+ "N'" +content+"'" + "+ '%' " +"OR MALOAI LIKE '%' +"+ "'" +content+"'" + "+ '%' " +"OR SOLUONG LIKE '%' +"+ "'" +content+"'" + "+ '%' " +"OR NXB LIKE '%' +"+ "N'" +content+"'" + "+ '%' " +"OR NAMXB LIKE '%' +"+ "'" +content+"'" + "+ '%' "+"OR TACGIA LIKE '%' +"+ "N'" +content+"'" + "+ '%'";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                Sach_Pojo tks = new Sach_Pojo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getShort(6),rs.getString(7));
                list.add(tks);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSach_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public static Sach_Pojo laySach1(String ma){
        Sach_Pojo tls = new Sach_Pojo(ma);
        String sql = String.format("SELECT * FROM SACH WHERE MASH = '%s'",ma);
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        ResultSet rs = provider.executeQuery(sql);
        try {
            while(rs.next()){
                tls.setTenSH(rs.getString(2));
            }
            provider.close();
                } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSach_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tls;
    }
     
     public static ArrayList<String> layDsMaSach(){
        ArrayList<String> list = new ArrayList<>();
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = "SELECT MASH FROM SACH";
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
