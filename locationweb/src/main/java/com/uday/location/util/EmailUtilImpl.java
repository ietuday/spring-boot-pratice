package com.uday.location.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilImpl implements EmailUtil {

    private JavaMailSender sender;

	@Override
	public void sendEmail(String toAddress, String subject, String body) {
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(toAddress);
			helper.setSubject(subject);
			helper.setText(body);
			sender.send(message);

			
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		
	}

    public JavaMailSender getSender() {
        return sender;
    }

    public void setSender(JavaMailSender sender) {
        this.sender = sender;
    }
    
}