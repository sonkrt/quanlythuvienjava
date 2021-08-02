/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.DocGia_Pojo;
import Pojo.MuonSach_Pojo;
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
public class MuonSach_Dao {
    public static ArrayList<MuonSach_Pojo> layDsMuonSach(){
        ArrayList<MuonSach_Pojo> list = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM MUONSACH";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                MuonSach_Pojo dg = new MuonSach_Pojo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getDate(5),rs.getDate(6),rs.getString(7),rs.getFloat(8),rs.getString(9));
                list.add(dg);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSach_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static boolean themMuonSach(String maThe,String maSach,String maThuThu){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("INSERT INTO MUONSACH(MATHE,MASH,MATT,NGAYMUON,NGAYTRA,HANTRA,GHICHU) VALUES\n" +
"('%s','%s','%s',GETDATE(),NULL,DATEADD(dd,15,GETDATE()),NULL);",maThe,maSach,maThuThu);
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
    public static boolean  traSach(String maThe,String maSach,String ngayMuon,String tienPhat,String ghiChu){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("UPDATE MUONSACH SET NGAYTRA = GETDATE(),TIENPHAT = %s,GHICHU = N'%s' WHERE MATHE = '%s' AND MASH = '%s' AND NGAYMUON = '%s'", tienPhat,ghiChu,maThe,maSach,ngayMuon);
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
    public static int kiemTraTraSach(String maThe,String maSach,String ngayMuon){
        int n = 0;
        SQLServerProvider provide = new SQLServerProvider();
        provide.open();
        String query = String.format("SELECT DATEDIFF(day,HANTRA,GETDATE()) FROM MUONSACH WHERE MATHE = '%s' AND MASH = '%s' AND NGAYMUON = '%s'", maThe,maSach,ngayMuon);
        ResultSet rs = provide.executeQuery(query);
        try {
            while(rs.next()){
                n = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MuonSach_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        provide.close();
        return n;
    }
    public static ResultSet thongKeMuonSach(){
        ResultSet rs = null;
        SQLServerProvider provide = new SQLServerProvider();
        provide.open();
        String query = "SELECT MONTH(NGAYMUON) AS THANG,COUNT(*) AS SL FROM MUONSACH GROUP BY MONTH(NGAYMUON)";
        rs = provide.executeQuery(query);
       // provide.close();
        return rs;
    }
    //SELECT MATHE FROM THETV WHERE GETDATE() > NGAYHETHAN;
    public static boolean kiemTraHanThe(String maThe){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("SELECT * FROM THETV WHERE MATHE = '%s' AND GETDATE() > NGAYHETHAN", maThe);
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
    public static ArrayList<MuonSach_Pojo> timKiemMuonSach(String content){
        ArrayList<MuonSach_Pojo> list = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM MUONSACH WHERE MATHE LIKE '%' +"+ "'" + content+"'"+ "+ '%' " + "OR MASH LIKE '%' +"+ "'" +content+"'" + "+ '%' " +"OR MATT LIKE '%' +"+ "'" +content+"'" + "+ '%' " +"OR NGAYMUON LIKE '%' +"+ "'" +content+"'" + "+ '%' " +"OR NGAYTRA LIKE '%' +"+ "'" +content+"'" + "+ '%' " +"OR HANTRA LIKE '%' +"+ "'" +content+"'" + "+ '%' "+"OR TINHTRANG LIKE '%' +"+ "N'" +content+"'" + "+ '%'" +"OR TIENPHAT LIKE '%' +"+ "'" +content+"'" + "+ '%'";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                MuonSach_Pojo dg = new MuonSach_Pojo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getDate(5),rs.getDate(6),rs.getString(7),rs.getFloat(8),rs.getString(9));
                list.add(dg);
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSach_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static boolean xoaMuonSach(String maThe,String maSach,String ngayMuon){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("DELETE FROM MUONSACH WHERE MATHE = '%s' AND MASH = '%s' AND NGAYMUON = '%s'", maThe,maSach,ngayMuon);
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
    public static boolean  suaMuonSach(String maThe,String maSach,String ngayMuon,String hanTra,String tienPhat,String ghiChu){
        boolean kq = false;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String sql = String.format("UPDATE MUONSACH SET TIENPHAT = %s,GHICHU = N'%s',HANTRA = '%s' WHERE MATHE = '%s' AND MASH = '%s' AND NGAYMUON = '%s'", tienPhat,ghiChu,hanTra,maThe,maSach,ngayMuon);
        int n = provider.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        provider.close();
        return kq;
    }
}
