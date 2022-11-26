package br.gov.rj.fazenda.email.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Anexos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("arquivos")
	private List<byte[]> arquivos;
	
	public Anexos() {
		nome = "Lista de Anexos";
		arquivos = new ArrayList<>();
	}

	public Anexos(String nome, List<byte[]> arquivos) {
		this.nome = nome;
		this.arquivos = arquivos;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<byte[]> getArquivo() {
		return arquivos;
	}

	public void setArquivo(List<byte[]> arquivo) {
		this.arquivos = arquivo;
	}

	public void addArquivo(byte[] arquivo) {
		this.arquivos.add(arquivo);
	}
}
