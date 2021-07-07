/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import java.lang.*;
import java.util.*;
import com.sun.mail.smtp.SMTPTransport;
import java.io.UnsupportedEncodingException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;


/**
 *
 * @author pallgree
 */

public class controller {

    userList list = new userList();
    String cookie="";
       String art=
                "                  ____                   \n" +
"      ____  ____ _/ / /___ _________  ___ \n" +
"     / __ \\/ __ `/ / / __ `/ ___/ _ \\/ _ \\\n" +
"    / /_/ / /_/ / / / /_/ / /  /  __/  __/\n" +
"   / .___/\\__,_/_/_/\\__, /_/   \\___/\\___/ \n" +
"  /_/              /____/                 ";

    public void innit() {
        user u1 = new user("admin", "123", "Admin", "admin@shop.com");
        list.add(u1);
        user u2 = new user("tienhung", "123", "Tiến Hưng", "hungvt164@gmail.com");
        list.add(u2);
    }

    public void menu() {
     
        
        System.out.println(art+"\n");
        System.out.println("Chào mừng bạn đến với hệ thống Pallgree.shop");
        System.out.println("1.Login");
        System.out.println("2.Đăng kí tài khoản bệnh nhân.");
        System.out.println("3.Lấy lại mật khẩu qua gmail ");
        System.out.println("Note: Chỉ tài khoản admin mới có toàn quyền truy cập hệ thống");
        System.out.println("Tài khoản admin: admin/123\n");
        Scanner sc = new Scanner(System.in);
        boolean check =false;
        String tmp;
        
        do{
            tmp=sc.nextLine();
            switch(tmp){
                case "1":
                    login();                 
                    break;
                    
                case "2":
                    register();
                    break;
                    
                case "3":
                   
                    sendMail();
                    break;
                default:
                    System.out.println("Vui lòng chọn lại !!!");
                    check=true;
                    
                
            
            }
            
        
        }
        while(check==true);
        

    }
    public int checkLogin(String s){
         for(int i=0;i<list.size();i++)
         {
             if(list.get(i).getUser_name().equals(s)) 
                  //this.cookie+=i.getFullname();
                  return i;
             
         }
         return -1;
    }
    
    public int checkMail(String s){
         for(int i=0;i<list.size();i++)
         {
             if(list.get(i).getEmail().equals(s)) 
                  //this.cookie+=i.getFullname();
                  return i;
             
         }
         return -1;
    }
    public void login(){
       Scanner sc = new Scanner(System.in);
       String a,b;
       System.out.println("Nhập user name:");
       a=sc.nextLine();
       System.out.println("Nhập password:");
       b=sc.nextLine();
       if(checkLogin(a)!=-1 && list.get(checkLogin(a)).getPass().equals(b))
       {
           System.out.println("Tài khoản "+list.get(checkLogin(a)).getFullname()+" đã đăng nhập thành công vào hệ thống");
           
           
       }
       else{
           System.err.println("Tài khoản không tồn tại");
           System.err.println("Nhấp nhím bất kì để quay lại");
           String c=sc.nextLine();
           menu();
       }
           
    }
    public void register(){
       System.out.println("Đăng kí tài khoản mới:");
       Scanner sc = new Scanner(System.in);
       String a ="",b,c,d="";
       boolean check=false;
       System.out.println("Nhập user name( không được trùng với user name trong kho dữ liệu):");
       //============
       do{
           try{
          a=sc.nextLine();
          if(checkLogin(a)==-1)
          {
              check=false;
          }
          else {
              throw new Exception();
          }
           }catch(Exception e){
               System.err.println("user name này đã tồn tại trong hệ thống, vui lòng chọn 1 tên khác");
               check=true;
           }
       }
       while(check==true);
       //===========
       System.out.println("Nhập password:");
       b=sc.nextLine();
       System.out.println("Nhập đầy đủ họ tên:");
       c=sc.nextLine();
       //============
       System.out.println("Nhập email(RegEx: xxx.gmail.com|| xxx.fpt.edu.vn):");
      
       check=false;
       String  pa= "^[\\w.+\\-]+@gmail\\.com$";
       String  pa2= "^[\\w.+\\-]+@fpt\\.edu\\.vn$";
        do{
           try{
          d=sc.nextLine();
          if(d.matches(pa)||d.matches(pa2))
          {
              check=false;
          }
          else {
              throw new Exception();
          }
           }catch(Exception e){
               System.err.println("không đúng format gmail, vui lòng nhập lại !!!");
               check=true;
           }
       }
       while(check==true);
      user u =new user(a,b,c,d);
      list.add(u);
      System.out.println("Đăng kí thành công");
      System.err.println("Nhấp nhím bất kì để quay lại");
           String z=sc.nextLine();
           menu();
      
           
    }
    public void sendMail(){
     
             System.out.println("Vui lòng nhập gmail mà bạn dùng để đăng kí để chúng tôi lấy lại mật khẩu cho bạn:");
             Scanner sc = new Scanner(System.in);
             String a,b="",name ="";
             a=sc.nextLine();
             int i=checkMail(a);
             try{
                 b=list.get(i).getPass();
                 name=list.get(i).getFullname();
             }catch(Exception e){}
           
        try {
            send(a,b,name);
        } catch (MessagingException | UnsupportedEncodingException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
             
           System.err.println("Nhấp phím bất kì để quay lại");
           String c=sc.nextLine();
           menu();
        
    }
    
    
    
    

    public void send(String s,String b,String name) throws MessagingException, UnsupportedEncodingException {
        final String fromEmail = "pallgreeshop@gmail.com";
        // Mat khai email cua ban
        final String password = "Pallgree123";
        // dia chi email nguoi nhan
        final String toEmail =s;
        final String subject = "Thư lấy lại mật khẩu Pallgree:";
        final String body = "Dear,"+name+"\nMật khẩu của bạn là:"+b+"\nTks\n\n"+art;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);
        MimeMessage msg = new MimeMessage(session);
        //set message headers
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");
        msg.setFrom(new InternetAddress(fromEmail, "PALLGREE"));
        msg.setReplyTo(InternetAddress.parse(fromEmail, false));
        msg.setSubject(subject, "UTF-8");
        msg.setText(body, "UTF-8");
        msg.setSentDate(new Date());
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        Transport.send(msg);
        System.out.println("Gửi thành công!!!\nCheck lại hộp thư Gmail bạn để xem mật khẩu.");
    }


}
