package com.javanauta.operadoracartao.controller.dto.response;

public record CartaoResponseDTO(String numero,
                                String dataExpiracao,
                                String cvv,
                                double limite) {}
