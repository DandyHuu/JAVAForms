/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Image;
import java.awt.TextField;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Tran Manh Truong
 */
public class clsTienich {
//    public static void ComboBoxLophoc(JComboBox cbb, int chonmalop)
//    {
//        //tạo mảng chứa các lớp học
//        tbLophoc bangLophoc = new tbLophoc();
//        Vector<clsLophoc> dsLophoc = bangLophoc.LayDSLop();
//       
//        //chèn các lớp học vào cbbLophoc
//        DefaultComboBoxModel cbm = new DefaultComboBoxModel(dsLophoc);
//        
//        cbb.setModel(cbm);
//        cbm.insertElementAt("Chọn lớp học", 0);
//        cbb.setSelectedIndex(0);
//    }
    
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
