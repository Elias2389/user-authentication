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
        clientEntity = getClient();

        Mockito.when(repository.save(clientEntity)).thenReturn(clientEntity);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(clientEntity));
        Mockito.when(repository.findByUsername("username")).thenReturn(clientEntity);
    }

    private ClientEntity getClient() {
        return  ClientEntity.builder()
                .id(1L)
                .name("User 1")
                .lastName("Last Name 1")
                .email("email@email.com")
                .createAt(new Date())
                .username("username")
                .build();
    }

    @Test
    public void createClient() {
        ClientEntity clientServiceCreate = clientService.createClient(clientEntity);
        Assertions.assertThat(clientServiceCreate.getUsername()).isEqualTo("username");
    }

    @Test
    public void whenIsValidId_ReturnClient() {
        ClientEntity client = clientService.getClient(1L);
        Assertions.assertThat(client.getName()).isEqualTo("User 1");
    }

    @Test
    public void whenIsValid_UpdateReturnClient() {
        ClientEntity clientServiceUpdate = clientService.updateClient(clientEntity);
        Assertions.assertThat(clientServiceUpdate.getName()).isEqualTo("User 1");
    }

    @Test
    public void whenIsValid_UsernameReturnClient() {
        ClientEntity clientServiceUpdate = clientService.getClientByUsername(clientEntity.getUsername());
        Assertions.assertThat(clientServiceUpdate.getName()).isEqualTo("User 1");
    }
}