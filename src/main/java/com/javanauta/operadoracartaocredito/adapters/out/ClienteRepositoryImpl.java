package com.javanauta.operadoracartaocredito.adapters.out;

import com.javanauta.operadoracartaocredito.adapters.mapper.ClienteMapper;
import com.javanauta.operadoracartaocredito.adapters.out.entities.ClienteEntity;
import com.javanauta.operadoracartaocredito.adapters.out.repositories.ClienteJpaRepository;
import com.javanauta.operadoracartaocredito.application.domain.ClienteDomain;
import com.javanauta.operadoracartaocredito.porters.out.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements IClienteRepository {

    private final ClienteJpaRepository clienteJpaRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public ClienteDomain salvar(ClienteDomain clienteDomain) {
        ClienteEntity clienteEntity = clienteJpaRepository.save(clienteMapper.paraEntity(clienteDomain));
        return clienteMapper.paraDomain(clienteEntity);
    }

    @Override
    public Boolean buscarUsuarioPorEmail(String email) {
        return clienteJpaRepository.existsByEmail(email);
    }

    @Override
    public Optional<ClienteDomain> buscarUsuarioPorCpf(String cpf) {
        return clienteJpaRepository.findByCpf(cpf)
                .map(clienteMapper::paraDomain);
    }
}
