package br.gov.rj.fazenda.email.corp.mapper;

import br.gov.rj.fazenda.email.corp.dto.TipoLogradouroDTO;
import br.gov.rj.fazenda.email.corp.dto.TipoLogradouroFormDTO;
import br.gov.rj.fazenda.email.corp.entity.TipoLogradouro;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TipoLogradouroMapper {
    TipoLogradouroDTO toDTO(TipoLogradouro tipoLogradouro);
    TipoLogradouro toEntity(TipoLogradouroFormDTO tipoLogradouroFormDTO);
}