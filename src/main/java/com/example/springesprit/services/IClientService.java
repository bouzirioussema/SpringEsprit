package com.example.springesprit.services;

import com.example.springesprit.entity.Client;

import java.util.List;

public interface IClientService {

    Client saveClient(Client client);
    Client getClientById(Long id);
    List<Client> getAllClients();
    Client updateClient(Long id, Client client);
    void deleteClient(Long id);

    List<Client>  addClients (List<Client> clients);
}
