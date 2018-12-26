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
public class clsPhieuMuon {
    public int maMuon;
    public int maKhach;
    public int maSach;
    public Date ngayMuon;
    public Date hanTra;
    
    public String tenSach;
    public int gia;
    public String tenKhachhang;
    public int phone;
    
    public clsPhieuMuon() {
        
    }
    
    public clsPhieuMuon(int maMuon, int maKhach, int maSach, Date ngayMuon, Date hanTra) {
        this.maMuon = maMuon;
        this.maKhach = maKhach;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
    }
    
    public int getMaMuon() {
        return maMuon;
    }
    public void setMaMuon(int mm) {
        this.maMuon = mm;
    }
    
    public int getMaKhach() {
        return maKhach;
    }
    public void setMaKhach(int mm) {
        this.maKhach = mm;
    }
    
    public int getSach() {
        return maSach;
    }
    public void setMaSach(int mm) {
        this.maSach = mm;
    }
    
    public Date getNgayMuon() {
        return ngayMuon;
    }
    public void setNgayMuon(Date nm) {
        this.ngayMuon = nm;
    }
    public Date getHanTra() {
        return hanTra;
    }
    public void setHanTra(Date ht) {
        this.hanTra = ht;
    }
    
//    ---------------
     public int getTien() {
        return gia;
    }
    public void setTien(int mm) {
        this.gia = mm;
    }
    
     public int getPhone() {
        return phone;
    }
    public void setPhone(int mm) {
        this.phone = mm;
    }
    
     public String getTensach() {
        return tenSach;
    }
    public void setTensach(String mm) {
        this.tenSach = mm;
    }
    
    public String getTenKhach() {
        return tenKhachhang;
    }
    public void setTenKhach(String mm) {
        this.tenKhachhang = mm;
    }
}
