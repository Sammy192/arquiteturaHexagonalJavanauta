package com.javanauta.operadoracartao.controller.mappers;


import com.javanauta.operadoracartao.controller.dto.request.ClienteRequestDTO;
import com.javanauta.operadoracartao.controller.dto.response.ClienteResponseDTO;
import com.javanauta.operadoracartao.infrastructure.entities.CartaoEntity;
import com.javanauta.operadoracartao.infrastructure.entities.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "cartao", expression = "java(toCartaoEntity(cliente))")
    ClienteEntity toEntity(ClienteRequestDTO cliente);

    ClienteResponseDTO toResponse(ClienteEntity cliente);

    @Mapping(source = "dataVencimentoFatura", target = "dataVencimentoFatura")
    CartaoEntity toCartaoEntity(ClienteRequestDTO clienteRequestDTO);

}
