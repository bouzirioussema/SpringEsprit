package com.example.springesprit.services;

import com.example.springesprit.entity.Client;
import com.example.springesprit.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClient(Long id, Client client) {
        Optional<Client> existingClient = clientRepository.findById(id);
        if (existingClient.isPresent()) {
            client.setIdClient(id); // On garde l'ID
            return clientRepository.save(client);
        }
        return null; // Ou lancer une exception personnalisée
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
