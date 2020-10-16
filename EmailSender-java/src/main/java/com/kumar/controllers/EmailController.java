package com.kumar.controllers;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kumar.model.Email;

@Controller
public class EmailController {
	@GetMapping("/email")
	public String showEmailPage(Model model)
	{
		Email email=new Email();
		model.addAttribute("email",email);
		return "emailPage";
	}
	@PostMapping("/email")
	public String SubmitEmail(@ModelAttribute("email") final Email email,Model model)
	{
		String host="smtp.gmail.com";
		String port="587";
		
		
		Properties properties=System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", port);
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		Session session;
		try {
			session=Session.getDefaultInstance(properties,new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication(email.getEmail(), email.getPassword());
				}
			});
			MimeMessage message=new MimeMessage(session);
			message.setFrom(new InternetAddress(email.getEmail()));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
			message.setSubject(email.getSubject());
			message.setText(email.getBody());
			
			
			
			
			
			Transport.send(message);
			return "mailStatus";
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("not sent");
			model.addAttribute("status","not-sent");

			return "notMailStatus";
		}
	}
}
