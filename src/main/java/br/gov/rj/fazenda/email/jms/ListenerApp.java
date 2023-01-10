package br.gov.rj.fazenda.email.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import br.gov.rj.fazenda.email.corp.dto.EmailDTO;
import br.gov.rj.fazenda.email.service.EmailService;

@Component
public class ListenerApp { 
	
//	   private JmsTemplate jmsTemplate;
//	   
		@Value("${email.corp.mq.queue}")	
		private String fila;   
		
		@Autowired
		private EmailService emailService;
		
//	    @Autowired
//	    public ListenerApp(JmsTemplate jmsTemplate) {
//			this.jmsTemplate = jmsTemplate;
//	    }	    
		
	    @JmsListener(destination = "${email.corp.mq.queue}")
	    public void onReceiverQueue(EmailDTO email ) {
	    	emailService.sendMail(email);
	    }

	    
//	    public void ReceiverQueue() {
//			Object objMsg = jmsTemplate.receiveAndConvert(fila);
//			if (objMsg == null)
//				return;
//			  
//			if ((objMsg instanceof Email) == false) {
//				System.out.println("Não é um email válido");
//				return;
//			}
//			Email email = (Email) objMsg;
//			HashMap<String, byte[]> arquivos = email.getArquivos();
//	        if (arquivos.isEmpty() == false ) {	        	
//	        	for (Map.Entry<String, byte[]> arquivo : arquivos.entrySet()) {	        		
//					try {
//					 
//					 Path path = Paths.get(fileDir + FileSystems.getDefault().getSeparator() + arquivo.getKey());
//						Files.write(path, arquivo.getValue());
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//	        	
//	        }
//	    }
}
