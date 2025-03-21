package com.javanauta.operadoracartaocredito.adapters.in.dto.response;


public record ClienteResponseDTO(String nome,
                                 String email,
                                 Integer idade,
                                 String cpf,
                                 CartaoResponseDTO cartao){}



