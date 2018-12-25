/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSDL;

import Models.clsKhachHang;
import Models.clsSach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaara
 */
public class tbKhachHang {
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    public clsKhachHang dangNhap(String taiKhoan) {
        clsKhachHang kh = null;
        try{
            ps = Database.KetnoiCSDL().prepareStatement("SELECT * FROM KHACH_HANG where Ma_Khach_hang = ?");
            ps.setString(1, taiKhoan);
//            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()) {
                kh = new clsKhachHang();
                kh.setMaKH(rs.getInt("Ma_Khach_hang"));
               // kh.setPass(rs.getString("Password"));
//                kh.setBirth(rs.getDate("Ngay_sinh"));
                kh.setName(rs.getString("Ten_Khach_hang"));
                kh.setDiaChi(rs.getString("Dia_chi"));
                kh.setPhone(rs.getInt("Phone"));
                kh.setTienCoc(rs.getInt("Tien_dat_coc"));
            }
        }
        catch(Exception e) {
            return kh = null;
        }
        return kh;
    }
    public Vector<clsKhachHang> SelectBookId(int id) {
        Vector<clsKhachHang> k = new Vector<clsKhachHang>();
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!= null) {
            String sql = "SELECT * FROM KHACH_HANG";
            if(id > 0){
                sql = "SELECT * FROM SACH WHERE Ma_Khach_hang = "+id;
            }
            try {
                Statement stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next())//duyệt từng bản ghi kết quả select
                {
                    clsKhachHang sv = new clsKhachHang();
                    sv.setMaKH(rs.getInt("Ma_Khach_hang"));
                    sv.setName(rs.getString("Ten_Khach_hang"));
                    sv.setDiaChi(rs.getString("Dia_Chi"));
                    sv.setPhone(rs.getInt("Phone"));
                    sv.setTienCoc(rs.getInt("Tien_dat_coc"));
                    k.add(sv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbSach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return k;

    }
    public Vector<clsKhachHang> SearchKhachhang(String name) {
        Vector<clsKhachHang> k = new Vector<clsKhachHang>();
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!= null) {
            String sql = "SELECT * FROM SACH WHERE Ten_Khach_hang = '%"+name+"%'";
            try {
                Statement stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next())//duyệt từng bản ghi kết quả select
                {
                    clsKhachHang sv = new clsKhachHang();
                    sv.setMaKH(rs.getInt("Ma_Khach_hang"));
                    sv.setName(rs.getString("Ten_Khach_hang"));
                    sv.setDiaChi(rs.getString("Dia_Chi"));
                    sv.setPhone(rs.getInt("Phone"));
                    sv.setTienCoc(rs.getInt("Tien_dat_coc"));
                    k.add(sv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbSach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return k;

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
        String sql = "insert into KHACH_HANG values(?,?,?,?,?)";
        try {
            ps = Database.KetnoiCSDL().prepareStatement(sql);
            ps.setInt(1, kh.getMaKH());
            ps.setString(2, kh.getName());
            ps.setString(3, kh.getDiaChi());
            ps.setInt(4, kh.getPhone());
            ps.setInt(5, kh.getTienCoc());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm khách hàng thành công!");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Khách hàng không được thêm" );
        }
    }
    
    public boolean UpdateKhachHang(clsKhachHang kh) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("UPDATE KHACH_HANG SET Ten_Khach_hang = ?,"
                    + "Dia_chi = ?, Phone = ?, Tien_dat_coc = ? where Ma_Khach_hang = ?");
            ps.setInt(5, kh.getMaKH());
//            ps.setString(1, kh.getPass());
            ps.setString(1, kh.getName());
//            ps.setDate(3, kh.getBirth());
            ps.setString(2, kh.getDiaChi());
            ps.setInt(3, kh.getPhone());
            ps.setInt(4, kh.getTienCoc());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeleteKhachHang(int maKH) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("DELETE FROM KHACH_HANG WHERE Ma_Khach_hang = ?");
            ps.setInt(1, maKH);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
    }
    
}
