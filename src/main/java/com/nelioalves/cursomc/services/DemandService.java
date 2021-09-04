package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Client;
import com.nelioalves.cursomc.domain.Demand;
import com.nelioalves.cursomc.repositories.DemandRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemandService {

    @Autowired
    private DemandRepository demandRepository;

    public Demand find(Integer id){
        Optional<Demand> dem = demandRepository.findById(id);
        return dem.orElseThrow(() -> new ObjectNotFoundException("Demand not found!" + "ID: " + id + " Type: " + Demand.class.getName()));
    }

}
