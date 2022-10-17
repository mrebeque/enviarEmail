package br.gov.rj.fazenda.email.corp.mapper;

import br.gov.rj.fazenda.email.corp.dto.ClienteEntradaDTO;
import br.gov.rj.fazenda.email.corp.dto.ClienteSaidaDTO;
import br.gov.rj.fazenda.email.corp.entity.Cliente;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ClienteMapper {
	
	ClienteSaidaDTO toDTO(Cliente cliente);
	Cliente toEntity(ClienteEntradaDTO clienteEntradaDTO);
}