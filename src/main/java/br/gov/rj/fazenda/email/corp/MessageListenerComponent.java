package br.gov.rj.fazenda.email.corp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.gov.rj.fazenda.email.corp.service.MensageriaService;

@Component
public class MessageListenerComponent implements ApplicationRunner {
	 
		@Autowired
		MensageriaService enviar;
		
	    @Override
	    public void run(ApplicationArguments args) throws Exception {
	    	
	    	System.out.println("Eu vou testar!!");
	    	enviar.enviarMensagem();
	       	System.out.println("Eu enviei!!");
	    }   	
}
