package com.ae.user.authentication.entities.user.repository;


import com.ae.user.authentication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByUsername(String username);
}
