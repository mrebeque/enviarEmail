package br.gov.rj.fazenda.email.corp.jms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import br.gov.rj.fazenda.email.corp.security.services.EmailService;
import br.gov.rj.fazenda.email.corp.vo.Email;

@Component
public class ListenerApp { 
	
	   private JmsTemplate jmsTemplate;
	   
		@Value("${email.corp.mq.queue}")	
		private String fila;   
		
		@Value("${email.corp.file_dir}")
		private String fileDir;
		
		@Autowired
		private EmailService emailService;
		
	    @Autowired
	    public ListenerApp(JmsTemplate jmsTemplate) {
			this.jmsTemplate = jmsTemplate;
	    }	    
		
	    @JmsListener(destination = "${email.corp.mq.queue}")
	    public void onReceiverTopic(Email email ) {

	    	System.out.println("Email: " + email.getSubject());

	    	emailService.sendMail(email);
	    
	    
	    }
	    
	    

	    public void ReceiverQueue() {
	      // Email email = (Email) jmsTemplate.receiveAndConvert(fila);
	      
	      Object objMsg = jmsTemplate.receiveAndConvert(fila);
	      
	      if (objMsg == null)
	    	  return;
	      
	      if (objMsg instanceof Email)
	    	  System.out.println("E email");
	      
	      Email email = (Email) objMsg;
	      
	    	System.out.println("Email: " + email.getCorpo());
       		System.out.println(email.getAnexos().getNome());
	       	for (int i = 0; i < email.getAnexos().getArquivo().size(); i++) {
	       		Path path = Paths.get(fileDir +"/anexo-"+i+".pdf");
					try {
						Files.write(path, email.getAnexos().getArquivo().get(i));
					} catch (IOException e) {
						e.printStackTrace();
					}
	       	}
	      
	    	
	    }
	    
	    /*
	    @JmsListener(destination = "${email.corp.mq.queue}")    
	    public void onReceiverQueue(Message mensagem) {			
	    	Email msg = (Email) mensagem;
	    	
	    	System.out.println("Email: " + msg.getCorpo());
       		System.out.println(msg.getAnexos().getNome());
	       	for (int i = 0; i < msg.getAnexos().getArquivo().size(); i++) {
	       		Path path = Paths.get(fileDir +"/anexo-"+i+".pdf");
					try {
						Files.write(path, msg.getAnexos().getArquivo().get(i));
					} catch (IOException e) {
						e.printStackTrace();
					}
	       	}
	    }  
	    */  	
}
