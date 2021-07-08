/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author pallgree
 */
public class patientList extends ArrayList<patient> {

    public patientList() {
        
        super();
    }
    public String today(){
        String s = "";
        s += "===============================================================================================\n";
        s += "ID          Name            Quê quán           Ngày book         Gmail               Triệu chứng\n";
        LocalDateTime myDate = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String k = myDate.format(myFormat);
        for (int i = 0; i < this.size(); i++) if(this.get(i).getDate().equals(k)){
            String a = "";
            for (int j = 0; j < 10 - this.get(i).getId().length(); j++) {
                a += " ";
            }
            String b = "";
            for (int j = 0; j < 19 - this.get(i).getName().length(); j++) {
                b += " ";
            }
            String c = "";
            for (int j = 0; j < 18 - this.get(i).getFrom().length(); j++) {
                c += " ";
            }
            String d = "";
            for (int j = 0; j < 14 - this.get(i).getDate().length(); j++) {
                d += " ";
            }
            String e = "";
            for (int j = 0; j < 25 - this.get(i).getGmail().length(); j++) {
                e += " ";
            }

            s+=this.get(i).getId()+a+this.get(i).getName()+b+this.get(i).getFrom()+c+this.get(i).getDate()+d+this.get(i).getGmail()+e+this.get(i).getTrieuchung()+"\n";
        }
        s += "===============================================================================================\n";

       

        return s;
    }

    @Override
    public String toString() {
        String s = "";
        s += "===============================================================================================\n";
        s += "ID          Name            Quê quán           Ngày book         Gmail               Triệu chứng\n";
        for (int i = 0; i < this.size(); i++) {
            String a = "";
            for (int j = 0; j < 10 - this.get(i).getId().length(); j++) {
                a += " ";
            }
            String b = "";
            for (int j = 0; j < 19 - this.get(i).getName().length(); j++) {
                b += " ";
            }
            String c = "";
            for (int j = 0; j < 18 - this.get(i).getFrom().length(); j++) {
                c += " ";
            }
            String d = "";
            for (int j = 0; j < 14 - this.get(i).getDate().length(); j++) {
                d += " ";
            }
            String e = "";
            for (int j = 0; j < 25 - this.get(i).getGmail().length(); j++) {
                e += " ";
            }

            s+=this.get(i).getId()+a+this.get(i).getName()+b+this.get(i).getFrom()+c+this.get(i).getDate()+d+this.get(i).getGmail()+e+this.get(i).getTrieuchung()+"\n";
        }
        s += "===============================================================================================\n";

        return s;
    }

}
