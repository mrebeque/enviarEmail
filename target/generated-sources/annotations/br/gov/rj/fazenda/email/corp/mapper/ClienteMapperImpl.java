package br.gov.rj.fazenda.email.corp.mapper;

import br.gov.rj.fazenda.email.corp.dto.ClienteEntradaDTO;
import br.gov.rj.fazenda.email.corp.dto.ClienteSaidaDTO;
import br.gov.rj.fazenda.email.corp.entity.Cliente;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-15T14:29:50-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20220802-0458, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteSaidaDTO toDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteSaidaDTO clienteSaidaDTO = new ClienteSaidaDTO();

        return clienteSaidaDTO;
    }

    @Override
    public Cliente toEntity(ClienteEntradaDTO clienteEntradaDTO) {
        if ( clienteEntradaDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        return cliente;
    }
}
