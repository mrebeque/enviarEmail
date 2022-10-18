package br.gov.rj.fazenda.email.corp.mapper;

import br.gov.rj.fazenda.email.corp.dto.ClienteEntradaDTO;
import br.gov.rj.fazenda.email.corp.dto.ClienteSaidaDTO;
import br.gov.rj.fazenda.email.corp.dto.ClienteSaidaDTO.ClienteSaidaDTOBuilder;
import br.gov.rj.fazenda.email.corp.entity.Cliente;
import br.gov.rj.fazenda.email.corp.entity.Cliente.ClienteBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-17T12:58:12-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteSaidaDTO toDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteSaidaDTOBuilder clienteSaidaDTO = ClienteSaidaDTO.builder();

        clienteSaidaDTO.bairro( cliente.getBairro() );
        clienteSaidaDTO.celular( cliente.getCelular() );
        clienteSaidaDTO.cep( cliente.getCep() );
        clienteSaidaDTO.cnpj( cliente.getCnpj() );
        clienteSaidaDTO.complemento( cliente.getComplemento() );
        clienteSaidaDTO.cpf( cliente.getCpf() );
        clienteSaidaDTO.dataNascimento( cliente.getDataNascimento() );
        clienteSaidaDTO.email( cliente.getEmail() );
        clienteSaidaDTO.id( cliente.getId() );
        clienteSaidaDTO.nome( cliente.getNome() );
        clienteSaidaDTO.numero( cliente.getNumero() );
        clienteSaidaDTO.numeroCNH( cliente.getNumeroCNH() );
        clienteSaidaDTO.numeroRegistroCNH( cliente.getNumeroRegistroCNH() );
        clienteSaidaDTO.observacao( cliente.getObservacao() );
        clienteSaidaDTO.razaoSocial( cliente.getRazaoSocial() );
        clienteSaidaDTO.rg( cliente.getRg() );
        clienteSaidaDTO.rua( cliente.getRua() );
        clienteSaidaDTO.senha( cliente.getSenha() );
        clienteSaidaDTO.telefone( cliente.getTelefone() );
        clienteSaidaDTO.validadeCNH( cliente.getValidadeCNH() );

        return clienteSaidaDTO.build();
    }

    @Override
    public Cliente toEntity(ClienteEntradaDTO clienteEntradaDTO) {
        if ( clienteEntradaDTO == null ) {
            return null;
        }

        ClienteBuilder cliente = Cliente.builder();

        cliente.bairro( clienteEntradaDTO.getBairro() );
        cliente.celular( clienteEntradaDTO.getCelular() );
        cliente.cep( clienteEntradaDTO.getCep() );
        cliente.cnpj( clienteEntradaDTO.getCnpj() );
        cliente.complemento( clienteEntradaDTO.getComplemento() );
        cliente.cpf( clienteEntradaDTO.getCpf() );
        cliente.dataNascimento( clienteEntradaDTO.getDataNascimento() );
        cliente.email( clienteEntradaDTO.getEmail() );
        cliente.id( clienteEntradaDTO.getId() );
        cliente.nome( clienteEntradaDTO.getNome() );
        cliente.numero( clienteEntradaDTO.getNumero() );
        cliente.numeroCNH( clienteEntradaDTO.getNumeroCNH() );
        cliente.numeroRegistroCNH( clienteEntradaDTO.getNumeroRegistroCNH() );
        cliente.observacao( clienteEntradaDTO.getObservacao() );
        cliente.razaoSocial( clienteEntradaDTO.getRazaoSocial() );
        cliente.rg( clienteEntradaDTO.getRg() );
        cliente.rua( clienteEntradaDTO.getRua() );
        cliente.senha( clienteEntradaDTO.getSenha() );
        cliente.telefone( clienteEntradaDTO.getTelefone() );
        cliente.validadeCNH( clienteEntradaDTO.getValidadeCNH() );

        return cliente.build();
    }
}
