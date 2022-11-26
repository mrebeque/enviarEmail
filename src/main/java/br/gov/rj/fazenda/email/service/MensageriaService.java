package br.gov.rj.fazenda.email.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import br.gov.rj.fazenda.email.vo.Email;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MensageriaService {
	   
	   private JmsTemplate jmsTemplate;
	   
		@Value("${email.corp.mq.queue}")	
		private String fila;   
		
		@Value("${spring.profiles.active}")
		private String ambiente;
		
		@Value("${app.dirAnexos}")
		private String dirAnexos;
		
	    @Autowired
	    public MensageriaService(JmsTemplate jmsTemplate) {
			this.jmsTemplate = jmsTemplate;
	    }
	    
	    
	    public void enviarMensagem(String sistema, 
	    		String from, String to, String cc,
	    		String subject, String body,
	    		HashMap<String, byte[]> arquivos){
	    	SimpleDateFormat ds = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	    	
    		Email email = new Email();
    		
            email.setSistema(sistema);
            email.setFrom(from);
            email.setTo(to);
            email.setCopia(cc);
            email.setSubject(subject);
            email.setCorpo(body);
            email.setTipoEmail("HTML");
            email.setDataEnvio(ds.format(Calendar.getInstance().getTime()));
            email.setStatus("oK");
            email.setError("Sem erro");
            email.setPastaAnexos("");
	    	if (arquivos.isEmpty() == false) {
	    	
	    		Path path = Paths.get(sistema + "_" + Calendar.getInstance().getTimeInMillis());	    		
	    	    boolean existeDir = (new File(path.toUri()).mkdirs());
	    	    
	    		email.setPastaAnexos(path.toFile().getName());

	    		for (Map.Entry<String, byte[]> arquivo : arquivos.entrySet()) {	        		
					try {					 
						Files.write(Paths.get(path + path.getFileSystem().getSeparator() + arquivo.getKey()), arquivo.getValue());
					} catch (IOException e) {
						e.printStackTrace();
					}
	    		}	    		
	    		jmsTemplate.convertAndSend(fila, email);	            
		    }
	    }	
			 
	    public void enviarMensagem() {
	    	
	    	SimpleDateFormat ds = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	    	for (int i = 0; i < 10; i++) {
	    		Email email = new Email();
	    		
	            email.setFrom("mrepereira@fazenda.rj.gov.br");
	            email.setTo("marcelo.rebeque@gmail.com");
	            email.setCopia("");
	            email.setSubject("Teste de envio de msg nr." + i);
	            email.setCorpo("Conteúdo.");
	            email.setSistema("SBF");
	            email.setTipoEmail("HTML");
	            email.setDataEnvio(ds.format(Calendar.getInstance().getTime()));
	            email.setStatus("oK");
	            email.setError("Sem erro");
	            jmsTemplate.convertAndSend(fila, email);
	    		
			}
    	
	    }    	
}
