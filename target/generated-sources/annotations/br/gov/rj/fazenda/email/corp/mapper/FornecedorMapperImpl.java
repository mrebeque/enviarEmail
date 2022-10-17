package br.gov.rj.fazenda.email.corp.mapper;

import br.gov.rj.fazenda.email.corp.dto.FornecedorEntradaDTO;
import br.gov.rj.fazenda.email.corp.dto.FornecedorSaidaDTO;
import br.gov.rj.fazenda.email.corp.entity.Fornecedor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-15T14:29:50-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20220802-0458, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class FornecedorMapperImpl implements FornecedorMapper {

    @Override
    public FornecedorSaidaDTO toDTO(Fornecedor fornecedor) {
        if ( fornecedor == null ) {
            return null;
        }

        FornecedorSaidaDTO fornecedorSaidaDTO = new FornecedorSaidaDTO();

        return fornecedorSaidaDTO;
    }

    @Override
    public Fornecedor toEntity(FornecedorEntradaDTO entradaDTO) {
        if ( entradaDTO == null ) {
            return null;
        }

        Fornecedor fornecedor = new Fornecedor();

        return fornecedor;
    }
}
