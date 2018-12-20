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
    int id;
    String userName;
    String pass;
    int role;
    
    public clsUsers(){
        id =0;
        userName="";
        pass = "";
        role = 0;
    }
    
    public clsUsers(int id , String userName, String pass, int role){
        this.id = id;
        this.userName= userName;
        this.pass = pass;
        this.role = role;
    }
     public void setid(int id){
         this.id = id;
     }
     public void setuserName(String userName){
         this.userName = userName;
     }
     public void setpass(String pass){
         this.pass = pass;
     }
     public void setrole(int role){
         this.role = role;
     }
     
      public int getid(){
         return id;
     }
     public String getuserName(){
         return userName;
     }
     public String getpass(){
         return pass;
     }
     public int getrole(){
         return role;
     }
     
     public String getString(){
        String a = "id = "+id +", UserName 0" +userName+",Pass = "+pass+", role = "+role;
        return a;
    }
}
