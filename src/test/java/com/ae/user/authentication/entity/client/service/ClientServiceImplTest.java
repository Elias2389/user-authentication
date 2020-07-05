package com.ae.user.authentication.entity.client.service;

import com.ae.user.authentication.entities.client.repository.ClientRepository;
import com.ae.user.authentication.entities.client.service.ClientService;
import com.ae.user.authentication.entities.client.service.ClientServiceImpl;
import com.ae.user.authentication.entity.ClientEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;


@SpringBootTest
public class ClientServiceImplTest {

    @Mock
    private ClientRepository repository;

    private ClientService clientService;

    ClientEntity clientEntity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        clientService = new ClientServiceImpl(repository);
        //clientEntity = new ClientEntity(1L, "Name", "Last name", "emial", new Date());


    }

    @Test
    public void createClient() {
        //ClientEntity clientEntityUpdate = new ClientEntity(1L, "Name4", "Last name4", "emial", new Date());
       // Mockito.when(repository.save(clientEntityUpdate)).thenReturn(clientEntityUpdate);
        //Mockito.when(repository.findById(1L)).thenReturn(Optional.of(clientEntityUpdate));

        //String clientServiceCreate = clientService.createClient(clientEntityUpdate);
        //Assertions.assertThat(clientServiceCreate).isEqualTo("done");
    }

    @Test
    public void whenIsValidId_ReturnClient() {
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(clientEntity));
        ClientEntity client = clientService.getClient(1L);
        Assertions.assertThat(client.getName()).isEqualTo("Name");
    }

    @Test
    public void whenIsValid_UpdateReturnClient() {
        //ClientEntity clientEntityUpdate = new ClientEntity(1L, "Name2", "Last name2", "emial", new Date());
        //Mockito.when(repository.save(clientEntityUpdate)).thenReturn(clientEntityUpdate);
        //Mockito.when(repository.findById(1L)).thenReturn(Optional.of(clientEntityUpdate));

        //ClientEntity clientServiceUpdate = clientService.updateClient(clientEntityUpdate);
        //Assertions.assertThat(clientServiceUpdate.getName()).isEqualTo("Name2");
    }


    public void deleteClient() {
    }
}