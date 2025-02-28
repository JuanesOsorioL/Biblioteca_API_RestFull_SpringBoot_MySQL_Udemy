package com.example.biblioteca.biblioteca.dto;

import com.example.biblioteca.biblioteca.model.Autor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String telefono;

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nombre = autor.getNombre();
        this.apellido = autor.getApellido();
        this.telefono = autor.getTelefono();
    }
}
