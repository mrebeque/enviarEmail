package br.gov.rj.fazenda.email.corp.mapper;

import br.gov.rj.fazenda.email.corp.dto.TipoLogradouroDTO;
import br.gov.rj.fazenda.email.corp.dto.TipoLogradouroFormDTO;
import br.gov.rj.fazenda.email.corp.entity.TipoLogradouro;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-15T14:29:50-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20220802-0458, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class TipoLogradouroMapperImpl implements TipoLogradouroMapper {

    @Override
    public TipoLogradouroDTO toDTO(TipoLogradouro tipoLogradouro) {
        if ( tipoLogradouro == null ) {
            return null;
        }

        TipoLogradouroDTO tipoLogradouroDTO = new TipoLogradouroDTO();

        return tipoLogradouroDTO;
    }

    @Override
    public TipoLogradouro toEntity(TipoLogradouroFormDTO tipoLogradouroFormDTO) {
        if ( tipoLogradouroFormDTO == null ) {
            return null;
        }

        TipoLogradouro tipoLogradouro = new TipoLogradouro();

        return tipoLogradouro;
    }
}
