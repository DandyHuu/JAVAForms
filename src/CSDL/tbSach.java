/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSDL;

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
public class tbSach {
    
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    public static ResultSet showTextfield(String sql) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    public Vector<clsSach> SelectBookId(int id) {
        Vector<clsSach> ds = new Vector<clsSach>();
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!= null) {
            String sql = "SELECT * FROM SACH";
            if(id > 0){
                sql = "SELECT * FROM SACH WHERE Ma_Sach = "+id;
            }
            try {
                Statement stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next())//duyệt từng bản ghi kết quả select
                {
                    clsSach sv = new clsSach();
                    sv.setMaSach(rs.getString("Ma_Sach"));
                    sv.setTenSach(rs.getString("Ten_Sach"));
                    sv.setTenTacGia(rs.getString("Ten_Tac_gia"));
                    sv.setGiaTien(rs.getInt("Gia_tien"));
                    sv.setNhaXB(rs.getString("Nha_xb"));
                    sv.setSoLuong(rs.getInt("So_luong"));
                    ds.add(sv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbSach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;

    }
    public Vector<clsSach> SearchBook(String name, int cate_id , String author , int price) {
        Vector<clsSach> ds = new Vector<clsSach>();
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!= null) {
            String sql = "";
            if(!name.equals("")){
                if (sql.equals("")) {
                    sql = "SELECT * FROM SACH WHERE Ten_Sach LIKE '%"+name+"%'";
                }
                else{
                    sql += "AND Ten_Sach LIKE '%"+name+"%'";
                }
            }
            if(!author.equals("")){
                if (sql.equals("")) {
                    sql = "SELECT * FROM SACH WHERE Ten_Tac_gia LIKE '%"+author+"%'";
                }
                else{
                    sql += "AND Ten_Tac_gia LIKE '%"+author+"%'";
                }
            }
            if(cate_id > 0){
                if (sql.equals("")) {
                    sql = "SELECT * FROM SACH WHERE id_Danhmuc = "+cate_id;
                }
                else{
                    sql += "AND id_Danhmuc = "+cate_id;
                }
            }
            if(price > 0){
                if (sql.equals("")) {
                    sql = "SELECT * FROM SACH WHERE Gia_tien < "+ price;
                }
                else{
                    sql += "AND Gia_tien < "+ price;
                }
            }
            try {
                Statement stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next())//duyệt từng bản ghi kết quả select
                {
                    clsSach sv = new clsSach();
                    sv.setMaSach(rs.getString("Ma_Sach"));
                    sv.setTenSach(rs.getString("Ten_Sach"));
                    sv.setTenTacGia(rs.getString("Ten_Tac_gia"));
                    sv.setGiaTien(rs.getInt("Gia_tien"));
                    sv.setNhaXB(rs.getString("Nha_xb"));
                    sv.setSoLuong(rs.getInt("So_luong"));
                    ds.add(sv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbSach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;

    }
    
     public static void InsertSach(clsSach s) {
        String sql = "insert into SACH values(?,?,?,?,?,?,?)";
        try {
            ps = Database.KetnoiCSDL().prepareStatement(sql);
            ps.setString(1, s.getMaSach());
            ps.setString(2, s.getTenSach());
            ps.setString(3, s.getTenTacGia());
            ps.setString(4, s.getNhaXB());
            ps.setInt(5, s.getGiaTien());
            ps.setInt(6, s.getSoLuong());
            ps.setString(7, "Yasuo 15 GG");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm sách thành công!" );
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!!" );
        }
    }
    
    public boolean UpdateSach(clsSach s) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("UPDATE SACH SET  Ten_Sach = ?, Ten_Tac_gia = ?,"
                    + "Nha_xb = ?, Gia_tien = ?, So_luong = ? where Ma_Sach = ?");
            ps.setString(6, s.getMaSach());
            ps.setString(1, s.getTenSach());
            ps.setString(2, s.getTenTacGia());
            ps.setString(3, s.getNhaXB());
            ps.setInt(4, s.getGiaTien());
            ps.setInt(5, s.getSoLuong());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeleteSach(String ms) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("DELETE FROM SACH WHERE Ma_Sach = ?");
            ps.setString(1, ms);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
    }
}