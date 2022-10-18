package br.gov.rj.fazenda.email.corp.mapper;

import br.gov.rj.fazenda.email.corp.dto.TipoLogradouroDTO;
import br.gov.rj.fazenda.email.corp.dto.TipoLogradouroDTO.TipoLogradouroDTOBuilder;
import br.gov.rj.fazenda.email.corp.dto.TipoLogradouroFormDTO;
import br.gov.rj.fazenda.email.corp.entity.TipoLogradouro;
import br.gov.rj.fazenda.email.corp.entity.TipoLogradouro.TipoLogradouroBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-17T12:58:12-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class TipoLogradouroMapperImpl implements TipoLogradouroMapper {

    @Override
    public TipoLogradouroDTO toDTO(TipoLogradouro tipoLogradouro) {
        if ( tipoLogradouro == null ) {
            return null;
        }

        TipoLogradouroDTOBuilder tipoLogradouroDTO = TipoLogradouroDTO.builder();

        tipoLogradouroDTO.abreviacao( tipoLogradouro.getAbreviacao() );
        tipoLogradouroDTO.descricao( tipoLogradouro.getDescricao() );
        tipoLogradouroDTO.id( tipoLogradouro.getId() );

        return tipoLogradouroDTO.build();
    }

    @Override
    public TipoLogradouro toEntity(TipoLogradouroFormDTO tipoLogradouroFormDTO) {
        if ( tipoLogradouroFormDTO == null ) {
            return null;
        }

        TipoLogradouroBuilder tipoLogradouro = TipoLogradouro.builder();

        tipoLogradouro.abreviacao( tipoLogradouroFormDTO.getAbreviacao() );
        tipoLogradouro.descricao( tipoLogradouroFormDTO.getDescricao() );
        tipoLogradouro.id( tipoLogradouroFormDTO.getId() );

        return tipoLogradouro.build();
    }
}
