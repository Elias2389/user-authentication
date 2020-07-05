package com.ae.user.authentication.entities.client.controller;

import com.ae.user.authentication.entities.client.service.ClientService;
import com.ae.user.authentication.entity.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private final ClientService service;

    @PostMapping("/client")
    public ResponseEntity<ClientEntity> createClient(final @RequestBody ClientEntity clientEntity) {
        ClientEntity client = service.createClient(clientEntity);
        return  ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<ClientEntity> getClient(final @PathVariable("clientId") Long clientId) {
        ClientEntity client = service.getClient(clientId);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/client")
    public ResponseEntity<List<ClientEntity>> getClients() {
        List<ClientEntity> clients = service.getClients();
        return ResponseEntity.ok(clients);
    }

    @PutMapping("/client")
    public ResponseEntity<ClientEntity> updateClient(final @RequestBody ClientEntity clientEntity) {
        ClientEntity model = service.updateClient(clientEntity);
        if (model != null) {
            return ResponseEntity.ok(model);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/client")
    public String deleteClient(final ClientEntity client) {
        return service.deleteClient(client);
    }
}
