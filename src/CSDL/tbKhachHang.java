/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSDL;

import Models.clsKhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaara
 */
public class tbKhachHang {
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    public clsKhachHang dangNhap(String taiKhoan, String pass) {
        clsKhachHang kh = null;
        try{
            ps = Database.KetnoiCSDL().prepareStatement("SELECT * FROM KHACH_HANG where Ma_Khach_hang = ? and Password=?");
            ps.setString(1, taiKhoan);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()) {
                kh = new clsKhachHang();
               // kh.setMaKH(rs.getString("Ma_Khach_hang"));
               // kh.setPass(rs.getString("Password"));
                kh.setBirth(rs.getDate("Ngay_sinh"));
                kh.setName(rs.getString("Ten_Khach_hang"));
                kh.setDiaChi(rs.getString("Dia_chi"));
                kh.setPhone(rs.getString("Phone"));
            }
        }
        catch(Exception e) {
            return kh = null;
        }
        return kh;
    }
    
    
    public static ResultSet showTextfield(String sql) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    
     public static void InsertKhachHang(clsKhachHang kh) {
        String sql = "insert into KHACH_HANG values(?,?,?,?,?,?,?)";
        try {
            ps = Database.KetnoiCSDL().prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getPass());
            ps.setString(3, kh.getName());
            ps.setDate(4, kh.getBirth());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getPhone());
            ps.setString(7, "Chỗ này thì mô tả j thì mô tả nha mày");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm khách hàng thành công!");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Khách hàng không được thêm" );
        }
    }
    
    public boolean UpdateKhachHang(clsKhachHang kh) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("UPDATE KHACH_HANG SET Password = ?, Ten_Khach_hang = ?,"
                    + "Ngay_sinh = ?, Dia_chi = ?, Phone = ? where Ma_Khach_hang = ?");
            ps.setString(6, kh.getMaKH());
            ps.setString(1, kh.getPass());
            ps.setString(2, kh.getName());
            ps.setDate(3, kh.getBirth());
            ps.setString(4, kh.getDiaChi());
            ps.setString(5, kh.getPhone());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeleteKhachHang(String maKH) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("DELETE FROM KHACH_HANG WHERE Ma_Khach_hang = ?");
            ps.setString(1, maKH);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
    }
    
}
