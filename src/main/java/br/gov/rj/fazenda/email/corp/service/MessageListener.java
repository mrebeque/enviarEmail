package br.gov.rj.fazenda.email.corp.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.gov.rj.fazenda.email.corp.vo.Email;

@Service
public class MessageListener implements ApplicationRunner {

    private JmsTemplate jmsTemplate;
   
	@Value("${email.corp.mq.queue}")	
	private String fila;   
	
	@Value("${email.corp.file_dir}")
	private String fileDir;
	
    @Autowired
    public MessageListener(JmsTemplate jmsTemplate, JmsTemplate jmsTemplateTopic) {
		this.jmsTemplate = jmsTemplate;
    }
    
    @JmsListener(destination = "${email.corp.mq.queue}")    
    public void onReceiverQueue(Email msg) {			
   	    	
    	System.out.println("Email: " + msg.getCorpo());
       	for (int i = 0; i < msg.getAnexos().size(); i++) {
       		System.out.println(msg.getAnexos().get(i).getNome());
       		Path path = Paths.get(file_dir+"\"+ msg.getAnexos().get(i).getNome());
       		try {
				Files.write(path, msg.getAnexos().get(i).getArquivo());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       	}
    	
	}
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
    	
    	System.out.println("Eu vou testar!!");
    	
    	for (int i = 1; i < 11; i++) {
    		jmsTemplate.convertAndSend(fila, new Email("marcelo.rebeque","Teste " + i,"enviando teste " + i));   	
    	}
       	System.out.println("Eu vou testar!!");
    }   
}
