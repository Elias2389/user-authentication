package com.ae.user.authentication.entities.client.service;

import com.ae.user.authentication.entities.client.repository.ClientRepository;
import com.ae.user.authentication.entity.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    @Autowired
    private final ClientRepository repository;

    @Transactional
    @Override
    public ClientEntity createClient(final ClientEntity client) {
        if (getClient(client.getId()) != null) {
            return getClient(client.getId());
        }
        return repository.save(client);
    }

    @Transactional(readOnly = true)
    @Override
    public ClientEntity getClient(final Long clientId) {
        return repository.findById(clientId).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientEntity> getClients() {
        return repository.findAll();
    }

    @Transactional()
    @Override
    public ClientEntity updateClient(final ClientEntity client) {
        ClientEntity clientEntity = getClient(client.getId());
        if (clientEntity != null) {
            clientEntity.setEmail(client.getEmail());
            return clientEntity;
        }
        return null;
    }

    @Transactional()
    @Override
    public String deleteClient(final ClientEntity client) {
        if (getClient(client.getId()) != null) {
            repository.delete(client);
            return "done";
        }
        return "not done";
    }
}
