package com.ae.user.authentication.entity.client.service;

import com.ae.user.authentication.entity.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl {

    private ClientRepository repository;

    @Autowired
    public ClientServiceImpl(final ClientRepository repository) {
        this.repository = repository;
    }



}
