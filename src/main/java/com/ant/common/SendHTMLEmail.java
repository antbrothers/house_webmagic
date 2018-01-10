package com.ant.common;


import com.ant.model.house.Houses;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Created by Administrator on 2018/1/10.
 */
public class SendHTMLEmail {
    /**
     * 发送邮件
     * @param houses
     */
    public static void Send(Houses houses) {
        String to = "896779016@qq.com";
        String from = "jianxi_lin@163.com";
        String host = "smtp.163.com";

        // 获取系统属性
        Properties properties = System.getProperties();
        properties.setProperty("mail.host", host);
        properties.setProperty("mail.smtp.auth", "true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jianxi_lin@163.com","ljx123456");
            }
        };
        Session session = Session.getDefaultInstance(properties, authenticator);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            message.setSubject(houses.getTitle());
            message.setContent("<h3><a href="+houses.getLink()+">"+houses.getTitle()+"</a></h3>" + "<div>"+houses.getAddress()+"</div>" + "<div>"+houses.getAcreage()+"</div>"+ "<div>"+houses.getTraffic()+"</div>"+ "<div>单价：<span style='color: #f15044'>"+houses.getPrice()+"</span></div>", "text/html;charset=utf-8");
            // 发送消息
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
