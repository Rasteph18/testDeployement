package com.example.personne.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personne.models.Personne;
import com.example.personne.repository.PersonneRepository;

@Service
public class PersonneService {
    
    @Autowired
    private PersonneRepository personneRepository;

    public void addPersonne(Personne personne) throws Exception
    {
        personneRepository.save(personne);
    }

    public void deletePersonne(String idPersonne) throws Exception
    {
        personneRepository.deleteById(Integer.parseInt(idPersonne));
    }

    public Personne getPersonneById(String idPersonne) throws Exception
    {
        Personne p = personneRepository.findById(Integer.parseInt(idPersonne)).get();

        if(p != null)
        {
            return p;
        } else {
            throw new Exception("Aucunne personne ne correspond à cette id");
        }
    }

    public Personne updatePersonne(Personne personne) throws Exception
    {
        return personneRepository.save(personne);
    }

    public List<Personne> getAllPersonne() throws Exception
    {
        return personneRepository.findAll();
    }
}
