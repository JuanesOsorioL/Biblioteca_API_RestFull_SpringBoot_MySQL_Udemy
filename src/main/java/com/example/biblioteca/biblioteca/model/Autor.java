package com.example.biblioteca.biblioteca.model;

import com.example.biblioteca.biblioteca.dto.AutorDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data/*crea todos los get y set implicitamente*/
@NoArgsConstructor/*crea constructor vacio*/
@Entity/*utilizar el modelo como tabla en BD*/
@Table(name = "autores")/*cambiar nombre tabla en plural*/
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private String telefono;

    public Autor(AutorDTO autorDTO) {
        this.id = autorDTO.getId();
        this.nombre = autorDTO.getNombre();
        this.apellido = autorDTO.getApellido();
        this.telefono = autorDTO.getTelefono();
    }
}