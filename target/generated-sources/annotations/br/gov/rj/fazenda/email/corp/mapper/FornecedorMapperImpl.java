package br.gov.rj.fazenda.email.corp.mapper;

import br.gov.rj.fazenda.email.corp.dto.FornecedorEntradaDTO;
import br.gov.rj.fazenda.email.corp.dto.FornecedorSaidaDTO;
import br.gov.rj.fazenda.email.corp.dto.FornecedorSaidaDTO.FornecedorSaidaDTOBuilder;
import br.gov.rj.fazenda.email.corp.entity.Fornecedor;
import br.gov.rj.fazenda.email.corp.entity.Fornecedor.FornecedorBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-21T10:34:20-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20220802-0458, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class FornecedorMapperImpl implements FornecedorMapper {

    @Override
    public FornecedorSaidaDTO toDTO(Fornecedor fornecedor) {
        if ( fornecedor == null ) {
            return null;
        }

        FornecedorSaidaDTOBuilder fornecedorSaidaDTO = FornecedorSaidaDTO.builder();

        fornecedorSaidaDTO.cnpj( fornecedor.getCnpj() );
        fornecedorSaidaDTO.cpf( fornecedor.getCpf() );
        fornecedorSaidaDTO.id( fornecedor.getId() );
        fornecedorSaidaDTO.inscricaoEstadual( fornecedor.getInscricaoEstadual() );
        fornecedorSaidaDTO.inscricaoMunicipal( fornecedor.getInscricaoMunicipal() );
        fornecedorSaidaDTO.nomeFantasia( fornecedor.getNomeFantasia() );
        fornecedorSaidaDTO.razaoSocial( fornecedor.getRazaoSocial() );
        fornecedorSaidaDTO.rg( fornecedor.getRg() );

        return fornecedorSaidaDTO.build();
    }

    @Override
    public Fornecedor toEntity(FornecedorEntradaDTO entradaDTO) {
        if ( entradaDTO == null ) {
            return null;
        }

        FornecedorBuilder fornecedor = Fornecedor.builder();

        fornecedor.bairro( entradaDTO.getBairro() );
        fornecedor.celular( entradaDTO.getCelular() );
        fornecedor.cep( entradaDTO.getCep() );
        fornecedor.cnpj( entradaDTO.getCnpj() );
        fornecedor.complemento( entradaDTO.getComplemento() );
        fornecedor.cpf( entradaDTO.getCpf() );
        fornecedor.email( entradaDTO.getEmail() );
        fornecedor.id( entradaDTO.getId() );
        fornecedor.inscricaoEstadual( entradaDTO.getInscricaoEstadual() );
        fornecedor.inscricaoMunicipal( entradaDTO.getInscricaoMunicipal() );
        fornecedor.nomeFantasia( entradaDTO.getNomeFantasia() );
        fornecedor.numero( entradaDTO.getNumero() );
        fornecedor.razaoSocial( entradaDTO.getRazaoSocial() );
        fornecedor.rg( entradaDTO.getRg() );
        fornecedor.rua( entradaDTO.getRua() );
        fornecedor.telefone( entradaDTO.getTelefone() );

        return fornecedor.build();
    }
}
