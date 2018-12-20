/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSDL;

import static CSDL.tbKhachHang.ps;
import Models.clsAdmin;
import Models.clsKhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gaara
 */
public class tbAdmin {
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    public clsAdmin dangNhap(String taiKhoan, String pass) {
        clsAdmin ad = null;
        try{
            ps = Database.KetnoiCSDL().prepareStatement("SELECT * FROM QUAN_TRI where Ma_Admin = ? and Password=?");
            ps.setString(1, taiKhoan);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()) {
                ad = new clsAdmin();
               // kh.setMaKH(rs.getString("Ma_Khach_hang"));
               // kh.setPass(rs.getString("Password"));
                
            }
        }
        catch(Exception e) {
            return ad = null;
        }
        return ad;
    }
    
    public static ResultSet showTextfield(String sql) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public boolean UpdateAdmin(clsAdmin ad) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("UPDATE QUAN_TRI SET Password = ? where Ma_Admin = ?");
            ps.setString(2, ad.getMaAdmin());
            ps.setString(1, ad.getPassword());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeleteAdmin(String maAd) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("DELETE FROM QUAN_TRI WHERE Ma_Admin = ?");
            ps.setString(1, maAd);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
    }
}
