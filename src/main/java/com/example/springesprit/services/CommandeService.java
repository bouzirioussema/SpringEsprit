package com.example.springesprit.services;

import com.example.springesprit.entity.Client;
import com.example.springesprit.entity.Commande;
import com.example.springesprit.entity.Menu;
import com.example.springesprit.repository.CommandeRepository;
import com.example.springesprit.repository.ClientRepository;
import com.example.springesprit.repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CommandeService implements ICommandeService {

    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final MenuRepository menuRepository;

    @Override
    public Commande saveCommande(Commande commande) {
        // Vérifier si le client existe
        Optional<Client> clientOpt = clientRepository.findById(commande.getClient().getIdClient());
        if (!clientOpt.isPresent()) {
            throw new RuntimeException("Client non trouvé");
        }

        // Vérifier si le menu existe
        Optional<Menu> menuOpt = menuRepository.findById(commande.getMenu().getIdMenu());
        if (!menuOpt.isPresent()) {
            throw new RuntimeException("Menu non trouvé");
        }

        // Sauvegarder la commande si tout est valide
        return commandeRepository.save(commande);
    }

    @Override
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande updateCommande(Long id, Commande commande) {
        if (commandeRepository.existsById(id)) {
            commande.setIdCommande(id); // S'assurer que l'ID est bien conservé
            return commandeRepository.save(commande);
        }
        return null;
    }

    @Override
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }

@Override
public void ajouterCommandeEtaffecterAClientEtMenu(Commande commande, String identifiant, String libelleMenu) {
    Client client = clientRepository.findByIdentifiant(identifiant);
    Menu menu = menuRepository.findByLibelle(libelleMenu);
    commande.setClient(client);
    commande.setMenu(menu);
    commande.setTotalCommande(menu.getPrixTotal());
    commandeRepository.save(commande);
}




@Override
public void affecterNoteACommande(Long idCommande, Long Note) {
    Commande commande = commandeRepository.findById(idCommande).orElse(null);
    if (commande != null) {
        commande.setNote(Note);
        commandeRepository.save(commande);
    }
}

}
