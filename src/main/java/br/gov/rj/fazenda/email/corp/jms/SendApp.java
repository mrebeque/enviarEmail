package br.gov.rj.fazenda.email.corp.jms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import org.python.icu.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import br.gov.rj.fazenda.email.corp.vo.Email;

@Component
public class SendApp {
	
	   private JmsTemplate jmsTemplate;
	   
		@Value("${email.corp.mq.queue}")	
		private String fila;   
		
		@Value("${email.corp.file_dir}")
		private String fileDir;
		
	    @Autowired
	    public SendApp(JmsTemplate jmsTemplate) {
			this.jmsTemplate = jmsTemplate;
	    }
    	
	    public void enviarMensagem() {
	    	
	    	SimpleDateFormat ds = new SimpleDateFormat();
	    	for (int i = 0; i < 10; i++) {
	    		Email email = new Email();
	    		
	            email.setTo("marcelo.rebeque@gmail.com");
	            email.setFrom("mrebeque@fazenda.rj.gov.br");
	            email.setCorpo("Conteúdo.");
	            email.setSubject("Teste de envio de msg nr." + i);
	            email.setSistema("SBF");
	            email.setTipoEmail("HTML");
	            email.setDataEnvio(ds.format(Calendar.getInstance().getTime()));
	            email.setStatus("oK");
	            email.setError("Sem erro");
	            email.setCopia("Sem Cópia");
				
	    		Path path = Paths.get("C:\\tmp\\arquivos\\comprovante.pdf");
	      	   	for (int j = 0; j < 2; j++) {
		    		try {
						byte[] arquivo = Files.readAllBytes(path);
		    	   		email.getAnexos().addArquivo(arquivo);
		    	   		System.out.println(email.getAnexos().getNome());
		    		} catch (IOException e) {
		    			e.printStackTrace();
		    		}
	    	   	}
	      	   	
	            // jmsTemplate.convertAndSend(fila, email);
	      	   	jmsTemplate.send(fila, null);
	    		
			}
    	
	    }    	
}
