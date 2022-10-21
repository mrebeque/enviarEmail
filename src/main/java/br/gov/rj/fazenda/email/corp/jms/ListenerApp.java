package br.gov.rj.fazenda.email.corp.jms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import br.gov.rj.fazenda.email.corp.vo.Email;

@Component
public class ListenerApp {
	
	   private JmsTemplate jmsTemplate;
	   
		@Value("${email.corp.mq.queue}")	
		private String fila;   
		
		@Value("${email.corp.file_dir}")
		private String fileDir;
		
	    @Autowired
	    public ListenerApp(JmsTemplate jmsTemplate) {
			this.jmsTemplate = jmsTemplate;
	    }
	    	
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
}
