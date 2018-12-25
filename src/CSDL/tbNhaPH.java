/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSDL;

import Models.clsNhaXb;
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
 * @author Admin
 */
public class tbNhaPH {
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
    public Vector<clsNhaXb> SelectNXBId(int id) {
        Vector<clsNhaXb> ds = new Vector<clsNhaXb>();
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!= null) {
            String sql = "SELECT * FROM NHA_PH";
            if(id > 0){
                sql = "SELECT * FROM NHA_PH WHERE Ma_NXB = "+id;
            }
            try {
                Statement stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next())//duyệt từng bản ghi kết quả select
                {
                    clsNhaXb sv = new clsNhaXb();
                    sv.setMaNXB(rs.getInt("Ma_NXB"));
                    sv.setTenNXB(rs.getString("Ten_NXB"));
                    sv.setDiachi(rs.getString("Dia_Chi"));
                    sv.setEmail(rs.getString("Email"));
                    sv.setGhichu(rs.getString("Ghi_Chu"));
                    sv.setLogo(rs.getString("Logo"));
                    ds.add(sv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbNhaPH.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ds;

    }
    public static void InsertNhaPH(clsNhaXb ph) {
        String sql = "insert into NHA_PH values(?,?,?,?,?,?)";
        try {
            ps = Database.KetnoiCSDL().prepareStatement(sql);
            ps.setInt(1, ph.getMaNXB());
            ps.setString(2, ph.getTenNXB());
            ps.setString(3, ph.getDiachi());
            ps.setString(4, ph.getEmail());
            ps.setString(5, ph.getGhichu());
             ps.setString(6, ph.getLogo());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm Nhà phát hành thành công!" );
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "NPH không được thêm" );
        }
    }
    
    public boolean UpdateNhaPH(clsNhaXb ph) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("UPDATE NHA_PH SET  Ten_NXB = ?, Dia_Chi = ?,"
                    + "Email = ?, Ghi_Chu = ? where Ma_NXB = ?");
            ps.setInt(6, ph.getMaNXB());
            ps.setString(1, ph.getTenNXB());
            ps.setString(2, ph.getDiachi());
            ps.setString(3, ph.getEmail());
            ps.setString(4, ph.getGhichu());
             ps.setString(5, ph.getLogo());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeleteNhaPH(String ms) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("DELETE FROM NHA_PH WHERE Ma_NXB = ?");
            ps.setString(1, ms);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
    }
}
