package com.example.biblioteca.biblioteca.service;

import com.example.biblioteca.biblioteca.dto.LibroDTO;
import com.example.biblioteca.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private FabricaLibroService fabricaLibroService;

    public LibroDTO save(LibroDTO libroDTO) {
        return fabricaLibroService.crearLibroDTO(libroRepository.save(fabricaLibroService.crearLibro(libroDTO)));
    }

    public List<LibroDTO> findAll() {
        return fabricaLibroService.listarLibrosDTO(libroRepository.findAll());
    }

    public Optional<LibroDTO> findById(Integer id) {
        return libroRepository.findById(id)
                .map(libro -> fabricaLibroService.crearLibroDTO(libro));
    }

    public Optional<LibroDTO> delete(Integer id) {
        return libroRepository.findById(id)
                .map(libro -> {
                    libroRepository.delete(libro);
                    return fabricaLibroService.crearLibroDTO(libro);
                });

    }

}
