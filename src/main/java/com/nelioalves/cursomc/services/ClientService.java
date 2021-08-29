package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Category;
import com.nelioalves.cursomc.domain.Client;
import com.nelioalves.cursomc.repositories.CategoryRepository;
import com.nelioalves.cursomc.repositories.ClientRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client find(Integer id){
        Optional<Client> cli = clientRepository.findById(id);
        return cli.orElseThrow(() -> new ObjectNotFoundException("Client not found!" + "ID: " + id + " Type: " + Client.class.getName()));
    }
}
