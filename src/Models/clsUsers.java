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
public class clsUsers {
    int Ma_admin;
    String Ten_dang_nhap;
    String Ten_nguoi_dung;
    String Password;
    String Avatar;
    String Phone;
    int Role;
    
    public clsUsers(){
        Ma_admin =0;
        Ten_dang_nhap="";
        Ten_nguoi_dung="";
        Password = "";
        Avatar = "";
        Phone = "";
        Role = 0;
    }
    
    public clsUsers(int Ma_admin , String Ten_dang_nhap, String Ten_nguoi_dung, String Password,String Avatar ,String Phone ,int Role){
        this.Ma_admin = Ma_admin;
        this.Ten_dang_nhap= Ten_dang_nhap;
        this.Ten_nguoi_dung = Ten_nguoi_dung;
        this.Password = Password;
        this.Avatar = Avatar;
        this.Phone = Phone;
        this.Role = Role;
    }
     public void setid(int Ma_admin){
         this.Ma_admin = Ma_admin;
     }
     public void setuserName(String Ten_dang_nhap){
         this.Ten_dang_nhap = Ten_dang_nhap;
     }
     public void setAvatar(String Avatar){
         this.Avatar = Avatar;
     }
     public void setPhone(String Phone){
         this.Phone = Phone;
     }
      public void setTennguoidung(String Ten_nguoi_dung){
         this.Ten_nguoi_dung = Ten_nguoi_dung;
     }
     public void setpass(String Password){
         this.Password = Password;
     }
     public void setrole(int Role){
         this.Role = Role;
     }
     
      public int getid(){
         return Ma_admin;
     }
     public String getuserName(){
         return Ten_dang_nhap;
     }
     public String getpass(){
         return Password;
     }
      public String getAvatar(){
         return Avatar;
     }
       public String getPhone(){
         return Phone;
     }
     public String getTennguoidung(){
         return Ten_nguoi_dung;
     }
     public int getrole(){
         return Role;
     }
     
     public String getString(){
        String a = "id = "+Ma_admin +", UserName 0" +Ten_dang_nhap+",Pass = "+Password+", role = "+Role;
        return a;
    }
}
