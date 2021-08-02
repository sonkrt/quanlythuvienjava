/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.DocGia_Pojo;
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
public class DocGia_Dao {
    public static ArrayList<DocGia_Pojo> layDsDocGia(){
        ArrayList<DocGia_Pojo> list = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM THETV";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                DocGia_Pojo dg = new DocGia_Pojo(rs.getString("MATHE"));
                dg.setTenDocGia(rs.getString("TENDG"));
                dg.setPhai(rs.getString("PHAI"));
                dg.setSoDT(rs.getString("SODT"));
                dg.setDiaChi(rs.getString("DIACHI"));
                dg.setNgayCap(rs.getDate("NGAYCAP"));
                dg.setNgayHetHan(rs.getDate("NGAYHETHAN"));
                list.add(dg);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSach_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static boolean themDocGia(String maThe,String tenDG,String phai,String sdt,String diaChi){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("INSERT INTO THETV VALUES('%s',N'%s',N'%s','%s',N'%s',GETDATE(),DATEADD(mm,6,GETDATE()))",maThe,tenDG,phai,sdt,diaChi);
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
    
    public static boolean suaDocGia(String maThe,String tenDG,String phai,String sdt,String diaChi){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("UPDATE THETV SET TENDG = N'%s',PHAI = N'%s',SODT='%s',DIACHI=N'%s' WHERE MATHE = '%s'",tenDG,phai,sdt,diaChi,maThe);
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
    public static boolean xoaDocGia(String maThe){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("DELETE FROM THETV WHERE MATHE='%s'", maThe);
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
    public static ArrayList<DocGia_Pojo> timKiemDocGia(String content){
        ArrayList<DocGia_Pojo> list = new ArrayList<>();
        try {
            
            String sql ="SELECT * FROM THETV WHERE MATHE LIKE '%' +"+ "'" + content+"'"+ "+ '%' " + "OR TENDG LIKE '%' +"+ "N'" +content+"'" + "+ '%' " +"OR SODT LIKE '%' +"+ "'" +content+"'" + "+ '%' " +"OR PHAI LIKE '%' +"+ "N'" +content+"'" + "+ '%' " +"OR DIACHI LIKE '%' +"+ "N'" +content+"'" + "+ '%' " +"OR NGAYCAP LIKE '%' +"+ "'" +content+"'" + "+ '%' "+"OR NGAYHETHAN LIKE '%' +"+ "'" +content+"'" + "+ '%'";

            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                DocGia_Pojo dg = new DocGia_Pojo(rs.getString("MATHE"));
                dg.setTenDocGia(rs.getString("TENDG"));
                dg.setPhai(rs.getString("PHAI"));
                dg.setSoDT(rs.getString("SODT"));
                dg.setDiaChi(rs.getString("DIACHI"));
                dg.setNgayCap(rs.getDate("NGAYCAP"));
                dg.setNgayHetHan(rs.getDate("NGAYHETHAN"));
                list.add(dg);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSach_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static ArrayList<DocGia_Pojo> layDSTheHetHan(){
        ArrayList<DocGia_Pojo> list = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM THETV WHERE NGAYHETHAN < GETDATE()";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                DocGia_Pojo dg = new DocGia_Pojo(rs.getString("MATHE"));
                dg.setTenDocGia(rs.getString("TENDG"));
                dg.setPhai(rs.getString("PHAI"));
                dg.setSoDT(rs.getString("SODT"));
                dg.setDiaChi(rs.getString("DIACHI"));
                dg.setNgayCap(rs.getDate("NGAYCAP"));
                dg.setNgayHetHan(rs.getDate("NGAYHETHAN"));
                list.add(dg);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSach_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static boolean giaHanThe(String maThe){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("UPDATE THETV SET NGAYHETHAN = DATEADD(mm,6,GETDATE()) WHERE MATHE = '%s'",maThe);
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
    public static DocGia_Pojo layDocGia1(String ma){
        DocGia_Pojo tls = new DocGia_Pojo(ma);
        String sql = String.format("SELECT * FROM THETV WHERE MATHE = '%s'",ma);
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        ResultSet rs = provider.executeQuery(sql);
        try {
            while(rs.next()){
                tls.setTenDocGia(rs.getString(2));
            }
            provider.close();
                } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSach_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tls;
    }
    public static ArrayList<String> layDsMaDocGia(){
        ArrayList<String> list = new ArrayList<>();
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = "SELECT MATHE FROM THETV";
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
