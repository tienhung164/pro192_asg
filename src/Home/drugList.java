/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import java.util.ArrayList;

/**
 *
 * @author pallgree
 */
public class drugList extends ArrayList<drug> {
     
            
    public drugList() {
        super();
    }

    @Override
    public String toString(){
        String s="";
              s+="=============================================================================\n";
              s+="Tên thuốc                       Khối Lượng                           Ngày Nhập\n";
         for(int i=0;i<this.size();i++)
         {
             String a="";
             for(int j=0;j<35 - this.get(i).getName().length();j++)
                 a+=" ";
             
             s+=this.get(i).getName()+a+this.get(i).getKluong()+"                              "+this.get(i).getDate()+"\n";
         }
         s+="=============================================================================\n";
  
        return s;
    }
    
    
    
}
