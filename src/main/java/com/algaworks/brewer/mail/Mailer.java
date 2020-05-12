package com.algaworks.brewer.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.algaworks.brewer.model.Venda;

@Component
public class Mailer {
	
	@Autowired
	private JavaMailSender mailSender;

	@Async
	public void enviar(Venda venda) {	
		System.out.println(">>> enviando e-mail...");
		
		SimpleMailMessage mensagem = new SimpleMailMessage();
		mensagem.setFrom("andreluiz1013@hotmail.com");
		mensagem.setTo(venda.getCliente().getEmail());
		mensagem.setSubject("Venda efetuada");
		mensagem.setText("Obrigado, sua venda foi processada!");
		
		System.out.println(">>>>> Cliente: " + venda.getCliente().getNome());
		System.out.println(">>>>> Email Cliente: " + venda.getCliente().getEmail());
		
		mailSender.send(mensagem);
		
		// Simula um tempo de 10 segundos
		/*
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		
		System.out.println(">>> e-mail enviado!");
		
	}
	
}
