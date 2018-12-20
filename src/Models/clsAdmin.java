/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Gaara
 */
public class clsAdmin {
    public String maAdmin;
    public String password;
    
    public clsAdmin() {
        
    }
    public clsAdmin(String maAdmin, String password) {
        this.maAdmin = maAdmin;
        this.password = password;
    }
    
    public String getMaAdmin() {
        return maAdmin;
    }
    public void setMaAdmin(String maAdmin) {
        this.maAdmin = maAdmin;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String pass) {
        this.password = pass;
    }
}
