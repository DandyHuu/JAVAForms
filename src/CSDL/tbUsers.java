/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSDL;

import Models.clsUsers;
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
public class tbUsers {
    public static PreparedStatement ps;
    public static ResultSet rs;
    public Vector<clsUsers> Layds_Users(){
        Vector<clsUsers> ds = new Vector<clsUsers>();
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!=null) {
            String sql = "SELECT * FROM quan_tri";
            try {
                
                Statement stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    clsUsers user = new clsUsers();
                    user.setid(rs.getInt("Ma_admin"));
                    user.setTennguoidung(rs.getString("Ten_nguoi_dung"));
                    user.setuserName(rs.getString("Ten_dang_nhap"));
                    user.setpass(rs.getString("Password"));
                    user.setrole(rs.getInt("Role"));
                     user.setAvatar(rs.getString("Avatar"));
                    user.setPhone(rs.getString("Phone"));
                    ds.add(user);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbUsers.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Lỗi !!!");
            }
            
        }
        return ds;
    }
    
    public Vector<clsUsers> SearchUser(String name){
        Vector<clsUsers> ds = new Vector<>();
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!=null) {
            String sql = "SELECT * FROM quan_tri WHERE Ten_nguoi_dung LIKE '"+name+"'";
            try {
                
                Statement stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    clsUsers user = new clsUsers();
                    user.setid(rs.getInt("Ma_admin"));
                    user.setTennguoidung(rs.getString("Ten_nguoi_dung"));
                    user.setuserName(rs.getString("Ten_dang_nhap"));
                    user.setpass(rs.getString("Password"));
                    user.setrole(rs.getInt("Role"));
                   user.setAvatar(rs.getString("Avatar"));
                    user.setPhone(rs.getString("Phone"));
                    ds.add(user);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbUsers.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Lỗi !!!");
            }
            
        }
        return ds;
    }
    
    public Vector<clsUsers> CheckUsers(String name , String pass){
        Vector<clsUsers> ds = new Vector<>();
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!=null) {
            String sql = "SELECT * FROM quan_tri WHERE Ten_dang_nhap = '"+name+"' and Password = '"+pass+"'";
            try {
                
                
                Statement stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    clsUsers user = new clsUsers();
                    user.setid(rs.getInt("Ma_admin"));
                    user.setTennguoidung(rs.getString("Ten_nguoi_dung"));
                    user.setuserName(rs.getString("Ten_dang_nhap"));
                    user.setpass(rs.getString("Password"));
                    user.setrole(rs.getInt("Role"));
                    user.setAvatar(rs.getString("Avatar"));
                    user.setPhone(rs.getString("Phone"));
                    ds.add(user);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbUsers.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Lỗi đăng nhập!!!");
            }
            
        }
        return ds;
    }
    
         public static boolean InsertUsers(clsUsers u) {
        String sql = "insert into quan_tri values(?,?,?,?,?,?,?)";
        try {
            ps = Database.KetnoiCSDL().prepareStatement(sql);
            ps.setInt(1, u.getid());
            ps.setString(2, u.getTennguoidung());
            ps.setString(3, u.getuserName());
            ps.setString(4, u.getpass());
             ps.setString(5, u.getAvatar());
              ps.setString(6, u.getPhone());
             ps.setInt(7, u.getrole());

           
            ps.execute();
            return true;
        } catch(Exception e) {
           return false;
        }
    }
    
    public boolean UpdateUsers(clsUsers u) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("UPDATE quan_tri SET  Ten_nguoi_dung = ?, Ten_dang_nhap = ?,"
                    + "Password = ?, Role = ?,Avatar = ? , Phone = ? where Ma_Admin = ?");
            ps.setInt(7, u.getid());
            ps.setString(1, u.getTennguoidung());
            ps.setString(2, u.getuserName());
            ps.setString(3, u.getpass());
            ps.setInt(4, u.getrole());
            ps.setString(5, u.getAvatar());
            ps.setString(6, u.getPhone());
          
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean UpdatePassUsers(int id , String u) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("UPDATE quan_tri SET Password = ? where Ma_Admin = ?");
            ps.setInt(2, id);
            ps.setString(1, u);
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeleteUsers(int ms) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("DELETE FROM QUAN_TRI WHERE Ma_admin = ?");
            ps.setInt(1, ms);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
    }
}
