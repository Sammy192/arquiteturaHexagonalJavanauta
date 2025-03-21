package com.javanauta.operadoracartaocredito.adapters.in.controller;

import com.javanauta.operadoracartaocredito.adapters.in.IClienteService;
import com.javanauta.operadoracartaocredito.adapters.in.dto.request.ClienteRequestDTO;
import com.javanauta.operadoracartaocredito.adapters.in.dto.response.ClienteResponseDTO;
import com.javanauta.operadoracartaocredito.adapters.mapper.ClienteMapper;
import com.javanauta.operadoracartaocredito.application.domain.ClienteDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final IClienteService clienteService;
    private final ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> solicitaCartao(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        mapper.toResponse(clienteService.solicitarCartao(mapper.toDomain(clienteRequestDTO)));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ClienteResponseDTO> buscaClientePorCpf(@RequestParam String cpf) {
        ClienteDomain cliente = clienteService.buscarPorCpf(cpf);
        return ResponseEntity.ok(mapper.toResponse(cliente));
    }
}
