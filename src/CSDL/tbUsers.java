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
    public Vector<clsUsers> Layds_Users(){
        Vector<clsUsers> ds = new Vector<>();
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!=null) {
            String sql = "SELECT * FROM tbusers";
            try {
                
                Statement stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    clsUsers user = new clsUsers();
                    user.setid(rs.getInt("id"));
                    user.setuserName(rs.getString("userName"));
                    user.setpass(rs.getString("pass"));
                    user.setrole(rs.getInt("role"));
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
            String sql = "SELECT * FROM tbusers WHERE userName = ? and pass = MD5(?) ";
            try {
                
                PreparedStatement stm = cnn.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, pass);
                
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    clsUsers user = new clsUsers();
                    user.setid(rs.getInt("id"));
                    user.setuserName(rs.getString("userName"));
                    user.setpass(rs.getString("pass"));
                    user.setrole(rs.getInt("role"));
                    ds.add(user);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbUsers.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Lỗi !!!");
            }
            
        }
        return ds;
    }
}
