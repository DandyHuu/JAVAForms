/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author admin
 */
public class clsDanhmuc {
    int id;
    String Ten_danh_muc;
    public clsDanhmuc(){
        id = 0;
        Ten_danh_muc = "";
    }
    public clsDanhmuc(int id , String Ten_danh_muc){
        this.id = id;
        this.Ten_danh_muc = Ten_danh_muc;
    }
    
    public int getID(){
        return id;
    }
    public String getTendanhmuc(){
        return Ten_danh_muc;
    }
    
    public void setID(int id){
        this.id = id;
    }
    public void setDanhmuc(String Ten_danh_muc){
        this.Ten_danh_muc = Ten_danh_muc;
    }
}
