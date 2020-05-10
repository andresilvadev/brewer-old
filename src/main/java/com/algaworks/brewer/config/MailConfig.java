package com.algaworks.brewer.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource({"classpath:env/mail-${ambiente:local}.properties"})
public class MailConfig {
	
	@Autowired
	private Environment env;

	@Bean
	public JavaMailSender mailSender() {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost("smtp.sendgrid.net");
		mailSender.setPort(587);
		mailSender.setUsername(env.getProperty("email.username"));
		mailSender.setPassword(env.getProperty("email.password"));
		
		System.out.println(">>>>> username: " + env.getProperty("email.username"));
		System.out.println(">>>>> password: " + env.getProperty("email.password"));
		
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.debug", true);
		props.put("mail.smtp.connectiontimeout", 10000);
		
		mailSender.setJavaMailProperties(props);
		
		return mailSender;		
	}
}
