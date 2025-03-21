package com.javanauta.operadoracartao.infrastructure.repositories;

import com.javanauta.operadoracartao.infrastructure.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {

    boolean existsByEmail(String email);

    Optional<ClienteEntity> findByCpf(String cpf);

}