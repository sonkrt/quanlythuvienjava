/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class SQLServerProvider {
    Connection connection;
      private static String ip = "192.168.1.138";//"";//Thay đổi ipV4 của máy : 192.168.1.8
    private static String port = "1433";//Thay đổi port
    private static String database = "QL_ThuVien_Java";//Tên database
    private static String username = "sa";//username
    private static String password = "123";//password : 0905213883
    private static String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String ulrConnection = "jdbc:sqlserver://localhost;databaseName=QL_ThuVien_Java;integratedSecurity=true";
    public void open(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLServerProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLServerProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void close(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SQLServerProvider.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public ResultSet executeQuery(String query){
        try {
            Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = sta.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(SQLServerProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int executeUpdate(String sql){
        int n = -1;
        try {
            Statement sta = connection.createStatement();
            n = sta.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SQLServerProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
   
}
