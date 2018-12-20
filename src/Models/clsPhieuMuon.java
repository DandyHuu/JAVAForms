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
    public String maMuon;
    public String maKhach;
    public String maSach;
    public Date ngayMuon;
    public Date hanTra;
    
    public clsPhieuMuon() {
        
    }
    
    public clsPhieuMuon(String maMuon, String maKhach, String maSach, Date ngayMuon, Date hanTra) {
        this.maMuon = maMuon;
        this.maKhach = maKhach;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
    }
    
    public String getMaMuon() {
        return maMuon;
    }
    public void setMaMuon(String mm) {
        this.maMuon = mm;
    }
    
    public String getMaKhach() {
        return maKhach;
    }
    public void setMaKhach(String mm) {
        this.maKhach = mm;
    }
    
    public String getSach() {
        return maSach;
    }
    public void setMaSach(String mm) {
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
    
    
}
