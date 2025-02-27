package com.example.biblioteca.biblioteca.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data/*crea todos los get y set implicitamente*/
@NoArgsConstructor/*crea constructor vacio*/
public class Autor {

    private int id;
    private String nombre;
    private String apellido;
    private String telefono;

}