package com.javanauta.operadoracartaocredito.adapters.in.dto.response;

public record CartaoResponseDTO(String numero,
                                String dataExpiracao,
                                String cvv,
                                double limite) {}
