package com.ae.user.authentication.entity.client.service;

import com.ae.user.authentication.model.ClientModel;

import java.util.List;

/**
 * Interface to make interaction with Repository, CRUD operation
 */
public interface ClientService {

    /**
     * @param client to save in data base
     * @return Message about transaction
     */
    String createClient(final ClientModel client);

    /**
     * @param client to find in data base
     * @return client found
     */
    ClientModel getClient(final ClientModel client);

    /**
     * @return List of clients registered
     */
    List<ClientModel> getClients();

    /**
     * @param client to uodate
     * @return updated client
     */
    ClientModel updateClient(final ClientModel client);

    /**
     * @param client to delete
     * @return deleted client
     */
    String deleteClient(final ClientModel client);

}
