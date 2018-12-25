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
    
    public String Ma_Khach_hang;
    public String Password;
    public String Ten_Khach_hang;
    public Date Ngay_sinh;
    public String Dia_chi;
    public String Phone;
    
    public clsKhachHang() {
        Ma_Khach_hang = "";
        Password = "";
        Ten_Khach_hang = "";
        Ngay_sinh = null;
        Dia_chi = "";
        Phone = "";
    }
    
    public clsKhachHang(String Ma_Khach_hang, String Password, String Ten_Khach_hang, Date Ngay_sinh, String Dia_chi, String Phone) {
        this.Ma_Khach_hang = Ma_Khach_hang;
        this.Password = Password;
        this.Ten_Khach_hang = Ten_Khach_hang;
        this.Ngay_sinh = Ngay_sinh;
        this.Dia_chi = Dia_chi;
        this.Phone = Phone;
    }
    public String getMaKH() {
        return Ma_Khach_hang;
    }
    public void setMaKH(String Ma_Khach_hang) {
        this.Ma_Khach_hang = Ma_Khach_hang;
    }
    
    public String getPass() {
        return Password;
    }
    public void setPass(String Password) {
        this.Password = Password;
    }
    
    public String getName() {
        return Ten_Khach_hang;
    }
    public void setName(String Ten_Khach_hang) {
        this.Ten_Khach_hang = Ten_Khach_hang;
    }
    
    public Date getBirth() {
        return Ngay_sinh;
    }
    public void setBirth(Date Ngay_sinh) {
        this.Ngay_sinh = Ngay_sinh;
    }
    
    public String getDiaChi() {
        return Dia_chi;
    }
    public void setDiaChi(String Dia_chi) {
        this.Dia_chi = Dia_chi;
    }
    
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
}
