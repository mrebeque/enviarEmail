package br.gov.rj.fazenda.email.corp.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Anexo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("arquivo")
	private byte[] arquivo;
	
	
	
	public Anexo() {
	}

	public Anexo(String nome, byte[] arquivo) {
		this.nome = nome;
		this.arquivo = arquivo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}
	
	
	
	

}
