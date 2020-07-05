package com.ae.user.authentication.entities.client.controller;

import com.ae.user.authentication.entities.client.service.ClientService;
import com.ae.user.authentication.entity.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private final ClientService service;

    @PostMapping("/client")
    String createClient(final @RequestBody ClientEntity clientEntity) {
        return service.createClient(clientEntity);
    }

    @GetMapping("/client/{clientId}")
    public ClientEntity getClient(final @PathVariable("clientId") Long clientId) {
        return service.getClient(clientId);
    }

    @GetMapping("/client")
    public List<ClientEntity> getClients() {
        return service.getClients();
    }

    @PutMapping("/client")
    public ClientEntity updateClient(final @RequestBody ClientEntity clientEntity) {
        ClientEntity model = service.updateClient(clientEntity);
        if (model != null) {
            return model;
        } else {
            return null;
        }
    }

    @DeleteMapping("/client")
    public String deleteClient(final ClientEntity client) {
        return service.deleteClient(client);
    }
}
