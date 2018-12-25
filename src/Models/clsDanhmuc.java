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
    String Ten_Danh_Muc;
    public clsDanhmuc(){
        id = 0;
        Ten_Danh_Muc = "";
    }
    public clsDanhmuc(int id , String Ten_Danh_Muc){
        this.id = id;
        this.Ten_Danh_Muc = Ten_Danh_Muc;
    }
    
    public int getID(){
        return id;
    }
    public String getTendanhmuc(){
        return Ten_Danh_Muc;
    }
    
    public void setID(int id){
        this.id = id;
    }
    public void setDanhmuc(String Ten_Danh_Muc){
        this.Ten_Danh_Muc = Ten_Danh_Muc;
    }
}
