package com.ae.user.authentication.entities.client.service;

import com.ae.user.authentication.entity.ClientEntity;

import java.util.List;

/**
 * Interface to make interaction with Repository, CRUD operation
 */
public interface ClientService {

    /**
     * @param client to save in data base
     * @return Message about transaction
     */
    ClientEntity createClient(final ClientEntity client);

    /**
     * @param clientId to find in data base
     * @return client found
     */
    ClientEntity getClient(final Long clientId);

    /**
     * @return List of clients registered
     */
    List<ClientEntity> getClients();

    /**
     * @param client to uodate
     * @return updated client
     */
    ClientEntity updateClient(final ClientEntity client);

    /**
     * @param client to delete
     * @return deleted client
     */
    String deleteClient(final ClientEntity client);

}
