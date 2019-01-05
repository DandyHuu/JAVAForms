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
                    sv.setMaSach(rs.getInt("Ma_Sach"));
                    sv.setTenSach(rs.getString("Ten_Sach"));
                    sv.setTenTacGia(rs.getString("Ten_Tac_gia"));
                    sv.setGiaTien(rs.getInt("Gia_tien"));
                    sv.setNhaXB(rs.getString("Nha_xb"));
                    sv.setSoLuong(rs.getInt("So_luong"));
                    sv.setMota(rs.getString("Name"));
                     sv.setIdcate(rs.getInt("id_cate"));
                    ds.add(sv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbSach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;

    }
    public Vector<clsSach> SearchBook(String name, int cate_id , String author , int price1, int price2) {
        Vector<clsSach> ds = new Vector<clsSach>();
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!= null) {
            String sql = "";
            if(!name.equals("")){
                if (sql.equals("")) {
                    sql = "SELECT * FROM SACH WHERE Ten_Sach LIKE '%"+name+"%'";
                }
                else{
                    sql += " AND Ten_Sach LIKE '%"+name+"%'";
                }
            }
            if(!author.equals("")){
                if (sql.equals("")) {
                    sql = "SELECT * FROM SACH WHERE Ten_Tac_gia LIKE '%"+author+"%'";
                }
                else{
                    sql += " AND Ten_Tac_gia LIKE '%"+author+"%'";
                }
            }
            if(cate_id > 0){
                if (sql.equals("")) {
                    sql = "SELECT * FROM SACH WHERE id_cate = "+cate_id;
                }
                else{
                    sql += " AND id_cate = "+cate_id;
                }
            }
            if (price2>0) {
                if(price2 == 100000){
                    if (sql.equals("")) {
                        sql = "SELECT * FROM SACH WHERE Gia_tien < "+ price2;
                    }
                    else{
                        sql += " AND Gia_tien < "+ price2;
                    }
                }
                if(price1 == 100001 && price2 == 200000){
                    if (sql.equals("")) {
                        sql = "SELECT * FROM SACH WHERE Gia_tien BETWEEN "+ price1+" AND "+ price2;
                    }
                    else{
                        sql += " AND Gia_tien BETWEEN "+ price1+" AND "+ price2;
                    }
                }
                 if(price2 > 200000){
                    if (sql.equals("")) {
                        sql = "SELECT * FROM SACH WHERE Gia_tien > "+ price2;
                    }
                    else{
                        sql += " AND Gia_tien > "+ price2;
                    }
                }
            }
            try {
                Statement stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next())//duyệt từng bản ghi kết quả select
                {
                    clsSach sv = new clsSach();
                    sv.setMaSach(rs.getInt("Ma_Sach"));
                    sv.setTenSach(rs.getString("Ten_Sach"));
                    sv.setTenTacGia(rs.getString("Ten_Tac_gia"));
                    sv.setGiaTien(rs.getInt("Gia_tien"));
                    sv.setNhaXB(rs.getString("Nha_xb"));
                    sv.setSoLuong(rs.getInt("So_luong"));
                    sv.setMota(rs.getString("Name"));
                     sv.setIdcate(rs.getInt("id_cate"));
                    ds.add(sv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbSach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;

    }
    
     public static void InsertSach(clsSach s) {
        String sql = "insert into SACH values(?,?,?,?,?,?,?,?)";
        try {
            ps = Database.KetnoiCSDL().prepareStatement(sql);
            ps.setInt(1, s.getMaSach());
            ps.setString(2, s.getTenSach());
            ps.setString(3, s.getTenTacGia());
            ps.setString(4, s.getNhaXB());
            ps.setInt(5, s.getGiaTien());
            ps.setInt(6, s.getSoLuong());
            ps.setString(7, s.getMota());
            ps.setInt(8, s.getIdcate());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm sách thành công!" );
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!!" );
        }
    }
    
    public boolean UpdateSach(clsSach s) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("UPDATE SACH SET  Ten_Sach = ?, Ten_Tac_gia = ?,"
                    + " Nha_xb = ?, Gia_tien = ?, So_luong = ?,Name = ? , id_cate = ? where Ma_Sach = ?");
            ps.setInt(8, s.getMaSach());
            ps.setString(1, s.getTenSach());
            ps.setString(2, s.getTenTacGia());
            ps.setString(3, s.getNhaXB());
            ps.setInt(4, s.getGiaTien());
            ps.setInt(5, s.getSoLuong());
            ps.setString(6, s.getMota());
             ps.setInt(7, s.getIdcate());
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
