package com.javanauta.operadoracartao.controller;


import com.javanauta.operadoracartao.business.services.ClienteService;
import com.javanauta.operadoracartao.controller.dto.request.ClienteRequestDTO;
import com.javanauta.operadoracartao.controller.dto.response.ClienteResponseDTO;
import com.javanauta.operadoracartao.controller.mappers.ClienteMapper;
import com.javanauta.operadoracartao.infrastructure.entities.ClienteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteServicePort;
    private final ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> solicitaCartao(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        mapper.toResponse(clienteServicePort.solicitarCartao(mapper.toEntity(clienteRequestDTO)));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ClienteResponseDTO> buscaClientePorCpf(@RequestParam String cpf) {
        ClienteEntity cliente = clienteServicePort.buscarPorCpf(cpf);
        return ResponseEntity.ok(mapper.toResponse(cliente));
    }
}
