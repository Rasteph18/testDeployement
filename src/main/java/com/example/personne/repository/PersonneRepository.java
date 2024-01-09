package com.example.personne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.personne.models.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {
    
}
