package com.example.personne.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.personne.models.Personne;
import com.example.personne.services.PersonneService;

@RestController
@RequestMapping(path = "v1")
public class PersonneController {
    
    @Autowired
    private PersonneService personneService;

    @PostMapping
    public ResponseEntity<Personne> addPersonne(@RequestBody Personne personne)
    {
        try {
            personneService.addPersonne(personne);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personne> findPersonneById(@PathVariable("id") String id)
    {
        try {
            Personne p = personneService.getPersonneById(id);
            return ResponseEntity.ok().body(p);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/allPersonne")
    public List<Personne> getAllPersonne()
    {
        try {
            return personneService.getAllPersonne();
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping
    public ResponseEntity<Personne> updatePersonne(@RequestBody Personne personne)
    {
        try {
            Personne p = personneService.updatePersonne(personne);

            return ResponseEntity.ok().body(p);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Personne> deletePersonne(@PathVariable("id") String id)
    {
        try {
            personneService.deletePersonne(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
