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
    
    public String maNXB;
    public String tenNXB;
    
    public clsNhaXb() {
        
    }
    
    public clsNhaXb(String maNXB, String tenNXB) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
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
    
}