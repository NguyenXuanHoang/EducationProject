package vn.iomedia.ipay.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import vn.iomedia.ipay.entity.Student;

public class SendEmail {

    private static Logger log = Logger.getLogger(SendEmail.class);

    public static void startSendEmail(Student student, String otp) {
        Thread t = new Thread(() -> {
            log.debug("Start new thread for send email.");
            SendEmail.sendEmail(student.getEmail().trim(), otp);
        });
        t.start();
    }

    private static void sendEmail(String email, String otp) {

        final String username = "hoangtestemail15@gmail.com";
        final String password = "Hoangnguyen16";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("hoangtestemail15@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Email OTP Test");
            message.setText("Dear Student," + "plese put OTP: " + otp + " from email to this registration.");

            Transport.send(message);
            log.debug("Send email success");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
