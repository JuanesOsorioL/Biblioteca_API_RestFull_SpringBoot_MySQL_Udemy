package com.example.biblioteca.biblioteca.service;

import com.example.biblioteca.biblioteca.dto.AutorDTO;
import com.example.biblioteca.biblioteca.model.Autor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FabricaAutorService {

    public Autor crearAutor(AutorDTO autorDTO) {
        return new Autor(autorDTO);
    }

    public AutorDTO crearAutorDTO(Autor autor) {
        return new AutorDTO(autor);
    }

    public List<AutorDTO> crearAutoresDTO_mio(List<Autor> listaAutores) {
        List<AutorDTO> autoresDTO = new ArrayList<>();
        listaAutores.forEach(autor -> {
            autoresDTO.add(crearAutorDTO(autor));
        });
        return autoresDTO;
    }

    public List<AutorDTO> crearAutoresDTO_udemy(List<Autor> listaAutores) {
        List<AutorDTO> autoresDTO = new ArrayList<>();
        listaAutores.stream().forEach(autor -> {
            autoresDTO.add(crearAutorDTO(autor));
        });
        return autoresDTO;
    }

    public List<AutorDTO> crearAutoresDTO_chatgpt(List<Autor> listaAutores) {
        return listaAutores.stream()
                .map(this::crearAutorDTO)
                .collect(Collectors.toList());
    }


}
