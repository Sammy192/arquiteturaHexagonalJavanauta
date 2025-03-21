package com.javanauta.operadoracartaocredito.adapters.in;

import com.javanauta.operadoracartaocredito.application.domain.ClienteDomain;

public interface IClienteService {

    ClienteDomain solicitarCartao(ClienteDomain cliente);
    ClienteDomain buscarPorCpf(String cpf);
}
