/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import java.util.Scanner;
import java.util.logging.Logger;
import validate.controller;

/**
 *
 * @author pallgree
 */
public class menuDrug {
    drugList list=new drugList();

    public menuDrug() {
    }
    
    public void innit(){
        drug d1=new drug("Đông Trùng Hạ Thảo","300","07-07-2001");
        list.add(d1);
         drug d2=new drug("Cao Bách Thảo","700","07-07-2001");
        list.add(d2);
    
    }
    
     public void menu() {
        innit();
        boolean check=false;
        Scanner sc=new Scanner(System.in);
        String tmp;
        System.out.println("\n-Home >> Quản lí thuốc đông y");
        System.out.println("1.Thêm thuốc mới");
        System.out.println("2.Xoá thuốc");
        System.out.println("3.Hiện thị danh sách thuốc hiện có");
        do{
            tmp=sc.nextLine();
            switch(tmp){
                case "1":
                System.out.println("\n-Home >> Quản lí thuốc đông y >> Thêm thuốc mới");
                   
                break;
                
                case "2":
                System.out.println("\n-Home >> Quản lí thuốc đông y >> Xoá thuốc");
                System.out.println(list.toString());
                remove();
                System.out.println(list.toString());
                System.out.println("Nhấn 1 phím bất kì để thoát");
                String z=sc.nextLine();
                menu();
                break;
                
                case "3":
                System.out.println("\n-Home >> Quản lí thuốc đông y >> Hiển thị toàn bộ danh sách");
                System.out.println(list.toString());
                list.toString();
                System.out.println("Nhấn 1 phím bất kì để thoát");
                z=sc.nextLine();
                menu();
                break;
                
                default:
                    check=true;
                    System.err.println("Không hợp lệ, vui lòng nhập lại!!");
                         
            }
            
        }
        while(check==true);
    
    }
    
     public void remove(){
         System.out.println("Nhập tên thuốc cần xoá");
          Scanner sc=new Scanner(System.in);
         String a=sc.nextLine();
         for(int i=0;i<list.size();i++){
             if(list.get(i).getName().equals(a))
             {
                 list.remove(i);
                 System.out.println("Xoá thành công !!!");
                 
             }
             else {
                 System.out.println("Tên thuốc không tồn tại");
             }
         }
             
     }
    
    
 
}
