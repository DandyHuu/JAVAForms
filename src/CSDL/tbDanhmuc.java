/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSDL;

import Models.clsDanhmuc;
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
 * @author admin
 */
public class tbDanhmuc {
    public static PreparedStatement ps;
    public static ResultSet rs;
    public Vector<clsDanhmuc> Layds_Cate(){
        Vector<clsDanhmuc> ds = new Vector<clsDanhmuc>();
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!=null) {
            String sql = "SELECT * FROM tbCategories";
           
                
                Statement stm;
            try {
                stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    clsDanhmuc dm = new clsDanhmuc();
                    dm.setID(rs.getInt("id"));
                    dm.setDanhmuc(rs.getString("Ten_danh_muc"));
                    
                    ds.add(dm);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbDanhmuc.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Lỗi kết nối!!");
            }
            
        }
        return ds;
    }
    
    public Vector<clsDanhmuc> Layds_Cate_ID(int id){
        Vector<clsDanhmuc> ds = new Vector<clsDanhmuc>();
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!=null) {
            String sql = "SELECT * FROM tbCategories WHERE id = "+id;
           
                
                Statement stm;
            try {
                stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    clsDanhmuc dm = new clsDanhmuc();
                    dm.setID(rs.getInt("id"));
                    dm.setDanhmuc(rs.getString("Ten_danh_muc"));
                    
                    ds.add(dm);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbDanhmuc.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Lỗi kết nối!!");
            }
            
        }
        return ds;
    }
      public static void InsertCate(clsDanhmuc d) {
        String sql = "insert into tbCategories values(?,?)";
        try {
            ps = Database.KetnoiCSDL().prepareStatement(sql);
            ps.setInt(1, d.getID());
            ps.setString(2, d.getTendanhmuc());
          
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm danh mục thành công!" );
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Danh mục không được trùng nhau!!" );
        }
    }
    
    public boolean UpdateCate(clsDanhmuc d) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("UPDATE tbCategories SET  Ten_danh_muc = ? where id = ?");
            ps.setInt(2, d.getID());
            ps.setString(1, d.getTendanhmuc());
           
          
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeleteCate(int ms) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("DELETE FROM tbCategories WHERE id = ?");
            ps.setInt(1, ms);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
    }
}
