package com.ae.user.authentication.entity.client.controller;

import com.ae.user.authentication.entity.client.service.ClientService;
import com.ae.user.authentication.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class ClientController {

    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping("/client")
    String createClient(final @RequestBody ClientModel clientModel) {
        return service.createClient(clientModel);
    }

    @GetMapping("/client/{clientId}")
    public ClientModel getClient(final @PathVariable("clientId") Long clientId) {
        return service.getClient(clientId);
    }

    @GetMapping("/client")
    public List<ClientModel> getClients() {
        return service.getClients();
    }

    @PutMapping("/client")
    public ClientModel updateClient(final @RequestBody ClientModel clientModel) {
        ClientModel model = service.updateClient(clientModel);
        if ( model != null ) {
            return model;
        } else {
            return new ClientModel();
        }
    }

    @DeleteMapping("/client")
    public String deleteClient(final ClientModel client) {
        return service.deleteClient(client);
    }
}
