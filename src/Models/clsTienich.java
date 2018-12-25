/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import CSDL.Database;
import CSDL.tbDanhmuc;
import java.awt.Image;
import java.awt.TextField;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Tran Manh Truong
 */
public class clsTienich {
    public static void ComboBox(JComboBox cbb, int i)
    {
       
        cbb.addItem("Chon muc");
        //tạo mảng chứa
       Vector<clsDanhmuc> ds = new Vector<clsDanhmuc>();
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!=null) {
            String sql = "SELECT * FROM tbCategories";
           
                
                Statement stm;
            try {
                stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    String name = rs.getString("Ten_danh_muc");
                    cbb.addItem(name);
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbDanhmuc.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Lỗi kết nối!!");
            }
            
        }
        //chèn các lớp học vào cbbLophoc
        cbb.setSelectedIndex(i);
    }
    
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;
    public static Connection con = Database.KetnoiCSDL();
    
    public static void LoadData (String sql,JTable tb) {
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            tb.setModel((DbUtils.resultSetToTableModel(rs)));
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e ,"Thông báo lỗi",1);
        }
    }
    
    public static ResultSet ShowTextField(String sql) {
        try{
            ps = con.prepareStatement(sql);
            return ps.executeQuery(); 
        }
        catch(Exception e) {
            return null;
            //JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", 1);
        }
    }
    
    
    public static void ShowHinhAnh(File file, JLabel label){
        try {
            Image img = ImageIO.read(file);
            Image img2 = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            
            ImageIcon icon = new ImageIcon(img2);
            label.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(clsTienich.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static File LayHinhAnh(JTextField txtAnh){
        JFileChooser openFile = new JFileChooser();
        
        FileNameExtensionFilter fft =
                new FileNameExtensionFilter("Hình ảnh",new String[]{"jpg","jpeg","gif","png"});
        openFile.addChoosableFileFilter(fft);
       openFile.showOpenDialog(openFile);
       File f = openFile.getSelectedFile();
       txtAnh.setText(f.toString());
        return f;
    }

   
    
}
