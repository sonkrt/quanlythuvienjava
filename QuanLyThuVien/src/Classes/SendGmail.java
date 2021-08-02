/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Properties;
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

/**
 *
 * @author Asus
 */
public class SendGmail {
    public static void sendMail(String recepient,String contentMail){
        Properties proper = new Properties();
        proper.put("mail.smtp.auth", "true");
        proper.put("mail.smtp.starttls.enable", "true");
        proper.put("mail.smtp.host", "smtp.gmail.com");
        proper.put("mail.smtp.port", "587");
        
        String myEmail = "librarysystems.031099@gmail.com";
        String passWord = "sonkarate19";
        Session session = Session.getInstance(proper, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, passWord);
            }       
});
        Message mes = prepareMessage(session, myEmail, recepient,contentMail);
        try {
            Transport.send(mes);
        } catch (MessagingException ex) {
            Logger.getLogger(SendGmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static Message prepareMessage(Session session, String myEmail,String recepient,String contentMail){
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Quản lý thư viện");
            message.setText(contentMail);
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(SendGmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
