/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tran Huu Phuc
 */
public class Dangky_Acount {
    private String User;
    private String Gmail;
    private String Password;
    private String ConfirmPass;
    
    //contructor

    public Dangky_Acount() {
    }

    public Dangky_Acount(String User, String Gmail, String Password, String ConfirmPass) {
        this.User = User;
        this.Gmail = Gmail;
        this.Password = Password;
        this.ConfirmPass = ConfirmPass;
    }

   //get and set

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getConfirmPass() {
        return ConfirmPass;
    }

    public void setConfirmPass(String ConfirmPass) {
        this.ConfirmPass = ConfirmPass;
    }

     
    
}
