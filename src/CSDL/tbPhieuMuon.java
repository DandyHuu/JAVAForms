/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSDL;

import Models.clsPhieuMuon;
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
public class tbPhieuMuon {
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
    
    public Vector<clsPhieuMuon> Layds_Phieumuon(){
        Vector<clsPhieuMuon> ds = new Vector<clsPhieuMuon>();
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!=null) {
            String sql = "SELECT * FROM phieu_muon INNER JOIN sach ON phieu_muon.Ma_Sach = sach.Ma_Sach INNER "
                    + "JOIN khach_hang ON phieu_muon.Ma_Khach_hang = khach_hang.Ma_Khach_hang";
           
                
                Statement stm;
            try {
                stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    clsPhieuMuon pm = new clsPhieuMuon();
                    pm.setMaMuon(rs.getInt("Ma_Phieu_muon"));
                    pm.setTensach(rs.getString("Ten_Sach"));
                    pm.setTenKhach(rs.getString("Ten_Khach_hang"));
                    pm.setPhone(rs.getInt("Phone"));
                    pm.setNgayMuon(rs.getDate("Ngay_muon"));
                    pm.setHanTra(rs.getDate("Han_tra"));
                    pm.setTien(rs.getInt("Tien_dat_coc"));
                    
                    ds.add(pm);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Lỗi kết nối!!");
            }
            
        }
        return ds;
    }
    
    
    public static void InsertPhieu(clsPhieuMuon p) {
        String sql = "insert into PHIEU_MUON values(?,?,?,?,?,?)";
        
        try {
            ps = Database.KetnoiCSDL().prepareStatement(sql);
            ps.setInt(1, p.getMaMuon());
            ps.setInt(2, p.getMaKhach());
            ps.setInt(3, p.getSach());
            ps.setDate(4, p.getNgayMuon());
            ps.setDate(5, p.getHanTra());
             ps.setDate(6, p.getHanTra());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm phiếu thành công!" );
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "phiếu không được thêm" );
        }
    }
    
    public boolean UpdatePhieu(clsPhieuMuon p) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("UPDATE PHIEU_MUON SET  Ma_Khach_hang = ?, Ma_Sach = ?,"
                    + "Ngay_muon = ?, Han_tra = ? where Ma_Phieu_muon = ?");
            ps.setInt(5, p.getMaMuon());
            ps.setInt(1, p.getMaKhach());
            ps.setInt(2, p.getSach());
            ps.setDate(3, p.getNgayMuon());
            ps.setDate(4, p.getHanTra());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeletePhieu(int ms) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("DELETE FROM PHIEU_MUON WHERE Ma_Phieu_muon = ?");
            ps.setInt(1, ms);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
}}
