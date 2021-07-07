/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

/**
 *
 * @author pallgree
 */
public class drug {
    private String name;
    private String kluong;
    private String date;

    public drug() {
    }

    public drug(String name, String kluong, String date) {
        this.name = name;
        this.kluong = kluong;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKluong() {
        return kluong;
    }

    public void setKluong(String kluong) {
        this.kluong = kluong;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return "drug{" + "name=" + name + ", kluong=" + kluong + ", date=" + date + '}';
    }
    
    
    
}
