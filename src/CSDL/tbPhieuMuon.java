/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSDL;

import Models.clsPhieuMuon;
import Models.clsSach;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public static void InsertPhieu(clsPhieuMuon p) {
        String sql = "insert into PHIEU_MUON values(?,?,?,?,?,?,?,?)";
        try {
            ps = Database.KetnoiCSDL().prepareStatement(sql);
            ps.setInt(1, p.getMaMuon());
            ps.setString(2, p.getMaKhach());
            ps.setString(3, p.getSach());
            ps.setDate(4, p.getNgayMuon());
            ps.setDate(5, p.getHanTra());
            ps.setString(6, "Yasuo 15 GG");
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
            ps.setString(1, p.getMaKhach());
            ps.setString(2, p.getSach());
            ps.setDate(3, p.getNgayMuon());
            ps.setDate(4, p.getHanTra());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeletePhieu(String ms) {
        try {
            ps = Database.KetnoiCSDL().prepareStatement("DELETE FROM PHIEU_MUON WHERE Ma_Phieu_muon = ?");
            ps.setString(1, ms);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
}}
