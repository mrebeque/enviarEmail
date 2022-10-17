package br.gov.rj.fazenda.email.corp.dto;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString @EqualsAndHashCode
public class FornecedorSaidaDTO {
	private Long id;
	private String nomeFantasia;
	private String razaoSocial;
	private String cpf;
	private String cnpj;
	private String inscricaoMunicipal;
	private String inscricaoEstadual;
	private String rg;

}
