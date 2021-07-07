/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import java.util.Scanner;
import validate.controller;

/**
 *
 * @author pallgree
 */
public class menuAd {

    public menuAd(){
    }
    public void menu(){
        boolean check=false;
        Scanner sc=new Scanner(System.in);
        String tmp;
        System.out.println("---------------Home---------------");
        System.out.println("1.Quản lí thuốc đông y");
        System.out.println("2.Quản lí bệnh nhân");
        System.out.println("3.Đăng xuất");
        do{
            tmp=sc.nextLine();
            switch(tmp){
                case "1":
                    menuDrug m1=new menuDrug();
                    m1.menu();
                break;
                case "2":
                break;
                case "3":
                   controller c=new controller();
                   c.menu();
                break;
                default:
                    check=true;
                    System.err.println("Không hợp lệ, vui lòng nhập lại!!");
                         
            }
            
        }
        while(check==true);
    }
}
