package com.example.biblioteca.biblioteca.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data/*crea todos los get y set implicitamente*/
@NoArgsConstructor/*crea constructor vacio*/
public class Libro {

    private int id;
    private String isbn;
    private String nombre;
    private String editorial;
    private String genero;
    private int numeroPaginas;
    private BigDecimal precio;
    private LocalDate fechaEdicion;
    private Autor autor;

}