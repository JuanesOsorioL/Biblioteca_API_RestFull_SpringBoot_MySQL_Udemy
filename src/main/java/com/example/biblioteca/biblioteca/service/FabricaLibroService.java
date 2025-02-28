package com.example.biblioteca.biblioteca.service;

import com.example.biblioteca.biblioteca.dto.LibroDTO;
import com.example.biblioteca.biblioteca.model.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FabricaLibroService {

    public Libro crearLibro(LibroDTO libroDTO) {
        return new Libro(libroDTO);
    }

    public LibroDTO crearLibroDTO(Libro libro) {
        return new LibroDTO(libro);
    }

    public List<LibroDTO> listarLibrosDTO(List<Libro> listaLibros) {
        List<LibroDTO> listaLibroDTO = new ArrayList<>();
        listaLibros.forEach(libro -> listaLibroDTO.add(crearLibroDTO(libro)));
        return listaLibroDTO;
    }
}
