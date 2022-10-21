package br.gov.rj.fazenda.email.corp.jms;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class ConversorMessagem implements MessageConverter  {

	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {

		// Email email = (Email) object;
        ObjectMessage message = session.createObjectMessage();
        message.setObject((Serializable) object);
        		
        /*
        MapMessage message = session.createMapMessage();
        message.setString("to", email.getTo());
        message.setString("from", email.getFrom() );
        message.setString("corpo", email.getTo());
        message.setString("subject", email.getFrom() );
        message.setString("sistema", email.getTo());
        message.setString("tipoEmail", email.getFrom() );
        message.setString("dataEnvio", email.getTo());
        message.setString("status", email.getFrom() );
        message.setString("error", email.getTo());
        message.setString("copia", email.getFrom() );
        message.setObject("anexos", (Object) email.getAnexos() );   
        */     
        return message;
	}

	@Override
	public Object fromMessage(Message msg) throws JMSException, MessageConversionException {

		
		/*
		Object ob = msg.getObjectProperty(null) 
		MapMessage mapMessage = (MapMessage) msg;
        
		Email email = new Email();
		
        email.setTo(mapMessage.getString("to"));
        email.setFrom(mapMessage.getString("from"));
        email.setCorpo(mapMessage.getString("corpo"));
        email.setSubject(mapMessage.getString("subject"));
        email.setSistema(mapMessage.getString("sistema"));
        email.setTipoEmail(mapMessage.getString("tipoEmail"));
        email.setDataEnvio(mapMessage.getString("dataEnvio"));
        email.setStatus(mapMessage.getString("status"));
        email.setError(mapMessage.getString("error"));
        email.setCopia(mapMessage.getString("copia"));
        email.setAnexos((Anexos)mapMessage.getObject("anexos")); 
        */
		return msg;
	}


}
