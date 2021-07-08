/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import java.io.UnsupportedEncodingException;
import java.lang.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import validate.controller;

/**
 *
 * @author pallgree
 */
public class menuPatient {

    patientList list = new patientList();
    boolean checkIn = false;

    public menuPatient() {
    }

    public void innit() {
        patient d1 = new patient("0101", "Vu Tien Hung", "Nghe An", "07/07/2021", "hungvt164@gmail.com", "dau tay");
        list.add(d1);
        patient d2 = new patient("0134", "Vu Thu Ha", "Nghe An", "07/07/2021", "xxxx@gmail.com", "dau chan");
        list.add(d2);
         patient d3 = new patient("0167", "Phạm Hải Duyên", "Hà Nội", "08/07/2021", "duyenhai@gmail.com", "dau bung");
        list.add(d3);

    }

    public void menu() {
        if (checkIn == false) {
            innit();
        }
        checkIn = true;
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        String tmp;
        System.out.println("\n-Home >> Quản lí bệnh nhân");
        System.out.println("1.Thêm bệnh nhân mới");
        System.out.println("2.Xoá bệnh nhân");
        System.out.println("3.Hiện thị danh sách bệnh nhân");
        System.out.println("4.Danh sách bệnh nhân hôm nay cần khám(lấy theo ngày tháng hệ thống)");
        System.out.println("5.Gửi lịch tái khám cho bệnh nhân qua gmail");
        System.out.println("6.Quay lại");
        do {
            tmp = sc.nextLine();
            switch (tmp) {
                case "1":
                    System.out.println("\n-Home >> Quản lí thuốc đông y >> Thêm bệnh nhân mới");
                    input();
                    System.out.println("Nhấn 1 phím bất kì để quay lại");
                    String z = sc.nextLine();
                    menu();

                case "2":
                    System.out.println("\n-Home >> Quản lí thuốc đông y >> Xoá bệnh nhân");
                    System.out.println(list.toString());
                    System.out.println("Nhập id bệnh nhân cần xoá");
                    remove();
                    System.out.println(list.toString());
                    System.out.println("Nhấn 1 phím bất kì để quay lại");
                    z = sc.nextLine();
                    menu();

                    break;
                case "3":
                    System.out.println("\n-Home >> Quản lí thuốc đông y >> Hiển thị danh sách bệnh nhân");
                    System.out.println(list.toString());
                    System.out.println("Nhấn 1 phím bất kì để quay lại");
                    z = sc.nextLine();
                    menu();
                    
                case "4":
                    System.out.println("\n-Home >> Quản lí thuốc đông y >> Danh sách bệnh nhân khám hôm nay");
                    System.out.println(list.today());
                    System.out.println("Nhấn 1 phím bất kì để quay lại");
                    z = sc.nextLine();
                    menu();

                    break;
                case "5":
                    System.out.println("\n-Home >> Quản lí thuốc đông y >> Gửi lịch tái khám");
                    System.out.println("Nhập gmail bệnh nhân cần gửi");
                    String a = sc.nextLine();
                    System.out.println("Nội dung cần gửi");
                    String b = sc.nextLine();
                    System.out.println("Vui lòng chờ trong giây lát ...");
                     {
                        try {
                            send(a, b);
                        } catch (MessagingException ex) {
                            Logger.getLogger(menuPatient.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (UnsupportedEncodingException ex) {
                            Logger.getLogger(menuPatient.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    //System.err.println("Gửi thành công");
                    System.out.println("Nhấn 1 phím bất kì để quay lại");
                    z = sc.nextLine();
                    menu();

                    break;
                case "6":
                    menuAd m3 = new menuAd();
                    m3.menu();
                    break;

                default:
                    check = true;
                    System.err.println("Không hợp lệ, vui lòng nhập lại!!");

            }

        } while (check == true);

    }

 

    public void remove() {
        //System.out.println("Nhập tên thuốc cần xoá");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(a)) {
                list.remove(i);
                System.err.println("Xoá thành công !!!");
                check = true;
                break;

            }

        }
        if (check == false) {
            System.err.println("Id bệnh nhân không tồn tại");
        }

    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        String a, b, c, d, e, f;
        int tmp = (int) (((Math.random()) * ((9998 - 1011) + 1)) + 1000);
        a = Integer.toString(tmp);
        System.out.println("Nhập họ và tên bệnh nhân");
        b = sc.nextLine();
        System.out.println("Nhập quê quán( chỉ nhập tỉnh thành)");
        c = sc.nextLine();
        //====
        System.out.println("Nhập ngày book khám(dd/MM/yyyy)");
        d = sc.nextLine();
        //====
        System.out.println("Nhập gmail bệnh nhân");
        e = sc.nextLine();
        System.out.println("Nhập triệu chứng bệnh nhân");
        f = sc.nextLine();

        patient p = new patient(a, b, c, d, e, f);
        list.add(p);
        System.err.println("Thêm thành công");

    }

    public void send(String s, String b) throws MessagingException, UnsupportedEncodingException {
        final String fromEmail = "pallgreeshop@gmail.com";
        // Mat khai email cua ban
        final String password = "Pallgree123";
        // dia chi email nguoi nhan
        final String toEmail = s;
        final String subject = "Thư đến từ Pallgree:";
        final String body = "Dear," + "\n" + b + "\nTks\n\n";
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
        System.out.println("Gửi thành công!!!\nCheck lại hộp thư Gmail bạn.");
    }

}
