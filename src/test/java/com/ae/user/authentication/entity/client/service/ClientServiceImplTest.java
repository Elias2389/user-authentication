package com.ae.user.authentication.entity.client.service;

import com.ae.user.authentication.entity.client.repository.ClientRepository;
import com.ae.user.authentication.model.ClientModel;
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

    ClientModel clientModel;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        clientService = new ClientServiceImpl(repository);
        clientModel = new ClientModel(1L, "Name", "Last name", "emial", new Date());


    }

    @Test
    public void createClient() {
        ClientModel clientModelUpdate = new ClientModel(1L, "Name4", "Last name4", "emial", new Date());
        Mockito.when(repository.save(clientModelUpdate)).thenReturn(clientModelUpdate);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(clientModelUpdate));

        String clientServiceCreate = clientService.createClient(clientModelUpdate);
        Assertions.assertThat(clientServiceCreate).isEqualTo("done");
    }

    @Test
    public void whenIsValidId_ReturnClient() {
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(clientModel));
        ClientModel client = clientService.getClient(1L);
        Assertions.assertThat(client.getName()).isEqualTo("Name");
    }

    @Test
    public void whenIsValid_UpdateReturnClient() {
        ClientModel clientModelUpdate = new ClientModel(1L, "Name2", "Last name2", "emial", new Date());
        Mockito.when(repository.save(clientModelUpdate)).thenReturn(clientModelUpdate);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(clientModelUpdate));

        ClientModel clientServiceUpdate = clientService.updateClient(clientModelUpdate);
        Assertions.assertThat(clientServiceUpdate.getName()).isEqualTo("Name2");
    }


    public void deleteClient() {
    }
}