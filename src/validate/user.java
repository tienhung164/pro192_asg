/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

/**
 *
 * @author pallgree
 */
public class user {
    private String user_name;
    private String pass;
    private String fullname;
    private String email;

    public user() {
    }

    public user(String user_name, String pass, String fullname, String email) {
        this.user_name = user_name;
        this.pass = pass;
        this.fullname = fullname;
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "user{" + "user_name=" + user_name + ", pass=" + pass + ", fullname=" + fullname + ", email=" + email + '}';
    }
    
    
    
}
