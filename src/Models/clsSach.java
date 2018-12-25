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
public class clsSach {
    public int maSach;
    public String tenSach;
    public String tenTacGia;
    public String nhaXB;
    public int giaTien;
    public int soLuong;
    public String Mota;
    public int Idcate;
    
    public clsSach() {
        
    }
    
    public clsSach(int maSach, String tenSach,int Idcate, String tenTacGia, String nhaXB, int giaTien, int soLuong, String Mota) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tenTacGia = tenTacGia;
        this.nhaXB = nhaXB;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
         this.Idcate = Idcate;
        this.Mota = Mota;
    }
    
    public int getMaSach() {
        return maSach;
    }
    
    public void setMaSach(int ms) {
        this.maSach = ms;
    }
    
    public String getTenSach() {
        return tenSach;
    }
    
    public void setTenSach(String ts) {
        this.tenSach = ts;
    }
    
    public String getTenTacGia() {
        return tenTacGia;
    }
    
    public void setTenTacGia(String ttg) {
        this.tenTacGia = ttg;
    }
    
    public String getNhaXB() {
        return nhaXB;
    }
    
    public void setNhaXB(String nxb) {
        this.nhaXB = nxb;
    }
    
    public int getGiaTien() {
        return giaTien;
    }
    
    public void setGiaTien(int gt) {
        this.giaTien = gt;
    }
    
    public int getSoLuong() {
        return soLuong;
    }
    
    public void setIdcate(int id) {
        this.Idcate = id;
    }
    
    public int getIdcate() {
        return Idcate;
    }
    
    public void setSoLuong(int sl) {
        this.soLuong = sl;
    }
    public String getMota() {
        return Mota;
    }
    
    public void setMota(String mota) {
        this.Mota = mota;
    }
}
