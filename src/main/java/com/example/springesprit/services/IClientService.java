package com.example.springesprit.services;

import com.example.springesprit.entity.Client;

import java.util.List;

public interface IClientService {

    Client addClient(Client client);
    Client getClientById(Long id);
    List<Client> getAllClients();
    Client updateClient(Long id, Client client);
    void deleteClient(Long id);
}
