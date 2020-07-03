package com.ae.user.authentication.entity.client.service;

import com.ae.user.authentication.entity.client.repository.ClientRepository;
import com.ae.user.authentication.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Autowired
    public ClientServiceImpl(final ClientRepository repository) {
        this.repository = repository;
    }


    @Transactional
    @Override
    public String createClient(final ClientModel client) {
        repository.save(client);
        return "done";
    }

    @Transactional(readOnly = true)
    @Override
    public ClientModel getClient(final ClientModel client) {
        return repository.findById(client.getId()).get();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientModel> getClients() {
        return (List<ClientModel>) repository.findAll();
    }

    @Transactional()
    @Override
    public ClientModel updateClient(final ClientModel client) {
        if (validateClient(client)) {
            repository.save(client);
            return getClient(client);
        }
        return null;
    }

    @Transactional()
    @Override
    public String deleteClient(final ClientModel client) {
        if (validateClient(client)) {
            repository.delete(client);
            return "done";
        }
        return "not done";
    }

    private Boolean validateClient(final ClientModel client) {
        return getClient(client) != null;
    }
}
