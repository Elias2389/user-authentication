package com.ae.user.authentication.entities.user.repository;


import com.ae.user.authentication.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ClientEntity, Long> {

    public ClientEntity findByUsername(String username);
}
