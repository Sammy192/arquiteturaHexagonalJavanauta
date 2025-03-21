package com.javanauta.operadoracartaocredito.porters.out;

import com.javanauta.operadoracartaocredito.application.domain.ClienteDomain;

import java.util.Optional;

public interface IClienteRepository {

    ClienteDomain salvar(ClienteDomain clienteDomain);
    Boolean buscarUsuarioPorEmail(String email);
    Optional<ClienteDomain> buscarUsuarioPorCpf(String cpf);
}
