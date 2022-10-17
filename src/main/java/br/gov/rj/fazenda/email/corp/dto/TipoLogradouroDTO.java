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
public class TipoLogradouroDTO {
	
	private Long id;
	private String abreviacao;
	private String descricao;

}
