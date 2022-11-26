package br.gov.rj.fazenda.email.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {
	private String Status;
	private String mensagem;
	private String retorno;
	
}
