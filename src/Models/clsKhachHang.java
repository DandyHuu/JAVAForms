/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;

/**
 *
 * @author Gaara
 */
public class clsKhachHang {
    
    private int maKhachHang;
    private String name;
    private String diaChi;
    private String phone;
    private int Tien_coc;
    
    public clsKhachHang() {
        
    }
    
    public clsKhachHang(int maKH, String name, String diaChi, String phone, int tien) {
        this.maKhachHang = maKH;
//        this.password = password;
        this.name = name;
//        this.birth = birth;
        this.diaChi = diaChi;
        this.phone = phone;
        this.Tien_coc = tien;
    }
    public int getMaKH() {
        return maKhachHang;
    }
    public void setMaKH(int maKH) {
        this.maKhachHang = maKH;
    }
    
//    public String getPass() {
//        return password;
//    }
//    public void setPass(String pass) {
//        this.password = pass;
//    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
//    public Date getBirth() {
//        return birth;
//    }
//    public void setBirth(Date birth) {
//        this.birth = birth;
//    }
    
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diachi) {
        this.diaChi = diachi;
    }
    
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getTienCoc() {
        return Tien_coc;
    }
    public void setTienCoc(int tien) {
        this.Tien_coc = tien;
    }
}
