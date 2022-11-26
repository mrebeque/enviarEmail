package br.gov.rj.fazenda.email.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.gov.rj.fazenda.email.corp.dto.EmailDTO;
import br.gov.rj.fazenda.email.vo.Email;


@Service
public class EmailService {

	

	@Value("${app.dirAnexos}")
	private String dirAnexos;
	
	@Autowired 
    private JavaMailSender mailSender;

    public void sendMail(EmailDTO msg) {    	
		try {
	    	MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper mimeMsg;
			mimeMsg = new MimeMessageHelper(message, true);
	        mimeMsg.setTo(msg.getTo());
	        mimeMsg.setFrom(msg.getFrom());
	        mimeMsg.setText(msg.getCorpo());
	        mimeMsg.setSubject(msg.getSubject());
	        
	        if (msg.getPastaAnexos().isEmpty() == false) {	        	
	           String pathAnexos = 	dirAnexos + 
		                			FileSystems.getDefault().getSeparator() +
       			   					msg.getPastaAnexos();
	           
	           Set<String> listaAnexo = this.obterAnexos(pathAnexos);	           
	           for (String nomeArquivo : listaAnexo) {
	        	   Path path = Paths.get(pathAnexos + 
	        			                FileSystems.getDefault().getSeparator() + 
	        			                nomeArquivo);
	        	   
			        FileSystemResource file = new FileSystemResource(new File(path.toUri()));
					mimeMsg.addAttachment(nomeArquivo, file);
				}
	        }
	        mailSender.send(message);
		} catch (MessagingException | IOException e1 ) {
			e1.printStackTrace();
		}
    }
	
    
    private Set<String> obterAnexos(String dir) throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            return stream
              .filter(file -> !Files.isDirectory(file))
              .map(Path::getFileName)
              .map(Path::toString)
              .collect(Collectors.toSet());
        }
    }    
    
//    public void sendMail(Email msg) {    	
//		try {
//	    	MimeMessage message = mailSender.createMimeMessage();
//	        MimeMessageHelper mimeMsg;
//			mimeMsg = new MimeMessageHelper(message, true);
//	        mimeMsg.setTo(msg.getTo());
//	        mimeMsg.setFrom(msg.getFrom());
//	        mimeMsg.setText(msg.getCorpo());
//	        mimeMsg.setSubject(msg.getSubject());
//	        
//			HashMap<String, byte[]> arquivos = msg.getArquivos();
//	        if (arquivos.isEmpty() == false ) {	        	
//	        	for (Map.Entry<String, byte[]> arquivo : arquivos.entrySet()) {	        		
//					try {					 
//						Path path = Paths.get(msg.getPastaAnexos() + FileSystems.getDefault().getSeparator() + arquivo.getKey());
//						Files.write(path, arquivo.getValue());
//				        FileSystemResource file = new FileSystemResource(new File(path.toUri()));
//				        mimeMsg.addAttachment(file.getFilename(), file);
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//	        	
//	        }
//	        
//	        /*
//	       	for (int i = 0; i < msg.getAnexos().getArquivo().size(); i++) {
//	         		Path path = Paths.get(fileDir +"/anexo-"+i+".pdf");
//					try {
//					    Files.write(path, msg.getAnexos().getArquivo().get(i));
//				        FileSystemResource file = new FileSystemResource(new File(path.toUri()));
//				        mimeMsg.addAttachment(file.getFilename(), file);
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//	       	}	
//	       	*/    
//	        mailSender.send(message);
//		} catch (MessagingException e1) {
//			e1.printStackTrace();
//		}
//    }
}
