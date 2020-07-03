package com.ae.user.authentication.entity.client.repository;

import com.ae.user.authentication.model.ClientModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientModel, Long> {
}
