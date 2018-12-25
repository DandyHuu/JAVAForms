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
public class clsNhaXb {
    
    private String maNXB;
    private String tenNXB;
    private String DiaChi;
    private String Email;
    private String Ghichu;
    private String Logo;
    
    
    public clsNhaXb() {
        
    }
    
    public clsNhaXb(String maNXB, String tenNXB, String DiaChi, String Email, String Ghichu,String Logo) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.Ghichu = Ghichu;
        this.Logo = Logo;
    }
    
    public String getMaNXB() {
        return maNXB;
    }
    public void setMaNXB(String m) {
        this.maNXB = m;
    }
    
    public String getTenNXB() {
        return tenNXB;
    }
    public void setTenNXB(String t) {
        this.tenNXB = t;
    }
    public String getDiachi(){
        return DiaChi;
    }
    public void setDiachi(String dc){
        this.DiaChi = dc;
    }
    public String getEmail(){
        return Email;
    }
    public void setEmail(String e){
        this.Email = e;
    }
    public String getGhichu(){
        return Ghichu;
    }
    public void setGhichu(String g){
        this.Ghichu = g;
    }
    
    public String getLogo(){
        return Logo;
    }
    public void setLogo(String lg){
        this.Logo = lg;
    }
    
}
