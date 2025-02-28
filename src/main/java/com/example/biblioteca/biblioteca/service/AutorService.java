package com.example.biblioteca.biblioteca.service;

import com.example.biblioteca.biblioteca.dto.AutorDTO;
import com.example.biblioteca.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private FabricaAutorService fabricaAutorService;
    @Autowired
    private AutorRepository autorRepository;

    public AutorDTO save(AutorDTO autorDTO) {
        return fabricaAutorService.crearAutorDTO(autorRepository.save(fabricaAutorService.crearAutor(autorDTO)));
    }

    public List<AutorDTO> findAll() {
        return fabricaAutorService.listarAutoresDTO(autorRepository.findAll());
    }

    /* Antes
        public AutorDTO findById(Integer id) {
            return fabricaAutorService.crearAutorDTO(autorRepository.findById(id).get()));
        }
    */

    public Optional<AutorDTO> findById(Integer id) {
        return autorRepository.findById(id)
                .map(autor -> fabricaAutorService.crearAutorDTO(autor));
    }
/*
    public void deleteByID(Integer id) {
        autorRepository.deleteById(id);
    }
*/
    public Optional<AutorDTO> deleteAutorByID(Integer id) {
        return autorRepository.findById(id)
                .map(autor -> {
                    autorRepository.deleteById(autor.getId());
                    return fabricaAutorService.crearAutorDTO(autor);
                });
    }
}
