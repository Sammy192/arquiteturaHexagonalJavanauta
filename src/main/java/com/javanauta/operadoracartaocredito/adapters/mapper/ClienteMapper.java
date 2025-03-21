package com.javanauta.operadoracartaocredito.adapters.mapper;

import com.javanauta.operadoracartaocredito.adapters.in.dto.request.ClienteRequestDTO;
import com.javanauta.operadoracartaocredito.adapters.in.dto.response.ClienteResponseDTO;
import com.javanauta.operadoracartaocredito.adapters.out.entities.ClienteEntity;
import com.javanauta.operadoracartaocredito.application.domain.CartaoDomain;
import com.javanauta.operadoracartaocredito.application.domain.ClienteDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteEntity paraEntity(ClienteDomain clienteDomain);

    ClienteDomain paraDomain(ClienteEntity clienteEntity);

    @Mapping(target = "cartao", expression = "java(toCartaoDomain(cliente))")
    ClienteDomain toDomain(ClienteRequestDTO cliente);

    ClienteResponseDTO toResponse(ClienteDomain cliente);

    @Mapping(source = "dataVencimentoFatura", target = "dataVencimentoFatura")
    CartaoDomain toCartaoDomain(ClienteRequestDTO clienteRequestDTO);
}
