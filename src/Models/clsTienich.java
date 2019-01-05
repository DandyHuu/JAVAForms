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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
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
    public static void ComboBoxSach(JComboBox cbb, int i)
    {
        cbb.removeAllItems();
        cbb.insertItemAt("Chon danh muc",0);

       Vector<clsDanhmuc> ds = new Vector<clsDanhmuc>();
      
        Connection cnn = Database.KetnoiCSDL();
        if (cnn!=null) {
            String sql = "SELECT * FROM danh_muc ";
                Statement stm;
            try {
                stm = cnn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    cbb.addItem(rs.getString("Ten_Danh__Muc"));
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(tbDanhmuc.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Lỗi kết nối!!");
            }
            
        }
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
        if (f != null) {
            String strTenNgaunhien = clsTienich.randomString(20);
            String strDuoitep = clsTienich.TypeFile(f.getName());
            String strTenTepAnh = strTenNgaunhien + "." + strDuoitep;
            txtAnh.setText(strTenTepAnh);
        }
      
        return f;
    }
    public static String randomString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }
    public static String TypeFile(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i >= 0) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }
    
    public static String SaveAnh(File ImageFile , String tenAnh){
       String filecopy = "";
       if (ImageFile != null) {
                //String img = ImageFile.getName();
                 filecopy = "src/Image/" + tenAnh;
                File fc = new File(filecopy);
           try {
               Files.copy(ImageFile.toPath(), fc.toPath(),StandardCopyOption.REPLACE_EXISTING);
           } catch (IOException ex) {
               Logger.getLogger(clsTienich.class.getName()).log(Level.SEVERE, null, ex);
           }
                    
       }
       return filecopy;
    }
   
    
}
