package com.example.biblioteca.biblioteca.repository;

import com.example.biblioteca.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LibroRepository extends JpaRepository<Libro, Integer> {

}
