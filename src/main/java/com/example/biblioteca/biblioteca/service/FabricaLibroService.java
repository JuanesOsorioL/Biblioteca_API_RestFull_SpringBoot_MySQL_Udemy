package com.example.biblioteca.biblioteca.service;

import com.example.biblioteca.biblioteca.dto.AutorDTO;
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

    public List<LibroDTO> listarLibros(List<Libro> ListaLibros) {
        List<LibroDTO> ListaLibroDTO = new ArrayList<>();
        ListaLibros.forEach(libro -> {ListaLibroDTO.add(crearLibroDTO(libro));});
                return ListaLibroDTO;
    }
}
