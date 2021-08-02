/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author Asus
 */
public class NewClass {
    public static void main(String[] args) {
        int countTheLoaiSach = 1000;
        String ma ="";
        if(countTheLoaiSach >= 10000){
            ma = String.valueOf("L" + countTheLoaiSach);
        }
        else if(countTheLoaiSach >= 1000){
            ma = String.valueOf("L0" + countTheLoaiSach);
        }
        else if(countTheLoaiSach >= 100){
            ma = String.valueOf("L00" + countTheLoaiSach);
        }
        else if(countTheLoaiSach >= 10){
            ma = String.valueOf("L000" + countTheLoaiSach);
        }
        else{
            ma = String.valueOf("L0000" + countTheLoaiSach);
        }
        System.out.println(ma);
    }
}
